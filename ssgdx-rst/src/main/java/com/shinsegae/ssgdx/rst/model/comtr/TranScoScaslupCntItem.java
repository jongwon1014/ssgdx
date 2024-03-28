package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranScoScaslupCntItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 4)
    @JsonProperty("TotScanCount")
    private String TotScanCount; // 총스캔횟수

    @IIrtFldMeta(size = 4)
    @JsonProperty("TotZWScanCount")
    private String TotZWScanCount; // ZeroWeight상품스캔횟수

    @IIrtFldMeta(size = 4)
    @JsonProperty("ScaslUpCount")
    private String ScaslUpCount; // 저울증가횟수

    @IIrtFldMeta(size = 100)
    @JsonProperty("Filler")
    private String Filler; // 예비
}
