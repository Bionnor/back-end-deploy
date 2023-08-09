package com.flora.backend.dtos.Order;

import com.flora.backend.entities.OrderState;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class FilteredOrdersRequestDTO {
    private int pageSize = 10;
    private int pageNumber = 0;
    private Date searchDate;
    private OrderState orderState;
    private Long orderId;
    private String customerFullName;
    private BigDecimal minTotalAmount;
    private BigDecimal maxTotalAmount;
}
