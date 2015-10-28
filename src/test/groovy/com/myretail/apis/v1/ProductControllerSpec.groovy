package com.myretail.apis.v1

import com.myretail.apis.ObjectNotFoundException
import com.myretail.services.InventoryFinderService
import com.myretail.services.ProductCategory
import com.myretail.services.ProductDetails
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import static org.hamcrest.Matchers.*;
import static spock.util.matcher.HamcrestSupport.*

/**
 * ProductControllerSpec provides unit test specifications for ProductController.
 */
class ProductControllerSpec extends Specification {

    @Shared ProductDetails sampleProductDetails = new ProductDetails(
        "DDD234",
        "ProductA",
        ProductCategory.BABY,
        new BigDecimal("100.00"))

    def "should return all product details that are persisted"() {
        given:
            def mockInventoryFinder = Mock(InventoryFinderService)
            def controller = new ProductController(mockInventoryFinder)
        when:
            def productList = controller.products(null)
        then:
            1 * mockInventoryFinder.all() >> [sampleProductDetails]
            that productList, is(not(empty()))
            that productList.collect{it.sku}, contains(sampleProductDetails.sku)
    }

    @Unroll
    def "should return a collection of product details for a given category"() {
        given:
            def mockInventoryFinder = Mock(InventoryFinderService)
            def controller = new ProductController(mockInventoryFinder)
        when:
            def productList = controller.products(category)
        then:
            1 * mockInventoryFinder.byCategory(ProductCategory.valueOf(category.toUpperCase())) >> [sampleProductDetails]
            that productList, is(not(empty()))
            that productList.collect{it.sku}, contains(sampleProductDetails.sku)
        where:
            category << ["baby", "BabY", "BABY"]

    }

    def "should throw a exception if a given category is an invalid one"() {
        given:
            def mockInventoryFinder = Mock(InventoryFinderService)
            def controller = new ProductController(mockInventoryFinder)
        when:
            controller.products("INVALID_CATEGORY")
        then:
            IllegalArgumentException e = thrown()
            that e.message, startsWith("No enum constant")
    }

    def "should return a single product details for a given existing SKU value"() {
        given:
            def mockInventoryFinder = Mock(InventoryFinderService)
            def controller = new ProductController(mockInventoryFinder)
        when:
            def product = controller.productBySku(sampleProductDetails.sku)
        then:
            1 * mockInventoryFinder.bySku(sampleProductDetails.sku) >> [sampleProductDetails]
            that product.sku, is(equalTo(sampleProductDetails.sku))
    }

    def "should throw an exception if a product does not exist for a given SKU value"() {
        given:
            def mockInventoryFinder = Mock(InventoryFinderService)
            def controller = new ProductController(mockInventoryFinder)
        when:
            controller.productBySku(sampleProductDetails.sku)
        then:
            1 * mockInventoryFinder.bySku(sampleProductDetails.sku) >> Optional.empty()
            ObjectNotFoundException e = thrown()
            that e.message, startsWith("Product does not exist for SKU")
    }

}