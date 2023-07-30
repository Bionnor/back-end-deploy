package com.flora.backend.mappers;

import com.flora.backend.dtos.SaveAdminDto;
import com.flora.backend.dtos.SaveCustomerDto;
import com.flora.backend.dtos.UserInput;
import com.flora.backend.entities.Administrator;
import com.flora.backend.entities.Customer;
import com.flora.backend.entities.User;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserMapper {
     UserInput fromUser(User user);
     Customer fromSaveCustomerDtoToCustomer(SaveCustomerDto saveCustomerDto);
     List<UserInput> fromUserstoUserInput(List<User> users);

}
