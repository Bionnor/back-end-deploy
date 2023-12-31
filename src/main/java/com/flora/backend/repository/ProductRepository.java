package com.flora.backend.repository;

import com.flora.backend.dtos.Product.ProductSaveDTO;
import com.flora.backend.entities.Category;
import com.flora.backend.entities.FinalProduct;
import com.flora.backend.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<FinalProduct,Long> {
    @Query("select p from FinalProduct p where   lower(p.name) like lower(?1) OR upper(p.name) like upper(?2) ")
    Page<FinalProduct> searchProduct(String keywordLowerCase, String keywordUpperCase, PageRequest pageable);
    Page<FinalProduct> getProductsByCategory(Category category, PageRequest pageable);

    Page<FinalProduct> findAll(Specification<FinalProduct> specification, Pageable pageable);
}
