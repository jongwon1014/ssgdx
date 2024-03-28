package com.shinsegae.ssgdx.rst.model.oldtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranGoodsItemO {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 6)
    @JsonProperty("MdCode")
    private String MdCode; // MD코드

    @IIrtFldMeta(size = 5)
    @JsonProperty("ClassCode")
    private String ClassCode; // 클래스 (협력회사코드 : CPCO_CD)

    @IIrtFldMeta(size = 1)
    @JsonProperty("EventCode")
    private String EventCode; // 행사구분

    @IIrtFldMeta(size = 4)
    @JsonProperty("CategoryCode")
    private String CategoryCode; // 품목단축 (상품분류단축코드 : PDCT_CL_CD)

    @IIrtFldMeta(size = 1)
    @JsonProperty("CouponFlag")
    private String CouponFlag; // 쿠폰매가변경 여부

    @IIrtFldMeta(size = 13)
    @JsonProperty("PluCode")
    private String PluCode; // 단품코드 (PIPD_CD)

    @IIrtFldMeta(size = 20)
    @JsonProperty("CouponCode")
    private String CouponCode; // 쿠폰코드

    @IIrtFldMeta(size = 1)
    @JsonProperty("PluType")
    private String PluType; // 단품구분필드

    @IIrtFldMeta(size = 1)
    @JsonProperty("ProdFlag")
    private String ProdFlag; // 상품구분

    @IIrtFldMeta(size = 4)
    @JsonProperty("Margin")
    private String Margin; // 마진

    @IIrtFldMeta(size = 9)
    @JsonProperty("OldPrice")
    private String OldPrice; // 마스터 단가

    @IIrtFldMeta(size = 9)
    @JsonProperty("ChangePrice")
    private String ChangePrice; // 매가변경후금액

    @IIrtFldMeta(size = 9)
    @JsonProperty("CouponPrice")
    private String CouponPrice; // 쿠폰매가변경후금액

    @IIrtFldMeta(size = 2)
    @JsonProperty("EventSaleFlag")
    private String EventSaleFlag; // 할인특매구분

    @IIrtFldMeta(size = 2)
    @JsonProperty("EventSaleRate")
    private String EventSaleRate; // 할인특매율

    @IIrtFldMeta(size = 9)
    @JsonProperty("EventSaleAmount")
    private String EventSaleAmount; // 할인금액

    @IIrtFldMeta(size = 9)
    @JsonProperty("Price")
    private String Price; // 단가

    @IIrtFldMeta(size = 4)
    @JsonProperty("Qty")
    private String Qty; // 수량

    @IIrtFldMeta(size = 9)
    @JsonProperty("Amount")
    private String Amount; // 금액

    @IIrtFldMeta(size = 2)
    @JsonProperty("DiscountFlag")
    private String DiscountFlag; // 에누리구분

    @IIrtFldMeta(size = 2)
    @JsonProperty("DiscountRate")
    private String DiscountRate; // 에누리율

    @IIrtFldMeta(size = 8)
    @JsonProperty("DiscountAmount")
    private String DiscountAmount; // 에누리금액

    @IIrtFldMeta(size = 9)
    @JsonProperty("NetAmount")
    private String NetAmount; // 순매출

    @IIrtFldMeta(size = 2)
    @JsonProperty("TaxFlag")
    private String TaxFlag; // 과면세구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("DeliveryFlag")
    private String DeliveryFlag; // 예약구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("CancelFlag")
    private String CancelFlag; // 지정취소구분

    @IIrtFldMeta(size = 8)
    @JsonProperty("OrgSaleDate")
    private String OrgSaleDate; // 원발생일

    @IIrtFldMeta(size = 1)
    @JsonProperty("SaleUnit")
    private String SaleUnit; // 신선상품단위

    @IIrtFldMeta(size = 5)
    @JsonProperty("UnitPrice")
    private String UnitPrice; // 신선상품단가

    @IIrtFldMeta(size = 20)
    @JsonProperty("ScanCode1")
    private String ScanCode1; // 바코드스캔코드1

    @IIrtFldMeta(size = 20)
    @JsonProperty("ScanCode2")
    private String ScanCode2; // 바코드스캔코드2

    @IIrtFldMeta(size = 1)
    @JsonProperty("PriceManualFlag")
    private String PriceManualFlag; // 가격입력구분

    @IIrtFldMeta(size = 4)
    @JsonProperty("MdTypeCode")
    private String MdTypeCode; // MD유형코드

    @IIrtFldMeta(size = 3)
    @JsonProperty("ItemSeq")
    private String ItemSeq; // 아이템 SEQ

    @IIrtFldMeta(size = 1)
    @JsonProperty("IsFreebie")
    private String IsFreebie; // 시코르 증정구분

    @IIrtFldMeta(size = 3)
    @JsonProperty("ChicorTranSeq")
    private String ChicorTranSeq; // 시코르 아이템 순번

    @IIrtFldMeta(size = 50)
    @JsonProperty("LinkCode")
    private String LinkCode; // 업체바코드

    @IIrtFldMeta(size = 50)
    @JsonProperty("CareLabel")
    private String CareLabel; // 케어라벨

    @IIrtFldMeta(size = 1)
    @JsonProperty("IsCareLabel")
    private String IsCareLabel; // 케어라벨구분자

    @IIrtFldMeta(size = 1)
    @JsonProperty("BrandPluFlag")
    private String BrandPluFlag; // 특정단품구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("BrandPluSet")
    private String BrandPluSet; // 세트구분

    @IIrtFldMeta(size = 2)
    @JsonProperty("PriceChangeReason")
    private String PriceChangeReason; // 매가변경사유

    @IIrtFldMeta(size = 1)
    @JsonProperty("HolidayDeliveryFlag")
    private String HolidayDeliveryFlag; // 명절배송대상 상품구분

    @IIrtFldMeta(size = 3)
    @JsonProperty("DeliveryProductCnt")
    private String DeliveryProductCnt; // 배송신청 상품 수

    @IIrtFldMeta(size = 3)
    @JsonProperty("WillCallProductCnt")
    private String WillCallProductCnt; // 현장수령 상품 수

    @IIrtFldMeta(size = 1)
    @JsonProperty("FoodMembershipFlag")
    private String FoodMembershipFlag; // 식품멤버십 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("ChicorEnuri_Yn")
    private String ChicorEnuri_Yn; // 시코르 에누리 적용여부

    @IIrtFldMeta(size = 8)
    @JsonProperty("EnuriAmt")
    private String EnuriAmt; // 상품 에누리 금액

    @IIrtFldMeta(size = 8)
    @JsonProperty("ChicorEnuriAmt")
    private String ChicorEnuriAmt; // 시코르 에누리 금액

    @IIrtFldMeta(size = 66)
    @JsonProperty("Filler")
    private String Filler; // 상품 예비
}
