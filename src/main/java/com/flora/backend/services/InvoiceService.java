package com.flora.backend.services;

import com.flora.backend.entities.OrderLine;
import com.flora.backend.entities.Orders;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;

import java.io.IOException;
import java.util.List;

public interface InvoiceService {
    byte[] generateInvoicePDF( Long orderId);
    byte[] generateInvoice(Orders order, List<OrderLine> orderLines);
    Image getLogoImage() throws IOException, BadElementException;
}
