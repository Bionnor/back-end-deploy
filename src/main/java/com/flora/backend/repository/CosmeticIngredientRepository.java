
package com.flora.backend.repository;

import com.flora.backend.entities.CosmeticIngredient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CosmeticIngredientRepository  extends JpaRepository<CosmeticIngredient,Long> {
    Page<CosmeticIngredient> findAll(Specification<CosmeticIngredient> specification, Pageable pageable);

}

