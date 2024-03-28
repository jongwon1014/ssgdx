package com.shinsegae.ssgdx.rst.model.newtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranUntactAccountItemC {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 12)
    @JsonProperty("CustHpNo")
    private String CustHpNo; // 고객휴대폰번호

    @IIrtFldMeta(size = 9)
    @JsonProperty("SPointCustId")
    private String SPointCustId; // 신세계포인트고객ID

    @IIrtFldMeta(size = 20)
    @JsonProperty("SPointCardNo")
    private String SPointCardNo; // 신세계포인트카드번호

    @IIrtFldMeta(size = 40)
    @JsonProperty("StrName")
    private String StrName; // 점포명

    @IIrtFldMeta(size = 200)
    @JsonProperty("ShopName")
    private String ShopName; // 매장명

    @IIrtFldMeta(size = 250)
    @JsonProperty("ItemNm")
    private String ItemNm; // 대표상품명

    @IIrtFldMeta(size = 15)
    @JsonProperty("TotalPay")
    private String TotalPay; // 총결제금액

    @IIrtFldMeta(size = 50)
    @JsonProperty("Filler")
    private String Filler; // 예비
}
