package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranReadyAmtItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 2)
    @JsonProperty("MoneyType")
    private String MoneyType; // 금종구분

    @IIrtFldMeta(size = 12)
    @JsonProperty("Amount")
    private String Amount; // 금액

    @IIrtFldMeta(size = 4)
    @JsonProperty("Qty")
    private String Qty; // 매수
}
