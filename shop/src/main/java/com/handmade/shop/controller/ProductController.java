package com.handmade.shop.controller;

import com.handmade.shop.dto.ProductRequest;
import com.handmade.shop.model.Product;
import com.handmade.shop.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping
    public String addProduct(@RequestBody ProductRequest request){
        return productService.addProduct(request);
    }


    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }


    @GetMapping("/search")
    public List<Product> search(@RequestParam String name){
        return productService.searchProducts(name);
    }
}
