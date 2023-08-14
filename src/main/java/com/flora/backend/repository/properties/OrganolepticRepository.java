
package com.flora.backend.repository.properties;

import com.flora.backend.entities.properties.Organoleptic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OrganolepticRepository extends JpaRepository<Organoleptic,Long> {
}

