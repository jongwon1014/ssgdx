/**
 * @project : 신세계백화점차세대프로젝트
 * @packageName : com.shinsegae.ssgdx.rst.util
 * @fileName : BatchSqlSessionFactoryMap.java
 * @author : q93m9k
 * @date : 2024.02.29
 * @description :
 * 
 * COPYRIGHT ©2024 SHINSEGAE. ALL RIGHTS RESERVED.
 * 
 * <pre>
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024.02.29       q93m9k              최초 생성
 * ===========================================================
 * </pre>
 */
package com.shinsegae.ssgdx.rst.util;

import java.util.Map;

import devonframe.dataaccess.mybatis.factory.CommonDaoSqlSessionFactoryBean;

import org.apache.ibatis.session.SqlSessionFactory;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * <pre>
 * 
 * </pre>
 * 
 * @author : q93m9k
 * @version : 2024.02.29
 * @see :
 */
@Getter
@RequiredArgsConstructor
public class BatchSqlSessionFactoryMap {

    /**
     * MDS DB의 SqlSessionFactory명
     */
    public static final String OPMDS_SQLSESSION_FACTORY_NAME = "sqlSession";

    /**
     * SLC DB의 SqlSessionFactory명
     */
    public static final String OPSLC_SQLSESSION_FACTORY_NAME = "opslcSqlSession";

    /**
     * DMS DB의 SqlSessionFactory명
     */
    public static final String OPDMS_SQLSESSION_FACTORY_NAME = "opdmsSqlSession";

    /**
     * 각 DataSource의 SqlSessionFactory를 저장한 Map
     */
    private final Map<String, SqlSessionFactory> sqlSessionFactoryMap;

    /**
     * Map에 SqlSession 저장
     * @param key SqlSessionFactory명
     * @param value SqlSessionFactory 객체
     */
    public void put(String key, SqlSessionFactory value){
        this.sqlSessionFactoryMap.put(key, value);
    }

    /**
     * Map에 SqlSession 저장
     * @param key SqlSessionFactory명
     * @param value CommonDaoSqlSessionFactoryBean 객체
     * @throws Exception
     */
    public void put(String key, CommonDaoSqlSessionFactoryBean value) throws Exception{
        this.put(key, value.getObject());
    }

    /**
     * SqlSessionFactory명을 이용하여 SqlSessionFactory 객체 반환
     * @param key SqlSessionFactory명
     * @return SqlSessionFactory 객체
     */
    public SqlSessionFactory get(String key){
        return this.sqlSessionFactoryMap.get(key);
    }

    /**
     * MDS DB의 SqlSessionFactory 반환
     * @return MDS DB의 SqlSessionFactory
     */
    public SqlSessionFactory getOpmdsSqlSession(){
        return this.get(OPMDS_SQLSESSION_FACTORY_NAME);
    }

    /**
     * SLC DB의 SqlSessionFactory 반환
     * @return SLC DB의 SqlSessionFactory
     */
    public SqlSessionFactory getOpslcSqlSession(){
        return this.get(OPSLC_SQLSESSION_FACTORY_NAME);
    }

    /**
     * DMS DB의 SqlSessionFactory 반환
     * @return DMS DB의 SqlSessionFactory
     */
    public SqlSessionFactory getOpdmsSqlSession(){
        return this.get(OPDMS_SQLSESSION_FACTORY_NAME);
    }
}
