package com.flora.backend;


import com.flora.backend.entities.*;
import com.flora.backend.repository.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.List;


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
							CategoryRepository categoryRepository,
							ReviewRepository reviewRepository
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


			Customer customer1 = new Customer();
			customer1.setUsername("customer1");
			customer1.setPassword(passwordEncoder.encode("customer1"));
			customer1.setEmail("customer1@gmail.com");
			customer1.setPhone("0629174033");
			customer1.setPhotoUrl("photo.jpg");
			customer1.setFirstName("inass");
			customer1.setLastName("zaadane");
			customer1.setSexe(true);
			customer1.getRoles().add(customerRole);
			userRepository.save(customer1);

			Customer customer2 = new Customer();
			customer2.setUsername("customer2");
			customer2.setPassword(passwordEncoder.encode("customer2"));
			customer2.setEmail("customer2@gmail.com");
			customer2.setPhone("0629174033");
			customer2.setPhotoUrl("photo.jpg");
			customer2.setFirstName("rida");
			customer2.setLastName("bahni");
			customer2.setSexe(false);
			customer2.getRoles().add(customerRole);
			userRepository.save(customer2);



			// Create and save categories


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





// Create and save products

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

			//reviews
			Review newReview = new Review();
			newReview.setCustomer(customer1);
			newReview.setProduct(product1);
			newReview.setDateavis(new Date());

			newReview.setNumetoile(Rate.TROIX);

			newReview.setContent("This is a great product. I'm really satisfied!");

			reviewRepository.save(newReview);

			Review newReview1 = new Review();
			newReview1.setCustomer(customer2);
			newReview1.setProduct(product2);
			newReview1.setDateavis(new Date());

			newReview1.setNumetoile(Rate.QUATRE);

			newReview1.setContent("The product exceeded my expectations. Highly recommended!");

			reviewRepository.save(newReview1);


			Review newReview2 = new Review();
			newReview2.setCustomer(customer2);
			newReview2.setProduct(product2);
			newReview2.setDateavis(new Date());
			newReview2.setNumetoile(Rate.CINQ);
			newReview2.setContent("The product exceeded my expectations. Highly recommended!");

			reviewRepository.save(newReview2);
			Review newReview3 = new Review();
			newReview3.setCustomer(customer2);
			newReview3.setProduct(product2);
			newReview3.setDateavis(new Date());
			newReview3.setNumetoile(Rate.CINQ);
			newReview3.setContent("The product exceeded my expectations. Highly recommended!");

			reviewRepository.save(newReview3);

			Review newReview4 = new Review();
			newReview4.setCustomer(customer2);
			newReview4.setProduct(product2);
			newReview4.setDateavis(new Date());
			newReview4.setNumetoile(Rate.CINQ);
			newReview4.setContent("The product exceeded my expectations. Highly recommended!");

			reviewRepository.save(newReview4);
			Review newReview5= new Review();
			newReview5.setCustomer(customer2);
			newReview5.setProduct(product2);
			newReview5.setDateavis(new Date());
			newReview5.setNumetoile(Rate.CINQ);
			newReview5.setContent("The product exceeded my expectations. Highly recommended!");

			reviewRepository.save(newReview5);
		};
	}
}
