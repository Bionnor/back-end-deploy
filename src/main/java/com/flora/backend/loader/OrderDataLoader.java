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
    InvoiceRepository invoiceRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    OrderLineRepository orderLineRepository;
    @Autowired
    ProductRepository productRepository ;
    @Override
    public void run(String... args) throws Exception {
        Customer customer = customerRepository.findByUsername("customer").orElseThrow(()->new RuntimeException("not found"));
        List<Product> products= productRepository.findAll();

        // Create and save orders and order lines
        Orders order1 = createOrder(new Date(), "123 Main St, City", new BigDecimal("1500.00"),
                OrderState.PENDING, customer);
        OrderLine orderLine1 = createOrderLine(order1, 1, new BigDecimal("8.99"), products.get(0));
        createPayment(order1);
        createInvoice(order1);

        Orders order2 = createOrder(new Date(), "456 Elm St, Town", new BigDecimal("1200.00"),
                OrderState.PROCESSING, customer);
        OrderLine orderLine2 = createOrderLine(order2, 1, new BigDecimal("11.99"), products.get(1));
        createPayment(order2);
        createInvoice(order2);

        Orders order3 = createOrder(new Date(), "789 Oak St, Village", new BigDecimal("800.00"),
                OrderState.DELIVERED, customer);
        OrderLine orderLine3 = createOrderLine(order3, 2, new BigDecimal("18"), products.get(2));
        createPayment(order3);
        createInvoice(order3);

        Orders order4 = createOrder(new Date(), "789 Oak St, Village 2", new BigDecimal("8000.00"),
                OrderState.READY, customer);
        OrderLine orderLine4 = createOrderLine(order4, 3, new BigDecimal("13"), products.get(3));
        createPayment(order4);
        createInvoice(order4);

        Orders order5 = createOrder(new Date(), "789 Oak St, Village 3", new BigDecimal("8001.00"),
                OrderState.RETURNED, customer);
        OrderLine orderLine5 = createOrderLine(order5, 4, new BigDecimal("10.99"), products.get(4));
        createPayment(order5);
        createInvoice(order5);

        Orders order6 = createOrder(new Date(), "789 Oak St, Village 4", new BigDecimal("8002.00"),
                OrderState.DELIVERED, customer);
        OrderLine orderLine6 = createOrderLine(order6, 1, new BigDecimal("12"), products.get(5));
        createPayment(order6);
        createInvoice(order6);

        // Save orders and order lines
        orderRepository.saveAll(List.of(order1, order2, order3, order4, order5, order6));
        orderLineRepository.saveAll(List.of(orderLine1, orderLine2, orderLine3, orderLine4, orderLine5, orderLine6));

    }

    private Payment createPayment(Orders order) {
        // Create payment instance based on order information...
        PaymentOnDelivery payment = new PaymentOnDelivery();
        payment.setAmount(order.getTotalAmount());
        payment.setPaymentDate(new Date());
        payment.setPaymentMethod(PaymentMethod.PAYMENT_ON_DELIVERY);
        payment.setDeliveryAddress("Casa blanca");
        payment.setOrder(order);
        paymentRepository.save(payment);
        return payment;
    }
    private Invoice createInvoice(Orders order) {
        // Create invoice instance and associate with order and payment...
        Invoice invoice = new Invoice();
        invoice.setAmount(order.getTotalAmount());
        invoice.setIssueDate(new Date());
        invoice.setDueDate(new Date()); // Set the due date appropriately
        invoice.setStatus(order.getOrderState());
        invoice.setOrder(order);
        invoiceRepository.save(invoice);
        return invoice;
    }
    private Orders createOrder(Date orderDate, String shippingAddress, BigDecimal totalAmount,
                               OrderState orderState, Customer customer) {
        Orders order = new Orders();
        order.setOrderDate(orderDate);
        order.setShippingAddress(shippingAddress);
        order.setTotalAmount(totalAmount);
        order.setOrderState(orderState);
        order.setCustomer(customer);
        return orderRepository.save(order);
    }

    private OrderLine createOrderLine(Orders order, int quantity, BigDecimal unitPrice, Product product) {
        OrderLine orderLine = new OrderLine();
        orderLine.setQuantity(quantity);
        orderLine.setUnitPrice(unitPrice);
        orderLine.setSubtotal(unitPrice.multiply(BigDecimal.valueOf(quantity)));
        orderLine.setProduct(product);
        orderLine.setOrder(order);
        return orderLineRepository.save(orderLine);
    }

}
