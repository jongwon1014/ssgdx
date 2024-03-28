/**
 * @project : 신세계백화점차세대프로젝트
 * @packageName : com.shinsegae.ssgdx.rst.config
 * @fileName : SlcDbConfiguration.java
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

import javax.sql.DataSource;

import com.shinsegae.ssgdx.rst.config.properties.RstDataSourceProperties;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

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
@RequiredArgsConstructor
@Configuration
public class SlcDbConfiguration {

    private final RstDataSourceProperties rstDataSourceProperties;

    @Bean(name = "slcDbHicariConfig")
    public HikariConfig slcDbHicariConfig(){

        RstDataSourceProperties.Master mProps = rstDataSourceProperties.getOpslc().get("master");
        RstDataSourceProperties.Master.Hakari hProps = mProps.getHikari();

        HikariConfig hCf = new HikariConfig();
        hCf.setDriverClassName(mProps.getDriverClassName());
        hCf.setJdbcUrl(mProps.getUrl());
        hCf.setUsername(mProps.getUsername());
        hCf.setRegisterMbeans(hProps.isRegisterMbeans());
        hCf.setMinimumIdle(hProps.getMinimumIdle());
        hCf.setMaximumPoolSize(hProps.getMaximumPoolSize());
        hCf.setAutoCommit(false);
        return hCf;
    }

    @Bean(name = "slcDbDataSource", destroyMethod = "close")
    public DataSource slcDbDataSource(@Qualifier("slcDbHicariConfig") HikariConfig slcDbHicariConfig){
        return new HikariDataSource(slcDbHicariConfig);
    }

    @Bean(name = "slcDbSqlSessionFactory")
    public SqlSessionFactory slcDbSqlSessionFactory(@Qualifier("slcDbDataSource") DataSource slcDbDataSource)
            throws Exception{
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(slcDbDataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("sql/rst/sql-rst-rst0002.xml")); // mapper
        // 파일
        // 로드
        return sessionFactory.getObject();
    }

    @Bean(name = "slcDbSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("slcDbSqlSessionFactory") SqlSessionFactory slcDbSqlSessionFactory) throws Exception{
        final SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(slcDbSqlSessionFactory);
        return sqlSessionTemplate;
    }

    @Bean(name = "slcDbTxManager")
    public PlatformTransactionManager slcDbTxManager(@Qualifier("slcDbDataSource") DataSource slcDbDataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(slcDbDataSource);
        dataSourceTransactionManager.setNestedTransactionAllowed(true); // nested
        return dataSourceTransactionManager;
    }
}
