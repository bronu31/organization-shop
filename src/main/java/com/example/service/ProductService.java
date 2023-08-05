package com.example.service;

import com.example.entity.Organization;
import com.example.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product saveProduct(Product product);

    Product getProductById(Long id);
    Product updateProduct(Product product);
    void deleteProduct(Long id);

    Product getProductByName(String s);


}
