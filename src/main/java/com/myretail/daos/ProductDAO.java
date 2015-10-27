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
     * @return @return an {@link Optional} that wraps a persisted Product.
     */
    Optional<Product> findById(Long id);

    /**
     * Used to retrieve all persisted Products from that database.
     *
     * @return a collection of persisted Products.
     */
    List<Product> findAll();

}
