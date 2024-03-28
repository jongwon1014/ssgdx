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
public class TranCardIcItemN {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 1)
    @JsonProperty("TmsType")
    private String TmsType; // 거래구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("CardType")
    private String CardType; // 결제구분

    @IIrtFldMeta(size = 3)
    @JsonProperty("AuthCnt")
    private String AuthCnt; // 카드 승인 개수

    @IIrtFldMeta(size = 8)
    @JsonProperty("AuthDate")
    private String AuthDate; // 승인일자

    @IIrtFldMeta(size = 6)
    @JsonProperty("AuthTime")
    private String AuthTime; // 승인시각

    @IIrtFldMeta(size = 2)
    @JsonProperty("CardKind")
    private String CardKind; // 카드종류

    @IIrtFldMeta(size = 2)
    @JsonProperty("AuthInClss")
    private String AuthInClss; // 카드입력구분

    @IIrtFldMeta(size = 2)
    @JsonProperty("PointFlag")
    private String PointFlag; // 포인트 적용 유무

    @IIrtFldMeta(size = 16)
    @JsonProperty("PassWord")
    private String PassWord; // 비밀번호

    @IIrtFldMeta(size = 12)
    @JsonProperty("AuthNo")
    private String AuthNo; // 승인번호

    @IIrtFldMeta(size = 10)
    @JsonProperty("PointSaleAmt")
    private String PointSaleAmt; // 포인트지불금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("PrePoint1")
    private String PrePoint1; // 포인트사용가능금액

    @IIrtFldMeta(size = 10)
    @JsonProperty("PrePoint2")
    private String PrePoint2; // 포인트지불가능금액

    @IIrtFldMeta(size = 2)
    @JsonProperty("InsMon")
    private String InsMon; // 할부개월

    @IIrtFldMeta(size = 11)
    @JsonProperty("PureSaleAmt")
    private String PureSaleAmt; // 순수카드매출금액

    @IIrtFldMeta(size = 1)
    @JsonProperty("CardAuthSbj")
    private String CardAuthSbj; // 승인주체

    @IIrtFldMeta(size = 4)
    @JsonProperty("AuthNum")
    private String AuthNum; // 카드사 번호

    @IIrtFldMeta(size = 4)
    @JsonProperty("AuthSeq")
    private String AuthSeq; // 카드 순번

    @IIrtFldMeta(size = 11)
    @JsonProperty("PartRcptAmt")
    private String PartRcptAmt; // 일부입금

    @IIrtFldMeta(size = 11)
    @JsonProperty("TotSaleAmt")
    private String TotSaleAmt; // 총매출

    @IIrtFldMeta(size = 11)
    @JsonProperty("DscntAmt")
    private String DscntAmt; // 에누리

    @IIrtFldMeta(size = 11)
    @JsonProperty("BagAmt")
    private String BagAmt; // 쇼핑백 금액

    @IIrtFldMeta(dType = EnmTranFieldType.LIST)
    @JsonProperty("ItemList")
    private List<TranCardIcItemNItemList> ItemList = new ArrayList<TranCardIcItemNItemList>(); // 상품정보(반복-6개)

    @IIrtFldMeta(size = 11)
    @JsonProperty("SaleEct")
    private String SaleEct; // 매출기타

    @IIrtFldMeta(size = 1)
    @JsonProperty("DccFlag")
    private String DccFlag; // DCC여부

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
    @JsonProperty("CardSeqNo")
    private String CardSeqNo; // 카드일련번호

    @IIrtFldMeta(size = 2)
    @JsonProperty("IssueFirmCode")
    private String IssueFirmCode; // 발행사

    @IIrtFldMeta(size = 2)
    @JsonProperty("BuyFirmCode")
    private String BuyFirmCode; // 매입사

    @IIrtFldMeta(size = 1)
    @JsonProperty("SsgCardFlag")
    private String SsgCardFlag; // SSG PAY CARD 구분

    @IIrtFldMeta(size = 6)
    @JsonProperty("DebitSeqNo")
    private String DebitSeqNo; // 직불 일련번호

    @IIrtFldMeta(size = 2)
    @JsonProperty("DongleReadType")
    private String DongleReadType; // 동글-거래구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("DongleMobileType")
    private String DongleMobileType; // 동글-이통사구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("DongleCardType")
    private String DongleCardType; // 동글-카드방식(결제)

    @IIrtFldMeta(size = 1)
    @JsonProperty("DongleCardKind")
    private String DongleCardKind; // 동글-카드종류

    @IIrtFldMeta(size = 1)
    @JsonProperty("DongleCvmType")
    private String DongleCvmType; // 동글-CVM

    @IIrtFldMeta(size = 10)
    @JsonProperty("PreCardChanAmt")
    private String PreCardChanAmt; // 선불카드 잔액

    @IIrtFldMeta(size = 20)
    @JsonProperty("CardNo")
    private String CardNo; // 카드 번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("CardEncryptFlag")
    private String CardEncryptFlag; // 암호화 여부

    @IIrtFldMeta(size = 16)
    @JsonProperty("PosTmlNo")
    private String PosTmlNo; // SW 모델 번호

    @IIrtFldMeta(size = 16)
    @JsonProperty("ReaderTmlNo")
    private String ReaderTmlNo; // HW 모델 번호

    @IIrtFldMeta(size = 127)
    @JsonProperty("CardData")
    private String CardData; // 카드 DATA(암호화)카드사

    @IIrtFldMeta(size = 127)
    @JsonProperty("CardDataVan")
    private String CardDataVan; // 카드 DATA(암호화)VAN사

    @IIrtFldMeta(size = 1)
    @JsonProperty("IcTmsType")
    private String IcTmsType; // 거래 형태

    @IIrtFldMeta(size = 2)
    @JsonProperty("FallBackType")
    private String FallBackType; // FallBack 구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("IcCardType")
    private String IcCardType; // IC 카드 종류

    @IIrtFldMeta(size = 2)
    @JsonProperty("IcVanCode")
    private String IcVanCode; // IC-VAN사 키 코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("IcEmvLen")
    private String IcEmvLen; // IC-EMV 데이터 길이

    @IIrtFldMeta(size = 1)
    @JsonProperty("ForceCancelFg")
    private String ForceCancelFg; // IC 강제취소구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("DaType")
    private String DaType; // 직승인유무

    @IIrtFldMeta(size = 12)
    @JsonProperty("LteAppSeq")
    private String LteAppSeq; // LTE VAN 승인번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("ForceTranSendFlag")
    private String ForceTranSendFlag; // LTE VAN 취소 강제 TRAN 전송 구분

    @IIrtFldMeta(size = 85)
    @JsonProperty("IcFiller")
    private String IcFiller; // IC 거래 예비필드

    @IIrtFldMeta(size = 1400)
    @JsonProperty("IcEmvData")
    private String IcEmvData; // 칩 데이터

    @IIrtFldMeta(size = 10)
    @JsonProperty("CardEventKey")
    private String CardEventKey; // BMP 카드행사 KEY

    @IIrtFldMeta(size = 1)
    @JsonProperty("TmGubn")
    private String TmGubn; // 장비구분

    @IIrtFldMeta(size = 1)
    @JsonProperty("CertiFlag")
    private String CertiFlag; // 인증조회된 승인요청 여부

    @IIrtFldMeta(size = 12)
    @JsonProperty("CertiAuthNo")
    private String CertiAuthNo; // 구인증조회 승인번호

    @IIrtFldMeta(size = 1)
    @JsonProperty("EdiDscntFlag")
    private String EdiDscntFlag; // 청구할인

    @IIrtFldMeta(size = 9)
    @JsonProperty("CupAmt")
    private String CupAmt; // 컵보증금

    @IIrtFldMeta(size = 24)
    @JsonProperty("Filler")
    private String Filler; // 예비

    /**
     * 상품정보(반복-6개)
     */
    @Getter
    @Setter
    public static class TranCardIcItemNItemList {

        @IIrtFldMeta(size = 30)
        @JsonProperty("Code")
        private String Code; // 상품코드

        @IIrtFldMeta(size = 4)
        @JsonProperty("BIZ_RELM_CD")
        private String BIZ_RELM_CD; // 사업영역코드

        @IIrtFldMeta(size = 4)
        @JsonProperty("Cnt")
        private String Cnt; // 상품수량

        @IIrtFldMeta(size = 11)
        @JsonProperty("Amt")
        private String Amt; // 상품금액

        @IIrtFldMeta(size = 2)
        @JsonProperty("Clss")
        private String Clss; // 상품명구분
    }
}
