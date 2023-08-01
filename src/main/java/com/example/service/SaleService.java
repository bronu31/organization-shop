package com.example.service;

import com.example.entity.Sale;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SaleService {

    List<Sale> getAllSales();

    Sale saveSale(Sale sale);

    Sale getSaleById(Long id);

    void deleteProduct(Long id);



}
