package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
//import lombok.Data;

//@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = true) // Nullable until assigned to a seller
    @JsonIgnore
    private Seller seller;

    @Column(nullable = false)
    private String itemName;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String status; // e.g., "Pending", "Accepted", "Rejected"

    @Column(nullable = true)
    private String rejectionReason; // Optional field if an order is rejected

    public void setStatus(String forwardedToSeller) {
        status = forwardedToSeller;
    };

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Seller getSeller() {
        return seller;
    }

    public String getItemName() {
        return itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }



}
