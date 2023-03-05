package com.bkdas.repository;

import com.bkdas.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductBaseRepository extends JpaRepository<Product, Long> {
}
