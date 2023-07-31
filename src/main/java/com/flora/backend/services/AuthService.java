package com.flora.backend.services;

import com.flora.backend.dtos.JwtResponse;
import com.flora.backend.dtos.RefreshTokenRequest;
import com.flora.backend.dtos.SaveCustomerDto;
import com.flora.backend.dtos.UserInput;
import com.flora.backend.entities.Customer;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface AuthService {
    ResponseEntity<Boolean> registerCustomer(SaveCustomerDto saveCustomerDto);
    JwtResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
     void requestPasswordReset(String email);

    Long validateToken(String token);

    Boolean changePassword(String password,Long id);


    JwtResponse loginCustomer(String username, String password);

    JwtResponse loginAdmin(String username, String password);

    JwtResponse loginModerator(String username, String password);
}
