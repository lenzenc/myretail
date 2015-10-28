package com.myretail.services.impl;

import com.myretail.daos.ProductDAO;
import com.myretail.models.Product;
import com.myretail.services.InventoryFinderService;
import com.myretail.services.ProductCategory;
import com.myretail.services.ProductDetails;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * InventoryFinderServiceImpl is the default implementation of the InventoryFinderService interface.
 */
public class InventoryFinderServiceImpl implements InventoryFinderService {

    private ProductDAO productDAO;

    /**
     * Creates a new instance of InventoryFinderServiceImpl.
     *
     * @param productDAO an instance of a ProductDAO.
     */
    public InventoryFinderServiceImpl(ProductDAO productDAO) {

        checkNotNull(productDAO);

        this.productDAO = productDAO;
    }

    /**
     * @inheritDoc
     */
    @Override
    public List<ProductDetails> all() {
        return this.productDAO.findAll().stream().map(p -> this.buildDetails(p)).collect(Collectors.toList());
    }

    /**
     * @inheritDoc
     */
    @Override
    public List<ProductDetails> byCategory(ProductCategory productCategory) {

        checkNotNull(productCategory);

        return this.productDAO.findAllByCategory(Product.Category.valueOf(productCategory.toString())).stream().map(p ->
            this.buildDetails(p)).collect(Collectors.toList());

    }

    /**
     * @inheritDoc
     */
    @Override
    public Optional<ProductDetails> bySku(String sku) {

        checkNotNull(sku);

        Product product = this.productDAO.findBySku(sku);
        return product != null ? Optional.of(this.buildDetails(product)) : Optional.empty();

    }

    private ProductDetails buildDetails(Product product) {
        return new ProductDetails(
            product.getSku(),
            product.getName(),
            ProductCategory.valueOf(product.getCategory().toString()),
            product.getPrice()
        );
    }

}
