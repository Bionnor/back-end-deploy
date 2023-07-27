package com.flora.backend.security;

import com.flora.backend.dtos.UserInput;
import com.flora.backend.entities.User;
import com.flora.backend.mappers.UserMapper;
import com.flora.backend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
@Slf4j
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> credential=userRepository.findByUsername(username);
        UserDetails userDetails=credential.map(CustomUserDetails::new).orElseThrow(()->new UsernameNotFoundException("username not founded"+username));
        return userDetails;
    }

}
