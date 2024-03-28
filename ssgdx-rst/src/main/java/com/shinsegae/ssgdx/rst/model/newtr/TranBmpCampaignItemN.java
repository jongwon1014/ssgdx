package com.shinsegae.ssgdx.rst.model.newtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranBmpCampaignItemN {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 1)
    @JsonProperty("JobType")
    private String JobType; // 업무구분

    @IIrtFldMeta(size = 10)
    @JsonProperty("CampId")
    private String CampId; // 캠페인식별자

    @IIrtFldMeta(size = 4)
    @JsonProperty("EvtStrCd")
    private String EvtStrCd; // 점포코드

    @IIrtFldMeta(size = 6)
    @JsonProperty("EvtYm")
    private String EvtYm; // 행사년월

    @IIrtFldMeta(size = 9)
    @JsonProperty("EvtNo")
    private String EvtNo; // 행사번호

    @IIrtFldMeta(size = 6)
    @JsonProperty("MdCd")
    private String MdCd; // MD코드

    @IIrtFldMeta(size = 5)
    @JsonProperty("Classcode")
    private String Classcode; // 클래스

    @IIrtFldMeta(size = 8)
    @JsonProperty("EvtStartDt")
    private String EvtStartDt; // 행사시작일자

    @IIrtFldMeta(size = 8)
    @JsonProperty("EvtEndDt")
    private String EvtEndDt; // 행사종료일자

    @IIrtFldMeta(size = 8)
    @JsonProperty("CnclValidDt")
    private String CnclValidDt; // 취소유효일자

    @IIrtFldMeta(size = 5)
    @JsonProperty("ShareRatioS")
    private String ShareRatioS; // 분담율_신세계

    @IIrtFldMeta(size = 5)
    @JsonProperty("ShareRatioB")
    private String ShareRatioB; // 분담율_브랜드

    @IIrtFldMeta(size = 11)
    @JsonProperty("Amount")
    private String Amount; // 결제금액
}
