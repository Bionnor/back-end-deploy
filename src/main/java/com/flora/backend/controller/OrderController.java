package com.flora.backend.controller;


import com.flora.backend.dtos.Order.FilteredOrdersRequestDTO;
import com.flora.backend.dtos.Order.OrderSaveDTO;
import com.flora.backend.dtos.Order.OrderView;
import com.flora.backend.dtos.ResponsePageDTO;
import com.flora.backend.entities.OrderState;
import com.flora.backend.services.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<ResponsePageDTO<OrderView>> getFilteredOrders(@ModelAttribute FilteredOrdersRequestDTO requestDTO) {
        ResponsePageDTO<OrderView> result = orderService.getFilteredOrders(
                requestDTO.getPageSize(), requestDTO.getPageNumber(),
                requestDTO.getSearchDate(), requestDTO.getOrderState(), requestDTO.getOrderId(), requestDTO.getCustomerFullName(),
                requestDTO.getMinTotalAmount(), requestDTO.getMaxTotalAmount());
        return ResponseEntity.ok(result);
    }
    @PutMapping("/{productId}")
    public ResponseEntity<OrderView> updateOrder(@PathVariable Long productId, @RequestBody OrderSaveDTO updatedOrder) {
        OrderView result = orderService.updateOrder(productId, updatedOrder);
        log.info(result.toString());
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long productId) {
        boolean isDeleted = orderService.deleteOrder(productId);

        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }


    @PostMapping("/")
    public OrderSaveDTO addOrder(@RequestBody OrderSaveDTO productSaveDTO) {
        return orderService.addOrder(productSaveDTO);
    }
    @GetMapping("/{id}")
    public OrderView getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }
}
