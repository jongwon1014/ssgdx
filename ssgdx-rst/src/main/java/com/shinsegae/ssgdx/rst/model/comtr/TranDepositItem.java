package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranDepositItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 2)
    @JsonProperty("TranType")
    private String TranType; // 구분

    @IIrtFldMeta(size = 8)
    @JsonProperty("SlipNo")
    private String SlipNo; // 전표번호

    @IIrtFldMeta(size = 9)
    @JsonProperty("TotalAmount")
    private String TotalAmount; // 총매출

    @IIrtFldMeta(size = 8)
    @JsonProperty("Discount")
    private String Discount; // 에누리

    @IIrtFldMeta(size = 8)
    @JsonProperty("Deposit")
    private String Deposit; // 계약금

    @IIrtFldMeta(size = 8)
    @JsonProperty("Balance")
    private String Balance; // 잔액

    @IIrtFldMeta(size = 10)
    @JsonProperty("EmpNo")
    private String EmpNo; // 사원번호
}
