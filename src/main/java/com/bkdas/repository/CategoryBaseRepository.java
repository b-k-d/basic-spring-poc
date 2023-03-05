package com.bkdas.repository;

import com.bkdas.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryBaseRepository extends JpaRepository<Category, Long> {
}
