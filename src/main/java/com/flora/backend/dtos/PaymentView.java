package com.flora.backend.dtos;

import com.flora.backend.entities.PaymentMethod;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentView {
    private Long paymentId;
    private BigDecimal amount;
    private Date paymentDate;
    private PaymentMethod paymentMethod;
    private String deliveryAddress;
}
