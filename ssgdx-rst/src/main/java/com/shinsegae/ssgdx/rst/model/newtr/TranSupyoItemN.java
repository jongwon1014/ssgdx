package com.shinsegae.ssgdx.rst.model.newtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranSupyoItemN {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemSeqNo")
    private String ItemSeqNo; // 아이템Seqno

    @IIrtFldMeta(size = 8)
    @JsonProperty("CheckNo")
    private String CheckNo; // 수표번호

    @IIrtFldMeta(size = 6)
    @JsonProperty("BankCode")
    private String BankCode; // 발행점코드

    @IIrtFldMeta(size = 8)
    @JsonProperty("IssueDate")
    private String IssueDate; // 발행일자

    @IIrtFldMeta(size = 2)
    @JsonProperty("AmountCode")
    private String AmountCode; // 권종코드

    @IIrtFldMeta(size = 12)
    @JsonProperty("AccountSeqNo")
    private String AccountSeqNo; // 수표계좌일련번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("FaceAmount")
    private String FaceAmount; // 액면금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("CashChange")
    private String CashChange; // 수표 현금 거스름

    @IIrtFldMeta(size = 50)
    @JsonProperty("Filler")
    private String Filler; // 예비
}
