package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranCashTerInOutOrgItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 1)
    @JsonProperty("ItemType")
    private String ItemType; // 거래타입

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

    @IIrtFldMeta(size = 6)
    @JsonProperty("CashierNo")
    private String CashierNo; // 캐셔번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("TranType")
    private String TranType; // 거래구분

    @IIrtFldMeta(size = 11)
    @JsonProperty("TotalAmount")
    private String TotalAmount; // 매출액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InCashReceivedAmount")
    private String InCashReceivedAmount; // 현금 입금한 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("OutCashReceivedAmount")
    private String OutCashReceivedAmount; // 현금 출금한 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InGiftReceivedAmount")
    private String InGiftReceivedAmount; // 상품권 입금한 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("OutGiftReceivedAmount")
    private String OutGiftReceivedAmount; // 상품권 출금한 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InEtcGiftReceivedAmount")
    private String InEtcGiftReceivedAmount; // 타사상품권 입금한 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InTourGiftReceivedAmount")
    private String InTourGiftReceivedAmount; // 국민관광상품권 입금한 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InRentGiftReceivedAmount")
    private String InRentGiftReceivedAmount; // 임대상품권 입금한 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InCosmeticGiftReceivedAmount")
    private String InCosmeticGiftReceivedAmount; // 화장품상품권 입금한 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InSportsGiftReceivedAmount")
    private String InSportsGiftReceivedAmount; // 스포츠상품권 입금한 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InVoucherGiftReceivedAmount")
    private String InVoucherGiftReceivedAmount; // 스페셜바우처 입금한 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InCheckReceivedAmount")
    private String InCheckReceivedAmount; // 수표 입금한 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InDollarReceivedAmount")
    private String InDollarReceivedAmount; // 달러 입금한 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InYenReceivedAmount")
    private String InYenReceivedAmount; // 엔화 입금한 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InEuroReceivedAmount")
    private String InEuroReceivedAmount; // 유로 입금한 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InYuanReceivedAmount")
    private String InYuanReceivedAmount; // 위안 입금한 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InPromoCashReceivedAmount")
    private String InPromoCashReceivedAmount; // 사은행사 현금 입금한 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InPromoGiftReceivedAmount")
    private String InPromoGiftReceivedAmount; // 사은행사 상품권 입금한 금액
}
