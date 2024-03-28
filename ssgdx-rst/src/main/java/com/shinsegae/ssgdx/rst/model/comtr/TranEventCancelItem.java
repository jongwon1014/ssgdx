package com.shinsegae.ssgdx.rst.model.comtr;

import java.util.ArrayList;
import java.util.List;

import com.shinsegae.ssgdx.ldi.util.IEnumComIrt.EnmTranFieldType;
import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranEventCancelItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 2)
    @JsonProperty("TranKind")
    private String TranKind; // ItemKind

    @IIrtFldMeta(size = 9)
    @JsonProperty("GiftCancelAmount")
    private String GiftCancelAmount; // 사은품취소 받을금액

    @IIrtFldMeta(size = 9)
    @JsonProperty("ReceiveCash")
    private String ReceiveCash; // 사은품취소현금

    @IIrtFldMeta(size = 9)
    @JsonProperty("ReceiveGift")
    private String ReceiveGift; // 사은품취소상품권

    @IIrtFldMeta(size = 2)
    @JsonProperty("CancelGiftCount")
    private String CancelGiftCount; // 사은품취소갯수

    @IIrtFldMeta(size = 9)
    @JsonProperty("ReceiveMobile")
    private String ReceiveMobile; // 사은품취소모바일 상품권

    @IIrtFldMeta(size = 9)
    @JsonProperty("GiftReturnAmount")
    private String GiftReturnAmount; // 사은품취소금액

    @IIrtFldMeta(size = 9)
    @JsonProperty("GiftRemainAmount")
    private String GiftRemainAmount; // 사은품거스름돈

    @IIrtFldMeta(size = 9)
    @JsonProperty("CashRemainAmount")
    private String CashRemainAmount; // 현금거스름돈

    @IIrtFldMeta(size = 1)
    @JsonProperty("TargetRemain")
    private String TargetRemain; // 거스름 대상

    @IIrtFldMeta(size = 9)
    @JsonProperty("ReceiveReward")
    private String ReceiveReward; // 사은품취소 신백 리워드

    @IIrtFldMeta(size = 9)
    @JsonProperty("ReceiveRewardCoupon")
    private String ReceiveRewardCoupon; // 사은품취소 신백 쿠폰

    @IIrtFldMeta(size = 8)
    @JsonProperty("Filler")
    private String Filler; // 예비

    @IIrtFldMeta(dType = EnmTranFieldType.CLASS)
    @JsonProperty("EventCommHeader")
    private TECIEventCommHeader EventCommHeader; // 사은행사 공통헤더

    @IIrtFldMeta(dType = EnmTranFieldType.CLASS)
    @JsonProperty("EventTranHeader")
    private TECIEventTranHeader EventTranHeader; // 사은행사 Tran Header

    @IIrtFldMeta(dType = EnmTranFieldType.CLASS, isItemHeader = true)
    @JsonProperty("EventReceiptItem")
    private TECIEventReceiptItem EventReceiptItem; // 사은품 영수증 ITEM

    // 전문 파싱부에서 직접 반복 구현
    @JsonProperty("EventItem")
    private List<TECIEventItem> EventItem = new ArrayList<TECIEventItem>(); // 사은품
                                                                            // ITEM

    /**
     * 사은행사 공통헤더
     */
    @Getter
    @Setter
    private static class TECIEventCommHeader {

        @IIrtFldMeta(size = 6)
        @JsonProperty("MsgLength")
        private String MsgLength; // 메시지길이

        @IIrtFldMeta(size = 2)
        @JsonProperty("MsgPath")
        private String MsgPath; // 메시지경로

        @IIrtFldMeta(size = 2)
        @JsonProperty("MsgType")
        private String MsgType; // 메시지타입

        @IIrtFldMeta(size = 2)
        @JsonProperty("MsgKind")
        private String MsgKind; // 메시지종류

        @IIrtFldMeta(size = 8)
        @JsonProperty("SaleDate")
        private String SaleDate; // 영업일자

        @IIrtFldMeta(size = 3)
        @JsonProperty("StoreNo")
        private String StoreNo; // 점코드

        @IIrtFldMeta(size = 4)
        @JsonProperty("PosNo")
        private String PosNo; // POS번호

        @IIrtFldMeta(size = 4)
        @JsonProperty("TranNo")
        private String TranNo; // 거래번호

        @IIrtFldMeta(size = 8)
        @JsonProperty("SendDate")
        private String SendDate; // 시스템날짜

        @IIrtFldMeta(size = 6)
        @JsonProperty("SendTime")
        private String SendTime; // 시스템시간

        @IIrtFldMeta(size = 4)
        @JsonProperty("ExtStoreNo")
        private String ExtStoreNo; // 新점포코드

        @IIrtFldMeta(size = 1)
        @JsonProperty("TrainMode")
        private String TrainMode; // 교육모드

        @IIrtFldMeta(size = 1)
        @JsonProperty("VersionFlag")
        private String VersionFlag; // 신/구전문구분

        @IIrtFldMeta(size = 12)
        @JsonProperty("UserInfo")
        private String UserInfo; // 사용자 정보

        @IIrtFldMeta(size = 4)
        @JsonProperty("ReplyCode")
        private String ReplyCode; // 응답코드
    }

    /**
     * 사은행사 Tran Header
     */
    @Getter
    @Setter
    private static class TECIEventTranHeader {

        @IIrtFldMeta(size = 6)
        @JsonProperty("MsgId")
        private String MsgId; // 메시지 ID

        @IIrtFldMeta(size = 6)
        @JsonProperty("MsgLength")
        private String MsgLength; // 전문 길이

        @IIrtFldMeta(size = 8)
        @JsonProperty("SaleDate")
        private String SaleDate; // 행사일

        @IIrtFldMeta(size = 4)
        @JsonProperty("StoreNo")
        private String StoreNo; // 점포 번호

        @IIrtFldMeta(size = 4)
        @JsonProperty("PosNo")
        private String PosNo; // 행사PC 번호

        @IIrtFldMeta(size = 4)
        @JsonProperty("TranNo")
        private String TranNo; // 행사Tran 번호

        @IIrtFldMeta(size = 2)
        @JsonProperty("TranType")
        private String TranType; // 거래 구분

        @IIrtFldMeta(size = 2)
        @JsonProperty("TranKind")
        private String TranKind; // 거래 종별

        @IIrtFldMeta(size = 20)
        @JsonProperty("CardNo")
        private String CardNo; // 카드 번호

        @IIrtFldMeta(size = 8)
        @JsonProperty("SysDate")
        private String SysDate; // 발생 일자

        @IIrtFldMeta(size = 6)
        @JsonProperty("SysTime")
        private String SysTime; // 발생 시각

        @IIrtFldMeta(size = 8)
        @JsonProperty("SendDate")
        private String SendDate; // 전송 일자

        @IIrtFldMeta(size = 6)
        @JsonProperty("SendTime")
        private String SendTime; // 전송 시각

        @IIrtFldMeta(size = 6)
        @JsonProperty("CashierNo")
        private String CashierNo; // 사용자 번호

        @IIrtFldMeta(size = 9)
        @JsonProperty("ReturnAmount")
        private String ReturnAmount; // 사은행사 회수 금액

        @IIrtFldMeta(size = 9)
        @JsonProperty("ReplaceReceiptAmount")
        private String ReplaceReceiptAmount; // 대체영수증 적용금액
    }

    /**
     * 사은품 영수증 ITEM
     */
    @Getter
    @Setter
    private static class TECIEventReceiptItem {

        @IIrtFldMeta(size = 2)
        @JsonProperty("ItemCode")
        private String ItemCode; // 아이템ID

        @IIrtFldMeta(size = 4)
        @JsonProperty("ItemLength")
        private String ItemLength; // 아이템길이

        @IIrtFldMeta(size = 8)
        @JsonProperty("SaleDate")
        private String SaleDate; // 영업일자

        @IIrtFldMeta(size = 4)
        @JsonProperty("StoreNo")
        private String StoreNo; // 점포코드

        @IIrtFldMeta(size = 4)
        @JsonProperty("PosNo")
        private String PosNo; // POS번호

        @IIrtFldMeta(size = 4)
        @JsonProperty("TranNo")
        private String TranNo; // 거래번호

        @IIrtFldMeta(size = 8)
        @JsonProperty("OrgSaleDate")
        private String OrgSaleDate; // 원영업일자

        @IIrtFldMeta(size = 4)
        @JsonProperty("OrgStoreCode")
        private String OrgStoreCode; // 원점포코드

        @IIrtFldMeta(size = 4)
        @JsonProperty("OrgPosNo")
        private String OrgPosNo; // 원POS번호

        @IIrtFldMeta(size = 4)
        @JsonProperty("OrgTranNo")
        private String OrgTranNo; // 원거래번호

        @IIrtFldMeta(size = 50)
        @JsonProperty("Filler")
        private String Filler; // 예비

        @IIrtFldMeta(size = 2, isLoopCount = true)
        @JsonProperty("ReplaceReceiptCount")
        private String ReplaceReceiptCount; // 대체 영수증 건수

        @IIrtFldMeta(dType = EnmTranFieldType.LIST)
        @JsonProperty("ReplaceReceiptList")
        private List<TECIERIReplaceReceiptList> ReplaceReceiptList = new ArrayList<TECIERIReplaceReceiptList>(); // 대체
                                                                                                                 // 영수증
                                                                                                                 // 리스트(최대10건)

        /**
         * 대체 영수증 리스트(최대10건)
         */
        @Getter
        @Setter
        private static class TECIERIReplaceReceiptList {

            @IIrtFldMeta(size = 8)
            @JsonProperty("SaleDate")
            private String SaleDate; // 영업일자

            @IIrtFldMeta(size = 4)
            @JsonProperty("PosNo")
            private String PosNo; // POS번호

            @IIrtFldMeta(size = 4)
            @JsonProperty("TranNo")
            private String TranNo; // 거래번호

            @IIrtFldMeta(size = 9)
            @JsonProperty("NetAmount")
            private String NetAmount; // 순매출액

            @IIrtFldMeta(size = 9)
            @JsonProperty("ApplyAmount")
            private String ApplyAmount; // 인정금액
        }
    }

    /**
     * 사은품 ITEM
     */
    @Getter
    @Setter
    public static class TECIEventItem {

        @IIrtFldMeta(size = 2)
        @JsonProperty("ItemCode")
        private String ItemCode; // 아이템 헤더 ID

        @IIrtFldMeta(size = 4)
        @JsonProperty("ItemLength")
        private String ItemLength; // 아이템 길이

        @IIrtFldMeta(size = 2)
        @JsonProperty("ReturnType")
        private String ReturnType; // 회입수단

        @IIrtFldMeta(size = 20)
        @JsonProperty("EventPluCode")
        private String EventPluCode; // 사은품 코드

        @IIrtFldMeta(size = 5)
        @JsonProperty("ReturnCount")
        private String ReturnCount; // 회입수량

        @IIrtFldMeta(size = 9)
        @JsonProperty("ReturnAmount")
        private String ReturnAmount; // 회입금액

        @IIrtFldMeta(size = 58)
        @JsonProperty("Filler")
        private String Filler; // 예비
    }
}
