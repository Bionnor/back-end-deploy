package com.flora.backend.mappers;

import com.flora.backend.dtos.Customer.CustomerView;
import com.flora.backend.entities.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-17T16:25:39+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19 (Eclipse Adoptium)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerView fromCustomerToCustomerView(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerView customerView = new CustomerView();

        customerView.setId( customer.getId() );
        customerView.setEmail( customer.getEmail() );
        customerView.setUsername( customer.getUsername() );
        customerView.setPassword( customer.getPassword() );
        customerView.setIsOnline( customer.getIsOnline() );
        customerView.setPhotoUrl( customer.getPhotoUrl() );
        customerView.setFirstName( customer.getFirstName() );
        customerView.setLastName( customer.getLastName() );
        customerView.setSexe( customer.getSexe() );
        customerView.setPhone( customer.getPhone() );

        return customerView;
    }

    @Override
    public Customer fromCustomerViewToCustomer(CustomerView customerView) {
        if ( customerView == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerView.getId() );
        customer.setEmail( customerView.getEmail() );
        customer.setUsername( customerView.getUsername() );
        customer.setPassword( customerView.getPassword() );
        customer.setIsOnline( customerView.getIsOnline() );
        customer.setPhotoUrl( customerView.getPhotoUrl() );
        customer.setFirstName( customerView.getFirstName() );
        customer.setLastName( customerView.getLastName() );
        customer.setSexe( customerView.getSexe() );
        customer.setPhone( customerView.getPhone() );

        return customer;
    }
}
