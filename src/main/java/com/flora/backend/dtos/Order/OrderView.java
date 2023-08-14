package com.flora.backend.dtos.Order;

import com.flora.backend.dtos.Category.CategoryView;
import com.flora.backend.dtos.Customer.CustomerView;
import com.flora.backend.dtos.InvoiceView;
import com.flora.backend.dtos.PaymentView;
import com.flora.backend.entities.Customer;
import com.flora.backend.entities.Invoice;
import com.flora.backend.entities.OrderLine;
import com.flora.backend.entities.OrderState;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderView {
    private Long orderId;
    private Date orderDate;
    private String shippingAddress;
    private BigDecimal totalAmount;
    @Enumerated(EnumType.STRING)
    private OrderState orderState;
    private List<OrderLineView> orderLines;
    private CustomerView customer;
    private InvoiceView invoice;
    private PaymentView payment;

}
