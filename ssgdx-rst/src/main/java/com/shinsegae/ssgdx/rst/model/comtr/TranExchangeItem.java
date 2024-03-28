package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranExchangeItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 8)
    @JsonProperty("ExcSaleDate")
    private String ExcSaleDate; // 교환거래(-) 매출일자

    @IIrtFldMeta(size = 4)
    @JsonProperty("ExcStoreCode")
    private String ExcStoreCode; // 교환거래(-) 점포코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ExcPosNo")
    private String ExcPosNo; // 교환거래(-) POS번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("ExcTranNo")
    private String ExcTranNo; // 교환거래(-) 거래번호

    @IIrtFldMeta(size = 6)
    @JsonProperty("ExcCashierNo")
    private String ExcCashierNo; // 교환거래(-) 캐셔번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("CancelSaleAmt")
    private String CancelSaleAmt; // 강제 취소 거래 매출 금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("NewSaleAmt")
    private String NewSaleAmt; // 강제 취소 후 신규거래 매출 금액

    @IIrtFldMeta(size = 50)
    @JsonProperty("Filler")
    private String Filler; // 예비
}
