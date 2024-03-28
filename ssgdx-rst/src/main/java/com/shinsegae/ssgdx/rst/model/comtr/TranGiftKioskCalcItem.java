package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranGiftKioskCalcItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 10)
    @JsonProperty("AdminID")
    private String AdminID; // 사용자(관리자)ID

    @IIrtFldMeta(size = 3)
    @JsonProperty("TranKind")
    private String TranKind; // 거래종류

    @IIrtFldMeta(size = 1)
    @JsonProperty("TranType")
    private String TranType; // 거래형태

    @IIrtFldMeta(size = 20)
    @JsonProperty("UserName")
    private String UserName; // 사용자(관리자) 성명

    @IIrtFldMeta(size = 11)
    @JsonProperty("Ori_SerialNumber")
    private String Ori_SerialNumber; // 원거래 번호

    @IIrtFldMeta(size = 11)
    @JsonProperty("GiftSaleAmount")
    private String GiftSaleAmount; // 판매 상품권 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("GiftExAmount")
    private String GiftExAmount; // 교환 상픔권 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("GiftPresentAmount")
    private String GiftPresentAmount; // 증정 상품권 금액

    /*
     * 입금된 금액
     */
    @IIrtFldMeta(size = 5)
    @JsonProperty("BillInCnt100000")
    private String BillInCnt100000; // 10만원권 현금 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BillInCnt50000")
    private String BillInCnt50000; // 5만원권 현금 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BillInCnt10000")
    private String BillInCnt10000; // 1만원권 현금 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BillInCnt5000")
    private String BillInCnt5000; // 5천원권 현금 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BillInCnt1000")
    private String BillInCnt1000; // 1천원권 현금 매수

    /*
     * 출금된 금액
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
}
