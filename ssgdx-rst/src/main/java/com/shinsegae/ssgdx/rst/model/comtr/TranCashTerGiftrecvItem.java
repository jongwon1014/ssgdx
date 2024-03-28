package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranCashTerGiftrecvItem {

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

    @IIrtFldMeta(size = 10)
    @JsonProperty("AdminAgencyUserID")
    private String AdminAgencyUserID; // 관리자 대행 사용자 ID

    @IIrtFldMeta(size = 20)
    @JsonProperty("AdminAgencyUserName")
    private String AdminAgencyUserName; // 관리자 대행 사용자 성명

    @IIrtFldMeta(size = 1)
    @JsonProperty("GiftIssue_6")
    private String GiftIssue_6; // 상품권발행처

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt500000_6")
    private String GiftInCnt500000_6; // 50만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt300000_6")
    private String GiftInCnt300000_6; // 30만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt100000_6")
    private String GiftInCnt100000_6; // 10만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt70000_6")
    private String GiftInCnt70000_6; // 7만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt50000_6")
    private String GiftInCnt50000_6; // 5만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt30000_6")
    private String GiftInCnt30000_6; // 3만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt10000_6")
    private String GiftInCnt10000_6; // 1만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt5000_6")
    private String GiftInCnt5000_6; // 5천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt2000_6")
    private String GiftInCnt2000_6; // 2천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt1000_6")
    private String GiftInCnt1000_6; // 1천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt500000_6")
    private String BagGiftInCnt500000_6; // 50만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt300000_6")
    private String BagGiftInCnt300000_6; // 30만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt100000_6")
    private String BagGiftInCnt100000_6; // 10만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt70000_6")
    private String BagGiftInCnt70000_6; // 7만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt50000_6")
    private String BagGiftInCnt50000_6; // 5만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt30000_6")
    private String BagGiftInCnt30000_6; // 3만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt10000_6")
    private String BagGiftInCnt10000_6; // 1만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt5000_6")
    private String BagGiftInCnt5000_6; // 5천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt2000_6")
    private String BagGiftInCnt2000_6; // 2천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt1000_6")
    private String BagGiftInCnt1000_6; // 1천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagTotalCnt_6")
    private String BagTotalCnt_6; // 총매수

    @IIrtFldMeta(size = 11)
    @JsonProperty("GiftTotalAmt_6")
    private String GiftTotalAmt_6; // 계수입금 상품권 총 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("BagGiftTotalAmt_6")
    private String BagGiftTotalAmt_6; // 봉투입금 상품권 총 금액

    @IIrtFldMeta(size = 1)
    @JsonProperty("GiftIssue_F")
    private String GiftIssue_F; // 상품권발행처

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt500000_F")
    private String GiftInCnt500000_F; // 50만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt300000_F")
    private String GiftInCnt300000_F; // 30만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt100000_F")
    private String GiftInCnt100000_F; // 10만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt70000_F")
    private String GiftInCnt70000_F; // 7만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt50000_F")
    private String GiftInCnt50000_F; // 5만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt30000_F")
    private String GiftInCnt30000_F; // 3만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt10000_F")
    private String GiftInCnt10000_F; // 1만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt5000_F")
    private String GiftInCnt5000_F; // 5천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt2000_F")
    private String GiftInCnt2000_F; // 2천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt1000_F")
    private String GiftInCnt1000_F; // 1천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt500000_F")
    private String BagGiftInCnt500000_F; // 50만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt300000_F")
    private String BagGiftInCnt300000_F; // 30만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt100000_F")
    private String BagGiftInCnt100000_F; // 10만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt70000_F")
    private String BagGiftInCnt70000_F; // 7만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt50000_F")
    private String BagGiftInCnt50000_F; // 5만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt30000_F")
    private String BagGiftInCnt30000_F; // 3만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt10000_F")
    private String BagGiftInCnt10000_F; // 1만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt5000_F")
    private String BagGiftInCnt5000_F; // 5천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt2000_F")
    private String BagGiftInCnt2000_F; // 2천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt1000_F")
    private String BagGiftInCnt1000_F; // 1천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagTotalCnt_F")
    private String BagTotalCnt_F; // 총매수

    @IIrtFldMeta(size = 11)
    @JsonProperty("GiftTotalAmt_F")
    private String GiftTotalAmt_F; // 계수입금 상품권 총 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("BagGiftTotalAmt_F")
    private String BagGiftTotalAmt_F; // 봉투입금 상품권 총 금액

    @IIrtFldMeta(size = 1)
    @JsonProperty("GiftIssue_G")
    private String GiftIssue_G; // 상품권발행처

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt500000_G")
    private String GiftInCnt500000_G; // 50만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt300000_G")
    private String GiftInCnt300000_G; // 30만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt100000_G")
    private String GiftInCnt100000_G; // 10만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt70000_G")
    private String GiftInCnt70000_G; // 7만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt50000_G")
    private String GiftInCnt50000_G; // 5만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt30000_G")
    private String GiftInCnt30000_G; // 3만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt10000_G")
    private String GiftInCnt10000_G; // 1만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt5000_G")
    private String GiftInCnt5000_G; // 5천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt2000_G")
    private String GiftInCnt2000_G; // 2천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt1000_G")
    private String GiftInCnt1000_G; // 1천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt500000_G")
    private String BagGiftInCnt500000_G; // 50만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt300000_G")
    private String BagGiftInCnt300000_G; // 30만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt100000_G")
    private String BagGiftInCnt100000_G; // 10만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt70000_G")
    private String BagGiftInCnt70000_G; // 7만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt50000_G")
    private String BagGiftInCnt50000_G; // 5만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt30000_G")
    private String BagGiftInCnt30000_G; // 3만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt10000_G")
    private String BagGiftInCnt10000_G; // 1만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt5000_G")
    private String BagGiftInCnt5000_G; // 5천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt2000_G")
    private String BagGiftInCnt2000_G; // 2천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt1000_G")
    private String BagGiftInCnt1000_G; // 1천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagTotalCnt_G")
    private String BagTotalCnt_G; // 총매수

    @IIrtFldMeta(size = 11)
    @JsonProperty("GiftTotalAmt_G")
    private String GiftTotalAmt_G; // 계수입금 상품권 총 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("BagGiftTotalAmt_G")
    private String BagGiftTotalAmt_G; // 봉투입금 상품권 총 금액

    @IIrtFldMeta(size = 1)
    @JsonProperty("GiftIssue_H")
    private String GiftIssue_H; // 상품권발행처

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt500000_H")
    private String GiftInCnt500000_H; // 50만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt300000_H")
    private String GiftInCnt300000_H; // 30만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt100000_H")
    private String GiftInCnt100000_H; // 10만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt70000_H")
    private String GiftInCnt70000_H; // 7만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt50000_H")
    private String GiftInCnt50000_H; // 5만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt30000_H")
    private String GiftInCnt30000_H; // 3만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt10000_H")
    private String GiftInCnt10000_H; // 1만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt5000_H")
    private String GiftInCnt5000_H; // 5천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt2000_H")
    private String GiftInCnt2000_H; // 2천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt1000_H")
    private String GiftInCnt1000_H; // 1천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt500000_H")
    private String BagGiftInCnt500000_H; // 50만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt300000_H")
    private String BagGiftInCnt300000_H; // 30만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt100000_H")
    private String BagGiftInCnt100000_H; // 10만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt70000_H")
    private String BagGiftInCnt70000_H; // 7만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt50000_H")
    private String BagGiftInCnt50000_H; // 5만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt30000_H")
    private String BagGiftInCnt30000_H; // 3만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt10000_H")
    private String BagGiftInCnt10000_H; // 1만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt5000_H")
    private String BagGiftInCnt5000_H; // 5천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt2000_H")
    private String BagGiftInCnt2000_H; // 2천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt1000_H")
    private String BagGiftInCnt1000_H; // 1천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagTotalCnt_H")
    private String BagTotalCnt_H; // 총매수

    @IIrtFldMeta(size = 11)
    @JsonProperty("GiftTotalAmt_H")
    private String GiftTotalAmt_H; // 계수입금 상품권 총 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("BagGiftTotalAmt_H")
    private String BagGiftTotalAmt_H; // 봉투입금 상품권 총 금액

    @IIrtFldMeta(size = 1)
    @JsonProperty("GiftIssue_I")
    private String GiftIssue_I; // 상품권발행처

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt500000_I")
    private String GiftInCnt500000_I; // 50만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt300000_I")
    private String GiftInCnt300000_I; // 30만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt100000_I")
    private String GiftInCnt100000_I; // 10만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt70000_I")
    private String GiftInCnt70000_I; // 7만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt50000_I")
    private String GiftInCnt50000_I; // 5만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt30000_I")
    private String GiftInCnt30000_I; // 3만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt10000_I")
    private String GiftInCnt10000_I; // 1만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt5000_I")
    private String GiftInCnt5000_I; // 5천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt2000_I")
    private String GiftInCnt2000_I; // 2천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("GiftInCnt1000_I")
    private String GiftInCnt1000_I; // 1천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt500000_I")
    private String BagGiftInCnt500000_I; // 50만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt300000_I")
    private String BagGiftInCnt300000_I; // 30만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt100000_I")
    private String BagGiftInCnt100000_I; // 10만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt70000_I")
    private String BagGiftInCnt70000_I; // 7만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt50000_I")
    private String BagGiftInCnt50000_I; // 5만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt30000_I")
    private String BagGiftInCnt30000_I; // 3만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt10000_I")
    private String BagGiftInCnt10000_I; // 1만원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt5000_I")
    private String BagGiftInCnt5000_I; // 5천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt2000_I")
    private String BagGiftInCnt2000_I; // 2천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagGiftInCnt1000_I")
    private String BagGiftInCnt1000_I; // 1천원권 매수

    @IIrtFldMeta(size = 5)
    @JsonProperty("BagTotalCnt_I")
    private String BagTotalCnt_I; // 총매수

    @IIrtFldMeta(size = 11)
    @JsonProperty("GiftTotalAmt_I")
    private String GiftTotalAmt_I; // 계수입금 상품권 총 금액

    @IIrtFldMeta(size = 11)
    @JsonProperty("BagGiftTotalAmt_I")
    private String BagGiftTotalAmt_I; // 봉투입금 상품권 총 금액
}
