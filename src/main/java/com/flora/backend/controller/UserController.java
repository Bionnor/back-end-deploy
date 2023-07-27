package com.flora.backend.controller;

import com.flora.backend.dtos.UserInput;
import com.flora.backend.mappers.UserMapper;
import com.flora.backend.repository.UserRepository;
import com.flora.backend.security.CustomUserDetailService;
import com.flora.backend.security.CustomUserDetails;
import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@Slf4j
public class UserController {
    //@PreAuthorize("hasAuthority('ROLE_ADMIN') OR hasAuthority('ROLE_MODERATOR')")
    private UserMapper userMapper;
    private UserRepository userRepository;
    private CustomUserDetailService customUserDetailService;
    @GetMapping("/users")
    public List<UserInput> getUsers()
    {
        return userMapper.fromUserstoUserInput(userRepository.findAll());
    }
    @GetMapping("/customer")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String HelloCustomer() {
        return "helloCustomer";
    }
    @GetMapping("/moderator/product")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String HelloModeratorProduct() {
        return "helloModeratorProduct";
    }
    @GetMapping("/moderator/blog")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String HelloModeratorBlog() {
        return "helloModeratorBlog";
    }
    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String HelloAdmin() {
        return "helloAdmin";
    }
}
