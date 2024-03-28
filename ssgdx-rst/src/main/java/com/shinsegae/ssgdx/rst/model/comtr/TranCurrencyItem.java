package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranCurrencyItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 1)
    @JsonProperty("CancelFlag")
    private String CancelFlag; // 지정취소여부

    @IIrtFldMeta(size = 1)
    @JsonProperty("ForeignType")
    private String ForeignType; // 외화 구분

    @IIrtFldMeta(size = 10)
    @JsonProperty("ReceiveAmount")
    private String ReceiveAmount; // 외화수령액

    @IIrtFldMeta(size = 10)
    @JsonProperty("ForeignAmount")
    private String ForeignAmount; // 외화 결재금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("ForeignExchangeRate")
    private String ForeignExchangeRate; // 환율

    @IIrtFldMeta(size = 9)
    @JsonProperty("ConversioAmount")
    private String ConversioAmount; // 원화환산금액

    @IIrtFldMeta(size = 9)
    @JsonProperty("Change")
    private String Change; // 원화 거스름
}
