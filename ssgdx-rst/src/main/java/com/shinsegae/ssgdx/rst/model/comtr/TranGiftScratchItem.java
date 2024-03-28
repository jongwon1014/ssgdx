package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranGiftScratchItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 1)
    @JsonProperty("OffLineFlag")
    private String OffLineFlag; // 온/오프라인구분

    @IIrtFldMeta(size = 4)
    @JsonProperty("CdNo")
    private String CdNo; // CD번호

    @IIrtFldMeta(size = 2)
    @JsonProperty("TranType")
    private String TranType; // 전환타입

    @IIrtFldMeta(size = 2)
    @JsonProperty("TradeType")
    private String TradeType; // 요청타입

    @IIrtFldMeta(size = 2)
    @JsonProperty("MethodType")
    private String MethodType; // 거래구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("TrackCheck")
    private String TrackCheck; // TRACK체크

    @IIrtFldMeta(size = 13)
    @JsonProperty("GiftNo")
    private String GiftNo; // 스크래치상품권 (시작)번호

    @IIrtFldMeta(size = 13)
    @JsonProperty("EndGiftNo")
    private String EndGiftNo; // 스크래치상품권 종료번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("MoneyType")
    private String MoneyType; // 권종코드

    @IIrtFldMeta(size = 3)
    @JsonProperty("GiftCount")
    private String GiftCount; // 상품권개수

    @IIrtFldMeta(size = 11)
    @JsonProperty("TotalAmount")
    private String TotalAmount; // 상품권합계

    @IIrtFldMeta(size = 1)
    @JsonProperty("SpecialGubun")
    private String SpecialGubun; // 미수수료 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("UseGubun")
    private String UseGubun; // 사용구분

    @IIrtFldMeta(size = 10)
    @JsonProperty("Filler")
    private String Filler; // 예비
}
