package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranCashTerUseSaleItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 3)
    @JsonProperty("ApplicationUnit")
    private String ApplicationUnit; // 신청회계단위

    @IIrtFldMeta(size = 6)
    @JsonProperty("ApplicationDate")
    private String ApplicationDate; // 신청년월

    @IIrtFldMeta(size = 5)
    @JsonProperty("ApplicationSeq")
    private String ApplicationSeq; // 신청일련번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("DrawerNo")
    private String DrawerNo; // 출금자사번

    @IIrtFldMeta(size = 10)
    @JsonProperty("ApplicationAmt")
    private String ApplicationAmt; // 총금액
}
