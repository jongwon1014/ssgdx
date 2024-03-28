/**
 * @project : 신세계백화점차세대프로젝트
 * @packageName : com.shinsegae.ssgdx.rst.model
 * @fileName : RecvTranService.java
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
 * @version : 2024.01.16
 * @see :
 */
@Slf4j
@Getter
@Setter
@RequiredArgsConstructor
@Scope("prototype")
@Service
public class RecvTranService implements ISCSService {

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
        String guid = "";
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

            log.info("rst-business client session id :[{}]", guid);

            // client 세션 유지로 변경
            boolean bSession = true;
            while(bSession){
                int ret = -1;
                BufferedInputStream bis = null;
                BufferedOutputStream bos = null;
                int[] offSet = { 0 };
                EncHeader encHeaderReq = new EncHeader();
                Aes128CipherUtil aes128CipherUtil = null;
                ComHeader comHeaderReq = new ComHeader();

                byte[] recvEncHeader = new byte[IEnumComIrt.DEF_ENC_HEADER_LEN];
                byte[] recvEncData = null;
                byte[] recvTranData = null;
                byte[] recvEncHeaderAndTranData = null;

                bis = new BufferedInputStream(client.getInputStream());
                bos = new BufferedOutputStream(client.getOutputStream());

                // [1] Enc Header 수신
                if(socketUtil.tcp_recv_b(bis, client, recvEncHeader, IEnumComIrt.DEF_ENC_HEADER_LEN) >= 0){
                    ret = 0;
                }else{
                    bSession = false;
                    ret = -2;
                    log.info("RecvTranService -- Enc Header 수신 Error!!-- session id:[{}]", guid);
                }

                // [2] Enc Header Bytes --> Object 변경
                if(ret == 0 && (IrtParseUtil.irtMapToObj(recvEncHeader, offSet, encHeaderReq, socketRecvCharset) == 0)){
                    ret = 0;
                }else
                    ret = -1;

                // [3] Enc Header->MSG_LEN 만큼 수신
                if(ret == 0){
                    int totLen = Integer.parseInt(encHeaderReq.getTOTLEN());
                    if(totLen > 0 && totLen > IEnumComIrt.DEF_ENC_HEADER_LEN){
                        int recvEncLen = totLen - IEnumComIrt.DEF_ENC_HEADER_LEN;

                        recvEncData = new byte[recvEncLen];

                        if((ret = socketUtil.tcp_recv_b(bis, client, recvEncData, recvEncLen)) >= 0){
                            ret = 0;
                        }else{
                            bSession = false;
                            ret = -2;
                            log.error("RecvTranService -- MSG_LEN 만큼 수신 Error!! -- session id:[{}]", guid);
                        }
                    }else
                        ret = -1;
                }else
                    ret = -1;

                // [4] 암호화 전문 복호화
                if(ret == 0){
                    aes128CipherUtil = new Aes128CipherUtil(socketRecvCharset, encHeaderReq.getPOSNO().getBytes(),
                            encHeaderReq.getTRANNO().getBytes(), encHeaderReq.getMSGVLI().getBytes());

                    recvTranData = aes128CipherUtil.decryptAes(recvEncData);
                    recvEncHeaderAndTranData = ParseHelper.byteArraysConcat(recvEncHeader, recvEncData);

                    // DEBUG_LOG
                    log.info("Pos Recv Tran : >>>{}<<<", new String(recvTranData));
                }else
                    ret = -1;

                // [5] 구 전문 파싱 및 신 전문으로 변환
                DecomposeTranProc decomposeTranProc = null;
                if(ret == 0){
                    decomposeTranProc = new DecomposeTranProc(idGeneratorFactory, commonDao, recvTranData,
                            recvEncHeaderAndTranData);

                    if(decomposeTranProc.tranProc() == 0){
                        ParseHelper.copySrcComHdToTgComHd(decomposeTranProc.getCompTranData().getCOMM_HEADER(),
                                comHeaderReq);
                    }else
                        ret = -1;
                }else
                    ret = -1;

                // [6] 신 전문 API 전송
                ComHeader comHeaderRes = null;
                if(ret == 0){
                    Map<String, String> responseData = new HashMap<String, String>();
                    String severUrl = "", salsClcTranUrl = "";
                    severUrl = rstUrlProperties.getUrl().get("sever-url");
                    salsClcTranUrl = rstUrlProperties.getUrl().get("salsClcTran-url");

                    log.info(salsClcTranUrl);

                    // DEBUG_LOG
                    if(decomposeTranProc.getJsonTran() != null){
                        Object dlogJObj = JsonUtil.getMapper().readValue(decomposeTranProc.getJsonTran(), Object.class);
                        String dlogJStr = JsonUtil.getMapper().writerWithDefaultPrettyPrinter()
                                .writeValueAsString(dlogJObj);
                        log.info("Convert FixToJson : \n{}\n", dlogJStr);
                    }

                    if(httpClient.sendPostData(severUrl + salsClcTranUrl, decomposeTranProc.getJsonTran(), responseData,
                            httpRecvCharset, httpSendCharset, connectTimeout, serviceTimeout) == 0){
                        Map<String, Map<String, String>> responseMap = JsonUtil.getMapper().readValue(
                                responseData.get("response"), new TypeReference<Map<String, Map<String, String>>>() {});

                        comHeaderRes = JsonUtil.getMapper().convertValue(responseMap.get("COMM_HEADER"),
                                ComHeader.class);
                        if(comHeaderRes == null){
                            ret = -1;
                            log.error("RecvTranService -- API 응답 없음 Error!! -- session id:[{}]", guid);
                        }else{
                            // DEBUG_LOG
                            String dlogJStr = JsonUtil.getMapper().writerWithDefaultPrettyPrinter()
                                    .writeValueAsString(comHeaderRes);
                            log.info("recv 차세대 응답 : \n{}\n", dlogJStr);
                        }
                    }else{
                        ret = -1;
                        log.error("RecvTranService -- API sendPostData Error!! -- session id:[{}]", guid);
                    }
                }else
                    ret = -1;

                // [7] 응답 전문 전송
                if(ret == 0){
                    // 응답 받은 통신헤더 길이 강제로 000067로 등록
                    comHeaderRes
                            .setMsgLength(IrtParseUtil.getLpadFillZeroStringForTgFld(comHeaderRes, "MsgLength", 67));

                    // [7-1] 통신 Header bytes 변환
                    String comHdMsgLenLpad = IrtParseUtil.getLpadFillZeroStringForTgFld(comHeaderRes, "MsgLength",
                            IEnumComIrt.DEF_COM_HEADER_LEN);

                    // [7-2] 응답 데이터 bytes 변환
                    offSet[0] = 0;
                    byte[] comHeaderBytes = new byte[IEnumComIrt.DEF_COM_HEADER_LEN];
                    IrtParseUtil.irtMapToBytes(comHeaderBytes, offSet, comHeaderRes, socketSendCharset);

                    String resComHd = new String(comHeaderBytes);
                    log.debug("rst-business -- res comHd : [{}]", resComHd);

                    // [7-3] 응답 데이터 암호화
                    aes128CipherUtil = new Aes128CipherUtil(socketSendCharset, encHeaderReq.getPOSNO().getBytes(),
                            encHeaderReq.getTRANNO().getBytes(), comHdMsgLenLpad.getBytes());

                    byte[] sendEncComHdBodyBytes = aes128CipherUtil.encryptAes(comHeaderBytes);

                    // [7-4] 암호화 헤더 설정
                    EncHeader encHeaderRes = new EncHeader();
                    IrtParseUtil.copySrcEncHdToTgEncHd(encHeaderReq, encHeaderRes);

                    int totLen = sendEncComHdBodyBytes.length + IEnumComIrt.DEF_ENC_HEADER_LEN;
                    String totLenLpad = IrtParseUtil.getLpadFillZeroStringForTgFld(encHeaderRes, "TOTLEN", totLen);

                    // 전체전문길이 설정
                    encHeaderRes.setTOTLEN(totLenLpad);
                    // 원문길이 설정
                    encHeaderRes.setMSGVLI(comHdMsgLenLpad);

                    // [7-5] 암호화 Header bytes 변환
                    offSet[0] = 0;
                    byte[] encHeaderBytes = new byte[IEnumComIrt.DEF_ENC_HEADER_LEN];
                    IrtParseUtil.irtMapToBytes(encHeaderBytes, offSet, encHeaderRes, socketSendCharset);

                    String resEncHd = new String(encHeaderBytes);
                    log.debug("rst-business -- res encHd : [{}]", resEncHd);

                    String resEncBody = new String(sendEncComHdBodyBytes);
                    log.debug("rst-business -- res encBody : [{}]", resEncBody);
                    // [7-6] 응답 전문 전송
                    byte[] snedResBytes = null;
                    if((snedResBytes = IrtParseUtil.byteArraysConcat(encHeaderBytes, sendEncComHdBodyBytes)) != null){
                        ret = 0;

                        String resSendData = new String(snedResBytes);
                        log.debug("rst-business -- res sendData : [{}]", resSendData);

                        if(socketUtil.tcp_send_b(bos, client, snedResBytes, totLen) == 0){
                            log.debug("send Reply Ok...");
                        }else{
                            ret = -2;
                            log.error("send Reply Error...");
                        }
                    }
                }else
                    ret = -1;

                // socket 에러일때 종료
                if(ret == -2){
                    bSession = false;
                    log.info("rst-business -- 소켓 에러로 연결 세션 종료!! -- session id:[{}]", guid);
                }
            } // while
        }catch(Exception e){
            log.error(e.toString());
            log.error("rst-business -- Exception -- session id:[{}]", guid);
        }finally{
            // 응답 전문 전송이 정상 처리 되지 않은 모든 에러 발생시 응답 처리 (단 전송 타임아웃이 아닐 때)
            try{
                /*****************************************************************/
                MDC.clear();
                // TranContext 초기화
                TranContextHolder.clearTranContext();
                /*****************************************************************/
            }catch(Exception e){
                log.error(e.toString());
                log.error("rst-business -- finally Exception -- session id:[{}]", guid);
            }

            // 클라이언트 연결 총료 처리
            try{
                // 소켓 세션 리스트에서 현재 소켓 정보 제거
                scsDaemon.removeClientSocketList(client);

                scsDaemon.setCliCnt();
                if(client != null){
                    client.close();
                }
                log.info("rst-business -- Connected Client Count: [{}] -- session id:[{}]", scsDaemon.getCliCnt(),
                        guid);
            }catch(Exception e){
                log.error(e.toString());
                log.error("rst-business -- 클라이언트 연결 총료 처리 Exception -- session id:[{}]", guid);
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
    public void sendReplyUnhandledError(SCSDaemon scsDaemon, Socket client, BufferedInputStream bis,
            BufferedOutputStream bos, EncHeader encHeaderReq, ComHeader comHeaderReq){
        int ret = -1;
        int[] offSet = { 0 };
        try{
            // [1] 통신 Header 설정
            ComHeader comHeaderRes = new ComHeader();
            if(comHeaderReq != null)
                ParseHelper.copySrcComHdToTgComHd(comHeaderReq, comHeaderRes);
            // 응답코드 설정 : 210 (APPL 예외 에러)
            comHeaderRes.setReplyCode(IrtParseUtil.getLpadFillZeroStringForTgFld(comHeaderRes, "MsgLength",
                    IEnumComIrt.EnmIrtTranResCode.C210.getResCode()));

            // [2] 통신 Header bytes 변환
            String comHdMsgLenLpad = IrtParseUtil.getLpadFillZeroStringForTgFld(comHeaderRes, "MsgLength",
                    IEnumComIrt.DEF_COM_HEADER_LEN);

            offSet[0] = 0;
            byte[] comHeaderBytes = new byte[IEnumComIrt.DEF_COM_HEADER_LEN];
            IrtParseUtil.irtMapToBytes(comHeaderBytes, offSet, comHeaderRes, socketSendCharset);

            // [3] 응답 데이터 암호화
            Aes128CipherUtil aes128CipherUtil = new Aes128CipherUtil(socketSendCharset,
                    encHeaderReq.getPOSNO().getBytes(), encHeaderReq.getTRANNO().getBytes(),
                    comHdMsgLenLpad.getBytes());

            byte[] sendEncComHdBodyBytes = aes128CipherUtil.encryptAes(comHeaderBytes);

            // [4] 암호화 헤더 설정
            EncHeader encHeaderRes = new EncHeader();
            IrtParseUtil.copySrcEncHdToTgEncHd(encHeaderReq, encHeaderRes);

            int totLen = sendEncComHdBodyBytes.length + IEnumComIrt.DEF_ENC_HEADER_LEN;
            String totLenLpad = IrtParseUtil.getLpadFillZeroStringForTgFld(encHeaderRes, "TOTLEN", totLen);

            // 전체전문길이 설정
            encHeaderRes.setTOTLEN(totLenLpad);
            // 원문길이 설정
            encHeaderRes.setMSGVLI(comHdMsgLenLpad);

            // [5] 암호화 Header bytes 변환
            offSet[0] = 0;
            byte[] encHeaderBytes = new byte[IEnumComIrt.DEF_ENC_HEADER_LEN];
            IrtParseUtil.irtMapToBytes(encHeaderBytes, offSet, encHeaderRes, socketSendCharset);

            // [6] 응답 전문 전송
            byte[] snedResBytes = null;
            if((snedResBytes = IrtParseUtil.byteArraysConcat(encHeaderBytes, sendEncComHdBodyBytes)) != null){
                if(socketUtil.tcp_send_b(bos, client, snedResBytes, totLen) == 0){
                    ret = 0;
                }
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
