/**
 * @project : 신세계백화점차세대프로젝트
 * @packageName : com.shinsegae.ssgdx.rst.service
 * @fileName : RecvTranPfTestService.java
 * @author : q93m9k
 * @date : 2024.02.02
 * @description :
 * 
 * COPYRIGHT ©2024 SHINSEGAE. ALL RIGHTS RESERVED.
 * 
 * <pre>
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024.02.02       q93m9k              최초 생성
 * ===========================================================
 * </pre>
 */
package com.shinsegae.ssgdx.rst.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import devonframe.dataaccess.CommonDao;

import com.shinsegae.ssgdx.core.context.SystemInfo;
import com.shinsegae.ssgdx.core.context.TranContext;
import com.shinsegae.ssgdx.core.context.TranContextConstants;
import com.shinsegae.ssgdx.core.context.TranContextHolder;
import com.shinsegae.ssgdx.core.idgenerator.IdGeneratorFactory;
import com.shinsegae.ssgdx.core.security.authentication.model.UserVO;
import com.shinsegae.ssgdx.ldi.model.comirt.EncHeader;
import com.shinsegae.ssgdx.ldi.service.ISCSService;
import com.shinsegae.ssgdx.ldi.util.Aes128CipherUtil;
import com.shinsegae.ssgdx.ldi.util.IEnumComIrt;
import com.shinsegae.ssgdx.ldi.util.IrtParseUtil;
import com.shinsegae.ssgdx.ldi.util.JsonUtil;
import com.shinsegae.ssgdx.ldi.util.SCSDaemon;
import com.shinsegae.ssgdx.ldi.util.SCSHttpClient;
import com.shinsegae.ssgdx.ldi.util.SocketUtil;
import com.shinsegae.ssgdx.rst.config.properties.RstUrlProperties;
import com.shinsegae.ssgdx.rst.model.comtr.ComHeader;
import com.shinsegae.ssgdx.rst.util.ParseHelper;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * 
 * </pre>
 * 
 * @author : q93m9k
 * @version : 2024.02.02
 * @see :
 */
@Slf4j
@Getter
@Setter
@RequiredArgsConstructor
@Scope("prototype")
@Service
public class RecvTranPfTestService implements ISCSService {

    private final CommonDao commonDao;

    private final RstUrlProperties rstUrlProperties;

    private final SocketUtil socketUtil;

    private final SCSHttpClient httpClient;

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

