package com.shinsegae.ssgdx.rst.model.oldtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranCashTerExpenItemO {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 2)
    @JsonProperty("DraftCode")
    private String DraftCode; // 기안구분

    @IIrtFldMeta(size = 10)
    @JsonProperty("RegisterNo")
    private String RegisterNo; // 기안자사번

    @IIrtFldMeta(size = 35)
    @JsonProperty("RegisterID")
    private String RegisterID; // 기안지ID / 블라섬결재 일련번호

    @IIrtFldMeta(size = 2)
    @JsonProperty("RegisterSeq")
    private String RegisterSeq; // 경조순번

    @IIrtFldMeta(size = 3)
    @JsonProperty("OccasionCode")
    private String OccasionCode; // 경조코드

    @IIrtFldMeta(size = 8)
    @JsonProperty("OccasionDate")
    private String OccasionDate; // 경조사일 / 정리예정일

    @IIrtFldMeta(size = 10)
    @JsonProperty("OccasionerNo")
    private String OccasionerNo; // 경조사사번

    @IIrtFldMeta(size = 1)
    @JsonProperty("OccasionerDept")
    private String OccasionerDept; // 대상자소속 / 시상금 여부

    @IIrtFldMeta(size = 10)
    @JsonProperty("DrawerNo")
    private String DrawerNo; // 신청자사번

    @IIrtFldMeta(size = 10)
    @JsonProperty("OccasionAmt")
    private String OccasionAmt; // 출금액 / 신청금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("Filler")
    private String Filler; // 예비필드
}
