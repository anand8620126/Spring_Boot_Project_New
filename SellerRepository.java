package com.example.demo.repository;
import java.util.List;
import com.example.demo.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    List<Seller> findByPincode(String pincode);
}
