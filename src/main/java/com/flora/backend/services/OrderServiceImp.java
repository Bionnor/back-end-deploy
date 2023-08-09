package com.flora.backend.services;


import com.flora.backend.dtos.Category.CategoryView;
import com.flora.backend.dtos.Order.OrderSaveDTO;
import com.flora.backend.dtos.Order.OrderView;
import com.flora.backend.dtos.ResponsePageDTO;
import com.flora.backend.entities.Category;
import com.flora.backend.entities.Customer;
import com.flora.backend.entities.OrderState;
import com.flora.backend.entities.Orders;
import com.flora.backend.exceptions.DataAccessException;
import com.flora.backend.exceptions.ResourceNotFoundException;
import com.flora.backend.mappers.CategoryMapper;
import com.flora.backend.mappers.OrderMapper;
import com.flora.backend.repository.CategoryRepository;
import com.flora.backend.repository.OrderRepository;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.flora.backend.Utils.ResponsePageUtils.createResponsePage;

@Service
@AllArgsConstructor
@Transactional
@NoArgsConstructor
@Slf4j
public class OrderServiceImp implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public OrderSaveDTO addOrder(OrderSaveDTO orderSaveDTO) {
        try {
            Orders order = orderMapper.fromOrderSaveToOrder(orderSaveDTO);
            return orderMapper.fromOrderToOrderSave(orderRepository.save(order));
        } catch (DataAccessException ex) {
            // Handle database-related issues
            throw new RuntimeException("Error while adding order", ex);
        }
    }

    @Override
    public OrderView updateOrder(Long orderId, OrderSaveDTO orderSaveDTO) {
        try {
            Orders existingOrder = orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order not found !"));
            orderMapper.updateFromOrderToOrderSaveDTO(orderSaveDTO, existingOrder);
            return orderMapper.fromOrderToOrderView(orderRepository.save(existingOrder));
        } catch (ResourceNotFoundException ex) {
            // Handle order not found
            throw ex;
        } catch (DataAccessException ex) {
            // Handle database-related issues
            throw new RuntimeException("Error while updating order", ex);
        }
    }

    @Override
    public boolean deleteOrder(Long orderId) {
        try {
            Orders existingOrder = orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order not found !"));
            if (existingOrder != null) {
                orderRepository.delete(existingOrder);
                return true;
            }
            return false;
        } catch (ResourceNotFoundException ex) {
            // Handle order not found
            throw ex;
        } catch (DataAccessException ex) {
            // Handle database-related issues
            throw new RuntimeException("Error while deleting order", ex);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public ResponsePageDTO<OrderView> getFilteredOrders(
             int pageSize, int pageNumber,
            Date searchDate, OrderState orderState, Long orderId,
            String customerFullName, BigDecimal minTotalAmount, BigDecimal maxTotalAmount) {
        try {
            Specification<Orders> specification = (root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();

                if (searchDate != null) {
                    predicates.add(criteriaBuilder.equal(root.get("orderDate"), searchDate));
                }

                if (orderState != null) {
                    predicates.add(criteriaBuilder.equal(root.get("orderState"), orderState));
                }

                if (orderId != null) {
                    predicates.add(criteriaBuilder.equal(root.get("orderId"), orderId));
                }

                if (customerFullName != null && !customerFullName.isEmpty()) {
                    Join<Orders, Customer> customerJoin = root.join("customer");

                    // Split the full name into first name and last name
                    String[] nameParts = customerFullName.split(" ", 2);
                    if (nameParts.length > 0) {
                        predicates.add(criteriaBuilder.like(criteriaBuilder.lower(customerJoin.get("firstName")), "%" + nameParts[0].toLowerCase() + "%"));
                    }
                    if (nameParts.length > 1) {
                        predicates.add(criteriaBuilder.like(criteriaBuilder.lower(customerJoin.get("lastName")), "%" + nameParts[1].toLowerCase() + "%"));
                    }
                }

                if (minTotalAmount != null) {
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("totalAmount"), minTotalAmount));
                }

                if (maxTotalAmount != null) {
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("totalAmount"), maxTotalAmount));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };

            Page<Orders> pages = orderRepository.findAll(specification, PageRequest.of(pageNumber, pageSize));
            return createResponsePage(orderMapper.getOrdersPage(pages),pages.getTotalPages(),pageNumber,pageSize);
        } catch (DataAccessException ex) {
            // Handle database-related issues
            throw new RuntimeException("Error while retrieving filtered orders", ex);
        }
    }

    @Override
    public OrderView getOrder(Long id) {
        try {
            return orderMapper.fromOrderToOrderView(orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found !")));
        } catch (ResourceNotFoundException ex) {
            // Handle order not found
            throw ex;
        } catch (DataAccessException ex) {
            // Handle database-related issues
            throw new RuntimeException("Error while retrieving order", ex);
        }
    }



}
