package com.example.demo.model;

import jakarta.persistence.*;
//import lombok.Data;

//@Data
@Entity
@Table(name = "sellers")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String shopName;

    @Column(nullable = false)
    private String pincode;

    // Additional fields as required
}
