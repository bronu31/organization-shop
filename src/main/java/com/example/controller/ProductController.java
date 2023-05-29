package com.example.controller;

import com.example.repository.ProductRepository;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
