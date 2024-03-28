package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranCardItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 1)
    @JsonProperty("TranType")
    private String TranType; // 카드구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("CardType")
    private String CardType; // 결제구분

    @IIrtFldMeta(size = 4)
    @JsonProperty("CardSeqNo")
    private String CardSeqNo; // 카드일련번호

    @IIrtFldMeta(size = 9)
    @JsonProperty("EtcAmount")
    private String EtcAmount; // 매출기타

    @IIrtFldMeta(size = 8)
    @JsonProperty("ApprovalDate")
    private String ApprovalDate; // 승인일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("ApprovalTime")
    private String ApprovalTime; // 승인시각

    @IIrtFldMeta(size = 2)
    @JsonProperty("CardKind")
    private String CardKind; // 카드종류

    @IIrtFldMeta(size = 2)
    @JsonProperty("InputType")
    private String InputType; // 카드입력구분

    @IIrtFldMeta(size = 50)
    @JsonProperty("CardData")
    private String CardData; // Card Data

    @IIrtFldMeta(size = 16)
    @JsonProperty("Password")
    private String Password; // 비밀번호

    @IIrtFldMeta(size = 12)
    @JsonProperty("ApprovalNo")
    private String ApprovalNo; // 승인번호

    @IIrtFldMeta(size = 9)
    @JsonProperty("PrePoint")
    private String PrePoint; // 이전포인트

    @IIrtFldMeta(size = 9)
    @JsonProperty("CurPoint")
    private String CurPoint; // 금회포인트

    @IIrtFldMeta(size = 9)
    @JsonProperty("SumPoint")
    private String SumPoint; // 누계포인트

    @IIrtFldMeta(size = 9)
    @JsonProperty("PointPayAmount")
    private String PointPayAmount; // 포인트지불금액

    @IIrtFldMeta(size = 9)
    @JsonProperty("PointUseValidAmount")
    private String PointUseValidAmount; // 포인트사용가능금액

    @IIrtFldMeta(size = 9)
    @JsonProperty("PointPayValidAmount")
    private String PointPayValidAmount; // 포인트지불가능금액

    @IIrtFldMeta(size = 2)
    @JsonProperty("DivMonth")
    private String DivMonth; // 할부개월 2자리

    @IIrtFldMeta(size = 9)
    @JsonProperty("CardAmount")
    private String CardAmount; // 카드매출

    @IIrtFldMeta(size = 1)
    @JsonProperty("HostStatus")
    private String HostStatus; // 승인주체

    @IIrtFldMeta(size = 4)
    @JsonProperty("CardComNo")
    private String CardComNo; // 카드사

    @IIrtFldMeta(size = 2)
    @JsonProperty("Publish")
    private String Publish; // 발행사

    @IIrtFldMeta(size = 2)
    @JsonProperty("Purchase")
    private String Purchase; // 매입사

    @IIrtFldMeta(size = 9)
    @JsonProperty("TotalAmount")
    private String TotalAmount; // 총매출

    @IIrtFldMeta(size = 9)
    @JsonProperty("DiscountAmount")
    private String DiscountAmount; // 에누리

    @IIrtFldMeta(size = 9)
    @JsonProperty("PartAmount")
    private String PartAmount; // 일부입금

    @IIrtFldMeta(size = 2)
    @JsonProperty("ReadType")
    private String ReadType; // 거래구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("DongleMobileType")
    private String DongleMobileType; // 이동사구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("DonglePayType")
    private String DonglePayType; // 카드방식(결제)

    @IIrtFldMeta(size = 1)
    @JsonProperty("DongleCardKind")
    private String DongleCardKind; // 카드종류

    @IIrtFldMeta(size = 1)
    @JsonProperty("DongleCvm")
    private String DongleCvm; // CVM

    @IIrtFldMeta(size = 1)
    @JsonProperty("DccType")
    private String DccType; // DCC여부

    @IIrtFldMeta(size = 1)
    @JsonProperty("SsgPayFlag")
    private String SsgPayFlag; // SSG PAY 구분 모바일페이 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("ForceCancelFg")
    private String ForceCancelFg; // 강제취소구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("EdiDscntFlag")
    private String EdiDscntFlag; // 청구할인

    @IIrtFldMeta(size = 5)
    @JsonProperty("Filler")
    private String Filler; // FILLER

    @IIrtFldMeta(size = 6)
    @JsonProperty("DebitSeqNo")
    private String DebitSeqNo; // 직불일련번호
}
