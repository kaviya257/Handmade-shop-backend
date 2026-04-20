package com.handmade.shop.controller;

import com.handmade.shop.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @PostMapping("/add")
    public String add(@RequestParam String username,
                      @RequestParam Long productId){
        return cartService.addToCart(username, productId);
    }


    @PostMapping("/decrease")
    public String decrease(@RequestParam String username,
                           @RequestParam Long productId){
        return cartService.decrease(username, productId);
    }


    @GetMapping("/{username}")
    public Map<String, Object> view(@PathVariable String username){
        return cartService.viewCart(username);
    }
}
