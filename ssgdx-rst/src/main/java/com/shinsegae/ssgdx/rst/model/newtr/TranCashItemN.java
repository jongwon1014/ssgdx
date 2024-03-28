package com.shinsegae.ssgdx.rst.model.newtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranCashItemN {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 2)
    @JsonProperty("CashType")
    private String CashType; // 구분

    @IIrtFldMeta(size = 9)
    @JsonProperty("Amount")
    private String Amount; // 금액

    @IIrtFldMeta(size = 8)
    @JsonProperty("Change")
    private String Change; // 거스름
}
