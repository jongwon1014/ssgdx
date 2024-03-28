package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranVipMileageItem {

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

    @IIrtFldMeta(size = 6)
    @JsonProperty("MdCode")
    private String MdCode; // 상품코드

    @IIrtFldMeta(size = 20)
    @JsonProperty("CardNo")
    private String CardNo; // 포인트카드번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("StoreId")
    private String StoreId; // 가맹점ID

    @IIrtFldMeta(size = 20)
    @JsonProperty("ApprovalNo")
    private String ApprovalNo; // 승인번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("ShinhanDebitPay")
    private String ShinhanDebitPay; // 신한직불 결제금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("WooriDebitPay")
    private String WooriDebitPay; // 우리직불 결제금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("NormalDebitPay")
    private String NormalDebitPay; // 일반직불 결제금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("SamsungCityPay")
    private String SamsungCityPay; // 신세계시티 결제금액

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
    private String TotalPay; // 총결제금액

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
    private String OrgTotalPay; // 원거래 총결제금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("DMS_OFFSET_AMT")
    private String DMS_OFFSET_AMT; // DMS 대상 한도 차감 금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("SMoneyPay")
    private String SMoneyPay; // 신백머니 결제금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("Filler3")
    private String Filler3; // 예비3

    @IIrtFldMeta(size = 10)
    @JsonProperty("ReturnGiftAmount")
    private String ReturnGiftAmount; // 회입한 상품권

    @IIrtFldMeta(size = 10)
    @JsonProperty("ReturnCashAmount")
    private String ReturnCashAmount; // 회입한 현금

    @IIrtFldMeta(size = 10)
    @JsonProperty("MD_SUM_AMT")
    private String MD_SUM_AMT; // MD합계금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("DIS_AMT")
    private String DIS_AMT; // 에누리금액

    @IIrtFldMeta(size = 1)
    @JsonProperty("SAGE_CUST_YN")
    private String SAGE_CUST_YN; // 세일리지 고객여부

    @IIrtFldMeta(size = 1)
    @JsonProperty("CLASS_CHANGE_YN")
    private String CLASS_CHANGE_YN; // 등급변경여부

    @IIrtFldMeta(size = 2)
    @JsonProperty("VIP_CUST_TYP_CD")
    private String VIP_CUST_TYP_CD; // VIP 고객유형(프로모션2 고객유형)

    @IIrtFldMeta(size = 2)
    @JsonProperty("SAGE_CUST_TYP_CD")
    private String SAGE_CUST_TYP_CD; // 세일리지 고객유형

    @IIrtFldMeta(size = 2)
    @JsonProperty("POS_CUST_TYP_CD")
    private String POS_CUST_TYP_CD; // POS 고객유형

    @IIrtFldMeta(size = 2)
    @JsonProperty("TOTMEM_CUST_TYP_CD")
    private String TOTMEM_CUST_TYP_CD; // 그룹멤버십 고객유형

    @IIrtFldMeta(size = 120)
    @JsonProperty("Filler")
    private String Filler; // 예비
}
