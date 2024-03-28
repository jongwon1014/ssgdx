package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranSetItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 3)
    @JsonProperty("ItemSeq")
    private String ItemSeq; // 아이템 SEQ

    @IIrtFldMeta(size = 3)
    @JsonProperty("Seq")
    private String Seq; // SEQ

    @IIrtFldMeta(size = 6)
    @JsonProperty("MdCode")
    private String MdCode; // MD코드

    @IIrtFldMeta(size = 5)
    @JsonProperty("ClassCode")
    private String ClassCode; // 클래스

    @IIrtFldMeta(size = 13)
    @JsonProperty("SetCode")
    private String SetCode; // 세트상품코드

    @IIrtFldMeta(size = 50)
    @JsonProperty("BrandBarcode")
    private String BrandBarcode; // 협력사바코드

    @IIrtFldMeta(size = 8)
    @JsonProperty("StartDate")
    private String StartDate; // 가격시작일자

    @IIrtFldMeta(size = 13)
    @JsonProperty("PluCode")
    private String PluCode; // 내부단품코드

    @IIrtFldMeta(size = 9)
    @JsonProperty("SalePrice")
    private String SalePrice; // 구성품 점별단가

    @IIrtFldMeta(size = 3)
    @JsonProperty("SaleQty")
    private String SaleQty; // 구성품 점별판매수량

    @IIrtFldMeta(size = 9)
    @JsonProperty("SaleAmt")
    private String SaleAmt; // 구성품 점별판매금액

    @IIrtFldMeta(size = 9)
    @JsonProperty("TotalSetPrice")
    private String TotalSetPrice; // 세트전체판매가

    @IIrtFldMeta(size = 50)
    @JsonProperty("Filler")
    private String Filler; // 예비
}
