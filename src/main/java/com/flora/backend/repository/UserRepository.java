package com.flora.backend.repository;

import com.flora.backend.entities.Customer;
import com.flora.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
