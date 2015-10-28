package com.myretail.apis.v1;

import com.myretail.apis.ObjectNotFoundException;
import com.myretail.services.InventoryFinderService;
import com.myretail.services.ProductCategory;
import com.myretail.services.ProductDetails;
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
    public InventoryFinderService inventoryFinder;

    /**
     * RESTFul method for getting details about all Products within My Retail.
     *
     * @return a collection of product details.
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ProductDetails> products(
            @RequestParam(value = "category", required = false) String category)
    {
        return category != null ?
            inventoryFinder.byCategory(ProductCategory.valueOf(category.toUpperCase())) :
            inventoryFinder.all();
    }

    @RequestMapping(value = "/{sku}", method = RequestMethod.GET)
    @ResponseBody
    public ProductDetails productBySku(@PathVariable String sku) {
        return inventoryFinder.bySku(sku).orElseThrow(() ->
            new ObjectNotFoundException("Product does not exist for SKU: " + sku));
    }

}
