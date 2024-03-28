package com.shinsegae.ssgdx.rst.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import devonframe.dataaccess.CommonDao;

import com.shinsegae.ssgdx.core.idgenerator.IdGeneratorFactory;
import com.shinsegae.ssgdx.ldi.util.IEnumComIrt;
import com.shinsegae.ssgdx.ldi.util.IEnumComIrt.EnmTranItemCode;
import com.shinsegae.ssgdx.ldi.util.IEnumComIrt.EnmTranItemCodeWrap;
import com.shinsegae.ssgdx.ldi.util.IrtParseUtil;
import com.shinsegae.ssgdx.ldi.util.JsonUtil;
import com.shinsegae.ssgdx.rst.model.CompTranData;
import com.shinsegae.ssgdx.rst.model.comtr.ItemHeader;
import com.shinsegae.ssgdx.rst.model.comtr.TranCalcItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranCardItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranCashBillItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranCashICItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranCashTerCashItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranCashTerCashinItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranCashTerCashrecvItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranCashTerCommItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranCashTerErrorItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranCashTerGiftSeqItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranCashTerGiftinItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranCashTerGiftrecvItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranCashTerInOutOrgItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranCashTerStartItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranCashTerUseSaleItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranChicorClubItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranChicorOnOffItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranCurrencyItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranDepositItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranEMPItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranEventCancelItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranExchangeItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranGIFTCardItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranGiftItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranGiftKioskCalcItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranGiftKioskCommItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranGiftKioskErrorItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranGiftKioskGiftSeqItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranGiftKioskInOutItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranGiftKioskOrgTranItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranGiftKioskStartItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranGiftPmItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranGiftSaleItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranGiftScratchItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranMidAmtItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranMidPdaAmtItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranMobileMmsItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranPointItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranReadyAmtItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranSSGConItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranSSGPayItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranSSGPayItemII;
import com.shinsegae.ssgdx.rst.model.comtr.TranScoScaslupCntItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranSetItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranShinBaekRewardCouponItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranShinBaekRewardItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranTaxRefundItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranVipMileageItem;
import com.shinsegae.ssgdx.rst.model.comtr.TranWeChatPayItem;
import com.shinsegae.ssgdx.rst.model.newtr.TranBmpCampaignItemN;
import com.shinsegae.ssgdx.rst.model.newtr.TranCCFreeSetItemN;
import com.shinsegae.ssgdx.rst.model.newtr.TranCardIcItemN;
import com.shinsegae.ssgdx.rst.model.newtr.TranCashItemN;
import com.shinsegae.ssgdx.rst.model.newtr.TranCashTerAmtItemDxN;
import com.shinsegae.ssgdx.rst.model.newtr.TranCashTerExpenItemN;
import com.shinsegae.ssgdx.rst.model.newtr.TranDmsItemN;
import com.shinsegae.ssgdx.rst.model.newtr.TranEasyPaymentItemN;
import com.shinsegae.ssgdx.rst.model.newtr.TranEtcPayItemC;
import com.shinsegae.ssgdx.rst.model.newtr.TranGoodsItemN;
import com.shinsegae.ssgdx.rst.model.newtr.TranHeaderN;
import com.shinsegae.ssgdx.rst.model.newtr.TranKakaopayItemN;
import com.shinsegae.ssgdx.rst.model.newtr.TranMileageAutoSaveItemC;
import com.shinsegae.ssgdx.rst.model.newtr.TranPaycoinItemN;
import com.shinsegae.ssgdx.rst.model.newtr.TranPreReservSaleItemC;
import com.shinsegae.ssgdx.rst.model.newtr.TranRecommanderItemC;
import com.shinsegae.ssgdx.rst.model.newtr.TranShinBaekMoneyItemN;
import com.shinsegae.ssgdx.rst.model.newtr.TranSupyoItemN;
import com.shinsegae.ssgdx.rst.model.newtr.TranUntactAccountItemC;
import com.shinsegae.ssgdx.rst.model.newtr.TranUntactCardItemC;
import com.shinsegae.ssgdx.rst.model.newtr.TranUseSaleSpecialItemC;
import com.shinsegae.ssgdx.rst.model.oldtr.TranBmpCampaignItemO;
import com.shinsegae.ssgdx.rst.model.oldtr.TranCCFreeSetItemO;
import com.shinsegae.ssgdx.rst.model.oldtr.TranCardIcItemO;
import com.shinsegae.ssgdx.rst.model.oldtr.TranCashTerAmtItemDxO;
import com.shinsegae.ssgdx.rst.model.oldtr.TranCashTerExpenItemO;
import com.shinsegae.ssgdx.rst.model.oldtr.TranDmsItemO;
import com.shinsegae.ssgdx.rst.model.oldtr.TranEasyPaymentItemO;
import com.shinsegae.ssgdx.rst.model.oldtr.TranGoodsItemO;
import com.shinsegae.ssgdx.rst.model.oldtr.TranHeaderO;
import com.shinsegae.ssgdx.rst.model.oldtr.TranKakaopayItemO;
import com.shinsegae.ssgdx.rst.model.oldtr.TranPaycoinItemO;
import com.shinsegae.ssgdx.rst.model.oldtr.TranShinBaekMoneyItemO;
import com.shinsegae.ssgdx.rst.model.oldtr.TranSupyoItemO;
import com.shinsegae.ssgdx.rst.util.ParseHelper;
import com.shinsegae.ssgdx.rst.util.QueryProc;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class DecomposeTranProc {

    private final IdGeneratorFactory idGeneratorFactory;

    private final CommonDao commonDao;

    private QueryProc queryProc;

    private CompTranData compTranData;

    private int[] offSet = { 0 };

    private String jsonTran = "";

    private String jsonTranEnc = "";

    private int nDebugFlag = 0;

    private byte[] tranDataOBytes;

    private String tranDataDec = "";

    private String tranDataEnc = "";

    private String logTranInfo = "";

    private Map<String, Object> logParamMap = new HashMap<>();

    private String tranGoodsItemShopCd = ""; // 외상아이템에서 사용하기위해서 상품트란에서 세팅

    private String tranGoodsItemBizRelmCd = ""; // 외상아이템에서 사용하기위해서 상품트란에서 세팅

    public DecomposeTranProc(IdGeneratorFactory idGeneratorFactory, CommonDao commonDao, byte[] tranDataOBytes)
            throws UnsupportedEncodingException {
        this.idGeneratorFactory = idGeneratorFactory;
        this.commonDao = commonDao;
        this.tranDataOBytes = tranDataOBytes;
        this.tranDataDec = new String(tranDataOBytes);

        queryProc = new QueryProc(commonDao);
        compTranData = new CompTranData();
    }

    public DecomposeTranProc(IdGeneratorFactory idGeneratorFactory, CommonDao commonDao, byte[] tranDataOBytes,
            byte[] recvEncHeaderAndTranDataBytes) throws UnsupportedEncodingException {
        this.idGeneratorFactory = idGeneratorFactory;
        this.commonDao = commonDao;
        this.tranDataOBytes = tranDataOBytes;
        this.tranDataDec = new String(tranDataOBytes);
        this.tranDataEnc = new String(recvEncHeaderAndTranDataBytes);

        queryProc = new QueryProc(commonDao);
        compTranData = new CompTranData();
    }

    public int tranProc(){
        int ret = -1;

        try{
            // 실시간 처리
            // 트란 전문 파싱
            // [1] 통신 헤더 생성
            ret = parseCommHeader();

            // [2] 구 트란 헤더 생성
            if(ret == 0)
                ret = parseOldTranHeader();

            // [6] 구 전문 TTRLOG_O 테이블에 저장 (사전이행일때는 제외, 실시간만 포함)
            if(ret == 0){
                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("saleDate", compTranData.getTran_Header_O().getSaleDate());
                paramMap.put("storeNo", compTranData.getTran_Header_O().getStoreNo());
                paramMap.put("posNo", compTranData.getTran_Header_O().getPosNo());
                paramMap.put("tranNo", compTranData.getTran_Header_O().getTranNo());
                paramMap.put("seqNo", "1");
                // 사전이행에서 넣어줄때 통신헤더 제외해서 넣어 주기 때문에 실시간도 제외하고 넣어 준다
                // paramMap.put("tranData", tranDataDec.substring(67));
                paramMap.put("tranDataEnc", tranDataEnc);
                paramMap.put("tranProcFg", "0");

                queryProc.mergeTTRLOG_O(paramMap, logTranInfo, logParamMap);
            }

            // [3] 트란 아이템 생성
            if(ret == 0)
                ret = parseTranItem();

            // [4] 구 트란 헤더 --> 신 트란 헤더 변환
            if(ret == 0)
                ret = makeNewTranHeader();

            // [5] 신규 트란 Json 생성
            if(ret == 0)
                ret = makeJsonTran();
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 통신 헤더 생성
     * 
     * @return
     */
    public int parseCommHeader(){
        int ret = -1;

        try{
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, compTranData.getCOMM_HEADER(), 0, 0, false,
                    false);
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 구 트란 헤더 생성
     * 
     * @return
     */
    public int parseOldTranHeader(){
        int ret = -1;

        try{
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, compTranData.getTran_Header_O(), 0, 0, false,
                    false);

            compTranData.getTran_Header_O().setStoreNo(compTranData.getTran_Header_O().getStoreNo().trim());
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 구 트란 헤더 --> 신 트란 헤더 변환
     * 
     * @return
     */
    public int makeNewTranHeader(){
        int ret = -1;

        try{
            ret = getTotalTranItemLength();
            if(ret >= 0){
                log.info("makeNewTranHeader -- 모든 전문 전체 길이 : [{}]", ret);

                TranHeaderO tranHeaderO = compTranData.getTran_Header_O();
                TranHeaderN tranHeaderN = compTranData.getTran_Header_N();

                // 트란헤더 길이 재계산
                tranHeaderN
                        .setMsgLength(String.format("%06d", EnmTranItemCodeWrap.Tran_Header.getItemCodeLen_N() + ret));

                log.info("makeNewTranHeader -- 트란헤더 길이 : {}", tranHeaderN.getMsgLength());

                // 통신헤더 길이 재계산
                compTranData.getCOMM_HEADER().setMsgLength(String.format("%06d",
                        IEnumComIrt.DEF_COM_HEADER_LEN + EnmTranItemCodeWrap.Tran_Header.getItemCodeLen_N() + ret));

                log.info("makeNewTranHeader -- 통신헤더 길이 : {}", compTranData.getCOMM_HEADER().getMsgLength());

                tranHeaderN.setItemCode(EnmTranItemCodeWrap.Tran_Header.getItemCode_N());
                tranHeaderN.setItemLength(String.format("%04d", EnmTranItemCodeWrap.Tran_Header.getItemCodeLen_N()));

                tranHeaderN.setSaleDate(tranHeaderO.getSaleDate());
                tranHeaderN.setStoreNo(tranHeaderO.getStoreNo());
                tranHeaderN.setPosNo(tranHeaderO.getPosNo());
                tranHeaderN.setTranNo(tranHeaderO.getTranNo());
                tranHeaderN.setSysDate(tranHeaderO.getSysDate());
                tranHeaderN.setSysTime(tranHeaderO.getSysTime());
                tranHeaderN.setTranType(tranHeaderO.getTranType());
                tranHeaderN.setCancelType(tranHeaderO.getCancelType());
                tranHeaderN.setTranKind(tranHeaderO.getTranKind());
                tranHeaderN.setCashierNo(tranHeaderO.getCashierNo());
                tranHeaderN.setOrgTranDate(tranHeaderO.getOrgTranDate());
                tranHeaderN.setOrgPosNo(tranHeaderO.getOrgPosNo());
                tranHeaderN.setOrgTranNo(tranHeaderO.getOrgTranNo());
                tranHeaderN.setOrgCashierNo(tranHeaderO.getOrgCashierNo());
                tranHeaderN.setReasonCode(tranHeaderO.getReasonCode());
                tranHeaderN.setTotalAmount(tranHeaderO.getTotalAmount());
                tranHeaderN.setDiscountAmount(tranHeaderO.getDiscountAmount());
                tranHeaderN.setCashFlag(tranHeaderO.getCashFlag());
                tranHeaderN.setGiftFlag(tranHeaderO.getGiftFlag());
                tranHeaderN.setPpFlag(tranHeaderO.getPpFlag());
                tranHeaderN.setCouponFlag(tranHeaderO.getCouponFlag());
                tranHeaderN.setCardFlag(tranHeaderO.getCardFlag());
                tranHeaderN.setDivMonthFlag(tranHeaderO.getDivMonthFlag());
                tranHeaderN.setPointUseFlag(tranHeaderO.getPointUseFlag());
                tranHeaderN.setDebitFlag(tranHeaderO.getDebitFlag());
                tranHeaderN.setIdCardFlag(tranHeaderO.getIdCardFlag());
                tranHeaderN.setKtCardFlag(tranHeaderO.getKtCardFlag());
                tranHeaderN.setSaleGiftFlag(tranHeaderO.getSaleGiftFlag());
                tranHeaderN.setCashReceiptFlag(tranHeaderO.getCashReceiptFlag());
                tranHeaderN.setDiscountCouponFlag(tranHeaderO.getDiscountCouponFlag());
                tranHeaderN.setMemberFlag(tranHeaderO.getMemberFlag());
                tranHeaderN.setDiscountCheckFlag(tranHeaderO.getDiscountCheckFlag());
                tranHeaderN.setDiscountRate(tranHeaderO.getDiscountRate());
                tranHeaderN.setCustomerType(tranHeaderO.getCustomerType());
                tranHeaderN.setPointNoLast3(tranHeaderO.getPointNoLast3());
                tranHeaderN.setParkingFlag(tranHeaderO.getParkingFlag());
                tranHeaderN.setForeignType(tranHeaderO.getForeignType());
                tranHeaderN.setPosType(tranHeaderO.getPosType());
                tranHeaderN.setSPointFlag(tranHeaderO.getSPointFlag());
                tranHeaderN.setElecCouponFlag(tranHeaderO.getElecCouponFlag());
                tranHeaderN.setVipMileageSendFlag(tranHeaderO.getVipMileageSendFlag());
                tranHeaderN.setSPointSendFlag(tranHeaderO.getSPointSendFlag());
                tranHeaderN.setSaleKind(tranHeaderO.getSaleKind());
                tranHeaderN.setExOrgSaleDate(tranHeaderO.getExOrgSaleDate());
                tranHeaderN.setExOrgPosNo(tranHeaderO.getExOrgPosNo());
                tranHeaderN.setExOrgTrdNo(tranHeaderO.getExOrgTrdNo());
                tranHeaderN.setExOrgCashierNo(tranHeaderO.getExOrgCashierNo());
                tranHeaderN.setVersionInfo1(tranHeaderO.getVersionInfo1());
                tranHeaderN.setVersionInfo2(tranHeaderO.getVersionInfo2());
                tranHeaderN.setVersionInfo3(tranHeaderO.getVersionInfo3());
                tranHeaderN.setHwType(tranHeaderO.getHwType());
                tranHeaderN.setBrandFlag(tranHeaderO.getBrandFlag());
                tranHeaderN.setNationalCode(tranHeaderO.getNationalCode());
                tranHeaderN.setEmpAuthSendFlag(tranHeaderO.getEmpAuthSendFlag());
                tranHeaderN.setCashIcSendFlag(tranHeaderO.getCashIcSendFlag());
                tranHeaderN.setMobileEgiftSendFlag(tranHeaderO.getMobileEgiftSendFlag());
                tranHeaderN.setIntegPaySendFlag(tranHeaderO.getIntegPaySendFlag());
                tranHeaderN.setIntegCardSendFlag(tranHeaderO.getIntegCardSendFlag());
                tranHeaderN.setCardOffLineFlag(tranHeaderO.getCardOffLineFlag());
                tranHeaderN.setFoodOrderNo(tranHeaderO.getFoodOrderNo());
                tranHeaderN.setFoodWaitNo(tranHeaderO.getFoodWaitNo());
                tranHeaderN.setMappingFlag(tranHeaderO.getMappingFlag());
                tranHeaderN.setRefundFlag(tranHeaderO.getRefundFlag());
                tranHeaderN.setElecReceiptFlag(tranHeaderO.getElecReceiptFlag());
                tranHeaderN.setLTEUseFlag(tranHeaderO.getLTEUseFlag());
                tranHeaderN.setLTEStatusFlag(tranHeaderO.getLTEStatusFlag());
                tranHeaderN.setIsCulture(tranHeaderO.getIsCulture());
                tranHeaderN.setCashTerminalUseFlag(tranHeaderO.getCashTerminalUseFlag());
                tranHeaderN.setCashTerminalTrnYn(tranHeaderO.getCashTerminalTrnYN());
                tranHeaderN.setClaimant(tranHeaderO.getClaimant());
                tranHeaderN.setHolidayDeliveryFlag(tranHeaderO.getHolidayDeliveryFlag());
                tranHeaderN.setMarketMemFlag(tranHeaderO.getMarketMemFlag());
                tranHeaderN.setSmartOrderFlag(tranHeaderO.getSmartOrderFlag());
                tranHeaderN.setDeliveryReturnCode(tranHeaderO.getDeliveryReturnCode());
                tranHeaderN.setChicorEnuriYn(tranHeaderO.getChicorEnuri_Yn());
                tranHeaderN.setSmpEnuriYn(tranHeaderO.getSmpEnuri_Yn());
                // 신규 : 고객유형코드
                // 구전문 자동 에누리 적용 고객타입으로 매핑(확인 필요)
                tranHeaderN.setCustType(ParseHelper.getRpadFillSpaceStringForNewTran(tranHeaderN, "CustType",
                        tranHeaderO.getCustomerType().trim()));
                // 변경 : 예비(76 -> 100)
                tranHeaderN.setFiller(
                        ParseHelper.getLpadFillSpaceStringForNewTran(tranHeaderN, "Filler", tranHeaderO.getFiller()));
                ret = 0;
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 전체 거래 전문의 길이 계산
     * 
     * @return
     */
    public int getTotalTranItemLength(){
        int ret = -1;
        try{
            int nLoop = 0;
            int nILen = 0;
            int nTLen = 0;
            // "03", "03", "현금영수증 아이템"
            for(TranCashBillItem item : compTranData.getTran_CashBillItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("03 - 03 현금영수증 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "12", "12", "상품권 아이템"
            for(TranGiftItem item : compTranData.getTran_GiftItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("12 - 12 상품권 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "14", "14", "신용카드(MSR) 아이템"
            for(TranCardItem item : compTranData.getTran_CardItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("14 - 14 신용카드(MSR) 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "18", "18", "전자상품권 아이템"
            for(TranGIFTCardItem item : compTranData.getTran_GIFTCardItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("18 - 18 전자상품권 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "19", "19", "외화 아이템"
            for(TranCurrencyItem item : compTranData.getTran_CurrencyItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("19 - 19 외화 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "21", "21", "사원인증 아이템"
            for(TranEMPItem item : compTranData.getTran_EMPItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("21 - 21 사원인증 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "22", "22", "현금IC카드 아이템"
            for(TranCashICItem item : compTranData.getTran_CashICItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("22 - 22 현금IC카드 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "23", "23", "사은품취소 아이템"
            for(TranEventCancelItem item : compTranData.getTran_EventCancelItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("23 - 23 사은품취소 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "24", "24", "통합플랫폼(SSGPAY) 아이템"
            for(TranSSGPayItem item : compTranData.getTran_SSGPayItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLen());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLen());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("24 - 24 통합플랫폼(SSGPAY) 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "25", "25", "위챗페이 거래 ITEM"
            for(TranWeChatPayItem item : compTranData.getTran_WeChatPayItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("25 - 25 위챗페이 거래 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "26", "26", "즉시환급 거래 ITEM"
            for(TranTaxRefundItem item : compTranData.getTran_TaxRefundItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("26 - 26 즉시환급 거래 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "27", "27", "스크래치상품권 아이템"
            for(TranGiftScratchItem item : compTranData.getTran_GiftScratchItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("27 - 27 스크래치상품권 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "28", "28", "상품권샵 상품권 판매/회수 ITEM"
            for(TranGiftSaleItem item : compTranData.getTran_GiftSaleItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("28 - 28 상품권샵 상품권 판매/회수 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "29", "29", "상품권샵 PM 아이템"
            for(TranGiftPmItem item : compTranData.getTran_GiftPmItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("29 - 29 상품권샵 PM 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "30", "30", "준비금 아이템"
            for(TranReadyAmtItem item : compTranData.getTran_ReadyAmtItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("30 - 30 준비금 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "31", "31", "상품권 키오스크 강제지급 원거래 ITEM"
            for(TranGiftKioskOrgTranItem item : compTranData.getTran_GiftKioskOrgTranItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("31 - 31 상품권 키오스크 강제지급 원거래 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "40", "40", "중간입금 아이템"
            for(TranMidAmtItem item : compTranData.getTran_MidAmtItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("40 - 40 중간입금 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "41", "41", "캐쉬터미널 공통 정보"
            for(TranCashTerCommItem item : compTranData.getTran_CashTerCommItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("41 - 41 캐쉬터미널 공통 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "42", "42", "캐쉬터미널 장애상태 정보"
            for(TranCashTerErrorItem item : compTranData.getTran_CashTerErrorItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("42 - 42 캐쉬터미널 장애상태 정보 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "43", "43", "캐쉬터미널 개국 아이템"
            for(TranCashTerStartItem item : compTranData.getTran_CashTerStartItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("43 - 43 캐쉬터미널 개국 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "44", "44", "캐쉬터미널 시재장입/회수 아이템"
            for(TranCashTerCashinItem item : compTranData.getTran_CashTerCashinItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("44 - 44 캐쉬터미널 시재장입/회수 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "45", "45", "캐쉬터미널 시재회수-상품권 아이템"
            for(TranCashTerGiftinItem item : compTranData.getTran_CashTerGiftinItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("45 - 45 캐쉬터미널 시재회수-상품권 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "46", "46", "캐쉬터미널 정산기 입출금 시재 아이템"
            for(TranCashTerCashItem item : compTranData.getTran_CashTerCashItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("46 - 46 캐쉬터미널 정산기 입출금 시재 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "47", "47", "캐쉬터미널 정산기 입금 아이템"
            for(TranCashTerCashrecvItem item : compTranData.getTran_CashTerCashrecvItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("47 - 47 캐쉬터미널 정산기 입금 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "48", "C2", "캐쉬터미널 상품권 입금 아이템"
            for(TranCashTerGiftrecvItem item : compTranData.getTran_CashTerGiftrecvItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("48 - C2 캐쉬터미널 상품권 입금 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "49", "49", "캐쉬터미널 상품권 일련번호 아이템"
            for(TranCashTerGiftSeqItem item : compTranData.getTran_CashTerGiftSeqItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("49 - 49 캐쉬터미널 상품권 일련번호 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "50", "50", "캐쉬터미널 입출금 원거래 정보 아이템"
            for(TranCashTerInOutOrgItem item : compTranData.getTran_CashTerInOutOrgItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("50 - 50 캐쉬터미널 상품권 일련번호 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "52", "52", "SCO스캔저울증가횟수"
            for(TranScoScaslupCntItem item : compTranData.getTran_ScoScaslupCntItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("52 - 52 스캔저울증가횟수 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "55", "55", "시코르 통합 멤버십 ITEM"
            for(TranChicorOnOffItem item : compTranData.getTran_ChicorOnOffItem()){
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("55 - 55 시코르 통합 멤버십 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "63", "63", "교환 거래 ITEM"
            for(TranExchangeItem item : compTranData.getTran_ExchangeItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("63 - 63 교환 거래 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "64", "64", "신세계 포인트 아이템"
            for(TranPointItem item : compTranData.getTran_PointItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("64 - 64 신세계 포인트 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "67", "67", "세일리지 아이템"
            for(TranVipMileageItem item : compTranData.getTran_VipMileageItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("67 - 67 세일리지 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "68", "68", "쓱콘 아이템"
            for(TranSSGConItem item : compTranData.getTran_SSGConItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("68 - 68 쓱콘 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "74", "74", "모바일&신세계MMS ITEM"
            for(TranMobileMmsItem item : compTranData.getTran_MobileMmsItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("74 - 74 모바일&신세계MMS 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "78", "78", "리워드(보상형) 아이템"
            for(TranShinBaekRewardItem item : compTranData.getTran_ShinBaekRewardItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("78 - 78 리워드(보상형) 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "79", "79", "리워드(쿠폰) 아이템"
            for(TranShinBaekRewardCouponItem item : compTranData.getTran_ShinBaekRewardCouponItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("79 - 79 리워드(쿠폰) 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "81", "81", "상품권 판매 키오스크 공통정보"
            for(TranGiftKioskCommItem item : compTranData.getTran_GiftKioskCommItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("81 - 81 상품권 판매 키오스크 공통정보 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "82", "82", "상품권 판매 키오스크 장애상태정보"
            for(TranGiftKioskErrorItem item : compTranData.getTran_GiftKioskErrorItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("82 - 82 상품권 판매 키오스크 장애상태정보 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "83", "83", "상품권 판매 키오스크 개국발생"
            for(TranGiftKioskStartItem item : compTranData.getTran_GiftKioskStartItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("83 - 83 상품권 판매 키오스크 장애상태정보 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "84", "84", "상품권 판매 키오스크 시재장입및회수"
            for(TranGiftKioskInOutItem item : compTranData.getTran_GiftKioskInOutItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("84 - 84 상품권 판매 키오스크 시재장입및회수 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "86", "86", "상품권 판매 키오스크 정산기시재"
            for(TranGiftKioskCalcItem item : compTranData.getTran_GiftKioskCalcItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("86 - 86 상품권 판매 키오스크 정산기시재 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "89", "89", "상품권 판매 키오스크 상품권일련번호"
            for(TranGiftKioskGiftSeqItem item : compTranData.getTran_GiftKioskGiftSeqItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("89 - 89 상품권 판매 키오스크 상품권일련번호 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "99", "99", "정산시재금 아이템"
            for(TranCalcItem item : compTranData.getTran_CalcItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("99 - 99 정산시재금 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "05", "05", "PDA중간입금 아이템"
            for(TranMidPdaAmtItem item : compTranData.getTran_MidPdaAmtItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("05 - 05 PDA중간입금 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "71", "71", "시코르 클럽 세일리지"
            for(TranChicorClubItem item : compTranData.getTran_ChicorClubItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("71 - 71 시코르 클럽 세일리지 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "76", "76", "캐시터미널 사용매출출금"
            for(TranCashTerUseSaleItem item : compTranData.getTran_CashTerUseSaleItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("76 - 76 캐시터미널 사용매출출금 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "56", "56", "특정매입 단품세트 구성상품 아이템"
            for(TranSetItem item : compTranData.getTran_SetItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("56 - 56 특정매입 단품세트 구성상품 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // ----------------------- < 변경 >
            // "11", "11", "현금성 아이템"
            for(TranCashItemN item : compTranData.getTran_CashItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("11 - 11 현금성 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "62", "62", "외상거래 아이템"
            for(TranDepositItem item : compTranData.getTran_DepositItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("62 - 62 외상거래 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "61", "B0", "상품정보 아이템"
            for(TranGoodsItemN item : compTranData.getTran_GoodsItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("61 - B0 상품정보 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "70", "B2", "시코르 증정/SET 아이템"
            for(TranCCFreeSetItemN item : compTranData.getTran_CCFreeSetItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("70 - B2 시코르 증정/SET 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "75", "C0", "캐시터미널 E-Accounting 결재출금"
            for(TranCashTerExpenItemN item : compTranData.getTran_CashTerExpenItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("75 - C0 캐시터미널 E-Accounting 결재출금 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "51", "C1", "캐쉬터미널 연동 POS 입출금 거래 금액 정보 아이템"
            for(TranCashTerAmtItemDxN item : compTranData.getTran_CashTerAmtItem_DX()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("51 - C1 캐쉬터미널 연동 POS 입출금 거래 금액 정보 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "66", "D0", "NEW DMS ITEM"
            for(TranDmsItemN item : compTranData.getTran_DmsItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("66 - D0 NEW DMS 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "73", "D1", "행사정보 ITEM(BMP 청구할인)"
            for(TranBmpCampaignItemN item : compTranData.getTran_BmpCampaignItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("73 - D1 행사정보 ITEM(BMP 청구할인) 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "65", "E1", "신용카드(IC) 아이템"
            for(TranCardIcItemN item : compTranData.getTran_CardIcItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("65 - E1 신용카드(IC) 아이템 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "90", "E2", "카카오페이 ITEM"
            for(TranKakaopayItemN item : compTranData.getTran_KakaopayItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("90 - E2 카카오페이 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "98", "E3", "간편결제 통합전문 ITEM"
            for(TranEasyPaymentItemN item : compTranData.getTran_EasyPaymentItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("98 - E3 간편결제 통합전문 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "16", "E4", "수표 아이템"
            for(TranSupyoItemN item : compTranData.getTran_SupyoItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("16 - E4 수표 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "77", "E8", "신백머니 아이템"
            for(TranShinBaekMoneyItemN item : compTranData.getTran_ShinBaekMoneyItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("77 - E8 신백머니 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "58", "58", "페이코인 아이템"
            for(TranPaycoinItemN item : compTranData.getTran_PaycoinItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info("58 - 58 페이코인 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // ----------------------- < 신규 >
            // "", "E5", "기타결제"
            for(TranEtcPayItemC item : compTranData.getTran_EtcPayItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info(" - E5 기타결제 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "", "E6", "사용매출 특판(점포,법인)"
            for(TranUseSaleSpecialItemC item : compTranData.getTran_UseSaleSpecialItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info(" - E6 사용매출 특판(점포,법인) 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "", "E7", "선수예약판매"
            for(TranPreReservSaleItemC item : compTranData.getTran_PreReservSaleItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info(" - E7 선수예약판매 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "", "E9", "권유자(퍼스널쇼퍼)"
            for(TranRecommanderItemC item : compTranData.getTran_RecommanderItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info(" - E9 권유자(퍼스널쇼퍼) 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "", "EA", "마일리지자동적립"
            for(TranMileageAutoSaveItemC item : compTranData.getTran_MileageAutoSaveItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info(" - EA 마일리지자동적립 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "", "EB", "비대면 가상계좌 결제"
            for(TranUntactAccountItemC item : compTranData.getTran_UntactAccountItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info(" - EB 비대면 가상계좌 결제 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            // "", "EC", "비대면 결제"
            for(TranUntactCardItemC item : compTranData.getTran_UntactCardItem()){
                if(nLoop == 0)
                    nILen = ParseHelper.convStrToInt(item.getItemLength());
                nTLen = nTLen + ParseHelper.convStrToInt(item.getItemLength());
                nLoop++;
            }
            if(nLoop > 0)
                log.info(" - EC 비대면 결제 아이템 반복 : {}, 아이템길이 : {}, 전체길이 : {}", nLoop, nILen, nTLen);
            nLoop = 0;
            nILen = 0;

            log.debug("func:getTotalTranItemLength() -- TotalTranItemLength:{}", nTLen);
            ret = nTLen;
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 트란 전문 파싱
     * 
     * @return
     */
    public int parseTranItem(){
        int ret = -1;
        String sTranInfo = "";
        // 상품 트랜의 시퀀스를 변환하면서 새롭게 만들어 준다 (20240228 윤동규)
        int nGoodsItemItemSeq = 0;
        tranGoodsItemShopCd = "";
        tranGoodsItemBizRelmCd = "";

        try{
            byte[] tranDataBytes = getTranDataOBytes();
            int tranDataDecLen = getTranDataOBytes().length;
            EnmTranItemCodeWrap enmTranItemCodeWrap = EnmTranItemCodeWrap.Tran_UnKnown;

            if(offSet[0] == tranDataDecLen){
                ret = 0;
            }else{
                sTranInfo = String.format("SaleDate : %s, StoreCode : %s, PosNo : %s, TranNo : %s",
                        compTranData.getTran_Header_O().getSaleDate(), compTranData.getTran_Header_O().getStoreNo(),
                        compTranData.getTran_Header_O().getPosNo(), compTranData.getTran_Header_O().getTranNo());
                logTranInfo = sTranInfo;

                logParamMap.clear();
                logParamMap.put("saleDate", compTranData.getTran_Header_O().getSaleDate());
                logParamMap.put("storeCode", compTranData.getTran_Header_O().getStoreNo());
                logParamMap.put("posNo", compTranData.getTran_Header_O().getPosNo());
                logParamMap.put("tranNo", compTranData.getTran_Header_O().getTranNo());

                while(offSet[0] < tranDataDecLen){
                    nDebugFlag = 0;
                    ItemHeader itemHeader = new ItemHeader();
                    ret = ParseHelper.tranMapToObj(tranDataBytes, offSet, itemHeader, IEnumComIrt.DEF_ITEM_HD_LEN, 0,
                            true, false);

                    if(ret == 0){
                        enmTranItemCodeWrap = EnmTranItemCodeWrap.findItemCodeWithItemCode(itemHeader.getItemCode());

                        if(enmTranItemCodeWrap.name() == EnmTranItemCode.Tran_UnKnown.name()){
                            ret = -1;
                            log.error(
                                    "func:parseTranItem() -- [ERROR] TranItemCode error!! -- ItemCode:{}, TranInfo : {}",
                                    itemHeader.getItemCode(), sTranInfo);
                        }
                        // 디버깅용
                        log.info("\nPARSE 구아이템 : {}, 신아이템 : {}, 트랜명 : {}", enmTranItemCodeWrap.getItemCode_O(),
                                enmTranItemCodeWrap.getItemCode_N(), enmTranItemCodeWrap.getItemCodeDesc());
                    }

                    if(ret == 0){
                        // 트란 아이템 코드에 따른 분기 처리
                        switch(enmTranItemCodeWrap.getItemCode())
                        {
                            case Tran_CashBillItem: // "03","03","현금영수증아이템"
                                ret = parseTranCashBillItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_GiftItem: // "12","12","상품권아이템"
                                ret = parseTranGiftItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_CardItem: // "14","14","신용카드(MSR)아이템"
                                ret = parseTranCardItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_GIFTCardItem: // "18","18","전자상품권아이템"
                                ret = parseTranGIFTCardItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_CurrencyItem: // "19","19","외화아이템"
                                ret = parseTranCurrencyItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_EMPItem: // "21","21","사원인증아이템"
                                ret = parseTranEMPItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_CashICItem: // "22","22","현금IC카드아이템"
                                ret = parseTranCashICItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_EventCancelItem: // "23","23","사은품취소아이템"
                                ret = parseTranEventCancelItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_SSGPayItem: // "24","24","통합플랫폼(SSGPAY)아이템"
                                ret = parseTranSSGPayItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_WeChatPayItem: // "25","25","위챗페이거래ITEM"
                                ret = parseTranWeChatPayItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_TaxRefundItem: // "26","26","즉시환급거래ITEM"
                                ret = parseTranTaxRefundItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_GiftScratchItem: // "27","27","스크래치상품권아이템"
                                ret = parseTranGiftScratchItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_GiftSaleItem: // "28","28","상품권샵상품권판매/회수ITEM"
                                ret = parseTranGiftSaleItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_GiftPmItem: // "29","29","상품권샵PM아이템"
                                ret = parseTranGiftPmItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_ReadyAmtItem: // "30","30","준비금아이템"
                                ret = parseTranReadyAmtItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_GiftKioskOrgTranItem: // "31","31","상품권키오스크강제지급원거래ITEM"
                                ret = parseTranGiftKioskOrgTranItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_MidAmtItem: // "40","40","중간입금아이템"
                                ret = parseTranMidAmtItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_CashTerCommItem: // "41","41","캐쉬터미널공통정보"
                                ret = parseTranCashTerCommItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_CashTerErrorItem: // "42","42","캐쉬터미널장애상태정보"
                                ret = parseTranCashTerErrorItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_CashTerStartItem: // "43","43","캐쉬터미널개국아이템"
                                ret = parseTranCashTerStartItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_CashTerCashinItem: // "44","44","캐쉬터미널시재장입/회수아이템"
                                ret = parseTranCashTerCashinItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_CashTerGiftinItem: // "45","45","캐쉬터미널시재회수-상품권아이템"
                                ret = parseTranCashTerGiftinItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_CashTerCashItem: // "46","46","캐쉬터미널정산기입출금시재아이템"
                                ret = parseTranCashTerCashItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_CashTerCashrecvItem: // "47","47","캐쉬터미널정산기입금아이템"
                                ret = parseTranCashTerCashrecvItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_CashTerGiftrecvItem: // "48","C2","캐쉬터미널상품권입금아이템"
                                ret = parseTranCashTerGiftrecvItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_CashTerGiftSeqItem: // "49","49","캐쉬터미널상품권일련번호아이템"
                                ret = parseTranCashTerGiftSeqItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_CashTerInOutOrgItem: // "50","50","캐쉬터미널입출금원거래정보아이템"
                                ret = parseTranCashTerInOutOrgItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_ScoScaslupCntItem: // "52","52","SCO스캔저울증가횟수"
                                ret = parseTranScoScaslupCntItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_ChicorOnOffItem: // "55","55","시코르통합멤버십ITEM"
                                ret = parseTranChicorOnOffItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_ExchangeItem: // "63","63","교환거래ITEM"
                                ret = parseTranExchangeItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_PointItem: // "64","64","신세계포인트아이템"
                                ret = parseTranPointItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_VipMileageItem: // "67","67","세일리지아이템"
                                ret = parseTranVipMileageItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_SSGConItem: // "68","68","쓱콘아이템"
                                ret = parseTranSSGConItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_MobileMmsItem: // "74","74","모바일&신세계MMSITEM"
                                ret = parseTranMobileMmsItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_ShinBaekRewardItem: // "78","78","리워드(보상형)아이템"
                                ret = parseTranShinBaekRewardItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_ShinBaekRewardCouponItem: // "79","79","리워드(쿠폰)아이템"
                                ret = parseTranShinBaekRewardCouponItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_GiftKioskCommItem: // "81","81","상품권판매키오스크공통정보"
                                ret = parseTranGiftKioskCommItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_GiftKioskErrorItem: // "82","82","상품권판매키오스크장애상태정보"
                                ret = parseTranGiftKioskErrorItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_GiftKioskStartItem: // "83","83","상품권판매키오스크개국발생"
                                ret = parseTranGiftKioskStartItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_GiftKioskInOutItem: // "84","84","상품권판매키오스크시재장입및회수"
                                ret = parseTranGiftKioskInOutItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_GiftKioskCalcItem: // "86","86","상품권판매키오스크정산기시재"
                                ret = parseTranGiftKioskCalcItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_GiftKioskGiftSeqItem: // "89","89","상품권판매키오스크상품권일련번호"
                                ret = parseTranGiftKioskGiftSeqItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_CalcItem: // "99","99","정산시재금아이템"
                                ret = parseTranCalcItem(itemHeader.getItemLengthNum());
                                break;
                            // ----------------------- < 변경 >
                            case Tran_CashItem: // "11","11","현금성아이템"
                                ret = parseTranCashItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_DepositItem: // "62","62","외상거래아이템"
                                ret = parseTranDepositItem(itemHeader.getItemLengthNum(), sTranInfo);
                                break;
                            case Tran_GoodsItem: // "61","B0","상품정보아이템"
                                nGoodsItemItemSeq++;
                                ret = parseTranGoodsItem(itemHeader.getItemLengthNum(), sTranInfo, nGoodsItemItemSeq);
                                break;
                            case Tran_CCFreeSetItem: // "70","B2","시코르증정/SET아이템"
                                ret = parseTranCCFreeSetItem(itemHeader.getItemLengthNum(), sTranInfo);
                                break;
                            case Tran_CashTerExpenItem: // "75","C0","캐시터미널E-Accounting결재출금"
                                ret = parseTranCashTerExpenItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_CashTerAmtItem_DX: // "51","C1","캐쉬터미널연동POS입출금거래금액정보아이템"
                                ret = parseTranCashTerAmtItem_DX(itemHeader.getItemLengthNum(), sTranInfo);
                                break;
                            case Tran_DmsItem: // "66","D0","NEWDMSITEM"
                                ret = parseTranDmsItem(itemHeader.getItemLengthNum(), sTranInfo);
                                break;
                            case Tran_BmpCampaignItem: // "73","D1","행사정보ITEM(BMP청구할인)"
                                ret = parseTranBmpCampaignItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_CardIcItem: // "65","E1","신용카드(IC)아이템"
                                ret = parseTranCardIcItem(itemHeader.getItemLengthNum(), sTranInfo);
                                break;
                            case Tran_KakaopayItem: // "90","E2","카카오페이ITEM"
                                ret = parseTranKakaopayItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_EasyPaymentItem: // "98","E3","간편결제통합전문ITEM"
                                ret = parseTranEasyPaymentItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_SupyoItem: // "16","E4","수표아이템"
                                ret = parseTranSupyoItem(itemHeader.getItemLengthNum());
                                break;
                            // case Tran_EtcPayItem: //"","E5","기타결제"
                            // break;
                            // case Tran_UseSaleSpecialItem:
                            // //"","E6","사용매출특판(점포,법인)"
                            // break;
                            // case Tran_PreReservSaleItem: //"","E7","선수예약판매"
                            // break;
                            case Tran_ShinBaekMoneyItem: // "77","E8","신백머니아이템"
                                ret = parseTranShinBaekMoneyItem(itemHeader.getItemLengthNum());
                                break;
                            // case Tran_RecommanderItem: //"","E9","권유자(퍼스널쇼퍼)"
                            // break;
                            // case Tran_MileageAutoSaveItem:
                            // //"","EA","마일리지자동적립"
                            // break;
                            // case Tran_UntactAccountItem:
                            // //"","EB","비대면가상계좌결제"
                            // break;
                            // case Tran_UntactCardItem: //"","EC","비대면카드결제"
                            // break;
                            case Tran_MidPdaAmtItem: // "05","05","PDA중간입금아이템"
                                ret = parseTranMidPdaAmtItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_ChicorClubItem: // "71","71","시코르클럽세일리지"
                                ret = parseTranChicorClubItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_CashTerUseSaleItem: // "76","76","캐시터미널사용매출출금"
                                ret = parseTranCashTerUseSaleItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_SetItem: // "56","56","특정매입단품세트구성상품아이템"
                                ret = parseTranSetItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_PaycoinItem: // "58","58","페이코인아이템"
                                ret = parseTranPaycoinItem(itemHeader.getItemLengthNum());
                                break;
                            case Tran_UnKnown:
                                break;
                            // 파싱제외(무시)전문은offset만증가시킨다
                            default:
                                log.debug(String.format("fn:%s -- ItemCode:%s -- ItemLength:%s skip!!",
                                        itemHeader.getItemCode(), itemHeader.getItemLength()));
                                offSet[0] += itemHeader.getItemLengthNum();
                                break;
                        } // switch
                    } // if

                    if(ret != 0){
                        log.error("TranInfo Error : {}", sTranInfo);
                        log.info("ERROR 구아이템 : {}, 신아이템 : {}, 트랜명 : {}", enmTranItemCodeWrap.getItemCode_O(),
                                enmTranItemCodeWrap.getItemCode_N(), enmTranItemCodeWrap.getItemCodeDesc());
                        break;
                    }
                } // while
            }
        }catch(Exception e){
            log.error("TranInfo : {}, Error : {}", sTranInfo, e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 현금영수증 아이템 ("03", "03")
     * 
     * @return
     */
    public int parseTranCashBillItem(int itemLength){
        int ret = -1;

        try{
            TranCashBillItem tranCashBillItem = new TranCashBillItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranCashBillItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_CashBillItem().add(tranCashBillItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 상품권 아이템 ("12", "12")
     * 
     * @return
     */
    public int parseTranGiftItem(int itemLength){
        int ret = -1;

        try{
            TranGiftItem tranGiftItem = new TranGiftItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranGiftItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_GiftItem().add(tranGiftItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 신용카드(MSR) 아이템 ("14", "14")
     * 
     * @return
     */
    public int parseTranCardItem(int itemLength){
        int ret = -1;

        try{
            TranCardItem tranCardItem = new TranCardItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranCardItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_CardItem().add(tranCardItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 전자상품권 아이템 ("18", "18")
     * 
     * @return
     */
    public int parseTranGIFTCardItem(int itemLength){
        int ret = -1;

        try{
            TranGIFTCardItem tranGIFTCardItem = new TranGIFTCardItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranGIFTCardItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_GIFTCardItem().add(tranGIFTCardItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 외화 아이템 ("19", "19")
     * 
     * @return
     */
    public int parseTranCurrencyItem(int itemLength){
        int ret = -1;

        try{
            TranCurrencyItem tranCurrencyItem = new TranCurrencyItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranCurrencyItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_CurrencyItem().add(tranCurrencyItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 사원인증 아이템 ("21", "21")
     * 
     * @return
     */
    public int parseTranEMPItem(int itemLength){
        int ret = -1;

        try{
            TranEMPItem tranEMPItem = new TranEMPItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranEMPItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_EMPItem().add(tranEMPItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 현금IC카드 아이템 ("22", "22")
     * 
     * @return
     */
    public int parseTranCashICItem(int itemLength){
        int ret = -1;

        try{
            TranCashICItem tranCashICItem = new TranCashICItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranCashICItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_CashICItem().add(tranCashICItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 사은품취소 아이템 ("23", "23")
     * 
     * @return
     */
    public int parseTranEventCancelItem(int itemLength){
        int ret = -1;

        try{
            int preOffSet = offSet[0];

            TranEventCancelItem tranEventCancelItem = new TranEventCancelItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranEventCancelItem, itemLength,
                    EnmTranItemCodeWrap.Tran_CardIcItem.getItemCodeLen_O(), false, true);

            if(ret == 0){
                int teciEventItemSize = ParseHelper.tranTotalSize(TranEventCancelItem.TECIEventItem.class);
                int exLoopLen = offSet[0] - preOffSet;
                int LoopCnt = (itemLength - exLoopLen) / teciEventItemSize;

                for(int i = 0; i < LoopCnt; i++){
                    TranEventCancelItem.TECIEventItem teciEventItem = new TranEventCancelItem.TECIEventItem();
                    ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, teciEventItem, 0, 0, false, false);
                    if(ret == 0)
                        tranEventCancelItem.getEventItem().add(teciEventItem);
                    else
                        break;
                }
            }

            if(ret == 0){
                compTranData.getTran_EventCancelItem().add(tranEventCancelItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 통합플랫폼(SSGPAY) 아이템 ("24", "24")
     * 
     * @return
     */
    public int parseTranSSGPayItem(int itemLength){
        int ret = -1;

        try{
            TranSSGPayItem tranSSGPayItem = new TranSSGPayItem();

            if(itemLength == 2854){
                log.info("통합플랫폼(SSGPAY) 아이템 길이 : 2854 일때 분해 처리");
                ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranSSGPayItem, 0, 0, false, false);
            }
            // 1954
            else{
                log.info("통합플랫폼(SSGPAY) 아이템 길이 : 1954 일때 분해 처리");
                TranSSGPayItemII tranSSGPayItemII = new TranSSGPayItemII();
                ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranSSGPayItemII, 0, 0, false, false);

                if(ret == 0){
                    tranSSGPayItem.setItemCode(tranSSGPayItemII.getItemCode());
                    tranSSGPayItem.setItemLen(tranSSGPayItemII.getItemLen());
                    tranSSGPayItem.setSendDate(tranSSGPayItemII.getSendDate());
                    tranSSGPayItem.setSendUniqNo(tranSSGPayItemII.getSendUniqNo());
                    tranSSGPayItem.setMsgGubun(tranSSGPayItemII.getMsgGubun());
                    tranSSGPayItem.setTranType(tranSSGPayItemII.getTranType());
                    tranSSGPayItem.setComCode(tranSSGPayItemII.getComCode());
                    tranSSGPayItem.setTermId(tranSSGPayItemII.getTermId());
                    tranSSGPayItem.setSaleDate(tranSSGPayItemII.getSaleDate());
                    tranSSGPayItem.setSaleTime(tranSSGPayItemII.getSaleTime());
                    tranSSGPayItem.setStoreNo(tranSSGPayItemII.getStoreNo());
                    tranSSGPayItem.setTMNo(tranSSGPayItemII.getTMNo());
                    tranSSGPayItem.setShopNo(tranSSGPayItemII.getShopNo());
                    tranSSGPayItem.setCDNo(tranSSGPayItemII.getCDNo());
                    tranSSGPayItem.setTranNo(tranSSGPayItemII.getTranNo());
                    tranSSGPayItem.setCashierNo(tranSSGPayItemII.getCashierNo());
                    tranSSGPayItem.setPosDate(tranSSGPayItemII.getPosDate());
                    tranSSGPayItem.setPosTime(tranSSGPayItemII.getPosTime());
                    tranSSGPayItem.setNormalGubun(tranSSGPayItemII.getNormalGubun());
                    tranSSGPayItem.setBuyFirmCode(tranSSGPayItemII.getBuyFirmCode());
                    tranSSGPayItem.setBuyFirmNM(tranSSGPayItemII.getBuyFirmNM());
                    tranSSGPayItem.setIssueFirmCode(tranSSGPayItemII.getIssueFirmCode());
                    tranSSGPayItem.setIssueFirmNM(tranSSGPayItemII.getIssueFirmNM());
                    tranSSGPayItem.setCardSysDate(tranSSGPayItemII.getCardSysDate());
                    tranSSGPayItem.setCardSysTime(tranSSGPayItemII.getCardSysTime());
                    tranSSGPayItem.setCardUniqNo(tranSSGPayItemII.getCardUniqNo());
                    tranSSGPayItem.setCardMchNo(tranSSGPayItemII.getCardMchNo());
                    tranSSGPayItem.setComUniqNo(tranSSGPayItemII.getComUniqNo());
                    tranSSGPayItem.setJumpoSysDate(tranSSGPayItemII.getJumpoSysDate());
                    tranSSGPayItem.setJumpoSysTime(tranSSGPayItemII.getJumpoSysTime());
                    tranSSGPayItem.setRespCode(tranSSGPayItemII.getRespCode());
                    tranSSGPayItem.setRespMsg(tranSSGPayItemII.getRespMsg());
                    tranSSGPayItem.setBankCode(tranSSGPayItemII.getBankCode());
                    tranSSGPayItem.setBankNm(tranSSGPayItemII.getBankNm());
                    tranSSGPayItem.setBankVanFlag(tranSSGPayItemII.getBankVanFlag());
                    tranSSGPayItem.setPlatformMId(tranSSGPayItemII.getPlatformMId());
                    tranSSGPayItem.setCARD_EVENT_KEY(tranSSGPayItemII.getCARD_EVENT_KEY());
                    tranSSGPayItem.setHeadFiller(tranSSGPayItemII.getHeadFiller());
                    tranSSGPayItem.setDelegateBarcodeNo(tranSSGPayItemII.getDelegateBarcodeNo());
                    tranSSGPayItem.setReceiptNo(tranSSGPayItemII.getReceiptNo());
                    tranSSGPayItem.setOrgReceiptNo(tranSSGPayItemII.getOrgReceiptNo());
                    tranSSGPayItem.setEmpNoPlatYn(tranSSGPayItemII.getEmpNoPlatYn());
                    tranSSGPayItem.setEmpNoYN(tranSSGPayItemII.getEmpNoYN());
                    tranSSGPayItem.setEmpIdNo(tranSSGPayItemII.getEmpIdNo());
                    tranSSGPayItem.setSPointPlatYn(tranSSGPayItemII.getSPointPlatYn());
                    tranSSGPayItem.setSPointYN(tranSSGPayItemII.getSPointYN());
                    tranSSGPayItem.setSPointCardNo(tranSSGPayItemII.getSPointCardNo());
                    tranSSGPayItem.setMGiftCardPlatYN(tranSSGPayItemII.getMGiftCardPlatYN());
                    tranSSGPayItem.setMGiftCardYN(tranSSGPayItemII.getMGiftCardYN());
                    tranSSGPayItem.setMGiftCardNo(tranSSGPayItemII.getMGiftCardNo());
                    tranSSGPayItem.setMGiftCardUseAmt(tranSSGPayItemII.getMGiftCardUseAmt());
                    tranSSGPayItem.setMGiftCardAuthDate(tranSSGPayItemII.getMGiftCardAuthDate());
                    tranSSGPayItem.setMGiftCardAuthNo(tranSSGPayItemII.getMGiftCardAuthNo());
                    tranSSGPayItem.setOrgMGiftCardAuthDate(tranSSGPayItemII.getOrgMGiftCardAuthDate());
                    tranSSGPayItem.setOrgMGiftCardAuthNo(tranSSGPayItemII.getOrgMGiftCardAuthNo());
                    tranSSGPayItem.setCreditCardPlatYN(tranSSGPayItemII.getCreditCardPlatYN());
                    tranSSGPayItem.setCreditCardYN(tranSSGPayItemII.getCreditCardYN());
                    tranSSGPayItem.setCardCertFlag(tranSSGPayItemII.getCardCertFlag());
                    tranSSGPayItem.setCreditCardNo(tranSSGPayItemII.getCreditCardNo());
                    tranSSGPayItem.setCreditCardInsMon(tranSSGPayItemII.getCreditCardInsMon());
                    tranSSGPayItem.setCreditCardUseAmt(tranSSGPayItemII.getCreditCardUseAmt());
                    tranSSGPayItem.setCreditCardAuthDate(tranSSGPayItemII.getCreditCardAuthDate());
                    tranSSGPayItem.setCreditCardAuthNo(tranSSGPayItemII.getCreditCardAuthNo());
                    tranSSGPayItem.setCreditCardReceiptA(tranSSGPayItemII.getCreditCardReceiptA());
                    tranSSGPayItem.setCreditCardReceiptD(tranSSGPayItemII.getCreditCardReceiptD());
                    tranSSGPayItem.setOrgCreditCardAuthDate(tranSSGPayItemII.getOrgCreditCardAuthDate());
                    tranSSGPayItem.setOrgCreditCardAuthNo(tranSSGPayItemII.getOrgCreditCardAuthNo());
                    tranSSGPayItem.setCashReceiptInfoPlatYN(tranSSGPayItemII.getCashReceiptInfoPlatYN());
                    tranSSGPayItem.setCashReceiptInfoYN(tranSSGPayItemII.getCashReceiptInfoYN());
                    tranSSGPayItem.setCashReceiptInfo(tranSSGPayItemII.getCashReceiptInfo());
                    tranSSGPayItem.setEtcPayYN(tranSSGPayItemII.getEtcPayYN());
                    tranSSGPayItem.setEtcPayAmt(tranSSGPayItemII.getEtcPayAmt());
                    tranSSGPayItem.setOrgSendDate(tranSSGPayItemII.getOrgSendDate());
                    tranSSGPayItem.setOrgSendUniqNo(tranSSGPayItemII.getOrgSendUniqNo());
                    tranSSGPayItem.setOrgComCD(tranSSGPayItemII.getOrgComCD());
                    tranSSGPayItem.setOrgSaleDate(tranSSGPayItemII.getOrgSaleDate());
                    tranSSGPayItem.setOrgStoreNo(tranSSGPayItemII.getOrgStoreNo());
                    tranSSGPayItem.setOrgTMNo(tranSSGPayItemII.getOrgTMNo());
                    tranSSGPayItem.setOrgShopNo(tranSSGPayItemII.getOrgShopNo());
                    tranSSGPayItem.setOrgCDNo(tranSSGPayItemII.getOrgCDNo());
                    tranSSGPayItem.setOrgTranNo(tranSSGPayItemII.getOrgTranNo());
                    tranSSGPayItem.setOrgCasherNo(tranSSGPayItemII.getOrgCasherNo());
                    tranSSGPayItem.setTotAmt(tranSSGPayItemII.getTotAmt());
                    tranSSGPayItem.setDisAmt(tranSSGPayItemII.getDisAmt());
                    tranSSGPayItem.setNetAmt(tranSSGPayItemII.getNetAmt());
                    tranSSGPayItem.setMdCount(tranSSGPayItemII.getMdCount());
                    tranSSGPayItem.setMdCode(tranSSGPayItemII.getMdCode());
                    tranSSGPayItem.setMdName(tranSSGPayItemII.getMdName());
                    tranSSGPayItem.setEventMdInYN(tranSSGPayItemII.getEventMdInYN());
                    tranSSGPayItem.setEventYN(tranSSGPayItemII.getEventYN());
                    tranSSGPayItem.setCnclGubun(tranSSGPayItemII.getCnclGubun());
                    tranSSGPayItem.setCnclUseYn(tranSSGPayItemII.getCnclUseYn());
                    tranSSGPayItem.setBankPlatYn(tranSSGPayItemII.getBankPlatYn());
                    tranSSGPayItem.setBankYn(tranSSGPayItemII.getBankYn());
                    tranSSGPayItem.setBankAccountNo(tranSSGPayItemII.getBankAccountNo());
                    tranSSGPayItem.setBankUseAmt(tranSSGPayItemII.getBankUseAmt());
                    tranSSGPayItem.setBankAuthDate(tranSSGPayItemII.getBankAuthDate());
                    tranSSGPayItem.setBankAuthNo(tranSSGPayItemII.getBankAuthNo());
                    tranSSGPayItem.setBankReceipt(tranSSGPayItemII.getBankReceipt());
                    tranSSGPayItem.setOrgBankAuthDate(tranSSGPayItemII.getOrgBankAuthDate());
                    tranSSGPayItem.setOrgBankAuthNo(tranSSGPayItemII.getOrgBankAuthNo());
                    tranSSGPayItem.setBankCnclGubun(tranSSGPayItemII.getBankCnclGubun());
                    tranSSGPayItem.setBankCnclUseYn(tranSSGPayItemII.getBankCnclUseYn());
                    tranSSGPayItem.setCouponPlatYN(tranSSGPayItemII.getCouponPlatYN());
                    tranSSGPayItem.setCouponUseYN(tranSSGPayItemII.getCouponUseYN());
                    tranSSGPayItem.setCouponAmt(tranSSGPayItemII.getCouponAmt());
                    tranSSGPayItem.setEdiDscntFlag(tranSSGPayItemII.getEdiDscntFlag());
                    tranSSGPayItem.setCUP_AMT(tranSSGPayItemII.getCUP_AMT());
                    tranSSGPayItem.setDataFiller(tranSSGPayItemII.getDataFiller());
                    tranSSGPayItem.setKeyInType(tranSSGPayItemII.getKeyInType());
                    tranSSGPayItem.setCardDateNo(tranSSGPayItemII.getCardDateNo());
                    tranSSGPayItem.setCardCertifyNo(tranSSGPayItemII.getCardCertifyNo());
                    tranSSGPayItem.setCardTrack2Data(tranSSGPayItemII.getCardTrack2Data());
                    tranSSGPayItem.setCardEtcData(tranSSGPayItemII.getCardEtcData());
                    tranSSGPayItem.setCardAuthTime(tranSSGPayItemII.getCardAuthTime());
                    tranSSGPayItem.setDATA2_FIELD_USE_YN(tranSSGPayItemII.getDATA2_FIELD_USE_YN());
                    tranSSGPayItem.setMILG_CNT("");
                    tranSSGPayItem.setMILG1_USE_YN("");
                    tranSSGPayItem.setMILG1_INST_CD("");
                    tranSSGPayItem.setMILG1_MAI_CRD_NO("");
                    tranSSGPayItem.setMILG1_USE_AMT("");
                    tranSSGPayItem.setMILG1_AUTH_DATE("");
                    tranSSGPayItem.setMILG1_AUTH_NO("");
                    tranSSGPayItem.setORG_MILG1_AUTH_DATE("");
                    tranSSGPayItem.setORG_MILG1_AUTH_NO("");
                    tranSSGPayItem.setMILG2_USE_YN("");
                    tranSSGPayItem.setMILG2_INST_CD("");
                    tranSSGPayItem.setMILG2_MAI_CRD_NO("");
                    tranSSGPayItem.setMILG2_USE_AMT("");
                    tranSSGPayItem.setMILG2_AUTH_DATE("");
                    tranSSGPayItem.setMILG2_AUTH_NO("");
                    tranSSGPayItem.setORG_MILG2_AUTH_DATE("");
                    tranSSGPayItem.setORG_MILG2_AUTH_NO("");
                    tranSSGPayItem.setMILG3_USE_YN("");
                    tranSSGPayItem.setMILG3_INST_CD("");
                    tranSSGPayItem.setMILG3_MAI_CRD_NO("");
                    tranSSGPayItem.setMILG3_USE_AMT("");
                    tranSSGPayItem.setMILG3_AUTH_DATE("");
                    tranSSGPayItem.setMILG3_AUTH_NO("");
                    tranSSGPayItem.setORG_MILG3_AUTH_DATE("");
                    tranSSGPayItem.setORG_MILG3_AUTH_NO("");
                    tranSSGPayItem.setMILG4_USE_YN("");
                    tranSSGPayItem.setMILG4_INST_CD("");
                    tranSSGPayItem.setMILG4_MAI_CRD_NO("");
                    tranSSGPayItem.setMILG4_USE_AMT("");
                    tranSSGPayItem.setMILG4_AUTH_DATE("");
                    tranSSGPayItem.setMILG4_AUTH_NO("");
                    tranSSGPayItem.setORG_MILG4_AUTH_DATE("");
                    tranSSGPayItem.setORG_MILG4_AUTH_NO("");
                    tranSSGPayItem.setDATA_ETC_FIELD2("");
                    tranSSGPayItem.setMsgEnd("");
                }
            }
            if(ret == 0){
                compTranData.getTran_SSGPayItem().add(tranSSGPayItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 위챗페이 거래 ITEM ("25", "25")
     * 
     * @return
     */
    public int parseTranWeChatPayItem(int itemLength){
        int ret = -1;

        try{
            TranWeChatPayItem tranWeChatPayItem = new TranWeChatPayItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranWeChatPayItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_WeChatPayItem().add(tranWeChatPayItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 즉시환급 거래 ITEM ("26", "26")
     * 
     * @return
     */
    public int parseTranTaxRefundItem(int itemLength){
        int ret = -1;

        try{
            TranTaxRefundItem tranTaxRefundItem = new TranTaxRefundItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranTaxRefundItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_TaxRefundItem().add(tranTaxRefundItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 스크래치상품권 아이템 ("27", "27")
     * 
     * @return
     */
    public int parseTranGiftScratchItem(int itemLength){
        int ret = -1;

        try{
            TranGiftScratchItem tranGiftScratchItem = new TranGiftScratchItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranGiftScratchItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_GiftScratchItem().add(tranGiftScratchItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 상품권샵 상품권 판매/회수 ITEM ("28", "28")
     * 
     * @return
     */
    public int parseTranGiftSaleItem(int itemLength){
        int ret = -1;

        try{
            TranGiftSaleItem tranGiftSaleItem = new TranGiftSaleItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranGiftSaleItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_GiftSaleItem().add(tranGiftSaleItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 상품권샵 PM 아이템 ("29", "29")
     * 
     * @return
     */
    public int parseTranGiftPmItem(int itemLength){
        int ret = -1;

        try{
            TranGiftPmItem tranGiftPmItem = new TranGiftPmItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranGiftPmItem, itemLength,
                    EnmTranItemCodeWrap.Tran_GiftPmItem.getItemCodeLen_O_exLoopLen(), false, true);

            if(ret == 0){
                compTranData.getTran_GiftPmItem().add(tranGiftPmItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 준비금 아이템 ("30", "30")
     * 
     * @return
     */
    public int parseTranReadyAmtItem(int itemLength){
        int ret = -1;

        try{
            TranReadyAmtItem tranReadyAmtItem = new TranReadyAmtItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranReadyAmtItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_ReadyAmtItem().add(tranReadyAmtItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 상품권 키오스크 강제지급 원거래 ITEM ("31", "31")
     * 
     * @return
     */
    public int parseTranGiftKioskOrgTranItem(int itemLength){
        int ret = -1;

        try{
            TranGiftKioskOrgTranItem tranGiftKioskOrgTranItem = new TranGiftKioskOrgTranItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranGiftKioskOrgTranItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_GiftKioskOrgTranItem().add(tranGiftKioskOrgTranItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 중간입금 아이템 ("40", "40")
     * 
     * @return
     */
    public int parseTranMidAmtItem(int itemLength){
        int ret = -1;

        try{
            TranMidAmtItem tranMidAmtItem = new TranMidAmtItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranMidAmtItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_MidAmtItem().add(tranMidAmtItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 캐쉬터미널 공통 정보 ("41", "41")
     * 
     * @return
     */
    public int parseTranCashTerCommItem(int itemLength){
        int ret = -1;

        try{
            TranCashTerCommItem tranCashTerCommItem = new TranCashTerCommItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranCashTerCommItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_CashTerCommItem().add(tranCashTerCommItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 캐쉬터미널 장애상태 정보 ("42", "42")
     * 
     * @return
     */
    public int parseTranCashTerErrorItem(int itemLength){
        int ret = -1;

        try{
            TranCashTerErrorItem tranCashTerErrorItem = new TranCashTerErrorItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranCashTerErrorItem, itemLength,
                    EnmTranItemCodeWrap.Tran_CashTerErrorItem.getItemCodeLen_O_exLoopLen(), false, true);

            if(ret == 0){
                compTranData.getTran_CashTerErrorItem().add(tranCashTerErrorItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 캐쉬터미널 개국 아이템 ("43", "43")
     * 
     * @return
     */
    public int parseTranCashTerStartItem(int itemLength){
        int ret = -1;

        try{
            TranCashTerStartItem tranCashTerStartItem = new TranCashTerStartItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranCashTerStartItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_CashTerStartItem().add(tranCashTerStartItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 캐쉬터미널 시재장입/회수 아이템 ("44", "44")
     * 
     * @return
     */
    public int parseTranCashTerCashinItem(int itemLength){
        int ret = -1;

        try{
            TranCashTerCashinItem tranCashTerCashinItem = new TranCashTerCashinItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranCashTerCashinItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_CashTerCashinItem().add(tranCashTerCashinItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 캐쉬터미널 시재회수-상품권 아이템 ("45", "45")
     * 
     * @return
     */
    public int parseTranCashTerGiftinItem(int itemLength){
        int ret = -1;

        try{
            TranCashTerGiftinItem tranCashTerGiftinItem = new TranCashTerGiftinItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranCashTerGiftinItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_CashTerGiftinItem().add(tranCashTerGiftinItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 캐쉬터미널 정산기 입출금 시재 아이템 ("46", "46")
     * 
     * @return
     */
    public int parseTranCashTerCashItem(int itemLength){
        int ret = -1;

        try{
            TranCashTerCashItem tranCashTerCashItem = new TranCashTerCashItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranCashTerCashItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_CashTerCashItem().add(tranCashTerCashItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 캐쉬터미널 정산기 입금 아이템 ("47", "47")
     * 
     * @return
     */
    public int parseTranCashTerCashrecvItem(int itemLength){
        int ret = -1;

        try{
            TranCashTerCashrecvItem tranCashTerCashrecvItem = new TranCashTerCashrecvItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranCashTerCashrecvItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_CashTerCashrecvItem().add(tranCashTerCashrecvItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 캐쉬터미널 상품권 입금 아이템 ("48", "C2")
     * 
     * @return
     */
    public int parseTranCashTerGiftrecvItem(int itemLength){
        int ret = -1;

        try{
            TranCashTerGiftrecvItem tranCashTerGiftrecvItem = new TranCashTerGiftrecvItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranCashTerGiftrecvItem, 0, 0, false, false);

            // 신 트란 아이템코드
            tranCashTerGiftrecvItem.setItemCode(EnmTranItemCodeWrap.Tran_CashTerGiftrecvItem.getItemCode_N());

            if(ret == 0){
                compTranData.getTran_CashTerGiftrecvItem().add(tranCashTerGiftrecvItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 캐쉬터미널 상품권 일련번호 아이템 ("49", "49")
     * 
     * @return
     */
    public int parseTranCashTerGiftSeqItem(int itemLength){
        int ret = -1;

        try{
            TranCashTerGiftSeqItem tranCashTerGiftSeqItem = new TranCashTerGiftSeqItem();
            // 5번 고정 반복 리스트 항목 파싱
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranCashTerGiftSeqItem, itemLength,
                    EnmTranItemCodeWrap.Tran_CashTerGiftSeqItem.getItemCodeLen_O_exLoopLen(), false, true);

            if(ret == 0){
                compTranData.getTran_CashTerGiftSeqItem().add(tranCashTerGiftSeqItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 캐쉬터미널 입출금 원거래 정보 아이템 ("50", "50")
     * 
     * @return
     */
    public int parseTranCashTerInOutOrgItem(int itemLength){
        int ret = -1;

        try{
            TranCashTerInOutOrgItem tranCashTerInOutOrgItem = new TranCashTerInOutOrgItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranCashTerInOutOrgItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_CashTerInOutOrgItem().add(tranCashTerInOutOrgItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * SCO스캔저울증가횟수 ("52", "52")
     * 
     * @return
     */
    public int parseTranScoScaslupCntItem(int itemLength){
        int ret = -1;

        try{
            TranScoScaslupCntItem tranScoScaslupCntItem = new TranScoScaslupCntItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranScoScaslupCntItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_ScoScaslupCntItem().add(tranScoScaslupCntItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 시코르 통합 멤버십 ITEM ("55", "55")
     * 
     * @return
     */
    public int parseTranChicorOnOffItem(int itemLength){
        int ret = -1;

        try{
            TranChicorOnOffItem tranChicorOnOffItem = new TranChicorOnOffItem();
            // 5번 고정 반복 리스트 항목 파싱
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranChicorOnOffItem, itemLength,
                    EnmTranItemCodeWrap.Tran_ChicorOnOffItem.getItemCodeLen_O_exLoopLen(), false, true);

            if(ret == 0){
                compTranData.getTran_ChicorOnOffItem().add(tranChicorOnOffItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 교환 거래 ITEM ("63", "63")
     * 
     * @return
     */
    public int parseTranExchangeItem(int itemLength){
        int ret = -1;

        try{
            TranExchangeItem tranExchangeItem = new TranExchangeItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranExchangeItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_ExchangeItem().add(tranExchangeItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 신세계 포인트 아이템 ("64", "64")
     * 
     * @return
     */
    public int parseTranPointItem(int itemLength){
        int ret = -1;

        try{
            TranPointItem tranPointItem = new TranPointItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranPointItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_PointItem().add(tranPointItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 세일리지 아이템 ("67", "67")
     * 
     * @return
     */
    public int parseTranVipMileageItem(int itemLength){
        int ret = -1;

        try{
            TranVipMileageItem tranVipMileageItem = new TranVipMileageItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranVipMileageItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_VipMileageItem().add(tranVipMileageItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 세일리지 아이템 ("68", "68")
     * 
     * @return
     */
    public int parseTranSSGConItem(int itemLength){
        int ret = -1;

        try{
            TranSSGConItem tranSSGConItem = new TranSSGConItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranSSGConItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_SSGConItem().add(tranSSGConItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 모바일&신세계MMS ITEM ("74", "74")
     * 
     * @return
     */
    public int parseTranMobileMmsItem(int itemLength){
        int ret = -1;

        try{
            TranMobileMmsItem tranMobileMmsItem = new TranMobileMmsItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranMobileMmsItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_MobileMmsItem().add(tranMobileMmsItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 모바일&신세계MMS ITEM ("78", "78")
     * 
     * @return
     */
    public int parseTranShinBaekRewardItem(int itemLength){
        int ret = -1;

        try{
            TranShinBaekRewardItem tranShinBaekRewardItem = new TranShinBaekRewardItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranShinBaekRewardItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_ShinBaekRewardItem().add(tranShinBaekRewardItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 리워드(쿠폰) 아이템 ("79", "79")
     * 
     * @return
     */
    public int parseTranShinBaekRewardCouponItem(int itemLength){
        int ret = -1;

        try{
            TranShinBaekRewardCouponItem tranShinBaekRewardCouponItem = new TranShinBaekRewardCouponItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranShinBaekRewardCouponItem, 0, 0, false,
                    false);

            if(ret == 0){
                compTranData.getTran_ShinBaekRewardCouponItem().add(tranShinBaekRewardCouponItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 리워드(쿠폰) 아이템 ("81", "81")
     * 
     * @return
     */
    public int parseTranGiftKioskCommItem(int itemLength){
        int ret = -1;

        try{
            TranGiftKioskCommItem tranGiftKioskCommItem = new TranGiftKioskCommItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranGiftKioskCommItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_GiftKioskCommItem().add(tranGiftKioskCommItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 리워드(쿠폰) 아이템 ("82", "82")
     * 
     * @return
     */
    public int parseTranGiftKioskErrorItem(int itemLength){
        int ret = -1;

        try{
            TranGiftKioskErrorItem tranGiftKioskErrorItem = new TranGiftKioskErrorItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranGiftKioskErrorItem, itemLength,
                    EnmTranItemCodeWrap.Tran_GiftKioskErrorItem.getItemCodeLen_O_exLoopLen(), false, true);

            if(ret == 0){
                compTranData.getTran_GiftKioskErrorItem().add(tranGiftKioskErrorItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 상품권 판매 키오스크 개국발생 ("83", "83")
     * 
     * @return
     */
    public int parseTranGiftKioskStartItem(int itemLength){
        int ret = -1;

        try{
            TranGiftKioskStartItem tranGiftKioskStartItem = new TranGiftKioskStartItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranGiftKioskStartItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_GiftKioskStartItem().add(tranGiftKioskStartItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 상품권 판매 키오스크 시재장입및회수 ("84", "84")
     * 
     * @return
     */
    public int parseTranGiftKioskInOutItem(int itemLength){
        int ret = -1;

        try{
            TranGiftKioskInOutItem tranGiftKioskInOutItem = new TranGiftKioskInOutItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranGiftKioskInOutItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_GiftKioskInOutItem().add(tranGiftKioskInOutItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 상품권 판매 키오스크 정산기시재 ("86", "86")
     * 
     * @return
     */
    public int parseTranGiftKioskCalcItem(int itemLength){
        int ret = -1;

        try{
            TranGiftKioskCalcItem tranGiftKioskCalcItem = new TranGiftKioskCalcItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranGiftKioskCalcItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_GiftKioskCalcItem().add(tranGiftKioskCalcItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 상품권 판매 키오스크 상품권일련번호 ("89", "89")
     * 
     * @return
     */
    public int parseTranGiftKioskGiftSeqItem(int itemLength){
        int ret = -1;

        try{
            TranGiftKioskGiftSeqItem tranGiftKioskGiftSeqItem = new TranGiftKioskGiftSeqItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranGiftKioskGiftSeqItem, itemLength,
                    EnmTranItemCodeWrap.Tran_GiftKioskErrorItem.getItemCodeLen_O_exLoopLen(), false, true);

            if(ret == 0){
                compTranData.getTran_GiftKioskGiftSeqItem().add(tranGiftKioskGiftSeqItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 정산시재금 아이템 ("99", "99")
     * 
     * @param itemLengthN
     * @return
     */
    public int parseTranCalcItem(int itemLength){
        int ret = -1;

        try{
            TranCalcItem tranCalcItem = new TranCalcItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranCalcItem, itemLength,
                    EnmTranItemCodeWrap.Tran_CalcItem.getItemCodeLen_O_exLoopLen(), false, true);

            if(ret == 0){
                compTranData.getTran_CalcItem().add(tranCalcItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    // ----------------------- < 변경 >
    /**
     * 현금성 아이템 ("11", "11")
     * 
     * @return
     */
    public int parseTranCashItem(int itemLength){
        int ret = -1;

        try{
            TranCashItemN tranCashItem_N = new TranCashItemN();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranCashItem_N, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_CashItem().add(tranCashItem_N);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 외상거래 아이템 ("62", "62")
     * 
     * @return
     */
    public int parseTranDepositItem(int itemLength, String sTranInfo){
        int ret = -1;

        try{
            TranDepositItem tranDepositItem = new TranDepositItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranDepositItem, 0, 0, false, false);

            if(ret == 0){
                // 구분 : 02:사용매출, 11:특판, 12:점특판TF 일경우 외상 거래 만들지 않고 TO-BE 사용매출
                // 특판(점포,법인) (E6 TO-BE신규) 거래 생성
                String tranType = tranDepositItem.getTranType(); // 구분

                if(tranType != null && ("02".equals(tranType) || "11".equals(tranType) || "12".equals(tranType))){
                    // "","E6","사용매출특판(점포,법인)"
                    TranUseSaleSpecialItemC tranUseSaleSpecialItemC = new TranUseSaleSpecialItemC();

                    if("02".equals(tranType)){
                        log.info("외상거래 아이템 -- 사용매출(02->10) --> 사용매출 거래 신규 생성");
                        // ITEM코드
                        tranUseSaleSpecialItemC
                                .setItemCode(EnmTranItemCodeWrap.Tran_UseSaleSpecialItem.getItemCode_N());

                        // ITEM길이
                        int itemLen = ParseHelper.tranTotalSize(TranUseSaleSpecialItemC.class);
                        tranUseSaleSpecialItemC.setItemLength(ParseHelper
                                .getLpadFillZeroStringForNewTran(tranUseSaleSpecialItemC, "ItemLength", itemLen));

                        // 매출구분
                        // 02:사용매출-->10:사용매출, 11:특판-->30:법인(점),
                        // 12:점특판TF-->20:점(T/F)
                        String itemType = "10";
                        tranUseSaleSpecialItemC.setItemType(itemType);

                        // 사원번호
                        tranUseSaleSpecialItemC.setEmpNo(tranDepositItem.getEmpNo());

                        // 전표번호
                        // 전표번호 생성을 위한 TOBE 회계단위 조회
                        String slipNo = "";
                        String apvlAplyYm = ""; // 승인신청연월
                        String apvlAplySno = ""; // 승인신청일련번호

                        Map<String, Object> paramMap = new HashMap<>();
                        String cmmnCdRfrValAsIs = ""; // ASIS 회계단위
                        String cmmnCdRfrValToBe = ""; // TOBE 회계단위
                        cmmnCdRfrValAsIs = tranDepositItem.getSlipNo();
                        log.info("전표번호 : [{}]", cmmnCdRfrValAsIs);

                        if(cmmnCdRfrValAsIs != null){
                            apvlAplyYm = cmmnCdRfrValAsIs.substring(3, 8);

                            cmmnCdRfrValAsIs = cmmnCdRfrValAsIs.substring(0, 3);
                            paramMap.put("cmmnCdRfrVal", cmmnCdRfrValAsIs);
                            log.info("ASIS 회계단위 :[{}]", cmmnCdRfrValAsIs);

                            nDebugFlag = 3;
                            cmmnCdRfrValToBe = queryProc.selectDepositItemCmmnCdRfrVal(paramMap, sTranInfo,
                                    logParamMap);
                            nDebugFlag = 0;
                            log.info("TOBE 회계단위 :[{}]", cmmnCdRfrValToBe);

                            apvlAplySno = tranDepositItem.getDeposit();
                            if(apvlAplySno != null){
                                apvlAplyYm = apvlAplyYm + apvlAplySno.substring(0, 1);
                                apvlAplySno = apvlAplySno.substring(1, 6);
                                apvlAplySno = ParseHelper.getLpadFillZeroString(apvlAplySno, 4);

                                slipNo = cmmnCdRfrValToBe + apvlAplyYm + apvlAplySno;
                            }
                        }
                        tranUseSaleSpecialItemC.setSlipNo(ParseHelper
                                .getRpadFillSpaceStringForNewTran(tranUseSaleSpecialItemC, "SlipNo", slipNo));
                        log.info("외상거래 아이템(62) --> 사용매출 거래 생성 -- aplyBizRelmCd:[{}], apvlAplyYm:[{}], apvlAplySno:[{}]",
                                cmmnCdRfrValToBe, apvlAplyYm, apvlAplySno);

                        // 매장코드
                        // 전표번호로 매장코드 조회
                        String shopCode = "";
                        paramMap.clear();
                        paramMap.put("aplyBizRelmCd", cmmnCdRfrValToBe);
                        paramMap.put("apvlAplyYm", apvlAplyYm);
                        paramMap.put("apvlAplySno", apvlAplySno);

                        nDebugFlag = 3;
                        shopCode = queryProc.selectDepositItemShopCode(paramMap, sTranInfo, logParamMap);
                        nDebugFlag = 0;

                        tranUseSaleSpecialItemC.setShopCode(ParseHelper
                                .getRpadFillSpaceStringForNewTran(tranUseSaleSpecialItemC, "ShopCode", shopCode));

                        // 판매금액 (잔액을 입력)
                        tranUseSaleSpecialItemC.setAmount(ParseHelper.getLpadFillZeroStringForNewTran(
                                tranUseSaleSpecialItemC, "Amount", tranDepositItem.getBalance().trim()));

                        // 예비
                        tranUseSaleSpecialItemC.setFiller(
                                ParseHelper.getLpadFillSpaceStringForNewTran(tranUseSaleSpecialItemC, "Filler", ""));
                    }
                    // 11:특판, 12:점특판TF
                    else{
                        // ITEM코드
                        tranUseSaleSpecialItemC
                                .setItemCode(EnmTranItemCodeWrap.Tran_UseSaleSpecialItem.getItemCode_N());

                        // ITEM길이
                        int itemLen = ParseHelper.tranTotalSize(TranUseSaleSpecialItemC.class);
                        tranUseSaleSpecialItemC.setItemLength(ParseHelper
                                .getLpadFillZeroStringForNewTran(tranUseSaleSpecialItemC, "ItemLength", itemLen));

                        // 매출구분
                        // 02:사용매출-->10:사용매출, 11:특판-->30:법인(점),
                        // 12:점특판TF-->20:점(T/F)
                        // 법인특판 매출의 경우는 그냥 "포스번호+거래번호" 8 자리로
                        String itemType = "";
                        if("11".equals(tranType)){
                            itemType = "30";
                            log.info("외상거래 아이템 -- 법인특판(11->30) --> 사용매출 거래 신규 생성");
                        }else if("12".equals(tranType)){
                            itemType = "20";
                            log.info("외상거래 아이템 -- 점특판TF(12->20) --> 사용매출 거래 신규 생성");
                        }
                        tranUseSaleSpecialItemC.setItemType(itemType);

                        // 사원번호
                        tranUseSaleSpecialItemC.setEmpNo(tranDepositItem.getEmpNo());

                        // 전표번호
                        // TOBE 회계단위(4) + 영업일(6) + max()+1(4)
                        // tranGoodsItemBizRelmCd +
                        // compTranData.getTran_Header_O().getSaleDate().substring(0,
                        // 6) + max 조회
                        String slipNo = "";
                        String apvlAplyYm = compTranData.getTran_Header_O().getSaleDate().substring(0, 6);

                        if("12".equals(tranType)){
                            Map<String, Object> paramMap = new HashMap<>();
                            paramMap.put("aplyBizRelmCd", tranGoodsItemBizRelmCd);
                            paramMap.put("apvlAplyYm", apvlAplyYm);

                            // nDebugFlag = 3;
                            int nApvlAplySno = 0;
                            String apvlAplySno = idGeneratorFactory.generateNextId("usgSalsApvlAplySno");
                            if(apvlAplySno == null){
                                apvlAplySno = "";
                                log.error("외상거래 아이템 -- 시퀀스 채번 오류 발생!!");
                            }else{
                                nApvlAplySno = ParseHelper.convStrToInt(apvlAplySno);
                                log.info("redis generateNextId : [{}]", nApvlAplySno);
                            }
                            apvlAplySno = ParseHelper.getLpadFillZeroString(nApvlAplySno, 4);

                            // apvlAplySno =
                            // queryProc.selectDepositItemApvlAplySno(paramMap,
                            // sTranInfo, logParamMap);

                            log.info("apvlAplySno(조회) : [{}]", apvlAplySno);
                            if(apvlAplySno == null || apvlAplySno.length() == 0)
                                apvlAplySno = ParseHelper.getLpadFillZeroString(apvlAplySno, 4);
                            // nDebugFlag = 0;
                            slipNo = tranGoodsItemBizRelmCd + apvlAplyYm + apvlAplySno;
                        }else{
                            slipNo = compTranData.getTran_Header_O().getPosNo()
                                    + compTranData.getTran_Header_O().getTranNo();
                        }

                        tranUseSaleSpecialItemC.setSlipNo(ParseHelper
                                .getRpadFillSpaceStringForNewTran(tranUseSaleSpecialItemC, "SlipNo", slipNo));
                        log.info("전표번호 : [{}]", slipNo);

                        // 매장코드
                        tranUseSaleSpecialItemC.setShopCode(ParseHelper.getRpadFillSpaceStringForNewTran(
                                tranUseSaleSpecialItemC, "ShopCode", tranGoodsItemShopCd));
                        log.info("매장코드 : [{}]", tranUseSaleSpecialItemC.getShopCode());

                        // 판매금액 (잔액을 입력)
                        tranUseSaleSpecialItemC.setAmount(ParseHelper.getLpadFillZeroStringForNewTran(
                                tranUseSaleSpecialItemC, "Amount", tranDepositItem.getBalance().trim()));

                        // 예비
                        tranUseSaleSpecialItemC.setFiller(
                                ParseHelper.getLpadFillSpaceStringForNewTran(tranUseSaleSpecialItemC, "Filler", ""));
                    }
                    compTranData.getTran_UseSaleSpecialItem().add(tranUseSaleSpecialItemC);
                }else
                    compTranData.getTran_DepositItem().add(tranDepositItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 상품정보 아이템 ("61", "B0")
     * 
     * @return
     */
    public int parseTranGoodsItem(int itemLength, String sTranInfo, int nGoodsItemItemSeq){
        int ret = -1;

        try{
            // 구 트란 파싱
            TranGoodsItemO tranGoodsItemO = new TranGoodsItemO();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranGoodsItemO, 0, 0, false, false);

            // 신 트란 생성
            TranGoodsItemN tranGoodsItemN = new TranGoodsItemN();

            // 신 트란 아이템코드
            tranGoodsItemN.setItemCode(EnmTranItemCodeWrap.Tran_GoodsItem.getItemCode_N());
            // 신 트란 아이템길이
            tranGoodsItemN.setItemLength(String.format("%04d", EnmTranItemCodeWrap.Tran_GoodsItem.getItemCodeLen_N()));

            tranGoodsItemN.setMdCode(tranGoodsItemO.getMdCode());
            tranGoodsItemN.setClassCode(tranGoodsItemO.getClassCode());
            tranGoodsItemN.setEventCode(tranGoodsItemO.getEventCode());

            // 품목단축(4->6)
            Map<String, Object> paramMap = new HashMap<>();
            String pluType = tranGoodsItemO.getPluType();
            paramMap.put("pluType", pluType);
            paramMap.put("mdCode", tranGoodsItemO.getMdCode());
            paramMap.put("classCode", tranGoodsItemO.getClassCode());
            paramMap.put("categoryCode", tranGoodsItemO.getCategoryCode());
            paramMap.put("pluCode", tranGoodsItemO.getPluCode());

            nDebugFlag = 3;
            tranGoodsItemN.setCategoryCode(queryProc.selectGoodsItemCategoryCode(paramMap, sTranInfo, logParamMap));
            nDebugFlag = 0;

            tranGoodsItemN.setCouponFlag(tranGoodsItemO.getCouponFlag());
            tranGoodsItemN.setPluCode(tranGoodsItemO.getPluCode());
            tranGoodsItemN.setCouponCode(tranGoodsItemO.getCouponCode());
            tranGoodsItemN.setPluType(tranGoodsItemO.getPluType());
            tranGoodsItemN.setProdFlag(tranGoodsItemO.getProdFlag());

            // 마진(4->5)
            tranGoodsItemN.setMargin(
                    ParseHelper.getLpadFillZeroStringForNewTran(tranGoodsItemN, "Margin", tranGoodsItemO.getMargin()));

            tranGoodsItemN.setOldPrice(tranGoodsItemO.getOldPrice());
            tranGoodsItemN.setChangePrice(tranGoodsItemO.getChangePrice());
            tranGoodsItemN.setCouponPrice(tranGoodsItemO.getCouponPrice());
            tranGoodsItemN.setEventSaleFlag(tranGoodsItemO.getEventSaleFlag());
            tranGoodsItemN.setEventSaleRate(tranGoodsItemO.getEventSaleRate());
            tranGoodsItemN.setEventSaleAmount(tranGoodsItemO.getEventSaleAmount());
            tranGoodsItemN.setPrice(tranGoodsItemO.getPrice());
            tranGoodsItemN.setQty(tranGoodsItemO.getQty());
            tranGoodsItemN.setAmount(tranGoodsItemO.getAmount());
            tranGoodsItemN.setDiscountFlag(tranGoodsItemO.getDiscountFlag());
            tranGoodsItemN.setDiscountRate(tranGoodsItemO.getDiscountRate());
            tranGoodsItemN.setDiscountAmount(tranGoodsItemO.getDiscountAmount());
            tranGoodsItemN.setNetAmount(tranGoodsItemO.getNetAmount());
            tranGoodsItemN.setTaxFlag(tranGoodsItemO.getTaxFlag());
            tranGoodsItemN.setDeliveryFlag(tranGoodsItemO.getDeliveryFlag());
            tranGoodsItemN.setCancelFlag(tranGoodsItemO.getCancelFlag());
            tranGoodsItemN.setOrgSaleDate(tranGoodsItemO.getOrgSaleDate());
            tranGoodsItemN.setSaleUnit(tranGoodsItemO.getSaleUnit());
            tranGoodsItemN.setUnitPrice(tranGoodsItemO.getUnitPrice());

            // 바코드스캔코드1(20->30) 20자리 미안은 뒤에 스페이스
            tranGoodsItemN.setScanCode1(ParseHelper.getRpadFillSpaceStringForNewTran(tranGoodsItemN, "ScanCode1",
                    tranGoodsItemO.getScanCode1()));
            // 바코드스캔코드2(20->30) 20자리 미안은 뒤에 스페이스
            tranGoodsItemN.setScanCode2(ParseHelper.getRpadFillSpaceStringForNewTran(tranGoodsItemN, "ScanCode2",
                    tranGoodsItemO.getScanCode2()));

            tranGoodsItemN.setPriceManualFlag(tranGoodsItemO.getPriceManualFlag());
            tranGoodsItemN.setMdTypeCode(tranGoodsItemO.getMdTypeCode());

            // 아이템 SEQ (새롭게 만들어 준다)
            // 반품일 경우에는 원거래 시퀀스로 넣어 준다
            String sOrgItemSeq = "", sNewItemSeq = "";
            sNewItemSeq = ParseHelper.getLpadFillZeroString(nGoodsItemItemSeq, 3);

            if("1".equals(compTranData.getTran_Header_O().getTranType())
                    || "2".equals(compTranData.getTran_Header_O().getTranType())){
                sOrgItemSeq = tranGoodsItemO.getItemSeq();
                tranGoodsItemN.setItemSeq(sOrgItemSeq);
            }else{
                tranGoodsItemN.setItemSeq(sNewItemSeq);
            }

            tranGoodsItemN.setIsFreebie(tranGoodsItemO.getIsFreebie());
            tranGoodsItemN.setChicorTranSeq(tranGoodsItemO.getChicorTranSeq());
            tranGoodsItemN.setLinkCode(tranGoodsItemO.getLinkCode());
            tranGoodsItemN.setCareLabel(tranGoodsItemO.getCareLabel());
            tranGoodsItemN.setIsCareLabel(tranGoodsItemO.getIsCareLabel());
            tranGoodsItemN.setBrandPluFlag(tranGoodsItemO.getBrandPluFlag());
            tranGoodsItemN.setBrandPluSet(tranGoodsItemO.getBrandPluSet());
            tranGoodsItemN.setPriceChangeReason(tranGoodsItemO.getPriceChangeReason());
            tranGoodsItemN.setHolidayDeliveryFlag(tranGoodsItemO.getHolidayDeliveryFlag());
            tranGoodsItemN.setDeliveryProductCnt(ParseHelper.getLpadFillZeroStringForNewTran(tranGoodsItemN,
                    "DeliveryProductCnt", tranGoodsItemO.getDeliveryProductCnt()));
            tranGoodsItemN.setWillCallProductCnt(tranGoodsItemO.getWillCallProductCnt());
            tranGoodsItemN.setFoodMembershipFlag(tranGoodsItemO.getFoodMembershipFlag());
            tranGoodsItemN.setChicorEnuriYn(tranGoodsItemO.getChicorEnuri_Yn());
            tranGoodsItemN.setDMSEnuriAmt(tranGoodsItemO.getEnuriAmt());
            tranGoodsItemN.setChicorEnuriAmt(tranGoodsItemO.getChicorEnuriAmt());

            // 주문번호
            // 'O' || STR_CD || SALS_YMD || POS_NO || DLNG_NO ||
            // POS_PDCT_REG_ORR -- POS상품등록순서
            String OrderNo = "O" + compTranData.getTran_Header_O().getStoreNo()
                    + compTranData.getTran_Header_O().getSaleDate() + compTranData.getTran_Header_O().getPosNo()
                    + compTranData.getTran_Header_O().getTranNo() + sNewItemSeq;
            tranGoodsItemN.setOrderNo(ParseHelper.getLpadFillSpaceStringForNewTran(tranGoodsItemN, "OrderNo", OrderNo));

            log.info("주문번호 : {}", OrderNo);

            // 배송요청구분코드
            // As-Is는 즉시인도로 처리 : '0' : 즉시
            tranGoodsItemN
                    .setSaleTakeType(ParseHelper.getLpadFillSpaceStringForNewTran(tranGoodsItemN, "SaleTakeType", "0"));

            // 매장코드, 사업영역코드 조회
            paramMap.clear();
            paramMap.put("storeNo", compTranData.getTran_Header_O().getStoreNo());
            paramMap.put("mdCode", tranGoodsItemO.getMdCode());
            nDebugFlag = 3;
            Map<String, String> retMap = queryProc.selectGoodsItemShopCdBizRelmCd(paramMap, sTranInfo, logParamMap);
            String shopCode = "", bizCopeCode = "";
            if(retMap != null){
                shopCode = retMap.get("shopCd");
                bizCopeCode = retMap.get("bizRelmCd");

                // 외상매출 거래시 사용매출 만들때 사용
                if(shopCode != null)
                    tranGoodsItemShopCd = shopCode;
                if(bizCopeCode != null)
                    tranGoodsItemBizRelmCd = bizCopeCode;
            }
            tranGoodsItemN.setShopCode(shopCode);
            nDebugFlag = 0;

            // 배송요청 상품수
            // '0'
            tranGoodsItemN.setDelReqPrdtCnt(
                    ParseHelper.getRpadFillSpaceStringForNewTran(tranGoodsItemN, "DelReqPrdtCnt", "0"));
            // 즉시인도 상품수
            // 총 주문수량, AS-IS 상품아이템(61) 의 WillCallProductCnt(현장수령 상품 수), 명절 배송 상품
            // 중 현장수령(TO-BE 즉시인도) 상품 수량
            // QTY 로 대입 : 20240214 경승현 상무
            tranGoodsItemN.setNowReqPrdtCnt(ParseHelper.getLpadFillZeroStringForNewTran(tranGoodsItemN, "NowReqPrdtCnt",
                    tranGoodsItemO.getQty()));
            // 현장인도 상품수
            // '0'
            tranGoodsItemN.setLaterReqPrdCnt(
                    ParseHelper.getLpadFillZeroStringForNewTran(tranGoodsItemN, "LaterReqPrdCnt", "0"));

            // 사업영역코드
            tranGoodsItemN.setBizCopeCode(bizCopeCode);

            // 손익센터코드
            paramMap.clear();
            paramMap.put("mdCode", tranGoodsItemO.getMdCode());
            nDebugFlag = 3;
            tranGoodsItemN.setProfitCenterCode(ParseHelper.getRpadFillSpaceStringForNewTran(tranGoodsItemN,
                    "ProfitCenterCode", queryProc.selectGoodsItemProfitCenterCode(paramMap, sTranInfo, logParamMap)));
            nDebugFlag = 0;

            // 상품브랜드코드
            // 단품구분코드(0:통합코드, 1:단축, 2:단품)가 단품이 아닐경우는 스페이스 패딩 처리
            paramMap.clear();
            paramMap.put("pluCode", tranGoodsItemO.getPluCode());

            String prdtBrandCode = "";
            if(pluType != null){
                // 단품일 경우만 상품브랜드코드 조회
                if("2".equals(pluType)){
                    nDebugFlag = 3;
                    prdtBrandCode = queryProc.selectGoodsItemPrdtBrandCode(paramMap, sTranInfo, logParamMap);
                    nDebugFlag = 0;
                }
            }
            tranGoodsItemN.setPrdtBrandCode(
                    ParseHelper.getLpadFillSpaceStringForNewTran(tranGoodsItemN, "PrdtBrandCode", prdtBrandCode));

            // 행사코드
            // 쿼리로 조회 (PR_SHOP_PIPD_PRC : PR_매장단품가격)
            String eventApplyCode = "00000000"; // 행사코드 없을 시 디폴트 값
            if(pluType != null){
                // 단품일 경우만 조회
                if("2".equals(pluType)){
                    paramMap.clear();
                    paramMap.put("strCd", compTranData.getTran_Header_O().getStoreNo());
                    paramMap.put("shopCd", shopCode);
                    paramMap.put("pipdCd", tranGoodsItemO.getPluCode());
                    paramMap.put("prcBgnYmd", compTranData.getTran_Header_O().getSaleDate());

                    nDebugFlag = 3;
                    eventApplyCode = queryProc.selectGoodsItemEvnCd(paramMap, sTranInfo, logParamMap);
                    nDebugFlag = 0;
                }
            }
            tranGoodsItemN.setEventApplyCode(
                    ParseHelper.getRpadFillSpaceStringForNewTran(tranGoodsItemN, "EventApplyCode", eventApplyCode));

            // 원거래주문번호
            // 반품일 경우만 해당하며 원거래 정보를 가지고 조회 한다
            String OrgOrderNo = "";
            if("1".equals(compTranData.getTran_Header_O().getTranType())
                    || "2".equals(compTranData.getTran_Header_O().getTranType())){
                OrgOrderNo = "O" + compTranData.getTran_Header_O().getStoreNo().trim()
                        + compTranData.getTran_Header_O().getOrgTranDate()
                        + compTranData.getTran_Header_O().getOrgPosNo().trim()
                        + compTranData.getTran_Header_O().getOrgTranNo() + sOrgItemSeq;

                // paramMap.clear();
                // paramMap.put("saleDate",
                // compTranData.getTran_Header_O().getOrgTranDate());
                // paramMap.put("storeNo",
                // compTranData.getTran_Header_O().getStoreNo());
                // paramMap.put("posNo",
                // compTranData.getTran_Header_O().getOrgPosNo());
                // paramMap.put("tranNo",
                // compTranData.getTran_Header_O().getOrgTranNo());
                // paramMap.put("itemSeq", sOrgItemSeq);
                // nDebugFlag = 3;
                // OrgOrderNo = queryProc.selectGoodsItemOrgOrderNo(paramMap,
                // sTranInfo, logParamMap);
                // nDebugFlag = 0;
            }
            log.info("원거래주문번호 : {}", OrgOrderNo);
            tranGoodsItemN.setOrgOrderNo(
                    ParseHelper.getRpadFillSpaceStringForNewTran(tranGoodsItemN, "OrgOrderNo", OrgOrderNo));

            // 행사관리연월
            // 행사관리번호
            paramMap.clear();
            // 반품일 경우 원거래 정보로 조회
            if("1".equals(compTranData.getTran_Header_O().getTranType())
                    || "2".equals(compTranData.getTran_Header_O().getTranType())){
                paramMap.put("otrsSalsYmd", compTranData.getTran_Header_O().getOrgTranDate());
                paramMap.put("saleDate", compTranData.getTran_Header_O().getOrgTranDate());
                paramMap.put("posNo", compTranData.getTran_Header_O().getOrgPosNo());
                paramMap.put("tranNo", compTranData.getTran_Header_O().getOrgTranNo());
            }else{
                paramMap.put("otrsSalsYmd", compTranData.getTran_Header_O().getSaleDate());
                paramMap.put("saleDate", compTranData.getTran_Header_O().getSaleDate());
                paramMap.put("posNo", compTranData.getTran_Header_O().getPosNo());
                paramMap.put("tranNo", compTranData.getTran_Header_O().getTranNo());
            }
            paramMap.put("storeNo", compTranData.getTran_Header_O().getStoreNo());
            paramMap.put("evnDvsCd", tranGoodsItemO.getEventCode());
            paramMap.put("dcSlrt", tranGoodsItemO.getEventSaleRate());
            paramMap.put("mdCd", tranGoodsItemO.getMdCode());
            paramMap.put("pipdCd", tranGoodsItemO.getPluCode());

            nDebugFlag = 3;
            String evnId = queryProc.selectGoodsItemEventMngYMEventMngNo(paramMap, sTranInfo, logParamMap);
            String eventMngYm = "", eventMngNo = "";
            if(evnId != null && evnId.length() == 15){
                log.info("evnId(조회) : [{}], len : {}", evnId, evnId.length());

                eventMngYm = evnId.substring(0, 6);
                eventMngNo = evnId.substring(6, 15);
            }
            nDebugFlag = 0;

            log.info("행사관리연월(조회) : [{}]", eventMngYm);
            log.info("행사관리번호(조회) : [{}]", eventMngNo);

            tranGoodsItemN.setEventMngYM(
                    ParseHelper.getLpadFillSpaceStringForNewTran(tranGoodsItemN, "EventMngYM", eventMngYm));

            tranGoodsItemN.setEventMngNo(
                    ParseHelper.getLpadFillSpaceStringForNewTran(tranGoodsItemN, "EventMngNo", eventMngNo));

            // 운영방식코드
            // 일단 "0"을 Default 값으로 처리
            // 이슈 예상: 차세대 매출정산에서는 1매장 1MD코드 체계로 되어 있으므로, 점포공용MD라는 것을 수용할 수 없는
            // 구조임
            tranGoodsItemN.setMdOperCode("0");

            // 상품 예비
            tranGoodsItemN.setFiller(ParseHelper.getLpadFillSpaceStringForNewTran(tranGoodsItemN, "Filler", ""));

            if(ret == 0){
                compTranData.getTran_GoodsItem().add(tranGoodsItemN);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 시코르 증정/SET 아이템 ("70", "B2")
     * 
     * @return
     */
    public int parseTranCCFreeSetItem(int itemLength, String sTranInfo){
        int ret = -1;

        try{
            // 구 트란 파싱
            TranCCFreeSetItemO tranCCFreeSetItemO = new TranCCFreeSetItemO();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranCCFreeSetItemO, 0, 0, false, false);

            // 신 트란 생성
            TranCCFreeSetItemN tranCCFreeSetItemN = new TranCCFreeSetItemN();

            // 신 트란 아이템코드
            tranCCFreeSetItemN.setItemCode(EnmTranItemCodeWrap.Tran_CCFreeSetItem.getItemCode_N());
            // 신 트란 아이템길이
            tranCCFreeSetItemN
                    .setItemLength(String.format("%04d", EnmTranItemCodeWrap.Tran_CCFreeSetItem.getItemCodeLen_N()));

            tranCCFreeSetItemN.setSeq(tranCCFreeSetItemO.getSeq());
            tranCCFreeSetItemN.setGnrCode(tranCCFreeSetItemO.getGnrCode());
            tranCCFreeSetItemN.setPluType(tranCCFreeSetItemO.getPluType());

            // 신규 : 매장코드
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("storeNo", compTranData.getTran_Header_O().getStoreNo());
            paramMap.put("pluCode", tranCCFreeSetItemO.getPluCode());
            nDebugFlag = 3;
            tranCCFreeSetItemN.setShopCode(queryProc.selectCCFreeSetItemShopCode(paramMap, sTranInfo, logParamMap));
            nDebugFlag = 0;

            tranCCFreeSetItemN.setPluCode(tranCCFreeSetItemO.getPluCode());
            tranCCFreeSetItemN.setPluQty(tranCCFreeSetItemO.getPluQty());

            // 판매금액(9->15)
            tranCCFreeSetItemN.setAmount(ParseHelper.getLpadFillZeroStringForNewTran(tranCCFreeSetItemN, "Amount",
                    tranCCFreeSetItemO.getAmount()));

            tranCCFreeSetItemN.setPrsEventMon(tranCCFreeSetItemO.getPrsEventMon());

            // 증정순번(5->9)
            tranCCFreeSetItemN.setPrsSeqNo(ParseHelper.getLpadFillZeroStringForNewTran(tranCCFreeSetItemN, "PrsSeqNo",
                    tranCCFreeSetItemO.getPrsSeqNo()));

            tranCCFreeSetItemN.setFiller(tranCCFreeSetItemO.getFiller());

            if(ret == 0){
                compTranData.getTran_CCFreeSetItem().add(tranCCFreeSetItemN);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 캐시터미널 E-Accounting 결재출금 ("75", "C0")
     * 
     * @return
     */
    public int parseTranCashTerExpenItem(int itemLength){
        int ret = -1;

        try{
            // 구 트란 파싱
            TranCashTerExpenItemO tranCashTerExpenItemO = new TranCashTerExpenItemO();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranCashTerExpenItemO, 0, 0, false, false);

            // 신 트란 생성
            TranCashTerExpenItemN tranCashTerExpenItemN = new TranCashTerExpenItemN();

            // 신 트란 아이템코드
            tranCashTerExpenItemN.setItemCode(EnmTranItemCodeWrap.Tran_CashTerExpenItem.getItemCode_N());
            // 신 트란 아이템길이
            tranCashTerExpenItemN
                    .setItemLength(String.format("%04d", EnmTranItemCodeWrap.Tran_CashTerExpenItem.getItemCodeLen_N()));

            // 비용신청문서유형코드
            tranCashTerExpenItemN.setExpsAplyDocTpCode(
                    ParseHelper.getLpadFillSpaceStringForNewTran(tranCashTerExpenItemN, "ExpsAplyDocTpCode", ""));

            // 비용신청문서번호
            tranCashTerExpenItemN.setExpsAplyDocNo(
                    ParseHelper.getLpadFillSpaceStringForNewTran(tranCashTerExpenItemN, "ExpsAplyDocNo", ""));

            // 비용신청문서번호일련번호
            tranCashTerExpenItemN.setExpsAplyDocNoSno(
                    ParseHelper.getLpadFillSpaceStringForNewTran(tranCashTerExpenItemN, "ExpsAplyDocNoSno", ""));

            // 품목일련번호
            tranCashTerExpenItemN
                    .setPdimSno(ParseHelper.getLpadFillSpaceStringForNewTran(tranCashTerExpenItemN, "PdimSno", ""));

            // 비용출금금액
            tranCashTerExpenItemN.setExpsWdlAmt(
                    ParseHelper.getLpadFillSpaceStringForNewTran(tranCashTerExpenItemN, "ExpsWdlAmt", ""));

            // 예비
            tranCashTerExpenItemN
                    .setFiller(ParseHelper.getLpadFillSpaceStringForNewTran(tranCashTerExpenItemN, "Filler", ""));

            if(ret == 0){
                compTranData.getTran_CashTerExpenItem().add(tranCashTerExpenItemN);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 캐쉬터미널 연동 POS 입출금 거래 금액 정보 아이템 ("51", "C1")
     * 
     * @return
     */
    public int parseTranCashTerAmtItem_DX(int itemLength, String sTranInfo){
        int ret = -1;

        try{
            // 구 트란 파싱
            TranCashTerAmtItemDxO tranCashTerAmtItemDXO = new TranCashTerAmtItemDxO();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranCashTerAmtItemDXO, 0, 0, false, false);

            // 신 트란 생성
            TranCashTerAmtItemDxN tranCashTerAmtItemDXN = new TranCashTerAmtItemDxN();

            // 신 트란 아이템코드
            tranCashTerAmtItemDXN.setItemCode(EnmTranItemCodeWrap.Tran_CashTerAmtItem_DX.getItemCode_N());
            // 신 트란 아이템길이
            tranCashTerAmtItemDXN.setItemLength(
                    String.format("%04d", EnmTranItemCodeWrap.Tran_CashTerAmtItem_DX.getItemCodeLen_N()));

            tranCashTerAmtItemDXN.setSaleDate(tranCashTerAmtItemDXO.getSaleDate());
            tranCashTerAmtItemDXN.setStoreCode(tranCashTerAmtItemDXO.getStoreCode());
            tranCashTerAmtItemDXN.setPosNo(tranCashTerAmtItemDXO.getPosNo());
            tranCashTerAmtItemDXN.setTranNo(tranCashTerAmtItemDXO.getTranNo());
            tranCashTerAmtItemDXN.setCashierNo(tranCashTerAmtItemDXO.getCashierNo());
            tranCashTerAmtItemDXN.setProdCode(tranCashTerAmtItemDXO.getProdCode());

            // 매장코드
            String prodCode = tranCashTerAmtItemDXO.getProdCode().trim();

            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("storeNo", compTranData.getTran_Header_O().getStoreNo());
            paramMap.put("prodCode", prodCode);

            // 통합상품코드 여부 체크
            if(prodCode.length() == 16)
                paramMap.put("pluType", "0");
            else
                paramMap.put("pluType", "2");

            nDebugFlag = 3;
            tranCashTerAmtItemDXN
                    .setShopCd(queryProc.selectTranCashTerAmtItemDXShopCd(paramMap, sTranInfo, logParamMap));
            nDebugFlag = 0;

            tranCashTerAmtItemDXN.setTotalAmount(tranCashTerAmtItemDXO.getTotalAmount());
            tranCashTerAmtItemDXN.setInCashAmount(tranCashTerAmtItemDXO.getInCashAmount());
            tranCashTerAmtItemDXN.setOutCashAmount(tranCashTerAmtItemDXO.getOutCashAmount());
            tranCashTerAmtItemDXN.setInGiftAmount(tranCashTerAmtItemDXO.getInGiftAmount());
            tranCashTerAmtItemDXN.setOutGiftAmount(tranCashTerAmtItemDXO.getOutGiftAmount());
            tranCashTerAmtItemDXN.setInEtcGiftAmount(tranCashTerAmtItemDXO.getInEtcGiftAmount());
            tranCashTerAmtItemDXN.setInTourGiftAmount(tranCashTerAmtItemDXO.getInTourGiftAmount());
            tranCashTerAmtItemDXN.setInRentGiftAmount(tranCashTerAmtItemDXO.getInRentGiftAmount());
            tranCashTerAmtItemDXN.setInCosmeticGiftAmount(tranCashTerAmtItemDXO.getInCosmeticGiftAmount());
            tranCashTerAmtItemDXN.setInSportsGiftAmount(tranCashTerAmtItemDXO.getInSportsGiftAmount());
            tranCashTerAmtItemDXN.setInVoucherGiftAmount(tranCashTerAmtItemDXO.getInVoucherGiftAmount());
            tranCashTerAmtItemDXN.setInPromoCashAmount(tranCashTerAmtItemDXO.getInPromoCashAmount());
            tranCashTerAmtItemDXN.setInPromoGiftAmount(tranCashTerAmtItemDXO.getInPromoGiftAmount());
            tranCashTerAmtItemDXN.setInCheckAmount(tranCashTerAmtItemDXO.getInCheckAmount());
            tranCashTerAmtItemDXN.setInDollarAmount(tranCashTerAmtItemDXO.getInDollarAmount());
            tranCashTerAmtItemDXN.setInYenAmount(tranCashTerAmtItemDXO.getInYenAmount());
            tranCashTerAmtItemDXN.setInEuroAmount(tranCashTerAmtItemDXO.getInEuroAmount());
            tranCashTerAmtItemDXN.setInYuanAmount(tranCashTerAmtItemDXO.getInYuanAmount());
            tranCashTerAmtItemDXN.setEndFlag(tranCashTerAmtItemDXO.getEndFlag());

            if(ret == 0){
                compTranData.getTran_CashTerAmtItem_DX().add(tranCashTerAmtItemDXN);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * NEW DMS ITEM ("66", "D0")
     * 
     * @return
     */
    public int parseTranDmsItem(int itemLength, String sTranInfo){
        int ret = -1;

        try{
            // ------------------------------------------------------------------------------------------------------
            // 구 트란 파싱
            TranDmsItemO tranDmsItemO = new TranDmsItemO();
            // ITEM코드
            ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, tranDmsItemO, "itemcode", 0, 0, 0);
            // ITEM길이
            ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, tranDmsItemO, "Itemlen", 0, 0, 0);
            // DMS 통신공통Header
            ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, tranDmsItemO, "DmsComHeader", 0, 0, 0);
            // DMS Tran Header
            ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, tranDmsItemO, "DmsTranHeader", 0, 0, 0);

            // DMS 에누리 행사 Item
            for(int i = 0; i < ParseHelper.convStrToInt(tranDmsItemO.getDmsTranHeader().getENURI_CD_CNT()); i++){
                TranDmsItemO.DmsItemList_O dmsItemListO = new TranDmsItemO.DmsItemList_O();

                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsItemListO, "ITEM_ID", 0, 0, 0);
                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsItemListO, "ITEM_LEN", 0, 0, 0);
                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsItemListO, "ENURI_EVT_CD", 0, 0, 0);
                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsItemListO, "ENURI_STR_CD", 0, 0, 0);
                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsItemListO, "ENURI_EVT_YM", 0, 0, 0);
                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsItemListO, "ENURI_EVT_NO", 0, 0, 0);
                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsItemListO, "CP_ISS_NO", 0, 0, 0);
                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsItemListO, "CP_NO", 0, 0, 0);
                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsItemListO, "CP_DCNT_GB_CD", 0, 0, 0);
                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsItemListO, "CP_ENURI_VAL", 0, 0, 0);
                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsItemListO, "ENURI_MD_CNT", 0, 0, 0);
                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsItemListO, "ENURI_PAY_CNT", 0, 0, 0);
                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsItemListO, "CP_ISSUE_TYPE", 0, 0, 0);
                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsItemListO, "ENURI_FILLER", 0, 0, 0);
                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsItemListO, "FILLER", 0, 0, 0);

                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsItemListO, "MdList", 0, 0,
                        ParseHelper.convStrToInt(dmsItemListO.getENURI_MD_CNT()));
                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsItemListO, "PayList", 0, 0,
                        ParseHelper.convStrToInt(dmsItemListO.getENURI_PAY_CNT()));

                tranDmsItemO.getDmsItemList().add(dmsItemListO);
            }

            // DMS 에누리 계산 행사 Item
            for(int i = 0; i < ParseHelper.convStrToInt(tranDmsItemO.getDmsTranHeader().getENURI_CD_CALC_CNT()); i++){
                TranDmsItemO.DmsCalcItemList_O dmsCalcItemList_O = new TranDmsItemO.DmsCalcItemList_O();
                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsCalcItemList_O, "ITEM_ID", 0, 0, 0);
                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsCalcItemList_O, "ITEM_LEN", 0, 0, 0);
                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsCalcItemList_O, "ENURI_EVT_CD", 0, 0, 0);
                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsCalcItemList_O, "ENURI_STR_CD", 0, 0, 0);
                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsCalcItemList_O, "ENURI_EVT_YM", 0, 0, 0);
                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsCalcItemList_O, "ENURI_EVT_NO", 0, 0, 0);
                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsCalcItemList_O, "CP_ENURI_VAL", 0, 0, 0);
                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsCalcItemList_O, "ENURI_MD_CNT", 0, 0, 0);
                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsCalcItemList_O, "ENURI_PAY_CNT", 0, 0, 0);
                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsCalcItemList_O, "ENURI_FILLER", 0, 0, 0);

                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsCalcItemList_O, "MdEnuriList", 0, 0,
                        ParseHelper.convStrToInt(dmsCalcItemList_O.getENURI_MD_CNT()));
                ParseHelper.setTranFieldData(getTranDataOBytes(), offSet, dmsCalcItemList_O, "PayList", 0, 0,
                        ParseHelper.convStrToInt(dmsCalcItemList_O.getENURI_PAY_CNT()));

                tranDmsItemO.getDmsCalcItemList().add(dmsCalcItemList_O);
            }
            log.info("NEW DMS ITEM(구전문) : \n{}\n",
                    JsonUtil.getMapper().writerWithDefaultPrettyPrinter().writeValueAsString(tranDmsItemO));

            // ------------------------------------------------------------------------------------------------------
            // 신 트란 생성
            int nDILMdList_N = ParseHelper.tranTotalSize(TranDmsItemN.DmsItemList_N.DILMdList_N.class);
            int nDILPayList_N = ParseHelper.tranTotalSize(TranDmsItemN.DmsItemList_N.DILPayList_N.class);
            int nDCILMdEnuriList_N = ParseHelper.tranTotalSize(TranDmsItemN.DmsCalcItemList_N.DCILMdEnuriList_N.class);
            int nDCILPayList_N = ParseHelper.tranTotalSize(TranDmsItemN.DmsCalcItemList_N.DCILPayList_N.class);
            int nTotLen = 111;

            TranDmsItemN tranDmsItemN = new TranDmsItemN();

            // 신 트란 아이템코드
            tranDmsItemN.setItemCode(EnmTranItemCodeWrap.Tran_DmsItem.getItemCode_N());
            // 신 트란 아이템길이
            /*
             * tranDmsItemN.setItemLength(String.format("%04d",
             * EnmTranItemCodeWrap.Tran_DmsItem.getItemCodeLen_N()));
             */

            // [1] DMS Tran Header
            // 사용구분
            tranDmsItemN.setUSE_FLAG(tranDmsItemO.getDmsTranHeader().getUSE_FLAG());
            // IRT ID
            tranDmsItemN.setIRT_ID(tranDmsItemO.getDmsTranHeader().getIRT_ID());
            // 고객번호
            tranDmsItemN.setCUST_ID(tranDmsItemO.getDmsTranHeader().getCUST_ID());

            // 에누리 총액 (10->15)
            tranDmsItemN.setENURI_AMT(ParseHelper.getLpadFillZeroStringForNewTran(tranDmsItemN, "ENURI_AMT",
                    tranDmsItemO.getDmsTranHeader().getENYRI_AMT()));

            // 적용 에누리 행사 개수
            tranDmsItemN.setENURI_CD_CNT(ParseHelper.getLpadFillZeroStringForNewTran(tranDmsItemN, "ENURI_CD_CNT",
                    tranDmsItemO.getDmsTranHeader().getENURI_CD_CNT()));
            // 할인 계산 행사 개수
            tranDmsItemN.setENURI_CD_CALC_CNT(ParseHelper.getLpadFillZeroStringForNewTran(tranDmsItemN,
                    "ENURI_CD_CALC_CNT", tranDmsItemO.getDmsTranHeader().getENURI_CD_CALC_CNT()));
            // 수기에누리여부
            tranDmsItemN.setMANUAL_ENURI_YN(tranDmsItemO.getDmsTranHeader().getMANUAL_ENURI_YN());
            // 스마일페이 회원번호
            tranDmsItemN.setSMILE_PAY_CUST_NO(tranDmsItemO.getDmsTranHeader().getSMP_CUST_ID());
            // 예비
            tranDmsItemN.setHEADER_FILLER(tranDmsItemO.getDmsTranHeader().getHEADER_FILLER());

            log.info("DMS 에누리 행사 ITEM 반복 시작");
            // [2] DMS 에누리 행사 ITEM
            for(TranDmsItemO.DmsItemList_O dmsItemListO : tranDmsItemO.getDmsItemList()){
                int nITEM_LEN = 200;
                TranDmsItemN.DmsItemList_N dmsItemListN = new TranDmsItemN.DmsItemList_N();

                // 아이템ID
                dmsItemListN.setITEM_ID(dmsItemListO.getITEM_ID());

                // 아이템길이
                // dmsItemListN.setITEM_LEN(dmsItemListO.getITEM_LEN());

                // 행사종류코드
                dmsItemListN.setEVT_KIND_CD(dmsItemListO.getENURI_EVT_CD());
                log.info("행사종류코드 : [{}]", dmsItemListN.getEVT_KIND_CD());

                // 점포코드
                dmsItemListN.setSTR_CD(dmsItemListO.getENURI_STR_CD());

                // 행사년월
                dmsItemListN.setYM(dmsItemListO.getENURI_EVT_YM());
                log.info("행사년월 : [{}]", dmsItemListN.getYM());

                // ---------------------------------------------------------------------------------------------------
                // 행사번호 (6->9)
                String sENURI_EVT_NO_TG = "";
                String sENURI_EVT_NO = dmsItemListO.getENURI_EVT_NO() == null ? ""
                        : dmsItemListO.getENURI_EVT_NO().trim();
                String sENURI_EVT_CD = dmsItemListO.getENURI_EVT_CD() == null ? ""
                        : dmsItemListO.getENURI_EVT_CD().trim();
                String sENURI_STR_CD = dmsItemListO.getENURI_STR_CD() == null ? ""
                        : dmsItemListO.getENURI_STR_CD().trim();
                List<String> lstENURI_EVT_CD = new ArrayList<>(Arrays.asList("04", "05", "07", "08", "11", "12"));

                sENURI_STR_CD = ParseHelper.getRpadFillSpaceString(sENURI_STR_CD, 2);
                log.info("ENURI_STR_CD : {}", sENURI_STR_CD);

                // 직영 수기에누리인 경우
                if(sENURI_EVT_NO.isEmpty() && "06".equals(sENURI_EVT_CD)){
                    sENURI_EVT_NO_TG = sENURI_EVT_NO;
                    log.info("행사티입 : 직영 수기에누리");
                }
                // 상시에누리인 경우
                else if("01".equals(sENURI_EVT_CD)){
                    sENURI_EVT_NO_TG = "000000002";
                    log.info("행사티입 : 상시에누리");
                }
                // 쿠폰행사인 경우
                else if(lstENURI_EVT_CD.contains(sENURI_EVT_CD)){
                    log.info("행사티입 : 쿠폰행사");
                    if(sENURI_EVT_NO != null){
                        if("999912".equals(dmsItemListN.getYM())){
                            sENURI_EVT_NO_TG = ParseHelper.getLpadFillZeroString(sENURI_EVT_NO, 9);
                        }else{
                            if("7".equals(sENURI_EVT_NO.substring(0, 1))){
                                sENURI_EVT_NO_TG = "000" + sENURI_EVT_NO;
                            }else{
                                sENURI_EVT_NO_TG = "D" + sENURI_STR_CD
                                        + String.format("%6s", sENURI_EVT_NO).replace(" ", "0");
                            }
                        }
                    }
                }else{
                    sENURI_EVT_NO_TG = sENURI_EVT_NO;
                }
                dmsItemListN.setEVT_NO(
                        ParseHelper.getLpadFillSpaceStringForNewTran(dmsItemListN, "EVT_NO", sENURI_EVT_NO_TG));
                log.info("EVT_NO : {}", dmsItemListN.getEVT_NO());

                // ---------------------------------------------------------------------------------------------------
                // 쿠폰코드
                Map<String, Object> paramMap = new HashMap<>();
                String sCP_CD_TG = "";

                // 직영 수기에누리인 경우
                if(sENURI_EVT_NO.isEmpty() && "06".equals(sENURI_EVT_CD)){
                    sCP_CD_TG = "";
                }
                // 상시에누리인 경우
                else if("01".equals(sENURI_EVT_CD)){
                    sCP_CD_TG = "99999999999999999";
                }
                // 쿠폰행사인 경우
                else if(lstENURI_EVT_CD.contains(sENURI_EVT_CD)){
                    if("999912".equals(dmsItemListN.getYM())){
                        sCP_CD_TG = "99999999999999999";
                    }else{
                        String sENURI_EVT_YM = dmsItemListO.getENURI_EVT_YM() == null ? ""
                                : dmsItemListO.getENURI_EVT_YM().trim();
                        paramMap.clear();
                        paramMap.put("enuriEvtYm", sENURI_EVT_YM);
                        paramMap.put("enuriStrCd", sENURI_STR_CD);
                        paramMap.put("enuriEvtNo", dmsItemListN.getEVT_NO());
                        nDebugFlag = 3;
                        sCP_CD_TG = queryProc.selectDmsItemCpCd(paramMap, sTranInfo, logParamMap);
                        nDebugFlag = 0;
                    }
                }else{
                    sCP_CD_TG = "";
                }
                dmsItemListN.setCP_CD(ParseHelper.getLpadFillSpaceStringForNewTran(dmsItemListN, "CP_CD", sCP_CD_TG));
                log.info("CP_CD : {}", dmsItemListN.getCP_CD());

                // ---------------------------------------------------------------------------------------------------
                // 쿠폰/할인권 발급 번호 (6->20)
                Map<String, Object> retMap = null;
                String cpIssNo = dmsItemListO.getCP_ISS_NO().trim();
                int nrmCpnDcrt = 0, evnCpnDcrt = 0;

                if(cpIssNo != null && cpIssNo.length() > 0){
                    if("999912".equals(dmsItemListN.getYM())){
                        cpIssNo = ParseHelper.getLpadFillZeroString(1, 20);
                    }else{
                        int nCpIssNo = ParseHelper.convStrToInt(cpIssNo.trim());

                        paramMap.clear();
                        paramMap.put("custId", tranDmsItemO.getDmsTranHeader().getCUST_ID());
                        paramMap.put("cpIssNo", nCpIssNo);

                        nDebugFlag = 3;
                        retMap = queryProc.selectDmsItemcpIssNo(paramMap, sTranInfo, logParamMap);
                        nDebugFlag = 0;

                        if(retMap != null){
                            if(retMap.get("dpstrEvnCpnNo") != null)
                                cpIssNo = retMap.get("dpstrEvnCpnNo").toString();
                            else
                                cpIssNo = "";

                            if(retMap.get("nrmCpnDcrt") != null)
                                nrmCpnDcrt = (int)retMap.get("nrmCpnDcrt");

                            if(retMap.get("evnCpnDcrt") != null)
                                evnCpnDcrt = (int)retMap.get("evnCpnDcrt");

                            log.info("조회 dpstrEvnCpnNo : [{}], nrmCpnDcrt : [{}], evnCpnDcrt : [{}}", cpIssNo,
                                    nrmCpnDcrt, evnCpnDcrt);
                        }
                    }
                }else
                    cpIssNo = "";

                dmsItemListN
                        .setCP_ISS_NO(ParseHelper.getLpadFillSpaceStringForNewTran(dmsItemListN, "CP_ISS_NO", cpIssNo));
                log.info("CP_ISS_NO : {}", dmsItemListN.getCP_ISS_NO());

                // ---------------------------------------------------------------------------------------------------
                // 할인구분코드
                dmsItemListN.setDCNT_GB_CD(dmsItemListO.getCP_DCNT_GB_CD());

                // 정상할인율
                // '0'
                dmsItemListN
                        .setNRM_DCRT(ParseHelper.getLpadFillZeroStringForNewTran(dmsItemListN, "NRM_DCRT", nrmCpnDcrt));

                // 행사할인율
                // '0'
                dmsItemListN
                        .setEVN_DCRT(ParseHelper.getLpadFillZeroStringForNewTran(dmsItemListN, "EVN_DCRT", evnCpnDcrt));

                // 할인금액 (10->15)
                dmsItemListN.setDCNT_AMT(ParseHelper.getLpadFillZeroStringForNewTran(dmsItemListN, "DCNT_AMT",
                        dmsItemListO.getCP_ENURI_VAL()));

                // 신세계분담금액
                // '0'
                dmsItemListN.setCP_S_DCNT_AMT(
                        ParseHelper.getLpadFillZeroStringForNewTran(dmsItemListN, "CP_S_DCNT_AMT", 0));
                log.info("신세계분담금액(고정) : 0");

                // 협력회사분담금액
                // '0'
                dmsItemListN.setCP_B_DCNT_AMT(
                        ParseHelper.getLpadFillZeroStringForNewTran(dmsItemListN, "CP_B_DCNT_AMT", 0));
                log.info("협력회사분담금액(고정) : 0");

                // 카드사분담금액
                // '0'
                dmsItemListN.setCP_C_DCNT_AMT(
                        ParseHelper.getLpadFillZeroStringForNewTran(dmsItemListN, "CP_C_DCNT_AMT", 0));
                log.info("카드사분담금액(고정) : 0");

                // 적용MD정보개수
                dmsItemListN.setMD_CNT(ParseHelper.getLpadFillZeroStringForNewTran(dmsItemListN, "MD_CNT",
                        dmsItemListO.getENURI_MD_CNT()));

                // 적용결제수단개수
                dmsItemListN.setPAY_CNT(ParseHelper.getLpadFillZeroStringForNewTran(dmsItemListN, "PAY_CNT",
                        dmsItemListO.getENURI_PAY_CNT()));

                // 쿠폰 발급 형태
                dmsItemListN.setCP_ISSUE_TYPE(dmsItemListO.getCP_ISSUE_TYPE());

                // 캠페인 행사종류
                dmsItemListN.setCAMP_KIND_CD(dmsItemListO.getENURI_FILLER());

                // 취소유효기간
                // 행사종류구분코드(EVT_KIND_CD) 값이 '11'(FIT에누리쿠폰), '12'(FIT금액할인권) 일때만
                // 조회 '11','12 값이 아닌 경우에는 NULL 값으로 전달
                String cpCaclValidDate = "";
                if(dmsItemListN.getEVT_KIND_CD() != null && ("11".equals(dmsItemListN.getEVT_KIND_CD().trim())
                        || "12".equals(dmsItemListN.getEVT_KIND_CD().trim()))){
                    paramMap.clear();
                    paramMap.put("cpnCd", sCP_CD_TG);

                    nDebugFlag = 3;
                    cpCaclValidDate = queryProc.selectDmsItemcpCaclValidDate(paramMap, sTranInfo, logParamMap);
                    nDebugFlag = 0;

                    log.info("취소유효기간(조회) : [{}]", cpCaclValidDate);
                }
                dmsItemListN.setCP_CACL_VALID_DATE(ParseHelper.getRpadFillSpaceStringForNewTran(dmsItemListN,
                        "CP_CACL_VALID_DATE", cpCaclValidDate));

                // 예비 (13->50)
                dmsItemListN.setFILLER(
                        ParseHelper.getLpadFillSpaceStringForNewTran(dmsItemListN, "FILLER", dmsItemListO.getFILLER()));

                // [2-1] DMS 에누리 행사 ITEM - MdList 적용MD 반복
                for(TranDmsItemO.DmsItemList_O.DILMdList_O dILMdList_O : dmsItemListO.getMdList()){
                    TranDmsItemN.DmsItemList_N.DILMdList_N dILMdList_N = new TranDmsItemN.DmsItemList_N.DILMdList_N();

                    // Item순번
                    dILMdList_N.setMD_ITEM_SEQ(dILMdList_O.getENURI_ITEM_SEQ());

                    // 예비
                    dILMdList_N.setMD_FILLER(dILMdList_O.getENURI_MD_FILLER());

                    dmsItemListN.getMdList().add(dILMdList_N);

                    nITEM_LEN = nITEM_LEN + nDILMdList_N;
                }

                // [2-2] DMS 에누리 행사 ITEM - PayList 적용결제수단 반복
                for(TranDmsItemO.DmsItemList_O.DILPayList_O dILPayList_O : dmsItemListO.getPayList()){
                    TranDmsItemN.DmsItemList_N.DILPayList_N dILPayList_N = new TranDmsItemN.DmsItemList_N.DILPayList_N();

                    // 결제수단코드
                    dILPayList_N.setPAY_CD(dILPayList_O.getENURI_PAY_CD());

                    // 카드빈
                    dILPayList_N.setPAY_BIN(dILPayList_O.getENURI_BIN());

                    // 결제금액 (10->15)
                    dILPayList_N.setPAY_AMT(ParseHelper.getLpadFillZeroStringForNewTran(dILPayList_N, "PAY_AMT",
                            dILPayList_O.getENURI_PAY_AMT()));

                    // 에누리 금액 (10->15)
                    dILPayList_N.setPAY_DC_AMT(ParseHelper.getLpadFillZeroStringForNewTran(dILPayList_N, "PAY_DC_AMT",
                            dILPayList_O.getENURI_DC_AMT()));

                    // 카드빈8
                    dILPayList_N.setPAY_BIN8(dILPayList_O.getENURI_BIN8());

                    // 예비
                    dILPayList_N.setPAY_FILLER(dILPayList_O.getENURI_PAY_FILLER());

                    dmsItemListN.getPayList().add(dILPayList_N);

                    nITEM_LEN = nITEM_LEN + nDILPayList_N;
                }

                // 아이템길이
                dmsItemListN
                        .setITEM_LEN(ParseHelper.getLpadFillZeroStringForNewTran(dmsItemListN, "ITEM_LEN", nITEM_LEN));

                log.info(" 에누리 행사 ITEM 길이 : [{}], 전체길이 : [{}]", nITEM_LEN, nTotLen);
                nTotLen += nITEM_LEN;

                tranDmsItemN.getDmsItemList().add(dmsItemListN);
            }

            log.info("DMS 에누리 행사 계산 ITEM 반복 시작");
            // [3] DMS 에누리 행사 계산 ITEM
            for(TranDmsItemO.DmsCalcItemList_O dmsCalcItemList_O : tranDmsItemO.getDmsCalcItemList()){
                int nITEM_LEN = 106;
                TranDmsItemN.DmsCalcItemList_N dmsCalcItemList_N = new TranDmsItemN.DmsCalcItemList_N();

                // 아이템ID
                dmsCalcItemList_N.setITEM_ID(dmsCalcItemList_O.getITEM_ID());

                // 아이템길이
                // dmsCalcItemList_N.setITEM_LEN(dmsCalcItemList_O.getITEM_LEN());

                // 행사종류코드(행사구분)
                dmsCalcItemList_N.setENURI_EVT_CD(dmsCalcItemList_O.getENURI_EVT_CD());

                // 점포코드
                dmsCalcItemList_N.setENURI_STR_CD(dmsCalcItemList_O.getENURI_STR_CD());

                // 행사년월
                dmsCalcItemList_N.setENURI_EVT_YM(dmsCalcItemList_O.getENURI_EVT_YM());

                // ---------------------------------------------------------------------------------------------------
                // 행사번호 (6->9)
                String sENURI_EVT_NO_TG = "";
                String sENURI_EVT_NO = dmsCalcItemList_O.getENURI_EVT_NO() == null ? ""
                        : dmsCalcItemList_O.getENURI_EVT_NO().trim();
                String sENURI_EVT_CD = dmsCalcItemList_O.getENURI_EVT_CD() == null ? ""
                        : dmsCalcItemList_O.getENURI_EVT_CD().trim();
                String sENURI_STR_CD = dmsCalcItemList_O.getENURI_STR_CD() == null ? ""
                        : dmsCalcItemList_O.getENURI_STR_CD().trim();
                List<String> lstENURI_EVT_CD = new ArrayList<>(Arrays.asList("04", "05", "07", "08", "11", "12"));

                sENURI_STR_CD = ParseHelper.getRpadFillSpaceString(sENURI_STR_CD, 2);
                log.info("ENURI_STR_CD : {}", sENURI_STR_CD);

                // 직영 수기에누리인 경우
                if(sENURI_EVT_NO.isEmpty() && "06".equals(sENURI_EVT_CD)){
                    sENURI_EVT_NO_TG = sENURI_EVT_NO;
                    log.info("행사티입 : 직영 수기에누리");
                }
                // 상시에누리인 경우
                else if("01".equals(sENURI_EVT_CD)){
                    sENURI_EVT_NO_TG = "000000002";
                    log.info("행사티입 : 상시에누리");
                }
                // 쿠폰행사인 경우
                else if(lstENURI_EVT_CD.contains(sENURI_EVT_CD)){
                    log.info("행사티입 : 쿠폰행사");
                    if(sENURI_EVT_NO != null){
                        if("999912".equals(dmsCalcItemList_N.getENURI_EVT_YM())){
                            sENURI_EVT_NO_TG = ParseHelper.getLpadFillZeroString(sENURI_EVT_NO, 9);
                        }else{
                            if("7".equals(sENURI_EVT_NO.substring(0, 1))){
                                sENURI_EVT_NO_TG = "000" + sENURI_EVT_NO;
                            }else{
                                sENURI_EVT_NO_TG = "D" + sENURI_STR_CD
                                        + String.format("%6s", sENURI_EVT_NO).replace(" ", "0");
                            }
                        }
                    }
                }else{
                    sENURI_EVT_NO_TG = sENURI_EVT_NO;
                }
                dmsCalcItemList_N.setENURI_EVT_NO(ParseHelper.getLpadFillSpaceStringForNewTran(dmsCalcItemList_N,
                        "ENURI_EVT_NO", sENURI_EVT_NO_TG));
                log.info("ENURI_EVT_NO : {}", dmsCalcItemList_N.getENURI_EVT_NO());

                // ---------------------------------------------------------------------------------------------------
                // 쿠폰코드
                Map<String, Object> paramMap = new HashMap<>();
                String sCP_CD_TG = "";

                // 직영 수기에누리인 경우
                if(sENURI_EVT_NO.isEmpty() && "06".equals(sENURI_EVT_CD)){
                    sCP_CD_TG = "";
                }
                // 상시에누리인 경우
                else if("01".equals(sENURI_EVT_CD)){
                    sCP_CD_TG = "99999999999999999";
                }
                // 쿠폰행사인 경우
                else if(lstENURI_EVT_CD.contains(sENURI_EVT_CD)){
                    if("999912".equals(dmsCalcItemList_N.getENURI_EVT_YM())){
                        sCP_CD_TG = "99999999999999999";
                    }else{
                        String sENURI_EVT_YM = dmsCalcItemList_O.getENURI_EVT_YM() == null ? ""
                                : dmsCalcItemList_O.getENURI_EVT_YM().trim();
                        paramMap.clear();
                        paramMap.put("enuriEvtYm", sENURI_EVT_YM);
                        paramMap.put("enuriStrCd", sENURI_STR_CD);
                        paramMap.put("enuriEvtNo", dmsCalcItemList_N.getENURI_EVT_NO());
                        nDebugFlag = 3;
                        sCP_CD_TG = queryProc.selectDmsItemCpCd(paramMap, sTranInfo, logParamMap);
                        nDebugFlag = 0;
                    }
                }else{
                    sCP_CD_TG = "";
                }
                dmsCalcItemList_N
                        .setCP_CD(ParseHelper.getLpadFillSpaceStringForNewTran(dmsCalcItemList_N, "CP_CD", sCP_CD_TG));
                log.info("CP_CD : {}", dmsCalcItemList_N.getCP_CD());

                // ---------------------------------------------------------------------------------------------------
                // 정상할인율
                // '0'
                dmsCalcItemList_N.setENURI_NRM_ENRT(
                        ParseHelper.getLpadFillZeroStringForNewTran(dmsCalcItemList_N, "ENURI_NRM_ENRT", 0));
                log.info("정상할인율(고정) : 0");

                // 행사할인율
                // '0'
                dmsCalcItemList_N.setENURI_EVN_ENRT(
                        ParseHelper.getLpadFillZeroStringForNewTran(dmsCalcItemList_N, "ENURI_EVN_ENRT", 0));
                log.info("행사할인율(고정) : 0");

                // 할인금액 (10->15)
                dmsCalcItemList_N.setENURI_DCNT_AMT(ParseHelper.getLpadFillZeroStringForNewTran(dmsCalcItemList_N,
                        "ENURI_DCNT_AMT", dmsCalcItemList_O.getCP_ENURI_VAL()));

                // 적용MD정보개수
                dmsCalcItemList_N.setENURI_MD_CNT(ParseHelper.getLpadFillZeroStringForNewTran(dmsCalcItemList_N,
                        "ENURI_MD_CNT", dmsCalcItemList_O.getENURI_MD_CNT()));

                // 적용결제수단개수
                dmsCalcItemList_N.setENURI_PAY_CNT(ParseHelper.getLpadFillZeroStringForNewTran(dmsCalcItemList_N,
                        "ENURI_PAY_CNT", dmsCalcItemList_O.getENURI_PAY_CNT()));

                // 예비
                dmsCalcItemList_N.setENURI_FILLER(dmsCalcItemList_O.getENURI_FILLER());

                // [3-1] DMS 에누리 행사 계산 ITEM - MdList 적용MD 반복
                for(TranDmsItemO.DmsCalcItemList_O.DCILMdEnuriList_O dCILMdEnuriList_O : dmsCalcItemList_O
                        .getMdEnuriList()){
                    TranDmsItemN.DmsCalcItemList_N.DCILMdEnuriList_N dCILMdEnuriList_N = new TranDmsItemN.DmsCalcItemList_N.DCILMdEnuriList_N();

                    // Item순번
                    dCILMdEnuriList_N.setENURI_ITEM_SEQ(dCILMdEnuriList_O.getENURI_ITEM_SEQ());

                    // 할인율(에누리 율)
                    dCILMdEnuriList_N.setENURI_RATE(dCILMdEnuriList_O.getENURI_RATE());

                    // 할인액(에누리 값) (3->15)
                    dCILMdEnuriList_N.setENURI_AMOUNT(ParseHelper.getLpadFillZeroStringForNewTran(dCILMdEnuriList_N,
                            "ENURI_AMOUNT", dCILMdEnuriList_O.getENURI_AMOUNT()));

                    // 예비 (9->22)
                    dCILMdEnuriList_N.setENURI_MD_FILLER(ParseHelper.getLpadFillSpaceStringForNewTran(dCILMdEnuriList_N,
                            "ENURI_MD_FILLER", dCILMdEnuriList_O.getENURI_MD_FILLER()));

                    dmsCalcItemList_N.getMdEnuriList().add(dCILMdEnuriList_N);

                    nITEM_LEN = nITEM_LEN + nDCILMdEnuriList_N;
                }

                // [3-2] DMS 에누리 행사 계산 ITEM - PayList 적용결제수단 반복
                for(TranDmsItemO.DmsCalcItemList_O.DCILPayList_O dCILPayList_O : dmsCalcItemList_O.getPayList()){
                    TranDmsItemN.DmsCalcItemList_N.DCILPayList_N dCILPayList_N = new TranDmsItemN.DmsCalcItemList_N.DCILPayList_N();

                    // 결제수단코드
                    dCILPayList_N.setENURI_PAY_CD(dCILPayList_O.getENURI_PAY_CD());

                    // 카드빈
                    dCILPayList_N.setENURI_BIN(dCILPayList_O.getENURI_BIN());

                    // 결제금액 (10->15)
                    dCILPayList_N.setENURI_PAY_AMT(ParseHelper.getLpadFillZeroStringForNewTran(dCILPayList_N,
                            "ENURI_PAY_AMT", dCILPayList_O.getENURI_PAY_AMT()));

                    // 에누리 금액 (10->15)
                    dCILPayList_N.setENURI_DC_AMT(ParseHelper.getLpadFillZeroStringForNewTran(dCILPayList_N,
                            "ENURI_DC_AMT", dCILPayList_O.getENURI_DC_AMT()));

                    // 카드빈8
                    dCILPayList_N.setENURI_BIN8(dCILPayList_O.getENURI_BIN8());

                    // 예비
                    dCILPayList_N.setENURI_PAY_FILLER(dCILPayList_O.getENURI_PAY_FILLER());

                    dmsCalcItemList_N.getPayList().add(dCILPayList_N);

                    nITEM_LEN = nITEM_LEN + nDCILPayList_N;
                }

                // 아이템길이
                dmsCalcItemList_N.setITEM_LEN(
                        (ParseHelper.getLpadFillZeroStringForNewTran(dmsCalcItemList_N, "ITEM_LEN", nITEM_LEN)));

                log.info(" 에누리 행사 계산 ITEM 길이 : [{}], 전체길이 : [{}]", nITEM_LEN, nTotLen);

                nTotLen += nITEM_LEN;

                tranDmsItemN.getDmsCalcItemList().add(dmsCalcItemList_N);
            }

            log.info("NEW DMS ITEM 전체 길이 : [{}]", nTotLen);

            // 신 트란 아이템길이
            tranDmsItemN
                    .setItemLength(ParseHelper.getLpadFillZeroStringForNewTran(tranDmsItemN, "ItemLength", nTotLen));

            compTranData.getTran_DmsItem().add(tranDmsItemN);
            ret = 0;
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 행사정보 ITEM(BMP 청구할인) ("73", "D1")
     * 
     * @return
     */
    public int parseTranBmpCampaignItem(int itemLength){
        int ret = -1;

        try{
            // 구 트란 파싱
            TranBmpCampaignItemO tranBmpCampaignItem_O = new TranBmpCampaignItemO();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranBmpCampaignItem_O, 0, 0, false, false);

            // 신 트란 생성
            TranBmpCampaignItemN tranBmpCampaignItem_N = new TranBmpCampaignItemN();

            // 신 트란 아이템코드
            tranBmpCampaignItem_N.setItemCode(EnmTranItemCodeWrap.Tran_BmpCampaignItem.getItemCode_N());
            // 신 트란 아이템길이
            tranBmpCampaignItem_N
                    .setItemLength(String.format("%04d", EnmTranItemCodeWrap.Tran_BmpCampaignItem.getItemCodeLen_N()));

            // 업무구분
            tranBmpCampaignItem_N.setJobType(tranBmpCampaignItem_O.getJobType());
            // 캠페인식별자
            tranBmpCampaignItem_N.setCampId(tranBmpCampaignItem_O.getCampId());
            // 점포코드
            tranBmpCampaignItem_N.setEvtStrCd(tranBmpCampaignItem_O.getEvtStrCd());
            // 행사년월
            tranBmpCampaignItem_N.setEvtYm(tranBmpCampaignItem_O.getEvtYm());

            // ---------------------------------------------------------------------------------------------------
            // 행사번호 (6->9)
            String sEvtStrCd = ParseHelper.getRpadFillSpaceString(tranBmpCampaignItem_O.getEvtStrCd(), 2);
            String sEvtYm = ParseHelper.getLpadFillZeroString(tranBmpCampaignItem_O.getEvtYm(), 6);
            String sEvtNo = tranBmpCampaignItem_O.getEvtNo();

            if(sEvtNo != null){
                if("7".equals(sEvtNo.substring(0, 1))){
                    sEvtNo = "000" + sEvtNo;
                }else{
                    sEvtNo = "D" + sEvtStrCd + String.format("%6s", sEvtNo).replace(" ", "0");
                }
            }else
                sEvtNo = "";
            log.info("행사점포 : [{}], 행사년월 : [{}], 행사번호 : [{}]", sEvtStrCd, sEvtYm, sEvtNo);

            tranBmpCampaignItem_N.setEvtNo(sEvtNo);

            // --------------------------------------------------------------------------------------------------
            // MD코드
            tranBmpCampaignItem_N.setMdCd(tranBmpCampaignItem_O.getMdCd());
            // 클래스
            tranBmpCampaignItem_N.setClasscode(tranBmpCampaignItem_O.getClasscode());
            // 행사시작일자
            tranBmpCampaignItem_N.setEvtStartDt(tranBmpCampaignItem_O.getEvtStartDt());
            // 행사종료일자
            tranBmpCampaignItem_N.setEvtEndDt(tranBmpCampaignItem_O.getEvtEndDt());
            // 취소유효일자
            tranBmpCampaignItem_N.setCnclValidDt(tranBmpCampaignItem_O.getCnclValidDt());
            // 분담율_신세계
            tranBmpCampaignItem_N.setShareRatioS(tranBmpCampaignItem_O.getShareRatioS());
            // 분담율_브랜드
            tranBmpCampaignItem_N.setShareRatioB(tranBmpCampaignItem_O.getShareRatioB());
            // 결제금액
            tranBmpCampaignItem_N.setAmount(tranBmpCampaignItem_O.getAmount());

            if(ret == 0){
                compTranData.getTran_BmpCampaignItem().add(tranBmpCampaignItem_N);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 신용카드(IC) 아이템 ("65", "E1")
     * 
     * @return
     */
    public int parseTranCardIcItem(int itemLength, String sTranInfo){
        int ret = -1;

        try{
            // 구 트란 파싱
            TranCardIcItemO tranCardIcItemO = new TranCardIcItemO();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranCardIcItemO, itemLength,
                    EnmTranItemCodeWrap.Tran_CardIcItem.getItemCodeLen_O_exLoopLen(), false, true);

            // 신 트란 생성
            TranCardIcItemN tranCardIcItemN = new TranCardIcItemN();

            // 신 트란 아이템코드
            tranCardIcItemN.setItemCode(EnmTranItemCodeWrap.Tran_CardIcItem.getItemCode_N());

            // 구 트란 상품 정보 반복 횟수
            int oLoop = tranCardIcItemO.getItemList().size();
            // 신 트란 상품 정보 반복 길이
            int nLoopLen = oLoop * ParseHelper.tranTotalSize(TranCardIcItemN.TranCardIcItemNItemList.class);

            // 신 트란 아이템길이
            tranCardIcItemN
                    .setItemLength(String.format("%04d", EnmTranItemCodeWrap.Tran_CardIcItem.getItemCodeLen_N()));

            tranCardIcItemN.setTmsType(tranCardIcItemO.getTMS_TYPE());
            tranCardIcItemN.setCardType(tranCardIcItemO.getCARD_TYPE());

            tranCardIcItemN.setAuthCnt(ParseHelper.getLpadFillZeroStringForNewTran(tranCardIcItemN, "AuthCnt",
                    tranCardIcItemO.getAUTH_CNT()));

            tranCardIcItemN.setAuthDate(tranCardIcItemO.getAUTH_DATE());
            tranCardIcItemN.setAuthTime(tranCardIcItemO.getAUTH_TIME());
            tranCardIcItemN.setCardKind(tranCardIcItemO.getCARD_KIND());
            tranCardIcItemN.setAuthInClss(tranCardIcItemO.getAUTH_IN_CLSS());
            tranCardIcItemN.setPointFlag(tranCardIcItemO.getPOINT_FLAG());
            tranCardIcItemN.setPassWord(tranCardIcItemO.getPASSWORD());
            tranCardIcItemN.setAuthNo(tranCardIcItemO.getAUTH_NO());
            tranCardIcItemN.setPointSaleAmt(tranCardIcItemO.getPOINT_SALE_AMT());
            tranCardIcItemN.setPrePoint1(tranCardIcItemO.getPRE_POINT1());
            tranCardIcItemN.setPrePoint2(tranCardIcItemO.getPRE_POINT2());
            tranCardIcItemN.setInsMon(tranCardIcItemO.getINS_MON());
            tranCardIcItemN.setPureSaleAmt(tranCardIcItemO.getPURE_SALE_AMT());
            tranCardIcItemN.setCardAuthSbj(tranCardIcItemO.getCARD_AUTH_SBJ());
            tranCardIcItemN.setAuthNum(tranCardIcItemO.getAUTH_NUM());
            tranCardIcItemN.setAuthSeq(tranCardIcItemO.getAUTH_SEQ());
            tranCardIcItemN.setPartRcptAmt(tranCardIcItemO.getPART_RCPT_AMT());
            tranCardIcItemN.setTotSaleAmt(tranCardIcItemO.getTOT_SALE_AMT());
            tranCardIcItemN.setDscntAmt(tranCardIcItemO.getDSCNT_AMT());
            tranCardIcItemN.setBagAmt(tranCardIcItemO.getBAG_AMT());

            Map<String, Object> paramMap = new HashMap<>();

            // 상품정보
            for(TranCardIcItemO.TranCardIcItemOItemList oItem : tranCardIcItemO.getItemList()){
                TranCardIcItemN.TranCardIcItemNItemList nItem = new TranCardIcItemN.TranCardIcItemNItemList();

                paramMap.clear();
                paramMap.put("storeNo", compTranData.getTran_Header_O().getStoreNo());
                paramMap.put("code", oItem.getCODE());

                // 상품코드 (16->30)
                nItem.setCode(ParseHelper.getLpadFillSpaceStringForNewTran(nItem, "Code",
                        queryProc.selectTranCardIcItemItemListCode(paramMap, sTranInfo, logParamMap)));

                // 사업영역코드
                nItem.setBIZ_RELM_CD(ParseHelper.getLpadFillSpaceStringForNewTran(nItem, "BIZ_RELM_CD",
                        queryProc.selectTranCardIcItemItemListBizRelmCd(paramMap, sTranInfo, logParamMap)));

                // 상품수량
                nItem.setCnt(ParseHelper.getLpadFillZeroStringForNewTran(nItem, "Cnt", oItem.getCNT()));
                // 상품금액
                nItem.setAmt(oItem.getAMT());
                // 상품명구분
                nItem.setClss(oItem.getCLSS());

                tranCardIcItemN.getItemList().add(nItem);
            }

            tranCardIcItemN.setSaleEct(tranCardIcItemO.getSALE_ETC());
            tranCardIcItemN.setDccFlag(tranCardIcItemO.getDCC_FLAG());
            tranCardIcItemN.setDccForeignAmt(tranCardIcItemO.getDccForeignAmt());
            tranCardIcItemN.setDccExchangeRate(tranCardIcItemO.getDccExchangeRate());
            tranCardIcItemN.setDccExchangeCode(tranCardIcItemO.getDccExchangeCode());
            tranCardIcItemN.setCardSeqNo(tranCardIcItemO.getCARD_SEQ_NO());
            tranCardIcItemN.setIssueFirmCode(tranCardIcItemO.getISSUE_FIRM_CODE());
            tranCardIcItemN.setBuyFirmCode(tranCardIcItemO.getBUY_FIRM_CODE());
            tranCardIcItemN.setSsgCardFlag(tranCardIcItemO.getSSG_CARD_FLAG());
            tranCardIcItemN.setDebitSeqNo(tranCardIcItemO.getDEBIT_SEQ_NO());
            tranCardIcItemN.setDongleReadType(tranCardIcItemO.getDONGLE_READ_TYPE());
            tranCardIcItemN.setDongleMobileType(tranCardIcItemO.getDONGLE_MOBILE_TYPE());
            tranCardIcItemN.setDongleCardType(tranCardIcItemO.getDONGLE_CARD_TYPE());
            tranCardIcItemN.setDongleCardKind(tranCardIcItemO.getDONGLE_CARD_KIND());
            tranCardIcItemN.setDongleCvmType(tranCardIcItemO.getDONGLE_CVM());
            tranCardIcItemN.setPreCardChanAmt(tranCardIcItemO.getPreCard_Chan_Amt());
            tranCardIcItemN.setCardNo(tranCardIcItemO.getCARD_NO());
            tranCardIcItemN.setCardEncryptFlag(tranCardIcItemO.getCARD_ENCRYPT_FLAG());
            tranCardIcItemN.setPosTmlNo(tranCardIcItemO.getPOS_TML_NO());
            tranCardIcItemN.setReaderTmlNo(tranCardIcItemO.getREADER_TML_NO());
            tranCardIcItemN.setCardData(tranCardIcItemO.getCARD_DATA());
            tranCardIcItemN.setCardDataVan(tranCardIcItemO.getCARD_DATA_VAN());
            tranCardIcItemN.setIcTmsType(tranCardIcItemO.getIC_TMS_TYPE());
            tranCardIcItemN.setFallBackType(tranCardIcItemO.getIC_FALL_BACK_TYPE());
            tranCardIcItemN.setIcCardType(tranCardIcItemO.getIC_CARD_TYPE());
            tranCardIcItemN.setIcVanCode(tranCardIcItemO.getIC_VAN_CODE());
            tranCardIcItemN.setIcEmvLen(tranCardIcItemO.getIC_EMV_LEN());
            tranCardIcItemN.setForceCancelFg(tranCardIcItemO.getIC_ForceCancelFg());
            tranCardIcItemN.setDaType(tranCardIcItemO.getDA_TYPE());
            tranCardIcItemN.setLteAppSeq(tranCardIcItemO.getLTEApprovalSeq());
            tranCardIcItemN.setForceTranSendFlag(tranCardIcItemO.getForceTranSendFlag());
            tranCardIcItemN.setIcFiller(tranCardIcItemO.getIC_FILLER());
            tranCardIcItemN.setIcEmvData(tranCardIcItemO.getCHIP_DATA());
            tranCardIcItemN.setCardEventKey(tranCardIcItemO.getCARD_EVENT_KEY());
            tranCardIcItemN.setTmGubn(tranCardIcItemO.getTM_GUBN());
            tranCardIcItemN.setCertiFlag(tranCardIcItemO.getCERTIFICATION_FLAG());
            tranCardIcItemN.setCertiAuthNo(tranCardIcItemO.getCERTIFICATION_AUTH_NO());
            tranCardIcItemN.setEdiDscntFlag(tranCardIcItemO.getEDI_DSCNT_FLAG());
            tranCardIcItemN.setCupAmt(tranCardIcItemO.getCUP_AMT());
            tranCardIcItemN.setFiller(tranCardIcItemO.getFILLER());

            if(ret == 0){
                compTranData.getTran_CardIcItem().add(tranCardIcItemN);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 카카오페이 ITEM ("90", "E2")
     * 
     * @return
     */
    public int parseTranKakaopayItem(int itemLength){
        int ret = -1;

        try{
            // 구 트란 파싱
            TranKakaopayItemO tranKakaopayItem_O = new TranKakaopayItemO();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranKakaopayItem_O, 0, 0, false, false);

            // 신 트란 생성
            TranKakaopayItemN tranKakaopayItem_N = new TranKakaopayItemN();

            // 신 트란 아이템코드
            tranKakaopayItem_N.setItemCode(EnmTranItemCodeWrap.Tran_KakaopayItem.getItemCode_N());
            // 신 트란 아이템길이
            tranKakaopayItem_N
                    .setItemLength(String.format("%04d", EnmTranItemCodeWrap.Tran_KakaopayItem.getItemCodeLen_N()));

            // Text ID
            tranKakaopayItem_N.setTextId(tranKakaopayItem_O.getTextId());
            // 점포코드
            tranKakaopayItem_N.setStoreNo(tranKakaopayItem_O.getStoreNo());
            // POS번호
            tranKakaopayItem_N.setPosNo(tranKakaopayItem_O.getPosNo());
            // 담당자번호
            tranKakaopayItem_N.setCashierNo(tranKakaopayItem_O.getCashierNo());
            // CD 일련번호
            tranKakaopayItem_N.setChitNo(tranKakaopayItem_O.getChitNo());
            // POS 거래번호
            tranKakaopayItem_N.setTranNo(tranKakaopayItem_O.getTranNo());
            // 영업일자
            tranKakaopayItem_N.setSaleDate(tranKakaopayItem_O.getSaleDate());
            // 아이템시퀀스
            tranKakaopayItem_N.setItemSeq(tranKakaopayItem_O.getItemSeq());
            // 전문번호
            tranKakaopayItem_N.setTextNo(tranKakaopayItem_O.getTextNo());
            // 전송기관
            tranKakaopayItem_N.setSendAgency(tranKakaopayItem_O.getSendAgency());
            // 거래고유번호
            tranKakaopayItem_N.setRetrievalNo(tranKakaopayItem_O.getRetrievalNo());
            // 거래타입
            tranKakaopayItem_N.setTrnsType(tranKakaopayItem_O.getTrnsType());
            // 단말기구분
            tranKakaopayItem_N.setCatClass(tranKakaopayItem_O.getCatClass());
            // 사업자번호
            tranKakaopayItem_N.setBuzNo(tranKakaopayItem_O.getBuzNo());
            // 가맹점아이디
            tranKakaopayItem_N.setMerId(tranKakaopayItem_O.getMerId());
            // 단말기아이디
            tranKakaopayItem_N.setCatId(tranKakaopayItem_O.getCatId());
            // 통화코드
            tranKakaopayItem_N.setCurrencyCode(tranKakaopayItem_O.getCurrencyCode());
            // 전송일자
            tranKakaopayItem_N.setSendDate(tranKakaopayItem_O.getSendDate());
            // 전송시간
            tranKakaopayItem_N.setSendTime(tranKakaopayItem_O.getSendTime());
            // 응답코드
            tranKakaopayItem_N.setRespCode(tranKakaopayItem_O.getRespCode());
            // 바코드타입
            tranKakaopayItem_N.setBarcodeType(tranKakaopayItem_O.getBarcodeType());
            // 바코드
            tranKakaopayItem_N.setBarcodeNo(tranKakaopayItem_O.getBarcodeNo());
            // 점포코드
            tranKakaopayItem_N.setStoreCode(tranKakaopayItem_O.getStoreCode());
            // 원거래 전송일자
            tranKakaopayItem_N.setOrgSaleDate(tranKakaopayItem_O.getOrgSaleDate());
            // 원거래 고유번호
            tranKakaopayItem_N.setOrgRetrievalNo(tranKakaopayItem_O.getOrgRetrievalNo());
            // 취소구분
            tranKakaopayItem_N.setCancelFlag(tranKakaopayItem_O.getCancelFlag());
            // 취소사유
            tranKakaopayItem_N.setCancelReason(tranKakaopayItem_O.getCancelReason());
            // 결제수단
            tranKakaopayItem_N.setPayType(tranKakaopayItem_O.getPayType());
            // 결제요청금액
            tranKakaopayItem_N.setSaleAmount(tranKakaopayItem_O.getSaleAmount());
            // 비과세금액
            tranKakaopayItem_N.setTaxFreeAmount(tranKakaopayItem_O.getTaxFreeAmount());
            // 세금
            tranKakaopayItem_N.setTaxAmount(tranKakaopayItem_O.getTaxAmount());
            // 봉사료
            tranKakaopayItem_N.setTipAmount(tranKakaopayItem_O.getTipAmount());
            // 할인금액
            tranKakaopayItem_N.setDiscountAmount(tranKakaopayItem_O.getDiscountAmount());
            // 승인금액
            tranKakaopayItem_N.setRecvAuthAmount(tranKakaopayItem_O.getRecvAuthAmount());
            // 할부개월
            tranKakaopayItem_N.setInsMonth(tranKakaopayItem_O.getInsMonth());
            // 승인일자
            tranKakaopayItem_N.setAuthDate(tranKakaopayItem_O.getAuthDate());
            // 승인시간
            tranKakaopayItem_N.setAuthTime(tranKakaopayItem_O.getAuthTime());
            // 승인번호
            tranKakaopayItem_N.setAuthNo(tranKakaopayItem_O.getAuthNo());
            // 카카오페이멤버십 바코드
            tranKakaopayItem_N.setMembershipBarcode(tranKakaopayItem_O.getMembershipBarcode());
            // 멤버십번호
            tranKakaopayItem_N.setMembershipNo(tranKakaopayItem_O.getMembershipNo());
            // 알림메세지
            tranKakaopayItem_N.setMessage(tranKakaopayItem_O.getMessage());
            // 발급사코드
            tranKakaopayItem_N.setBuyCode(tranKakaopayItem_O.getBuyCode());
            // 발급사명
            tranKakaopayItem_N.setBuyName(tranKakaopayItem_O.getBuyName());
            // 매입사코드
            tranKakaopayItem_N.setIssueCode(tranKakaopayItem_O.getIssueCode());
            // 매입사명
            tranKakaopayItem_N.setIssueName(tranKakaopayItem_O.getIssueName());
            // OTC
            tranKakaopayItem_N.setOTC(tranKakaopayItem_O.getOTC());
            // PEM
            tranKakaopayItem_N.setPEM(tranKakaopayItem_O.getPEM());
            // Trid
            tranKakaopayItem_N.setTrid(tranKakaopayItem_O.getTrid());
            // 카드BIN
            tranKakaopayItem_N.setCardBin(tranKakaopayItem_O.getCardBin());
            // 카카오 조회 거래고유번호
            tranKakaopayItem_N.setSearchRetrievalNo(tranKakaopayItem_O.getSearchRetrievalNo());
            // MD코드
            tranKakaopayItem_N.setMDCode(tranKakaopayItem_O.getMDCode());
            // 승인기관
            tranKakaopayItem_N.setVANClass(tranKakaopayItem_O.getVANClass());
            // 대표상품코드
            tranKakaopayItem_N.setSKUCode(tranKakaopayItem_O.getSKUCode());
            // 신용/체크 구분자
            tranKakaopayItem_N.setCheckClass(tranKakaopayItem_O.getCheckClass());
            // 도서/공연비 여부
            tranKakaopayItem_N.setMunwhaFlag(tranKakaopayItem_O.getMunwhaFlag());
            // POS바코드
            tranKakaopayItem_N.setPosBarcode(tranKakaopayItem_O.getPosBarcode());
            // 청구할인
            tranKakaopayItem_N.setEdiDscntFlag(tranKakaopayItem_O.getEdiDscntFlag());
            // 카드BIN8
            tranKakaopayItem_N.setCardBin8(tranKakaopayItem_O.getCardBin8());

            // 현금영수증대상금액
            // SUBSTR(FILLER, 5, 12)
            tranKakaopayItem_N.setCashRcptAmt(ParseHelper.getLpadFillZeroStringForNewTran(tranKakaopayItem_N,
                    "CashRcptAmt", tranKakaopayItem_O.getFiller().substring(4, 5 + 12)));

            // 컵보증금
            tranKakaopayItem_N.setCupAmt(tranKakaopayItem_O.getCupAmt());

            // 사업영역코드
            // SUBSTR(FILLER, 1, 4)
            // 상품 아이템꺼 갖다 씀 : tranGoodsItemBizRelmCd
            // tranKakaopayItem_N.setBizRelmCd(ParseHelper.getLpadFillSpaceStringForNewTran(tranKakaopayItem_N,
            // "BizRelmCd", tranKakaopayItem_O.getFiller().substring(1, 1 +
            // 4)));
            tranKakaopayItem_N.setBizRelmCd(ParseHelper.getLpadFillSpaceStringForNewTran(tranKakaopayItem_N,
                    "BizRelmCd", tranGoodsItemBizRelmCd));

            // 예비필드 (482->466)
            tranKakaopayItem_N
                    .setFiller(ParseHelper.getLpadFillSpaceStringForNewTran(tranKakaopayItem_N, "Filler", ""));

            if(ret == 0){
                compTranData.getTran_KakaopayItem().add(tranKakaopayItem_N);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 간편결제 통합전문 ITEM ("98", "E3")
     * 
     * @return
     */
    public int parseTranEasyPaymentItem(int itemLength){
        int ret = -1;

        try{
            // 구 트란 파싱
            TranEasyPaymentItemO tranEasyPaymentItem_O = new TranEasyPaymentItemO();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranEasyPaymentItem_O, 0, 0, false, false);

            // 신 트란 생성
            TranEasyPaymentItemN tranEasyPaymentItem_N = new TranEasyPaymentItemN();

            // 신 트란 아이템코드
            tranEasyPaymentItem_N.setItemCode(EnmTranItemCodeWrap.Tran_EasyPaymentItem.getItemCode_N());
            // 신 트란 아이템길이
            tranEasyPaymentItem_N
                    .setItemLength(String.format("%04d", EnmTranItemCodeWrap.Tran_EasyPaymentItem.getItemCodeLen_N()));

            // TEXT ID - 대외기관 코드
            // 'TS'으로 세팅
            tranEasyPaymentItem_N.setCom_id_1("TS");

            // TEXT ID - 대외기관 코드
            // 'M'으로 세팅
            tranEasyPaymentItem_N.setCom_id_2("M");

            // TEXT ID - 전문구분
            // 매칭이 안되는 코드는 그대로 할당
            String com_id_2 = tranEasyPaymentItem_O.getCom_id_2().trim();
            String com_id_3 = tranEasyPaymentItem_O.getCom_id_3().trim();
            String com_id_3_tobe = com_id_3;

            if("1".equals(com_id_2) && "500".equals(com_id_3))
                com_id_3_tobe = "M50";
            else if("1".equals(com_id_2) && "600".equals(com_id_3))
                com_id_3_tobe = "M60";
            else if("2".equals(com_id_2) && "500".equals(com_id_3))
                com_id_3_tobe = "P50";
            else if("2".equals(com_id_2) && "600".equals(com_id_3))
                com_id_3_tobe = "P60";

            tranEasyPaymentItem_N.setCom_id_3(com_id_3_tobe);

            // 전문길이
            tranEasyPaymentItem_N.setCom_len(tranEasyPaymentItem_O.getCom_len());
            // 전문일련번호
            tranEasyPaymentItem_N.setCom_seq_no(tranEasyPaymentItem_O.getCom_seq_no());
            // 점코드
            tranEasyPaymentItem_N.setCom_st_code(tranEasyPaymentItem_O.getCom_st_code());
            // 포스번호
            tranEasyPaymentItem_N.setCom_tm_no(tranEasyPaymentItem_O.getCom_tm_no());
            // 캐셔번호
            tranEasyPaymentItem_N.setCom_casher_no(tranEasyPaymentItem_O.getCom_casher_no());
            // CD 일련번호
            tranEasyPaymentItem_N.setCom_chit_no(tranEasyPaymentItem_O.getCom_chit_no());
            // POS거래번호
            tranEasyPaymentItem_N.setCom_tran_no(tranEasyPaymentItem_O.getCom_tran_no());
            // 요청자 고유정보
            tranEasyPaymentItem_N.setCom_req_man_no(tranEasyPaymentItem_O.getCom_req_man_no());
            // 영업일자
            tranEasyPaymentItem_N.setCom_auth_date(tranEasyPaymentItem_O.getCom_auth_date());
            // 영업시간
            tranEasyPaymentItem_N.setCom_auth_time(tranEasyPaymentItem_O.getCom_auth_time());
            // 전문전송일자
            tranEasyPaymentItem_N.setCom_send_date(tranEasyPaymentItem_O.getCom_send_date());
            // 전문전송시간
            tranEasyPaymentItem_N.setCom_send_time(tranEasyPaymentItem_O.getCom_send_time());
            // ITEM 순번
            tranEasyPaymentItem_N.setCom_item_seq(tranEasyPaymentItem_O.getCom_item_seq());
            // 거래고유번호
            tranEasyPaymentItem_N.setRETRIEVAL_NO(tranEasyPaymentItem_O.getRETRIEVAL_NO());
            // 단말기아이디
            tranEasyPaymentItem_N.setCAT_ID(tranEasyPaymentItem_O.getCAT_ID());
            // 사업자번호
            tranEasyPaymentItem_N.setBUZ_NO(tranEasyPaymentItem_O.getBUZ_NO());
            // 가맹점아이디(TID)
            tranEasyPaymentItem_N.setMER_ID(tranEasyPaymentItem_O.getMER_ID());
            // 가맹점비밀번호
            tranEasyPaymentItem_N.setMER_PASSWORD(tranEasyPaymentItem_O.getMER_PASSWORD());
            // 예비
            tranEasyPaymentItem_N.setHEADER_FILLER(tranEasyPaymentItem_O.getHEADER_FILLER());
            // 결제타입
            tranEasyPaymentItem_N.setPAYMENT_TYPE(tranEasyPaymentItem_O.getPAYMENT_TYPE());
            // 단말기구분
            tranEasyPaymentItem_N.setPOS_TYPE(tranEasyPaymentItem_O.getPOS_TYPE());
            // 통화코드
            tranEasyPaymentItem_N.setCURR_CODE(tranEasyPaymentItem_O.getCURR_CODE());
            // 메인결제수단
            tranEasyPaymentItem_N.setMAIN_PAY_TYPE(tranEasyPaymentItem_O.getMAIN_PAY_TYPE());
            // 복합결제여부
            tranEasyPaymentItem_N.setMULTI_PAY_YN(tranEasyPaymentItem_O.getMULTI_PAY_YN());
            // 바코드
            tranEasyPaymentItem_N.setBARCODE_NO(tranEasyPaymentItem_O.getBARCODE_NO());
            // 카드번호
            tranEasyPaymentItem_N.setETC_CARD_NO(tranEasyPaymentItem_O.getETC_CARD_NO());
            // 신세계포인트여부
            tranEasyPaymentItem_N.setISSHINSEGAE_POINT(tranEasyPaymentItem_O.getISSHINSEGAE_POINT());
            // 신세계포인트카드
            tranEasyPaymentItem_N.setSHINSEAGE_POINT_NO(tranEasyPaymentItem_O.getSHINSEAGE_POINT_NO());
            // 신세계포인트카드사용여부
            tranEasyPaymentItem_N.setSHINSEAGE_POINT_USE_YN(tranEasyPaymentItem_O.getSHINSEAGE_POINT_USE_YN());
            // 결제총금액
            tranEasyPaymentItem_N.setTOT_SALE_AMT(tranEasyPaymentItem_O.getTOT_SALE_AMT());
            // 할인금액
            tranEasyPaymentItem_N.setDISCOUNT_AMT(tranEasyPaymentItem_O.getDISCOUNT_AMT());
            // 결제요청금액
            tranEasyPaymentItem_N.setPURE_SALE_AMT(tranEasyPaymentItem_O.getPURE_SALE_AMT());
            // 보증금type
            tranEasyPaymentItem_N.setDEPOSIT_TYPE(tranEasyPaymentItem_O.getDEPOSIT_TYPE());
            // 보증금 금액
            tranEasyPaymentItem_N.setDEPOSIT_AMT(tranEasyPaymentItem_O.getDEPOSIT_AMT());
            // 면세상품금액
            tranEasyPaymentItem_N.setTAX_FREE_AMT(tranEasyPaymentItem_O.getTAX_FREE_AMT());
            // 과세상품금액
            tranEasyPaymentItem_N.setTAX_AMT(tranEasyPaymentItem_O.getTAX_AMT());
            // 영세상품금액
            tranEasyPaymentItem_N.setZERO_AMT(tranEasyPaymentItem_O.getZERO_AMT());
            // 봉사료
            tranEasyPaymentItem_N.setTIP_AMT(tranEasyPaymentItem_O.getTIP_AMT());
            // 증빙제외
            tranEasyPaymentItem_N.setEXCLUDE_AMT(tranEasyPaymentItem_O.getEXCLUDE_AMT());
            // 할인금액
            tranEasyPaymentItem_N.setRECV_DISCOUNT_AMT(tranEasyPaymentItem_O.getRECV_DISCOUNT_AMT());
            // 승인금액
            tranEasyPaymentItem_N.setRECV_AUTH_AMT(tranEasyPaymentItem_O.getRECV_AUTH_AMT());
            // 할부개월
            tranEasyPaymentItem_N.setINS_MON(tranEasyPaymentItem_O.getINS_MON());
            // 승인일자
            tranEasyPaymentItem_N.setAUTH_DATE(tranEasyPaymentItem_O.getAUTH_DATE());
            // 승인시간
            tranEasyPaymentItem_N.setAUTH_TIME(tranEasyPaymentItem_O.getAUTH_TIME());
            // 승인번호
            tranEasyPaymentItem_N.setAUTH_NO(tranEasyPaymentItem_O.getAUTH_NO());
            // VAN 승인일자
            tranEasyPaymentItem_N.setVAN_AUTH_DATE(tranEasyPaymentItem_O.getVAN_AUTH_DATE());
            // VAN 승인시간
            tranEasyPaymentItem_N.setVAN_AUTH_TIME(tranEasyPaymentItem_O.getVAN_AUTH_TIME());
            // VAN 승인번호
            tranEasyPaymentItem_N.setVAN_AUTH_NO(tranEasyPaymentItem_O.getVAN_AUTH_NO());
            // 원거래 승인일자
            tranEasyPaymentItem_N.setORG_SALE_DATE(tranEasyPaymentItem_O.getORG_SALE_DATE());
            // 원거래 승인시간
            tranEasyPaymentItem_N.setORG_AUTH_TIME(tranEasyPaymentItem_O.getORG_AUTH_TIME());
            // 원거래 승인번호
            tranEasyPaymentItem_N.setORG_AUTH_NO(tranEasyPaymentItem_O.getORG_AUTH_NO());
            // 원거래 고유번호
            tranEasyPaymentItem_N.setORG_RETRIEVAL_NO(tranEasyPaymentItem_O.getORG_RETRIEVAL_NO());
            // 매입사코드
            tranEasyPaymentItem_N.setBUY_FIRM_CODE(tranEasyPaymentItem_O.getBUY_FIRM_CODE());
            // 매입사명
            tranEasyPaymentItem_N.setBUY_FIRM_NM(tranEasyPaymentItem_O.getBUY_FIRM_NM());
            // 발급사코드
            tranEasyPaymentItem_N.setISSUE_FIRM_CODE(tranEasyPaymentItem_O.getISSUE_FIRM_CODE());
            // 발급사명
            tranEasyPaymentItem_N.setISSUE_FIRM_NM(tranEasyPaymentItem_O.getISSUE_FIRM_NM());
            // 사용가능금액
            tranEasyPaymentItem_N.setENABLE_AMT(tranEasyPaymentItem_O.getENABLE_AMT());
            // 카드BIN type
            tranEasyPaymentItem_N.setCARD_BIN_TYPE(tranEasyPaymentItem_O.getCARD_BIN_TYPE());
            // 카드BIN 번호
            tranEasyPaymentItem_N.setCARD_BIN_NO(tranEasyPaymentItem_O.getCARD_BIN_NO());
            // 대표상품코드
            tranEasyPaymentItem_N.setMD_CODE(tranEasyPaymentItem_O.getMD_CODE());

            // 사업영역코드
            // SUBSTR(FILLER, 1, 4)
            // 상품 아이템꺼 갖다 씀 : tranGoodsItemBizRelmCd
            // tranEasyPaymentItem_N.setBIZ_RELM_CD(ParseHelper.getLpadFillSpaceStringForNewTran(tranEasyPaymentItem_N,
            // "BIZ_RELM_CD", tranEasyPaymentItem_O.getFILLER().substring(1, 1 +
            // 4)));
            tranEasyPaymentItem_N.setBIZ_RELM_CD(ParseHelper.getLpadFillSpaceStringForNewTran(tranEasyPaymentItem_N,
                    "BIZ_RELM_CD", tranGoodsItemBizRelmCd));

            // 상품명
            tranEasyPaymentItem_N.setMD_NM(tranEasyPaymentItem_O.getMD_NM());
            // 승인기관
            tranEasyPaymentItem_N.setVAN_CLSS(tranEasyPaymentItem_O.getVAN_CLSS());
            // 신용/체크 구분자
            tranEasyPaymentItem_N.setCHECK_CLSS(tranEasyPaymentItem_O.getCHECK_CLSS());
            // 도서/공연비 여부
            tranEasyPaymentItem_N.setMUNHWA_FLAG(tranEasyPaymentItem_O.getMUNHWA_FLAG());
            // 청구할인 여부
            tranEasyPaymentItem_N.setEDI_DSCNT_FLAG(tranEasyPaymentItem_O.getEDI_DSCNT_FLAG());
            // 멀티가맹점 구분
            tranEasyPaymentItem_N.setMULTI_CARD_MEMBER_STORE(tranEasyPaymentItem_O.getMULTI_CARD_MEMBER_STORE());
            // 응답코드
            tranEasyPaymentItem_N.setRESP_CODE(tranEasyPaymentItem_O.getRESP_CODE());
            // 응답메시지
            tranEasyPaymentItem_N.setPOS_MSG(tranEasyPaymentItem_O.getPOS_MSG());
            // 마스킹된 결제수단번호
            tranEasyPaymentItem_N.setMASKING_NO(tranEasyPaymentItem_O.getMASKING_NO());
            // 클럽 여부
            tranEasyPaymentItem_N.setISCLUB(tranEasyPaymentItem_O.getISCLUB());
            // 회원번호
            tranEasyPaymentItem_N.setMEMBER_NO(tranEasyPaymentItem_O.getMEMBER_NO());
            // 임직원여부
            tranEasyPaymentItem_N.setISEMPLOYEE(tranEasyPaymentItem_O.getISEMPLOYEE());
            // 임직원 사원증번호
            tranEasyPaymentItem_N.setISEMPLOYEE_CARD_NO(tranEasyPaymentItem_O.getISEMPLOYEE_CARD_NO());

            // 필러 (139->135)
            tranEasyPaymentItem_N
                    .setFILLER(ParseHelper.getLpadFillSpaceStringForNewTran(tranEasyPaymentItem_N, "FILLER", ""));

            if(ret == 0){
                compTranData.getTran_EasyPaymentItem().add(tranEasyPaymentItem_N);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 수표 아이템 ("16", "E4")
     * 
     * @return
     */
    public int parseTranSupyoItem(int itemLength){
        int ret = -1;

        try{
            // 구 트란 파싱
            TranSupyoItemO tranSupyoItem_O = new TranSupyoItemO();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranSupyoItem_O, 0, 0, false, false);

            // 신 트란 생성
            TranSupyoItemN tranSupyoItem_N = new TranSupyoItemN();

            // 신 트란 아이템코드
            tranSupyoItem_N.setItemCode(EnmTranItemCodeWrap.Tran_SupyoItem.getItemCode_N());
            // 신 트란 아이템길이
            tranSupyoItem_N.setItemLength(String.format("%04d", EnmTranItemCodeWrap.Tran_SupyoItem.getItemCodeLen_N()));

            // 아이템Seqno
            tranSupyoItem_N.setItemSeqNo(tranSupyoItem_O.getItemSeqNo());
            // 수표번호
            tranSupyoItem_N.setCheckNo(tranSupyoItem_O.getCheckNo());
            // 발행점코드
            tranSupyoItem_N.setBankCode(tranSupyoItem_O.getBankCode());
            // 발행일자
            tranSupyoItem_N.setIssueDate(tranSupyoItem_O.getIssueDate());
            // 권종코드
            tranSupyoItem_N.setAmountCode(tranSupyoItem_O.getAmountCode());
            // 수표계좌일련번호
            tranSupyoItem_N.setAccountSeqNo(tranSupyoItem_O.getAccountSeqNo());
            // 액면금액
            tranSupyoItem_N.setFaceAmount(tranSupyoItem_O.getFaceAmount());

            // 수표 현금 거스름
            if(compTranData.getTran_CashItem().size() > 0){
                TranCashItemN tranCashItemN = compTranData.getTran_CashItem().get(0);
                int nChangeO = 0;
                try{
                    nChangeO = ParseHelper.convStrToInt(tranCashItemN.getChange().trim());
                }catch(Exception e){
                }

                int nAmountO = 0;
                try{
                    nAmountO = ParseHelper.convStrToInt(tranCashItemN.getAmount().trim());
                }catch(Exception e){
                }

                int nFaceAmount = 0;
                try{
                    nFaceAmount = ParseHelper.convStrToInt(tranSupyoItem_N.getFaceAmount().trim());
                }catch(Exception e){
                }

                if("01".equals(tranCashItemN.getCashType()) && nChangeO > 0 && (nChangeO + nAmountO == nFaceAmount)){
                    tranSupyoItem_N
                            .setCashChange(ParseHelper.getLpadFillZeroString(tranCashItemN.getChange().trim(), 10));
                }else{
                    tranSupyoItem_N.setCashChange(
                            ParseHelper.getLpadFillZeroStringForNewTran(tranSupyoItem_N, "CashChange", "0"));
                }
            }else{
                tranSupyoItem_N
                        .setCashChange(ParseHelper.getLpadFillZeroStringForNewTran(tranSupyoItem_N, "CashChange", "0"));
            }

            // 예비
            tranSupyoItem_N.setFiller(ParseHelper.getLpadFillSpaceStringForNewTran(tranSupyoItem_N, "Filler", ""));

            if(ret == 0){
                compTranData.getTran_SupyoItem().add(tranSupyoItem_N);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 신백머니 아이템 ("77", "E8")
     * 
     * @return
     */
    public int parseTranShinBaekMoneyItem(int itemLength){
        int ret = -1;

        try{
            // 구 트란 파싱
            TranShinBaekMoneyItemO tranShinBaekMoneyItem_O = new TranShinBaekMoneyItemO();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranShinBaekMoneyItem_O, 0, 0, false, false);

            // 신 트란 생성
            TranShinBaekMoneyItemN tranShinBaekMoneyItem_N = new TranShinBaekMoneyItemN();

            // 신 트란 아이템코드
            tranShinBaekMoneyItem_N.setItemCode(EnmTranItemCodeWrap.Tran_ShinBaekMoneyItem.getItemCode_N());
            // 신 트란 아이템길이
            tranShinBaekMoneyItem_N.setItemLength(
                    String.format("%04d", EnmTranItemCodeWrap.Tran_ShinBaekMoneyItem.getItemCodeLen_N()));

            // -----------------------------------------------------------------------------------------------------------
            // CommHeader
            // TEXT ID - 대외기관 코드
            tranShinBaekMoneyItem_N.setCom_id_1(tranShinBaekMoneyItem_O.getCom_id_1());
            // TEXT ID - 대외기간 상세코드
            tranShinBaekMoneyItem_N.setCom_id_2(tranShinBaekMoneyItem_O.getCom_id_2());
            // TEXT ID - 전문구분
            tranShinBaekMoneyItem_N.setCom_id_3(tranShinBaekMoneyItem_O.getCom_id_3());
            // 전문길이
            tranShinBaekMoneyItem_N.setCom_len(tranShinBaekMoneyItem_O.getCom_len());
            // 전문일련번호
            tranShinBaekMoneyItem_N.setCom_seq_no(tranShinBaekMoneyItem_O.getCom_seq_no());
            // 점코드
            tranShinBaekMoneyItem_N.setCom_st_code(tranShinBaekMoneyItem_O.getCom_st_code());
            // 포스번호
            tranShinBaekMoneyItem_N.setCom_tm_no(tranShinBaekMoneyItem_O.getCom_tm_no());
            // 캐셔번호
            tranShinBaekMoneyItem_N.setCom_casher_no(tranShinBaekMoneyItem_O.getCom_casher_no());
            // 일련번호
            tranShinBaekMoneyItem_N.setCom_chit_no(tranShinBaekMoneyItem_O.getCom_chit_no());
            // POS거래번호
            tranShinBaekMoneyItem_N.setCom_tran_no(tranShinBaekMoneyItem_O.getCom_tran_no());
            // 요청자 고유정보
            tranShinBaekMoneyItem_N.setCom_req_man_no(tranShinBaekMoneyItem_O.getCom_req_man_no());
            // 영업일자
            tranShinBaekMoneyItem_N.setCom_auth_date(tranShinBaekMoneyItem_O.getCom_auth_date());
            // 영업시간
            tranShinBaekMoneyItem_N.setCom_auth_time(tranShinBaekMoneyItem_O.getCom_auth_time());
            // 전문전송일자
            tranShinBaekMoneyItem_N.setCom_send_date(tranShinBaekMoneyItem_O.getCom_send_date());
            // 전문전송시간
            tranShinBaekMoneyItem_N.setCom_send_time(tranShinBaekMoneyItem_O.getCom_send_time());

            // -----------------------------------------------------------------------------------------------------------
            // Header
            // 전문길이
            tranShinBaekMoneyItem_N.setMSG_LEN(tranShinBaekMoneyItem_O.getMSG_LEN());
            // 전문 ID
            tranShinBaekMoneyItem_N.setMSG_ID(tranShinBaekMoneyItem_O.getMSG_ID());
            // 전문전송일자
            tranShinBaekMoneyItem_N.setMCH_SEND_DATE(tranShinBaekMoneyItem_O.getMCH_SEND_DATE());
            // 전송 거래 고유번호
            tranShinBaekMoneyItem_N.setMCHH_SEND_UNIQ_NO(tranShinBaekMoneyItem_O.getMCHH_SEND_UNIQ_NO());
            // 가맹점번호
            tranShinBaekMoneyItem_N.setGIFT_MCH_NO(tranShinBaekMoneyItem_O.getGIFT_MCH_NO());
            // 요청구분
            tranShinBaekMoneyItem_N.setMSG_GUBUN(tranShinBaekMoneyItem_O.getMSG_GUBUN());
            // 회사코드
            tranShinBaekMoneyItem_N.setSER_COM_CD(tranShinBaekMoneyItem_O.getSER_COM_CD());
            // 영업일자
            tranShinBaekMoneyItem_N.setSALE_DATE(tranShinBaekMoneyItem_O.getSALE_DATE());
            // 영업시간
            tranShinBaekMoneyItem_N.setSALE_TIME(tranShinBaekMoneyItem_O.getSALE_TIME());
            // 점코드
            tranShinBaekMoneyItem_N.setST_CODE(tranShinBaekMoneyItem_O.getST_CODE());
            // 포스 번호
            tranShinBaekMoneyItem_N.setTM_NO(tranShinBaekMoneyItem_O.getTM_NO());
            // CD 번호
            tranShinBaekMoneyItem_N.setCD_NO(tranShinBaekMoneyItem_O.getCD_NO());
            // 거래 번호
            tranShinBaekMoneyItem_N.setTRAN_NO(tranShinBaekMoneyItem_O.getTRAN_NO());
            // Casher 번호
            tranShinBaekMoneyItem_N.setCASHER_NO(tranShinBaekMoneyItem_O.getCASHER_NO());
            // POS시스템일자
            tranShinBaekMoneyItem_N.setPOS_DATE(tranShinBaekMoneyItem_O.getPOS_DATE());
            // POS시스템시간
            tranShinBaekMoneyItem_N.setPOS_TIME(tranShinBaekMoneyItem_O.getPOS_TIME());
            // 점포서버 전문전송일자
            tranShinBaekMoneyItem_N.setJUMPO_SYS_DATE(tranShinBaekMoneyItem_O.getJUMPO_SYS_DATE());
            // 점포서버 전문전송시간
            tranShinBaekMoneyItem_N.setJUMPO_SYS_TIME(tranShinBaekMoneyItem_O.getJUMPO_SYS_TIME());
            // MD코드
            tranShinBaekMoneyItem_N.setSER_COM_UNIQ_NO(tranShinBaekMoneyItem_O.getSER_COM_UNIQ_NO());
            // 헤더예비필드
            tranShinBaekMoneyItem_N.setHEAD_ETC_FIELD(tranShinBaekMoneyItem_O.getHEAD_ETC_FIELD());

            // -----------------------------------------------------------------------------------------------------------
            // Data
            // 거래 TYPE
            tranShinBaekMoneyItem_N.setTRAN_TYPE(tranShinBaekMoneyItem_O.getTRAN_TYPE());
            // 요청 TYPE
            tranShinBaekMoneyItem_N.setTRADE_TYPE(tranShinBaekMoneyItem_O.getTRADE_TYPE());
            // GIFT 카드번호
            tranShinBaekMoneyItem_N.setGIFT_CARD_NO(tranShinBaekMoneyItem_O.getGIFT_CARD_NO());
            // GIFT 인증번호
            tranShinBaekMoneyItem_N.setGIFT_CONFIRM_NO(tranShinBaekMoneyItem_O.getGIFT_CONFIRM_NO());
            // KEY_IN 유무
            tranShinBaekMoneyItem_N.setKEY_IN_TYPE(tranShinBaekMoneyItem_O.getKEY_IN_TYPE());
            // 요청금액
            tranShinBaekMoneyItem_N.setTRADE_AMT(tranShinBaekMoneyItem_O.getTRADE_AMT());
            // 미수수료 구분
            tranShinBaekMoneyItem_N.setSPECIAL_GUBUN(tranShinBaekMoneyItem_O.getSPECIAL_GUBUN());
            // 사용구분
            tranShinBaekMoneyItem_N.setUSE_GUBUN(tranShinBaekMoneyItem_O.getUSE_GUBUN());
            // 권종코드
            tranShinBaekMoneyItem_N.setGIFT_CODE(tranShinBaekMoneyItem_O.getGIFT_CODE());
            // 원거래 회사코드
            tranShinBaekMoneyItem_N.setORG_SER_COM_CD(tranShinBaekMoneyItem_O.getORG_SER_COM_CD());
            // 원거래 영업일자
            tranShinBaekMoneyItem_N.setORG_SALE_DATE(tranShinBaekMoneyItem_O.getORG_SALE_DATE());
            // 원거래 점코드
            tranShinBaekMoneyItem_N.setORG_ST_CODE(tranShinBaekMoneyItem_O.getORG_ST_CODE());
            // 원거래 포스 번호
            tranShinBaekMoneyItem_N.setORG_TM_NO(tranShinBaekMoneyItem_O.getORG_TM_NO());
            // 원거래 거래 번호
            tranShinBaekMoneyItem_N.setORG_TRAN_NO(tranShinBaekMoneyItem_O.getORG_TRAN_NO());
            // 원거래 CD 번호
            tranShinBaekMoneyItem_N.setORG_CD_NO(tranShinBaekMoneyItem_O.getORG_CD_NO());
            // 원거래 전문전송일자
            tranShinBaekMoneyItem_N.setORG_SEND_DATE(tranShinBaekMoneyItem_O.getORG_SEND_DATE());
            // 원거래 전송거래 고유번호
            tranShinBaekMoneyItem_N.setORG_SEND_UNIQ_NO(tranShinBaekMoneyItem_O.getORG_SEND_UNIQ_NO());
            // 원거래 가맹점번호
            tranShinBaekMoneyItem_N.setORG_GIFT_MCH_NO(tranShinBaekMoneyItem_O.getORG_GIFT_MCH_NO());
            // 원거래 승인일자
            tranShinBaekMoneyItem_N.setORG_AUTH_DATE(tranShinBaekMoneyItem_O.getORG_AUTH_DATE());
            // 원거래 승인번호
            tranShinBaekMoneyItem_N.setORG_AUTH_NO(tranShinBaekMoneyItem_O.getORG_AUTH_NO());
            // 승인일자
            tranShinBaekMoneyItem_N.setAUTH_DATE(tranShinBaekMoneyItem_O.getAUTH_DATE());
            // 승인시간
            tranShinBaekMoneyItem_N.setAUTH_TIME(tranShinBaekMoneyItem_O.getAUTH_TIME());
            // 승인번호
            tranShinBaekMoneyItem_N.setAUTH_NO(tranShinBaekMoneyItem_O.getAUTH_NO());
            // 상품권잔액
            tranShinBaekMoneyItem_N.setREMAIN_AMT(tranShinBaekMoneyItem_O.getREMAIN_AMT());
            // 응답코드
            tranShinBaekMoneyItem_N.setRESP_CODE(tranShinBaekMoneyItem_O.getRESP_CODE());
            // 응답메시지
            tranShinBaekMoneyItem_N.setRESP_MSG(tranShinBaekMoneyItem_O.getRESP_MSG());
            // 통합플랫폼 바코드
            tranShinBaekMoneyItem_N.setDELEGATE_BARCODE_NO(tranShinBaekMoneyItem_O.getDELEGATE_BARCODE_NO());
            // 소득공제 신고유형
            tranShinBaekMoneyItem_N.setITD_RPT_TYPE(tranShinBaekMoneyItem_O.getITD_RPT_TYPE());
            // 소득공제 식별정보
            tranShinBaekMoneyItem_N.setITD_RPT_INFO(tranShinBaekMoneyItem_O.getITD_RPT_INFO());
            // 소득공제 제외금액
            tranShinBaekMoneyItem_N.setITD_EXCL_AMT(tranShinBaekMoneyItem_O.getITD_EXCL_AMT());
            // 현금영수증 신고 가능금액
            tranShinBaekMoneyItem_N.setCASH_RECEIPT_REPORT_AMT(tranShinBaekMoneyItem_O.getCASH_RECEIPT_REPORT_AMT());

            // 사업영역코드
            // SUBSTR(FILLER, 1, 4)
            // 상품 아이템꺼 갖다 씀 : tranGoodsItemBizRelmCd
            // tranShinBaekMoneyItem_N.setBIZ_RELM_CD(ParseHelper.getLpadFillSpaceStringForNewTran(tranShinBaekMoneyItem_N,
            // "BIZ_RELM_CD",
            // tranShinBaekMoneyItem_O.getDATA_ETC_FIELD().substring(1, 1 +
            // 4)));
            tranShinBaekMoneyItem_N.setBIZ_RELM_CD(ParseHelper.getLpadFillSpaceStringForNewTran(tranShinBaekMoneyItem_N,
                    "BIZ_RELM_CD", tranGoodsItemBizRelmCd));

            // DATA예비필드
            tranShinBaekMoneyItem_N.setDATA_ETC_FIELD(
                    ParseHelper.getLpadFillSpaceStringForNewTran(tranShinBaekMoneyItem_N, "DATA_ETC_FIELD", ""));

            // 전문 종료 내역
            tranShinBaekMoneyItem_N.setMSG_END(tranShinBaekMoneyItem_O.getMSG_END());

            if(ret == 0){
                compTranData.getTran_ShinBaekMoneyItem().add(tranShinBaekMoneyItem_N);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 기타결제 ("", "E5")
     * 
     * @return
     */
    public int makeTranEtcPayItem(){
        int ret = -1;

        try{
            // 신 트란 생성
            TranEtcPayItemC tranEtcPayItem_C = new TranEtcPayItemC();

            // 신 트란 아이템코드
            tranEtcPayItem_C.setItemCode(EnmTranItemCodeWrap.Tran_EtcPayItem.getItemCode_N());
            // 신 트란 아이템길이
            tranEtcPayItem_C
                    .setItemLength(String.format("%04d", EnmTranItemCodeWrap.Tran_EtcPayItem.getItemCodeLen_N()));

            // 결제코드
            tranEtcPayItem_C.setEtcPayCode("");

            // 결제금액
            tranEtcPayItem_C.setAmount("");

            // 예비
            tranEtcPayItem_C.setFiller(ParseHelper.getLpadFillSpaceStringForNewTran(tranEtcPayItem_C, "Filler", ""));

            compTranData.getTran_EtcPayItem().add(tranEtcPayItem_C);
            ret = 0;
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 사용매출 특판(점포,법인) ("", "E6")
     * 
     * @return
     */
    public int makeTranUseSaleSpecialItem(){
        int ret = -1;

        try{
            // 신 트란 생성
            TranUseSaleSpecialItemC tranUseSaleSpecialItem_C = new TranUseSaleSpecialItemC();

            // 신 트란 아이템코드
            tranUseSaleSpecialItem_C.setItemCode(EnmTranItemCodeWrap.Tran_UseSaleSpecialItem.getItemCode_N());
            // 신 트란 아이템길이
            tranUseSaleSpecialItem_C.setItemLength(
                    String.format("%04d", EnmTranItemCodeWrap.Tran_UseSaleSpecialItem.getItemCodeLen_N()));

            // 매출구분
            tranUseSaleSpecialItem_C.setItemType("");
            // 사원번호
            tranUseSaleSpecialItem_C.setEmpNo("");
            // 전표번호
            tranUseSaleSpecialItem_C.setSlipNo("");
            // 매장코드
            tranUseSaleSpecialItem_C.setShopCode("");
            // 판매금액
            tranUseSaleSpecialItem_C.setAmount("");
            // 예비
            tranUseSaleSpecialItem_C
                    .setFiller(ParseHelper.getLpadFillSpaceStringForNewTran(tranUseSaleSpecialItem_C, "Filler", ""));

            compTranData.getTran_UseSaleSpecialItem().add(tranUseSaleSpecialItem_C);
            ret = 0;
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 선수예약판매 ("", "E7")
     * 
     * @return
     */
    public int makeTranPreReservSaleItem(){
        int ret = -1;

        try{
            // 신 트란 생성
            TranPreReservSaleItemC tranPreReservSaleItem_C = new TranPreReservSaleItemC();

            // 신 트란 아이템코드
            tranPreReservSaleItem_C.setItemCode(EnmTranItemCodeWrap.Tran_PreReservSaleItem.getItemCode_N());
            // 신 트란 아이템길이
            tranPreReservSaleItem_C.setItemLength(
                    String.format("%04d", EnmTranItemCodeWrap.Tran_PreReservSaleItem.getItemCodeLen_N()));

            // 전표번호
            tranPreReservSaleItem_C.setSlipNo("");
            // 계약금
            tranPreReservSaleItem_C.setContractAmount("");
            // 계약금에누리금액
            tranPreReservSaleItem_C.setContractEnuriAmount("");
            // 계약금순매출금액
            tranPreReservSaleItem_C.setContractNetAmount("");
            // 계약금에누리구분
            tranPreReservSaleItem_C.setDiscountFlag("");
            // 계약금에누리율
            tranPreReservSaleItem_C.setDiscountRate("");
            // 예비
            tranPreReservSaleItem_C
                    .setFiller(ParseHelper.getLpadFillSpaceStringForNewTran(tranPreReservSaleItem_C, "Filler", ""));

            compTranData.getTran_PreReservSaleItem().add(tranPreReservSaleItem_C);
            ret = 0;
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 권유자(퍼스널쇼퍼) ("", "E9")
     * 
     * @return
     */
    public int makeTranRecommanderItem(){
        int ret = -1;

        try{
            // 신 트란 생성
            TranRecommanderItemC tranRecommanderItem_C = new TranRecommanderItemC();

            // 신 트란 아이템코드
            tranRecommanderItem_C.setItemCode(EnmTranItemCodeWrap.Tran_RecommanderItem.getItemCode_N());
            // 신 트란 아이템길이
            tranRecommanderItem_C
                    .setItemLength(String.format("%04d", EnmTranItemCodeWrap.Tran_RecommanderItem.getItemCodeLen_N()));

            // 구분
            tranRecommanderItem_C.setItemType("");
            // 사번
            tranRecommanderItem_C.setEmpNo("");
            // 예비
            tranRecommanderItem_C
                    .setFiller(ParseHelper.getLpadFillSpaceStringForNewTran(tranRecommanderItem_C, "Filler", ""));

            compTranData.getTran_RecommanderItem().add(tranRecommanderItem_C);
            ret = 0;
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 마일리지자동적립 ("", "EA")
     * 
     * @return
     */
    public int makeTranMileageAutoSaveItem(){
        int ret = -1;

        try{
            // 신 트란 생성
            TranMileageAutoSaveItemC tranMileageAutoSaveItem_C = new TranMileageAutoSaveItemC();

            // 신 트란 아이템코드
            tranMileageAutoSaveItem_C.setItemCode(EnmTranItemCodeWrap.Tran_RecommanderItem.getItemCode_N());
            // 신 트란 아이템길이
            tranMileageAutoSaveItem_C
                    .setItemLength(String.format("%04d", EnmTranItemCodeWrap.Tran_RecommanderItem.getItemCodeLen_N()));

            // 고객CUSTID
            tranMileageAutoSaveItem_C.setCustId("");
            // 행사관리년월
            tranMileageAutoSaveItem_C.setEvnMngYm("");
            // 행사관리번호
            tranMileageAutoSaveItem_C.setEvnMngNo("");
            // 금회적립 예상 마일리지
            tranMileageAutoSaveItem_C.setMlgPoint("");
            // 예비
            tranMileageAutoSaveItem_C
                    .setFiller(ParseHelper.getLpadFillSpaceStringForNewTran(tranMileageAutoSaveItem_C, "Filler", ""));

            compTranData.getTran_MileageAutoSaveItem().add(tranMileageAutoSaveItem_C);
            ret = 0;
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 비대면 주문 ("", "EB")
     * 
     * @return
     */
    public int makeTranUntactAccountItem(){
        int ret = -1;

        try{
            // 신 트란 생성
            TranUntactAccountItemC tranUntactAccountItem_C = new TranUntactAccountItemC();

            // 신 트란 아이템코드
            tranUntactAccountItem_C.setItemCode(EnmTranItemCodeWrap.Tran_UntactAccountItem.getItemCode_N());
            // 신 트란 아이템길이
            tranUntactAccountItem_C.setItemLength(
                    String.format("%04d", EnmTranItemCodeWrap.Tran_UntactAccountItem.getItemCodeLen_N()));

            // 고객휴대폰번호
            tranUntactAccountItem_C.setCustHpNo("");
            // 신세계포인트고객ID
            tranUntactAccountItem_C.setSPointCustId("");
            // 신세계포인트카드번호
            tranUntactAccountItem_C.setSPointCardNo("");
            // 점포명
            tranUntactAccountItem_C.setStrName("");
            // 매장명
            tranUntactAccountItem_C.setShopName("");
            // 대표상품명
            tranUntactAccountItem_C.setItemNm("");
            // 총결제금액
            tranUntactAccountItem_C.setTotalPay("");
            // 예비
            tranUntactAccountItem_C
                    .setFiller(ParseHelper.getLpadFillSpaceStringForNewTran(tranUntactAccountItem_C, "Filler", ""));

            compTranData.getTran_UntactAccountItem().add(tranUntactAccountItem_C);
            ret = 0;
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 비대면 결제 ("", "EC")
     * 
     * @return
     */
    public int makeTranUntactCardItem(){
        int ret = -1;

        try{
            // 신 트란 생성
            TranUntactCardItemC tranUntactCardItem_C = new TranUntactCardItemC();

            // 신 트란 아이템코드
            tranUntactCardItem_C.setItemCode(EnmTranItemCodeWrap.Tran_UntactCardItem.getItemCode_N());
            // 신 트란 아이템길이
            tranUntactCardItem_C
                    .setItemLength(String.format("%04d", EnmTranItemCodeWrap.Tran_UntactCardItem.getItemCodeLen_N()));

            // 비대면 주문일자
            tranUntactCardItem_C.setContactlessOrdDate("");
            // 비대면 주문 POS번호
            tranUntactCardItem_C.setContactlessOrdPosNo("");
            // 비대면 주문 TRAN번호
            tranUntactCardItem_C.setContactlessOrdTranNo("");
            // 매장명
            tranUntactCardItem_C.setShopName("");
            // 예비
            tranUntactCardItem_C
                    .setFiller(ParseHelper.getLpadFillSpaceStringForNewTran(tranUntactCardItem_C, "Filler", ""));

            compTranData.getTran_UntactCardItem().add(tranUntactCardItem_C);
            ret = 0;
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * PDA중간입금 아이템 ("05", "05")
     * 
     * @param itemLengthN
     * @return
     */
    public int parseTranMidPdaAmtItem(int itemLength){
        int ret = -1;

        try{
            TranMidPdaAmtItem tranMidPdaAmtItem = new TranMidPdaAmtItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranMidPdaAmtItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_MidPdaAmtItem().add(tranMidPdaAmtItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 시코르 클럽 세일리지 ("71", "71")
     * 
     * @param itemLengthN
     * @return
     */
    public int parseTranChicorClubItem(int itemLength){
        int ret = -1;

        try{
            TranChicorClubItem tranChicorClubItem = new TranChicorClubItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranChicorClubItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_ChicorClubItem().add(tranChicorClubItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 캐시터미널 사용매출출금 ("76", "76")
     * 
     * @param itemLengthN
     * @return
     */
    public int parseTranCashTerUseSaleItem(int itemLength){
        int ret = -1;

        try{
            TranCashTerUseSaleItem tranCashTerUseSaleItem = new TranCashTerUseSaleItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranCashTerUseSaleItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_CashTerUseSaleItem().add(tranCashTerUseSaleItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 특정매입 단품세트 구성상품 아이템 ("56", "56")
     * 
     * @param itemLengthN
     * @return
     */
    public int parseTranSetItem(int itemLength){
        int ret = -1;

        try{
            TranSetItem tranSetItem = new TranSetItem();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranSetItem, 0, 0, false, false);

            if(ret == 0){
                compTranData.getTran_SetItem().add(tranSetItem);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 페이코인 아이템 ("58", "58")
     * 
     * @param itemLengthN
     * @return
     */
    public int parseTranPaycoinItem(int itemLength){
        int ret = -1;

        try{
            // 구 트란 파싱
            TranPaycoinItemO tranPaycoinItemO = new TranPaycoinItemO();
            ret = ParseHelper.tranMapToObj(getTranDataOBytes(), offSet, tranPaycoinItemO, 0, 0, false, false);

            // 신 트란 생성
            TranPaycoinItemN tranPaycoinItemN = new TranPaycoinItemN();

            // 신 트란 아이템코드
            tranPaycoinItemN.setItemCode(EnmTranItemCodeWrap.Tran_PaycoinItem.getItemCode_N());
            // 신 트란 아이템길이
            tranPaycoinItemN
                    .setItemLength(String.format("%04d", EnmTranItemCodeWrap.Tran_PaycoinItem.getItemCodeLen_N()));
            // Text ID
            tranPaycoinItemN.setTextId(tranPaycoinItemO.getTextId());
            // 점포코드
            tranPaycoinItemN.setStoreNo(tranPaycoinItemO.getStoreNo());
            // POS번호
            tranPaycoinItemN.setPosNo(tranPaycoinItemO.getPosNo());
            // 담당자번호
            tranPaycoinItemN.setCashierNo(tranPaycoinItemO.getCashierNo());
            // CD 일련번호
            tranPaycoinItemN.setChitNo(tranPaycoinItemO.getChitNo());
            // POS 거래번호
            tranPaycoinItemN.setTranNo(tranPaycoinItemO.getTranNo());
            // 영업일자
            tranPaycoinItemN.setSaleDate(tranPaycoinItemO.getSaleDate());
            // 아이템시퀀스
            tranPaycoinItemN.setItemSeq(tranPaycoinItemO.getItemSeq());
            // 요청구분
            tranPaycoinItemN.setCommandType(tranPaycoinItemO.getCommandType());
            // 바코드번호
            tranPaycoinItemN.setBarcodeNo(tranPaycoinItemO.getBarcodeNo());
            // 가맹점번호
            tranPaycoinItemN.setMerNo(tranPaycoinItemO.getMerNo());
            // 가맹점 비밀번호
            tranPaycoinItemN.setMerPassword(tranPaycoinItemO.getMerPassword());
            // 상품코드(itemcode)
            tranPaycoinItemN.setSKUCode(tranPaycoinItemO.getSKUCode());
            // 상품명
            tranPaycoinItemN.setSKUName(tranPaycoinItemO.getSKUName());
            // 가맹점 거래번호
            tranPaycoinItemN.setMerSaleNo(tranPaycoinItemO.getMerSaleNo());
            // 결제금액
            tranPaycoinItemN.setSaleAmount(tranPaycoinItemO.getSaleAmount());
            // 결제수단 코드
            tranPaycoinItemN.setPayCode(tranPaycoinItemO.getPayCode());
            // 응답코드
            tranPaycoinItemN.setRespCode(tranPaycoinItemO.getRespCode());
            // 응답메세지
            tranPaycoinItemN.setRespMsg(tranPaycoinItemO.getRespMsg());
            // 거래 ID
            tranPaycoinItemN.setSaleTID(tranPaycoinItemO.getSaleTID());
            // 취소거래 ID
            tranPaycoinItemN.setCnclTID(tranPaycoinItemO.getCnclTID());
            // 취소 후 한도 잔액
            tranPaycoinItemN.setCnclBalance(tranPaycoinItemO.getCnclBalance());
            // 취소 원거래 일자
            tranPaycoinItemN.setOrgSaleData(tranPaycoinItemO.getOrgSaleData());
            // Reserved Field 1
            tranPaycoinItemN.setMsgReserved1(tranPaycoinItemO.getMsgReserved1());
            // Reserved Field 2
            tranPaycoinItemN.setMsgReserved2(tranPaycoinItemO.getMsgReserved2());
            // SID_MERCHANT 사용 여부
            tranPaycoinItemN.setSIdUseFlag(tranPaycoinItemO.getSIdUseFlag());
            // 하부 가맹점
            tranPaycoinItemN.setSIdMer(tranPaycoinItemO.getSIdMer());
            // 할부개월
            tranPaycoinItemN.setInsMonth(tranPaycoinItemO.getInsMonth());
            // 할인금액
            tranPaycoinItemN.setDiscountAmount(tranPaycoinItemO.getDiscountAmount());
            // 1회용컵 보증금 금액
            tranPaycoinItemN.setCupAmount(tranPaycoinItemO.getCupAmount());
            // MD코드
            tranPaycoinItemN.setMDCode(tranPaycoinItemO.getMDCode());

            // 사업영역코드
            // 상품 아이템꺼 갖다 씀 : tranGoodsItemBizRelmCd
            Map<String, Object> paramMap = new HashMap<>();

            nDebugFlag = 3;
            // tranPaycoinItemN
            // .setBIZ_RELM_CD(queryProc.selectTranCashTerAmtItemDXShopCd(paramMap,
            // sTranInfo, logParamMap));
            // tranPaycoinItemN
            // .setBIZ_RELM_CD(ParseHelper.getLpadFillSpaceStringForNewTran(tranPaycoinItemN,
            // "BIZ_RELM_CD", ""));
            tranPaycoinItemN.setBIZ_RELM_CD(ParseHelper.getLpadFillSpaceStringForNewTran(tranPaycoinItemN,
                    "BIZ_RELM_CD", tranGoodsItemBizRelmCd));
            nDebugFlag = 0;

            // 예비
            tranPaycoinItemN.setFiller(ParseHelper.getLpadFillSpaceStringForNewTran(tranPaycoinItemN, "Filler", ""));

            if(ret == 0){
                compTranData.getTran_PaycoinItem().add(tranPaycoinItemN);
            }
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    /**
     * 트란 전문 json 변환
     */
    public int makeJsonTran(){
        int ret = -1;

        try{
            jsonTran = JsonUtil.getMapper().writeValueAsString(compTranData);
            // log.debug(JsonUtil.getMapper().writerWithDefaultPrettyPrinter().writeValueAsString(compTranData));
            // log.info(JsonUtil.getMapper().writerWithDefaultPrettyPrinter().writeValueAsString(compTranData));

            ret = 0;
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }

    public int makeCommHeader(){
        int ret = -1;

        try{
            // 메시지길이
            // compTranData.getCOMM_HEADER().setMsgLength();
            // 메시지경로
            compTranData.getCOMM_HEADER().setMsgPath("SM");
            // 메시지타입 01: 트란, 02: IRT
            compTranData.getCOMM_HEADER().setMsgType("01");
            // 메시지종류 Default : 00
            compTranData.getCOMM_HEADER().setMsgKind("00");
            // 영업일자
            compTranData.getCOMM_HEADER().setSaleDate(compTranData.getTran_Header_O().getSaleDate());
            // 점코드
            compTranData.getCOMM_HEADER().setStoreNo(compTranData.getTran_Header_O().getStoreNo());
            // POS번호
            compTranData.getCOMM_HEADER().setPosNo(compTranData.getTran_Header_O().getPosNo());
            // 거래번호
            compTranData.getCOMM_HEADER().setTranNo(compTranData.getTran_Header_O().getTranNo());
            // 시스템날짜
            compTranData.getCOMM_HEADER().setSendDate(compTranData.getTran_Header_O().getSysDate());
            // 시스템시간
            compTranData.getCOMM_HEADER().setSendTime(compTranData.getTran_Header_O().getSysTime());
            // 新점포코드
            compTranData.getCOMM_HEADER().setExtStoreNo(compTranData.getTran_Header_O().getStoreNo() + " ");
            // 교육모드
            compTranData.getCOMM_HEADER().setTrainMode(" ");
            // 신/구전문구분
            compTranData.getCOMM_HEADER().setVersionFlag("A");
            // 사용자 정보
            compTranData.getCOMM_HEADER().setUserInfo(
                    IrtParseUtil.getLpadFillSpaceStringForTgFld(compTranData.getCOMM_HEADER(), "UserInfo", ""));
            // 응답코드
            compTranData.getCOMM_HEADER().setReplyCode("0000");

            ret = 0;
        }catch(Exception e){
            log.error(e.toString());
            ret = -1;
        }

        return ret;
    }
}
