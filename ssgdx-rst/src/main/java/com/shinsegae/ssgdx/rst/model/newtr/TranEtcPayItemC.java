package com.shinsegae.ssgdx.rst.model.newtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranEtcPayItemC {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 2)
    @JsonProperty("EtcPayCode")
    private String EtcPayCode; // 결제코드

    @IIrtFldMeta(size = 12)
    @JsonProperty("Amount")
    private String Amount; // 결제금액

    @IIrtFldMeta(size = 50)
    @JsonProperty("Filler")
    private String Filler; // 예비
}
