package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranCashTerCashinItem {

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

    /**
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

    @IIrtFldMeta(size = 5)
    @JsonProperty("CoinOutCnt500")
    private String CoinOutCnt500; // 500원권 현금 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("CoinOutCnt100")
    private String CoinOutCnt100; // 100원권 현금 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("CoinOutCnt50")
    private String CoinOutCnt50; // 50원권 현금 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("CoinOutCnt10")
    private String CoinOutCnt10; // 10원권 현금 매수

    /**
     * 상품권출금
     */
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

    /**
     * 현금입금
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
    private String CoinInCnt500; // 500원권 현금 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("CoinInCnt100")
    private String CoinInCnt100; // 100원권 현금 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("CoinInCnt50")
    private String CoinInCnt50; // 50원권 현금 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("CoinInCnt10")
    private String CoinInCnt10; // 10원권 현금 매수

    /**
     * 수표입금
     */
    @IIrtFldMeta(size = 5)
    @JsonProperty("CheckInCnt1000000")
    private String CheckInCnt1000000; // 100만원권 수표 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("CheckInCnt500000")
    private String CheckInCnt500000; // 50만원권 수표 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("CheckInCnt300000")
    private String CheckInCnt300000; // 30만원권 수표 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("CheckInCnt100000")
    private String CheckInCnt100000; // 10만원권 수표 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("CheckInNonDenoCnt")
    private String CheckInNonDenoCnt; // 비정액권 매수

    @IIrtFldMeta(size = 11)
    @JsonProperty("CheckInNonDenoAmt")
    private String CheckInNonDenoAmt; // 비정액권 금액

    /**
     * 달러입금
     */
    @IIrtFldMeta(size = 5)
    @JsonProperty("DollarInCnt100")
    private String DollarInCnt100; // 100달러 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("DollarInCnt50")
    private String DollarInCnt50; // 50달러 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("DollarInCnt20")
    private String DollarInCnt20; // 20달러 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("DollarInCnt10")
    private String DollarInCnt10; // 10달러 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("DollarInCnt5")
    private String DollarInCnt5; // 5달러 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("DollarInCnt2")
    private String DollarInCnt2; // 2달러 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("DollarInCnt1")
    private String DollarInCnt1; // 1달러 매수

    /**
     * 엔입금
     */
    @IIrtFldMeta(size = 5)
    @JsonProperty("YenInCnt10000")
    private String YenInCnt10000; // 10000엔 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("YenInCnt5000")
    private String YenInCnt5000; // 5000엔 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("YenInCnt2000")
    private String YenInCnt2000; // 2000엔 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("YenInCnt1000")
    private String YenInCnt1000; // 1000엔 매수

    /**
     * 유로입금
     */
    @IIrtFldMeta(size = 5)
    @JsonProperty("EuroInCnt500")
    private String EuroInCnt500; // 500유로 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("EuroInCnt200")
    private String EuroInCnt200; // 200유로 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("EuroInCnt100")
    private String EuroInCnt100; // 100유로 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("EuroInCnt50")
    private String EuroInCnt50; // 50유로 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("EuroInCnt20")
    private String EuroInCnt20; // 20유로 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("EuroInCnt10")
    private String EuroInCnt10; // 10유로 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("EuroInCnt5")
    private String EuroInCnt5; // 5유로 매수

    /**
     * 위안입금
     */
    @IIrtFldMeta(size = 5)
    @JsonProperty("YuanCnt100")
    private String YuanCnt100; // 100위안 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("YuanCnt20")
    private String YuanCnt20; // 20위안 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("YuanCnt10")
    private String YuanCnt10; // 10위안 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("YuanCnt5")
    private String YuanCnt5; // 5위안 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("YuanCnt2")
    private String YuanCnt2; // 2위안 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("YuanCnt1")
    private String YuanCnt1; // 1위안 매수

    /**
     * 상품권입금
     */
    @IIrtFldMeta(size = 11)
    @JsonProperty("InCorpGiftAmt")
    private String InCorpGiftAmt; // 자사 상품권 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("OutCorpGiftAmt")
    private String OutCorpGiftAmt; // 타사 상품권 금액

    /**
     * 현금봉투입금
     */
    @IIrtFldMeta(size = 5)
    @JsonProperty("BagBillOutCnt100000")
    private String BagBillOutCnt100000; // 10만원권 현금 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagBillOutCnt50000")
    private String BagBillOutCnt50000; // 5만원권 현금 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagBillOutCnt10000")
    private String BagBillOutCnt10000; // 1만원권 현금 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagBillOutCnt5000")
    private String BagBillOutCnt5000; // 5천원권 현금 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagBillOutCnt1000")
    private String BagBillOutCnt1000; // 1천원권 현금 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagCoinOutCnt500")
    private String BagCoinOutCnt500; // 500원권 주화 개수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagCoinOutCnt100")
    private String BagCoinOutCnt100; // 100원권 주화 개수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagCoinOutCnt50")
    private String BagCoinOutCnt50; // 50원권 주화 개수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagCoinOutCnt10")
    private String BagCoinOutCnt10; // 10원권 주화 개수

    /**
     * 수표봉투입금
     */
    @IIrtFldMeta(size = 5)
    @JsonProperty("BagCheckInCnt1000000")
    private String BagCheckInCnt1000000; // 100만원권 수표 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagCheckInCnt500000")
    private String BagCheckInCnt500000; // 50만원권 수표 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagCheckInCnt300000")
    private String BagCheckInCnt300000; // 30만원권 수표 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagCheckInCnt100000")
    private String BagCheckInCnt100000; // 10만원권 수표 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagCheckInNonDenoCnt")
    private String BagCheckInNonDenoCnt; // 비정액권 매수

    @IIrtFldMeta(size = 11)
    @JsonProperty("BagCheckInNonDenoAmt")
    private String BagCheckInNonDenoAmt; // 비정액권 금액

    /**
     * 달러봉투입금
     */
    @IIrtFldMeta(size = 5)
    @JsonProperty("BagDollarInCnt100")
    private String BagDollarInCnt100; // 100달러 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagDollarInCnt50")
    private String BagDollarInCnt50; // 50달러 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagDollarInCnt20")
    private String BagDollarInCnt20; // 20달러 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagDollarInCnt10")
    private String BagDollarInCnt10; // 10달러 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagDollarInCnt5")
    private String BagDollarInCnt5; // 5달러 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagDollarInCnt2")
    private String BagDollarInCnt2; // 2달러 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagDollarInCnt1")
    private String BagDollarInCnt1; // 1달러 매수

    /**
     * 엔봉투입금
     */
    @IIrtFldMeta(size = 5)
    @JsonProperty("BagYenInCnt10000")
    private String BagYenInCnt10000; // 10000엔 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagYenInCnt5000")
    private String BagYenInCnt5000; // 5000엔 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagYenInCnt2000")
    private String BagYenInCnt2000; // 2000엔 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagYenInCnt1000")
    private String BagYenInCnt1000; // 1000엔 매수

    /**
     * 유로봉투입금
     */
    @IIrtFldMeta(size = 5)
    @JsonProperty("BagEuroInCnt500")
    private String BagEuroInCnt500; // 500유로 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagEuroInCnt200")
    private String BagEuroInCnt200; // 200유로 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagEuroInCnt100")
    private String BagEuroInCnt100; // 100유로 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagEuroInCnt50")
    private String BagEuroInCnt50; // 50유로 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagEuroInCnt20")
    private String BagEuroInCnt20; // 20유로 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagEuroInCnt10")
    private String BagEuroInCnt10; // 10유로 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagEuroInCnt5")
    private String BagEuroInCnt5; // 5유로 매수

    /**
     * 위안봉투입금
     */
    @Getter
    @Setter
    @IIrtFldMeta(size = 5)
    @JsonProperty("BagYuanCnt100")
    private String BagYuanCnt100; // 100위안 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagYuanCnt20")
    private String BagYuanCnt20; // 20위안 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagYuanCnt10")
    private String BagYuanCnt10; // 10위안 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagYuanCnt5")
    private String BagYuanCnt5; // 5위안 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagYuanCnt2")
    private String BagYuanCnt2; // 2위안 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagYuanCnt1")
    private String BagYuanCnt1; // 1위안 매수

    /**
     * 상품권봉투입금
     */
    @IIrtFldMeta(size = 11)
    @JsonProperty("BagInCorpGiftAmt")
    private String BagInCorpGiftAmt; // 자사 상품권 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("BagOutCorpGiftAmt")
    private String BagOutCorpGiftAmt; // 타사 상품권 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("BagAllianceGiftAmt")
    private String BagAllianceGiftAmt; // 제휴 상품권 금액

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagOutCorpGiftCnt")
    private String BagOutCorpGiftCnt; // 타사 상품권 매수

    /**
     * 상품권입금계수
     */
    @IIrtFldMeta(size = 11)
    @JsonProperty("AllianceGiftAmt")
    private String AllianceGiftAmt; // 상품권입금계수
}
