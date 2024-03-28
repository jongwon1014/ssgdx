package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranTaxRefundItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // 전문 ID

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // 전문길이

    @IIrtFldMeta(size = 6)
    @JsonProperty("ComSeqNo")
    private String ComSeqNo; // 전문 일련 번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("ComStCode")
    private String ComStCode; // 점코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ComTmNo")
    private String ComTmNo; // TM 번호

    @IIrtFldMeta(size = 6)
    @JsonProperty("ComCashierNo")
    private String ComCashierNo; // 캐셔 번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("ComChitNo")
    private String ComChitNo; // CD 일련 번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("ComTranNo")
    private String ComTranNo; // POS거래번호

    @IIrtFldMeta(size = 6)
    @JsonProperty("ComReqManNo")
    private String ComReqManNo; // 요청자 고유번호

    @IIrtFldMeta(size = 8)
    @JsonProperty("ComAuthDate")
    private String ComAuthDate; // 영업일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("ComAuthTime")
    private String ComAuthTime; // 영업시간

    @IIrtFldMeta(size = 8)
    @JsonProperty("ComSendDate")
    private String ComSendDate; // 전문전송일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("ComSendTime")
    private String ComSendTime; // 전문전송시간

    @IIrtFldMeta(size = 1)
    @JsonProperty("TmsType")
    private String TmsType; // 거래구분

    @IIrtFldMeta(size = 5)
    @JsonProperty("MsgLength")
    private String MsgLength; // 전문길이

    @IIrtFldMeta(size = 2)
    @JsonProperty("Edi")
    private String Edi; // 업무구분

    @IIrtFldMeta(size = 10)
    @JsonProperty("Version")
    private String Version; // 전문버전

    @IIrtFldMeta(size = 3)
    @JsonProperty("DocumentCd")
    private String DocumentCd; // 문서코드

    @IIrtFldMeta(size = 20)
    @JsonProperty("BuySerialNum")
    private String BuySerialNum; // 구매 일련번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("BuyerCancelChk")
    private String BuyerCancelChk; // 구매 취소여부

    @IIrtFldMeta(size = 10)
    @JsonProperty("TradeApprovalNum")
    private String TradeApprovalNum; // 거래 승인번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("SellerBusiRegistNum")
    private String SellerBusiRegistNum; // 판매자 사업자등록번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("TerminalId")
    private String TerminalId; // 단말기ID

    @IIrtFldMeta(size = 14)
    @JsonProperty("SellTime")
    private String SellTime; // 판매 년월일시

    @IIrtFldMeta(size = 4)
    @JsonProperty("SellSumTotal")
    private String SellSumTotal; // 판매 총수량

    @IIrtFldMeta(size = 9)
    @JsonProperty("SellSumMoney")
    private String SellSumMoney; // 판매 총금액

    @IIrtFldMeta(size = 8)
    @JsonProperty("RefundAmount")
    private String RefundAmount; // 환급총액

    @IIrtFldMeta(size = 1)
    @JsonProperty("PayMentType")
    private String PayMentType; // 결제 유형

    @IIrtFldMeta(size = 21)
    @JsonProperty("CreditCardNum")
    private String CreditCardNum; // 결제 신용카드번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("KorDomesticCitizen")
    private String KorDomesticCitizen; // 내국인환급대상여부

    @IIrtFldMeta(size = 13)
    @JsonProperty("KorIdentity")
    private String KorIdentity; // 주민번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("PassportEncYn")
    private String PassportEncYn; // 여권암호화여부

    @IIrtFldMeta(size = 40)
    @JsonProperty("PassportName")
    private String PassportName; // 여권영문이름

    @IIrtFldMeta(size = 24)
    @JsonProperty("PassportNum")
    private String PassportNum; // 여권번호

    @IIrtFldMeta(size = 3)
    @JsonProperty("PassportNation")
    private String PassportNation; // 여권국가코드

    @IIrtFldMeta(size = 1)
    @JsonProperty("PassportSex")
    private String PassportSex; // 여권성별

    @IIrtFldMeta(size = 6)
    @JsonProperty("PassportBirth")
    private String PassportBirth; // 여권생년월일

    @IIrtFldMeta(size = 6)
    @JsonProperty("PassportExpire")
    private String PassportExpire; // 여권만료일

    @IIrtFldMeta(size = 3)
    @JsonProperty("ResponseCd")
    private String ResponseCd; // 응답코드

    @IIrtFldMeta(size = 60)
    @JsonProperty("ResponseMessage")
    private String ResponseMessage; // 응답메시지

    @IIrtFldMeta(size = 40)
    @JsonProperty("ShopName")
    private String ShopName; // 매장명

    @IIrtFldMeta(size = 4)
    @JsonProperty("SequenceCount")
    private String SequenceCount; // 물품부반복횟수

    @IIrtFldMeta(size = 8)
    @JsonProperty("ExportExpiryDate")
    private String ExportExpiryDate; // 반출유효기간

    @IIrtFldMeta(size = 30)
    @JsonProperty("RctNo")
    private String RctNo; // 영수증번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("BeforeRefundYn")
    private String BeforeRefundYn; // 즉시환급여부

    @IIrtFldMeta(size = 9)
    @JsonProperty("PaymentAmount")
    private String PaymentAmount; // 결제금액

    @IIrtFldMeta(size = 30)
    @JsonProperty("ExportApprovalNum")
    private String ExportApprovalNum; // 반출승인번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("BeforeLimitAmount")
    private String BeforeLimitAmount; // 즉시환급한도액

    @IIrtFldMeta(size = 20)
    @JsonProperty("UniqueNum")
    private String UniqueNum; // 고유번호

    @IIrtFldMeta(size = 2)
    @JsonProperty("VanNo")
    private String VanNo; // 승인VAN사구분

    @IIrtFldMeta(size = 78)
    @JsonProperty("Extra")
    private String Extra; // 비고
}
