package com.myretail.services;

import java.util.List;
import java.util.Optional;

/**
 * InventoryFinderService defines services for finding product details within the My Retail application.
 */
public interface InventoryFinderService {

    /**
     * @return a collection of all product within My Retail.
     */
    List<ProductDetails> all();

    /**
     * Used to final all products by a given product category.
     *
     * @param productCategory the category given to find products associated to it.
     *
     * @return a collection of product details for the given category of an empty collection if none are found.
     */
    List<ProductDetails> byCategory(ProductCategory productCategory);

    /**
     * Used to find details about an individual product for a given unique SKU.
     *
     * @param sku the unique SKU of the product.
     *
     * @return an Optional that wraps if a product exists or not for the given SKU.
     */
    Optional<ProductDetails> bySku(String sku);

}
