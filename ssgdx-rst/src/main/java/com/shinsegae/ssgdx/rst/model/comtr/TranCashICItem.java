package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranCashICItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 4)
    @JsonProperty("CorpCode")
    private String CorpCode; // 회사코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("MsgFlag")
    private String MsgFlag; // 요청구분

    @IIrtFldMeta(size = 8)
    @JsonProperty("SaleDate")
    private String SaleDate; // 영업일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("SaleTime")
    private String SaleTime; // 영업시간

    @IIrtFldMeta(size = 4)
    @JsonProperty("StoreNo")
    private String StoreNo; // 점코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("PosNo")
    private String PosNo; // 포스 번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("CardSeqNo")
    private String CardSeqNo; // CD 번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("TranNo")
    private String TranNo; // 거래 번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("CashierNo")
    private String CashierNo; // 캐셔번호

    @IIrtFldMeta(size = 8)
    @JsonProperty("PosDate")
    private String PosDate; // POS시스템일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("PosTime")
    private String PosTime; // POS시스템시간

    @IIrtFldMeta(size = 20)
    @JsonProperty("MsgUniqueNo")
    private String MsgUniqueNo; // 회사별 요청자 정보

    @IIrtFldMeta(size = 8)
    @JsonProperty("SysDate")
    private String SysDate; // 점포서버 전문전송일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("SysTime")
    private String SysTime; // 점포서버 전문전송시간

    @IIrtFldMeta(size = 8)
    @JsonProperty("IcSysDate")
    private String IcSysDate; // IC전문전송일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("IcSysTime")
    private String IcSysTime; // IC전문전송시간

    @IIrtFldMeta(size = 2)
    @JsonProperty("TranType")
    private String TranType; // 거래 TYPE

    @IIrtFldMeta(size = 2)
    @JsonProperty("TradeType")
    private String TradeType; // 요청 TYPE

    @IIrtFldMeta(size = 3)
    @JsonProperty("IcCorpCode")
    private String IcCorpCode; // IC카드 발급기관코드

    @IIrtFldMeta(size = 30)
    @JsonProperty("Track3")
    private String Track3; // TRACK3

    @IIrtFldMeta(size = 16)
    @JsonProperty("IcCardNo")
    private String IcCardNo; // IC카드일련번호

    @IIrtFldMeta(size = 2)
    @JsonProperty("PayFlag")
    private String PayFlag; // 결제처리간소화정보

    @IIrtFldMeta(size = 13)
    @JsonProperty("ApprovalNo")
    private String ApprovalNo; // 승인번호

    @IIrtFldMeta(size = 2)
    @JsonProperty("InputType")
    private String InputType; // KEY_IN 유무

    @IIrtFldMeta(size = 12)
    @JsonProperty("TotalAmount")
    private String TotalAmount; // 총매출금액

    @IIrtFldMeta(size = 12)
    @JsonProperty("NetAmount")
    private String NetAmount; // 순매출금액

    @IIrtFldMeta(size = 12)
    @JsonProperty("ApprovalAmount")
    private String ApprovalAmount; // 승인금액

    @IIrtFldMeta(size = 38)
    @JsonProperty("HeaderFiller")
    private String HeaderFiller; // 헤더예비필드

    @IIrtFldMeta(size = 8)
    @JsonProperty("OrgSaleDate")
    private String OrgSaleDate; // 원거래 영업일자

    @IIrtFldMeta(size = 4)
    @JsonProperty("OrgStoreNo")
    private String OrgStoreNo; // 원거래 점코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("OrgPosNo")
    private String OrgPosNo; // 원거래 포스 번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("OrgTranNo")
    private String OrgTranNo; // 원거래 거래 번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("OrgCardSeqNo")
    private String OrgCardSeqNo; // 원거래 CD 번호

    @IIrtFldMeta(size = 8)
    @JsonProperty("OrgApprovalDate")
    private String OrgApprovalDate; // 원거래 승인일자

    @IIrtFldMeta(size = 20)
    @JsonProperty("OrgApprovalNo")
    private String OrgApprovalNo; // 원거래 승인번호

    @IIrtFldMeta(size = 2)
    @JsonProperty("HostStatus")
    private String HostStatus; // 승인주체

    @IIrtFldMeta(size = 4)
    @JsonProperty("RespCode")
    private String RespCode; // 응답코드

    @IIrtFldMeta(size = 8)
    @JsonProperty("ApprovalDate")
    private String ApprovalDate; // 승인일자

    @IIrtFldMeta(size = 7)
    @JsonProperty("IssueCode")
    private String IssueCode; // 발급기관 점별코드

    @IIrtFldMeta(size = 12)
    @JsonProperty("CupAmt")
    private String CupAmt; // 컵보증금

    @IIrtFldMeta(size = 31)
    @JsonProperty("Filler")
    private String Filler; // DATA예비필드
}
