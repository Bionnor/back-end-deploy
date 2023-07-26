package com.flora.backend.repository;

import com.flora.backend.entities.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Administrator,Long> {
}
