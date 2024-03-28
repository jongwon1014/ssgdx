package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranMobileMmsItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 1)
    @JsonProperty("TMS_TYPE")
    private String TMS_TYPE; // 거래구분

    @IIrtFldMeta(size = 8)
    @JsonProperty("AUTH_DATE")
    private String AUTH_DATE; // 승인일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("AUTH_TIME")
    private String AUTH_TIME; // 승인시간

    @IIrtFldMeta(size = 2)
    @JsonProperty("CARD_TYPE")
    private String CARD_TYPE; // 카드종류

    @IIrtFldMeta(size = 4)
    @JsonProperty("CARD_SEQ_NO")
    private String CARD_SEQ_NO; // 카드일련번호

    @IIrtFldMeta(size = 2)
    @JsonProperty("AUTH_IN_CLSS")
    private String AUTH_IN_CLSS; // 카드입력구분

    @IIrtFldMeta(size = 20)
    @JsonProperty("AUTH_NO")
    private String AUTH_NO; // 승인번호

    @IIrtFldMeta(size = 11)
    @JsonProperty("PURE_SALE_AMT")
    private String PURE_SALE_AMT; // 교환금액

    @IIrtFldMeta(size = 1)
    @JsonProperty("PROC_CODE")
    private String PROC_CODE; // 서비스 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("CARD_AUTH_SBJ")
    private String CARD_AUTH_SBJ; // 카드 승인 주체

    @IIrtFldMeta(size = 8)
    @JsonProperty("ORG_AUTH_DATE")
    private String ORG_AUTH_DATE; // 원 매출일자

    @IIrtFldMeta(size = 4)
    @JsonProperty("ORG_AUTH_ST_CODE")
    private String ORG_AUTH_ST_CODE; // 원 매출 점코드

    @IIrtFldMeta(size = 6)
    @JsonProperty("ORG_CASHIER_NO")
    private String ORG_CASHIER_NO; // 원 캐셔번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("ORG_TM_NO")
    private String ORG_TM_NO; // 원 POS번호

    @IIrtFldMeta(size = 20)
    @JsonProperty("CARD_NO")
    private String CARD_NO; // 바코드번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("MMS_AUTH_NO")
    private String MMS_AUTH_NO; // 신세계MMS 인증번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("TM_GUBN")
    private String TM_GUBN; // 장비구분

    @IIrtFldMeta(size = 31)
    @JsonProperty("FILLER")
    private String FILLER; // 예비
}
