package com.shinsegae.ssgdx.rst.model.newtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranHeaderN {

    @IIrtFldMeta(size = 6)
    @JsonProperty("MsgLength")
    private String MsgLength; // 전문 Length

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 8)
    @JsonProperty("SaleDate")
    private String SaleDate; // 영업일자

    @IIrtFldMeta(size = 3)
    @JsonProperty("StoreNo")
    private String StoreNo; // 점포코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("PosNo")
    private String PosNo; // POS번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("TranNo")
    private String TranNo; // 거래번호

    @IIrtFldMeta(size = 8)
    @JsonProperty("SysDate")
    private String SysDate; // 거래일자 (시스템)

    @IIrtFldMeta(size = 6)
    @JsonProperty("SysTime")
    private String SysTime; // 거래시간 (시스템)

    @IIrtFldMeta(size = 1)
    @JsonProperty("TranType")
    private String TranType; // 거래구분(Ftype)

    @IIrtFldMeta(size = 1)
    @JsonProperty("CancelType")
    private String CancelType; // 취소구분

    @IIrtFldMeta(size = 2)
    @JsonProperty("TranKind")
    private String TranKind; // 거래종류(TRAN구분)

    @IIrtFldMeta(size = 6)
    @JsonProperty("CashierNo")
    private String CashierNo; // 캐셔번호

    @IIrtFldMeta(size = 8)
    @JsonProperty("OrgTranDate")
    private String OrgTranDate; // 원매출일

    @IIrtFldMeta(size = 4)
    @JsonProperty("OrgPosNo")
    private String OrgPosNo; // 원POS번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("OrgTranNo")
    private String OrgTranNo; // 원거래번호

    @IIrtFldMeta(size = 6)
    @JsonProperty("OrgCashierNo")
    private String OrgCashierNo; // 원거래 캐셔번호

    @IIrtFldMeta(size = 2)
    @JsonProperty("ReasonCode")
    private String ReasonCode; // 반품/오타 사유

    @IIrtFldMeta(size = 10)
    @JsonProperty("TotalAmount")
    private String TotalAmount; // 총매출

    @IIrtFldMeta(size = 8)
    @JsonProperty("DiscountAmount")
    private String DiscountAmount; // 에누리

    @IIrtFldMeta(size = 1)
    @JsonProperty("CashFlag")
    private String CashFlag; // 현금 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("GiftFlag")
    private String GiftFlag; // 상품권 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("PpFlag")
    private String PpFlag; // PP 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("CouponFlag")
    private String CouponFlag; // 쿠폰 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("CardFlag")
    private String CardFlag; // 카드 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("DivMonthFlag")
    private String DivMonthFlag; // 카드할부 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("PointUseFlag")
    private String PointUseFlag; // 포인트사용 여부

    @IIrtFldMeta(size = 1)
    @JsonProperty("DebitFlag")
    private String DebitFlag; // 직불카드 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("IdCardFlag")
    private String IdCardFlag; // 현금ID카드 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("KtCardFlag")
    private String KtCardFlag; // 선불카드 여부

    @IIrtFldMeta(size = 1)
    @JsonProperty("SaleGiftFlag")
    private String SaleGiftFlag; // 사은품반품 여부

    @IIrtFldMeta(size = 1)
    @JsonProperty("CashReceiptFlag")
    private String CashReceiptFlag; // 현금영수증 발행여부

    @IIrtFldMeta(size = 1)
    @JsonProperty("DiscountCouponFlag")
    private String DiscountCouponFlag; // 에누리쿠폰 수취 여부

    @IIrtFldMeta(size = 2)
    @JsonProperty("MemberFlag")
    private String MemberFlag; // 카드회원구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("DiscountCheckFlag")
    private String DiscountCheckFlag; // 에누리적정 적용

    @IIrtFldMeta(size = 2)
    @JsonProperty("DiscountRate")
    private String DiscountRate; // 에누리 율

    @IIrtFldMeta(size = 2)
    @JsonProperty("CustomerType")
    private String CustomerType; // 자동 에누리 적용 고객 타입

    @IIrtFldMeta(size = 3)
    @JsonProperty("PointNoLast3")
    private String PointNoLast3; // Swallet 포인트 카드 뒤 3자리

    @IIrtFldMeta(size = 1)
    @JsonProperty("ParkingFlag")
    private String ParkingFlag; // 주차Flag 및 전자지갑 Flag

    @IIrtFldMeta(size = 2)
    @JsonProperty("ForeignType")
    private String ForeignType; // 외국인유형코드

    @IIrtFldMeta(size = 1)
    @JsonProperty("PosType")
    private String PosType; // TM구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("SPointFlag")
    private String SPointFlag; // S-POINT 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("ElecCouponFlag")
    private String ElecCouponFlag; // 전자쿠폰 존재체크

    @IIrtFldMeta(size = 1)
    @JsonProperty("VipMileageSendFlag")
    private String VipMileageSendFlag; // VIP 마일리지 송신 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("SPointSendFlag")
    private String SPointSendFlag; // S-Point 송신 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("SaleKind")
    private String SaleKind; // 업장구분

    @IIrtFldMeta(size = 8)
    @JsonProperty("ExOrgSaleDate")
    private String ExOrgSaleDate; // 매출후 반품/취소후 반품 원 매출일

    @IIrtFldMeta(size = 4)
    @JsonProperty("ExOrgPosNo")
    private String ExOrgPosNo; // 매출후 반품/취소후 반품 원 POS번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("ExOrgTrdNo")
    private String ExOrgTrdNo; // 매출후 반품/취소후 반품 원 거래번호

    @IIrtFldMeta(size = 6)
    @JsonProperty("ExOrgCashierNo")
    private String ExOrgCashierNo; // 매출후 반품/취소후 반품 원 거래 캐셔번호

    @IIrtFldMeta(size = 20)
    @JsonProperty("VersionInfo1")
    private String VersionInfo1; // 버전1

    @IIrtFldMeta(size = 20)
    @JsonProperty("VersionInfo2")
    private String VersionInfo2; // 버전2

    @IIrtFldMeta(size = 20)
    @JsonProperty("VersionInfo3")
    private String VersionInfo3; // 버전3

    @IIrtFldMeta(size = 1)
    @JsonProperty("HwType")
    private String HwType; // 하드웨어 구성

    @IIrtFldMeta(size = 1)
    @JsonProperty("BrandFlag")
    private String BrandFlag; // 임대구분

    @IIrtFldMeta(size = 3)
    @JsonProperty("NationalCode")
    private String NationalCode; // 국가코드 추가

    @IIrtFldMeta(size = 1)
    @JsonProperty("EmpAuthSendFlag")
    private String EmpAuthSendFlag; // 사원인증 송신 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("CashIcSendFlag")
    private String CashIcSendFlag; // 현금 IC 송신 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("MobileEgiftSendFlag")
    private String MobileEgiftSendFlag; // 모바일 전자 상품권 송신 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("IntegPaySendFlag")
    private String IntegPaySendFlag; // 통합 결제 송신 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("IntegCardSendFlag")
    private String IntegCardSendFlag; // 통합 결제 카드 송신 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("CardOffLineFlag")
    private String CardOffLineFlag; // 신용카드 OFF-LINE 승인 구분

    @IIrtFldMeta(size = 4)
    @JsonProperty("FoodOrderNo")
    private String FoodOrderNo; // 식당가 주문번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("FoodWaitNo")
    private String FoodWaitNo; // 식당가 대기번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("MappingFlag")
    private String MappingFlag; // 매핑키 사용 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("RefundFlag")
    private String RefundFlag; // 즉시환급 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("ElecReceiptFlag")
    private String ElecReceiptFlag; // 전자영수증 발행 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("LTEUseFlag")
    private String LTEUseFlag; // P_LTE 사용 여부 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("LTEStatusFlag")
    private String LTEStatusFlag; // LTE 상태 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("IsCulture")
    private String IsCulture; // 도서문화공연 FLAG

    @IIrtFldMeta(size = 1)
    @JsonProperty("CashTerminalUseFlag")
    private String CashTerminalUseFlag; // 캐쉬 터미널 사용 FLAG

    @IIrtFldMeta(size = 1)
    @JsonProperty("CashTerminalTrnYn")
    private String CashTerminalTrnYn; // 캐쉬 터미널 대상 거래

    @IIrtFldMeta(size = 1)
    @JsonProperty("Claimant")
    private String Claimant; // 청구할인 여부

    @IIrtFldMeta(size = 1)
    @JsonProperty("HolidayDeliveryFlag")
    private String HolidayDeliveryFlag; // 명절 배송상품 존재여부

    @IIrtFldMeta(size = 1)
    @JsonProperty("MarketMemFlag")
    private String MarketMemFlag; // 식품멤버십 대상여부

    @IIrtFldMeta(size = 1)
    @JsonProperty("SmartOrderFlag")
    private String SmartOrderFlag; // 스마트오더 대상여부

    @IIrtFldMeta(size = 2)
    @JsonProperty("DeliveryReturnCode")
    private String DeliveryReturnCode; // 명절배송 반품사유

    @IIrtFldMeta(size = 1)
    @JsonProperty("ChicorEnuriYn")
    private String ChicorEnuriYn; // 시코르 에누리 적용 여부

    @IIrtFldMeta(size = 1)
    @JsonProperty("SmpEnuriYn")
    private String SmpEnuriYn; // 스마일페이 할인 여부

    @IIrtFldMeta(size = 50)
    @JsonProperty("CustType")
    private String CustType; // 고객 유형 코드

    @IIrtFldMeta(size = 100)
    @JsonProperty("Filler")
    private String Filler; // 예비
}
