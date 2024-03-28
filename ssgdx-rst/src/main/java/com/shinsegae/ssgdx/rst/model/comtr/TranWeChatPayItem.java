package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranWeChatPayItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // 전문 ID

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // 전문 길이

    @IIrtFldMeta(size = 2)
    @JsonProperty("PayKind")
    private String PayKind; // 결제종류

    @IIrtFldMeta(size = 8)
    @JsonProperty("MchSendDate")
    private String MchSendDate; // 가맹점 전문 전송일자

    @IIrtFldMeta(size = 24)
    @JsonProperty("MchSendUniqNo")
    private String MchSendUniqNo; // 가맹점 전송 고유번호

    @IIrtFldMeta(size = 15)
    @JsonProperty("MchNo")
    private String MchNo; // 가맹점번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("SerComCode")
    private String SerComCode; // 회사코드

    @IIrtFldMeta(size = 8)
    @JsonProperty("SaleDate")
    private String SaleDate; // 영업일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("SaleTime")
    private String SaleTime; // 영업시간

    @IIrtFldMeta(size = 10)
    @JsonProperty("StCode")
    private String StCode; // 점코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("TmNo")
    private String TmNo; // 포스번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("CdNo")
    private String CdNo; // CD번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("TranNo")
    private String TranNo; // 거래번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("CasherNo")
    private String CasherNo; // Casher 번호

    @IIrtFldMeta(size = 8)
    @JsonProperty("PosDate")
    private String PosDate; // POS시스템일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("PosTime")
    private String PosTime; // POS시스템시간

    @IIrtFldMeta(size = 20)
    @JsonProperty("SerComUniqNo")
    private String SerComUniqNo; // 회사별 요청자 정보

    @IIrtFldMeta(size = 8)
    @JsonProperty("JumpoSysDate")
    private String JumpoSysDate; // 점포서버 전문전송일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("JumpoSysTime")
    private String JumpoSysTime; // 점포서버 전문전송시간

    @IIrtFldMeta(size = 2)
    @JsonProperty("TranType")
    private String TranType; // 거래 TYPE

    @IIrtFldMeta(size = 1)
    @JsonProperty("CnclClss")
    private String CnclClss; // 취소 구분

    @IIrtFldMeta(size = 18)
    @JsonProperty("AuthCode")
    private String AuthCode; // 인증 코드

    @IIrtFldMeta(size = 3)
    @JsonProperty("PayCurrency")
    private String PayCurrency; // 결제 요청 통화

    @IIrtFldMeta(size = 6)
    @JsonProperty("PayRate")
    private String PayRate; // 결제 요청 환율

    @IIrtFldMeta(size = 12)
    @JsonProperty("PayKrwAmount")
    private String PayKrwAmount; // 결제 요청 금액 (원화)

    @IIrtFldMeta(size = 12)
    @JsonProperty("PayUsdAmount")
    private String PayUsdAmount; // 결제 요청 금액 (외화)

    @IIrtFldMeta(size = 8)
    @JsonProperty("AuthDate")
    private String AuthDate; // 승인 일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("AuthTime")
    private String AuthTime; // 승인 시간

    @IIrtFldMeta(size = 32)
    @JsonProperty("AuthNo")
    private String AuthNo; // 승인 번호

    @IIrtFldMeta(size = 284)
    @JsonProperty("Filler")
    private String Filler; // 예비필드
}
