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
public class SellerService {

    @Autowired
    private OrderRepository orderRepository;

    @PersistenceContext
    private EntityManager entityManager;

    // Fetch all orders assigned to a seller
    public List<Order> getOrdersForSeller(Long sellerId) {
        entityManager.clear();
        return orderRepository.findBySellerId(sellerId);
    }

    // Accept an order
    public String acceptOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) {
            return "Order not found!";
        }
        order.setStatus("ACCEPTED");
        orderRepository.save(order);
        return "Order accepted successfully!";
    }

    // Reject an order with a reason
    public String rejectOrder(Long orderId, String reason) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) {
            return "Order not found!";
        }
        order.setStatus("REJECTED");
        orderRepository.save(order);
        return "Order rejected with reason: " + reason;
    }
}
