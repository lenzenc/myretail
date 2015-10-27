package com.myretail.models;

import java.io.Serializable;

/**
 * Product represents an item that can be made available for purchase within My Retail.
 */
public class Product implements Serializable {

    private Integer id;
    private String name;

    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() { return this.id; }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() { return this.name; }
    public void setName(String name) {
        this.name = name;
    }

}
