package com.myretail.apis.v1;

import com.myretail.models.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * ProductController provides version 1 API functionality for the Product resource.
 */
@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Product> index() {
        return Arrays.asList(
            new Product(1L, "Mac Book Pro"),
            new Product(2L, "Microsoft Surface")
        );
    }

}
