package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranCashBillItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 1)
    @JsonProperty("CustKind")
    private String CustKind; // 거래자구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("InputType")
    private String InputType; // 입력구분

    @IIrtFldMeta(size = 20)
    @JsonProperty("PersonInfo")
    private String PersonInfo; // 신분확인구분

    @IIrtFldMeta(size = 9)
    @JsonProperty("Amount")
    private String Amount; // 공급가액

    @IIrtFldMeta(size = 9)
    @JsonProperty("Tax")
    private String Tax; // 부가세

    @IIrtFldMeta(size = 9)
    @JsonProperty("Service")
    private String Service; // 봉사료

    @IIrtFldMeta(size = 9)
    @JsonProperty("TotalAmount")
    private String TotalAmount; // 총액

    @IIrtFldMeta(size = 9)
    @JsonProperty("ApprovalNo")
    private String ApprovalNo; // 승인번호

    @IIrtFldMeta(size = 9)
    @JsonProperty("OrgApprovalNo")
    private String OrgApprovalNo; // 원승인번호

    @IIrtFldMeta(size = 2)
    @JsonProperty("ApprovalFlag")
    private String ApprovalFlag; // 승인주체
}
