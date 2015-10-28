package com.myretail.apis.v1;

import com.myretail.daos.ProductDAO;
import com.myretail.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ProductController provides version 1 API functionality for the Product resource.
 */
@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @Autowired
    public ProductDAO productDAO;

    /**
     * RESTFul method for getting details about all Products within My Retail.
     *
     * @return a collection of product details.
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Product> products(
            @RequestParam(value = "category", required = false) String category)
    {
        return category != null ?
            this.productDAO.findAllByCategory(Product.Category.valueOf(category.toUpperCase())) :
            this.productDAO.findAll();

    }

    @RequestMapping(value = "/{sku}", method = RequestMethod.GET)
    @ResponseBody
    public Product productBySku(@PathVariable String sku) {
        return this.productDAO.findBySku(sku);
    }

}
