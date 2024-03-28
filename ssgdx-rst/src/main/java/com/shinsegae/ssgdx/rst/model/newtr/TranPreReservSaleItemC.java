package com.shinsegae.ssgdx.rst.model.newtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranPreReservSaleItemC {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 20)
    @JsonProperty("SlipNo")
    private String SlipNo; // 전표번호

    @IIrtFldMeta(size = 12)
    @JsonProperty("ContractAmount")
    private String ContractAmount; // 계약금

    @IIrtFldMeta(size = 12)
    @JsonProperty("ContractEnuriAmount")
    private String ContractEnuriAmount; // 계약금에누리금액

    @IIrtFldMeta(size = 12)
    @JsonProperty("ContractNetAmount")
    private String ContractNetAmount; // 계약금순매출금액

    @IIrtFldMeta(size = 2)
    @JsonProperty("DiscountFlag")
    private String DiscountFlag; // 계약금에누리구분

    @IIrtFldMeta(size = 2)
    @JsonProperty("DiscountRate")
    private String DiscountRate; // 계약금에누리율

    @IIrtFldMeta(size = 50)
    @JsonProperty("Filler")
    private String Filler; // 예비
}
