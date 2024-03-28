package com.shinsegae.ssgdx;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;

import devonboot.common.DevOnApplication;
import devonboot.common.annotation.DevOnBootApplication;

import com.shinsegae.ssgdx.ldi.config.SCSSchedulingConfig;
import com.shinsegae.ssgdx.ldi.util.SCSDaemon;
import com.shinsegae.ssgdx.rst.controller.RecvTranController;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.core.task.TaskExecutor;

import lombok.RequiredArgsConstructor;

/**
 * @project : 신세계백화점차세대프로젝트
 * @packageName :
 * @fileName : SsgdxRstApplication.java
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

/**
 * <pre>
 * 
 * </pre>
 * 
 * @author : q93m9k
 * @version : 2024.01.16
 * @see :
 */
@RequiredArgsConstructor
@ConfigurationPropertiesScan("com.shinsegae.ssgdx.rst.config.properties")
@DevOnBootApplication
public class SsgdxRstApplication extends SCSDaemon implements CommandLineRunner {

    @Value("${ssgdx-opdms.server.port: 8060}")
    int port;

    @Value("${ssgdx-opdms.server.maxThreadCount: 1}")
    int maxThreadCount;

    @Value("${ssgdx-opdms.rst.skipIpLst:}")
    ArrayList<String> skipIpLstInfo;

    // 생성자 주입 빈 선언
    private final ObjectProvider<RecvTranController> recvTranControllerProvider;

    @Qualifier("scsSchedulingConfig")
    private final SCSSchedulingConfig scsSchedulingConfig;

    @Qualifier("scsThreadPoolTaskExecutor")
    private final TaskExecutor scsThreadPoolTaskExecutor;

    private final ApplicationArguments applicationArguments;

    public static void main(String[] args){
        DevOnApplication.run(SsgdxRstApplication.class, args);
    }

    /**
     * 소켓 서버 실행
     * @param args
     * @throws Exception
     * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
     */
    @Override
    public void run(String... args) throws Exception{
        // TODO Auto-generated method stub
        for(String skipIp : skipIpLstInfo){
            SCSDaemon.skipIpLst.add(skipIp);
        }
        if(SCSDaemon.skipIpLst != null && SCSDaemon.skipIpLst.size() > 0)
            SCSDaemon.conSkipFlg = true;

        // 명령행 인수 체크하여 사전 이행일 경우 인수를 전달하여 실행
        List<String> optionValues = applicationArguments.getOptionValues("runOp");
        // 사전 이행 (90일) 배치 실행
        if(optionValues != null && "preMig".equals(optionValues.get(0))){
            RecvTranController recvTranController = recvTranControllerProvider.getObject();
            Thread th = new Thread(recvTranController);
            th.start();
            th.join();
        }
        // 소켓 서버 데몬 실행
        else{
            serverRun(port, maxThreadCount);
        }
        System.exit(0);
    }

    /**
     * @param socketDaemon
     * @param client
     * @see com.shinsegae.ssgdx.ldi.util.SCSDaemon#business(com.shinsegae.ssgdx.ldi.util.SCSDaemon,
     * java.net.Socket)
     */
    @Override
    public void business(SCSDaemon socketDaemon, Socket client){
        // TODO Auto-generated method stub
        RecvTranController recvTranController = recvTranControllerProvider.getObject();
        recvTranController.init(socketDaemon, client);
        scsThreadPoolTaskExecutor.execute(recvTranController);
    }

    /**
     * <pre>
     * 종료 전 scsIdleConnectionMonitor 스케쥴러 중단
     * </pre>
     *
     */
    @PreDestroy
    public void destory(){
        scsSchedulingConfig.getThreadPoolTaskScheduler().destroy();
    }
}
