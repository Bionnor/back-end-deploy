package com.flora.backend.mappers;

import com.flora.backend.dtos.UserInput;
import com.flora.backend.entities.User;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserMapper {
     UserInput fromUser(User user);
     List<UserInput> fromUserstoUserInput(List<User> users);

    // Optional<UserInput> fromOUserToOUserInput(Optional<User> optionalUserInputs);
}
