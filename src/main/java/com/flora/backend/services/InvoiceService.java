package com.flora.backend.services;

import com.flora.backend.entities.OrderLine;
import com.flora.backend.entities.Orders;

import java.util.List;

public interface InvoiceService {
    byte[] generateInvoicePDF( Long orderId);
    byte[] generateInvoice(Orders order, List<OrderLine> orderLines);
}
