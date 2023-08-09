package com.flora.backend.mappers;

import com.flora.backend.dtos.Customer.CustomerView;
import com.flora.backend.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerView fromCustomerToCustomerView(Customer customer);
    Customer fromCustomerViewToCustomer(CustomerView  customerView);
}
