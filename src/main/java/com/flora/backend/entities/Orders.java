package com.flora.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Date orderDate;
    private String shippingAddress;
    private BigDecimal totalAmount;
    @Enumerated(EnumType.STRING)
    private OrderState orderState;
    @OneToMany(mappedBy = "order")
    private List<OrderLine> orderLines;
    @OneToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
    @ManyToOne
    private Customer customer;
}
