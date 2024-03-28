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

import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import devonframe.dataaccess.CommonDao;

import com.shinsegae.ssgdx.core.context.SystemInfo;
import com.shinsegae.ssgdx.core.context.TranContext;
import com.shinsegae.ssgdx.core.context.TranContextConstants;
import com.shinsegae.ssgdx.core.context.TranContextHolder;
import com.shinsegae.ssgdx.core.idgenerator.IdGeneratorFactory;
import com.shinsegae.ssgdx.core.security.authentication.model.UserVO;
import com.shinsegae.ssgdx.ldi.service.ISCSService;
import com.shinsegae.ssgdx.ldi.util.IEnumComIrt;
import com.shinsegae.ssgdx.ldi.util.IrtParseUtil;
import com.shinsegae.ssgdx.ldi.util.SCSDaemon;
import com.shinsegae.ssgdx.rst.model.oldtr.TtrlogO;
import com.shinsegae.ssgdx.rst.util.QueryProc;

import org.slf4j.MDC;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
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
public class PreMigrationTranService implements ISCSService {

    private final CommonDao commonDao;

    /**
     * System 정보
     */
    private final SystemInfo systemInfo;

    /**
     * Trace ID를 채번하기 위한 IdGeneratorFactory
     */
    private final IdGeneratorFactory idGeneratorFactory;

    // 생성자 주입 빈 선언 (90일 사전 이행 구 -> 신 전문 변환)
    private final ObjectProvider<PreMigrationTranTasket> preMigrationTranTasketProvider;

    // 생성자 주입 빈 선언 (90일 사전 이행 구전문 평문 -> 암호화 저장)
    private final ObjectProvider<PreMigrationTranEncTasket> preMigrationTranEncTasketProvider;

    private final ApplicationArguments applicationArguments;

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

            // -------------------------------------------------------
            // 쓰레드 풀 생성
            int maxPoolSize = 100;
            int awaitTerminationSeconds = 10;

            ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
            taskExecutor.setCorePoolSize(maxPoolSize);
            taskExecutor.setMaxPoolSize(maxPoolSize);
            taskExecutor.setQueueCapacity(awaitTerminationSeconds);

            // ThreadPool 종료시 대기 여부 설정
            taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
            // ThreadPool 종료시 대기를 허용했을 경우 이곳에서 설정된 시간이 지날 때까지 종료를 대기한다.
            taskExecutor.setAwaitTerminationSeconds(awaitTerminationSeconds);

            // core thread에대한 타임아웃 여부
            taskExecutor.setAllowCoreThreadTimeOut(false);
            // 코어 쓰레드 타임아웃을 허용했을 경우 이곳에서 설정된 시간이 지날 때까지 코어 쓰레드 풀의 쓰레드가 사용되지 않을
            // 경우 해당
            // 쓰레드는 종료
            // 된다
            taskExecutor.setKeepAliveSeconds(60);
            taskExecutor.initialize();

            // 명령행 인수 체크하여 사전 이행일 경우 인수를 전달하여 실행
            Set<String> optionNames = applicationArguments.getOptionNames();

            if(optionNames == null || optionNames.size() == 0){
                log.error("PreMigrationTranService -- 명령행 인수가 설정 되지 않았습니다. 종료합니다!!");
                return;
            }

            String startSaleDate = "", endSaleDate = "";
            // 시작일
            List<String> optionValues = applicationArguments.getOptionValues("sYmd");
            if(optionValues != null){
                startSaleDate = optionValues.get(0);
            }
            // 종료일
            optionValues = applicationArguments.getOptionValues("eYmd");
            if(optionValues != null){
                endSaleDate = optionValues.get(0);
            }
            if((startSaleDate == null || startSaleDate.trim().length() == 0)
                    && (endSaleDate == null || endSaleDate.trim().length() == 0)){
                log.error("PreMigrationTranService -- args --> startSaleDate:{}, endSaleDate:{}", startSaleDate,
                        endSaleDate);
                log.error("PreMigrationTranService -- 명령행 인수가 설정이 잘못 되었습니다. 종료합니다!!");
                return;
            }

