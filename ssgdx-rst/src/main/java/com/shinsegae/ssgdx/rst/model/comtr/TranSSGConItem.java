package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranSSGConItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 12)
    @JsonProperty("Barcode")
    private String Barcode; // 바코드(쿠폰코드)

    @IIrtFldMeta(size = 4)
    @JsonProperty("HplNo")
    private String HplNo; // 핸드폰 번호 뒷 4자리

    @IIrtFldMeta(size = 50)
    @JsonProperty("ItemCd")
    private String ItemCd; // 상품코드

    @IIrtFldMeta(size = 15)
    @JsonProperty("SellPrc")
    private String SellPrc; // 판매가

    @IIrtFldMeta(size = 4)
    @JsonProperty("SalesTrNo")
    private String SalesTrNo; // 백화점 점포코드

    @IIrtFldMeta(size = 50)
    @JsonProperty("RecpNo")
    private String RecpNo; // 영수증 번호

    @IIrtFldMeta(size = 20)
    @JsonProperty("CshrCtNo")
    private String CshrCtNo; // 현금영수증번호

    @IIrtFldMeta(size = 50)
    @JsonProperty("DemndHist")
    private String DemndHist; // 요청IP OR 디바이스번호

    @IIrtFldMeta(size = 20)
    @JsonProperty("CashierId")
    private String CashierId; // 캐셔사번

    @IIrtFldMeta(size = 20)
    @JsonProperty("CnclCshrctNo")
    private String CnclCshrctNo; // 취소현금영수증번호

    @IIrtFldMeta(size = 2)
    @JsonProperty("RefundYn")
    private String RefundYn; // 환불거래 여부

    @IIrtFldMeta(size = 50)
    @JsonProperty("Filler")
    private String Filler; // 예비
}
