package com.flora.backend.dtos.Order;

import com.flora.backend.dtos.Product.ProductView;
import com.flora.backend.entities.Orders;
import com.flora.backend.entities.Product;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineView {
    private Long orderLineId;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal subtotal;
    private ProductView product;
}
