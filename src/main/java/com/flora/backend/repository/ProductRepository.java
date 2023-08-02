package com.flora.backend.repository;

import com.flora.backend.entities.Category;
import com.flora.backend.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("select p from Product p where   lower(p.name) like lower(?1) OR upper(p.name) like upper(?2) ")
    Page<Product> searchProduct(String keywordLowerCase, String keywordUpperCase, PageRequest pageable);
    Page<Product> getProductsByCategory(Category category, PageRequest pageable);


}
