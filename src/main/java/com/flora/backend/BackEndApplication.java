package com.flora.backend;


import com.flora.backend.entities.*;
import com.flora.backend.repository.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class BackEndApplication {
	@Value("${role.customer}")
	private String customer;
	@Value("${role.moderator}")
	private String moderator;
	@Value("${role.admin}")
	private String admin;
	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);
	}
	@Bean
	CommandLineRunner Start(RoleRepository roleRepository,
							UserRepository userRepository,
							ProductRepository productRepository,
							PasswordEncoder passwordEncoder,
							CategoryRepository categoryRepository
							){

		return args -> {

			Role adminRole = new Role();
			adminRole.setRoleName(admin);
			roleRepository.save(adminRole);

			Role moderatorProductRole = new Role();
			moderatorProductRole.setRoleName(moderator);
			roleRepository.save(moderatorProductRole);


			Role customerRole = new Role();
			customerRole.setRoleName(customer);
			roleRepository.save(customerRole);

			// Create and save users of different types
			Administrator admin = new Administrator();
			admin.setUsername("admin");
			admin.setPassword(passwordEncoder.encode("admin"));
			admin.setEmail("admin@admin.com");

			admin.setPhotoUrl("photo.jpg");
			admin.getRoles().add(adminRole);
			userRepository.save(admin);

			Moderator moderator = new Moderator();
			moderator.setUsername("moderator");
			moderator.setPassword(passwordEncoder.encode("moderator"));
			moderator.setEmail("moderator@moderator.com");
			moderator.setPhotoUrl("photo.jpg");
			moderator.setIsEnabled(true);
			moderator.getRoles().add(moderatorProductRole);
			userRepository.save(moderator);

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


			Category category = new Category();
			category.setName("Electronics");
			categoryRepository.save(category);

			// Create two sample products and associate them with the category
			Product product1 = new Product();
			product1.setName("Laptop");
			product1.setDescription("High-performance laptop");
			product1.setPrice(1000.0);
			product1.setQuantity(10);
			product1.setCategory(category);
			product1.setBrand("HP");
			product1.setRating(4.5);
			product1.setActive(true);

			Product product2 = new Product();
			product2.setName("Smartphone");
			product2.setDescription("Flagship smartphone");
			product2.setPrice(800.0);
			product2.setQuantity(20);
			product2.setCategory(category);
			product2.setBrand("Samsung");
			product2.setRating(4.8);
			product2.setActive(true);

			productRepository.save(product1);
			productRepository.save(product2);


		};
	}
}
