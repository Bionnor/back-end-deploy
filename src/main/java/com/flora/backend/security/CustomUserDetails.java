package com.flora.backend.security;

import com.flora.backend.entities.Role;
import com.flora.backend.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class CustomUserDetails implements UserDetails {
    private String email;
    private String password;
    private Set<GrantedAuthority> authorities ;

    public CustomUserDetails(User userCredential) {
        this.email = userCredential.getEmail();
        this.password = userCredential.getPassword();
        this.authorities = new HashSet<>();
        // Populate authorities with roles
        for (Role role : userCredential.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
