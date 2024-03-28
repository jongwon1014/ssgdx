/**
 * @project : 신세계백화점차세대프로젝트
 * @packageName : com.shinsegae.ssgdx.rst.model
 * @fileName : PreMigrationTranService.java
 * @author : q93m9k
 * @date : 2024.01.16
 * @description :
 * 
 * COPYRIGHT ©2024 SHINSEGAE. ALL RIGHTS RESERVED.
 * 
 * <pre>
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024.01.16       q93m9k              최초 생성
 * ===========================================================
 * </pre>
 */
package com.shinsegae.ssgdx.rst.service;

import com.shinsegae.ssgdx.core.context.SystemInfo;
import com.shinsegae.ssgdx.core.context.TranContext;
import com.shinsegae.ssgdx.core.context.TranContextConstants;
import com.shinsegae.ssgdx.core.context.TranContextHolder;
import com.shinsegae.ssgdx.core.idgenerator.IdGeneratorFactory;
import com.shinsegae.ssgdx.core.security.SecurityConstants.CubeOneItems;
import com.shinsegae.ssgdx.core.security.authentication.model.UserVO;
import com.shinsegae.ssgdx.core.security.crypto.CryptoManagerFactory;
import com.shinsegae.ssgdx.ldi.model.comirt.EncHeader;
import com.shinsegae.ssgdx.ldi.util.Aes128CipherUtil;
import com.shinsegae.ssgdx.ldi.util.IEnumComIrt;
import com.shinsegae.ssgdx.ldi.util.JsonUtil;
import com.shinsegae.ssgdx.ldi.util.SCSHttpClient;
import com.shinsegae.ssgdx.rst.config.properties.RstUrlProperties;
import com.shinsegae.ssgdx.rst.model.oldtr.TtrlogO;
import com.shinsegae.ssgdx.rst.util.ParseHelper;
import com.shinsegae.ssgdx.rst.util.PreMigQueryProc;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * 90일치 TTRLOG 사전 이행 배치
 * </pre>
 * 
 * @author : q93m9k
 * @version : 2024.01.16
 * @see :
 */
@Slf4j
@Getter
@Setter
@RequiredArgsConstructor
@Scope("prototype")
@Service
public class PreMigrationTranTasket implements Runnable {

    private final RstUrlProperties rstUrlProperties;

    private final SCSHttpClient httpClient;

    private final CryptoManagerFactory cryptoManagerFactory; // 암복호화

    @Qualifier("mdsDbSqlSessionFactory")
    private final SqlSessionFactory mdsDbSqlSessionFactory;

    @Qualifier("slcDbSqlSessionFactory")
    private final SqlSessionFactory slcDbSqlSessionFactory;

    /**
     * System 정보
     */
    private final SystemInfo systemInfo;

    /**
     * Trace ID를 채번하기 위한 IdGeneratorFactory
     */
    private final IdGeneratorFactory idGeneratorFactory;

    @Value("${ssgdx-opdms.client.socketRecvCharset: EUC-KR}")
    String socketRecvCharset;

    @Value("${ssgdx-opdms.client.socketSendCharset: EUC-KR}")
    String socketSendCharset;

    @Value("${ssgdx-opdms.client.httpRecvCharset: UTF-8}")
    String httpRecvCharset;

    @Value("${ssgdx-opdms.client.httpSendCharset: UTF-8}")
    String httpSendCharset;

    @Value("${ssgdx-opdms.client.connectTimeout: 3000}")
    int connectTimeout;

    @Value("${ssgdx-opdms.client.serviceTimeout: 10000}")
    int serviceTimeout;

    private TtrlogO ttrlogO;

    public void init(TtrlogO ttrlogO){
        this.ttrlogO = ttrlogO;
    }

    @Override
    public void run(){
        // TODO Auto-generated method stub
        try{
            business();
        }catch(Exception e){
            log.error(e.toString());
        }finally{

        }

    }

