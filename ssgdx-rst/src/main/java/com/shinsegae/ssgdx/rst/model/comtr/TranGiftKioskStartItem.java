package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranGiftKioskStartItem {

    @IIrtFldMeta(size = 2)
    @JsonProperty("ItemCode")
    private String ItemCode; // ITEM코드

    @IIrtFldMeta(size = 4)
    @JsonProperty("ItemLength")
    private String ItemLength; // ITEM길이

    @IIrtFldMeta(size = 3)
    @JsonProperty("DeviceType")
    private String DeviceType; // 정산기TYPE

    @IIrtFldMeta(size = 8)
    @JsonProperty("DeviceVersion")
    private String DeviceVersion; // 정산기버전

    @IIrtFldMeta(size = 15)
    @JsonProperty("DeviceIpInfo")
    private String DeviceIpInfo; // IP정보

    /*
     * 상품권 방출기
     */
    @IIrtFldMeta(size = 1)
    @JsonProperty("GiftOut1Cassette1")
    private String GiftOut1Cassette1; // 상품권 1카세트

    @IIrtFldMeta(size = 1)
    @JsonProperty("GiftOut1Cassette2")
    private String GiftOut1Cassette2; // 상품권 2카세트

    @IIrtFldMeta(size = 1)
    @JsonProperty("GiftOut1Cassette3")
    private String GiftOut1Cassette3; // 상품권 3카세트

    @IIrtFldMeta(size = 1)
    @JsonProperty("GiftOut1Cassette4")
    private String GiftOut1Cassette4; // 상품권 4카세트

    @IIrtFldMeta(size = 1)
    @JsonProperty("GiftOut1Cassette5")
    private String GiftOut1Cassette5; // 상품권 5카세트

    /*
     * 봉투/증정 상품권
     */
    @IIrtFldMeta(size = 1)
    @JsonProperty("GiftOut2Hopper1")
    private String GiftOut2Hopper1; // 봉투/증정 1카세트

    @IIrtFldMeta(size = 1)
    @JsonProperty("GiftOut2Hopper2")
    private String GiftOut2Hopper2; // 봉투/증정 2카세트

    @IIrtFldMeta(size = 1)
    @JsonProperty("GiftOut2Hopper3")
    private String GiftOut2Hopper3; // 봉투/증정 3카세트

    @IIrtFldMeta(size = 1)
    @JsonProperty("GiftOut2Hopper4")
    private String GiftOut2Hopper4; // 봉투/증정 4카세트

    @IIrtFldMeta(size = 1)
    @JsonProperty("GiftOut2Hopper5")
    private String GiftOut2Hopper5; // 봉투/증정 5카세트

    /*
     * 현금부
     */
    @IIrtFldMeta(size = 1)
    @JsonProperty("BillOutCassette1")
    private String BillOutCassette1; // 지폐 1카세트

    @IIrtFldMeta(size = 1)
    @JsonProperty("BillOutCassette2")
    private String BillOutCassette2; // 지폐 2카세트

    @IIrtFldMeta(size = 1)
    @JsonProperty("BillOutCassette3")
    private String BillOutCassette3; // 지폐 3카세트

    @IIrtFldMeta(size = 1)
    @JsonProperty("BillOutCassette4")
    private String BillOutCassette4; // 지폐 4카세트

    @IIrtFldMeta(size = 1)
    @JsonProperty("StackCassette")
    private String StackCassette; // 지폐 5카세트

    @IIrtFldMeta(size = 6)
    @JsonProperty("CDriveDiskTotal")
    private String CDriveDiskTotal; // C드라이브 전체용량

    @IIrtFldMeta(size = 6)
    @JsonProperty("CDriveDiskUsage")
    private String CDriveDiskUsage; // C드라이브 사용량

    @IIrtFldMeta(size = 6)
    @JsonProperty("CDriveDiskAvailable")
    private String CDriveDiskAvailable; // C드라이브 가용량

    @IIrtFldMeta(size = 6)
    @JsonProperty("MemorySize")
    private String MemorySize; // 메모리 사이즈

    @IIrtFldMeta(size = 65)
    @JsonProperty("CPUInformation")
    private String CPUInformation; // CPU 정보

    @IIrtFldMeta(size = 65)
    @JsonProperty("OSVersion")
    private String OSVersion; // OS 버전

    @IIrtFldMeta(size = 5)
    @JsonProperty("OSPatchCnt")
    private String OSPatchCnt; // OS 패치 카운트

    /*
     * F/W 버전
     */
    @IIrtFldMeta(size = 32)
    @JsonProperty("Printer")
    private String Printer; // 영수증 프린터

    @IIrtFldMeta(size = 32)
    @JsonProperty("GiftOut1")
    private String GiftOut1; // 상품권 방출기(판매용)

    @IIrtFldMeta(size = 32)
    @JsonProperty("GiftOut2")
    private String GiftOut2; // 상품권 방출기(증정용)

    @IIrtFldMeta(size = 32)
    @JsonProperty("BTOut")
    private String BTOut; // 봉투방출기

    @IIrtFldMeta(size = 32)
    @JsonProperty("BillInOut1")
    private String BillInOut1; // 현금 입출금기

    @IIrtFldMeta(size = 32)
    @JsonProperty("BarCode")
    private String BarCode; // 바코드(고정형)

    @IIrtFldMeta(size = 32)
    @JsonProperty("CardReader")
    private String CardReader; // 카드리더기(동글)

    @IIrtFldMeta(size = 32)
    @JsonProperty("IOCNTR")
    private String IOCNTR; // I/O Controller

    @IIrtFldMeta(size = 32)
    @JsonProperty("Filler1")
    private String Filler1; // 예비1

    @IIrtFldMeta(size = 30)
    @JsonProperty("Filler2")
    private String Filler2; // 예비2

    @IIrtFldMeta(size = 2)
    @JsonProperty("MechineType")
    private String MechineType; // 판매기 형태
}
