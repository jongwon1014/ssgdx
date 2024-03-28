/**
 * @project : 신세계백화점차세대프로젝트
 * @packageName : com.shinsegae.ssgdx.rst.config
 * @fileName : MdsDbConfiguration.java
 * @author : q93m9k
 * @date : 2024.03.02
 * @description :
 * 
 * COPYRIGHT ©2024 SHINSEGAE. ALL RIGHTS RESERVED.
 * 
 * <pre>
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024.03.02       q93m9k              최초 생성
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
 * @version : 2024.03.02
 * @see :
 */
@RequiredArgsConstructor
@Configuration
public class MdsDbConfiguration {

    private final RstDataSourceProperties rstDataSourceProperties;

    @Bean(name = "mdsDbHicariConfig")
    public HikariConfig mdsDbHicariConfig(){

        RstDataSourceProperties.Master mProps = rstDataSourceProperties.getOpmds().get("master");
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

    @Bean(name = "mdsDbDataSource", destroyMethod = "close")
    public DataSource mdsDbDataSource(@Qualifier("mdsDbHicariConfig") HikariConfig mdsDbHicariConfig){
        return new HikariDataSource(mdsDbHicariConfig);
    }

    @Bean(name = "mdsDbSqlSessionFactory")
    public SqlSessionFactory mdsDbSqlSessionFactory(@Qualifier("mdsDbDataSource") DataSource mdsDbDataSource)
            throws Exception{
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(mdsDbDataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("sql/rst/sql-rst-rst0002.xml")); // mapper
        // 파일
        // 로드
        return sessionFactory.getObject();
    }

    @Bean(name = "mdsDbSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("mdsDbSqlSessionFactory") SqlSessionFactory mdsDbSqlSessionFactory) throws Exception{
        final SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(mdsDbSqlSessionFactory);
        return sqlSessionTemplate;
    }

    @Bean(name = "mdsDbTxManager")
    public PlatformTransactionManager mdsDbTxManager(@Qualifier("mdsDbDataSource") DataSource mdsDbDataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(mdsDbDataSource);
        dataSourceTransactionManager.setNestedTransactionAllowed(true); // nested
        return dataSourceTransactionManager;
    }
}
