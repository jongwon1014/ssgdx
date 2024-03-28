package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranGiftSaleItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 3)
    @JsonProperty("ItemSeq")
    private String ItemSeq; // 순번

    @IIrtFldMeta(size = 2)
    @JsonProperty("TranType")
    private String TranType; // 거래구분코드

    @IIrtFldMeta(size = 2)
    @JsonProperty("SaleType")
    private String SaleType; // 판매유형코드

    @IIrtFldMeta(size = 13)
    @JsonProperty("GiftStartNo")
    private String GiftStartNo; // 상품권 시작번호

    @IIrtFldMeta(size = 13)
    @JsonProperty("GiftEndNo")
    private String GiftEndNo; // 상품권 종료번호

    @IIrtFldMeta(size = 2)
    @JsonProperty("MoneyType")
    private String MoneyType; // 권종코드

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftCount")
    private String GiftCount; // 상품권수량

    @IIrtFldMeta(size = 5)
    @JsonProperty("Filler")
    private String Filler; // 예비
}
