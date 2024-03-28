package com.shinsegae.ssgdx.rst.model.newtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranKakaopayItemN {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 6)
    @JsonProperty("TextId")
    private String TextId; // Text ID

    @IIrtFldMeta(size = 4)
    @JsonProperty("StoreNo")
    private String StoreNo; // 점포코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("PosNo")
    private String PosNo; // POS번호

    @IIrtFldMeta(size = 6)
    @JsonProperty("CashierNo")
    private String CashierNo; // 담당자번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("ChitNo")
    private String ChitNo; // CD 일련번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("TranNo")
    private String TranNo; // POS 거래번호

    @IIrtFldMeta(size = 8)
    @JsonProperty("SaleDate")
    private String SaleDate; // 영업일자

    @IIrtFldMeta(size = 1)
    @JsonProperty("ItemSeq")
    private String ItemSeq; // 아이템시퀀스

    @IIrtFldMeta(size = 6)
    @JsonProperty("TextNo")
    private String TextNo; // 전문번호

    @IIrtFldMeta(size = 5)
    @JsonProperty("SendAgency")
    private String SendAgency; // 전송기관

    @IIrtFldMeta(size = 20)
    @JsonProperty("RetrievalNo")
    private String RetrievalNo; // 거래고유번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("TrnsType")
    private String TrnsType; // 거래타입

    @IIrtFldMeta(size = 1)
    @JsonProperty("CatClass")
    private String CatClass; // 단말기구분

    @IIrtFldMeta(size = 10)
    @JsonProperty("BuzNo")
    private String BuzNo; // 사업자번호

    @IIrtFldMeta(size = 15)
    @JsonProperty("MerId")
    private String MerId; // 가맹점아이디

    @IIrtFldMeta(size = 20)
    @JsonProperty("CatId")
    private String CatId; // 단말기아이디

    @IIrtFldMeta(size = 3)
    @JsonProperty("CurrencyCode")
    private String CurrencyCode; // 통화코드

    @IIrtFldMeta(size = 8)
    @JsonProperty("SendDate")
    private String SendDate; // 전송일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("SendTime")
    private String SendTime; // 전송시간

    @IIrtFldMeta(size = 4)
    @JsonProperty("RespCode")
    private String RespCode; // 응답코드

    @IIrtFldMeta(size = 1)
    @JsonProperty("BarcodeType")
    private String BarcodeType; // 바코드타입

    @IIrtFldMeta(size = 24)
    @JsonProperty("BarcodeNo")
    private String BarcodeNo; // 바코드

    @IIrtFldMeta(size = 10)
    @JsonProperty("StoreCode")
    private String StoreCode; // 점포코드

    @IIrtFldMeta(size = 8)
    @JsonProperty("OrgSaleDate")
    private String OrgSaleDate; // 원거래 전송일자

    @IIrtFldMeta(size = 20)
    @JsonProperty("OrgRetrievalNo")
    private String OrgRetrievalNo; // 원거래 고유번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("CancelFlag")
    private String CancelFlag; // 취소구분

    @IIrtFldMeta(size = 2)
    @JsonProperty("CancelReason")
    private String CancelReason; // 취소사유

    @IIrtFldMeta(size = 10)
    @JsonProperty("PayType")
    private String PayType; // 결제수단

    @IIrtFldMeta(size = 12)
    @JsonProperty("SaleAmount")
    private String SaleAmount; // 결제요청금액

    @IIrtFldMeta(size = 12)
    @JsonProperty("TaxFreeAmount")
    private String TaxFreeAmount; // 비과세금액

    @IIrtFldMeta(size = 12)
    @JsonProperty("TaxAmount")
    private String TaxAmount; // 세금

    @IIrtFldMeta(size = 12)
    @JsonProperty("TipAmount")
    private String TipAmount; // 봉사료

    @IIrtFldMeta(size = 12)
    @JsonProperty("DiscountAmount")
    private String DiscountAmount; // 할인금액

    @IIrtFldMeta(size = 12)
    @JsonProperty("RecvAuthAmount")
    private String RecvAuthAmount; // 승인금액

    @IIrtFldMeta(size = 2)
    @JsonProperty("InsMonth")
    private String InsMonth; // 할부개월

    @IIrtFldMeta(size = 8)
    @JsonProperty("AuthDate")
    private String AuthDate; // 승인일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("AuthTime")
    private String AuthTime; // 승인시간

    @IIrtFldMeta(size = 10)
    @JsonProperty("AuthNo")
    private String AuthNo; // 승인번호

    @IIrtFldMeta(size = 16)
    @JsonProperty("MembershipBarcode")
    private String MembershipBarcode; // 카카오페이멤버십 바코드

    @IIrtFldMeta(size = 20)
    @JsonProperty("MembershipNo")
    private String MembershipNo; // 멤버십번호

    @IIrtFldMeta(size = 50)
    @JsonProperty("Message")
    private String Message; // 알림메세지

    @IIrtFldMeta(size = 3)
    @JsonProperty("BuyCode")
    private String BuyCode; // 발급사코드

    @IIrtFldMeta(size = 20)
    @JsonProperty("BuyName")
    private String BuyName; // 발급사명

    @IIrtFldMeta(size = 3)
    @JsonProperty("IssueCode")
    private String IssueCode; // 매입사코드

    @IIrtFldMeta(size = 20)
    @JsonProperty("IssueName")
    private String IssueName; // 매입사명

    @IIrtFldMeta(size = 100)
    @JsonProperty("OTC")
    private String OTC; // OTC

    @IIrtFldMeta(size = 3)
    @JsonProperty("PEM")
    private String PEM; // PEM

    @IIrtFldMeta(size = 16)
    @JsonProperty("Trid")
    private String Trid; // Trid

    @IIrtFldMeta(size = 6)
    @JsonProperty("CardBin")
    private String CardBin; // 카드BIN

    @IIrtFldMeta(size = 20)
    @JsonProperty("SearchRetrievalNo")
    private String SearchRetrievalNo; // 카카오 조회 거래고유번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("MDCode")
    private String MDCode; // MD코드

    @IIrtFldMeta(size = 1)
    @JsonProperty("VANClass")
    private String VANClass; // 승인기관

    @IIrtFldMeta(size = 20)
    @JsonProperty("SKUCode")
    private String SKUCode; // 대표상품코드

    @IIrtFldMeta(size = 1)
    @JsonProperty("CheckClass")
    private String CheckClass; // 신용/체크 구분자

    @IIrtFldMeta(size = 1)
    @JsonProperty("MunwhaFlag")
    private String MunwhaFlag; // 도서/공연비 여부

    @IIrtFldMeta(size = 30)
    @JsonProperty("PosBarcode")
    private String PosBarcode; // POS바코드

    @IIrtFldMeta(size = 1)
    @JsonProperty("EdiDscntFlag")
    private String EdiDscntFlag; // 청구할인

    @IIrtFldMeta(size = 8)
    @JsonProperty("CardBin8")
    private String CardBin8; // 카드BIN8

    @IIrtFldMeta(size = 12)
    @JsonProperty("CashRcptAmt")
    private String CashRcptAmt; // 현금영수증대상금액

    @IIrtFldMeta(size = 9)
    @JsonProperty("CupAmt")
    private String CupAmt; // 컵보증금

    @IIrtFldMeta(size = 4)
    @JsonProperty("BizRelmCd")
    private String BizRelmCd; // 사업영역코드

    @IIrtFldMeta(size = 466)
    @JsonProperty("Filler")
    private String Filler; // 예비필드
}
