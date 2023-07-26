package com.flora.backend.repository;

import com.flora.backend.entities.Customer;
import com.flora.backend.entities.Moderator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeratorRepository  extends JpaRepository<Moderator,Long> {
}
