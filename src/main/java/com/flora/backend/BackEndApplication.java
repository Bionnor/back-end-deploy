package com.flora.backend;

import com.flora.backend.entities.Administrator;
import com.flora.backend.entities.Customer;
import com.flora.backend.entities.Moderator;
import com.flora.backend.entities.Role;
import com.flora.backend.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);
	}
	@Bean
	CommandLineRunner Start(RoleRepository roleRepository,
							CustomerRepository customerRepository,
							AdminRepository adminRepository,
							ModeratorRepository moderatorRepository,
							UserRepository userRepository
							){

		return args -> {
			Role adminRole = new Role();
			adminRole.setRoleName("ROLE_ADMIN");
			roleRepository.save(adminRole);

			Role moderatorRole = new Role();
			moderatorRole.setRoleName("ROLE_MODERATOR");
			roleRepository.save(moderatorRole);

			Role customerRole = new Role();
			customerRole.setRoleName("ROLE_CUSTOMER");
			roleRepository.save(customerRole);

			// Create and save users of different types
			Administrator admin = new Administrator();
			admin.setUsername("admin");
			admin.setPassword("admin");
			admin.setEmail("admin@admin.com");
			admin.setIsOnline(true);
			admin.setPhotoUrl("photo.jpg");
			admin.getRoles().add(adminRole);
			userRepository.save(admin);

			Moderator moderator = new Moderator();
			moderator.setUsername("moderator");
			moderator.setPassword("moderator");
			moderator.setEmail("moderator@moderator.com");
			moderator.setIsOnline(true);
			moderator.setPhotoUrl("photo.jpg");
			moderator.setIsEnabled(true);
			moderator.getRoles().add(moderatorRole);
			userRepository.save(moderator);

			Customer customer = new Customer();
			customer.setUsername("customer");
			customer.setPassword("customer");
			customer.setEmail("customer@customer.com");
			customer.setIsOnline(true);
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
