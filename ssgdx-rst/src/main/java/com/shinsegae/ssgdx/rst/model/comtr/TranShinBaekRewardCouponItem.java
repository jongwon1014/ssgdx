package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranShinBaekRewardCouponItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 1)
    @JsonProperty("tradeGbCd")
    private String tradeGbCd; // 거래구분

    @IIrtFldMeta(size = 4)
    @JsonProperty("chitNo")
    private String chitNo; // CD일련번호

    @IIrtFldMeta(size = 9)
    @JsonProperty("custId")
    private String custId; // 회원번호

    @IIrtFldMeta(size = 20)
    @JsonProperty("sMembershipCardNo")
    private String sMembershipCardNo; // 신백멤버십카드번호

    @IIrtFldMeta(size = 8)
    @JsonProperty("saleDate")
    private String saleDate; // 거래일자

    @IIrtFldMeta(size = 4)
    @JsonProperty("storeCode")
    private String storeCode; // 점포코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("posNo")
    private String posNo; // POS번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("tranNo")
    private String tranNo; // POS거래번호

    @IIrtFldMeta(size = 24)
    @JsonProperty("rcptNo")
    private String rcptNo; // 거래고유번호

    @IIrtFldMeta(size = 12)
    @JsonProperty("totRewUsed")
    private String totRewUsed; // 총리워드사용금액

    @IIrtFldMeta(size = 12)
    @JsonProperty("compAmt")
    private String compAmt; // 동일리워드사용금액

    @IIrtFldMeta(size = 12)
    @JsonProperty("difCompAmt")
    private String difCompAmt; // 타법인사용금액

    @IIrtFldMeta(size = 12)
    @JsonProperty("totTaxFreeAmt")
    private String totTaxFreeAmt; // 면세물품총액

    @IIrtFldMeta(size = 12)
    @JsonProperty("totTaxAmt")
    private String totTaxAmt; // 과세물품총액

    @IIrtFldMeta(size = 8)
    @JsonProperty("orgSaleDate")
    private String orgSaleDate; // 원거래거래일자

    @IIrtFldMeta(size = 4)
    @JsonProperty("orgPosNo")
    private String orgPosNo; // 원거래POS번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("orgTranNo")
    private String orgTranNo; // 원거래거래번호

    @IIrtFldMeta(size = 24)
    @JsonProperty("orgRcptNo")
    private String orgRcptNo; // 원거래고유번호

    @IIrtFldMeta(size = 6)
    @JsonProperty("mdCode")
    private String mdCode; // 사용MD코드

    @IIrtFldMeta(size = 1)
    @JsonProperty("irtYn")
    private String irtYn; // 조회구분

    @IIrtFldMeta(size = 8)
    @JsonProperty("couponEndDate")
    private String couponEndDate; // 쿠폰 종료일자

    @IIrtFldMeta(size = 192)
    @JsonProperty("filler")
    private String filler; // 필러
}
