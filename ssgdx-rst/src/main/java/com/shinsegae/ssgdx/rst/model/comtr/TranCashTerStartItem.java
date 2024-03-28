package com.shinsegae.ssgdx.rst.model.comtr;

import com.shinsegae.ssgdx.ldi.util.IIrtFldMeta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranCashTerStartItem {

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

    /**
     * 1번출금기
     */
    @IIrtFldMeta(size = 1)
    @JsonProperty("BillOut1Cassette1")
    private String BillOut1Cassette1; // 지폐 1카세트

    @IIrtFldMeta(size = 1)
    @JsonProperty("BillOut1Cassette2")
    private String BillOut1Cassette2; // 지폐 2카세트

    @IIrtFldMeta(size = 1)
    @JsonProperty("BillOut1Cassette3")
    private String BillOut1Cassette3; // 지폐 3카세트

    @IIrtFldMeta(size = 1)
    @JsonProperty("BillOut1Cassette4")
    private String BillOut1Cassette4; // 지폐 4카세트

    @IIrtFldMeta(size = 1)
    @JsonProperty("BillOut1Cassette5")
    private String BillOut1Cassette5; // 지폐 5카세트

    @IIrtFldMeta(size = 1)
    @JsonProperty("CoinOut1Hopper1")
    private String CoinOut1Hopper1; // 동전 1호퍼

    @IIrtFldMeta(size = 1)
    @JsonProperty("CoinOut1Hopper2")
    private String CoinOut1Hopper2; // 동전 2호퍼

    @IIrtFldMeta(size = 1)
    @JsonProperty("CoinOut1Hopper3")
    private String CoinOut1Hopper3; // 동전 3호퍼

    @IIrtFldMeta(size = 1)
    @JsonProperty("CoinOut1Hopper4")
    private String CoinOut1Hopper4; // 동전 4호퍼

    @IIrtFldMeta(size = 1)
    @JsonProperty("CoinOut1Hopper5")
    private String CoinOut1Hopper5; // 동전 5호퍼

    @IIrtFldMeta(size = 1)
    @JsonProperty("CoinOut1Hopper6")
    private String CoinOut1Hopper6; // 동전 6호퍼

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

    /**
     * F/W 버전
     */
    @IIrtFldMeta(size = 32)
    @JsonProperty("Printer")
    private String Printer; // 영수증 프린터

    @IIrtFldMeta(size = 32)
    @JsonProperty("Camera1")
    private String Camera1; // 안면카메라

    @IIrtFldMeta(size = 32)
    @JsonProperty("Camera2")
    private String Camera2; // 손카메라

    @IIrtFldMeta(size = 32)
    @JsonProperty("MucbIn")
    private String MucbIn; // 입금부 통신제어보드

    @IIrtFldMeta(size = 32)
    @JsonProperty("BillIn")
    private String BillIn; // 지폐 입금부

    @IIrtFldMeta(size = 32)
    @JsonProperty("CoinIn")
    private String CoinIn; // 동전 입금부

    @IIrtFldMeta(size = 32)
    @JsonProperty("MucbOut1")
    private String MucbOut1; // 출금부 통신제어보드

    @IIrtFldMeta(size = 32)
    @JsonProperty("BillOut1")
    private String BillOut1; // 지폐 출금부

    @IIrtFldMeta(size = 32)
    @JsonProperty("CoinOut1")
    private String CoinOut1; // 동전 출금부

    @IIrtFldMeta(size = 32)
    @JsonProperty("MucbOut2")
    private String MucbOut2; // 출금부 통신제어보드2

    @IIrtFldMeta(size = 32)
    @JsonProperty("CoinOut2")
    private String CoinOut2; // 지폐 출금부2

    @IIrtFldMeta(size = 32)
    @JsonProperty("BillOut2")
    private String BillOut2; // 동전 출금부2
}
