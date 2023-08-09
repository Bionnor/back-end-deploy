package com.flora.backend.mappers;

import com.flora.backend.dtos.Order.OrderSaveDTO;
import com.flora.backend.dtos.Order.OrderView;
import com.flora.backend.entities.Order;
import com.flora.backend.entities.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface OrderMapper {

    OrderView fromOrderToOrderView(Orders order);
    Orders fromOrderViewToOrder(OrderView orderView);
    @Mapping(target="idCategory", source="category.id")
    OrderSaveDTO fromOrderToOrderSave(Orders order);
    @Mapping(target="category.id", source="idCategory")
    Orders fromOrderSaveToOrder(OrderSaveDTO orderSaveDTO);


    List<OrderView> fromOrdersToOrderViews(List<Orders> orders);

    List<OrderView> getOrdersPage(Page<Orders> pages);

    @Mapping(target = "id", ignore = true) // Ignore updating the ID
    @Mapping(target="category.id", source="idCategory", ignore = true)
    void updateFromOrderToOrderSaveDTO(OrderSaveDTO orderSaveDTO, @MappingTarget Orders order);

}
