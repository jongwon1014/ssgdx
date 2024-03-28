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
public class TranCalcItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @JsonProperty("CalcList")
    @IIrtFldMeta(dType = EnmTranFieldType.LIST)
    private List<TranCalcItemCalcList> CalcList = new ArrayList<TranCalcItemCalcList>(); // CloseList
                                                                                         // (반복)

    /**
     * CalcList (반복)
     */
    @Getter
    @Setter
    private static class TranCalcItemCalcList {

        @IIrtFldMeta(size = 4)
        @JsonProperty("CloseId")
        private String CloseId; // 정산 항목 코드

        @IIrtFldMeta(size = 12)
        @JsonProperty("Amount")
        private String Amount; // 금액

        @IIrtFldMeta(size = 4)
        @JsonProperty("Count")
        private String Count; // 건수

        @IIrtFldMeta(size = 4)
        @JsonProperty("CardCode")
        private String CardCode; // 카드사
    }
}
