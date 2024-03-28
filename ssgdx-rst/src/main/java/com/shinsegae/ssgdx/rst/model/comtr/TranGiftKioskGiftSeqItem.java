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
public class TranGiftKioskGiftSeqItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 10)
    @JsonProperty("AdminID")
    private String AdminID; // 사용자(관리자)ID

    @IIrtFldMeta(size = 3)
    @JsonProperty("TranKind")
    private String TranKind; // 거래종류

    @IIrtFldMeta(size = 1)
    @JsonProperty("TranType")
    private String TranType; // 거래형태

    @IIrtFldMeta(size = 4)
    @JsonProperty("PosNo")
    private String PosNo; // POS번호

    @IIrtFldMeta(size = 20)
    @JsonProperty("UserName")
    private String UserName; // 사용자(관리자) 성명

    @IIrtFldMeta(size = 5, isLoopCount = true)
    @JsonProperty("TotalRecordCnt")
    private String TotalRecordCnt; // 총 레코드 건수

    @JsonProperty("RecordList")
    @IIrtFldMeta(dType = EnmTranFieldType.LIST)
    private List<TGKGSIRecordList> RecordList = new ArrayList<TGKGSIRecordList>(); // RecordList
                                                                                   // 반복

    @Getter
    @Setter
    private static class TGKGSIRecordList {

        @IIrtFldMeta(size = 1)
        @JsonProperty("GiftIssuerCode")
        private String GiftIssuerCode; // 상품권발행처코드

        @IIrtFldMeta(size = 3)
        @JsonProperty("GiftTypeCode")
        private String GiftTypeCode; // 상품권권종코드

        @IIrtFldMeta(size = 18)
        @JsonProperty("GiftSeqNo")
        private String GiftSeqNo; // 상품권일련번호

        @IIrtFldMeta(size = 1)
        @JsonProperty("Filler")
        private String Filler; // 예비
    }
}
