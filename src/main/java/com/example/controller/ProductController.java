package com.example.controller;

import com.example.entity.Product;
import com.example.service.OrganizationService;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private ProductService productService;
@Autowired
    private OrganizationService organizationService;

    public ProductController(ProductService productRepository) {
        this.productService = productRepository;
    }

    @GetMapping("/products")
    public String productsPage(Model model){
        model.addAttribute("products",productService.getAllProducts());
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

        return "/products";
    }
    @GetMapping("/product/new")
    public String createProduct(Model model){
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        Product product=new Product();
        model.addAttribute("org_id_select",organizationService.getAllorganizations());
        model.addAttribute("product",product);
        return "/create_product";
    }
    @PostMapping("/products/buffer")
    public String saveProduct(@ModelAttribute("product") Product product
            ,@RequestParam("org_name_id") String  strimg){
        product.setOrgId(organizationService.getOrganizationByName(strimg));

        productService.saveProduct(product);
        return "redirect:/products";
    }
    @GetMapping("/buffer")
    public String bufferTime(){

        return "/products";
    }
}