            if(startSaleDate == null || startSaleDate.trim().length() == 0)
                startSaleDate = endSaleDate;
            else if(endSaleDate == null || endSaleDate.trim().length() == 0)
                endSaleDate = startSaleDate;

            if(IrtParseUtil.convStrToInt(startSaleDate) > IrtParseUtil.convStrToInt(endSaleDate)){
                log.error("PreMigrationTranService -- 시작일은 종료일보다 작아야 합니다. 종료합니다!!");
                return;
            }

            // 복호화 전문 암호화 전문 Update 체크
            boolean bUpTranEnc = false;
            optionValues = applicationArguments.getOptionValues("upTranEnc");
            if(optionValues != null){
                bUpTranEnc = true;
            }

            log.info("PreMigrationTranService -- start");

            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("tranProcFg", "0"); // 사전이행 기본은 조회는 '0', 성공 '1', 실패는
                                             // '9'
                                             // '9'
            paramMap.put("startSaleDate", startSaleDate);
            paramMap.put("endSaleDate", endSaleDate);

            QueryProc queryProc = new QueryProc(commonDao);

            // [1] 전체 대상 건수 조회
            int tranTotCount = queryProc.selectTtrlogOTranDataCount(paramMap);
            log.info("전체 대상 건수 조회 : [{}]", tranTotCount);

            int tranIdx = 0;
            if(tranTotCount > 0){
                while(tranIdx < tranTotCount){
                    List<TtrlogO> ttrlogOLst = queryProc.selectTtrlogOTranData(paramMap);
                    log.info("대상 건수 조회 : [{}]", tranTotCount);

                    if(ttrlogOLst != null){
                        for(int i = 0; i < ttrlogOLst.size(); i++){
                            // for(int i = 0; i < 1; i++){
                            // ThreadPool이 가득차면 잠시 대기한다.
                            while(taskExecutor.getQueueSize() == maxPoolSize
                                    || taskExecutor.getActiveCount() == maxPoolSize){
                                // TimeUnit.MILLISECONDS.sleep(10);
                                TimeUnit.MILLISECONDS.sleep(1000);
                                log.debug("wait busy!!");
                            }

                            // 90일 사전 이행 구전문 평문 -> 암호화 저장
                            if(bUpTranEnc){
                                PreMigrationTranEncTasket preMigrationTranEncTasket = preMigrationTranEncTasketProvider
                                        .getObject();
                                preMigrationTranEncTasket.init(ttrlogOLst.get(i));
                                taskExecutor.execute(preMigrationTranEncTasket);
                            }
                            // 90일 사전 이행 구 -> 신 전문 변환
                            else{
                                PreMigrationTranTasket preMigrationTranTasket = preMigrationTranTasketProvider
                                        .getObject();
                                preMigrationTranTasket.init(ttrlogOLst.get(i));
                                taskExecutor.execute(preMigrationTranTasket);
                            }

                            tranIdx++;

                            log.info("작업 진행 인덱스 : [{}]", tranIdx);

                            // DEBUG TEST
                            // break;
                        }

                        // 작업 종료시 까지 대기 (최대 5분)
                        int nTotWait = 0;
                        while(true){
                            if(taskExecutor.getQueueSize() > 0 || taskExecutor.getActiveCount() > 0){
                                TimeUnit.SECONDS.sleep(1);
                                log.debug("wait tot job finish!!");
                            }else
                                break;

                            nTotWait++;

                            if(nTotWait > (60 * 5))
                                break;
                        }
                    }else{
                        log.info("조회 중 처리할 대상이 없습니다");
                        break;
                    }
                }
            }else{
                log.info("전체 건수 조회 처리할 대상이 없습니다");
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
                log.info("PreMigrationTranService -- end");
            }catch(Exception e){
                log.error(e.toString());
                log.error("business -- finally Exception");
            }
        }
    }
}
