package com.flora.backend.loader;

import com.flora.backend.entities.*;
import com.flora.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Component
@Order(5)
public class OrderDataLoader implements CommandLineRunner {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderLineRepository orderLineRepository;
    @Autowired
    ProductRepository productRepository ;
    @Override
    public void run(String... args) throws Exception {
        Customer customer = customerRepository.findByUsername("customer").orElseThrow(()->new RuntimeException("not found"));
        List<Product> products= productRepository.findAll();

        Orders order1 = new Orders();
        order1.setOrderDate(new Date());
        order1.setShippingAddress("123 Main St, City");
        order1.setTotalAmount(new BigDecimal("1500.00"));
        order1.setOrderState(OrderState.PENDING);
        order1.setCustomer(customer); // Set the customer for the order
        orderRepository.save(order1);



        OrderLine orderLine = new OrderLine();
        orderLine.setQuantity(1);
        orderLine.setUnitPrice(new BigDecimal("8.99"));
        orderLine.setSubtotal(orderLine.getUnitPrice().multiply(BigDecimal.valueOf(orderLine.getQuantity())));
        orderLine.setProduct(products.get(0));
        orderLine.setOrder(order1);
        orderLineRepository.save(orderLine);

        Orders order2 = new Orders();
        order2.setOrderDate(new Date());
        order2.setShippingAddress("456 Elm St, Town");
        order2.setTotalAmount(new BigDecimal("1200.00"));
        order2.setOrderState(OrderState.PROCESSING);
        order2.setCustomer(customer); // Set the customer for the order
        orderRepository.save(order2);

        OrderLine orderLine2 = new OrderLine();
        orderLine2.setQuantity(1);
        orderLine2.setUnitPrice(new BigDecimal("11.99"));
        orderLine2.setSubtotal(orderLine2.getUnitPrice().multiply(BigDecimal.valueOf(orderLine2.getQuantity())));
        orderLine2.setProduct(products.get(1));
        orderLine2.setOrder(order2);
        orderLineRepository.save(orderLine2);

        Orders order3 = new Orders();
        order3.setOrderDate(new Date());
        order3.setShippingAddress("789 Oak St, Village");
        order3.setTotalAmount(new BigDecimal("800.00"));
        order3.setOrderState(OrderState.DELIVERED);
        order3.setCustomer(customer); // Set the customer for the order
        orderRepository.save(order3);

        OrderLine orderLine3 = new OrderLine();
        orderLine3.setQuantity(2);
        orderLine3.setUnitPrice(new BigDecimal("18"));
        orderLine3.setSubtotal(orderLine3.getUnitPrice().multiply(BigDecimal.valueOf(orderLine3.getQuantity())));
        orderLine3.setProduct(products.get(2));
        orderLine3.setOrder(order3);
        orderLineRepository.save(orderLine3);

        Orders order4 = new Orders();
        order4.setOrderDate(new Date());
        order4.setShippingAddress("789 Oak St, Village 2");
        order4.setTotalAmount(new BigDecimal("8000.00"));
        order4.setOrderState(OrderState.READY);
        order4.setCustomer(customer); // Set the customer for the order
        orderRepository.save(order4);

        OrderLine orderLine4 = new OrderLine();
        orderLine4.setQuantity(3);
        orderLine4.setUnitPrice(new BigDecimal("13"));
        orderLine4.setSubtotal(orderLine4.getUnitPrice().multiply(BigDecimal.valueOf(orderLine4.getQuantity())));
        orderLine4.setProduct(products.get(3));
        orderLine4.setOrder(order4);
        orderLineRepository.save(orderLine4);

        Orders order5 = new Orders();
        order5.setOrderDate(new Date());
        order5.setShippingAddress("789 Oak St, Village 3");
        order5.setTotalAmount(new BigDecimal("8001.00"));
        order5.setOrderState(OrderState.RETURNED);
        order5.setCustomer(customer); // Set the customer for the order
        orderRepository.save(order5);

        OrderLine orderLine5 = new OrderLine();
        orderLine5.setQuantity(4);
        orderLine5.setUnitPrice(new BigDecimal("10.99"));
        orderLine5.setSubtotal(orderLine5.getUnitPrice().multiply(BigDecimal.valueOf(orderLine5.getQuantity())));
        orderLine5.setProduct(products.get(4));
        orderLine5.setOrder(order5);
        orderLineRepository.save(orderLine5);

        Orders order6 = new Orders();
        order6.setOrderDate(new Date());
        order6.setShippingAddress("789 Oak St, Village 4");
        order6.setTotalAmount(new BigDecimal("8002.00"));
        order6.setOrderState(OrderState.DELIVERED);
        order6.setCustomer(customer); // Set the customer for the order
        orderRepository.save(order6);

        OrderLine orderLine6 = new OrderLine();
        orderLine6.setQuantity(1);
        orderLine6.setUnitPrice(new BigDecimal("12"));
        orderLine6.setSubtotal(orderLine4.getUnitPrice().multiply(BigDecimal.valueOf(orderLine6.getQuantity())));
        orderLine6.setProduct(products.get(5));
        orderLine6.setOrder(order4);
        orderLineRepository.save(orderLine6);
    }
}
