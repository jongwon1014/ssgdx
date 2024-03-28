package com.shinsegae.ssgdx.rst.model.newtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranCashTerAmtItemDxN {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

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

    @IIrtFldMeta(size = 20)
    @JsonProperty("ProdCode")
    private String ProdCode; // 대표상품코드

    @IIrtFldMeta(size = 10)
    @JsonProperty("ShopCd")
    private String ShopCd; // 매장코드

    @IIrtFldMeta(size = 11)
    @JsonProperty("TotalAmount")
    private String TotalAmount; // 매출액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InCashAmount")
    private String InCashAmount; // 현금입금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("OutCashAmount")
    private String OutCashAmount; // 현금출금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InGiftAmount")
    private String InGiftAmount; // 자사상품권 입금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("OutGiftAmount")
    private String OutGiftAmount; // 자사상품권 출금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InEtcGiftAmount")
    private String InEtcGiftAmount; // 타사상품권 입금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InTourGiftAmount")
    private String InTourGiftAmount; // 국민관광상품권 입금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InRentGiftAmount")
    private String InRentGiftAmount; // 임대상품권 입금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InCosmeticGiftAmount")
    private String InCosmeticGiftAmount; // 화장품상품권 입금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InSportsGiftAmount")
    private String InSportsGiftAmount; // 스포츠상품권 입금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InVoucherGiftAmount")
    private String InVoucherGiftAmount; // 스페셜바우처 입금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InPromoCashAmount")
    private String InPromoCashAmount; // 사은행사 현금 입금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InPromoGiftAmount")
    private String InPromoGiftAmount; // 사은행사 상품권 입금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InCheckAmount")
    private String InCheckAmount; // 수표입금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InDollarAmount")
    private String InDollarAmount; // 달러입금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InYenAmount")
    private String InYenAmount; // 엔화입금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InEuroAmount")
    private String InEuroAmount; // 유로입금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("InYuanAmount")
    private String InYuanAmount; // 위안입금액

    @IIrtFldMeta(size = 1)
    @JsonProperty("EndFlag")
    private String EndFlag; // 입출금완료여부
}
