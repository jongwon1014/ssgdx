/**
 * @project : 신세계백화점차세대프로젝트
 * @packageName : com.shinsegae.ssgdx.rst.model.oldtr
 * @fileName : TtrlogO.java
 * @author : q93m9k
 * @date : 2024.02.26
 * @description :
 * 
 * COPYRIGHT ©2024 SHINSEGAE. ALL RIGHTS RESERVED.
 * 
 * <pre>
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024.02.26       q93m9k              최초 생성
 * ===========================================================
 * </pre>
 */
package com.shinsegae.ssgdx.rst.model.oldtr;

import lombok.Getter;
import lombok.Setter;

/**
 * <pre>
 * 
 * </pre>
 * 
 * @author : q93m9k
 * @version : 2024.02.26
 * @see :
 */
@Getter
@Setter
public class TtrlogO {

    private String saleDate; // 영업일자

    private String storeCode; // 점포코드

    private String posNo; // POS번호

    private String tranNo; // 거래번호

    private long seqNo; // 작업순서

    private String sysDate; // 시스템일자

    private String sysTime; // 시스템시간

    private String retFlag; // 반품구분

    private String entDate; // 입력일자

    private String entTime; // 입력시간

    private String tranEncYn; // TRAN암호화여부

    private String tranData; // TRAN암호화여부

    private String tranDataEnc; // 거래데이터암호화

    private String tranProcFg; // 거래처리플래그
}
