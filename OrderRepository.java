package com.example.demo.repository;
import java.util.List;
import com.example.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStatus(String status);

    List<Order> findBySellerId(Long sellerId);

    List<Order> findByUserId(Long userId);
}
