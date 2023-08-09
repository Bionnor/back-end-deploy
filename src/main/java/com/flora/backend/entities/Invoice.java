package com.flora.backend.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;

    private BigDecimal amount;
    private Date issueDate;
    private Date dueDate;
    @Enumerated(EnumType.STRING)
    private OrderState status;

    // Getters and setters
}
