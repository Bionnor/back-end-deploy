package com.flora.backend.repository;

import com.flora.backend.entities.Invoice;
import com.flora.backend.entities.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
}
