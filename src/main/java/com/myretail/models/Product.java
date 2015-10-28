package com.myretail.models;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Product represents an item that can be made available for purchase within My Retail.
 */
public class Product implements Serializable {

    public  enum Category {
        BABY,
        TOYS
    }

    private Integer id;
    private String sku;
    private String name;
    private Category category;
    private BigDecimal price;

//    public Product(
//        Integer id,
//        String sku,
//        String name,
//        Category category,
//        BigDecimal price)
//    {
//        this.id = id;
//        this.sku = sku;
//        this.name = name;
//        this.category = category;
//        this.price = price;
//    }

    public Integer getId() { return this.id; }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getSku() { return this.sku; }
    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() { return this.name; }
    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() { return this.category; }
    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getPrice() { return this.price; }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
