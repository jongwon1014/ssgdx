package com.shinsegae.ssgdx.rst.model.newtr;

import java.util.ArrayList;
import java.util.List;

import com.shinsegae.ssgdx.ldi.util.IEnumComIrt.EnmTranFieldType;
import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranDmsItemN {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 1)
    @JsonProperty("USE_FLAG")
    private String USE_FLAG; // 사용구분

    @IIrtFldMeta(size = 10)
    @JsonProperty("IRT_ID")
    private String IRT_ID; // IRT ID

    @IIrtFldMeta(size = 9)
    @JsonProperty("CUST_ID")
    private String CUST_ID; // 고객번호

    @IIrtFldMeta(size = 15)
    @JsonProperty("ENURI_AMT")
    private String ENURI_AMT; // 에누리 총액

    @IIrtFldMeta(size = 3)
    @JsonProperty("ENURI_CD_CNT")
    private String ENURI_CD_CNT; // 적용 에누리 행사 개수

    @IIrtFldMeta(size = 3)
    @JsonProperty("ENURI_CD_CALC_CNT")
    private String ENURI_CD_CALC_CNT; // 할인 계산 행사 개수

    @IIrtFldMeta(size = 1)
    @JsonProperty("MANUAL_ENURI_YN")
    private String MANUAL_ENURI_YN; // 수기에누리여부

    @IIrtFldMeta(size = 20)
    @JsonProperty("SMILE_PAY_CUST_NO")
    private String SMILE_PAY_CUST_NO; // 스마일페이 회원번호

    @IIrtFldMeta(size = 43)
    @JsonProperty("HEADER_FILLER")
    private String HEADER_FILLER; // 예비

    @IIrtFldMeta(dType = EnmTranFieldType.LIST)
    @JsonProperty("DmsItemList")
    private List<DmsItemList_N> DmsItemList = new ArrayList<DmsItemList_N>(); // DMS
                                                                              // 에누리
                                                                              // 행사
                                                                              // Item

    @IIrtFldMeta(dType = EnmTranFieldType.LIST)
    @JsonProperty("DmsCalcItemList")
    private List<DmsCalcItemList_N> DmsCalcItemList = new ArrayList<DmsCalcItemList_N>(); // DMS
                                                                                          // 에누리
                                                                                          // 계산
                                                                                          // 행사
                                                                                          // Item

    // DMS 에누리 행사 ITEM
    @Getter
    @Setter
    public static class DmsItemList_N {

        @IIrtFldMeta(size = 2)
        @JsonProperty("ITEM_ID")
        private String ITEM_ID; // 아이템ID

        @IIrtFldMeta(size = 4)
        @JsonProperty("ITEM_LEN")
        private String ITEM_LEN; // 아이템길이

        @IIrtFldMeta(size = 2)
        @JsonProperty("EVT_KIND_CD")
        private String EVT_KIND_CD; // 행사종류코드

        @IIrtFldMeta(size = 4)
        @JsonProperty("STR_CD")
        private String STR_CD; // 점포코드

        @IIrtFldMeta(size = 6)
        @JsonProperty("YM")
        private String YM; // 행사년월

        @IIrtFldMeta(size = 9)
        @JsonProperty("EVT_NO")
        private String EVT_NO; // 행사번호

        @IIrtFldMeta(size = 17)
        @JsonProperty("CP_CD")
        private String CP_CD; // 쿠폰코드

        @IIrtFldMeta(size = 20)
        @JsonProperty("CP_ISS_NO")
        private String CP_ISS_NO; // 쿠폰/할인권 발급 번호

        @IIrtFldMeta(size = 2)
        @JsonProperty("DCNT_GB_CD")
        private String DCNT_GB_CD; // 할인구분코드

        @IIrtFldMeta(size = 3)
        @JsonProperty("NRM_DCRT")
        private String NRM_DCRT; // 정상할인율

        @IIrtFldMeta(size = 3)
        @JsonProperty("EVN_DCRT")
        private String EVN_DCRT; // 행사할인율

        @IIrtFldMeta(size = 15)
        @JsonProperty("DCNT_AMT")
        private String DCNT_AMT; // 할인금액

        @IIrtFldMeta(size = 15)
        @JsonProperty("CP_S_DCNT_AMT")
        private String CP_S_DCNT_AMT; // 신세계분담금액

        @IIrtFldMeta(size = 15)
        @JsonProperty("CP_B_DCNT_AMT")
        private String CP_B_DCNT_AMT; // 협력회사분담금액

        @IIrtFldMeta(size = 15)
        @JsonProperty("CP_C_DCNT_AMT")
        private String CP_C_DCNT_AMT; // 카드사분담금액

        @IIrtFldMeta(size = 3)
        @JsonProperty("MD_CNT")
        private String MD_CNT; // 적용MD정보개수

        @IIrtFldMeta(size = 3)
        @JsonProperty("PAY_CNT")
        private String PAY_CNT; // 적용결제수단개수

        @IIrtFldMeta(size = 2)
        @JsonProperty("CP_ISSUE_TYPE")
        private String CP_ISSUE_TYPE; // 쿠폰 발급 형태

        @IIrtFldMeta(size = 2)
        @JsonProperty("CAMP_KIND_CD")
        private String CAMP_KIND_CD; // 캠페인 행사종류

        @IIrtFldMeta(size = 8)
        @JsonProperty("CP_CACL_VALID_DATE")
        private String CP_CACL_VALID_DATE; // 취소유효기간

        @IIrtFldMeta(size = 50)
        @JsonProperty("FILLER")
        private String FILLER; // 예비

        @IIrtFldMeta(dType = EnmTranFieldType.LIST)
        @JsonProperty("MdList")
        private List<DILMdList_N> MdList = new ArrayList<DILMdList_N>(); // DMS
                                                                         // 에누리
                                                                         // 행사
                                                                         // ITEM
                                                                         // -
                                                                         // MdList
                                                                         // 적용MD
                                                                         // 반복

        @IIrtFldMeta(dType = EnmTranFieldType.LIST)
        @JsonProperty("PayList")
        private List<DILPayList_N> PayList = new ArrayList<DILPayList_N>(); // DMS
                                                                            // 에누리
                                                                            // 행사
                                                                            // ITEM
                                                                            // -
                                                                            // PayList
                                                                            // 적용결제수단
                                                                            // 반복

        // DMS 에누리 행사 ITEM - MdList 적용MD 반복
        @Getter
        @Setter
        public static class DILMdList_N {

            @IIrtFldMeta(size = 3)
            @JsonProperty("MD_ITEM_SEQ")
            private String MD_ITEM_SEQ; // Item순번

            @IIrtFldMeta(size = 22)
            @JsonProperty("MD_FILLER")
            private String MD_FILLER; // 예비
        }

        // DMS 에누리 행사 ITEM - PayList 적용결제수단 반복
        @Getter
        @Setter
        public static class DILPayList_N {

            @IIrtFldMeta(size = 2)
            @JsonProperty("PAY_CD")
            private String PAY_CD; // 결제수단코드

            @IIrtFldMeta(size = 6)
            @JsonProperty("PAY_BIN")
            private String PAY_BIN; // 카드빈

            @IIrtFldMeta(size = 15)
            @JsonProperty("PAY_AMT")
            private String PAY_AMT; // 결제금액

            @IIrtFldMeta(size = 15)
            @JsonProperty("PAY_DC_AMT")
            private String PAY_DC_AMT; // 에누리 금액

            @IIrtFldMeta(size = 8)
            @JsonProperty("PAY_BIN8")
            private String PAY_BIN8; // 카드빈8

            @IIrtFldMeta(size = 14)
            @JsonProperty("PAY_FILLER")
            private String PAY_FILLER; // 예비
        }
    }

    // DMS 에누리 행사 계산 ITEM
    @Getter
    @Setter
    public static class DmsCalcItemList_N {

        @IIrtFldMeta(size = 2)
        @JsonProperty("ITEM_ID")
        private String ITEM_ID; // 아이템ID

        @IIrtFldMeta(size = 4)
        @JsonProperty("ITEM_LEN")
        private String ITEM_LEN; // 아이템길이

        @IIrtFldMeta(size = 2)
        @JsonProperty("ENURI_EVT_CD")
        private String ENURI_EVT_CD; // 행사종류코드(행사구분)

        @IIrtFldMeta(size = 4)
        @JsonProperty("ENURI_STR_CD")
        private String ENURI_STR_CD; // 점포코드

        @IIrtFldMeta(size = 6)
        @JsonProperty("ENURI_EVT_YM")
        private String ENURI_EVT_YM; // 행사년월

        @IIrtFldMeta(size = 9)
        @JsonProperty("ENURI_EVT_NO")
        private String ENURI_EVT_NO; // 행사번호

        @IIrtFldMeta(size = 17)
        @JsonProperty("CP_CD")
        private String CP_CD; // 쿠폰코드

        @IIrtFldMeta(size = 3)
        @JsonProperty("ENURI_NRM_ENRT")
        private String ENURI_NRM_ENRT; // 정상할인율

        @IIrtFldMeta(size = 3)
        @JsonProperty("ENURI_EVN_ENRT")
        private String ENURI_EVN_ENRT; // 행사할인율

        @IIrtFldMeta(size = 15)
        @JsonProperty("ENURI_DCNT_AMT")
        private String ENURI_DCNT_AMT; // 할인금액

        @IIrtFldMeta(size = 3)
        @JsonProperty("ENURI_MD_CNT")
        private String ENURI_MD_CNT; // 적용MD정보개수

        @IIrtFldMeta(size = 3)
        @JsonProperty("ENURI_PAY_CNT")
        private String ENURI_PAY_CNT; // 적용결제수단개수

        @IIrtFldMeta(size = 35)
        @JsonProperty("ENURI_FILLER")
        private String ENURI_FILLER; // 예비

        @IIrtFldMeta(dType = EnmTranFieldType.LIST)
        @JsonProperty("MdEnuriList")
        private List<DCILMdEnuriList_N> MdEnuriList = new ArrayList<DCILMdEnuriList_N>(); // DMS
                                                                                          // 에누리
                                                                                          // 행사
                                                                                          // 계산
                                                                                          // ITEM
                                                                                          // -
                                                                                          // MdList
                                                                                          // 적용MD
                                                                                          // 반복

        @IIrtFldMeta(dType = EnmTranFieldType.LIST)
        @JsonProperty("PayList")
        private List<DCILPayList_N> PayList = new ArrayList<DCILPayList_N>(); // DMS
                                                                              // 에누리
                                                                              // 행사
                                                                              // 계산
                                                                              // ITEM
                                                                              // -
                                                                              // PayList
                                                                              // 적용결제수단
                                                                              // 반복

        // DMS 에누리 행사 계산 ITEM - MdList 적용MD 반복
        @Getter
        @Setter
        public static class DCILMdEnuriList_N {

            @IIrtFldMeta(size = 3)
            @JsonProperty("ENURI_ITEM_SEQ")
            private String ENURI_ITEM_SEQ; // Item순번

            @IIrtFldMeta(size = 3)
            @JsonProperty("ENURI_RATE")
            private String ENURI_RATE; // 할인율(에누리 율)

            @IIrtFldMeta(size = 15)
            @JsonProperty("ENURI_AMOUNT")
            private String ENURI_AMOUNT; // 할인액(에누리 값)

            @IIrtFldMeta(size = 22)
            @JsonProperty("ENURI_MD_FILLER")
            private String ENURI_MD_FILLER; // 예비
        }

        // DMS 에누리 행사 계산 ITEM - PayList 적용결제수단 반복
        @Getter
        @Setter
        public static class DCILPayList_N {

            @IIrtFldMeta(size = 2)
            @JsonProperty("ENURI_PAY_CD")
            private String ENURI_PAY_CD; // 결제수단코드

            @IIrtFldMeta(size = 6)
            @JsonProperty("ENURI_BIN")
            private String ENURI_BIN; // 카드빈

            @IIrtFldMeta(size = 15)
            @JsonProperty("ENURI_PAY_AMT")
            private String ENURI_PAY_AMT; // 결제금액

            @IIrtFldMeta(size = 15)
            @JsonProperty("ENURI_DC_AMT")
            private String ENURI_DC_AMT; // 에누리 금액

            @IIrtFldMeta(size = 8)
            @JsonProperty("ENURI_BIN8")
            private String ENURI_BIN8; // 카드빈8

            @IIrtFldMeta(size = 14)
            @JsonProperty("ENURI_PAY_FILLER")
            private String ENURI_PAY_FILLER; // 예비
        }
    }
}
