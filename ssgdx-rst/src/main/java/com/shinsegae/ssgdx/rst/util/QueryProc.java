package com.shinsegae.ssgdx.rst.util;

import java.util.List;
import java.util.Map;

import devonframe.dataaccess.CommonDao;

import com.shinsegae.ssgdx.core.dataaccess.mybatis.MybatisConstants;
import com.shinsegae.ssgdx.rst.model.oldtr.TtrlogO;

import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * 구트란 체계를 신트란 체계로 변환 처리하는 클래스
 * </pre>
 * 
 * @author : q93m9k
 * @version : 2023.10.19
 * @see :
 */
@Slf4j
public class QueryProc {

    private final CommonDao commonDao;

    public QueryProc(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    /**
     * <pre>
     * 외상거래 아이템 ("62", "62") TOBE 회계단위 조회
     * </pre>
     * 
     * @param paramMap
     * @return
     * @throws Exception
     */
    public String selectDepositItemCmmnCdRfrVal(Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        String cmmnCdRfrVal = "";

        cmmnCdRfrVal = commonDao.select("rst.Rst0001.selectDepositItemCmmnCdRfrVal", paramMap,
                MybatisConstants.OPMDS_SQLSESSION_FACTORY_NAME);

        if(cmmnCdRfrVal == null){
            log.info("\n[NULL] selectDepositItemCmmnCdRfrVal -- (62, 62) -- TOBE 회계단위 -- cmmnCdRfrValAsIs:[{}], {}",
                    paramMap.get("cmmnCdRfrVal"), sTranInfo);

            cmmnCdRfrVal = "";
        }else{
            log.info(
                    "\nselectDepositItemCmmnCdRfrVal -- (62, 62) -- TOBE 회계단위 -- cmmnCdRfrValAsIs:[{}], cmmnCdRfrValToBe:[{}], {}",
                    paramMap.get("cmmnCdRfrVal"), cmmnCdRfrVal, sTranInfo);
        }

        return cmmnCdRfrVal;
    }

    /**
     * <pre>
     * 외상거래 아이템 ("62", "62") 사용매출전표번호, 매장매출 조회
     * </pre>
     * 
     * @param paramMap
     * @return
     * @throws Exception
     */
    public Map<String, Object> selectSalsSlipNoSalsAmt(Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        Map<String, Object> retMap = null;

        retMap = commonDao.select("rst.Rst0001.selectSalsSlipNoSalsAmt", paramMap,
                MybatisConstants.OPMDS_SQLSESSION_FACTORY_NAME);

        if(retMap == null){
            log.info("\n[NULL] selectSalsSlipNoSalsAmt -- (62, 62) -- TOBE 회계단위 -- {}", sTranInfo);
        }else{
            log.info("\nselectSalsSlipNoSalsAmt -- (62, 62) -- TOBE 회계단위 -- {}", sTranInfo);
        }

        return retMap;
    }

    /**
     * <pre>
     * 외상거래 아이템 ("62", "62") 매장코드 조회
     * </pre>
     * 
     * @param paramMap
     * @return
     * @throws Exception
     */
    public String selectDepositItemShopCode(Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        String shopCode = "";

        shopCode = commonDao.select("rst.Rst0001.selectDepositItemShopCode", paramMap,
                MybatisConstants.OPMDS_SQLSESSION_FACTORY_NAME);

        if(shopCode == null){
            log.info("\n[NULL] selectDepositItemShopCode -- (62, 62) -- TOBE 회계단위 -- shopCode:[{}], {}",
                    paramMap.get("shopCode"), sTranInfo);

            shopCode = "";
        }else{
            log.info("\nselectDepositItemShopCode -- (62, 62) -- TOBE 회계단위 -- shopCode:[{}], shopCode:[{}], {}",
                    paramMap.get("shopCode"), shopCode, sTranInfo);
        }

        return shopCode;
    }

    /**
     * <pre>
     * 외상거래 아이템 ("62", "62") 승인신청일련번호 조회
     * </pre>
     * 
     * @param paramMap
     * @return
     * @throws Exception
     */
    public String selectDepositItemApvlAplySno(Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        String apvlAplySno = "";

        apvlAplySno = commonDao.select("rst.Rst0001.selectDepositItemApvlAplySno", paramMap,
                MybatisConstants.OPMDS_SQLSESSION_FACTORY_NAME);

        if(apvlAplySno == null){
            log.info("\n[NULL] selectDepositItemApvlAplySno -- (62, 62) -- 승인신청일련번호 -- apvlAplySno:[{}], {}",
                    apvlAplySno, sTranInfo);

            apvlAplySno = "";
        }else{
            log.info("\nselectDepositItemApvlAplySno -- (62, 62) -- 승인신청일련번호 -- apvlAplySno:[{}], {}", apvlAplySno,
                    sTranInfo);
        }

        return apvlAplySno;
    }

    /**
     * <pre>
     * 상품정보 아이템 ("61", "B0") 품목코드 조회
     * </pre>
     * 
     * @param paramMap
     * @return
     * @throws Exception
     */
    public String selectGoodsItemCategoryCode(Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        String categoryCode = "";

        categoryCode = commonDao.select("rst.Rst0001.selectGoodsItemCategoryCode", paramMap,
                MybatisConstants.OPMDS_SQLSESSION_FACTORY_NAME);

        if(categoryCode == null){
            log.info(
                    "\n[NULL] selectGoodsItemCategoryCode -- (61, B0) -- 품목코드             -- pluType:[{}], mdCode:[{}], classCode:[{}], categoryCode:[{}], pluCode:[{}], {}",
                    paramMap.get("pluType"), paramMap.get("mdCode"), paramMap.get("classCode"),
                    paramMap.get("categoryCode"), paramMap.get("pluCode"), sTranInfo);

            categoryCode = "";

        }else{
            log.info(
                    "\nselectGoodsItemCategoryCode -- (61, B0) -- 품목코드             -- pluType:[{}], mdCode:[{}], classCode:[{}], categoryCode:[{}], pluCode:[{}], categoryCode(조회):[{}], {}",
                    paramMap.get("pluType"), paramMap.get("mdCode"), paramMap.get("classCode"),
                    paramMap.get("categoryCode"), paramMap.get("pluCode"), categoryCode, sTranInfo);
        }

        return categoryCode;
    }

    /**
     * <pre>
     * 상품정보 아이템 ("61", "B0") 매장코드, 사업영역코드 조회
     * </pre>
     * 
     * @param paramMap
     * @return
     * @throws Exception
     */
    public Map<String, String> selectGoodsItemShopCdBizRelmCd(Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        Map<String, String> retMap = null;

        retMap = commonDao.select("rst.Rst0001.selectGoodsItemShopCdBizRelmCd", paramMap,
                MybatisConstants.OPMDS_SQLSESSION_FACTORY_NAME);

        if(retMap == null){
            log.info(
                    "\n[NULL] selectGoodsItemShopCdBizRelmCd -- (61, B0) -- 매장코드             -- storeNo:[{}], mdCode:[{}], {}",
                    paramMap.get("storeNo"), paramMap.get("mdCode"), sTranInfo);
        }else{
            log.info(
                    "\nselectGoodsItemShopCdBizRelmCd -- (61, B0) -- 매장코드             -- storeNo:[{}], mdCode:[{}], {}",
                    paramMap.get("storeNo"), paramMap.get("mdCode"), sTranInfo);
        }

        return retMap;
    }

    /**
     * <pre>
     * 상품정보 아이템 ("61", "B0") 손익센터코드 조회
     * </pre>
     * 
     * @param paramMap
     * @return
     * @throws Exception
     */
    public String selectGoodsItemProfitCenterCode(Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        String ProfitCenterCode = "";

        ProfitCenterCode = commonDao.select("rst.Rst0001.selectGoodsItemProfitCenterCode", paramMap,
                MybatisConstants.OPMDS_SQLSESSION_FACTORY_NAME);

        if(ProfitCenterCode == null){
            log.info("\n[NULL] selectGoodsItemProfitCenterCode -- (61, B0) -- 손익센터코드         -- mdCode:[{}], {}",
                    paramMap.get("mdCode"), sTranInfo);

            ProfitCenterCode = "";
        }else{
            log.info(
                    "\nselectGoodsItemProfitCenterCode -- (61, B0) -- 손익센터코드         -- mdCode:[{}], ProfitCenterCode:[{}], {}",
                    paramMap.get("mdCode"), ProfitCenterCode, sTranInfo);
        }
        return ProfitCenterCode;
    }

    /**
     * <pre>
     * 상품정보 아이템 ("61", "B0") 상품브랜드코드 조회
     * </pre>
     *
     * @param paramMap
     * @return
     * @throws Exception
     */
    public String selectGoodsItemPrdtBrandCode(Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        String PrdtBrandCode = "";

        PrdtBrandCode = commonDao.select("rst.Rst0001.selectGoodsItemPrdtBrandCode", paramMap,
                MybatisConstants.OPMDS_SQLSESSION_FACTORY_NAME);

        if(PrdtBrandCode == null){
            log.info("\n[NULL] selectGoodsItemPrdtBrandCode -- (61, B0) -- 상품브랜드코드       -- pluCode:[{}], {}",
                    paramMap.get("pluCode"), sTranInfo);

            PrdtBrandCode = "";
        }else{
            log.info(
                    "\nselectGoodsItemPrdtBrandCode -- (61, B0) -- 상품브랜드코드       -- pluCode:[{}], PrdtBrandCode:[{}], {}",
                    paramMap.get("pluCode"), PrdtBrandCode, sTranInfo);
        }

        return PrdtBrandCode;
    }

    /**
     * <pre>
     * 상품정보 아이템 ("61", "B0") 행사코드 조회
     * </pre>
     *
     * @param paramMap
     * @return
     * @throws Exception
     */
    public String selectGoodsItemEvnCd(Map<String, Object> paramMap, String sTranInfo, Map<String, Object> logParamMap)
            throws Exception{
        String evnCd = "";

        evnCd = commonDao.select("rst.Rst0001.selectGoodsItemEvnCd", paramMap,
                MybatisConstants.OPMDS_SQLSESSION_FACTORY_NAME);

        if(evnCd == null){
            log.info("\n[NULL] selectGoodsItemEvnCd -- (61, B0) -- 행사코드       -- pipdCd:[{}], {}",
                    paramMap.get("pipdCd"), sTranInfo);

            evnCd = "";
        }else{
            log.info("\nselectGoodsItemEvnCd -- (61, B0) -- 행사코드       -- pipdCd:[{}], evnCd:[{}], {}",
                    paramMap.get("pipdCd"), evnCd, sTranInfo);
        }

        return evnCd;
    }

    /**
     * <pre>
     * 상품정보 아이템 ("61", "B0") 원거래주문번호 조회
     * </pre>
     *
     * @param paramMap
     * @return
     * @throws Exception
     */
    public String selectGoodsItemOrgOrderNo(Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        String OrgOrderNo = "";

        OrgOrderNo = commonDao.select("rst.Rst0001.selectGoodsItemOrgOrderNo", paramMap,
                MybatisConstants.OPMDS_SQLSESSION_FACTORY_NAME);

        log.info(
                "selectGoodsItemOrgOrderNo -- (61, B0) 상품정보 아이템 -- 원거래주문번호 -- selectGoodsItemOrgOrderNo -- OrgOrderNo : [{}], {}",
                OrgOrderNo, sTranInfo);
        if(OrgOrderNo == null){
            OrgOrderNo = "";
        }

        return OrgOrderNo;
    }

    /**
     * <pre>
     * 상품정보 아이템 ("61", "B0") 행사관리연월, 행사관리번호 조회
     * </pre>
     * 
     * @param paramMap
     * @return
     * @throws Exception
     */
    public String selectGoodsItemEventMngYMEventMngNo(Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        String evnId = null;

        evnId = commonDao.select("rst.Rst0001.selectGoodsItemEventMngYMEventMngNo", paramMap,
                MybatisConstants.OPMDS_SQLSESSION_FACTORY_NAME);

        if(evnId == null){
            log.info("\n[NULL] selectGoodsItemEventMngYMEventMngNo -- (61, B0) -- 행사관리연월, 행사관리번호 -- {}", sTranInfo);

            evnId = "";
        }else{
            log.info("\nselectGoodsItemEventMngYMEventMngNo -- (61, B0) -- 행사관리연월, 행사관리번호 -- evnId:[{}], {}", evnId,
                    sTranInfo);
        }

        return evnId;
    }

    /**
     * <pre>
     * 시코르 증정/SET 아이템 ("70", "B2") 매장코드 조회
     * </pre>
     * 
     * @param paramMap
     * @return
     * @throws Exception
     */
    public String selectCCFreeSetItemShopCode(Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        String shopCode = "";

        shopCode = commonDao.select("rst.Rst0001.selectCCFreeSetItemShopCode", paramMap,
                MybatisConstants.OPMDS_SQLSESSION_FACTORY_NAME);

        if(shopCode == null){
            log.info(
                    "\n[NULL] selectCCFreeSetItemShopCode -- (70, B2) -- 매장코드             -- storeNo:[{}], pluCode:[{}], {}",
                    paramMap.get("storeNo"), paramMap.get("pluCode"), sTranInfo);

            shopCode = "";
        }else{
            log.info(
                    "\nselectCCFreeSetItemShopCode -- (70, B2) -- 매장코드             -- storeNo:[{}], pluCode:[{}], shopCode:[{}], {}",
                    paramMap.get("storeNo"), paramMap.get("pluCode"), shopCode, sTranInfo);
        }

        return shopCode;
    }

    /**
     * <pre>
     * 캐쉬터미널 연동 POS 입출금 거래 금액 정보 아이템 ("51", "C1") 매장코드 조회
     * </pre>
     * 
     * @param paramMap
     * @return
     * @throws Exception
     */
    public String selectTranCashTerAmtItemDXShopCd(Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        String shopCd = "";

        shopCd = commonDao.select("rst.Rst0001.selectTranCashTerAmtItemDXShopCd", paramMap,
                MybatisConstants.OPMDS_SQLSESSION_FACTORY_NAME);

        if(shopCd == null){
            log.info(
                    "\n[NULL] selectTranCashTerAmtItemDXShopCd -- (51, C1) -- 매장코드             -- storeNo:[{}], prodCode:[{}], pluType;[{}], {}",
                    paramMap.get("storeNo"), paramMap.get("prodCode"), paramMap.get("pluType"), sTranInfo);

            shopCd = "";
        }else{
            log.info(
                    "\nselectTranCashTerAmtItemDXShopCd -- (51, C1) -- 매장코드             -- storeNo:[{}], prodCode:[{}], pluType;[{}], shopCd:[{}], {}",
                    paramMap.get("storeNo"), paramMap.get("prodCode"), paramMap.get("pluType"), shopCd, sTranInfo);
        }

        return shopCd;
    }

    /**
     * <pre>
     * NEW DMS ITEM ("66", "D0") 쿠폰코드 조회
     * </pre>
     * 
     * @param paramMap
     * @return
     * @throws Exception
     */
    public String selectDmsItemCpCd(Map<String, Object> paramMap, String sTranInfo, Map<String, Object> logParamMap)
            throws Exception{
        String cpCd = "";

        cpCd = commonDao.select("rst.Rst0001.selectDmsItemCpCd", paramMap,
                MybatisConstants.OPMDS_SQLSESSION_FACTORY_NAME);

        if(cpCd == null){
            log.info(
                    "\n[NULL] selectDmsItemCpCd -- (66, D0) -- 쿠폰코드             -- enuriEvtYm:[{}], enuriStrCd:[{}], enuriEvtNo:[{}], {}",
                    paramMap.get("enuriEvtYm"), paramMap.get("enuriStrCd"), paramMap.get("enuriEvtNo"), sTranInfo);

            cpCd = "";
        }else{
            log.info(
                    "\nselectDmsItemCpCd -- (66, D0) -- 쿠폰코드             -- enuriEvtYm:[{}], enuriStrCd:[{}], enuriEvtNo:[{}], cpCd:[{}], {}",
                    paramMap.get("enuriEvtYm"), paramMap.get("enuriStrCd"), paramMap.get("enuriEvtNo"), cpCd,
                    sTranInfo);
        }

        return cpCd;
    }

    /**
     * <pre>
     * NEW DMS ITEM ("66", "D0") 쿠폰/할인권 발급 번호 조회
     * </pre>
     * 
     * @param paramMap
     * @return
     * @throws Exception
     */
    public Map<String, Object> selectDmsItemcpIssNo(Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        Map<String, Object> retMap = null;

        retMap = commonDao.select("rst.Rst0001.selectDmsItemcpIssNo", paramMap,
                MybatisConstants.OPDMS_SQLSESSION_FACTORY_NAME);

        if(retMap == null){
            log.info("\n[NULL] selectDmsItemcpIssNo -- (66, D0) -- 쿠폰/할인권 발급번호 조회된 내용이 없습니다. {}", sTranInfo);
        }else{
            log.info("\nselectDmsItemcpIssNo -- (66, D0) -- 쿠폰/할인권 발급번호 조회 성공. {}", sTranInfo);
        }

        return retMap;
    }

    /**
     * <pre>
     * NEW DMS ITEM ("66", "D0") 쿠폰/할인권 발급 취소유효기간 조회
     * </pre>
     * 
     * @param paramMap
     * @return
     * @throws Exception
     */
    public String selectDmsItemcpCaclValidDate(Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        String cpCaclValidDate = "";

        cpCaclValidDate = commonDao.select("rst.Rst0001.selectDmsItemcpCaclValidDate", paramMap,
                MybatisConstants.OPMDS_SQLSESSION_FACTORY_NAME);

        log.info("QueryProc -- selectDmsItemcpCaclValidDate -- cpCaclValidDate :[{}], {}", cpCaclValidDate, sTranInfo);
        if(cpCaclValidDate == null){
            log.info("\n[NULL] selectDmsItemcpCaclValidDate -- (66, D0) -- 취소유효기간 -- cpnCd:[{}], {}",
                    paramMap.get("cpnCd"), sTranInfo);

            cpCaclValidDate = "";
        }else{
            log.info("\nselectDmsItemcpCaclValidDate -- (66, D0) -- 취소유효기간 -- cpnCd:[{}], cpCaclValidDate:[{}], {}",
                    paramMap.get("cpnCd"), cpCaclValidDate, sTranInfo);
        }

        return cpCaclValidDate;
    }

    /**
     * <pre>
     * 신용카드(IC) 아이템 ("65", "E1") 상품코드 (16->30) 조회
     * </pre>
     * 
     * @param paramMap
     * @return
     * @throws Exception
     */
    public String selectTranCardIcItemItemListCode(Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        String pdctClCd = "";

        pdctClCd = commonDao.select("rst.Rst0001.selectTranCardIcItemItemListCode", paramMap,
                MybatisConstants.OPMDS_SQLSESSION_FACTORY_NAME);

        if(pdctClCd == null){
            log.info("\n[NULL] selectTranCardIcItemItemListCode -- (65, E1) -- 상품코드 (16->30) 조회 -- code:[{}], {}",
                    paramMap.get("code"), sTranInfo);

            pdctClCd = "";
        }else{
            log.info(
                    "\nselectTranCardIcItemItemListCode -- (65, E1) -- 상품코드 (16->30) 조회 -- code:[{}], pdctClCd:[{}], {}",
                    paramMap.get("code"), pdctClCd, sTranInfo);
        }

        return pdctClCd;
    }

    /**
     * <pre>
     * 신용카드(IC) 아이템 ("65", "E1") 사업영역코드 조회
     * </pre>
     * 
     * @param paramMap
     * @return
     * @throws Exception
     */
    public String selectTranCardIcItemItemListBizRelmCd(Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        String bizRelmCd = "";

        bizRelmCd = commonDao.select("rst.Rst0001.selectTranCardIcItemItemListBizRelmCd", paramMap,
                MybatisConstants.OPMDS_SQLSESSION_FACTORY_NAME);

        if(bizRelmCd == null){
            log.info(
                    "\n[NULL] selectTranCardIcItemItemListBizRelmCd -- (65, E1) -- 사업영역코드 조회 -- storeNo:[{}], code:[{}], {}",
                    paramMap.get("storeNo"), paramMap.get("code"), sTranInfo);
            bizRelmCd = "";
        }else{
            log.info(
                    "\nselectTranCardIcItemItemListBizRelmCd -- (65, E1) -- 사업영역코드 조회 -- storeNo:[{}], code:[{}], bizRelmCd:[{}], {}",
                    paramMap.get("storeNo"), paramMap.get("code"), bizRelmCd, sTranInfo);
        }

        return bizRelmCd;
    }

    public void mergeTTRLOG_O(Map<String, Object> paramMap, String sTranInfo, Map<String, Object> logParamMap)
            throws Exception{
        commonDao.insert("rst.Rst0001.mergeTTRLOG_O", paramMap, MybatisConstants.OPMDS_SQLSESSION_FACTORY_NAME);
        log.debug("mergeTTRLOG_O -- TranInfo : {}", sTranInfo);
    }

    /*----------------------------------------------------------------------------------------
    * 90일 사전 이행 처리용
    *---------------------------------------------------------------------------------------*/
    public int selectTtrlogOTranDataCount(Map<String, Object> paramMap) throws Exception{
        int tranTotCount = commonDao.select("rst.Rst0001.selectTtrlogOTranDataCount", paramMap,
                MybatisConstants.OPMDS_SQLSESSION_FACTORY_NAME);

        log.info("\nselectTtrlogOTranDataCount -- selectTtrlogOTranDataCount -- tranCount : {}", tranTotCount);

        return tranTotCount;
    }

    public List<TtrlogO> selectTtrlogOTranData(Map<String, Object> paramMap) throws Exception{

        List<TtrlogO> resLst = commonDao.selectList("rst.Rst0001.selectTtrlogOTranData", paramMap,
                MybatisConstants.OPMDS_SQLSESSION_FACTORY_NAME);

        if(resLst == null){
            log.info("\n[NULL] selectTtrlogOTranData -- 사전이행 구트란 조회 -- 조회된 내용이 없습니다.");
        }else{
            log.info("\nselectTtrlogOTranData -- selectTtrlogOTranData -- resLst Count : {}", resLst.size());
        }

        return resLst;
    }
}
