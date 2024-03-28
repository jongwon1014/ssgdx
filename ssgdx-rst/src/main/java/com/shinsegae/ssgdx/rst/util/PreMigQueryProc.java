package com.shinsegae.ssgdx.rst.util;

import java.util.Map;

import com.shinsegae.ssgdx.rst.model.oldtr.TtrlogO;

import org.apache.ibatis.session.SqlSession;

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
public class PreMigQueryProc {

    public PreMigQueryProc() {}

    /**
     * <pre>
     * 외상거래 아이템 ("62", "62") TOBE 회계단위 조회
     * </pre>
     * 
     * @param paramMap
     * @return
     * @throws Exception
     */
    public String selectDepositItemCmmnCdRfrVal(SqlSession sqlSession, Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        String cmmnCdRfrVal = "";

        cmmnCdRfrVal = sqlSession.selectOne("rst.Rst0002.selectDepositItemCmmnCdRfrVal", paramMap);

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
    public Map<String, Object> selectSalsSlipNoSalsAmt(SqlSession sqlSession, Map<String, Object> paramMap,
            String sTranInfo, Map<String, Object> logParamMap) throws Exception{
        Map<String, Object> retMap = null;

        retMap = sqlSession.selectOne("rst.Rst0002.selectSalsSlipNoSalsAmt", paramMap);

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
    public String selectDepositItemShopCode(SqlSession sqlSession, Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        String shopCode = "";

        shopCode = sqlSession.selectOne("rst.Rst0002.selectDepositItemShopCode", paramMap);

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
    public String selectDepositItemApvlAplySno(SqlSession sqlSession, Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        String apvlAplySno = "";

        apvlAplySno = sqlSession.selectOne("rst.Rst0002.selectDepositItemApvlAplySno", paramMap);

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
    public String selectGoodsItemCategoryCode(SqlSession sqlSession, Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        String categoryCode = "";

        categoryCode = sqlSession.selectOne("rst.Rst0002.selectGoodsItemCategoryCode", paramMap);

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
    public Map<String, String> selectGoodsItemShopCdBizRelmCd(SqlSession sqlSession, Map<String, Object> paramMap,
            String sTranInfo, Map<String, Object> logParamMap) throws Exception{
        Map<String, String> retMap = null;

        retMap = sqlSession.selectOne("rst.Rst0002.selectGoodsItemShopCdBizRelmCd", paramMap);

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
    public String selectGoodsItemProfitCenterCode(SqlSession sqlSession, Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        String ProfitCenterCode = "";

        ProfitCenterCode = sqlSession.selectOne("rst.Rst0002.selectGoodsItemProfitCenterCode", paramMap);

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
    public String selectGoodsItemPrdtBrandCode(SqlSession sqlSession, Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        String PrdtBrandCode = "";

        PrdtBrandCode = sqlSession.selectOne("rst.Rst0002.selectGoodsItemPrdtBrandCode", paramMap);

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
    public String selectGoodsItemEvnCd(SqlSession sqlSession, Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        String evnCd = "";

        evnCd = sqlSession.selectOne("rst.Rst0002.selectGoodsItemEvnCd", paramMap);

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
    public String selectGoodsItemOrgOrderNo(SqlSession sqlSession, Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        String OrgOrderNo = "";

        OrgOrderNo = sqlSession.selectOne("rst.Rst0002.selectGoodsItemOrgOrderNo", paramMap);

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
    public String selectGoodsItemEventMngYMEventMngNo(SqlSession sqlSession, Map<String, Object> paramMap,
            String sTranInfo, Map<String, Object> logParamMap) throws Exception{
        String evnId = null;

        evnId = sqlSession.selectOne("rst.Rst0002.selectGoodsItemEventMngYMEventMngNo", paramMap);

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
    public String selectCCFreeSetItemShopCode(SqlSession sqlSession, Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        String shopCode = "";

        shopCode = sqlSession.selectOne("rst.Rst0002.selectCCFreeSetItemShopCode", paramMap);

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
    public String selectTranCashTerAmtItemDXShopCd(SqlSession sqlSession, Map<String, Object> paramMap,
            String sTranInfo, Map<String, Object> logParamMap) throws Exception{
        String shopCd = "";

        shopCd = sqlSession.selectOne("rst.Rst0002.selectTranCashTerAmtItemDXShopCd", paramMap);

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
    public String selectDmsItemCpCd(SqlSession sqlSession, Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        String cpCd = "";

        cpCd = sqlSession.selectOne("rst.Rst0002.selectDmsItemCpCd", paramMap);

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
    public Map<String, Object> selectDmsItemcpIssNo(SqlSession sqlSession, Map<String, Object> paramMap,
            String sTranInfo, Map<String, Object> logParamMap) throws Exception{
        Map<String, Object> retMap = null;

        retMap = sqlSession.selectOne("rst.Rst0002.selectDmsItemcpIssNo", paramMap);

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
    public String selectDmsItemcpCaclValidDate(SqlSession sqlSession, Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        String cpCaclValidDate = "";

        cpCaclValidDate = sqlSession.selectOne("rst.Rst0002.selectDmsItemcpCaclValidDate", paramMap);

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
    public String selectTranCardIcItemItemListCode(SqlSession sqlSession, Map<String, Object> paramMap,
            String sTranInfo, Map<String, Object> logParamMap) throws Exception{
        String pdctClCd = "";

        pdctClCd = sqlSession.selectOne("rst.Rst0002.selectTranCardIcItemItemListCode", paramMap);

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
    public String selectTranCardIcItemItemListBizRelmCd(SqlSession sqlSession, Map<String, Object> paramMap,
            String sTranInfo, Map<String, Object> logParamMap) throws Exception{
        String bizRelmCd = "";

        bizRelmCd = sqlSession.selectOne("rst.Rst0002.selectTranCardIcItemItemListBizRelmCd", paramMap);

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

    public void mergeTTRLOG_O(SqlSession sqlSession, Map<String, Object> paramMap, String sTranInfo,
            Map<String, Object> logParamMap) throws Exception{
        sqlSession.insert("rst.Rst0002.mergeTTRLOG_O", paramMap);
        log.debug("mergeTTRLOG_O -- TranInfo : {}", sTranInfo);
    }

    /*----------------------------------------------------------------------------------------
     * 90일 사전 이행 처리용
     *---------------------------------------------------------------------------------------*/
    public int mergePreMigSC_SALS_TRAN_G(SqlSession sqlSession, TtrlogO ttrlogO) throws Exception{
        int ret = -1;
        // 매출수집 SC_매출_TRAN_전문 저장
        try{
            sqlSession.insert("rst.Rst0002.mergePreMigSC_SALS_TRAN_G", ttrlogO);
            ret = 0;
        }catch(Exception e){
            sqlSession.rollback();
            log.error("PreMigQueryProc -- mergePreMigSC_SALS_TRAN_G Exception!!");
            log.error(e.toString());
        }
        return ret;
    }

    public int updatePreMigTTRLOG_O(SqlSession sqlSession, TtrlogO ttrlogO) throws Exception{
        int ret = -1;
        // 매출수집 저장 정상 처리 되었다면 TTRLOG_O 처리 플래그 업데이트
        try{
            sqlSession.update("rst.Rst0002.updatePreMigTTRLOG_O", ttrlogO);
            ret = 0;
        }catch(Exception e){
            sqlSession.rollback();
            log.error("PreMigQueryProc -- updatePreMigTTRLOG_O Exception!!");
            log.error(e.toString());
        }
        return ret;
    }

    public int updatePreMigTranEncTTRLOG_O(SqlSession sqlSession, TtrlogO ttrlogO) throws Exception{
        int ret = -1;
        // 거래전문 암호화 저장 업데이트
        try{
            sqlSession.update("rst.Rst0002.updatePreMigTranEncTTRLOG_O", ttrlogO);
            ret = 0;
        }catch(Exception e){
            sqlSession.rollback();
            log.error("PreMigQueryProc -- updatePreMigTranEncTTRLOG_O Exception!!");
            log.error(e.toString());
        }
        return ret;
    }
}
