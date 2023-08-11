package com.flora.backend.dtos;

import com.flora.backend.entities.OrderState;
import com.flora.backend.entities.Orders;
import com.flora.backend.entities.Payment;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceView {
    private Long invoiceId;
    private BigDecimal amount;
    private Date issueDate;
    private Date dueDate;
    private OrderState status;
    private PaymentView payment;
}
