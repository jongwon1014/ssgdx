package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranGIFTCardItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 3)
    @JsonProperty("ItemSeqNo")
    private String ItemSeqNo; // 아이템Seqno

    @IIrtFldMeta(size = 1)
    @JsonProperty("CancelFlag")
    private String CancelFlag; // 지정취소여부

    @IIrtFldMeta(size = 1)
    @JsonProperty("TranType")
    private String TranType; // 거래구분

    @IIrtFldMeta(size = 2)
    @JsonProperty("GiftCardType")
    private String GiftCardType; // 결제처리

    @IIrtFldMeta(size = 1)
    @JsonProperty("InputType")
    private String InputType; // 카드입력구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("TrackCheck")
    private String TrackCheck; // track유무

    @IIrtFldMeta(size = 14)
    @JsonProperty("StartGiftNo")
    private String StartGiftNo; // 시작 바코드

    @IIrtFldMeta(size = 14)
    @JsonProperty("EndGiftNo")
    private String EndGiftNo; // 종료 바코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("MoneyType")
    private String MoneyType; // 권종

    @IIrtFldMeta(size = 2)
    @JsonProperty("TrackLength")
    private String TrackLength; // TRACK길이

    @IIrtFldMeta(size = 37)
    @JsonProperty("CardData")
    private String CardData; // 카드번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("UseType")
    private String UseType; // 회수구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("SaleType")
    private String SaleType; // 판매구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("GiftType")
    private String GiftType; // 상품권구분

    @IIrtFldMeta(size = 2)
    @JsonProperty("CooperationType")
    private String CooperationType; // 제휴사구분

    @IIrtFldMeta(size = 14)
    @JsonProperty("ApprovalDate")
    private String ApprovalDate; // 승인일자

    @IIrtFldMeta(size = 8)
    @JsonProperty("ApprovalNo")
    private String ApprovalNo; // 승인번호

    @IIrtFldMeta(size = 11)
    @JsonProperty("RemainAmount")
    private String RemainAmount; // 잔액

    @IIrtFldMeta(size = 11)
    @JsonProperty("UseAmount")
    private String UseAmount; // 회수금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("ChargeAmount")
    private String ChargeAmount; // 충전금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("SaleAmount")
    private String SaleAmount; // 판매금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("TotalAmount")
    private String TotalAmount; // 상품권합계

    @IIrtFldMeta(size = 11)
    @JsonProperty("ChangeAmount")
    private String ChangeAmount; // 전자상품권 현금거스름

    @IIrtFldMeta(size = 1)
    @JsonProperty("HostStatus")
    private String HostStatus; // 승인주체

    @IIrtFldMeta(size = 4)
    @JsonProperty("CardSeqNo")
    private String CardSeqNo; // 카드SeqNo

    @IIrtFldMeta(size = 10)
    @JsonProperty("StoreId")
    private String StoreId; // 가맹점코드

    @IIrtFldMeta(size = 1)
    @JsonProperty("ChangeType")
    private String ChangeType; // 교환구분

    @IIrtFldMeta(size = 22)
    @JsonProperty("PlatfromBarcode")
    private String PlatfromBarcode; // 통합결제 플랫폼 바코드

    @IIrtFldMeta(size = 1)
    @JsonProperty("PayType")
    private String PayType; // 결제수단

    @IIrtFldMeta(size = 4)
    @JsonProperty("org_cd")
    private String org_cd; // 원거래 CD번호

    @IIrtFldMeta(size = 2)
    @JsonProperty("Filler")
    private String Filler; // 예비
}
