package com.flora.backend.services;


import com.flora.backend.dtos.Category.CategoryView;
import com.flora.backend.dtos.Order.OrderSaveDTO;
import com.flora.backend.dtos.Order.OrderView;
import com.flora.backend.dtos.ResponsePageDTO;
import com.flora.backend.entities.Category;
import com.flora.backend.entities.Order;
import com.flora.backend.entities.Orders;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
@NoArgsConstructor
@Slf4j
public class OrderServiceImp implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private OrderMapper orderMapper;





    @Override
    public OrderSaveDTO addOrder(OrderSaveDTO orderSaveDTO) {
        Orders order=orderMapper.fromOrderSaveToOrder(orderSaveDTO);
        return orderMapper.fromOrderToOrderSave(orderRepository.save(order));

    }
    @Override
    public OrderView updateOrder(Long orderId, OrderSaveDTO orderSaveDTO){
        Orders existingOrder = orderRepository.findById(orderId).orElse(null);
        orderMapper.updateFromOrderToOrderSaveDTO(orderSaveDTO,existingOrder);
        Category category = categoryRepository.findById(orderSaveDTO.getIdCategory()).orElse(null);
        existingOrder.setCategory(category);
        return orderMapper.fromOrderToOrderView(orderRepository.save(existingOrder));
    }
    @Override
    public boolean deleteOrder(Long orderId){
        // Check if the order with the given ID exists
        Orders existingOrder = orderRepository.findById(orderId).orElse(null);
        if (existingOrder != null) {
            orderRepository.delete(existingOrder);
            return true;
        }
        return false;
    }
    @Transactional(readOnly = true)
    @Override
    public ResponsePageDTO<OrderView> getFilteredOrders(String searchTerm, Long categoryId, int pageSize, int pageNumber) {

        Specification<Orders> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (searchTerm != null && !searchTerm.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + searchTerm.toLowerCase() + "%"));
            }

            if (categoryId != null) {
                Join<Orders, Category> categoryJoin = root.join("category");
                predicates.add(criteriaBuilder.equal(categoryJoin.get("id"), categoryId));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        Page<Orders> pages=  orderRepository.findAll(specification, PageRequest.of(pageNumber, pageSize));
        ResponsePageDTO<OrderView> orderViewResponsePageDTO= new ResponsePageDTO();
        orderViewResponsePageDTO.setResponseList(orderMapper.getOrdersPage(pages));
        orderViewResponsePageDTO.setTotalPages(pages.getTotalPages());
        orderViewResponsePageDTO.setCurrentPage(pageNumber);
        orderViewResponsePageDTO.setPageSize(pageSize);
        return orderViewResponsePageDTO;
    }

    @Override
    public OrderView getOrder(Long id) {
        return orderMapper.fromOrderToOrderView(orderRepository.findById(id).orElseThrow(() -> new RuntimeException(
                "Order Not Found!")));
    }


}
