package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranGiftKioskInOutItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 8)
    @JsonProperty("SaleDate")
    private String SaleDate; // 거래일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("SaleTime")
    private String SaleTime; // 거래시간

    /*
     * 현금출금
     */
    @IIrtFldMeta(size = 5)
    @JsonProperty("BillOutCnt100000")
    private String BillOutCnt100000; // 10만원권 현금 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BillOutCnt50000")
    private String BillOutCnt50000; // 5만원권 현금 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BillOutCnt10000")
    private String BillOutCnt10000; // 1만원권 현금 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BillOutCnt5000")
    private String BillOutCnt5000; // 5천원권 현금 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BillOutCnt1000")
    private String BillOutCnt1000; // 1천원권 현금 매수

    /*
     * 판매 상품권
     */
    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftOutCnt500000")
    private String GiftOutCnt500000; // 50만원권 상품권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftOutCnt300000")
    private String GiftOutCnt300000; // 30만원권 상품권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftOutCnt100000")
    private String GiftOutCnt100000; // 10만원권 상품권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftOutCnt50000")
    private String GiftOutCnt50000; // 5만원권 상품권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftOutCnt10000")
    private String GiftOutCnt10000; // 1만원권 상품권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftOutCnt5000")
    private String GiftOutCnt5000; // 5천원권 상품권 매수

    /*
     * 증정 상품권
     */
    @IIrtFldMeta(size = 5)
    @JsonProperty("PresentOutCnt500000")
    private String PresentOutCnt500000; // 50만원권 상품권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("PresentOutCnt300000")
    private String PresentOutCnt300000; // 30만원권 상품권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("PresentOutCnt100000")
    private String PresentOutCnt100000; // 10만원권 상품권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("PresentOutCnt50000")
    private String PresentOutCnt50000; // 5만원권 상품권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("PresentOutCnt10000")
    private String PresentOutCnt10000; // 1만원권 상품권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("PresentOutCnt5000")
    private String PresentOutCnt5000; // 5천원권 상품권 매수

    @IIrtFldMeta(size = 11)
    @JsonProperty("BillTotalAmount")
    private String BillTotalAmount; // 현금 총 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("GiftTotalAmount")
    private String GiftTotalAmount; // 판매 상품권

    @IIrtFldMeta(size = 11)
    @JsonProperty("PresentTotalAmount")
    private String PresentTotalAmount; // 증정 상품권

}
