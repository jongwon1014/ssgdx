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
public class TranChicorOnOffItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 1)
    @JsonProperty("TradeGbCd")
    private String TradeGbCd; // 거래구분코드

    @IIrtFldMeta(size = 8)
    @JsonProperty("TradeDt")
    private String TradeDt; // 거래발생일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("TradeTm")
    private String TradeTm; // 거래발생시간

    @IIrtFldMeta(size = 6)
    @JsonProperty("CashierNo")
    private String CashierNo; // 캐셔번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("OrgStoreNo")
    private String OrgStoreNo; // 원거래 점포코드

    @IIrtFldMeta(size = 8)
    @JsonProperty("OrgSaleDate")
    private String OrgSaleDate; // 원거래 영업일자

    @IIrtFldMeta(size = 4)
    @JsonProperty("OrgPosNo")
    private String OrgPosNo; // 원거래 POS번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("OrgTranNo")
    private String OrgTranNo; // 원거래 거래번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("OrgTotAmt")
    private String OrgTotAmt; // 원거래 결제금액

    @IIrtFldMeta(size = 9)
    @JsonProperty("Mbshno")
    private String Mbshno; // 시코르 회원번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("FirstAuthFlag")
    private String FirstAuthFlag; // 최초인증구분

    @IIrtFldMeta(size = 4)
    @JsonProperty("MbshFlag")
    private String MbshFlag; // 회원 가입 구분

    @IIrtFldMeta(size = 64)
    @JsonProperty("SPointCardNo")
    private String SPointCardNo; // 신세계포인트 카드번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("PointApprNo")
    private String PointApprNo; // 시코르 포인트 사용 승인 번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("NotPointPay")
    private String NotPointPay; // 미적립 결제수단 결제금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("UsePoint")
    private String UsePoint; // 사용한 시코르 포인트

    @IIrtFldMeta(size = 10)
    @JsonProperty("UseSPoint")
    private String UseSPoint; // 사용한 신세계포인트

    @IIrtFldMeta(size = 10)
    @JsonProperty("UsablePoint")
    private String UsablePoint; // 시코르 가용 포인트

    @IIrtFldMeta(size = 10)
    @JsonProperty("TotalPoint")
    private String TotalPoint; // 시코르 누적 포인트

    @IIrtFldMeta(size = 10)
    @JsonProperty("SavePoint")
    private String SavePoint; // 시코르 적립 포인트

    @IIrtFldMeta(size = 10)
    @JsonProperty("PointSaveApprNo")
    private String PointSaveApprNo; // 시코르 포인트 적립 고유번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("TotAmt")
    private String TotAmt; // 총매출

    @IIrtFldMeta(size = 10)
    @JsonProperty("NetAmt")
    private String NetAmt; // 순매출

    @IIrtFldMeta(size = 10)
    @JsonProperty("EnuriAmt")
    private String EnuriAmt; // 에누리

    @IIrtFldMeta(size = 2)
    @JsonProperty("UseCpCnt")
    private String UseCpCnt; // 사용한 쿠폰 개수

    @IIrtFldMeta(size = 100)
    @JsonProperty("Filler")
    private String Filler; // 예비필드

    @JsonProperty("CoupList")
    @IIrtFldMeta(dType = EnmTranFieldType.LIST)
    private List<TCOOICoupList> CoupList = new ArrayList<TCOOICoupList>(); // RecordList
                                                                           // 반복

    @Getter
    @Setter
    private static class TCOOICoupList {

        @IIrtFldMeta(size = 20)
        @JsonProperty("CpId")
        private String CpId; // 쿠폰번호(ID)

        @IIrtFldMeta(size = 10)
        @JsonProperty("CpTargCls")
        private String CpTargCls; // 쿠폰종류

        @IIrtFldMeta(size = 1)
        @JsonProperty("CpFlag")
        private String CpFlag; // 율/금액구분

        @IIrtFldMeta(size = 20)
        @JsonProperty("CpIssuNo")
        private String CpIssuNo; // 쿠폰발급번호

        @IIrtFldMeta(size = 10)
        @JsonProperty("CpSaleAmt")
        private String CpSaleAmt; // 쿠폰할인금액

        @IIrtFldMeta(size = 10)
        @JsonProperty("CpApprNo")
        private String CpApprNo; // 쿠폰 승인 ID

        @IIrtFldMeta(size = 56)
        @JsonProperty("CpNm")
        private String CpNm; // 쿠폰이름

        @IIrtFldMeta(size = 50)
        @JsonProperty("CpFiller")
        private String CpFiller; // 쿠폰 예비
    }
}
