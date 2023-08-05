package com.example.repository;

import com.example.entity.Organization;
import com.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {


    Product findByProdName(String org_name);
}
