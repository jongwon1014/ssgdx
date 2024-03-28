package com.shinsegae.ssgdx.rst.model.newtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranCCFreeSetItemN {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 3)
    @JsonProperty("Seq")
    private String Seq; // 순번

    @IIrtFldMeta(size = 2)
    @JsonProperty("GnrCode")
    private String GnrCode; // 장르코드

    @IIrtFldMeta(size = 2)
    @JsonProperty("PluType")
    private String PluType; // 상품구분

    @IIrtFldMeta(size = 10)
    @JsonProperty("ShopCode")
    private String ShopCode; // 매장코드

    @IIrtFldMeta(size = 13)
    @JsonProperty("PluCode")
    private String PluCode; // 상품코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("PluQty")
    private String PluQty; // 판매(증정)수량

    @IIrtFldMeta(size = 15)
    @JsonProperty("Amount")
    private String Amount; // 판매금액

    @IIrtFldMeta(size = 6)
    @JsonProperty("PrsEventMon")
    private String PrsEventMon; // 증정년월

    @IIrtFldMeta(size = 9)
    @JsonProperty("PrsSeqNo")
    private String PrsSeqNo; // 증정순번

    @IIrtFldMeta(size = 100)
    @JsonProperty("Filler")
    private String Filler; // 예비
}
