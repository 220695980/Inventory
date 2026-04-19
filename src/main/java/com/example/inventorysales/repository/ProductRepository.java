package com.example.inventorysales.repository;

import com.example.inventorysales.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByQuantityLessThanEqual(Integer reorderLevel);
}
