package com.shinsegae.ssgdx.rst.model.oldtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranEasyPaymentItemO {

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
    private String com_id_2; // TEXT ID - 대외기관 코드

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
    private String com_chit_no; // CD 일련번호

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

    @IIrtFldMeta(size = 4)
    @JsonProperty("com_item_seq")
    private String com_item_seq; // ITEM 순번

    @IIrtFldMeta(size = 100)
    @JsonProperty("RETRIEVAL_NO")
    private String RETRIEVAL_NO; // 거래고유번호

    @IIrtFldMeta(size = 40)
    @JsonProperty("CAT_ID")
    private String CAT_ID; // 단말기아이디

    @IIrtFldMeta(size = 20)
    @JsonProperty("BUZ_NO")
    private String BUZ_NO; // 사업자번호

    @IIrtFldMeta(size = 40)
    @JsonProperty("MER_ID")
    private String MER_ID; // 가맹점아이디(TID)

    @IIrtFldMeta(size = 40)
    @JsonProperty("MER_PASSWORD")
    private String MER_PASSWORD; // 가맹점비밀번호

    @IIrtFldMeta(size = 150)
    @JsonProperty("HEADER_FILLER")
    private String HEADER_FILLER; // 예비

    @IIrtFldMeta(size = 5)
    @JsonProperty("PAYMENT_TYPE")
    private String PAYMENT_TYPE; // 결제타입

    @IIrtFldMeta(size = 1)
    @JsonProperty("POS_TYPE")
    private String POS_TYPE; // 단말기구분

    @IIrtFldMeta(size = 10)
    @JsonProperty("CURR_CODE")
    private String CURR_CODE; // 통화코드

    @IIrtFldMeta(size = 10)
    @JsonProperty("MAIN_PAY_TYPE")
    private String MAIN_PAY_TYPE; // 메인결제수단

    @IIrtFldMeta(size = 1)
    @JsonProperty("MULTI_PAY_YN")
    private String MULTI_PAY_YN; // 복합결제여부

    @IIrtFldMeta(size = 100)
    @JsonProperty("BARCODE_NO")
    private String BARCODE_NO; // 바코드

    @IIrtFldMeta(size = 100)
    @JsonProperty("ETC_CARD_NO")
    private String ETC_CARD_NO; // 카드번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("ISSHINSEGAE_POINT")
    private String ISSHINSEGAE_POINT; // 신세계포인트여부

    @IIrtFldMeta(size = 20)
    @JsonProperty("SHINSEAGE_POINT_NO")
    private String SHINSEAGE_POINT_NO; // 신세계포인트카드

    @IIrtFldMeta(size = 1)
    @JsonProperty("SHINSEAGE_POINT_USE_YN")
    private String SHINSEAGE_POINT_USE_YN; // 신세계포인트카드사용여부

    @IIrtFldMeta(size = 12)
    @JsonProperty("TOT_SALE_AMT")
    private String TOT_SALE_AMT; // 결제총금액

    @IIrtFldMeta(size = 12)
    @JsonProperty("DISCOUNT_AMT")
    private String DISCOUNT_AMT; // 할인금액

    @IIrtFldMeta(size = 12)
    @JsonProperty("PURE_SALE_AMT")
    private String PURE_SALE_AMT; // 결제요청금액

    @IIrtFldMeta(size = 5)
    @JsonProperty("DEPOSIT_TYPE")
    private String DEPOSIT_TYPE; // 보증금type

    @IIrtFldMeta(size = 12)
    @JsonProperty("DEPOSIT_AMT")
    private String DEPOSIT_AMT; // 보증금 금액

    @IIrtFldMeta(size = 12)
    @JsonProperty("TAX_FREE_AMT")
    private String TAX_FREE_AMT; // 면세상품금액

    @IIrtFldMeta(size = 12)
    @JsonProperty("TAX_AMT")
    private String TAX_AMT; // 과세상품금액

    @IIrtFldMeta(size = 12)
    @JsonProperty("ZERO_AMT")
    private String ZERO_AMT; // 영세상품금액

    @IIrtFldMeta(size = 12)
    @JsonProperty("TIP_AMT")
    private String TIP_AMT; // 봉사료

    @IIrtFldMeta(size = 12)
    @JsonProperty("EXCLUDE_AMT")
    private String EXCLUDE_AMT; // 증빙제외

    @IIrtFldMeta(size = 12)
    @JsonProperty("RECV_DISCOUNT_AMT")
    private String RECV_DISCOUNT_AMT; // 할인금액

    @IIrtFldMeta(size = 12)
    @JsonProperty("RECV_AUTH_AMT")
    private String RECV_AUTH_AMT; // 승인금액

    @IIrtFldMeta(size = 2)
    @JsonProperty("INS_MON")
    private String INS_MON; // 할부개월

    @IIrtFldMeta(size = 8)
    @JsonProperty("AUTH_DATE")
    private String AUTH_DATE; // 승인일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("AUTH_TIME")
    private String AUTH_TIME; // 승인시간

    @IIrtFldMeta(size = 50)
    @JsonProperty("AUTH_NO")
    private String AUTH_NO; // 승인번호

    @IIrtFldMeta(size = 8)
    @JsonProperty("VAN_AUTH_DATE")
    private String VAN_AUTH_DATE; // VAN 승인일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("VAN_AUTH_TIME")
    private String VAN_AUTH_TIME; // VAN 승인시간

    @IIrtFldMeta(size = 50)
    @JsonProperty("VAN_AUTH_NO")
    private String VAN_AUTH_NO; // VAN 승인번호

    @IIrtFldMeta(size = 8)
    @JsonProperty("ORG_SALE_DATE")
    private String ORG_SALE_DATE; // 원거래 승인일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("ORG_AUTH_TIME")
    private String ORG_AUTH_TIME; // 원거래 승인시간

    @IIrtFldMeta(size = 50)
    @JsonProperty("ORG_AUTH_NO")
    private String ORG_AUTH_NO; // 원거래 승인번호

    @IIrtFldMeta(size = 100)
    @JsonProperty("ORG_RETRIEVAL_NO")
    private String ORG_RETRIEVAL_NO; // 원거래 고유번호

    @IIrtFldMeta(size = 2)
    @JsonProperty("BUY_FIRM_CODE")
    private String BUY_FIRM_CODE; // 매입사코드

    @IIrtFldMeta(size = 20)
    @JsonProperty("BUY_FIRM_NM")
    private String BUY_FIRM_NM; // 매입사명

    @IIrtFldMeta(size = 2)
    @JsonProperty("ISSUE_FIRM_CODE")
    private String ISSUE_FIRM_CODE; // 발급사코드

    @IIrtFldMeta(size = 20)
    @JsonProperty("ISSUE_FIRM_NM")
    private String ISSUE_FIRM_NM; // 발급사명

    @IIrtFldMeta(size = 12)
    @JsonProperty("ENABLE_AMT")
    private String ENABLE_AMT; // 사용가능금액

    @IIrtFldMeta(size = 1)
    @JsonProperty("CARD_BIN_TYPE")
    private String CARD_BIN_TYPE; // 카드BIN type

    @IIrtFldMeta(size = 10)
    @JsonProperty("CARD_BIN_NO")
    private String CARD_BIN_NO; // 카드BIN 번호

    @IIrtFldMeta(size = 40)
    @JsonProperty("MD_CODE")
    private String MD_CODE; // 대표상품코드

    @IIrtFldMeta(size = 50)
    @JsonProperty("MD_NM")
    private String MD_NM; // 상품명

    @IIrtFldMeta(size = 2)
    @JsonProperty("VAN_CLSS")
    private String VAN_CLSS; // 승인기관

    @IIrtFldMeta(size = 1)
    @JsonProperty("CHECK_CLSS")
    private String CHECK_CLSS; // 신용/체크 구분자

    @IIrtFldMeta(size = 1)
    @JsonProperty("MUNHWA_FLAG")
    private String MUNHWA_FLAG; // 도서/공연비 여부

    @IIrtFldMeta(size = 20)
    @JsonProperty("EDI_DSCNT_FLAG")
    private String EDI_DSCNT_FLAG; // 청구할인 여부

    @IIrtFldMeta(size = 2)
    @JsonProperty("MULTI_CARD_MEMBER_STORE")
    private String MULTI_CARD_MEMBER_STORE; // 멀티가맹점 구분

    @IIrtFldMeta(size = 4)
    @JsonProperty("RESP_CODE")
    private String RESP_CODE; // 응답코드

    @IIrtFldMeta(size = 200)
    @JsonProperty("POS_MSG")
    private String POS_MSG; // 응답메시지

    @IIrtFldMeta(size = 50)
    @JsonProperty("MASKING_NO")
    private String MASKING_NO; // 마스킹된 결제수단번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("ISCLUB")
    private String ISCLUB; // 클럽 여부

    @IIrtFldMeta(size = 20)
    @JsonProperty("MEMBER_NO")
    private String MEMBER_NO; // 회원번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("ISEMPLOYEE")
    private String ISEMPLOYEE; // 임직원여부

    @IIrtFldMeta(size = 20)
    @JsonProperty("ISEMPLOYEE_CARD_NO")
    private String ISEMPLOYEE_CARD_NO; // 임직원 사원증번호

    @IIrtFldMeta(size = 139)
    @JsonProperty("FILLER")
    private String FILLER; // 필러
}
