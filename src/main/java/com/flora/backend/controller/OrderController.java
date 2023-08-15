package com.flora.backend.controller;


import com.flora.backend.dtos.Order.FilteredOrdersRequestDTO;
import com.flora.backend.dtos.Order.OrderSaveDTO;
import com.flora.backend.dtos.Order.OrderView;
import com.flora.backend.dtos.Product.ProductView;
import com.flora.backend.dtos.ResponsePageDTO;
import com.flora.backend.entities.OrderLine;
import com.flora.backend.entities.OrderState;
import com.flora.backend.services.InvoiceService;
import com.flora.backend.services.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")

@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private InvoiceService invoiceService;
    @GetMapping("/generate/{orderId}")
    public ResponseEntity<byte[]> generateInvoicePDF(@PathVariable Long orderId) {
        byte[] pdfContent = this.invoiceService.generateInvoicePDF(orderId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "invoice.pdf");

        return new ResponseEntity<>(pdfContent, headers, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<ResponsePageDTO<OrderView>> getFilteredOrders(@ModelAttribute FilteredOrdersRequestDTO requestDTO) {
        ResponsePageDTO<OrderView> result = orderService.getFilteredOrders(
                requestDTO.getPageSize(), requestDTO.getPageNumber(),
                requestDTO.getSearchDate(), requestDTO.getOrderState(), requestDTO.getOrderId(), requestDTO.getCustomerFullName(),
                requestDTO.getMinTotalAmount(), requestDTO.getMaxTotalAmount());
        return ResponseEntity.ok(result);
    }
    @GetMapping("/{orderId}/products")
    public ResponseEntity<List<ProductView>> getProductsByOrderId(@PathVariable Long orderId) {
        List<ProductView> products = orderService.getProductsByOrderId(orderId);
        return ResponseEntity.ok(products);
    }
    @PutMapping("/{orderId}")
    public ResponseEntity<OrderView> updateOrder(@PathVariable Long orderId, @RequestBody OrderSaveDTO updatedOrder) {
        OrderView result = orderService.updateOrder(orderId, updatedOrder);
        log.info(result.toString());
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        boolean isDeleted = orderService.deleteOrder(orderId);

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
