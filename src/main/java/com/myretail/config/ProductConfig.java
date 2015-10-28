package com.myretail.config;

import com.myretail.apis.v1.ProductController;
import com.myretail.daos.ProductDAO;
import com.myretail.services.InventoryFinderService;
import com.myretail.services.impl.InventoryFinderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ProductConfig provides the Spring configurations for components related to products with in My Retail.
 */
@Configuration
public class ProductConfig {

    @Autowired
    public ProductDAO productDAO;

    @Bean
    public InventoryFinderService inventoryFinderService() {
        return new InventoryFinderServiceImpl(this.productDAO);
    }

    @Bean
    public ProductController productController() {
        return new ProductController(inventoryFinderService());
    }

}
