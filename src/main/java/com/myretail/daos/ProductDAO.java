package com.myretail.daos;

import com.myretail.models.Product;

import java.util.List;
import java.util.Optional;

/**
 * ProductDAO defines the persistence functionality for a Product within My Retail.
 */
public interface ProductDAO {

    /**
     * Used to find a persisted Product given it's unique database identifier.
     *
     * @param id the unique database identifier of a Product.
     *
     * @return @return a persisted Product or NULL if one is not found for the given id.
     */
    Product findById(Integer id);

    /**
     * Used to find a persisted Product given it's unique product sku number.
     *
     * @param sku the unique product sku number of a Product.
     *
     * @return a persisted Product or NULL if one is not found for the given sku.
     */
    Product findBySku(String sku);

    /**
     * Used to find all persisted Products given a product category value.
     *
     * @param category the product category for Products to find.
     *
     * @return a collection of Products or an EMPTY collection is non are found for given category.
     */
    List<Product> findAllByCategory(Product.Category category);

    /**
     * Used to retrieve all persisted Products from that database.
     *
     * @return a collection of persisted Products.
     */
    List<Product> findAll();

    /**
     * Used to persist a new instance of Product.
     *
     * Note, that in this case Product must be mutable as the generated DB identifier will get set on Product after a
     * successful insert.
     *
     * @param product the instance of Product to persist.
     */
    void insert(Product product);

}
