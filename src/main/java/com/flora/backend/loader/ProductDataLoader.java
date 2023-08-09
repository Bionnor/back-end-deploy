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
@Order(4)
public class ProductDataLoader implements CommandLineRunner {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public void run(String... args) throws Exception {
        Category category = categoryRepository.findByName("Electronics").orElseThrow();
        Category categoryPhone = categoryRepository.findByName("Phone").orElseThrow();
        Category categoryTablet = categoryRepository.findByName("Tablets").orElseThrow();
        Category categoryTv = categoryRepository.findByName("Television").orElseThrow();
        Category categoryComputer = categoryRepository.findByName("Computer").orElseThrow();
        Category categoryCamera = categoryRepository.findByName("Cameras").orElseThrow();

        Product product1 = new Product();
        product1.setName("Laptop");
        product1.setDescription("High-performance laptop");
        product1.setPrice(1000.0);
        product1.setQuantity(10);
        product1.setCategory(category);
        product1.setBrand("HP");
        product1.setRating(4.5);
        product1.setCreatedAt(new Date());
        product1.setActive(true);

        Product product2 = new Product();
        product2.setName("Smartphone");
        product2.setDescription("Flagship smartphone");
        product2.setPrice(800.0);
        product2.setQuantity(20);
        product2.setCategory(categoryPhone); // Corrected the category association
        product2.setBrand("Samsung");
        product2.setRating(4.8);
        product2.setCreatedAt(new Date());
        product2.setActive(true);

        Product productTV = new Product();
        productTV.setName("Smart TV");
        productTV.setDescription("55-inch 4K Smart TV");
        productTV.setPrice(800.0);
        productTV.setQuantity(5);
        productTV.setCategory(categoryTv); // Corrected the category association
        productTV.setBrand("Samsung");
        productTV.setRating(4.8);
        productTV.setCreatedAt(new Date());
        productTV.setActive(true);

        Product productMonitor = new Product();
        productMonitor.setName("Computer Monitor");
        productMonitor.setDescription("27-inch Full HD Monitor");
        productMonitor.setPrice(250.0);
        productMonitor.setQuantity(8);
        productMonitor.setCategory(categoryComputer); // Corrected the category association
        productMonitor.setBrand("Dell");
        productMonitor.setRating(4.3);
        productMonitor.setCreatedAt(new Date());
        productMonitor.setActive(true);
        // Create and save more products

        Product product3 = new Product();
        product3.setName("Digital Camera");
        product3.setDescription("High-quality digital camera");
        product3.setPrice(500.0);
        product3.setQuantity(15);
        product3.setCategory(categoryCamera); // Associating with the "Cameras" category
        product3.setBrand("Sony");
        product3.setRating(4.2);
        product3.setCreatedAt(new Date());
        product3.setActive(true);

        Product product4 = new Product();
        product4.setName("Tablet");
        product4.setDescription("10-inch Android tablet");
        product4.setPrice(300.0);
        product4.setQuantity(12);
        product4.setCategory(categoryTablet); // Associating with the "Tablets" category
        product4.setBrand("Lenovo");
        product4.setRating(4.0);
        product4.setCreatedAt(new Date());
        product4.setActive(true);

        Product product5 = new Product();
        product5.setName("UHD Monitor");
        product5.setDescription("32-inch UHD monitor");
        product5.setPrice(400.0);
        product5.setQuantity(6);
        product5.setCategory(categoryComputer); // Associating with the "Computer" category
        product5.setBrand("LG");
        product5.setRating(4.5);
        product5.setCreatedAt(new Date());
        product5.setActive(true);

        productRepository.saveAll(List.of(product1,product2,productTV,productMonitor,product3, product4, product5));
    }
}
