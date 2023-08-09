package com.flora.backend.repository;

import com.flora.backend.entities.Invoice;
import com.flora.backend.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
