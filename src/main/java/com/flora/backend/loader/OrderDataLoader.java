
package com.flora.backend.loader;

import com.flora.backend.entities.Category;
import com.flora.backend.entities.Customer;
import com.flora.backend.entities.OrderState;
import com.flora.backend.entities.Orders;
import com.flora.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
@Order(5)
public class OrderDataLoader implements CommandLineRunner {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public void run(String... args) throws Exception {
        Customer customer = customerRepository.findByUsername("customer").orElseThrow(()->new RuntimeException("not found"));
        Orders order1 = new Orders();
        order1.setOrderDate(new Date());
        order1.setShippingAddress("123 Main St, City");
        order1.setTotalAmount(new BigDecimal("1500.00"));
        order1.setOrderState(OrderState.PENDING);
        order1.setCustomer(customer); // Set the customer for the order
        orderRepository.save(order1);

        Orders order2 = new Orders();
        order2.setOrderDate(new Date());
        order2.setShippingAddress("456 Elm St, Town");
        order2.setTotalAmount(new BigDecimal("1200.00"));
        order2.setOrderState(OrderState.PROCESSING);
        order2.setCustomer(customer); // Set the customer for the order
        orderRepository.save(order2);

        Orders order3 = new Orders();
        order3.setOrderDate(new Date());
        order3.setShippingAddress("789 Oak St, Village");
        order3.setTotalAmount(new BigDecimal("800.00"));
        order3.setOrderState(OrderState.DELIVERED);
        order3.setCustomer(customer); // Set the customer for the order
        orderRepository.save(order3);
        Orders order4 = new Orders();
        order4.setOrderDate(new Date());
        order4.setShippingAddress("789 Oak St, Village 2");
        order4.setTotalAmount(new BigDecimal("8000.00"));
        order4.setOrderState(OrderState.READY);
        order4.setCustomer(customer); // Set the customer for the order
        orderRepository.save(order4);
        Orders order5 = new Orders();
        order5.setOrderDate(new Date());
        order5.setShippingAddress("789 Oak St, Village 3");
        order5.setTotalAmount(new BigDecimal("8001.00"));
        order5.setOrderState(OrderState.RETURNED);
        order5.setCustomer(customer); // Set the customer for the order
        orderRepository.save(order5);
        Orders order6 = new Orders();
        order6.setOrderDate(new Date());
        order6.setShippingAddress("789 Oak St, Village 4");
        order6.setTotalAmount(new BigDecimal("8002.00"));
        order6.setOrderState(OrderState.DELIVERED);
        order6.setCustomer(customer); // Set the customer for the order
        orderRepository.save(order6);
    }
}
