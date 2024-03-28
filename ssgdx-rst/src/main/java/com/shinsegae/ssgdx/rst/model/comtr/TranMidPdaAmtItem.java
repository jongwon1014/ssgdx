package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranMidPdaAmtItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 1)
    @JsonProperty("InputType")
    private String InputType; // 입출금구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("EntryType")
    private String EntryType; // 거래유형

    @IIrtFldMeta(size = 6)
    @JsonProperty("PdaCashierNo")
    private String PdaCashierNo; // 캐셔번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("PdaPosNo")
    private String PdaPosNo; // POS번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("PdaTranNo")
    private String PdaTranNo; // 거래번호

    @IIrtFldMeta(size = 9)
    @JsonProperty("CashAmount")
    private String CashAmount; // 현금금액

    @IIrtFldMeta(size = 9)
    @JsonProperty("GiftAmount")
    private String GiftAmount; // 상품권금액
}
