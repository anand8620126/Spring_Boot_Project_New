package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint to place a new order
    @PostMapping("/place-order")
    public String placeOrder(@RequestBody Order order) {
        return userService.placeOrder(order);
    }

    // Endpoint to view all orders placed by the user
    @GetMapping("/orders/{userId}")
    public List<Order> getOrdersByUser(@PathVariable Long userId) {
        return userService.getOrdersByUser(userId);
    }
}
