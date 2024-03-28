package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranPointItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 2)
    @JsonProperty("TranType")
    private String TranType; // 거래구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("PosType")
    private String PosType; // POS구분

    @IIrtFldMeta(size = 20)
    @JsonProperty("CardNo")
    private String CardNo; // 포인트카드번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("StoreId")
    private String StoreId; // 점포ID

    @IIrtFldMeta(size = 20)
    @JsonProperty("ApprovalNo")
    private String ApprovalNo; // 승인번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("Password")
    private String Password; // 비밀번호

    @IIrtFldMeta(size = 13)
    @JsonProperty("CouponNo1")
    private String CouponNo1; // 현금쿠폰번호1

    @IIrtFldMeta(size = 13)
    @JsonProperty("CouponNo2")
    private String CouponNo2; // 현금쿠폰번호2

    @IIrtFldMeta(size = 13)
    @JsonProperty("CouponNo3")
    private String CouponNo3; // 현금쿠폰번호3

    @IIrtFldMeta(size = 13)
    @JsonProperty("CouponNo4")
    private String CouponNo4; // 현금쿠폰번호4

    @IIrtFldMeta(size = 10)
    @JsonProperty("GiftPointAmount")
    private String GiftPointAmount; // 상품권금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("ShinhanDebitPay")
    private String ShinhanDebitPay; // 신한직불

    @IIrtFldMeta(size = 10)
    @JsonProperty("WooriDebitPay")
    private String WooriDebitPay; // 우리직불

    @IIrtFldMeta(size = 10)
    @JsonProperty("NormalDebitPay")
    private String NormalDebitPay; // 일반직불

    @IIrtFldMeta(size = 10)
    @JsonProperty("ShinCitySamPay")
    private String ShinCitySamPay; // 신세계씨티 결제금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("WooriCheckPay")
    private String WooriCheckPay; // 우리체크

    @IIrtFldMeta(size = 10)
    @JsonProperty("CashPay")
    private String CashPay; // 현금

    @IIrtFldMeta(size = 10)
    @JsonProperty("GiftPay")
    private String GiftPay; // 상품권

    @IIrtFldMeta(size = 10)
    @JsonProperty("OtherPay")
    private String OtherPay; // 타사카드/기타

    @IIrtFldMeta(size = 10)
    @JsonProperty("NotPointPay")
    private String NotPointPay; // 미적립대상

    @IIrtFldMeta(size = 10)
    @JsonProperty("SPointPay")
    private String SPointPay; // S-POINT

    @IIrtFldMeta(size = 10)
    @JsonProperty("TotalPay")
    private String TotalPay; // 총 결제금액

    @IIrtFldMeta(size = 8)
    @JsonProperty("TotalPoint")
    private String TotalPoint; // 누적포인트

    @IIrtFldMeta(size = 8)
    @JsonProperty("UsablePoint")
    private String UsablePoint; // 가용포인트

    @IIrtFldMeta(size = 8)
    @JsonProperty("CurrentPoint")
    private String CurrentPoint; // 금회포인트

    @IIrtFldMeta(size = 8)
    @JsonProperty("CurrentBasic")
    private String CurrentBasic; // 기본적립포인트

    @IIrtFldMeta(size = 8)
    @JsonProperty("CurrentGood")
    private String CurrentGood; // 상품적립포인트

    @IIrtFldMeta(size = 8)
    @JsonProperty("CurrentClub")
    private String CurrentClub; // 클럽적립포인트

    @IIrtFldMeta(size = 8)
    @JsonProperty("CurrentEvent")
    private String CurrentEvent; // 이벤트적립포인트

    @IIrtFldMeta(size = 8)
    @JsonProperty("CurrentEtc")
    private String CurrentEtc; // 기타적립포인트

    @IIrtFldMeta(size = 1)
    @JsonProperty("ExchangeUser")
    private String ExchangeUser; // 전환고객여부

    @IIrtFldMeta(size = 1)
    @JsonProperty("MakePassword")
    private String MakePassword; // 비밀번호존재여부

    @IIrtFldMeta(size = 1)
    @JsonProperty("CashReceipt")
    private String CashReceipt; // 현금영수증대상

    @IIrtFldMeta(size = 8)
    @JsonProperty("OrgSaleDate")
    private String OrgSaleDate; // 원거래 영업일

    @IIrtFldMeta(size = 4)
    @JsonProperty("OrgStoreNo")
    private String OrgStoreNo; // 원거래 점코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("OrgPosNo")
    private String OrgPosNo; // 원거래 POS번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("OrgTranNo")
    private String OrgTranNo; // 원거래 거래번호

    @IIrtFldMeta(size = 20)
    @JsonProperty("OrgApprovalNo")
    private String OrgApprovalNo; // 원거래 승인번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("OrgTotalPay")
    private String OrgTotalPay; // 원거래총결제금액

    @IIrtFldMeta(size = 9)
    @JsonProperty("CustId")
    private String CustId; // Cust-ID

    @IIrtFldMeta(size = 1)
    @JsonProperty("SsgPayFlag")
    private String SsgPayFlag; // SSG-Pay 플래그

    @IIrtFldMeta(size = 70)
    @JsonProperty("EtcMessage")
    private String EtcMessage; // 영수증메시지

    @IIrtFldMeta(size = 1)
    @JsonProperty("GiftShopFg")
    private String GiftShopFg; // 상품권 샵 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("EReceiptPrtFlg")
    private String EReceiptPrtFlg; // 전자영수증 발급 유/무

    @IIrtFldMeta(size = 1)
    @JsonProperty("pnt_add_type")
    private String pnt_add_type; // 포인트 추가적립 타입

    @IIrtFldMeta(size = 4)
    @JsonProperty("pnt_add_rate")
    private String pnt_add_rate; // 포인트 추가적립율

    @IIrtFldMeta(size = 1)
    @JsonProperty("input_flg")
    private String input_flg; // 포인트 입력 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("OffTranYn")
    private String OffTranYn; // 오프라인 적립 거래 여부

    @IIrtFldMeta(size = 142)
    @JsonProperty("Filler")
    private String Filler; // 예비
}
