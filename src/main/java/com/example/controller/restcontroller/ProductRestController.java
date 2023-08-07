package com.example.controller.restcontroller;


import com.example.entity.Organization;
import com.example.entity.Product;
import com.example.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "rest/product")
    public List<Product> getOrganizations(){
        return productService.getAllProducts();
    }

    @GetMapping(value = "rest/product/{id}")
    public Product getOrganizations(@PathVariable Long id){
        return productService.getProductById(id);
    }

}
