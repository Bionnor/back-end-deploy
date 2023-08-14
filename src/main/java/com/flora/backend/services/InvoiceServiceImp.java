package com.flora.backend.services;

import com.flora.backend.entities.OrderLine;
import com.flora.backend.entities.Orders;
import com.flora.backend.exceptions.ResourceNotFoundException;
import com.flora.backend.repository.OrderLineRepository;
import com.flora.backend.repository.OrderRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.time.Instant;
import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceServiceImp implements InvoiceService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderLineRepository orderLineRepository;
    public  byte[] generateInvoice(Orders order, List<OrderLine> orderLines) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, outputStream);
            document.open();

            // Add company information (logo, name, address, phone)
            Image logo = Image.getInstance("D:\\MyWork\\InternershipWork\\Back-end\\src\\main\\resources\\static\\images\\logo.png");
            logo.setAlignment(Element.ALIGN_LEFT);
            document.add(logo);
            Paragraph companyInfo = new Paragraph("\n Flora \n Office national du conseil agricole \n Bejaâd hay hassani bd Hassan ll,\n Boujad 25060 \n Phone: +212 522 986 494", new Font(Font.FontFamily.HELVETICA, 10));
            document.add(companyInfo);

            // Add invoice details (id, date) on the right
            PdfPTable invoiceDetailsTable = new PdfPTable(1);
            invoiceDetailsTable.setWidthPercentage(40);
            PdfPCell cell = new PdfPCell(new Phrase("Invoice ID: " + order.getInvoice().getInvoiceId()));
            cell.setBorder(Rectangle.NO_BORDER);
            invoiceDetailsTable.addCell(cell);
            cell = new PdfPCell(new Phrase("Due Date: " +order.getInvoice().getDueDate()));
            cell.setBorder(Rectangle.NO_BORDER);
            invoiceDetailsTable.addCell(cell);
            cell = new PdfPCell(new Phrase("Issue Date: " +order.getInvoice().getIssueDate()));
            cell.setBorder(Rectangle.NO_BORDER);
            invoiceDetailsTable.addCell(cell);
            invoiceDetailsTable.setHorizontalAlignment(Element.ALIGN_RIGHT);
            document.add(invoiceDetailsTable);

            // Add spacing between sections
            document.add(new Paragraph("\n"));

// Add title
            Paragraph title = new Paragraph("Order N :"+order.getOrderId(), new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD));
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

// Add spacing between sections
            document.add(new Paragraph("\n"));

            // Add customer information
            Paragraph customerInfo = new Paragraph("Customer Information:\n"
                    + "Name: " + order.getCustomer().getFirstName() +" "+order.getCustomer().getLastName()+ "\n"
                    + "Address: " + order.getShippingAddress() + "\n"
                    + "Phone: " + order.getCustomer().getPhone() + "\n", new Font(Font.FontFamily.HELVETICA, 10));
            customerInfo.setSpacingBefore(10f);
            document.add(customerInfo);
            document.add(new Paragraph("\n"));
// Add product table
            float[] columnWidths = {1, 2, 2, 2}; // Adjust column widths as needed
            PdfPTable productTable = new PdfPTable(columnWidths);
            productTable.setWidthPercentage(100);
            productTable.setHeaderRows(1);

// Add table header
            cell = new PdfPCell(new Phrase("Qty"));
            productTable.addCell(cell);
            cell = new PdfPCell(new Phrase("Product"));
            productTable.addCell(cell);
            cell = new PdfPCell(new Phrase("Unit Price"));
            productTable.addCell(cell);
            cell = new PdfPCell(new Phrase("Subtotal"));
            productTable.addCell(cell);
            BigDecimal totalSubtotal = BigDecimal.ZERO;
// Add product rows
            for (OrderLine productInfo : order.getOrderLines()) {
                productTable.addCell(String.valueOf(productInfo.getQuantity()));
                productTable.addCell(productInfo.getProduct().getName());
                productTable.addCell(String.valueOf(productInfo.getUnitPrice()));
                productTable.addCell(productInfo.getSubtotal()+" DH");
                totalSubtotal =totalSubtotal.add(productInfo.getSubtotal());
            }

            document.add(productTable);
            // Add total
            Paragraph total = new Paragraph("Total: " + totalSubtotal.toString()+" DH", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD));
            total.setAlignment(Element.ALIGN_RIGHT);
            document.add(total);

            // Add footer (company signature)
            Paragraph signature = new Paragraph("\n\n\n\n\n\n\n\n Signature: __________________________", new Font(Font.FontFamily.HELVETICA, 10));
            signature.setAlignment(Element.ALIGN_LEFT);
            document.add(signature);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return outputStream.toByteArray();
    }
    public byte[] generateInvoicePDF( Long orderId) {
        // Fetch order and order lines from your repository based on the orderId
        Orders order = orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        List<OrderLine> orderLines = orderLineRepository.findAllByOrder(order);

        return  this.generateInvoice(order, orderLines);
    }
}
