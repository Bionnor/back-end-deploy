package com.flora.backend.mappers;

import com.flora.backend.dtos.Category.CategoryView;
import com.flora.backend.dtos.Customer.CustomerView;
import com.flora.backend.dtos.InvoiceView;
import com.flora.backend.dtos.Order.OrderLineView;
import com.flora.backend.dtos.Order.OrderSaveDTO;
import com.flora.backend.dtos.Order.OrderView;
import com.flora.backend.dtos.Payment.PaymentView;
import com.flora.backend.dtos.Product.ProductView;
import com.flora.backend.entities.Category;
import com.flora.backend.entities.Customer;
import com.flora.backend.entities.Invoice;
import com.flora.backend.entities.OrderLine;
import com.flora.backend.entities.Orders;
import com.flora.backend.entities.Payment;
import com.flora.backend.entities.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-17T16:25:40+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19 (Eclipse Adoptium)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderView fromOrderToOrderView(Orders order) {
        if ( order == null ) {
            return null;
        }

        OrderView orderView = new OrderView();

        if ( order.getOrderId() != null ) {
            orderView.setOrderId( order.getOrderId() );
        }
        if ( order.getOrderDate() != null ) {
            orderView.setOrderDate( order.getOrderDate() );
        }
        if ( order.getShippingAddress() != null ) {
            orderView.setShippingAddress( order.getShippingAddress() );
        }
        if ( order.getTotalAmount() != null ) {
            orderView.setTotalAmount( order.getTotalAmount() );
        }
        if ( order.getOrderState() != null ) {
            orderView.setOrderState( order.getOrderState() );
        }
        List<OrderLineView> list = orderLineListToOrderLineViewList( order.getOrderLines() );
        if ( list != null ) {
            orderView.setOrderLines( list );
        }
        if ( order.getCustomer() != null ) {
            orderView.setCustomer( customerToCustomerView( order.getCustomer() ) );
        }
        if ( order.getInvoice() != null ) {
            orderView.setInvoice( invoiceToInvoiceView( order.getInvoice() ) );
        }
        if ( order.getPayment() != null ) {
            orderView.setPayment( paymentToPaymentView( order.getPayment() ) );
        }

        return orderView;
    }

    @Override
    public Invoice map(InvoiceView value) {
        if ( value == null ) {
            return null;
        }

        Invoice invoice = new Invoice();

        if ( value.getInvoiceId() != null ) {
            invoice.setInvoiceId( value.getInvoiceId() );
        }
        if ( value.getAmount() != null ) {
            invoice.setAmount( value.getAmount() );
        }
        if ( value.getIssueDate() != null ) {
            invoice.setIssueDate( value.getIssueDate() );
        }
        if ( value.getDueDate() != null ) {
            invoice.setDueDate( value.getDueDate() );
        }
        if ( value.getStatus() != null ) {
            invoice.setStatus( value.getStatus() );
        }

        return invoice;
    }

    @Override
    public Orders fromOrderViewToOrder(OrderView orderView) {
        if ( orderView == null ) {
            return null;
        }

        Orders orders = new Orders();

        if ( orderView.getOrderId() != null ) {
            orders.setOrderId( orderView.getOrderId() );
        }
        if ( orderView.getOrderDate() != null ) {
            orders.setOrderDate( orderView.getOrderDate() );
        }
        if ( orderView.getShippingAddress() != null ) {
            orders.setShippingAddress( orderView.getShippingAddress() );
        }
        if ( orderView.getTotalAmount() != null ) {
            orders.setTotalAmount( orderView.getTotalAmount() );
        }
        if ( orderView.getOrderState() != null ) {
            orders.setOrderState( orderView.getOrderState() );
        }
        List<OrderLine> list = orderLineViewListToOrderLineList( orderView.getOrderLines() );
        if ( list != null ) {
            orders.setOrderLines( list );
        }
        if ( orderView.getInvoice() != null ) {
            orders.setInvoice( map( orderView.getInvoice() ) );
        }
        if ( orderView.getPayment() != null ) {
            orders.setPayment( paymentViewToPayment( orderView.getPayment() ) );
        }
        if ( orderView.getCustomer() != null ) {
            orders.setCustomer( customerViewToCustomer( orderView.getCustomer() ) );
        }

        return orders;
    }

    @Override
    public OrderSaveDTO fromOrderToOrderSave(Orders order) {
        if ( order == null ) {
            return null;
        }

        OrderSaveDTO orderSaveDTO = new OrderSaveDTO();

        Long id = orderCustomerId( order );
        if ( id != null ) {
            orderSaveDTO.setIdCustomer( id );
        }
        if ( order.getOrderId() != null ) {
            orderSaveDTO.setOrderId( order.getOrderId() );
        }
        if ( order.getOrderDate() != null ) {
            orderSaveDTO.setOrderDate( order.getOrderDate() );
        }
        if ( order.getShippingAddress() != null ) {
            orderSaveDTO.setShippingAddress( order.getShippingAddress() );
        }
        if ( order.getTotalAmount() != null ) {
            orderSaveDTO.setTotalAmount( order.getTotalAmount() );
        }
        if ( order.getOrderState() != null ) {
            orderSaveDTO.setOrderState( order.getOrderState() );
        }

        return orderSaveDTO;
    }

    @Override
    public Orders fromOrderSaveToOrder(OrderSaveDTO orderSaveDTO) {
        if ( orderSaveDTO == null ) {
            return null;
        }

        Orders orders = new Orders();

        if ( orderSaveDTO != null ) {
            orders.setCustomer( orderSaveDTOToCustomer( orderSaveDTO ) );
        }
        if ( orderSaveDTO.getOrderId() != null ) {
            orders.setOrderId( orderSaveDTO.getOrderId() );
        }
        if ( orderSaveDTO.getOrderDate() != null ) {
            orders.setOrderDate( orderSaveDTO.getOrderDate() );
        }
        if ( orderSaveDTO.getShippingAddress() != null ) {
            orders.setShippingAddress( orderSaveDTO.getShippingAddress() );
        }
        if ( orderSaveDTO.getTotalAmount() != null ) {
            orders.setTotalAmount( orderSaveDTO.getTotalAmount() );
        }
        if ( orderSaveDTO.getOrderState() != null ) {
            orders.setOrderState( orderSaveDTO.getOrderState() );
        }

        return orders;
    }

    @Override
    public List<OrderView> fromOrdersToOrderViews(List<Orders> orders) {
        if ( orders == null ) {
            return null;
        }

        List<OrderView> list = new ArrayList<OrderView>( orders.size() );
        for ( Orders orders1 : orders ) {
            list.add( fromOrderToOrderView( orders1 ) );
        }

        return list;
    }

    @Override
    public List<OrderView> getOrdersPage(Page<Orders> pages) {
        if ( pages == null ) {
            return null;
        }

        List<OrderView> list = new ArrayList<OrderView>();
        for ( Orders orders : pages ) {
            list.add( fromOrderToOrderView( orders ) );
        }

        return list;
    }

    @Override
    public void updateFromOrderToOrderSaveDTO(OrderSaveDTO orderSaveDTO, Orders order) {
        if ( orderSaveDTO == null ) {
            return;
        }

        if ( order.getCustomer() == null ) {
            order.setCustomer( new Customer() );
        }
        orderSaveDTOToCustomer1( orderSaveDTO, order.getCustomer() );
        if ( orderSaveDTO.getOrderDate() != null ) {
            order.setOrderDate( orderSaveDTO.getOrderDate() );
        }
        else {
            order.setOrderDate( null );
        }
        if ( orderSaveDTO.getShippingAddress() != null ) {
            order.setShippingAddress( orderSaveDTO.getShippingAddress() );
        }
        else {
            order.setShippingAddress( null );
        }
        if ( orderSaveDTO.getTotalAmount() != null ) {
            order.setTotalAmount( orderSaveDTO.getTotalAmount() );
        }
        else {
            order.setTotalAmount( null );
        }
        if ( orderSaveDTO.getOrderState() != null ) {
            order.setOrderState( orderSaveDTO.getOrderState() );
        }
        else {
            order.setOrderState( null );
        }
    }

    protected List<CategoryView> categoryListToCategoryViewList(List<Category> list) {
        if ( list == null ) {
            return null;
        }

        List<CategoryView> list1 = new ArrayList<CategoryView>( list.size() );
        for ( Category category : list ) {
            list1.add( categoryToCategoryView( category ) );
        }

        return list1;
    }

    protected CategoryView categoryToCategoryView(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryView categoryView = new CategoryView();

        if ( category.getId() != null ) {
            categoryView.setId( category.getId() );
        }
        if ( category.getName() != null ) {
            categoryView.setName( category.getName() );
        }
        if ( category.getDescription() != null ) {
            categoryView.setDescription( category.getDescription() );
        }
        if ( category.getCreatedAt() != null ) {
            categoryView.setCreatedAt( category.getCreatedAt() );
        }
        if ( category.getUpdatedAt() != null ) {
            categoryView.setUpdatedAt( category.getUpdatedAt() );
        }
        categoryView.setActive( category.isActive() );
        if ( category.getParentCategory() != null ) {
            categoryView.setParentCategory( categoryToCategoryView( category.getParentCategory() ) );
        }
        List<CategoryView> list = categoryListToCategoryViewList( category.getSubcategories() );
        if ( list != null ) {
            categoryView.setSubcategories( list );
        }

        return categoryView;
    }

    protected ProductView productToProductView(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductView productView = new ProductView();

        if ( product.getId() != null ) {
            productView.setId( product.getId() );
        }
        if ( product.getName() != null ) {
            productView.setName( product.getName() );
        }
        if ( product.getDescription() != null ) {
            productView.setDescription( product.getDescription() );
        }
        productView.setPrice( product.getPrice() );
        productView.setQuantity( product.getQuantity() );
        if ( product.getCategory() != null ) {
            productView.setCategory( categoryToCategoryView( product.getCategory() ) );
        }
        if ( product.getImageUrl() != null ) {
            productView.setImageUrl( product.getImageUrl() );
        }
        if ( product.getCreatedAt() != null ) {
            productView.setCreatedAt( product.getCreatedAt() );
        }
        if ( product.getUpdatedAt() != null ) {
            productView.setUpdatedAt( product.getUpdatedAt() );
        }
        productView.setActive( product.isActive() );

        return productView;
    }

    protected OrderLineView orderLineToOrderLineView(OrderLine orderLine) {
        if ( orderLine == null ) {
            return null;
        }

        OrderLineView orderLineView = new OrderLineView();

        if ( orderLine.getOrderLineId() != null ) {
            orderLineView.setOrderLineId( orderLine.getOrderLineId() );
        }
        orderLineView.setQuantity( orderLine.getQuantity() );
        if ( orderLine.getUnitPrice() != null ) {
            orderLineView.setUnitPrice( orderLine.getUnitPrice() );
        }
        if ( orderLine.getSubtotal() != null ) {
            orderLineView.setSubtotal( orderLine.getSubtotal() );
        }
        if ( orderLine.getProduct() != null ) {
            orderLineView.setProduct( productToProductView( orderLine.getProduct() ) );
        }

        return orderLineView;
    }

    protected List<OrderLineView> orderLineListToOrderLineViewList(List<OrderLine> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderLineView> list1 = new ArrayList<OrderLineView>( list.size() );
        for ( OrderLine orderLine : list ) {
            list1.add( orderLineToOrderLineView( orderLine ) );
        }

        return list1;
    }

    protected CustomerView customerToCustomerView(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerView customerView = new CustomerView();

        if ( customer.getId() != null ) {
            customerView.setId( customer.getId() );
        }
        if ( customer.getEmail() != null ) {
            customerView.setEmail( customer.getEmail() );
        }
        if ( customer.getUsername() != null ) {
            customerView.setUsername( customer.getUsername() );
        }
        if ( customer.getPassword() != null ) {
            customerView.setPassword( customer.getPassword() );
        }
        if ( customer.getIsOnline() != null ) {
            customerView.setIsOnline( customer.getIsOnline() );
        }
        if ( customer.getPhotoUrl() != null ) {
            customerView.setPhotoUrl( customer.getPhotoUrl() );
        }
        if ( customer.getFirstName() != null ) {
            customerView.setFirstName( customer.getFirstName() );
        }
        if ( customer.getLastName() != null ) {
            customerView.setLastName( customer.getLastName() );
        }
        if ( customer.getSexe() != null ) {
            customerView.setSexe( customer.getSexe() );
        }
        if ( customer.getPhone() != null ) {
            customerView.setPhone( customer.getPhone() );
        }

        return customerView;
    }

    protected InvoiceView invoiceToInvoiceView(Invoice invoice) {
        if ( invoice == null ) {
            return null;
        }

        InvoiceView invoiceView = new InvoiceView();

        if ( invoice.getInvoiceId() != null ) {
            invoiceView.setInvoiceId( invoice.getInvoiceId() );
        }
        if ( invoice.getAmount() != null ) {
            invoiceView.setAmount( invoice.getAmount() );
        }
        if ( invoice.getIssueDate() != null ) {
            invoiceView.setIssueDate( invoice.getIssueDate() );
        }
        if ( invoice.getDueDate() != null ) {
            invoiceView.setDueDate( invoice.getDueDate() );
        }
        if ( invoice.getStatus() != null ) {
            invoiceView.setStatus( invoice.getStatus() );
        }

        return invoiceView;
    }

    protected PaymentView paymentToPaymentView(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        PaymentView paymentView = new PaymentView();

        if ( payment.getPaymentId() != null ) {
            paymentView.setPaymentId( payment.getPaymentId() );
        }
        if ( payment.getAmount() != null ) {
            paymentView.setAmount( payment.getAmount() );
        }
        if ( payment.getPaymentDate() != null ) {
            paymentView.setPaymentDate( payment.getPaymentDate() );
        }
        if ( payment.getPaymentMethod() != null ) {
            paymentView.setPaymentMethod( payment.getPaymentMethod() );
        }

        return paymentView;
    }

    protected List<Category> categoryViewListToCategoryList(List<CategoryView> list) {
        if ( list == null ) {
            return null;
        }

        List<Category> list1 = new ArrayList<Category>( list.size() );
        for ( CategoryView categoryView : list ) {
            list1.add( categoryViewToCategory( categoryView ) );
        }

        return list1;
    }

    protected Category categoryViewToCategory(CategoryView categoryView) {
        if ( categoryView == null ) {
            return null;
        }

        Category category = new Category();

        if ( categoryView.getId() != null ) {
            category.setId( categoryView.getId() );
        }
        if ( categoryView.getName() != null ) {
            category.setName( categoryView.getName() );
        }
        if ( categoryView.getDescription() != null ) {
            category.setDescription( categoryView.getDescription() );
        }
        if ( categoryView.getCreatedAt() != null ) {
            category.setCreatedAt( categoryView.getCreatedAt() );
        }
        if ( categoryView.getUpdatedAt() != null ) {
            category.setUpdatedAt( categoryView.getUpdatedAt() );
        }
        category.setActive( categoryView.isActive() );
        if ( categoryView.getParentCategory() != null ) {
            category.setParentCategory( categoryViewToCategory( categoryView.getParentCategory() ) );
        }
        List<Category> list = categoryViewListToCategoryList( categoryView.getSubcategories() );
        if ( list != null ) {
            category.setSubcategories( list );
        }

        return category;
    }

    protected Product productViewToProduct(ProductView productView) {
        if ( productView == null ) {
            return null;
        }

        Product product = new Product();

        if ( productView.getId() != null ) {
            product.setId( productView.getId() );
        }
        if ( productView.getName() != null ) {
            product.setName( productView.getName() );
        }
        if ( productView.getDescription() != null ) {
            product.setDescription( productView.getDescription() );
        }
        product.setPrice( productView.getPrice() );
        product.setQuantity( productView.getQuantity() );
        if ( productView.getCategory() != null ) {
            product.setCategory( categoryViewToCategory( productView.getCategory() ) );
        }
        if ( productView.getImageUrl() != null ) {
            product.setImageUrl( productView.getImageUrl() );
        }
        if ( productView.getCreatedAt() != null ) {
            product.setCreatedAt( productView.getCreatedAt() );
        }
        if ( productView.getUpdatedAt() != null ) {
            product.setUpdatedAt( productView.getUpdatedAt() );
        }
        product.setActive( productView.isActive() );

        return product;
    }

    protected OrderLine orderLineViewToOrderLine(OrderLineView orderLineView) {
        if ( orderLineView == null ) {
            return null;
        }

        OrderLine orderLine = new OrderLine();

        if ( orderLineView.getOrderLineId() != null ) {
            orderLine.setOrderLineId( orderLineView.getOrderLineId() );
        }
        orderLine.setQuantity( orderLineView.getQuantity() );
        if ( orderLineView.getUnitPrice() != null ) {
            orderLine.setUnitPrice( orderLineView.getUnitPrice() );
        }
        if ( orderLineView.getSubtotal() != null ) {
            orderLine.setSubtotal( orderLineView.getSubtotal() );
        }
        if ( orderLineView.getProduct() != null ) {
            orderLine.setProduct( productViewToProduct( orderLineView.getProduct() ) );
        }

        return orderLine;
    }

    protected List<OrderLine> orderLineViewListToOrderLineList(List<OrderLineView> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderLine> list1 = new ArrayList<OrderLine>( list.size() );
        for ( OrderLineView orderLineView : list ) {
            list1.add( orderLineViewToOrderLine( orderLineView ) );
        }

        return list1;
    }

    protected Payment paymentViewToPayment(PaymentView paymentView) {
        if ( paymentView == null ) {
            return null;
        }

        Payment payment = new Payment();

        if ( paymentView.getPaymentId() != null ) {
            payment.setPaymentId( paymentView.getPaymentId() );
        }
        if ( paymentView.getAmount() != null ) {
            payment.setAmount( paymentView.getAmount() );
        }
        if ( paymentView.getPaymentDate() != null ) {
            payment.setPaymentDate( paymentView.getPaymentDate() );
        }
        if ( paymentView.getPaymentMethod() != null ) {
            payment.setPaymentMethod( paymentView.getPaymentMethod() );
        }

        return payment;
    }

    protected Customer customerViewToCustomer(CustomerView customerView) {
        if ( customerView == null ) {
            return null;
        }

        Customer customer = new Customer();

        if ( customerView.getId() != null ) {
            customer.setId( customerView.getId() );
        }
        if ( customerView.getEmail() != null ) {
            customer.setEmail( customerView.getEmail() );
        }
        if ( customerView.getUsername() != null ) {
            customer.setUsername( customerView.getUsername() );
        }
        if ( customerView.getPassword() != null ) {
            customer.setPassword( customerView.getPassword() );
        }
        if ( customerView.getIsOnline() != null ) {
            customer.setIsOnline( customerView.getIsOnline() );
        }
        if ( customerView.getPhotoUrl() != null ) {
            customer.setPhotoUrl( customerView.getPhotoUrl() );
        }
        if ( customerView.getFirstName() != null ) {
            customer.setFirstName( customerView.getFirstName() );
        }
        if ( customerView.getLastName() != null ) {
            customer.setLastName( customerView.getLastName() );
        }
        if ( customerView.getSexe() != null ) {
            customer.setSexe( customerView.getSexe() );
        }
        if ( customerView.getPhone() != null ) {
            customer.setPhone( customerView.getPhone() );
        }

        return customer;
    }

    private Long orderCustomerId(Orders orders) {
        if ( orders == null ) {
            return null;
        }
        Customer customer = orders.getCustomer();
        if ( customer == null ) {
            return null;
        }
        Long id = customer.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Customer orderSaveDTOToCustomer(OrderSaveDTO orderSaveDTO) {
        if ( orderSaveDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        if ( orderSaveDTO.getIdCustomer() != null ) {
            customer.setId( orderSaveDTO.getIdCustomer() );
        }

        return customer;
    }

    protected void orderSaveDTOToCustomer1(OrderSaveDTO orderSaveDTO, Customer mappingTarget) {
        if ( orderSaveDTO == null ) {
            return;
        }
    }
}
