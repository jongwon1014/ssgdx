package com.shinsegae.ssgdx.rst.model.comtr;

import java.util.ArrayList;
import java.util.List;

import com.shinsegae.ssgdx.ldi.util.IEnumComIrt.EnmTranFieldType;
import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranGiftPmItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 11)
    @JsonProperty("CashTotAmt")
    private String CashTotAmt; // 현금판매금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("CashPmAmt")
    private String CashPmAmt; // 현금판매PM

    @IIrtFldMeta(size = 5)
    @JsonProperty("CashRate")
    private String CashRate; // 현금판매PM지급율

    @IIrtFldMeta(size = 11)
    @JsonProperty("CardTotAmt")
    private String CardTotAmt; // 카드판매금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("CardPmAmt")
    private String CardPmAmt; // 카드판매PM

    @IIrtFldMeta(size = 5)
    @JsonProperty("CardRate")
    private String CardRate; // 카드판매PM지급율

    @IIrtFldMeta(size = 11)
    @JsonProperty("TotAmt")
    private String TotAmt; // 합계판매금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("TotPmAmt")
    private String TotPmAmt; // 합계판매PM

    @IIrtFldMeta(size = 5)
    @JsonProperty("TotRate")
    private String TotRate; // 합계판매PM지급율

    @IIrtFldMeta(size = 1)
    @JsonProperty("PayFlag")
    private String PayFlag; // PM예외지급플래그

    @IIrtFldMeta(size = 2, isLoopCount = true)
    @JsonProperty("ItemCnt")
    private String ItemCnt; // 아이템수량

    @JsonProperty("ItemList")
    @IIrtFldMeta(dType = EnmTranFieldType.LIST)
    private List<TGPMIItemList> ItemList = new ArrayList<TGPMIItemList>(); // ItemList
                                                                           // 반복구간

    /**
     * ItemList 반복구간
     */
    @Getter
    @Setter
    private static class TGPMIItemList {

        @IIrtFldMeta(size = 8)
        @JsonProperty("SaleDate")
        private String SaleDate; // 영업일자

        @IIrtFldMeta(size = 4)
        @JsonProperty("StoreCode")
        private String StoreCode; // 점포코드

        @IIrtFldMeta(size = 4)
        @JsonProperty("PosNo")
        private String PosNo; // POS번호

        @IIrtFldMeta(size = 4)
        @JsonProperty("TranNo")
        private String TranNo; // 트란번호

        @IIrtFldMeta(size = 11)
        @JsonProperty("TotalAmount")
        private String TotalAmount; // 매출액
    }
}
