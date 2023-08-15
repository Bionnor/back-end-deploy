package com.flora.backend.mappers;

import com.flora.backend.dtos.InvoiceView;
import com.flora.backend.dtos.Order.OrderSaveDTO;
import com.flora.backend.dtos.Order.OrderView;
import com.flora.backend.entities.Invoice;
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
    Invoice map(InvoiceView value);
    Orders fromOrderViewToOrder(OrderView orderView);
    @Mapping(target="idCustomer", source="customer.id")
    OrderSaveDTO fromOrderToOrderSave(Orders order);
    @Mapping(target="customer.id", source="idCustomer")
    Orders fromOrderSaveToOrder(OrderSaveDTO orderSaveDTO);


    List<OrderView> fromOrdersToOrderViews(List<Orders> orders);

    List<OrderView> getOrdersPage(Page<Orders> pages);

    @Mapping(target = "orderId", ignore = true) // Ignore updating the ID
    @Mapping(target="customer.id", source="idCustomer", ignore = true)
    void updateFromOrderToOrderSaveDTO(OrderSaveDTO orderSaveDTO, @MappingTarget Orders order);

}
