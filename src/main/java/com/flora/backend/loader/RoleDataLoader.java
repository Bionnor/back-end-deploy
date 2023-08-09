package com.flora.backend.loader;

import com.flora.backend.entities.Product;
import com.flora.backend.entities.Role;
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
@Order(2)
public class RoleDataLoader implements CommandLineRunner {
    @Value("${role.customer}")
    private String customer;
    @Value("${role.moderator}")
    private String moderator;
    @Value("${role.admin}")
    private String admin;
    @Autowired
    RoleRepository roleRepository;
    @Override
    public void run(String... args) throws Exception {
        Role adminRole = new Role();
        adminRole.setRoleName(admin);
        roleRepository.save(adminRole);

        Role moderatorProductRole = new Role();
        moderatorProductRole.setRoleName(moderator);
        roleRepository.save(moderatorProductRole);


        Role customerRole = new Role();
        customerRole.setRoleName(customer);
        roleRepository.save(customerRole);
    }
}
