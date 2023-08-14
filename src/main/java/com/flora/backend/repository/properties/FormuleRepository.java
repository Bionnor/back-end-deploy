
package com.flora.backend.repository.properties;

import com.flora.backend.entities.properties.Formule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FormuleRepository extends JpaRepository<Formule,Long> {
}