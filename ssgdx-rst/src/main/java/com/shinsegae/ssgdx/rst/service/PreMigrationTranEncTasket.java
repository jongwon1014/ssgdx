/**
 * @project : 신세계백화점차세대프로젝트
 * @packageName : com.shinsegae.ssgdx.rst.service
 * @fileName : PreMigrationTranEncTasket.java
 * @author : q93m9k
 * @date : 2024.03.13
 * @description :
 * 
 * COPYRIGHT ©2024 SHINSEGAE. ALL RIGHTS RESERVED.
 * 
 * <pre>
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024.03.13       q93m9k              최초 생성
 * ===========================================================
 * </pre>
 */
package com.shinsegae.ssgdx.rst.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.shinsegae.ssgdx.core.context.SystemInfo;
import com.shinsegae.ssgdx.core.context.TranContext;
import com.shinsegae.ssgdx.core.context.TranContextConstants;
import com.shinsegae.ssgdx.core.context.TranContextHolder;
import com.shinsegae.ssgdx.core.idgenerator.IdGeneratorFactory;
import com.shinsegae.ssgdx.core.security.authentication.model.UserVO;
import com.shinsegae.ssgdx.ldi.model.comirt.EncHeader;
import com.shinsegae.ssgdx.ldi.util.Aes128CipherUtil;
import com.shinsegae.ssgdx.ldi.util.IEnumComIrt;
import com.shinsegae.ssgdx.ldi.util.IrtParseUtil;
import com.shinsegae.ssgdx.rst.model.comtr.ComHeader;
import com.shinsegae.ssgdx.rst.model.oldtr.TranHeaderO;
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
 * 90일치 TTRLOG 사전 이행 평문 거래를 암호화 거래로 업데이트
 * </pre>
 * 
 * @author : q93m9k
 * @version : 2024.03.13
 * @see :
 */
@Slf4j
@Getter
@Setter
@RequiredArgsConstructor
@Scope("prototype")
@Service
public class PreMigrationTranEncTasket implements Runnable {

    @Qualifier("mdsDbSqlSessionFactory")
    private final SqlSessionFactory mdsDbSqlSessionFactory;

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

            log.info("구 전문 암호화 저정 start....");

            Aes128CipherUtil aes128CipherUtil = null;
            byte[] recvEncHdData = null;
            byte[] recvComHdData = null;
            byte[] recvTranData = null;
            byte[] recvTranEncData = null;

            int[] offSet = { 0 };
            byte[] oldTranDataBytes = ttrlogO.getTranData().getBytes();
            byte[] oldTranDataEncBytes = null;
            String oldTranDataEncStr = "";

            TranHeaderO tranHeaderO = new TranHeaderO();
            EncHeader encHeader = new EncHeader();
            ComHeader comHeader = new ComHeader();

            PreMigQueryProc queryProc = new PreMigQueryProc();

