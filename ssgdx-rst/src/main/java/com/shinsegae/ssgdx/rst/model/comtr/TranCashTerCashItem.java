package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranCashTerCashItem {

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

    @IIrtFldMeta(size = 10)
    @JsonProperty("AdminAgencyUserID")
    private String AdminAgencyUserID; // 관리자 대행 사용자 ID

    @IIrtFldMeta(size = 20)
    @JsonProperty("AdminAgencyUserName")
    private String AdminAgencyUserName; // 관리자 대행 사용자 성명

    /**
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

    @IIrtFldMeta(size = 5)
    @JsonProperty("CoinInCnt500")
    private String CoinInCnt500; // 500원권 주화 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("CoinInCnt100")
    private String CoinInCnt100; // 100원권 주화 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("CoinInCnt50")
    private String CoinInCnt50; // 50원권 주화 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("CoinInCnt10")
    private String CoinInCnt10; // 10원권 주화 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt100000")
    private String GiftInCnt100000; // 10만원권 상품권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt50000")
    private String GiftInCnt50000; // 5만원권 상품권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt10000")
    private String GiftInCnt10000; // 1만원권 상품권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt5000")
    private String GiftInCnt5000; // 5천원권 상품권 매수

    /**
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
    @JsonProperty("CoOutOutCnt500")
    private String CoOutOutCnt500; // 500원권 주화 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("CoOutOutCnt100")
    private String CoOutOutCnt100; // 100원권 주화 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("CoOutOutCnt50")
    private String CoOutOutCnt50; // 50원권 주화 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("CoOutOutCnt10")
    private String CoOutOutCnt10; // 10원권 주화 매수

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
