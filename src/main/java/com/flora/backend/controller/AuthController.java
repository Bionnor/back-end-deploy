package com.flora.backend.controller;

import com.flora.backend.dtos.*;
import com.flora.backend.entities.Administrator;
import com.flora.backend.mappers.UserMapper;
import com.flora.backend.repository.UserRepository;
import com.flora.backend.services.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;


    @GetMapping("/profile")
    public Authentication Profile(Authentication authentication) {
        return authentication;
    }

    @PostMapping("/customer/register")
    public ResponseEntity<Boolean> registerCustomer(@RequestBody SaveCustomerDto saveCustomerDto) {
        return authService.registerCustomer(saveCustomerDto);
    }

    @PostMapping("/customer/login")
    public JwtResponse loginCustomer(@RequestBody UserInput userInput) {
        return authService.loginCustomer(userInput.getEmail(), userInput.getPassword());
    }
    @PostMapping("/admin/login")
    public JwtResponse loginAdmin(@RequestBody UserInput userInput) {
        return authService.loginAdmin(userInput.getEmail(), userInput.getPassword());
    }
    @PostMapping("/moderator/login")
    public JwtResponse loginModerator(@RequestBody UserInput userInput) {
        return authService.loginModerator(userInput.getEmail(), userInput.getPassword());
    }

    @PostMapping("/refreshToken")
    public JwtResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }
    @PostMapping("/reset-password")
    public void requestPasswordReset(String email) {
         authService.requestPasswordReset(email);
    }
    @GetMapping ("/validate-token")
    public Long validateToken(@RequestParam String token) {
       return authService.validateToken(token);
    }
    @PostMapping("/change-password")
    public Boolean ChangePassword(String password,Long id) {
       return authService.changePassword(password,id);
    }
}