    /**
     * @param scsDaemon
     * @param client
     * @see com.shinsegae.ssgdx.ldi.service.ISCSService#business(com.shinsegae.ssgdx.ldi.util.SCSDaemon,
     * java.net.Socket)
     */
    @Override
    public void business(SCSDaemon scsDaemon, Socket client){
        // TODO Auto-generated method stub
        int ret = -1;
        long startTime = 0;
        int remainTimeOut = 0;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        int[] offSet = { 0 };

        ComHeader comHeaderReq = new ComHeader();

        try{
            /*****************************************************************/
            // Trace ID 채번
            String guid = idGeneratorFactory.generateNextId("traceId");
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

            byte[] recvComHeader = new byte[IEnumComIrt.DEF_COM_HEADER_LEN];
            byte[] recvTranData = null;

            Aes128CipherUtil aes128CipherUtil = null;
            EncHeader encHeader = new EncHeader();
            byte[] recvEncHeader = new byte[IEnumComIrt.DEF_ENC_HEADER_LEN];
            byte[] recvEncData = null;
            byte[] recvEncHeaderAndTranData = null;

            bis = new BufferedInputStream(client.getInputStream());
            bos = new BufferedOutputStream(client.getOutputStream());
            startTime = System.currentTimeMillis();

            remainTimeOut = socketUtil.getRemainTime(startTime, serviceTimeout);

            if(remainTimeOut > 0){
                // [1] Com Header 수신
                if(socketUtil.tcp_recv_b(bis, client, recvComHeader, IEnumComIrt.DEF_COM_HEADER_LEN,
                        remainTimeOut) >= 0){
                    ret = 0;
                    remainTimeOut = socketUtil.getRemainTime(startTime, serviceTimeout);
                }else{
                    ret = -1;
                    log.error("RecvTranPfTestService -- Com Header 수신 Error!!");
                }

                // [2] Com Header Bytes --> Object 변경
                if(ret == 0 && remainTimeOut > 0
                        && (IrtParseUtil.irtMapToObj(recvComHeader, offSet, comHeaderReq, socketRecvCharset) == 0)){
                    ret = 0;
                    remainTimeOut = socketUtil.getRemainTime(startTime, serviceTimeout);
                }else
                    ret = -1;

                // [3] Com Header->MsgLength 만큼 수신
                int recvTranLen = 0;
                byte[] recvComHdTranData = null;
                if(ret == 0 && remainTimeOut > 0){
                    int totLen = Integer.parseInt(comHeaderReq.getMsgLength().trim());
                    if(totLen > 0 && totLen > IEnumComIrt.DEF_COM_HEADER_LEN){
                        recvTranLen = totLen - IEnumComIrt.DEF_COM_HEADER_LEN;

                        recvTranData = new byte[recvTranLen];

                        if((ret = socketUtil.tcp_recv_b(bis, client, recvTranData, recvTranLen, remainTimeOut)) >= 0){
                            recvComHdTranData = IrtParseUtil.byteArraysConcat(recvComHeader, recvTranData);

                            ret = 0;
                            remainTimeOut = socketUtil.getRemainTime(startTime, serviceTimeout);
                        }else
                            ret = -1;
                    }else
                        ret = -1;
                }else
                    ret = -1;

                // [5] 구 전문 파싱 및 신 전문으로 변환
                DecomposeTranProc decomposeTranProc = null;
                if(ret == 0 && remainTimeOut > 0){
                    // 거래 전문 암호화
                    ParseHelper.makeEncHdFromComHd(comHeaderReq, encHeader);
                    String sMSGVLI = ParseHelper.getLpadFillZeroStringForNewTran(encHeader, "MSGVLI", recvTranLen);
                    encHeader.setMSGVLI(sMSGVLI);

                    aes128CipherUtil = new Aes128CipherUtil(socketRecvCharset, encHeader.getPOSNO().getBytes(),
                            encHeader.getTRANNO().getBytes(), encHeader.getMSGVLI().getBytes());

                    recvEncData = aes128CipherUtil.encryptAes(recvTranData);

                    int totLen = recvEncData.length + IEnumComIrt.DEF_ENC_HEADER_LEN;
                    String totLenLpad = IrtParseUtil.getLpadFillZeroStringForTgFld(encHeader, "TOTLEN", totLen);

                    // 전체전문길이 설정
                    encHeader.setTOTLEN(totLenLpad);

                    offSet[0] = 0;
                    IrtParseUtil.irtMapToObj(recvEncHeader, offSet, encHeader, socketRecvCharset);
                    recvEncHeaderAndTranData = ParseHelper.byteArraysConcat(recvEncHeader, recvEncData);

                    decomposeTranProc = new DecomposeTranProc(idGeneratorFactory, commonDao, recvComHdTranData,
                            recvEncHeaderAndTranData);

                    if(decomposeTranProc.tranProc() == 0){
                        ParseHelper.copySrcComHdToTgComHd(decomposeTranProc.getCompTranData().getCOMM_HEADER(),
                                comHeaderReq);
                        remainTimeOut = socketUtil.getRemainTime(startTime, serviceTimeout);
                    }else
                        ret = -1;
                }else
                    ret = -1;

                // [6] 신 전문 API 전송
                ComHeader comHeaderRes = null;
                if(ret == 0 && remainTimeOut > 0){
                    Map<String, String> responseData = new HashMap<String, String>();
                    String severUrl = "", salsClcTranUrl = "";
                    severUrl = rstUrlProperties.getUrl().get("sever-url");
                    salsClcTranUrl = rstUrlProperties.getUrl().get("salsClcTran-url");

                    if(httpClient.sendPostData(severUrl + salsClcTranUrl, decomposeTranProc.getJsonTran(), responseData,
                            httpRecvCharset, httpSendCharset, connectTimeout, serviceTimeout) == 0){
                        Map<String, Map<String, String>> responseMap = JsonUtil.getMapper().readValue(
                                responseData.get("response"), new TypeReference<Map<String, Map<String, String>>>() {});

                        comHeaderRes = JsonUtil.getMapper().convertValue(responseMap.get("COMM_HEADER"),
                                ComHeader.class);
                        if(comHeaderRes == null)
                            ret = -1;
                        else
                            remainTimeOut = socketUtil.getRemainTime(startTime, serviceTimeout);
                    }else
                        ret = -1;
                }else
                    ret = -1;

                // [7] 응답 전문 전송
                if(ret == 0 && remainTimeOut > 0){
                    // [7-2] 응답 데이터 bytes 변환
                    offSet[0] = 0;
                    byte[] comHeaderBytes = new byte[IEnumComIrt.DEF_COM_HEADER_LEN];
                    // 통신 헤더 길이 설정
                    comHeaderRes.setMsgLength(IrtParseUtil.getLpadFillZeroStringForTgFld(comHeaderRes, "MsgLength",
                            IEnumComIrt.DEF_COM_HEADER_LEN));

                    IrtParseUtil.irtMapToBytes(comHeaderBytes, offSet, comHeaderRes, socketSendCharset);

                    // [7-6] 응답 전문 전송
                    if(socketUtil.tcp_send_b(bos, client, comHeaderBytes, IEnumComIrt.DEF_COM_HEADER_LEN,
                            remainTimeOut) == 0){
                        log.debug("send Reply Ok...");
                    }else{
                        log.error("send Reply Error...");
                    }
                }else
                    ret = -1;
            }
        }catch(Exception e){
            ret = -1;
            log.error(e.toString());
            log.error("business -- Exception");
        }finally{
            // 응답 전문 전송이 정상 처리 되지 않은 모든 에러 발생시 응답 처리 (단 전송 타임아웃이 아닐 때)
            try{
                /*****************************************************************/
                MDC.clear();
                // TranContext 초기화
                TranContextHolder.clearTranContext();
                /*****************************************************************/

                if(remainTimeOut > 0 && ret != 0){
                    sendReplyUnhandledError(scsDaemon, client, startTime, remainTimeOut, bis, bos, comHeaderReq);
                }
            }catch(Exception e){
                log.error(e.toString());
                log.error("business -- finally Exception");
            }

            // 클라이언트 연결 총료 처리
            try{
                scsDaemon.setCliCnt();
                if(client != null){
                    client.close();
                }
                log.info("business -- CliCnt Count: [{}]", scsDaemon.getCliCnt());
            }catch(Exception e){
                log.error(e.toString());
                log.error("business -- 클라이언트 연결 총료 처리 Exception");
            }
        }
    }

