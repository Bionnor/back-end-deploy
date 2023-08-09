package com.flora.backend.loader;

import com.flora.backend.entities.*;
import com.flora.backend.repository.CategoryRepository;
import com.flora.backend.repository.ProductRepository;
import com.flora.backend.repository.RoleRepository;
import com.flora.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Order(3)
public class UserDataLoader implements CommandLineRunner {
    @Value("${role.customer}")
    private String customer;
    @Value("${role.admin}")
    private String admin;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Role adminRole = roleRepository.findByRoleName(admin);
        Role customerRole = roleRepository.findByRoleName(customer);
        // Create and save users of different types
        Administrator admin = new Administrator();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setEmail("admin@admin.com");

        admin.setPhotoUrl("photo.jpg");
        admin.getRoles().add(adminRole);
        userRepository.save(admin);

        Customer customer = new Customer();
        customer.setUsername("customer");
        customer.setPassword(passwordEncoder.encode("customer"));
        customer.setEmail("petiho6010@inkiny.com");
        customer.setPhone("0629174033");
        customer.setPhotoUrl("photo.jpg");
        customer.setFirstName("inass");
        customer.setLastName("rida");
        customer.setSexe(true);
        customer.getRoles().add(customerRole);
        userRepository.save(customer);
    }
}
