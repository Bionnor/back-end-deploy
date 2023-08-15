package com.flora.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;
    private BigDecimal amount;
    private Date issueDate;
    private Date dueDate;
    @Enumerated(EnumType.STRING)
    private OrderState status;
    @OneToOne
    @JoinColumn(name = "order_id")
    private Orders order;


}
