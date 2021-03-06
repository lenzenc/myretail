package com.myretail.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * DatabaseConfig is a Spring configuration class that is used to setup/configure the basis of persistence in My Retail
 * which is using MyBatis.
 */
@Configuration
@MapperScan("com.myretail.daos")
public class DatabaseConfig {

    /**
     * Creates a MyBatis session factory that will get used from within the Spring context when managing connections
     * to an underlying data store.
     *
     * @return an instance of MyBatis SessionFactory.
     *
     * @throws Exception is thrown if a SessionFactory can not be gottent from a session factory bean.
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setTypeAliasesPackage("com.myretail.models");
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * @return a JDBC DataSource to be used when getting connection for performing persistent functionality.
     */
    @Bean
    public EmbeddedDatabase dataSource() {
        return new EmbeddedDatabaseBuilder().
            generateUniqueName(true).
            addScripts("classpath:schema.sql", "classpath:data.sql").
            setType(EmbeddedDatabaseType.H2).
            build();
    }

}
