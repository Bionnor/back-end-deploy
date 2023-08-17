package com.flora.backend.repository;

import com.flora.backend.entities.BlogCategory;
import com.flora.backend.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogCategoryRepository extends JpaRepository<BlogCategory,Long> {
    Optional<Category> findByName(String name);
}
