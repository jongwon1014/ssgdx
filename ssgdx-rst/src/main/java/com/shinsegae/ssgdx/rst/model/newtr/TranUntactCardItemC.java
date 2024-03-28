package com.shinsegae.ssgdx.rst.model.newtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranUntactCardItemC {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 8)
    @JsonProperty("ContactlessOrdDate")
    private String ContactlessOrdDate; // 비대면 주문일자

    @IIrtFldMeta(size = 4)
    @JsonProperty("ContactlessOrdPosNo")
    private String ContactlessOrdPosNo; // 비대면 주문 POS번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("ContactlessOrdTranNo")
    private String ContactlessOrdTranNo; // 비대면 주문 TRAN번호
    
    @IIrtFldMeta(size = 200)
    @JsonProperty("ShopName")
    private String ShopName; // 매장명

    @IIrtFldMeta(size = 50)
    @JsonProperty("Filler")
    private String Filler; // 예비
}
