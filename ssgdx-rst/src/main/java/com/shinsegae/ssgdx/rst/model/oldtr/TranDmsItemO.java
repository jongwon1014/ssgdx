package com.shinsegae.ssgdx.rst.model.oldtr;

import java.util.ArrayList;
import java.util.List;

import com.shinsegae.ssgdx.ldi.util.IEnumComIrt.EnmTranFieldType;
import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranDmsItemO {

    @IIrtFldMeta(size = 2)
    @JsonProperty("itemcode")
    private String itemcode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("Itemlen")
    private String Itemlen; // ITEM길이

    @IIrtFldMeta(dType = EnmTranFieldType.CLASS)
    @JsonProperty("DmsComHeader")
    private DmsComHeader_O DmsComHeader; // DMS 통신공통Header

    @IIrtFldMeta(dType = EnmTranFieldType.CLASS)
    @JsonProperty("DmsTranHeader")
    private DmsTranHeader_O DmsTranHeader; // DMS Tran Header

    @IIrtFldMeta(dType = EnmTranFieldType.LIST)
    @JsonProperty("DmsItemList")
    private List<DmsItemList_O> DmsItemList = new ArrayList<DmsItemList_O>(); // DMS
                                                                              // 에누리
                                                                              // 행사
                                                                              // Item

    @IIrtFldMeta(dType = EnmTranFieldType.LIST)
    @JsonProperty("DmsCalcItemList")
    private List<DmsCalcItemList_O> DmsCalcItemList = new ArrayList<DmsCalcItemList_O>(); // DMS
                                                                                          // 에누리
                                                                                          // 계산
                                                                                          // 행사
                                                                                          // Item

    // DMS 통신공통Header
    @Getter
    @Setter
    public static class DmsComHeader_O {

        @IIrtFldMeta(size = 6)
        @JsonProperty("MSG_LEN")
        private String MSG_LEN; // 전문길이

        @IIrtFldMeta(size = 8)
        @JsonProperty("MSG_ID")
        private String MSG_ID; // 전문ID

        @IIrtFldMeta(size = 6)
        @JsonProperty("MSG_VER")
        private String MSG_VER; // 전문 버전

        @IIrtFldMeta(size = 8)
        @JsonProperty("SALE_DATE")
        private String SALE_DATE; // 영업일자

        @IIrtFldMeta(size = 4)
        @JsonProperty("STORE_CD")
        private String STORE_CD; // 점코드

        @IIrtFldMeta(size = 4)
        @JsonProperty("POS_NO")
        private String POS_NO; // POS번호

        @IIrtFldMeta(size = 4)
        @JsonProperty("TRAN_NO")
        private String TRAN_NO; // 거래번호

        @IIrtFldMeta(size = 3)
        @JsonProperty("COM_TYPE")
        private String COM_TYPE; // 통신구분

        @IIrtFldMeta(size = 10)
        @JsonProperty("COM_ID")
        private String COM_ID; // 통신ID

        @IIrtFldMeta(size = 8)
        @JsonProperty("COM_DATE")
        private String COM_DATE; // 통신날짜

        @IIrtFldMeta(size = 6)
        @JsonProperty("COM_TIME")
        private String COM_TIME; // 통신시간

        @IIrtFldMeta(size = 20)
        @JsonProperty("USER_INFO")
        private String USER_INFO; // 사용자정보

        @IIrtFldMeta(size = 4)
        @JsonProperty("RES_CODE")
        private String RES_CODE; // 응답 코드*

        @IIrtFldMeta(size = 80)
        @JsonProperty("RES_MSG")
        private String RES_MSG; // 응답 메시지

        @IIrtFldMeta(size = 29)
        @JsonProperty("FILLER")
        private String FILLER; // 예비
    }

    // DMS Tran Header
    @Getter
    @Setter
    public static class DmsTranHeader_O {

        @IIrtFldMeta(size = 1)
        @JsonProperty("USE_FLAG")
        private String USE_FLAG; // 사용구분

        @IIrtFldMeta(size = 10)
        @JsonProperty("IRT_ID")
        private String IRT_ID; // IRT ID

        @IIrtFldMeta(size = 9)
        @JsonProperty("CUST_ID")
        private String CUST_ID; // 고객번호

        @IIrtFldMeta(size = 10)
        @JsonProperty("ENYRI_AMT")
        private String ENYRI_AMT; // 에누리 총액

        @IIrtFldMeta(size = 3)
        @JsonProperty("ENURI_CD_CNT")
        private String ENURI_CD_CNT; // 에누리 행사 개수

        @IIrtFldMeta(size = 3)
        @JsonProperty("ENURI_CD_CALC_CNT")
        private String ENURI_CD_CALC_CNT; // 할인 계산 행사 개수

        @IIrtFldMeta(size = 1)
        @JsonProperty("MANUAL_ENURI_YN")
        private String MANUAL_ENURI_YN; // 수기에누리여부

        @IIrtFldMeta(size = 20)
        @JsonProperty("SMP_CUST_ID")
        private String SMP_CUST_ID; // 스마일페이 고객번호

        @IIrtFldMeta(size = 43)
        @JsonProperty("HEADER_FILLER")
        private String HEADER_FILLER; // 예비
    }

    // DMS 에누리 행사 ITEM
    @Getter
    @Setter
    public static class DmsItemList_O {

        @IIrtFldMeta(size = 2)
        @JsonProperty("ITEM_ID")
        private String ITEM_ID; // 아이템ID

        @IIrtFldMeta(size = 4)
        @JsonProperty("ITEM_LEN")
        private String ITEM_LEN; // 아이템길이

        @IIrtFldMeta(size = 2)
        @JsonProperty("ENURI_EVT_CD")
        private String ENURI_EVT_CD; // 행사종류코드

        @IIrtFldMeta(size = 4)
        @JsonProperty("ENURI_STR_CD")
        private String ENURI_STR_CD; // 점포코드

        @IIrtFldMeta(size = 6)
        @JsonProperty("ENURI_EVT_YM")
        private String ENURI_EVT_YM; // 행사년월

        @IIrtFldMeta(size = 6)
        @JsonProperty("ENURI_EVT_NO")
        private String ENURI_EVT_NO; // 행사번호

        @IIrtFldMeta(size = 6)
        @JsonProperty("CP_ISS_NO")
        private String CP_ISS_NO; // 쿠폰/할인권 발급 번호

        @IIrtFldMeta(size = 10)
        @JsonProperty("CP_NO")
        private String CP_NO; // 쿠폰/할인권번호

        @IIrtFldMeta(size = 2)
        @JsonProperty("CP_DCNT_GB_CD")
        private String CP_DCNT_GB_CD; // 할인구분코드

        @IIrtFldMeta(size = 10)
        @JsonProperty("CP_ENURI_VAL")
        private String CP_ENURI_VAL; // 에누리값

        @IIrtFldMeta(size = 3)
        @JsonProperty("ENURI_MD_CNT")
        private String ENURI_MD_CNT; // 적용MD정보개수

        @IIrtFldMeta(size = 3)
        @JsonProperty("ENURI_PAY_CNT")
        private String ENURI_PAY_CNT; // 적용결제수단개수

        @IIrtFldMeta(size = 2)
        @JsonProperty("CP_ISSUE_TYPE")
        private String CP_ISSUE_TYPE; // 쿠폰 발급 형태

        @IIrtFldMeta(size = 2)
        @JsonProperty("ENURI_FILLER")
        private String ENURI_FILLER; // 캠페인 행사종류

        @IIrtFldMeta(size = 13)
        @JsonProperty("FILLER")
        private String FILLER; // 예비

        @IIrtFldMeta(dType = EnmTranFieldType.LIST)
        @JsonProperty("MdList")
        private List<DILMdList_O> MdList = new ArrayList<DILMdList_O>(); // DMS
                                                                         // 에누리
                                                                         // 행사
                                                                         // ITEM
                                                                         // -
                                                                         // MdList
                                                                         // 적용MD
                                                                         // 반복

        @IIrtFldMeta(dType = EnmTranFieldType.LIST)
        @JsonProperty("PayList")
        private List<DILPayList_O> PayList = new ArrayList<DILPayList_O>(); // DMS
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
        public static class DILMdList_O {

            @IIrtFldMeta(size = 3)
            @JsonProperty("ENURI_ITEM_SEQ")
            private String ENURI_ITEM_SEQ; // Item순번

            @IIrtFldMeta(size = 22)
            @JsonProperty("ENURI_MD_FILLER")
            private String ENURI_MD_FILLER; // 예비
        }

        // DMS 에누리 행사 ITEM - PayList 적용결제수단 반복
        @Getter
        @Setter
        public static class DILPayList_O {

            @IIrtFldMeta(size = 2)
            @JsonProperty("ENURI_PAY_CD")
            private String ENURI_PAY_CD; // 결제수단코드

            @IIrtFldMeta(size = 6)
            @JsonProperty("ENURI_BIN")
            private String ENURI_BIN; // 카드빈

            @IIrtFldMeta(size = 10)
            @JsonProperty("ENURI_PAY_AMT")
            private String ENURI_PAY_AMT; // 결제금액

            @IIrtFldMeta(size = 10)
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

    // DMS 에누리 행사 계산 ITEM
    @Getter
    @Setter
    public static class DmsCalcItemList_O {

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

        @IIrtFldMeta(size = 6)
        @JsonProperty("ENURI_EVT_NO")
        private String ENURI_EVT_NO; // 행사번호

        @IIrtFldMeta(size = 10)
        @JsonProperty("CP_ENURI_VAL")
        private String CP_ENURI_VAL; // 에누리값

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
        private List<DCILMdEnuriList_O> MdEnuriList = new ArrayList<DCILMdEnuriList_O>(); // DMS
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
        private List<DCILPayList_O> PayList = new ArrayList<DCILPayList_O>(); // DMS
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
        public static class DCILMdEnuriList_O {

            @IIrtFldMeta(size = 3)
            @JsonProperty("ENURI_ITEM_SEQ")
            private String ENURI_ITEM_SEQ; // Item순번

            @IIrtFldMeta(size = 3)
            @JsonProperty("ENURI_RATE")
            private String ENURI_RATE; // 할인율(에누리 율)

            @IIrtFldMeta(size = 10)
            @JsonProperty("ENURI_AMOUNT")
            private String ENURI_AMOUNT; // 할인액(에누리 값)

            @IIrtFldMeta(size = 9)
            @JsonProperty("ENURI_MD_FILLER")
            private String ENURI_MD_FILLER; // 예비
        }

        // DMS 에누리 행사 계산 ITEM - PayList 적용결제수단 반복
        @Getter
        @Setter
        public static class DCILPayList_O {

            @IIrtFldMeta(size = 2)
            @JsonProperty("ENURI_PAY_CD")
            private String ENURI_PAY_CD; // 결제수단코드

            @IIrtFldMeta(size = 6)
            @JsonProperty("ENURI_BIN")
            private String ENURI_BIN; // 카드빈

            @IIrtFldMeta(size = 10)
            @JsonProperty("ENURI_PAY_AMT")
            private String ENURI_PAY_AMT; // 결제금액

            @IIrtFldMeta(size = 10)
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
