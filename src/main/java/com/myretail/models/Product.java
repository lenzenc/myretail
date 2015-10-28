package com.myretail.models;

import java.io.Serializable;
import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Product represents an item that can be made available for purchase within My Retail.
 */
public class Product implements Serializable {

    public  enum Category {
        BABY,
        TOYS,
        FOOD
    }

    private Integer id;
    private String sku;
    private String name;
    private Category category;
    private BigDecimal price;

    /**
     * Empty constructor that is defined only for usage by MyBatis.
     */
    private Product() {}

    /**
     * Constructs a new instance of Product.
     *
     * @param sku the unique external identifier of a product.
     * @param name the name and/or description of a product.
     * @param category the category a product falls under.
     * @param price the price of the product.
     */
    public Product(
        String sku,
        String name,
        Category category,
        BigDecimal price)
    {

        checkNotNull(sku);
        checkNotNull(name);
        checkNotNull(category);
        checkNotNull(price);

        this.sku = sku;
        this.name = name;
        this.category = category;
        this.price = price;
    }

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
