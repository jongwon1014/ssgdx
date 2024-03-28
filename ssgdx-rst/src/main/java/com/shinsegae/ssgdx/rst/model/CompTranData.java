package com.shinsegae.ssgdx.rst.model;

import java.util.ArrayList;
import java.util.List;

import com.shinsegae.ssgdx.rst.model.comtr.ComHeader;
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
import com.shinsegae.ssgdx.rst.model.oldtr.TranHeaderO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CompTranData {

    @JsonProperty("COMM_HEADER")
    private ComHeader COMM_HEADER = new ComHeader(); // 통신 헤더

    @JsonIgnore
    private TranHeaderO Tran_Header_O = new TranHeaderO(); // 구 트란 헤더

    @JsonProperty("Tran_Header")
    private TranHeaderN Tran_Header_N = new TranHeaderN(); // 신 트란 헤더

    // -------------------------------------------------------------------------------------
    // 거래 트란 선언
    // ----------------------- < 유지 >
    @JsonProperty("Tran_CashBillItem")
    private List<TranCashBillItem> Tran_CashBillItem = new ArrayList<TranCashBillItem>(); // "03","03","현금영수증아이템"

    @JsonProperty("Tran_GiftItem")
    private List<TranGiftItem> Tran_GiftItem = new ArrayList<TranGiftItem>(); // "12","12","상품권아이템"

    @JsonProperty("Tran_CardItem")
    private List<TranCardItem> Tran_CardItem = new ArrayList<TranCardItem>(); // "14","14","신용카드(MSR)아이템"

    @JsonProperty("Tran_GIFTCardItem")
    private List<TranGIFTCardItem> Tran_GIFTCardItem = new ArrayList<TranGIFTCardItem>(); // "18","18","전자상품권아이템"

    @JsonProperty("Tran_CurrencyItem")
    private List<TranCurrencyItem> Tran_CurrencyItem = new ArrayList<TranCurrencyItem>(); // "19","19","외화아이템"

    @JsonProperty("Tran_EMPItem")
    private List<TranEMPItem> Tran_EMPItem = new ArrayList<TranEMPItem>(); // "21","21","사원인증아이템"

    @JsonProperty("Tran_CashICItem")
    private List<TranCashICItem> Tran_CashICItem = new ArrayList<TranCashICItem>(); // "22","22","현금IC카드아이템"

    @JsonProperty("Tran_EventCancelItem")
    private List<TranEventCancelItem> Tran_EventCancelItem = new ArrayList<TranEventCancelItem>(); // "23","23","사은품취소아이템"

    @JsonProperty("Tran_SSGPayItem")
    private List<TranSSGPayItem> Tran_SSGPayItem = new ArrayList<TranSSGPayItem>(); // "24","24","통합플랫폼(SSGPAY)아이템"

    @JsonProperty("Tran_WeChatPayItem")
    private List<TranWeChatPayItem> Tran_WeChatPayItem = new ArrayList<TranWeChatPayItem>(); // "25","25","위챗페이거래ITEM"

    @JsonProperty("Tran_TaxRefundItem")
    private List<TranTaxRefundItem> Tran_TaxRefundItem = new ArrayList<TranTaxRefundItem>(); // "26","26","즉시환급거래ITEM"

    @JsonProperty("Tran_GiftScratchItem")
    private List<TranGiftScratchItem> Tran_GiftScratchItem = new ArrayList<TranGiftScratchItem>(); // "27","27","스크래치상품권아이템"

    @JsonProperty("Tran_GiftSaleItem")
    private List<TranGiftSaleItem> Tran_GiftSaleItem = new ArrayList<TranGiftSaleItem>(); // "28","28","상품권샵상품권판매/회수ITEM"

    @JsonProperty("Tran_GiftPmItem")
    private List<TranGiftPmItem> Tran_GiftPmItem = new ArrayList<TranGiftPmItem>(); // "29","29","상품권샵PM아이템"

    @JsonProperty("Tran_ReadyAmtItem")
    private List<TranReadyAmtItem> Tran_ReadyAmtItem = new ArrayList<TranReadyAmtItem>(); // "30","30","준비금아이템"

    @JsonProperty("Tran_GiftKioskOrgTranItem")
    private List<TranGiftKioskOrgTranItem> Tran_GiftKioskOrgTranItem = new ArrayList<TranGiftKioskOrgTranItem>(); // "31","31","상품권키오스크강제지급원거래ITEM"

    @JsonProperty("Tran_MidAmtItem")
    private List<TranMidAmtItem> Tran_MidAmtItem = new ArrayList<TranMidAmtItem>(); // "40","40","중간입금아이템"

    @JsonProperty("Tran_CashTerCommItem")
    private List<TranCashTerCommItem> Tran_CashTerCommItem = new ArrayList<TranCashTerCommItem>(); // "41","41","캐쉬터미널공통정보"

    @JsonProperty("Tran_CashTerErrorItem")
    private List<TranCashTerErrorItem> Tran_CashTerErrorItem = new ArrayList<TranCashTerErrorItem>(); // "42","42","캐쉬터미널장애상태정보"

    @JsonProperty("Tran_CashTerStartItem")
    private List<TranCashTerStartItem> Tran_CashTerStartItem = new ArrayList<TranCashTerStartItem>(); // "43","43","캐쉬터미널개국아이템"

    @JsonProperty("Tran_CashTerCashinItem")
    private List<TranCashTerCashinItem> Tran_CashTerCashinItem = new ArrayList<TranCashTerCashinItem>(); // "44","44","캐쉬터미널시재장입/회수아이템"

    @JsonProperty("Tran_CashTerGiftinItem")
    private List<TranCashTerGiftinItem> Tran_CashTerGiftinItem = new ArrayList<TranCashTerGiftinItem>(); // "45","45","캐쉬터미널시재회수-상품권아이템"

    @JsonProperty("Tran_CashTerCashItem")
    private List<TranCashTerCashItem> Tran_CashTerCashItem = new ArrayList<TranCashTerCashItem>(); // "46","46","캐쉬터미널정산기입출금시재아이템"

    @JsonProperty("Tran_CashTerCashrecvItem")
    private List<TranCashTerCashrecvItem> Tran_CashTerCashrecvItem = new ArrayList<TranCashTerCashrecvItem>(); // "47","47","캐쉬터미널정산기입금아이템"

    @JsonProperty("Tran_CashTerGiftrecvItem")
    private List<TranCashTerGiftrecvItem> Tran_CashTerGiftrecvItem = new ArrayList<TranCashTerGiftrecvItem>(); // "48","C2","캐쉬터미널상품권입금아이템"

    @JsonProperty("Tran_CashTerGiftSeqItem")
    private List<TranCashTerGiftSeqItem> Tran_CashTerGiftSeqItem = new ArrayList<TranCashTerGiftSeqItem>(); // "49","49","캐쉬터미널상품권일련번호아이템"

    @JsonProperty("Tran_CashTerInOutOrgItem")
    private List<TranCashTerInOutOrgItem> Tran_CashTerInOutOrgItem = new ArrayList<TranCashTerInOutOrgItem>(); // "50","50","캐쉬터미널입출금원거래정보아이템"

    @JsonProperty("Tran_ScoScaslupCntItem")
    private List<TranScoScaslupCntItem> Tran_ScoScaslupCntItem = new ArrayList<TranScoScaslupCntItem>(); // "52","52","SCO스캔저울증가횟수"

    @JsonProperty("Tran_ChicorOnOffItem")
    private List<TranChicorOnOffItem> Tran_ChicorOnOffItem = new ArrayList<TranChicorOnOffItem>(); // "55","55","시코르통합멤버십ITEM"

    @JsonProperty("Tran_ExchangeItem")
    private List<TranExchangeItem> Tran_ExchangeItem = new ArrayList<TranExchangeItem>(); // "63","63","교환거래ITEM"

    @JsonProperty("Tran_PointItem")
    private List<TranPointItem> Tran_PointItem = new ArrayList<TranPointItem>(); // "64","64","신세계포인트아이템"

    @JsonProperty("Tran_VipMileageItem")
    private List<TranVipMileageItem> Tran_VipMileageItem = new ArrayList<TranVipMileageItem>(); // "67","67","세일리지아이템"

    @JsonProperty("Tran_SSGConItem")
    private List<TranSSGConItem> Tran_SSGConItem = new ArrayList<TranSSGConItem>(); // "68","68","쓱콘아이템"

    @JsonProperty("Tran_MobileMmsItem")
    private List<TranMobileMmsItem> Tran_MobileMmsItem = new ArrayList<TranMobileMmsItem>(); // "74","74","모바일&신세계MMSITEM"

    @JsonProperty("Tran_ShinBaekRewardItem")
    private List<TranShinBaekRewardItem> Tran_ShinBaekRewardItem = new ArrayList<TranShinBaekRewardItem>(); // "78","78","리워드(보상형)아이템"

    @JsonProperty("Tran_ShinBaekRewardCouponItem")
    private List<TranShinBaekRewardCouponItem> Tran_ShinBaekRewardCouponItem = new ArrayList<TranShinBaekRewardCouponItem>(); // "79","79","리워드(쿠폰)아이템"

    @JsonProperty("Tran_GiftKioskCommItem")
    private List<TranGiftKioskCommItem> Tran_GiftKioskCommItem = new ArrayList<TranGiftKioskCommItem>(); // "81","81","상품권판매키오스크공통정보"

    @JsonProperty("Tran_GiftKioskErrorItem")
    private List<TranGiftKioskErrorItem> Tran_GiftKioskErrorItem = new ArrayList<TranGiftKioskErrorItem>(); // "82","82","상품권판매키오스크장애상태정보"

    @JsonProperty("Tran_GiftKioskStartItem")
    private List<TranGiftKioskStartItem> Tran_GiftKioskStartItem = new ArrayList<TranGiftKioskStartItem>(); // "83","83","상품권판매키오스크개국발생"

    @JsonProperty("Tran_GiftKioskInOutItem")
    private List<TranGiftKioskInOutItem> Tran_GiftKioskInOutItem = new ArrayList<TranGiftKioskInOutItem>(); // "84","84","상품권판매키오스크시재장입및회수"

    @JsonProperty("Tran_GiftKioskCalcItem")
    private List<TranGiftKioskCalcItem> Tran_GiftKioskCalcItem = new ArrayList<TranGiftKioskCalcItem>(); // "86","86","상품권판매키오스크정산기시재"

    @JsonProperty("Tran_GiftKioskGiftSeqItem")
    private List<TranGiftKioskGiftSeqItem> Tran_GiftKioskGiftSeqItem = new ArrayList<TranGiftKioskGiftSeqItem>(); // "89","89","상품권판매키오스크상품권일련번호"

    @JsonProperty("Tran_CalcItem")
    private List<TranCalcItem> Tran_CalcItem = new ArrayList<TranCalcItem>(); // "99","99","정산시재금아이템"

    @JsonProperty("Tran_MidPdaAmtItem")
    private List<TranMidPdaAmtItem> Tran_MidPdaAmtItem = new ArrayList<TranMidPdaAmtItem>(); // "05","05","PDA중간입금아이템"

    @JsonProperty("Tran_ChicorClubItem")
    private List<TranChicorClubItem> Tran_ChicorClubItem = new ArrayList<TranChicorClubItem>(); // "71","71","시코르클럽세일리지"

    @JsonProperty("Tran_CashTerUseSaleItem")
    private List<TranCashTerUseSaleItem> Tran_CashTerUseSaleItem = new ArrayList<TranCashTerUseSaleItem>(); // "76","76","캐시터미널사용매출출금"

    @JsonProperty("Tran_SetItem")
    private List<TranSetItem> Tran_SetItem = new ArrayList<TranSetItem>(); // "56","56","특정매입단품세트구성상품아이템"

    // ----------------------- < 변경 >
    @JsonProperty("Tran_CashItem")
    private List<TranCashItemN> Tran_CashItem = new ArrayList<TranCashItemN>(); // "11","11","현금성아이템"

    @JsonProperty("Tran_DepositItem")
    private List<TranDepositItem> Tran_DepositItem = new ArrayList<TranDepositItem>(); // "62","62","외상거래아이템"

    @JsonProperty("Tran_GoodsItem")
    private List<TranGoodsItemN> Tran_GoodsItem = new ArrayList<TranGoodsItemN>(); // "61","B0","상품정보아이템"

    @JsonProperty("Tran_CCFreeSetItem")
    private List<TranCCFreeSetItemN> Tran_CCFreeSetItem = new ArrayList<TranCCFreeSetItemN>(); // "70","B2","시코르증정/SET아이템"

    @JsonProperty("Tran_CashTerExpenItem")
    private List<TranCashTerExpenItemN> Tran_CashTerExpenItem = new ArrayList<TranCashTerExpenItemN>(); // "75","C0","캐시터미널E-Accounting결재출금"

    @JsonProperty("Tran_CashTerAmtItem_DX")
    private List<TranCashTerAmtItemDxN> Tran_CashTerAmtItem_DX = new ArrayList<TranCashTerAmtItemDxN>(); // "51","C1","캐쉬터미널연동POS입출금거래금액정보아이템"

    @JsonProperty("Tran_DmsItem")
    private List<TranDmsItemN> Tran_DmsItem = new ArrayList<TranDmsItemN>(); // "66","D0","NEWDMSITEM"

    @JsonProperty("Tran_BmpCampaignItem")
    private List<TranBmpCampaignItemN> Tran_BmpCampaignItem = new ArrayList<TranBmpCampaignItemN>(); // "73","D1","행사정보ITEM(BMP청구할인)"

    @JsonProperty("Tran_CardIcItem")
    private List<TranCardIcItemN> Tran_CardIcItem = new ArrayList<TranCardIcItemN>(); // "65","E1","신용카드(IC)아이템"

    @JsonProperty("Tran_KakaopayItem")
    private List<TranKakaopayItemN> Tran_KakaopayItem = new ArrayList<TranKakaopayItemN>(); // "90","E2","카카오페이ITEM"

    @JsonProperty("Tran_EasyPaymentItem")
    private List<TranEasyPaymentItemN> Tran_EasyPaymentItem = new ArrayList<TranEasyPaymentItemN>(); // "98","E3","간편결제통합전문ITEM"

    @JsonProperty("Tran_SupyoItem")
    private List<TranSupyoItemN> Tran_SupyoItem = new ArrayList<TranSupyoItemN>(); // "16","E4","수표아이템"

    @JsonProperty("Tran_ShinBaekMoneyItem")
    private List<TranShinBaekMoneyItemN> Tran_ShinBaekMoneyItem = new ArrayList<TranShinBaekMoneyItemN>(); // "77","E8","신백머니아이템"

    @JsonProperty("Tran_PaycoinItem")
    private List<TranPaycoinItemN> Tran_PaycoinItem = new ArrayList<TranPaycoinItemN>(); // "58","58","페이코인아이템"

    // ----------------------- < 신규 >
    @JsonProperty("Tran_EtcPayItem")
    private List<TranEtcPayItemC> Tran_EtcPayItem = new ArrayList<TranEtcPayItemC>(); // "","E5","기타결제"

    @JsonProperty("Tran_UseSaleSpecialItem")
    private List<TranUseSaleSpecialItemC> Tran_UseSaleSpecialItem = new ArrayList<TranUseSaleSpecialItemC>(); // "","E6","사용매출특판(점포,법인)"

    @JsonProperty("Tran_PreReservSaleItem")
    private List<TranPreReservSaleItemC> Tran_PreReservSaleItem = new ArrayList<TranPreReservSaleItemC>(); // "","E7","선수예약판매"

    @JsonProperty("Tran_RecommanderItem")
    private List<TranRecommanderItemC> Tran_RecommanderItem = new ArrayList<TranRecommanderItemC>(); // "","E9","권유자(퍼스널쇼퍼)"

    @JsonProperty("Tran_MileageAutoSaveItem")
    private List<TranMileageAutoSaveItemC> Tran_MileageAutoSaveItem = new ArrayList<TranMileageAutoSaveItemC>(); // "","EA","마일리지자동적립"

    @JsonProperty("Tran_UntactAccountItem")
    private List<TranUntactAccountItemC> Tran_UntactAccountItem = new ArrayList<TranUntactAccountItemC>(); // "","EB","비대면
                                                                                                           // 결제요청정보
                                                                                                           // 아이템"

    @JsonProperty("Tran_UntactCardItem")
    private List<TranUntactCardItemC> Tran_UntactCardItem = new ArrayList<TranUntactCardItemC>(); // "","EC","비대면
                                                                                                  // 결제정보
                                                                                                  // 아이템"
}
