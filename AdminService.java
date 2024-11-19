package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AdminService {

    @Autowired
    private OrderRepository orderRepository;
    @PersistenceContext
    private EntityManager entityManager;

    // Fetch all orders
    public List<Order> getAllOrders() {
        entityManager.clear();
        List<Order> orders = orderRepository.findAll();

        return orders;
    }

    // Forward an order to the seller
    public String forwardOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) {
            return "Order not found!";
        }
        order.setStatus("FORWARDED_TO_SELLER");
        orderRepository.save(order);
        return "Order forwarded to seller successfully!";
    }
}
