package com.example.demo.controller;

import com.example.demo.dto.OrderDTO;
import com.example.demo.model.Order;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Endpoint to fetch all orders
    @GetMapping("/orders")
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = adminService.getAllOrders();
        return orders
                .stream()
                .map(order -> new OrderDTO(order.getId(), order.getItemName(), order.getQuantity(), order.getPrice(), order.getStatus()))
                .collect(Collectors.toList());
    }

    // Endpoint to forward an order to the seller
    @PostMapping("/forward/{orderId}")
    public String forwardOrder(@PathVariable Long orderId) {
        return adminService.forwardOrder(orderId);
    }
}
