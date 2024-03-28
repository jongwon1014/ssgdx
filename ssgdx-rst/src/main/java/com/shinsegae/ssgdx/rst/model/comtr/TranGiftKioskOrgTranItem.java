package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranGiftKioskOrgTranItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 8)
    @JsonProperty("OrgTranDate")
    private String OrgTranDate; // 원매출일

    @IIrtFldMeta(size = 4)
    @JsonProperty("OrgPosNo")
    private String OrgPosNo; // 원POS번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("OrgTranNo")
    private String OrgTranNo; // 원거래번호

    @IIrtFldMeta(size = 5)
    @JsonProperty("Filler")
    private String Filler; // 예비
}
