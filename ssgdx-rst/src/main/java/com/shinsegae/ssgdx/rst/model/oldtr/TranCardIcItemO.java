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
public class TranCardIcItemO {

    @IIrtFldMeta(size = 2)
    @JsonProperty("itemcode")
    private String itemcode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("Itemlen")
    private String Itemlen; // ITEM길이

    @IIrtFldMeta(size = 1)
    @JsonProperty("TMS_TYPE")
    private String TMS_TYPE; // 거래구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("CARD_TYPE")
    private String CARD_TYPE; // 결제구분

    @IIrtFldMeta(size = 3)
    @JsonProperty("AUTH_CNT")
    private String AUTH_CNT; // 카드 승인 개수

    @IIrtFldMeta(size = 8)
    @JsonProperty("AUTH_DATE")
    private String AUTH_DATE; // 승인일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("AUTH_TIME")
    private String AUTH_TIME; // 승인시각

    @IIrtFldMeta(size = 2)
    @JsonProperty("CARD_KIND")
    private String CARD_KIND; // 카드종류

    @IIrtFldMeta(size = 2)
    @JsonProperty("AUTH_IN_CLSS")
    private String AUTH_IN_CLSS; // 카드입력구분

    @IIrtFldMeta(size = 2)
    @JsonProperty("POINT_FLAG")
    private String POINT_FLAG; // 포인트 적용 유무

    @IIrtFldMeta(size = 16)
    @JsonProperty("PASSWORD")
    private String PASSWORD; // 비밀번호

    @IIrtFldMeta(size = 12)
    @JsonProperty("AUTH_NO")
    private String AUTH_NO; // 승인번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("POINT_SALE_AMT")
    private String POINT_SALE_AMT; // 포인트지불금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("PRE_POINT1")
    private String PRE_POINT1; // 포인트사용가능금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("PRE_POINT2")
    private String PRE_POINT2; // 포인트지불가능금액

    @IIrtFldMeta(size = 2)
    @JsonProperty("INS_MON")
    private String INS_MON; // 할부개월

    @IIrtFldMeta(size = 11)
    @JsonProperty("PURE_SALE_AMT")
    private String PURE_SALE_AMT; // 순수카드매출금액

    @IIrtFldMeta(size = 1)
    @JsonProperty("CARD_AUTH_SBJ")
    private String CARD_AUTH_SBJ; // 승인주체

    @IIrtFldMeta(size = 4)
    @JsonProperty("AUTH_NUM")
    private String AUTH_NUM; // 카드사 번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("AUTH_SEQ")
    private String AUTH_SEQ; // 카드 순번

    @IIrtFldMeta(size = 11)
    @JsonProperty("PART_RCPT_AMT")
    private String PART_RCPT_AMT; // 일부입금

    @IIrtFldMeta(size = 11)
    @JsonProperty("TOT_SALE_AMT")
    private String TOT_SALE_AMT; // 총매출

    @IIrtFldMeta(size = 11)
    @JsonProperty("DSCNT_AMT")
    private String DSCNT_AMT; // 에누리

    @IIrtFldMeta(size = 11)
    @JsonProperty("BAG_AMT")
    private String BAG_AMT; // 쇼핑백 금액

    @IIrtFldMeta(dType = EnmTranFieldType.LIST)
    @JsonProperty("ItemList")
    private List<TranCardIcItemOItemList> ItemList = new ArrayList<TranCardIcItemOItemList>(); // 상품정보(반복-6개)

    @IIrtFldMeta(size = 11)
    @JsonProperty("SALE_ETC")
    private String SALE_ETC; // 매출기타

    @IIrtFldMeta(size = 1)
    @JsonProperty("DCC_FLAG")
    private String DCC_FLAG; // DCC여부

    @IIrtFldMeta(size = 16)
    @JsonProperty("DccForeignAmt")
    private String DccForeignAmt; // DCC-Foreign Amount

    @IIrtFldMeta(size = 10)
    @JsonProperty("DccExchangeRate")
    private String DccExchangeRate; // DCC-Exchange Rate

    @IIrtFldMeta(size = 3)
    @JsonProperty("DccExchangeCode")
    private String DccExchangeCode; // DCC-통화코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("CARD_SEQ_NO")
    private String CARD_SEQ_NO; // 카드일련번호

    @IIrtFldMeta(size = 2)
    @JsonProperty("ISSUE_FIRM_CODE")
    private String ISSUE_FIRM_CODE; // 발행사

    @IIrtFldMeta(size = 2)
    @JsonProperty("BUY_FIRM_CODE")
    private String BUY_FIRM_CODE; // 매입사

    @IIrtFldMeta(size = 1)
    @JsonProperty("SSG_CARD_FLAG")
    private String SSG_CARD_FLAG; // SSG PAY CARD 구분

    @IIrtFldMeta(size = 6)
    @JsonProperty("DEBIT_SEQ_NO")
    private String DEBIT_SEQ_NO; // 직불 일련번호

