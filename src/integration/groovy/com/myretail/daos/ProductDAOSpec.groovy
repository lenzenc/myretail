package com.myretail.daos

import com.myretail.config.DatabaseConfig
import com.myretail.models.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.support.NullValue
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.support.AnnotationConfigContextLoader
import org.springframework.test.context.transaction.TransactionConfiguration
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

import static org.hamcrest.Matchers.*;
import static spock.util.matcher.HamcrestSupport.*

/**
 * ProductDAOSpec provides integration tests for ProductDAO.
 *
 * Note this is a very simple example relying on the data loaded by spring via script located if the following directory;
 * src/main/resources/data.sql
 */
@ContextConfiguration(classes = [DatabaseConfig.class], loader = AnnotationConfigContextLoader.class)
class ProductDAOSpec extends Specification {

    @Autowired
    def ProductDAO productDAO

    def "should find a Product by a given existing id"() {
        when:
            def product = productDAO.findById(1)
        then:
            that product.id, is(equalTo(1))
            that product.sku, is(equalTo("AEX143"))
            that product.name, is(equalTo("Stroller"))
            that product.category, is(equalTo(Product.Category.BABY))
            that product.price, is(comparesEqualTo((new BigDecimal("199.99"))))
    }

    def "should return NULL if a Product is not found for a given id"() {
        when:
            def product = productDAO.findById(-1)
        then:
            that product, is(nullValue())
    }

    def "should return a Product for a given existing SKU"() {
        when:
            def product = productDAO.findBySku("AEX143")
        then:
            that product.id, is(equalTo(1))
            that product.sku, is(equalTo("AEX143"))
            that product.name, is(equalTo("Stroller"))
            that product.category, is(equalTo(Product.Category.BABY))
            that product.price, is(comparesEqualTo((new BigDecimal("199.99"))))
    }

    def "should return NULL if a Product is not found for a given SKU"() {
        when:
            def product = productDAO.findBySku("DOESNOTEXIST")
        then:
            that product, is(nullValue())
    }

    def "should return a collection of Products for a given category"() {
        when:
            def productList = productDAO.findAllByCategory(Product.Category.TOYS)
        then:
            that productList, is(not(empty()))
            that productList.collect{it.sku}, containsInAnyOrder("IOL123","XYZ904")
    }

    def "should return an empty collection when no Products exist for a category"() {
        when:
            def productList = productDAO.findAllByCategory(Product.Category.FOOD)
        then:
            that productList, is(empty())
    }

    def "should return all Products that are persisted"() {
        when:
            def productList = productDAO.findAll()
        then:
            that productList.collect{it.sku}, containsInAnyOrder("AEX143","IOL123","XYZ904")
    }

}