    public void business(){
        // TODO Auto-generated method stub
        int ret = -1;
        String guid = "";

        SqlSession ssMds = null;
        SqlSession ssSlc = null;

        try{
            /*****************************************************************/
            // Trace ID 채번
            guid = idGeneratorFactory.generateNextId("traceId");
            // TranContext 설정
            TranContext tranContext = TranContext.of(systemInfo);
            tranContext.setChannelCode(TranContextConstants.ChannelCode.NONE);
            tranContext.setGuid(guid);

            MDC.put("guid", guid);

            UserVO userVo = new UserVO();
            userVo.setUsername(IEnumComIrt.UPDR_ID);
            tranContext.setUserVO(userVo);

            TranContextHolder.setTranContext(tranContext);
            /*****************************************************************/

            // -----------------------------------------------------------------------------
            ssMds = mdsDbSqlSessionFactory.openSession();
            ssSlc = slcDbSqlSessionFactory.openSession();

            log.info("preMig-business start --> th guid :[{}]", guid);

            // [0] 암호화 헤더 분리 및 복호화
            Aes128CipherUtil aes128CipherUtil = null;
            byte[] recvEncData = null;
            byte[] recvTranData = null;
            int[] offSet = { 0 };
            byte[] oldTranDataBytes = ttrlogO.getTranData().getBytes();
            EncHeader encHeaderReq = new EncHeader();
            PreMigQueryProc queryProc = new PreMigQueryProc();

            try{
                // Enc Header Bytes --> Object 변경
                ret = ParseHelper.tranMapToObj(oldTranDataBytes, offSet, encHeaderReq, 0, 0, false, false);

                if(ret == 0){
                    int totLen = Integer.parseInt(encHeaderReq.getTOTLEN());
                    if(totLen > 0 && totLen > IEnumComIrt.DEF_ENC_HEADER_LEN){
                        int recvEncLen = totLen - IEnumComIrt.DEF_ENC_HEADER_LEN;

                        recvEncData = new byte[recvEncLen];
                        System.arraycopy(oldTranDataBytes, offSet[0], recvEncData, 0, recvEncLen);
                        offSet[0] += recvEncLen;

                        aes128CipherUtil = new Aes128CipherUtil(socketRecvCharset, encHeaderReq.getPOSNO().getBytes(),
                                encHeaderReq.getTRANNO().getBytes(), encHeaderReq.getMSGVLI().getBytes());

                        // 복호화 거래 트란
                        recvTranData = aes128CipherUtil.decryptAes(recvEncData);

                        // DEBUG_LOG
                        log.info("복호화 거래 트란 : >>>{}<<<", new String(recvTranData));
                        ret = 0;
                    }else
                        ret = -1;
                }

                PreMigDecomposeTranProc decomposeTranProc = null;
                if(ret == 0){
                    // [1] 구 전문 파싱 및 신 전문으로 변환
                    decomposeTranProc = new PreMigDecomposeTranProc(idGeneratorFactory, ssMds, recvTranData);
                    if(decomposeTranProc.tranProc() == 0){
                        ssMds.commit();
                        ret = 0;
                    }else{
                        ssMds.rollback();
                        ret = -1;
                        log.error("preMig-business -- 구 전문 파싱 및 신 전문으로 변환 실패!! -- ");
                    }
                }

                // [2] 신 전문 저장
                if(ret == 0){
                    // DEBUG_LOG
                    if(decomposeTranProc.getJsonTran() != null){
                        Object dlogJObj = JsonUtil.getMapper().readValue(decomposeTranProc.getJsonTran(), Object.class);
                        String dlogJStr = JsonUtil.getMapper().writerWithDefaultPrettyPrinter()
                                .writeValueAsString(dlogJObj);
                        log.info("Convert FixToJson : \n{}\n", dlogJStr);

                        // 암호화 변환
                        String tranDataEnc = "";
                        try{
                            tranDataEnc = cryptoManagerFactory.encrypt(CubeOneItems.TRANDATA,
                                    decomposeTranProc.getJsonTran());
                            ret = 0;
                        }catch(Exception e){
                            log.error("암호화 에러 발생 : " + e.toString());
                            ret = -1;
                        }

                        // tranDataEnc = decomposeTranProc.getJsonTran();
                        // insert/update SC_SALS_TRAN_G$ (SC_매출_TRAN_전문)
                        // update TTRLOG_O
                        if(ret == 0 && tranDataEnc != null){
                            ttrlogO.setTranDataEnc(tranDataEnc);

                            try{
                                ret = queryProc.mergePreMigSC_SALS_TRAN_G(ssSlc, ttrlogO);

                                // 트랜잭션 commit
                                if(ret == 0)
                                    ssSlc.commit();
                                else
                                    ssSlc.rollback();
                            }catch(Exception e){
                                ssSlc.rollback();
                                ret = -1;
                                log.error(e.toString());
                            }
                        }else{
                            log.error("암호화 변환한 데이터가 없습니다!!");
                            ret = -1;
                        }
                    }
                }else
                    ret = -1;
            }catch(Exception e){
                ret = -1;
                log.error("처리중 오류 발생!!");
                log.error(e.toString());
            }

            if(ret == 0)
                ttrlogO.setTranProcFg("1");
            else
                ttrlogO.setTranProcFg("9");

            try{
                queryProc.updatePreMigTTRLOG_O(ssMds, ttrlogO);
                ret = 0;

                // 트랜잭션 commit
                if(ret == 0)
                    ssMds.commit();
                else
                    ssMds.rollback();
            }catch(Exception e){
                ssMds.rollback();
                ret = -1;
                log.error(e.toString());
            }
        }catch(Exception e){
            ret = -1;
            log.error(e.toString());
            log.error("preMig-business -- Exception");
        }finally{
            // DB Session 반환
            if(ssMds != null){
                ssMds.rollback();
                ssMds.close();
            }
            if(ssSlc != null){
                ssMds.rollback();
                ssSlc.close();
            }

            // 응답 전문 전송이 정상 처리 되지 않은 모든 에러 발생시 응답 처리 (단 전송 타임아웃이 아닐 때)
            try{
                log.info("preMig-business end --> th guid :[{}]", guid);

                /*****************************************************************/
                MDC.clear();
                // TranContext 초기화
                TranContextHolder.clearTranContext();
                /*****************************************************************/

            }catch(Exception e){
                log.error(e.toString());
                log.error("preMig-business -- finally Exception");
            }
        }
    }
}
