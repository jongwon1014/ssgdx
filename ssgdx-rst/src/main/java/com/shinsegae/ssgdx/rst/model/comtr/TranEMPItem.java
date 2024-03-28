package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranEMPItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 2)
    @JsonProperty("TranType")
    private String TranType; // 거래 타입

    @IIrtFldMeta(size = 1)
    @JsonProperty("AuthKind")
    private String AuthKind; // 사원인증구분

    @IIrtFldMeta(size = 10)
    @JsonProperty("EmpCardNo")
    private String EmpCardNo; // 사원증번호

    @IIrtFldMeta(size = 20)
    @JsonProperty("CardNo")
    private String CardNo; // 카드번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("InputKind")
    private String InputKind; // KEY-IN구분

    @IIrtFldMeta(size = 12)
    @JsonProperty("TotalAmount")
    private String TotalAmount; // 총매출금액

    @IIrtFldMeta(size = 12)
    @JsonProperty("NetAmount")
    private String NetAmount; // 순매출금액

    @IIrtFldMeta(size = 12)
    @JsonProperty("EmpDcAmount")
    private String EmpDcAmount; // 직원할인금액

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
    @JsonProperty("OrgTrdNo")
    private String OrgTrdNo; // 원거래 거래 번호

    @IIrtFldMeta(size = 20)
    @JsonProperty("OrgUniqueNo")
    private String OrgUniqueNo; // 원거래 고유 번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("HostStatus")
    private String HostStatus; // 승인주체

    @IIrtFldMeta(size = 20)
    @JsonProperty("ApprovalNo")
    private String ApprovalNo; // 승인번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("EmpNo")
    private String EmpNo; // 사번

    @IIrtFldMeta(size = 10)
    @JsonProperty("CorpCode")
    private String CorpCode; // 소속사코드

    @IIrtFldMeta(size = 10)
    @JsonProperty("LevelCode")
    private String LevelCode; // 직급코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("PluCount")
    private String PluCount; // 회사별 물품수

    @IIrtFldMeta(size = 20)
    @JsonProperty("PluCode")
    private String PluCode; // 회사별 물품코드

    @IIrtFldMeta(size = 20)
    @JsonProperty("MsgUniqueNo")
    private String MsgUniqueNo; // 회사별 업무 고유번호

    @IIrtFldMeta(size = 20)
    @JsonProperty("Filler")
    private String Filler; // FILLER
}
