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
public class TranGiftKioskErrorItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 3)
    @JsonProperty("DeviceType")
    private String DeviceType; // 정산기TYPE

    @IIrtFldMeta(size = 8)
    @JsonProperty("DeviceVersion")
    private String DeviceVersion; // 정산기버전

    @IIrtFldMeta(size = 1)
    @JsonProperty("DeviceStatus")
    private String DeviceStatus; // 기기상태

    @IIrtFldMeta(size = 2, isLoopCount = true)
    @JsonProperty("ItemCnt")
    private String ItemCnt; // 반복건수

    @JsonProperty("ItemList")
    @IIrtFldMeta(dType = EnmTranFieldType.LIST)
    private List<TGKEIItemList> ItemList = new ArrayList<TGKEIItemList>(); // ItemList
                                                                           // 반복

    @Getter
    @Setter
    private static class TGKEIItemList {

        @IIrtFldMeta(size = 20)
        @JsonProperty("DeviceName")
        private String DeviceName; // 디바이스명

        @IIrtFldMeta(size = 1)
        @JsonProperty("DeviceType")
        private String DeviceType; // 장애구분

        @IIrtFldMeta(size = 7)
        @JsonProperty("DeviceCode")
        private String DeviceCode; // 장애코드
    }
}