            try{
                // TranHeader Bytes --> Object 변경
                ret = ParseHelper.tranMapToObj(oldTranDataBytes, offSet, tranHeaderO, 0, 0, false, false);

                if(ret == 0){
                    // 통신헤더 설정
                    // 메시지길이
                    // 메시지경로
                    comHeader.setMsgPath("PS");
                    // 메시지타입 01: 트란, 02: 저널, 03: IRT
                    comHeader.setMsgType("03");
                    // 메시지종류 Default : 00
                    comHeader.setMsgKind("00");
                    // 영업일자
                    comHeader.setSaleDate(IrtParseUtil.getRpadFillSpaceStringForTgFld(comHeader, "SaleDate",
                            tranHeaderO.getSaleDate()));
                    // 점코드
                    comHeader.setStoreNo(IrtParseUtil.getRpadFillSpaceStringForTgFld(comHeader, "StoreNo",
                            tranHeaderO.getStoreNo()));
                    // POS번호
                    comHeader.setPosNo(
                            IrtParseUtil.getRpadFillSpaceStringForTgFld(comHeader, "PosNo", tranHeaderO.getPosNo()));
                    // 거래번호
                    comHeader.setTranNo(
                            IrtParseUtil.getRpadFillSpaceStringForTgFld(comHeader, "TranNo", tranHeaderO.getTranNo()));
                    LocalDateTime now = LocalDateTime.now();
                    // 시스템날짜
                    comHeader.setSendDate(now.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
                    // 시스템시간
                    comHeader.setSendTime(now.format(DateTimeFormatter.ofPattern("HHmmss")));
                    // 新점포코드
                    comHeader.setExtStoreNo(IrtParseUtil.getRpadFillSpaceStringForTgFld(comHeader, "ExtStoreNo", ""));
                    // 교육모드
                    comHeader.setTrainMode(IrtParseUtil.getRpadFillSpaceStringForTgFld(comHeader, "TrainMode", ""));
                    // 신/구전문구분
                    comHeader
                            .setVersionFlag(IrtParseUtil.getRpadFillSpaceStringForTgFld(comHeader, "VersionFlag", "A"));
                    // 사용자 정보
                    comHeader.setUserInfo(IrtParseUtil.getRpadFillSpaceStringForTgFld(comHeader, "UserInfo", ""));
                    // 응답코드
                    comHeader.setReplyCode("0000");

                    recvComHdData = new byte[IEnumComIrt.DEF_DMS_COM_HEADER_LEN];

                    offSet[0] = 0;
                    ret = IrtParseUtil.irtMapToBytes(recvComHdData, offSet, comHeader, socketRecvCharset);
                }

                if(ret == 0){
                    recvTranData = IrtParseUtil.byteArraysConcat(recvComHdData, oldTranDataBytes);
                    if(recvTranData != null){
                        int nMSGVLI = recvTranData.length;
                        String sMSGVLI = IrtParseUtil.getLpadFillZeroStringForTgFld(encHeader, "MSGVLI", nMSGVLI);

                        // 암호화 헤더 설정
                        encHeader.setENCTYPE("B");
                        encHeader.setPOSNO(comHeader.getPosNo());
                        encHeader.setTRANNO(comHeader.getTranNo());
                        encHeader.setMSGVLI(sMSGVLI);

                        aes128CipherUtil = new Aes128CipherUtil(socketRecvCharset, encHeader.getPOSNO().getBytes(),
                                encHeader.getTRANNO().getBytes(), encHeader.getMSGVLI().getBytes());

                        // 암호화 거래 트란
                        recvTranEncData = aes128CipherUtil.encryptAes(recvTranData);

                        if(recvTranEncData != null){
                            encHeader.setTOTLEN(IrtParseUtil.getLpadFillZeroStringForTgFld(encHeader, "TOTLEN",
                                    IEnumComIrt.DEF_ENC_HEADER_LEN + recvTranEncData.length));
                            recvEncHdData = new byte[IEnumComIrt.DEF_ENC_HEADER_LEN];

                            offSet[0] = 0;
                            ret = IrtParseUtil.irtMapToBytes(recvEncHdData, offSet, encHeader, socketRecvCharset);

                            if(ret == 0){
                                oldTranDataEncBytes = IrtParseUtil.byteArraysConcat(recvEncHdData, recvTranEncData);

                                ttrlogO.setTranDataEnc(new String());
                                ttrlogO.setTranProcFg("1");

                                // DEBUG_LOG
                                log.info("암호화 거래 트란 : >>>{}<<<", new String(oldTranDataEncBytes));

                                try{
                                    ret = queryProc.updatePreMigTranEncTTRLOG_O(ssMds, ttrlogO);

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
                            }
                        }else
                            ret = -1;
                    }else
                        ret = -1;
                }
            }catch(Exception e){
                ret = -1;
                log.error("처리중 오류 발생!!");
                log.error(e.toString());
            }

            if(ret != 0)
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
