package com.shinsegae.ssgdx.rst.model.newtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranCashTerExpenItemN {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 10)
    @JsonProperty("ExpsAplyDocTpCode")
    private String ExpsAplyDocTpCode; // 비용신청문서유형코드

    @IIrtFldMeta(size = 16)
    @JsonProperty("ExpsAplyDocNo")
    private String ExpsAplyDocNo; // 비용신청문서번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("ExpsAplyDocNoSno")
    private String ExpsAplyDocNoSno; // 비용신청문서번호일련번호

    @IIrtFldMeta(size = 3)
    @JsonProperty("PdimSno")
    private String PdimSno; // 품목일련번호

    @IIrtFldMeta(size = 12)
    @JsonProperty("ExpsWdlAmt")
    private String ExpsWdlAmt; // 비용출금금액

    @IIrtFldMeta(size = 50)
    @JsonProperty("Filler")
    private String Filler; // 예비
}
