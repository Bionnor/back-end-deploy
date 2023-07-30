package com.flora.backend.controller;

import com.flora.backend.dtos.UserInput;
import com.flora.backend.mappers.UserMapper;
import com.flora.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@Slf4j
public class UserController {
    private UserMapper userMapper;
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<UserInput> getUsers()
    {
        return userMapper.fromUserstoUserInput(userRepository.findAll());
    }

    @GetMapping("/customer/hello")
    public String HelloCustomer() {
        return "helloCustomer";
    }
    @GetMapping("/moderator/product")
    public String HelloModeratorProduct() {
        return "helloModeratorProduct";
    }
    @GetMapping("/moderator/blog")

    public String HelloModeratorBlog() {
        return "helloModeratorBlog";
    }

    @GetMapping("/admin/hello")
    public String HelloAdmin() {
        return "helloAdmin";
    }
}
