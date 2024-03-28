/**
 * @project : 신세계백화점차세대프로젝트
 * @packageName : com.shinsegae.ssgdx.rst.controller
 * @fileName : RecvTranController.java
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
package com.shinsegae.ssgdx.rst.controller;

import java.net.Socket;
import java.util.List;

import com.shinsegae.ssgdx.core.context.SystemInfo;
import com.shinsegae.ssgdx.core.context.TranContextConstants.ProfileCode;
import com.shinsegae.ssgdx.ldi.controller.ISCSController;
import com.shinsegae.ssgdx.ldi.util.SCSDaemon;
import com.shinsegae.ssgdx.rst.service.PreMigrationTranService;
import com.shinsegae.ssgdx.rst.service.RecvTranPfTestService;
import com.shinsegae.ssgdx.rst.service.RecvTranService;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

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
@Controller
public class RecvTranController implements ISCSController , Runnable {

    private SCSDaemon scsDaemon;

    private Socket client;

    // 생성자 주입 빈 선언
    private final ObjectProvider<RecvTranService> recvTranServiceProvider;

    // 생성자 주입 빈 선언 (병행운영 PerfecTwin 테스트)
    private final ObjectProvider<RecvTranPfTestService> recvTranPfTestServiceProvider;

    // 생성자 주입 빈 선언 (사전이행)
    private final ObjectProvider<PreMigrationTranService> preMigrationTranServiceProvider;

    private final SystemInfo systemInfo;

    private final ApplicationArguments applicationArguments;

    /**
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run(){
        // TODO Auto-generated method stub
        if(systemInfo.getProfile() == ProfileCode.PERFECT_TWIN){
            // 병행운영 PerfecTwin 테스트
            RecvTranPfTestService recvTranPfTestService = recvTranPfTestServiceProvider.getObject();
            recvTranPfTestService.business(scsDaemon, client);
        }else{
            // 명령행 인수 체크하여 사전 이행일 경우 인수를 전달하여 실행
            List<String> optionValues = applicationArguments.getOptionValues("runOp");
            // 사전 이행 (90일)
            if(optionValues != null && "preMig".equals(optionValues.get(0))){
                PreMigrationTranService preMigrationTranService = preMigrationTranServiceProvider.getObject();
                preMigrationTranService.business(scsDaemon, client);
            }
            // 실시간 매출TRAN 전송
            else{
                RecvTranService recvTranService = recvTranServiceProvider.getObject();
                recvTranService.business(scsDaemon, client);
            }
        }
    }

    /**
     * @param scsDaemon
     * @param client
     * @see com.shinsegae.ssgdx.ldi.controller.ISCSController#init(com.shinsegae.ssgdx.ldi.util.SCSDaemon,
     * java.net.Socket)
     */
    @Override
    public void init(SCSDaemon scsDaemon, Socket client){
        // TODO Auto-generated method stub
        this.scsDaemon = scsDaemon;
        this.client = client;
    }

}
