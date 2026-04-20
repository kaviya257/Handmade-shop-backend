package com.handmade.shop.controller;

import com.handmade.shop.model.Product;
import com.handmade.shop.model.Order;
import com.handmade.shop.repository.ProductRepository;
import com.handmade.shop.repository.OrderRepository;
import com.handmade.shop.repository.UserRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    private final ProductRepository productRepo;
    private final OrderRepository orderRepo;
    private final UserRepository userRepo;

    public AdminController(ProductRepository productRepo,
                           OrderRepository orderRepo,
                           UserRepository userRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
    }

    // ================= PRODUCT MANAGEMENT =================

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return productRepo.save(product);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepo.deleteById(id);
        return "Product deleted";
    }

    // ================= ORDER MANAGEMENT =================

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @PutMapping("/order/{id}/status")
    public String updateStatus(@PathVariable Long id,
                               @RequestParam String status) {

        Order order = orderRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(status);
        orderRepo.save(order);

        return "Order status updated";
    }

    // ================= USER VIEW =================

    @GetMapping("/users")
    public Object getUsers() {
        return userRepo.findAll();
    }
}