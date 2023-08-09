package com.example.controller;

import com.example.entity.Organization;
import com.example.entity.Product;
import com.example.entity.Sale;
import com.example.repository.SaleRepository;
import com.example.service.ProductService;
import com.example.service.SaleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedList;

@Controller
public class SaleController {

    private final SaleService saleService;
    private final ProductService productService;

    public SaleController(SaleService saleService, ProductService productService) {
        this.saleService = saleService;
        this.productService = productService;
    }

    @GetMapping("/sales")
    public String productsPage(Model model){
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        for (Product product: saleService.getSaleById(1L).getProductsOnSale()) {
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            System.out.println(product.getProdName());
        }
        model.addAttribute("sales",saleService.getAllSales());
        return "/sales";
    }
    @GetMapping("/sales/new")
    public String createProduct(Model model){
        Sale sale=new Sale();
        model.addAttribute("prod_id",productService.getAllProducts());
        model.addAttribute("sale",sale);
        return "/create_sale";
    }
    @PostMapping("/sales/buffer")
    public String saveProduct(@ModelAttribute("sale") Sale sale
            ,@RequestParam("prod_id") String[] strings){

        LinkedList<Product> products= new LinkedList<>();
       for (String s: strings){
            products.add(productService.getProductByName(s));//TODO РАССМОТРЕТЬ ВАРИАТ ПРОБЛЕМЫ КОГДА МОЖЕТ НЕ БЫТЬ ПРОДУКТА
        }
        sale.setProductsOnSale(products);
        saleService.saveSale(sale);
        return "redirect:/sales";
    }
}
