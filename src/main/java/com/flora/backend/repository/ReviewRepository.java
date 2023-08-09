package com.flora.backend.repository;

import com.flora.backend.entities.Product;
import com.flora.backend.entities.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    Review findReviewByProduct(Long idProduct);
    Review findReviewByCustomer(Long idCustomer);
    Review findReviewByCustomerAndProduct(Long idCustomer,Long idProduct);
    Page<Review> findAll(Specification<Review> specification, Pageable pageable);

    Page<Review> getReviewsByProduct(Product product, PageRequest pageable);
}
