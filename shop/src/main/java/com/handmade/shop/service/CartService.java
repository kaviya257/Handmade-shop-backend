package com.handmade.shop.service;

import com.handmade.shop.model.Cart;
import com.handmade.shop.model.Product;
import com.handmade.shop.repository.CartRepository;
import com.handmade.shop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartService(CartRepository cartRepository,
                       ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public String addToCart(String username, Long productId){

        Cart existing = cartRepository
                .findByUsernameAndProductId(username, productId);

        if(existing != null){
            existing.setQuantity(existing.getQuantity() + 1);
            cartRepository.save(existing);
        } else {
            Cart cart = new Cart();
            cart.setUsername(username);
            cart.setProductId(productId);
            cart.setQuantity(1);
            cartRepository.save(cart);
        }

        return "Cart Updated";
    }


    public String decrease(String username, Long productId){

        Cart cart = cartRepository
                .findByUsernameAndProductId(username, productId);

        if(cart == null){
            return "Item not found";
        }

        if(cart.getQuantity() > 1){
            cart.setQuantity(cart.getQuantity() - 1);
            cartRepository.save(cart);
        } else {
            cartRepository.delete(cart);
        }

        return "Updated";
    }


    public Map<String, Object> viewCart(String username){

        List<Cart> items = cartRepository.findByUsername(username);

        double total = 0;

        for(Cart c : items){
            Product p = productRepository.findById(c.getProductId()).orElse(null);
            if(p != null){
                total += p.getPrice() * c.getQuantity();
            }
        }

        Map<String, Object> response = new HashMap<>();
        response.put("items", items);
        response.put("total", total);

        return response;
    }
}