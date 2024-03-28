package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranGiftItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 2)
    @JsonProperty("GiftType")
    private String GiftType; // 상품권구분

    @IIrtFldMeta(size = 14)
    @JsonProperty("GiftNo")
    private String GiftNo; // 상품권번호

    @IIrtFldMeta(size = 3)
    @JsonProperty("Qty")
    private String Qty; // 상품권매수

    @IIrtFldMeta(size = 9)
    @JsonProperty("Amount")
    private String Amount; // 상품권금액

    @IIrtFldMeta(size = 8)
    @JsonProperty("CashChange")
    private String CashChange; // 현금거스름금액

    @IIrtFldMeta(size = 8)
    @JsonProperty("GiftChange")
    private String GiftChange; // 상품권거스름금액
}
