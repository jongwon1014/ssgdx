package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranCashTerCommItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 4)
    @JsonProperty("MsgType")
    private String MsgType; // 전문종류

    @IIrtFldMeta(size = 4)
    @JsonProperty("JobType")
    private String JobType; // 업무구분

    @IIrtFldMeta(size = 8)
    @JsonProperty("SaleDate")
    private String SaleDate; // 거래일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("SaleTime")
    private String SaleTime; // 거래시각

    @IIrtFldMeta(size = 11)
    @JsonProperty("SerialNumber")
    private String SerialNumber; // 기기 일련번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("MutualCode")
    private String MutualCode; // 상호코드

    @IIrtFldMeta(size = 6)
    @JsonProperty("DeptNo")
    private String DeptNo; // 지점코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("PosNo")
    private String PosNo; // POS번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("TranNo")
    private String TranNo; // 거래번호

    @IIrtFldMeta(size = 11)
    @JsonProperty("SeqNo")
    private String SeqNo; // 정산기일련번호

    @IIrtFldMeta(size = 8)
    @JsonProperty("OrgSaleDate")
    private String OrgSaleDate; // 원거래일자

    @IIrtFldMeta(size = 4)
    @JsonProperty("OrgPosNo")
    private String OrgPosNo; // 원거래POS번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("OrgTranNo")
    private String OrgTranNo; // 원거래거래번호

    @IIrtFldMeta(size = 6)
    @JsonProperty("OrgCashierNo")
    private String OrgCashierNo; // 원거래캐셔번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("DeviceNo")
    private String DeviceNo; // 기기번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("DeviceType")
    private String DeviceType; // 단말타입

    @IIrtFldMeta(size = 20)
    @JsonProperty("MutualName")
    private String MutualName; // 상호명

    @IIrtFldMeta(size = 8)
    @JsonProperty("AppVersion")
    private String AppVersion; // 정산기버전

    @IIrtFldMeta(size = 5)
    @JsonProperty("DeviceName")
    private String DeviceName; // 기종명

    @IIrtFldMeta(size = 42)
    @JsonProperty("Filler")
    private String Filler; // 필러
}
