
package com.flora.backend.repository.properties;

import com.flora.backend.entities.properties.AcidesGras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface AcideGrasRepository extends JpaRepository<AcidesGras,Long> {
}

