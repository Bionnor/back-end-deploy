package com.flora.backend.services;

import com.flora.backend.dtos.UserInput;
import com.flora.backend.mappers.UserMapper;
import com.flora.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class AuthServiceImp implements AuthService{

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;


    @Override
    public String SaveUser(UserInput userInput) {
        return null;
    }

    public String generateToken(String username, String scope) {
        return jwtService.generateToken(username,scope);
    }




}


