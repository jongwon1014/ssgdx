package com.shinsegae.ssgdx.rst.model.newtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranUseSaleSpecialItemC {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemType")
    private String ItemType; // 매출구분

    @IIrtFldMeta(size = 6)
    @JsonProperty("EmpNo")
    private String EmpNo; // 사원번호

    @IIrtFldMeta(size = 14)
    @JsonProperty("SlipNo")
    private String SlipNo; // 전표번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("ShopCode")
    private String ShopCode; // 매장코드

    @IIrtFldMeta(size = 12)
    @JsonProperty("Amount")
    private String Amount; // 판매금액

    @IIrtFldMeta(size = 50)
    @JsonProperty("Filler")
    private String Filler; // 예비
}
