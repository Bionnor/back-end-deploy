package com.flora.backend.repository;

import com.flora.backend.entities.Invoice;
import com.flora.backend.entities.OrderLine;
import com.flora.backend.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
    List<OrderLine> findAllByOrder(Orders Order);
}
