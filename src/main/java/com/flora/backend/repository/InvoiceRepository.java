package com.flora.backend.repository;

import com.flora.backend.entities.Administrator;
import com.flora.backend.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
}
