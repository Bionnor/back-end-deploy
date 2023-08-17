package com.flora.backend.mappers;

import com.flora.backend.dtos.SaveCustomerDto;
import com.flora.backend.dtos.UserInput;
import com.flora.backend.entities.Customer;
import com.flora.backend.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-17T15:20:26+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserInput fromUser(User user) {
        if ( user == null ) {
            return null;
        }

        UserInput userInput = new UserInput();

        userInput.setEmail( user.getEmail() );
        userInput.setPassword( user.getPassword() );

        return userInput;
    }

    @Override
    public Customer fromSaveCustomerDtoToCustomer(SaveCustomerDto saveCustomerDto) {
        if ( saveCustomerDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setEmail( saveCustomerDto.getEmail() );
        customer.setUsername( saveCustomerDto.getUsername() );
        customer.setPassword( saveCustomerDto.getPassword() );
        customer.setPhotoUrl( saveCustomerDto.getPhotoUrl() );
        customer.setFirstName( saveCustomerDto.getFirstName() );
        customer.setLastName( saveCustomerDto.getLastName() );
        customer.setSexe( saveCustomerDto.getSexe() );
        customer.setPhone( saveCustomerDto.getPhone() );

        return customer;
    }

    @Override
    public List<UserInput> fromUserstoUserInput(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserInput> list = new ArrayList<UserInput>( users.size() );
        for ( User user : users ) {
            list.add( fromUser( user ) );
        }

        return list;
    }
}
