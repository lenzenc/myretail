package com.myretail.config;

import com.myretail.daos.ProductDAO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ProductConfig provides the Spring configurations for components related to products with in My Retail.
 */
@Configuration
public class ProductConfig {

    @Autowired
    public SqlSessionFactory sessionFactory;

//    @Bean
//    public ProductDAO productDAO() {
//        SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(this.sessionFactory);
//        return sessionTemplate.getMapper(ProductDAO.class);
//    }

}
