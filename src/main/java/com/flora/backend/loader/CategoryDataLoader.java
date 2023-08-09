package com.flora.backend.loader;

import com.flora.backend.entities.Category;
import com.flora.backend.entities.Product;
import com.flora.backend.repository.CategoryRepository;
import com.flora.backend.repository.ProductRepository;
import com.flora.backend.repository.RoleRepository;
import com.flora.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Order(1)
public class CategoryDataLoader implements CommandLineRunner {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public void run(String... args) throws Exception {
        Category category = new Category();
        category.setName("Electronics");
        categoryRepository.save(category);
        Category categoryPhone = new Category();
        categoryPhone.setName("Phone");
        categoryRepository.save(categoryPhone);
        Category categoryTablet = new Category(); // Corrected the variable name
        categoryTablet.setName("Tablets");
        categoryRepository.save(categoryTablet);
        Category categoryTv = new Category(); // Corrected the variable name
        categoryTv.setName("Television");
        categoryRepository.save(categoryTv);
        Category categoryComputer = new Category(); // Corrected the variable name
        categoryComputer.setName("Computer"); // Corrected the category name
        categoryRepository.save(categoryComputer);
        Category categoryCamera = new Category(); // Corrected the variable name
        categoryCamera.setName("Cameras");
        categoryRepository.save(categoryCamera);
    }
}
