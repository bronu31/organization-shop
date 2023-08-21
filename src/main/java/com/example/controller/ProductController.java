package com.example.controller;

import com.example.entity.Product;
import com.example.service.OrganizationService;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ProductController {

    private final ProductService productService;
@Autowired
    private OrganizationService organizationService;

    public ProductController(ProductService productRepository) {
        this.productService = productRepository;
    }

    @GetMapping("/products")
    public String productsPage(Model model){
        model.addAttribute("products",productService.getAllProducts());

        return "/products";
    }
    @GetMapping("/product/new")
    public String createProduct(Model model){
        Product product=new Product();
        model.addAttribute("org_id_select",organizationService.getAllorganizations());
        model.addAttribute("product",product);
        return "/create_product";
    }

    @GetMapping("/product/details/{id}")
    public String detailsOnProduct(Model model, @PathVariable Long id){

            model.addAttribute("product",productService.getProductById(id));
        return "/product_details";
    }

    @PostMapping("/products/buffer")
    public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult
            , @RequestParam("org_name_id") String  strimg){
        if (bindingResult.hasErrors()) return "/create_product";
        product.setOrgId(organizationService.getOrganizationByName(strimg));

        productService.saveProduct(product);
        return "redirect:/products";
    }
    @GetMapping("/buffer")
    public String bufferTime(){

        return "/products";
    }
}
