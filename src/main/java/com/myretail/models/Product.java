package com.myretail.models;

/**
 * Product represents an item that can be made available for purchase within My Retail.
 */
public class Product {

    private Long id;
    private String name;

    public Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() { return this.id; }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() { return this.name; }
    public void setName(String name) {
        this.name = name;
    }

}
