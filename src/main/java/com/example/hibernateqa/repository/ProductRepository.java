package com.example.hibernateqa.repository;

import com.example.hibernateqa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
