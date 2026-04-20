package com.handmade.shop.repository;

import com.handmade.shop.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByUsername(String username);

    Cart findByUsernameAndProductId(String username, Long productId);
}
