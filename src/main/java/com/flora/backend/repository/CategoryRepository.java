package com.flora.backend.repository;

import com.flora.backend.entities.Category;
import com.flora.backend.entities.Customer;
import com.flora.backend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findByName(String name);
}
