package com.smartcart.smartcart.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.smartcart.smartcart.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}


