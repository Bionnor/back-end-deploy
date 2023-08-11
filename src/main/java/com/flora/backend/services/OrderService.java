package com.flora.backend.services;


import com.flora.backend.dtos.Order.OrderSaveDTO;
import com.flora.backend.dtos.Order.OrderView;
import com.flora.backend.dtos.Product.ProductView;
import com.flora.backend.dtos.ResponsePageDTO;
import com.flora.backend.entities.OrderState;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface OrderService {
    OrderSaveDTO addOrder(OrderSaveDTO productSaveDTO);

    OrderView updateOrder(Long productId, OrderSaveDTO productSaveDTO);
    List<ProductView> getProductsByOrderId(Long orderId);
    boolean deleteOrder(Long productId);

     ResponsePageDTO<OrderView> getFilteredOrders(
             int pageSize, int pageNumber,
            Date searchDate, OrderState orderState, Long orderId,
            String customerFullName, BigDecimal minTotalAmount, BigDecimal maxTotalAmount);

    OrderView getOrder(Long id);
}
