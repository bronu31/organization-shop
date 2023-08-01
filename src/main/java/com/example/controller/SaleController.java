package com.example.controller;

import com.example.entity.Product;
import com.example.entity.Sale;
import com.example.repository.SaleRepository;
import com.example.service.ProductService;
import com.example.service.SaleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SaleController {

    private SaleService saleService;
    private ProductService productService;

    public SaleController(SaleService saleService, ProductService productService) {
        this.saleService = saleService;
        this.productService = productService;
    }

    @GetMapping("/sales")
    public String productsPage(Model model){
        model.addAttribute("products",productService.getAllProducts());
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

        return "/products";
    }
    @GetMapping("/sale/new")
    public String createProduct(Model model){
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        Sale sale=new Sale();
        model.addAttribute("org_id_select",productService.getAllProducts());
        model.addAttribute("product",sale);
        return "/create_sale";
    }
}
