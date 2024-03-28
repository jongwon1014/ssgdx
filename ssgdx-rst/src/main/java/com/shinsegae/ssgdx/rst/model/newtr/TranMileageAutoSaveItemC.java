package com.shinsegae.ssgdx.rst.model.newtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranMileageAutoSaveItemC {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 10)
    @JsonProperty("CustId")
    private String CustId; // 고객CUSTID

    @IIrtFldMeta(size = 6)
    @JsonProperty("EvnMngYm")
    private String EvnMngYm; // 행사관리년월

    @IIrtFldMeta(size = 9)
    @JsonProperty("EvnMngNo")
    private String EvnMngNo; // 행사관리번호

    @IIrtFldMeta(size = 12)
    @JsonProperty("MlgPoint")
    private String MlgPoint; // 금회적립 예상 마일리지

    @IIrtFldMeta(size = 50)
    @JsonProperty("Filler")
    private String Filler; // 예비
}
