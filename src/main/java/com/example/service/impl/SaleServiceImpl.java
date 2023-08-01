package com.example.service.impl;

import com.example.entity.Product;
import com.example.entity.Sale;
import com.example.repository.SaleRepository;
import com.example.service.SaleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SaleServiceImpl implements SaleService {

    private SaleRepository saleRepository;

    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    @Override
    public Sale saveSale(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public Sale getSaleById(Long id) {
        return saleRepository.getReferenceById(id);
    }

    @Override
    public void deleteProduct(Long id) {
        saleRepository.deleteById(id);
    }
}
