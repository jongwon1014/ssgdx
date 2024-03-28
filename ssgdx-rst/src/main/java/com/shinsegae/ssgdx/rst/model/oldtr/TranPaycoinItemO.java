package com.shinsegae.ssgdx.rst.model.oldtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranPaycoinItemO {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 6)
    @JsonProperty("TextId")
    private String TextId; // Text ID

    @IIrtFldMeta(size = 4)
    @JsonProperty("StoreNo")
    private String StoreNo; // 점포코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("PosNo")
    private String PosNo; // POS번호

    @IIrtFldMeta(size = 6)
    @JsonProperty("CashierNo")
    private String CashierNo; // 담당자번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("ChitNo")
    private String ChitNo; // CD 일련번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("TranNo")
    private String TranNo; // POS 거래번호

    @IIrtFldMeta(size = 8)
    @JsonProperty("SaleDate")
    private String SaleDate; // 영업일자

    @IIrtFldMeta(size = 1)
    @JsonProperty("ItemSeq")
    private String ItemSeq; // 아이템시퀀스

    @IIrtFldMeta(size = 20)
    @JsonProperty("CommandType")
    private String CommandType; // 요청구분

    @IIrtFldMeta(size = 20)
    @JsonProperty("BarcodeNo")
    private String BarcodeNo; // 바코드번호

    @IIrtFldMeta(size = 20)
    @JsonProperty("MerNo")
    private String MerNo; // 가맹점번호

    @IIrtFldMeta(size = 20)
    @JsonProperty("MerPassword")
    private String MerPassword; // 가맹점 비밀번호

    @IIrtFldMeta(size = 20)
    @JsonProperty("SKUCode")
    private String SKUCode; // 상품코드(itemcode)

    @IIrtFldMeta(size = 20)
    @JsonProperty("SKUName")
    private String SKUName; // 상품명

    @IIrtFldMeta(size = 100)
    @JsonProperty("MerSaleNo")
    private String MerSaleNo; // 가맹점 거래번호

    @IIrtFldMeta(size = 9)
    @JsonProperty("SaleAmount")
    private String SaleAmount; // 결제금액

    @IIrtFldMeta(size = 2)
    @JsonProperty("PayCode")
    private String PayCode; // 결제수단 코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("RespCode")
    private String RespCode; // 응답코드

    @IIrtFldMeta(size = 256)
    @JsonProperty("RespMsg")
    private String RespMsg; // 응답메세지

    @IIrtFldMeta(size = 40)
    @JsonProperty("SaleTID")
    private String SaleTID; // 거래 ID

    @IIrtFldMeta(size = 40)
    @JsonProperty("CnclTID")
    private String CnclTID; // 취소거래 ID

    @IIrtFldMeta(size = 9)
    @JsonProperty("CnclBalance")
    private String CnclBalance; // 취소 후 한도 잔액

    @IIrtFldMeta(size = 8)
    @JsonProperty("OrgSaleData")
    private String OrgSaleData; // 취소 원거래 일자

    @IIrtFldMeta(size = 100)
    @JsonProperty("MsgReserved1")
    private String MsgReserved1; // Reserved Field 1

    @IIrtFldMeta(size = 100)
    @JsonProperty("MsgReserved2")
    private String MsgReserved2; // Reserved Field 2

    @IIrtFldMeta(size = 1)
    @JsonProperty("SIdUseFlag")
    private String SIdUseFlag; // SID_MERCHANT 사용 여부

    @IIrtFldMeta(size = 20)
    @JsonProperty("SIdMer")
    private String SIdMer; // 하부 가맹점

    @IIrtFldMeta(size = 2)
    @JsonProperty("InsMonth")
    private String InsMonth; // 할부개월

    @IIrtFldMeta(size = 9)
    @JsonProperty("DiscountAmount")
    private String DiscountAmount; // 할인금액

    @IIrtFldMeta(size = 9)
    @JsonProperty("CupAmount")
    private String CupAmount; // 1회용컵 보증금 금액

    @IIrtFldMeta(size = 6)
    @JsonProperty("MDCode")
    private String MDCode; // MD코드

    @IIrtFldMeta(size = 92)
    @JsonProperty("Filler")
    private String Filler; // 예비
}
