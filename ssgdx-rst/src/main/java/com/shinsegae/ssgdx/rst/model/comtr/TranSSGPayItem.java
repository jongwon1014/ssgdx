package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranSSGPayItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // 전문 ID

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLen")
    private String ItemLen; // 전문 길이

    @IIrtFldMeta(size = 8)
    @JsonProperty("SendDate")
    private String SendDate; // 전문 전송일자

    @IIrtFldMeta(size = 24)
    @JsonProperty("SendUniqNo")
    private String SendUniqNo; // 전송 거래고유번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("MsgGubun")
    private String MsgGubun; // 요청구분

    @IIrtFldMeta(size = 2)
    @JsonProperty("TranType")
    private String TranType; // 거래 TYPE

    @IIrtFldMeta(size = 4)
    @JsonProperty("ComCode")
    private String ComCode; // 회사코드

    @IIrtFldMeta(size = 15)
    @JsonProperty("TermId")
    private String TermId; // 터미널아이디

    @IIrtFldMeta(size = 8)
    @JsonProperty("SaleDate")
    private String SaleDate; // 영업일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("SaleTime")
    private String SaleTime; // 영업시간

    @IIrtFldMeta(size = 10)
    @JsonProperty("StoreNo")
    private String StoreNo; // 점코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("TMNo")
    private String TMNo; // 포스 번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("ShopNo")
    private String ShopNo; // 매장번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("CDNo")
    private String CDNo; // CD 번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("TranNo")
    private String TranNo; // 거래 번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("CashierNo")
    private String CashierNo; // 캐셔 번호

    @IIrtFldMeta(size = 8)
    @JsonProperty("PosDate")
    private String PosDate; // POS시스템일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("PosTime")
    private String PosTime; // POS시스템시간

    @IIrtFldMeta(size = 6)
    @JsonProperty("NormalGubun")
    private String NormalGubun; // 정상예외구분

    @IIrtFldMeta(size = 4)
    @JsonProperty("BuyFirmCode")
    private String BuyFirmCode; // 매입사

    @IIrtFldMeta(size = 30)
    @JsonProperty("BuyFirmNM")
    private String BuyFirmNM; // 매입사명

    @IIrtFldMeta(size = 4)
    @JsonProperty("IssueFirmCode")
    private String IssueFirmCode; // 발행사

    @IIrtFldMeta(size = 30)
    @JsonProperty("IssueFirmNM")
    private String IssueFirmNM; // 발행사명

    @IIrtFldMeta(size = 8)
    @JsonProperty("CardSysDate")
    private String CardSysDate; // 카드사 요청일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("CardSysTime")
    private String CardSysTime; // 카드사 요청시간

    @IIrtFldMeta(size = 20)
    @JsonProperty("CardUniqNo")
    private String CardUniqNo; // 카드사 요청 고유번호

    @IIrtFldMeta(size = 20)
    @JsonProperty("CardMchNo")
    private String CardMchNo; // 카드사 가맹점 번호

    @IIrtFldMeta(size = 20)
    @JsonProperty("ComUniqNo")
    private String ComUniqNo; // 회사별 요청자 정보

    @IIrtFldMeta(size = 8)
    @JsonProperty("JumpoSysDate")
    private String JumpoSysDate; // 점포서버 전문전송일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("JumpoSysTime")
    private String JumpoSysTime; // 점포서버 전문전송시간

    @IIrtFldMeta(size = 4)
    @JsonProperty("RespCode")
    private String RespCode; // 응답코드

    @IIrtFldMeta(size = 60)
    @JsonProperty("RespMsg")
    private String RespMsg; // 응답메시지

    @IIrtFldMeta(size = 3)
    @JsonProperty("BankCode")
    private String BankCode; // 은행코드

    @IIrtFldMeta(size = 30)
    @JsonProperty("BankNm")
    private String BankNm; // 은행사명

    @IIrtFldMeta(size = 4)
    @JsonProperty("BankVanFlag")
    private String BankVanFlag; // 금융VAN 구분

    @IIrtFldMeta(size = 20)
    @JsonProperty("PlatformMId")
    private String PlatformMId; // 플랫폼 연동 가맹점 ID

    @IIrtFldMeta(size = 10)
    @JsonProperty("CARD_EVENT_KEY")
    private String CARD_EVENT_KEY; // BMP 카드행사 KEY

    @IIrtFldMeta(size = 74)
    @JsonProperty("HeadFiller")
    private String HeadFiller; // 헤더예비필드

    @IIrtFldMeta(size = 64)
    @JsonProperty("DelegateBarcodeNo")
    private String DelegateBarcodeNo; // 통합바코드번호

    @IIrtFldMeta(size = 50)
    @JsonProperty("ReceiptNo")
    private String ReceiptNo; // 영수증 번호

    @IIrtFldMeta(size = 50)
    @JsonProperty("OrgReceiptNo")
    private String OrgReceiptNo; // 원거래 영수증번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("EmpNoPlatYn")
    private String EmpNoPlatYn; // 사원증 Platform 응답 여부

    @IIrtFldMeta(size = 1)
    @JsonProperty("EmpNoYN")
    private String EmpNoYN; // 사원증 활용 여부

    @IIrtFldMeta(size = 32)
    @JsonProperty("EmpIdNo")
    private String EmpIdNo; // 사원증번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("SPointPlatYn")
    private String SPointPlatYn; // 포인트 Platform 응답 여부

    @IIrtFldMeta(size = 1)
    @JsonProperty("SPointYN")
    private String SPointYN; // 신세계포인트 활용 여부

    @IIrtFldMeta(size = 64)
    @JsonProperty("SPointCardNo")
    private String SPointCardNo; // 신세계포인트카드번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("MGiftCardPlatYN")
    private String MGiftCardPlatYN; // 모바일 Platform 응답 여부

    @IIrtFldMeta(size = 1)
    @JsonProperty("MGiftCardYN")
    private String MGiftCardYN; // 모바일상품권 활용 여부

    @IIrtFldMeta(size = 64)
    @JsonProperty("MGiftCardNo")
    private String MGiftCardNo; // 모바일상품권 번호

    @IIrtFldMeta(size = 12)
    @JsonProperty("MGiftCardUseAmt")
    private String MGiftCardUseAmt; // 모바일상품권 사용 금액

    @IIrtFldMeta(size = 8)
    @JsonProperty("MGiftCardAuthDate")
    private String MGiftCardAuthDate; // 모바일상품권 승인일자

    @IIrtFldMeta(size = 12)
    @JsonProperty("MGiftCardAuthNo")
    private String MGiftCardAuthNo; // 모바일상품권 승인번호

    @IIrtFldMeta(size = 8)
    @JsonProperty("OrgMGiftCardAuthDate")
    private String OrgMGiftCardAuthDate; // 모바일상품권 원승인일자

    @IIrtFldMeta(size = 12)
    @JsonProperty("OrgMGiftCardAuthNo")
    private String OrgMGiftCardAuthNo; // 모바일상품권 원승인번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("CreditCardPlatYN")
    private String CreditCardPlatYN; // 신용카드 Platform 응답 여부

    @IIrtFldMeta(size = 1)
    @JsonProperty("CreditCardYN")
    private String CreditCardYN; // 신용카드 활용 여부

    @IIrtFldMeta(size = 2)
    @JsonProperty("CardCertFlag")
    private String CardCertFlag; // 신용카드 인증 구분

    @IIrtFldMeta(size = 64)
    @JsonProperty("CreditCardNo")
    private String CreditCardNo; // 신용카드 번호

    @IIrtFldMeta(size = 2)
    @JsonProperty("CreditCardInsMon")
    private String CreditCardInsMon; // 할부개월

    @IIrtFldMeta(size = 12)
    @JsonProperty("CreditCardUseAmt")
    private String CreditCardUseAmt; // 신용카드 이용금액

    @IIrtFldMeta(size = 8)
    @JsonProperty("CreditCardAuthDate")
    private String CreditCardAuthDate; // 신용카드 승인일자

    @IIrtFldMeta(size = 20)
    @JsonProperty("CreditCardAuthNo")
    private String CreditCardAuthNo; // 신용카드 승인번호

    @IIrtFldMeta(size = 32)
    @JsonProperty("CreditCardReceiptA")
    private String CreditCardReceiptA; // 영수증 출력A

    @IIrtFldMeta(size = 32)
    @JsonProperty("CreditCardReceiptD")
    private String CreditCardReceiptD; // 영수증 출력D

    @IIrtFldMeta(size = 8)
    @JsonProperty("OrgCreditCardAuthDate")
    private String OrgCreditCardAuthDate; // 신용카드 원승인일자

    @IIrtFldMeta(size = 20)
    @JsonProperty("OrgCreditCardAuthNo")
    private String OrgCreditCardAuthNo; // 신용카드 원승인번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("CashReceiptInfoPlatYN")
    private String CashReceiptInfoPlatYN; // 현금영수증 식별정보 Platform 응답여부

    @IIrtFldMeta(size = 1)
    @JsonProperty("CashReceiptInfoYN")
    private String CashReceiptInfoYN; // 현금영수증/소득공제식별정보 활용여부

    @IIrtFldMeta(size = 32)
    @JsonProperty("CashReceiptInfo")
    private String CashReceiptInfo; // 현금영수증 식별정보

    @IIrtFldMeta(size = 1)
    @JsonProperty("EtcPayYN")
    private String EtcPayYN; // 기타 결제수단 여부

    @IIrtFldMeta(size = 12)
    @JsonProperty("EtcPayAmt")
    private String EtcPayAmt; // 기타 결제 금액

    @IIrtFldMeta(size = 8)
    @JsonProperty("OrgSendDate")
    private String OrgSendDate; // 원거래 전문전송일자

    @IIrtFldMeta(size = 24)
    @JsonProperty("OrgSendUniqNo")
    private String OrgSendUniqNo; // 원거래 전송 거래고유번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("OrgComCD")
    private String OrgComCD; // 원거래 회사코드

    @IIrtFldMeta(size = 8)
    @JsonProperty("OrgSaleDate")
    private String OrgSaleDate; // 원거래 영업일자

    @IIrtFldMeta(size = 10)
    @JsonProperty("OrgStoreNo")
    private String OrgStoreNo; // 원거래 점코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("OrgTMNo")
    private String OrgTMNo; // 원거래 포스 번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("OrgShopNo")
    private String OrgShopNo; // 원거래 매장번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("OrgCDNo")
    private String OrgCDNo; // 원거래 CD 번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("OrgTranNo")
    private String OrgTranNo; // 원거래 거래 번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("OrgCasherNo")
    private String OrgCasherNo; // 원거래 Casher 번호

    @IIrtFldMeta(size = 12)
    @JsonProperty("TotAmt")
    private String TotAmt; // 전체거래금액

    @IIrtFldMeta(size = 12)
    @JsonProperty("DisAmt")
    private String DisAmt; // 에누리금액

    @IIrtFldMeta(size = 12)
    @JsonProperty("NetAmt")
    private String NetAmt; // 고객 결제 금액

    @IIrtFldMeta(size = 4)
    @JsonProperty("MdCount")
    private String MdCount; // 상품 수량

    @IIrtFldMeta(size = 50)
    @JsonProperty("MdCode")
    private String MdCode; // 회사별 상품 코드

    @IIrtFldMeta(size = 100)
    @JsonProperty("MdName")
    private String MdName; // 상품명

    @IIrtFldMeta(size = 1)
    @JsonProperty("EventMdInYN")
    private String EventMdInYN; // 이벤트상품포함여부

    @IIrtFldMeta(size = 1)
    @JsonProperty("EventYN")
    private String EventYN; // 이벤트참여식별여부

    @IIrtFldMeta(size = 2)
    @JsonProperty("CnclGubun")
    private String CnclGubun; // 취소 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("CnclUseYn")
    private String CnclUseYn; // 부분취소 가능 여부

    @IIrtFldMeta(size = 1)
    @JsonProperty("BankPlatYn")
    private String BankPlatYn; // 가상은행계좌 Platform 응답 여부

    @IIrtFldMeta(size = 1)
    @JsonProperty("BankYn")
    private String BankYn; // 가상은행계좌 활용 여부

    @IIrtFldMeta(size = 96)
    @JsonProperty("BankAccountNo")
    private String BankAccountNo; // 가상은행계좌번호

    @IIrtFldMeta(size = 12)
    @JsonProperty("BankUseAmt")
    private String BankUseAmt; // 가상은행계좌 승인금액

    @IIrtFldMeta(size = 8)
    @JsonProperty("BankAuthDate")
    private String BankAuthDate; // 가상은행계좌 승인일자

    @IIrtFldMeta(size = 15)
    @JsonProperty("BankAuthNo")
    private String BankAuthNo; // 가상은행계좌 승인번호

    @IIrtFldMeta(size = 15)
    @JsonProperty("BankReceipt")
    private String BankReceipt; // 가상은행계좌 영수증 출력

    @IIrtFldMeta(size = 8)
    @JsonProperty("OrgBankAuthDate")
    private String OrgBankAuthDate; // 가상은행계좌 원승인일자

    @IIrtFldMeta(size = 15)
    @JsonProperty("OrgBankAuthNo")
    private String OrgBankAuthNo; // 가상은행계좌 원승인번호

    @IIrtFldMeta(size = 2)
    @JsonProperty("BankCnclGubun")
    private String BankCnclGubun; // 취소 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("BankCnclUseYn")
    private String BankCnclUseYn; // 부분취소 가능 여부

    @IIrtFldMeta(size = 1)
    @JsonProperty("CouponPlatYN")
    private String CouponPlatYN; // PLCC 쿠폰 Platform 응답 유무

    @IIrtFldMeta(size = 1)
    @JsonProperty("CouponUseYN")
    private String CouponUseYN; // PLCC 쿠폰 활용 여부

    @IIrtFldMeta(size = 8)
    @JsonProperty("CouponAmt")
    private String CouponAmt; // PLCC 쿠폰 사용 금액

    @IIrtFldMeta(size = 1)
    @JsonProperty("EdiDscntFlag")
    private String EdiDscntFlag; // 청구할인 여부

    @IIrtFldMeta(size = 8)
    @JsonProperty("CUP_AMT")
    private String CUP_AMT; // 컵보증금

    @IIrtFldMeta(size = 0)
    @JsonProperty("DataFiller")
    private String DataFiller; // DATA예비필드

    @IIrtFldMeta(size = 2)
    @JsonProperty("KeyInType")
    private String KeyInType; // 키인 유무

    @IIrtFldMeta(size = 32)
    @JsonProperty("CardDateNo")
    private String CardDateNo; // 신용카드유효기간

    @IIrtFldMeta(size = 96)
    @JsonProperty("CardCertifyNo")
    private String CardCertifyNo; // 인증번호

    @IIrtFldMeta(size = 96)
    @JsonProperty("CardTrack2Data")
    private String CardTrack2Data; // 가상Track2Data

    @IIrtFldMeta(size = 128)
    @JsonProperty("CardEtcData")
    private String CardEtcData; // 카드사예비필드

    @IIrtFldMeta(size = 6)
    @JsonProperty("CardAuthTime")
    private String CardAuthTime; // 승인시간

    @IIrtFldMeta(size = 1)
    @JsonProperty("DATA2_FIELD_USE_YN")
    private String DATA2_FIELD_USE_YN; // 데이터2 필드 사용 여부

    @IIrtFldMeta(size = 1)
    @JsonProperty("MILG_CNT")
    private String MILG_CNT; // 마일리지 종류 개수

    @IIrtFldMeta(size = 1)
    @JsonProperty("MILG1_USE_YN")
    private String MILG1_USE_YN; // 마일리지1 사용 여부

    @IIrtFldMeta(size = 4)
    @JsonProperty("MILG1_INST_CD")
    private String MILG1_INST_CD; // 마일리지1 기관코드

    @IIrtFldMeta(size = 64)
    @JsonProperty("MILG1_MAI_CRD_NO")
    private String MILG1_MAI_CRD_NO; // 마일리지1 메인 카드 번호

    @IIrtFldMeta(size = 12)
    @JsonProperty("MILG1_USE_AMT")
    private String MILG1_USE_AMT; // 마일리지1 사용(취소) 금액

    @IIrtFldMeta(size = 8)
    @JsonProperty("MILG1_AUTH_DATE")
    private String MILG1_AUTH_DATE; // 마일리지1 승인(취소) 일자

    @IIrtFldMeta(size = 12)
    @JsonProperty("MILG1_AUTH_NO")
    private String MILG1_AUTH_NO; // 마일리지1 승인(취소) 번호

    @IIrtFldMeta(size = 8)
    @JsonProperty("ORG_MILG1_AUTH_DATE")
    private String ORG_MILG1_AUTH_DATE; // 마일리지1 원거래 승인일자

    @IIrtFldMeta(size = 12)
    @JsonProperty("ORG_MILG1_AUTH_NO")
    private String ORG_MILG1_AUTH_NO; // 마일리지1 원거래 승인번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("MILG2_USE_YN")
    private String MILG2_USE_YN; // 마일리지2 사용 여부

    @IIrtFldMeta(size = 4)
    @JsonProperty("MILG2_INST_CD")
    private String MILG2_INST_CD; // 마일리지2 기관코드

    @IIrtFldMeta(size = 64)
    @JsonProperty("MILG2_MAI_CRD_NO")
    private String MILG2_MAI_CRD_NO; // 마일리지2 메인 카드 번호

    @IIrtFldMeta(size = 12)
    @JsonProperty("MILG2_USE_AMT")
    private String MILG2_USE_AMT; // 마일리지2 사용(취소) 금액

    @IIrtFldMeta(size = 8)
    @JsonProperty("MILG2_AUTH_DATE")
    private String MILG2_AUTH_DATE; // 마일리지2 승인(취소) 일자

    @IIrtFldMeta(size = 12)
    @JsonProperty("MILG2_AUTH_NO")
    private String MILG2_AUTH_NO; // 마일리지2 승인(취소) 번호

    @IIrtFldMeta(size = 8)
    @JsonProperty("ORG_MILG2_AUTH_DATE")
    private String ORG_MILG2_AUTH_DATE; // 마일리지2 원거래 승인일자

    @IIrtFldMeta(size = 12)
    @JsonProperty("ORG_MILG2_AUTH_NO")
    private String ORG_MILG2_AUTH_NO; // 마일리지2 원거래 승인번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("MILG3_USE_YN")
    private String MILG3_USE_YN; // 마일리지3 사용 여부

    @IIrtFldMeta(size = 4)
    @JsonProperty("MILG3_INST_CD")
    private String MILG3_INST_CD; // 마일리지3 기관코드

    @IIrtFldMeta(size = 64)
    @JsonProperty("MILG3_MAI_CRD_NO")
    private String MILG3_MAI_CRD_NO; // 마일리지3 메인 카드 번호

    @IIrtFldMeta(size = 12)
    @JsonProperty("MILG3_USE_AMT")
    private String MILG3_USE_AMT; // 마일리지3 사용(취소) 금액

    @IIrtFldMeta(size = 8)
    @JsonProperty("MILG3_AUTH_DATE")
    private String MILG3_AUTH_DATE; // 마일리지3 승인(취소) 일자

    @IIrtFldMeta(size = 12)
    @JsonProperty("MILG3_AUTH_NO")
    private String MILG3_AUTH_NO; // 마일리지3 승인(취소) 번호

    @IIrtFldMeta(size = 8)
    @JsonProperty("ORG_MILG3_AUTH_DATE")
    private String ORG_MILG3_AUTH_DATE; // 마일리지3 원거래 승인일자

    @IIrtFldMeta(size = 12)
    @JsonProperty("ORG_MILG3_AUTH_NO")
    private String ORG_MILG3_AUTH_NO; // 마일리지3 원거래 승인번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("MILG4_USE_YN")
    private String MILG4_USE_YN; // 마일리지4 사용 여부

    @IIrtFldMeta(size = 4)
    @JsonProperty("MILG4_INST_CD")
    private String MILG4_INST_CD; // 마일리지4 기관코드

    @IIrtFldMeta(size = 64)
    @JsonProperty("MILG4_MAI_CRD_NO")
    private String MILG4_MAI_CRD_NO; // 마일리지4 메인 카드 번호

    @IIrtFldMeta(size = 12)
    @JsonProperty("MILG4_USE_AMT")
    private String MILG4_USE_AMT; // 마일리지4 사용(취소) 금액

    @IIrtFldMeta(size = 8)
    @JsonProperty("MILG4_AUTH_DATE")
    private String MILG4_AUTH_DATE; // 마일리지4 승인(취소) 일자

    @IIrtFldMeta(size = 12)
    @JsonProperty("MILG4_AUTH_NO")
    private String MILG4_AUTH_NO; // 마일리지4 승인(취소) 번호

    @IIrtFldMeta(size = 8)
    @JsonProperty("ORG_MILG4_AUTH_DATE")
    private String ORG_MILG4_AUTH_DATE; // 마일리지4 원거래 승인일자

    @IIrtFldMeta(size = 12)
    @JsonProperty("ORG_MILG4_AUTH_NO")
    private String ORG_MILG4_AUTH_NO; // 마일리지4 원거래 승인번호

    @IIrtFldMeta(size = 414)
    @JsonProperty("DATA_ETC_FIELD2")
    private String DATA_ETC_FIELD2; // DATA 예비필드2

    @IIrtFldMeta(size = 1)
    @JsonProperty("MsgEnd")
    private String MsgEnd; // 전문 종료 내역
}
