package com.flora.backend;


import com.flora.backend.entities.Administrator;
import com.flora.backend.entities.Customer;
import com.flora.backend.entities.Moderator;
import com.flora.backend.entities.Role;
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
							PasswordEncoder passwordEncoder){

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

		};
	}
}