    @IIrtFldMeta(size = 2)
    @JsonProperty("DONGLE_READ_TYPE")
    private String DONGLE_READ_TYPE; // 동글-거래구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("DONGLE_MOBILE_TYPE")
    private String DONGLE_MOBILE_TYPE; // 동글-이통사구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("DONGLE_CARD_TYPE")
    private String DONGLE_CARD_TYPE; // 동글-카드방식(결제)

    @IIrtFldMeta(size = 1)
    @JsonProperty("DONGLE_CARD_KIND")
    private String DONGLE_CARD_KIND; // 동글-카드종류

    @IIrtFldMeta(size = 1)
    @JsonProperty("DONGLE_CVM")
    private String DONGLE_CVM; // 동글-CVM

    @IIrtFldMeta(size = 10)
    @JsonProperty("PreCard_Chan_Amt")
    private String PreCard_Chan_Amt; // 선불카드 잔액

    @IIrtFldMeta(size = 20)
    @JsonProperty("CARD_NO")
    private String CARD_NO; // 카드 번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("CARD_ENCRYPT_FLAG")
    private String CARD_ENCRYPT_FLAG; // 암호화 여부

    @IIrtFldMeta(size = 16)
    @JsonProperty("POS_TML_NO")
    private String POS_TML_NO; // SW 모델 번호

    @IIrtFldMeta(size = 16)
    @JsonProperty("READER_TML_NO")
    private String READER_TML_NO; // HW 모델 번호

    @IIrtFldMeta(size = 127)
    @JsonProperty("CARD_DATA")
    private String CARD_DATA; // 카드 DATA(암호화)카드사

    @IIrtFldMeta(size = 127)
    @JsonProperty("CARD_DATA_VAN")
    private String CARD_DATA_VAN; // 카드 DATA(암호화)VAN사

    @IIrtFldMeta(size = 1)
    @JsonProperty("IC_TMS_TYPE")
    private String IC_TMS_TYPE; // 거래 형태

    @IIrtFldMeta(size = 2)
    @JsonProperty("IC_FALL_BACK_TYPE")
    private String IC_FALL_BACK_TYPE; // FallBack 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("IC_CARD_TYPE")
    private String IC_CARD_TYPE; // IC 카드 종류

    @IIrtFldMeta(size = 2)
    @JsonProperty("IC_VAN_CODE")
    private String IC_VAN_CODE; // IC-VAN사 키 코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("IC_EMV_LEN")
    private String IC_EMV_LEN; // IC-EMV 데이터 길이

    @IIrtFldMeta(size = 1)
    @JsonProperty("IC_ForceCancelFg")
    private String IC_ForceCancelFg; // IC 강제취소구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("DA_TYPE")
    private String DA_TYPE; // 직승인유무

    @IIrtFldMeta(size = 12)
    @JsonProperty("LTEApprovalSeq")
    private String LTEApprovalSeq; // LTE VAN 승인번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("ForceTranSendFlag")
    private String ForceTranSendFlag; // LTE VAN 취소 강제 TRAN 전송 구분

    @IIrtFldMeta(size = 85)
    @JsonProperty("IC_FILLER")
    private String IC_FILLER; // IC 거래 예비필드

    @IIrtFldMeta(size = 1400)
    @JsonProperty("CHIP_DATA")
    private String CHIP_DATA; // 칩 데이터

    @IIrtFldMeta(size = 10)
    @JsonProperty("CARD_EVENT_KEY")
    private String CARD_EVENT_KEY; // BMP 카드행사 KEY

    @IIrtFldMeta(size = 1)
    @JsonProperty("TM_GUBN")
    private String TM_GUBN; // 장비구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("CERTIFICATION_FLAG")
    private String CERTIFICATION_FLAG; // 인증조회된 승인요청 여부

    @IIrtFldMeta(size = 12)
    @JsonProperty("CERTIFICATION_AUTH_NO")
    private String CERTIFICATION_AUTH_NO; // 구인증조회 승인번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("EDI_DSCNT_FLAG")
    private String EDI_DSCNT_FLAG; // 청구할인

    @IIrtFldMeta(size = 9)
    @JsonProperty("CUP_AMT")
    private String CUP_AMT; // 컵보증금

    @IIrtFldMeta(size = 24)
    @JsonProperty("FILLER")
    private String FILLER; // 예비

    /**
     * 상품정보(반복-6개)
     */
    @Getter
    @Setter
    public static class TranCardIcItemOItemList {

        @IIrtFldMeta(size = 16)
        @JsonProperty("CODE")
        private String CODE; // 상품코드

        @IIrtFldMeta(size = 4)
        @JsonProperty("CNT")
        private String CNT; // 상품수량

        @IIrtFldMeta(size = 11)
        @JsonProperty("AMT")
        private String AMT; // 상품금액

        @IIrtFldMeta(size = 2)
        @JsonProperty("CLSS")
        private String CLSS; // 상품명구분
    }
}
