package com.example.demo.repository;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    static List<Product> findAllByNameContaining(String name) {
        return null;
    }
}
