package com.myretail.services.impl

import com.myretail.daos.ProductDAO
import com.myretail.models.Product
import com.myretail.services.ProductCategory
import com.myretail.services.ProductDetails
import spock.lang.Shared
import spock.lang.Specification

import static org.hamcrest.Matchers.*;
import static spock.util.matcher.HamcrestSupport.*

/**
 * InventoryFinderServiceImplSpec provides unit test specifications for InventoryFinderServiceImpl.
 */
class InventoryFinderServiceImplSpec extends Specification {

    @Shared Product sampleProduct = new Product(
        "DDD234",
        "ProductA",
        Product.Category.BABY,
        new BigDecimal("100.00"))

    @Shared ProductDetails sampleProductDetails = new ProductDetails(
        "DDD234",
        "ProductA",
        ProductCategory.BABY,
        new BigDecimal("100.00"))

    def "should be able to return a list product details for all products"() {
        given:
            def mockProductDAO = Mock(ProductDAO)
            def inventoryFinder = new InventoryFinderServiceImpl(mockProductDAO)
        when:
            def productList = inventoryFinder.all()
        then:
            1 * mockProductDAO.findAll() >> [sampleProduct]
            that productList, is(not(empty()))
            that productList.collect{it.sku}, contains(sampleProductDetails.sku)
    }

    def "should return an empty list when there are no products"() {
        given:
            def mockProductDAO = Mock(ProductDAO)
            def inventoryFinder = new InventoryFinderServiceImpl(mockProductDAO)
        when:
            def productList = inventoryFinder.all()
        then:
            1 * mockProductDAO.findAll() >> []
            that productList, is(empty())
    }

    def "should return product details about an individual product given a SKU value"() {
        given:
            def mockProductDAO = Mock(ProductDAO)
            def inventoryFinder = new InventoryFinderServiceImpl(mockProductDAO)
        when:
            def productDetails = inventoryFinder.bySku(sampleProduct.sku)
        then:
            1 * mockProductDAO.findBySku(sampleProduct.sku) >> sampleProduct
            that productDetails.isPresent(), is(true)
            that productDetails.get().sku, is(equalTo(sampleProductDetails.sku))
            that productDetails.get().name, is(equalTo(sampleProductDetails.name))
            that productDetails.get().category, is(equalTo(sampleProductDetails.category))
            that productDetails.get().price, is(equalTo(sampleProductDetails.price))

    }

    def "should return an empty Optional if a product can not be found for a given SKU value"() {
        given:
            def mockProductDAO = Mock(ProductDAO)
            def inventoryFinder = new InventoryFinderServiceImpl(mockProductDAO)
        when:
            def productDetails = inventoryFinder.bySku("SKU_DOES_NOT_EXIST")
        then:
            1 * mockProductDAO.findBySku("SKU_DOES_NOT_EXIST") >> null
            that productDetails.isPresent(), is(false)
    }

    def "should return a list of product details for a given product category"() {
        given:
            def mockProductDAO = Mock(ProductDAO)
            def inventoryFinder = new InventoryFinderServiceImpl(mockProductDAO)
        when:
            def productList = inventoryFinder.byCategory(ProductCategory.BABY)
        then:
            1 * mockProductDAO.findAllByCategory(Product.Category.BABY) >> [sampleProduct]
            that productList, is(not(empty()))
            that productList.collect{it.sku}, contains(sampleProductDetails.sku)
    }

    def "should return an empty list if no products exist for a given product category"() {
        given:
            def mockProductDAO = Mock(ProductDAO)
            def inventoryFinder = new InventoryFinderServiceImpl(mockProductDAO)
        when:
            def productList = inventoryFinder.byCategory(ProductCategory.BABY)
        then:
            1 * mockProductDAO.findAllByCategory(Product.Category.BABY) >> []
            that productList, is(empty())
    }

}