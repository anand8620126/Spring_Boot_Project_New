package com.example.demo.controller;

import com.example.demo.dto.OrderDTO;
import com.example.demo.model.Order;
import com.example.demo.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    // Endpoint to fetch all orders forwarded to the seller
    @GetMapping("/orders/{sellerId}")
    public List<OrderDTO> getOrdersForSeller(@PathVariable Long sellerId) {
        List<Order> orders =  sellerService.getOrdersForSeller(sellerId);
        return orders
                .stream()
                .map(order -> new OrderDTO(order.getId(), order.getItemName(), order.getQuantity(), order.getPrice(), order.getStatus()))
                .collect(Collectors.toList());
    }

    // Endpoint to accept an order
    @PostMapping("/accept/{orderId}")
    public String acceptOrder(@PathVariable Long orderId) {
        return sellerService.acceptOrder(orderId);
    }

    // Endpoint to reject an order
    @PostMapping("/reject/{orderId}")
    public String rejectOrder(@PathVariable Long orderId, @RequestBody String reason) {
        return sellerService.rejectOrder(orderId, reason);
    }
}
