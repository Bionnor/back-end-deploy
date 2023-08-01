package com.flora.backend.services;


import com.flora.backend.dtos.JwtResponse;
import com.flora.backend.dtos.RefreshTokenRequest;
import com.flora.backend.dtos.SaveCustomerDto;
import com.flora.backend.entities.Customer;
import com.flora.backend.entities.RefreshToken;
import com.flora.backend.entities.Role;
import com.flora.backend.entities.User;
import com.flora.backend.mappers.UserMapper;
import com.flora.backend.repository.RefreshTokenRepository;
import com.flora.backend.repository.RoleRepository;
import com.flora.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor

@Slf4j


public class AuthServiceImp implements AuthService {
    private UserMapper userMapper;
    private UserRepository userRepository;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;
    private RoleRepository roleRepository;
    PasswordEncoder passwordEncoder;
    private RefreshTokenService refreshTokenService;
    private MailService mailService;
    private RefreshTokenRepository refreshTokenRepository;

    @Override
    public ResponseEntity<Boolean> registerCustomer(SaveCustomerDto saveCustomerDto) {
        try {
            Role roleCustomer = roleRepository.findByRoleName("ROLE_CUSTOMER");
            // Save the admin entity using the userRepository
            Customer customer = userMapper.fromSaveCustomerDtoToCustomer(saveCustomerDto);
            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
            customer.getRoles().add(roleCustomer);
            userRepository.save(customer);
            // Return success (true) indicating successful registration
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public JwtResponse loginAdmin(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        if (authentication.isAuthenticated() && hasAuthority(authorities, "ROLE_ADMIN")) {
            // Check if the user has the required authority (role) for loginCustomer functionality
            RefreshToken refreshToken = refreshTokenService.createRefreshToken(email);
            return JwtResponse.builder()
                    .accessToken(jwtService.generateToken(email))
                    .token(refreshToken.getToken()).build();

        } else throw new RuntimeException("Invalid Access");
    }
    @Override
    public JwtResponse loginCustomer(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        // Get the user's authorities
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        if (authentication.isAuthenticated() && hasAuthority(authorities, "ROLE_CUSTOMER")) {
            // Check if the user has the required authority (role) for loginCustomer functionality
                RefreshToken refreshToken = refreshTokenService.createRefreshToken(email);
                return JwtResponse.builder()
                        .accessToken(jwtService.generateToken(email))
                        .token(refreshToken.getToken()).build();

        } else {
            throw new BadCredentialsException("Invalid credentials. Authentication failed.");
        }
    }

    private boolean hasAuthority(Collection<? extends GrantedAuthority> authorities, String authority) {
        return authorities.stream()
                .anyMatch(auth -> auth.getAuthority().equals(authority));
    }


    @Override
    public JwtResponse loginModerator(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
        if (authentication.isAuthenticated() && authentication.getAuthorities().contains("ROLE_MODERATOR")) {
            RefreshToken refreshToken = refreshTokenService.createRefreshToken(email);
            return JwtResponse.builder()
                    .accessToken(jwtService.generateToken(email))
                    .token(refreshToken.getToken()).build();
        } else throw new RuntimeException("Invalid Access");
    }
    @Override
    public JwtResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {

        return refreshTokenService.findByToken(refreshTokenRequest.getToken())
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(userInfo -> {
                    String accessToken = jwtService.generateToken(userInfo.getUsername());
                    return JwtResponse.builder()
                            .accessToken(accessToken)
                            .token(refreshTokenRequest.getToken())
                            .build();
                }).orElseThrow(() -> new RuntimeException(
                        "Refresh token is not in database!"));
    }

    @Override
    public void requestPasswordReset(String email) {
       // log.info(email);
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            // Generate a password reset token with a 30-min expiration time
            String token = jwtService.generateToken(user.get().getEmail());
            // Send the token via email (you can use email sending libraries or simulate the process here)
            try {
                mailService.sendPasswordResetEmail(user.get().getEmail(), token);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }

        } else throw new RuntimeException("User not Found !");
    }

    @Override
    public Long validateToken(String token) {

        // Check if the token is expired
        if (!jwtService.isTokenExpired(token)) {
            String email=jwtService.extractEmail(token);
            return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException(
                    "User is not in database!")).getId();
        } else throw new RuntimeException("Token expired !");
    }



    @Override
    public Boolean changePassword(String password,Long id) {
        try {
            User user=userRepository.findById(id).orElseThrow(() -> new RuntimeException(
                    "User is not in database!"));
            user.setPassword(passwordEncoder.encode(password));
            userRepository.save(user);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }


}


