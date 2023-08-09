package com.flora.backend.repository;

import com.flora.backend.entities.Invoice;
import com.flora.backend.entities.Orders;
import com.flora.backend.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {
    Page<Orders> findAll(Specification<Orders> specification, Pageable pageable);
}
