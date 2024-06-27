package com.aaronbujatin.be_sweet_circle.repository;

import com.aaronbujatin.be_sweet_circle.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