    /**
     * <pre>
     * 응답 전문 전송이 정상 처리 되지 않은 모든 에러 발생시 응답 처리 (단 전송 타임아웃이 아닐 때)
     * </pre>
     *
     * @param dmsComHeaderReq
     * @param bos
     * @param client
     * @param remainTimeOut
     */
    public void sendReplyUnhandledError(SCSDaemon scsDaemon, Socket client, long startTime, int remainTimeOut,
            BufferedInputStream bis, BufferedOutputStream bos, ComHeader comHeaderReq){
        int ret = -1;
        int[] offSet = { 0 };
        try{
            // [1] 통신 Header 설정
            ComHeader comHeaderRes = new ComHeader();
            if(comHeaderReq != null)
                ParseHelper.copySrcComHdToTgComHd(comHeaderReq, comHeaderRes);

            // 통신 헤더 길이 설정
            comHeaderRes.setMsgLength(IrtParseUtil.getLpadFillZeroStringForTgFld(comHeaderRes, "MsgLength",
                    IEnumComIrt.DEF_COM_HEADER_LEN));
            // 응답코드 설정 : 210 (APPL 예외 에러)
            comHeaderRes.setReplyCode(IrtParseUtil.getLpadFillZeroStringForTgFld(comHeaderRes, "ReplyCode",
                    IEnumComIrt.EnmIrtTranResCode.C210.getResCode()));

            offSet[0] = 0;
            byte[] comHeaderBytes = new byte[IEnumComIrt.DEF_COM_HEADER_LEN];
            IrtParseUtil.irtMapToBytes(comHeaderBytes, offSet, comHeaderRes, socketSendCharset);

            if(socketUtil.tcp_send_b(bos, client, comHeaderBytes, IEnumComIrt.DEF_COM_HEADER_LEN, remainTimeOut) == 0){
                ret = 0;
            }
        }catch(Exception e){
            log.error(e.toString());
        }finally{
            if(ret == 0)
                log.debug("sendReplyUnhandledError Ok...");
            else
                log.error("sendReplyUnhandledError Error...");
        }
    }
}
