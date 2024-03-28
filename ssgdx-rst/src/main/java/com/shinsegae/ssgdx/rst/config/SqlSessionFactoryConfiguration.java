/**
 * @project : 신세계백화점차세대프로젝트
 * @packageName : com.shinsegae.ssgdx.rst.config
 * @fileName : SqlSessionFactoryConfiguration.java
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
package com.shinsegae.ssgdx.rst.config;

import java.util.Map;

import devonboot.autoconfigure.dataaccess.mybatis.dao.CommonDaoMultiSqlSessionFactory;

import com.shinsegae.ssgdx.core.autoconfiguration.dataaccess.MultiSqlSessionFactoryConfiguration;
import com.shinsegae.ssgdx.rst.util.BatchSqlSessionFactoryMap;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
@Configuration
@RequiredArgsConstructor
@AutoConfigureAfter(MultiSqlSessionFactoryConfiguration.class)
public class SqlSessionFactoryConfiguration {

    private final Map<String, CommonDaoMultiSqlSessionFactory> commonDaoSqlSessionFactoryMap;

    @Bean
    BatchSqlSessionFactoryMap batchSqlSessionFactoryMap(Map<String, SqlSessionFactory> sqlSessionFactoryMap){
        return new BatchSqlSessionFactoryMap(sqlSessionFactoryMap);
    }
}
