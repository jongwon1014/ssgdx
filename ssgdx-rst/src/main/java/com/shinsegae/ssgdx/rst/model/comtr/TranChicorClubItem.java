package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranChicorClubItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 10)
    @JsonProperty("MsgText")
    private String MsgText; // 전문구분

    @IIrtFldMeta(size = 6)
    @JsonProperty("TradeGbCd")
    private String TradeGbCd; // 거래구분코드

    @IIrtFldMeta(size = 10)
    @JsonProperty("MsgId")
    private String MsgId; // 전문ID

    @IIrtFldMeta(size = 8)
    @JsonProperty("SaleDt")
    private String SaleDt; // 영업일자

    @IIrtFldMeta(size = 4)
    @JsonProperty("TradeDt")
    private String TradeDt; // 거래발생일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("TradeTm")
    private String TradeTm; // 서버 갱신 값3

    @IIrtFldMeta(size = 4)
    @JsonProperty("StoreNo")
    private String StoreNo; // 점포코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("PosNo")
    private String PosNo; // POS번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("TranNo")
    private String TranNo; // 거래번호

    @IIrtFldMeta(size = 6)
    @JsonProperty("CashierNo")
    private String CashierNo; // 캐셔번호

    @IIrtFldMeta(size = 6)
    @JsonProperty("MdCode")
    private String MdCode; // MD코드

    @IIrtFldMeta(size = 60)
    @JsonProperty("CardNo")
    private String CardNo; // 카드번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("BrchId")
    private String BrchId; // 가맹점ID

    @IIrtFldMeta(size = 20)
    @JsonProperty("RecptNo")
    private String RecptNo; // 영수증번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("ShinhanDebitPay")
    private String ShinhanDebitPay; // 신한직불 결재금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("WooriDebitPay")
    private String WooriDebitPay; // 우리직불 결제금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("NormalDebitPay")
    private String NormalDebitPay; // 일반직불 결제금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("SamsungCityPay")
    private String SamsungCityPay; // 자사카드 결제금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("WooriCheckPay")
    private String WooriCheckPay; // 우리체크 결제금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("CashPay")
    private String CashPay; // 현금 결제금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("GiftPay")
    private String GiftPay; // 상품권 결제금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("OtherPay")
    private String OtherPay; // 타사카드/기타 결제금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("NotPointPay")
    private String NotPointPay; // 미적립대상 결제금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("SPointPay")
    private String SPointPay; // S-POINT 결제금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("TotalPay")
    private String TotalPay; // 총 결제금액

    @IIrtFldMeta(size = 8)
    @JsonProperty("OrgSaleDate")
    private String OrgSaleDate; // 원거래 영업일자

    @IIrtFldMeta(size = 4)
    @JsonProperty("OrgStoreNo")
    private String OrgStoreNo; // 원거래 점포코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("OrgPosNo")
    private String OrgPosNo; // 원거래 POS번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("OrgTranNo")
    private String OrgTranNo; // 원거래 거래번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("OrgTotalPay")
    private String OrgTotalPay; // 원거래 결제금액

    @IIrtFldMeta(size = 4)
    @JsonProperty("ReplyCd")
    private String ReplyCd; // 응답코드

    @IIrtFldMeta(size = 10)
    @JsonProperty("CoinEchCnt")
    private String CoinEchCnt; // 코인 교환수량

    @IIrtFldMeta(size = 10)
    @JsonProperty("CoinRefundCnt")
    private String CoinRefundCnt; // 코인 회입수량

    @IIrtFldMeta(size = 10)
    @JsonProperty("AddMile")
    private String AddMile; // 적립 마일리지

    @IIrtFldMeta(size = 10)
    @JsonProperty("CUST_ID")
    private String CUST_ID; // 고객ID.

    @IIrtFldMeta(size = 10)
    @JsonProperty("UsableMile")
    private String UsableMile; // 가용 마일리지

    @IIrtFldMeta(size = 10)
    @JsonProperty("MdSumAmt")
    private String MdSumAmt; // MD합계금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("DisAmt")
    private String DisAmt; // 에누리금액

    @IIrtFldMeta(size = 1)
    @JsonProperty("SageGb")
    private String SageGb; // 세일리지구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("ClassChangeYn")
    private String ClassChangeYn; // 등급변경여부

    @IIrtFldMeta(size = 2)
    @JsonProperty("Filler1")
    private String Filler1; // 예비2

    @IIrtFldMeta(size = 2)
    @JsonProperty("SageCustTypCd")
    private String SageCustTypCd; // 세일리지고객유형

    @IIrtFldMeta(size = 2)
    @JsonProperty("PosCustTypCd")
    private String PosCustTypCd; // POS고객유형

    @IIrtFldMeta(size = 3)
    @JsonProperty("RetGiftCnt")
    private String RetGiftCnt; // 코인회입 물품(코인구간)

    @IIrtFldMeta(size = 3)
    @JsonProperty("RetCoinCnt")
    private String RetCoinCnt; // 코인회입 코인개수

    @IIrtFldMeta(size = 44)
    @JsonProperty("PosFiller1")
    private String PosFiller1; // POS 예비1

    @IIrtFldMeta(size = 50)
    @JsonProperty("PosFiller2")
    private String PosFiller2; // POS 예비2
}
