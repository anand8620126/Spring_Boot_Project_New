package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private OrderRepository orderRepository;

    // Place a new order
    public String placeOrder(Order order) {
        order.setStatus("PENDING");
        orderRepository.save(order);
        return "Order placed successfully!";
    }

    // Fetch all orders for a specific user
    public List<Order> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
