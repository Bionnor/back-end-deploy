package com.flora.backend.repository;

import com.flora.backend.entities.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog,Long> {
    Page<Blog> findAll(Specification<Blog> specification, Pageable pageable);
}
