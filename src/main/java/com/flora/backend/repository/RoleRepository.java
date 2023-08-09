package com.flora.backend.repository;

import com.flora.backend.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String role);
}
