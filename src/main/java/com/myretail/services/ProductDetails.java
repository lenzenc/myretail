package com.myretail.services;

import java.math.BigDecimal;

/**
 * ProductDetails is a service DTO abstraction that represents details about a product within My Retail.
 */
public class ProductDetails {

    private String sku;
    private String name;
    private ProductCategory productCategory;
    private BigDecimal price;

    public ProductDetails(
        String sku,
        String name,
        ProductCategory productCategory,
        BigDecimal price)
    {
        this.sku = sku;
        this.name = name;
        this.productCategory = productCategory;
        this.price = price;
    }

    public String getSku() { return this.sku; }
    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() { return this.name; }
    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getCategory() { return this.productCategory; }
    public void setCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public BigDecimal getPrice() { return this.price; }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
