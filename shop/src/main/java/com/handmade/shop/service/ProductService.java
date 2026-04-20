package com.handmade.shop.service;

import com.handmade.shop.dto.ProductRequest;
import com.handmade.shop.model.Product;
import com.handmade.shop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public String addProduct(ProductRequest request){

        Product p = new Product();
        p.setName(request.getName());
        p.setPrice(request.getPrice());
        p.setDescription(request.getDescription());

        productRepository.save(p);

        return "Product Added";
    }


    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }


    public List<Product> searchProducts(String name){
        return productRepository.findByNameContainingIgnoreCase(name);
    }
}
