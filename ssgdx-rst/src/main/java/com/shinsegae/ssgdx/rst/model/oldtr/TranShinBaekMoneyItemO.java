package com.shinsegae.ssgdx.rst.model.oldtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranShinBaekMoneyItemO {

    // CommHeader
    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // Item코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // Item길이

    @IIrtFldMeta(size = 2)
    @JsonProperty("com_id_1")
    private String com_id_1; // TEXT ID - 대외기관 코드

    @IIrtFldMeta(size = 1)
    @JsonProperty("com_id_2")
    private String com_id_2; // TEXT ID - 대외기간 상세코드

    @IIrtFldMeta(size = 3)
    @JsonProperty("com_id_3")
    private String com_id_3; // TEXT ID - 전문구분

    @IIrtFldMeta(size = 4)
    @JsonProperty("com_len")
    private String com_len; // 전문길이

    @IIrtFldMeta(size = 6)
    @JsonProperty("com_seq_no")
    private String com_seq_no; // 전문일련번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("com_st_code")
    private String com_st_code; // 점코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("com_tm_no")
    private String com_tm_no; // 포스번호

    @IIrtFldMeta(size = 6)
    @JsonProperty("com_casher_no")
    private String com_casher_no; // 캐셔번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("com_chit_no")
    private String com_chit_no; // 일련번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("com_tran_no")
    private String com_tran_no; // POS거래번호

    @IIrtFldMeta(size = 6)
    @JsonProperty("com_req_man_no")
    private String com_req_man_no; // 요청자 고유정보

    @IIrtFldMeta(size = 8)
    @JsonProperty("com_auth_date")
    private String com_auth_date; // 영업일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("com_auth_time")
    private String com_auth_time; // 영업시간

    @IIrtFldMeta(size = 8)
    @JsonProperty("com_send_date")
    private String com_send_date; // 전문전송일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("com_send_time")
    private String com_send_time; // 전문전송시간

    // Header
    @IIrtFldMeta(size = 4)
    @JsonProperty("MSG_LEN")
    private String MSG_LEN; // 전문길이

    @IIrtFldMeta(size = 8)
    @JsonProperty("MSG_ID")
    private String MSG_ID; // 전문 ID

    @IIrtFldMeta(size = 8)
    @JsonProperty("MCH_SEND_DATE")
    private String MCH_SEND_DATE; // 전문전송일자

    @IIrtFldMeta(size = 20)
    @JsonProperty("MCHH_SEND_UNIQ_NO")
    private String MCHH_SEND_UNIQ_NO; // 전송 거래 고유번호

    @IIrtFldMeta(size = 15)
    @JsonProperty("GIFT_MCH_NO")
    private String GIFT_MCH_NO; // 가맹점번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("MSG_GUBUN")
    private String MSG_GUBUN; // 요청구분

    @IIrtFldMeta(size = 4)
    @JsonProperty("SER_COM_CD ")
    private String SER_COM_CD; // 회사코드

    @IIrtFldMeta(size = 8)
    @JsonProperty("SALE_DATE")
    private String SALE_DATE; // 영업일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("SALE_TIME")
    private String SALE_TIME; // 영업시간

    @IIrtFldMeta(size = 10)
    @JsonProperty("ST_CODE")
    private String ST_CODE; // 점코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("TM_NO")
    private String TM_NO; // 포스 번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("CD_NO")
    private String CD_NO; // CD 번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("TRAN_NO")
    private String TRAN_NO; // 거래 번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("CASHER_NO")
    private String CASHER_NO; // Casher 번호

    @IIrtFldMeta(size = 8)
    @JsonProperty("POS_DATE")
    private String POS_DATE; // POS시스템일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("POS_TIME")
    private String POS_TIME; // POS시스템시간

    @IIrtFldMeta(size = 8)
    @JsonProperty("JUMPO_SYS_DATE ")
    private String JUMPO_SYS_DATE; // 점포서버 전문전송일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("JUMPO_SYS_TIME")
    private String JUMPO_SYS_TIME; // 점포서버 전문전송시간

    @IIrtFldMeta(size = 20)
    @JsonProperty("SER_COM_UNIQ_NO")
    private String SER_COM_UNIQ_NO; // MD코드

    @IIrtFldMeta(size = 53)
    @JsonProperty("HEAD_ETC_FIELD")
    private String HEAD_ETC_FIELD; // 헤더예비필드

    // Data
    @IIrtFldMeta(size = 2)
    @JsonProperty("TRAN_TYPE")
    private String TRAN_TYPE; // 거래 TYPE

    @IIrtFldMeta(size = 2)
    @JsonProperty("TRADE_TYPE")
    private String TRADE_TYPE; // 요청 TYPE

    @IIrtFldMeta(size = 100)
    @JsonProperty("GIFT_CARD_NO")
    private String GIFT_CARD_NO; // GIFT 카드번호

    @IIrtFldMeta(size = 50)
    @JsonProperty("GIFT_CONFIRM_NO")
    private String GIFT_CONFIRM_NO; // GIFT 인증번호

    @IIrtFldMeta(size = 2)
    @JsonProperty("KEY_IN_TYPE")
    private String KEY_IN_TYPE; // KEY_IN 유무

    @IIrtFldMeta(size = 12)
    @JsonProperty("TRADE_AMT")
    private String TRADE_AMT; // 요청금액

    @IIrtFldMeta(size = 1)
    @JsonProperty("SPECIAL_GUBUN")
    private String SPECIAL_GUBUN; // 미수수료 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("USE_GUBUN")
    private String USE_GUBUN; // 사용구분

    @IIrtFldMeta(size = 4)
    @JsonProperty("GIFT_CODE")
    private String GIFT_CODE; // 권종코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ORG_SER_COM_CD")
    private String ORG_SER_COM_CD; // 원거래 회사코드

    @IIrtFldMeta(size = 8)
    @JsonProperty("ORG_SALE_DATE")
    private String ORG_SALE_DATE; // 원거래 영업일자

    @IIrtFldMeta(size = 10)
    @JsonProperty("ORG_ST_CODE")
    private String ORG_ST_CODE; // 원거래 점코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ORG_TM_NO")
    private String ORG_TM_NO; // 원거래 포스 번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("ORG_TRAN_NO")
    private String ORG_TRAN_NO; // 원거래 거래 번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("ORG_CD_NO")
    private String ORG_CD_NO; // 원거래 CD 번호

    @IIrtFldMeta(size = 8)
    @JsonProperty("ORG_SEND_DATE")
    private String ORG_SEND_DATE; // 원거래 전문전송일자

    @IIrtFldMeta(size = 20)
    @JsonProperty("ORG_SEND_UNIQ_NO")
    private String ORG_SEND_UNIQ_NO; // 원거래 전송거래 고유번호

    @IIrtFldMeta(size = 15)
    @JsonProperty("ORG_GIFT_MCH_NO")
    private String ORG_GIFT_MCH_NO; // 원거래 가맹점번호

    @IIrtFldMeta(size = 8)
    @JsonProperty("ORG_AUTH_DATE")
    private String ORG_AUTH_DATE; // 원거래 승인일자

    @IIrtFldMeta(size = 8)
    @JsonProperty("ORG_AUTH_NO")
    private String ORG_AUTH_NO; // 원거래 승인번호

    @IIrtFldMeta(size = 8)
    @JsonProperty("AUTH_DATE")
    private String AUTH_DATE; // 승인일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("AUTH_TIME")
    private String AUTH_TIME; // 승인시간

    @IIrtFldMeta(size = 8)
    @JsonProperty("AUTH_NO")
    private String AUTH_NO; // 승인번호

    @IIrtFldMeta(size = 12)
    @JsonProperty("REMAIN_AMT")
    private String REMAIN_AMT; // 상품권잔액

    @IIrtFldMeta(size = 4)
    @JsonProperty("RESP_CODE")
    private String RESP_CODE; // 응답코드

    @IIrtFldMeta(size = 60)
    @JsonProperty("RESP_MSG")
    private String RESP_MSG; // 응답메시지

    @IIrtFldMeta(size = 100)
    @JsonProperty("DELEGATE_BARCODE_NO")
    private String DELEGATE_BARCODE_NO; // 통합플랫폼 바코드

    @IIrtFldMeta(size = 1)
    @JsonProperty("ITD_RPT_TYPE")
    private String ITD_RPT_TYPE; // 소득공제 신고유형

    @IIrtFldMeta(size = 32)
    @JsonProperty("ITD_RPT_INFO")
    private String ITD_RPT_INFO; // 소득공제 식별정보

    @IIrtFldMeta(size = 12)
    @JsonProperty("ITD_EXCL_AMT")
    private String ITD_EXCL_AMT; // 소득공제 제외금액

    @IIrtFldMeta(size = 12)
    @JsonProperty("CASH_RECEIPT_REPORT_AMT")
    private String CASH_RECEIPT_REPORT_AMT; // 현금영수증 신고 가능금액

    @IIrtFldMeta(size = 167)
    @JsonProperty("DATA_ETC_FIELD")
    private String DATA_ETC_FIELD; // DATA예비필드

    @IIrtFldMeta(size = 1)
    @JsonProperty("MSG_END")
    private String MSG_END; // 전문 종료 내역
}
