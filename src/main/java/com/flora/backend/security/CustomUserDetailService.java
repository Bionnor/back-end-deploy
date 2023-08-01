package com.flora.backend.security;

import com.flora.backend.entities.User;
import com.flora.backend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Slf4j
@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info(email.toString());
        Optional<User> credential=userRepository.findByEmail(email);

        return credential.map(CustomUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("username not founded"+email));

    }

}
