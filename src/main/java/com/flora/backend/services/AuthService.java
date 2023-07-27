package com.flora.backend.services;

import com.flora.backend.dtos.UserInput;

import java.util.Map;

public interface AuthService {
    String SaveUser(UserInput userInput);
    String generateToken(String username, String scope);
}
