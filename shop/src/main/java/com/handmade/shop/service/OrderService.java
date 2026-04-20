package com.handmade.shop.service;

import com.handmade.shop.dto.OrderRequest;
import com.handmade.shop.model.Order;

import java.util.List;

public interface OrderService {

    Order placeOrder(OrderRequest request);

    List<Order> getAllOrders();

    List<Order> getOrdersByUser(Long userId);

    Order getOrderById(Long orderId);

    Order updateOrderStatus(Long orderId, String status);

    void deleteOrder(Long orderId);

    List<Order> findByUsername(String username);
}