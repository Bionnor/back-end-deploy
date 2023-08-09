package com.flora.backend.services;


import com.flora.backend.dtos.Order.OrderSaveDTO;
import com.flora.backend.dtos.Order.OrderView;
import com.flora.backend.dtos.ResponsePageDTO;

public interface OrderService {
    OrderSaveDTO addOrder(OrderSaveDTO productSaveDTO);

    OrderView updateOrder(Long productId, OrderSaveDTO productSaveDTO);

    boolean deleteOrder(Long productId);

    ResponsePageDTO<OrderView> getFilteredOrders(String searchTerm, Long categoryId, int pageSize, int pageNumber);

    OrderView getOrder(Long id);
}
