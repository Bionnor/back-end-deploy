package com.flora.backend.controller;

import com.flora.backend.dtos.UserInput;
import com.flora.backend.services.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/auth")
public class SecurityController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthService authService;
    @GetMapping("/profile")
    public Authentication Profile(Authentication authentication) {
        return authentication;
    }

    @PostMapping("/login")
    public Map<String,String> login(String username,String password)
    {

        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username,password)
        );

        if(authentication.isAuthenticated()){
            log.info("autheticated");
            String scope =authentication.getAuthorities().stream().map(a->a.getAuthority()).collect(Collectors.joining(" "));
            return Map.of("access-token",authService.generateToken(username,scope));
        }
        else throw new RuntimeException("Invalid Access");

    }
}
