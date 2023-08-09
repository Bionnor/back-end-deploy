package com.flora.backend.dtos.Order;

import com.flora.backend.dtos.Customer.CustomerView;
import com.flora.backend.entities.OrderState;
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
public class OrderSaveDTO {
    private Long orderId;
    private Date orderDate;
    private String shippingAddress;
    private BigDecimal totalAmount;
    @Enumerated(EnumType.STRING)
    private OrderState orderState;
    private Long idCustomer;
}
