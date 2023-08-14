
package com.flora.backend.repository;

import com.flora.backend.entities.Category;
import com.flora.backend.entities.FoodIngredient;
import com.flora.backend.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodIngredientRepository extends JpaRepository<FoodIngredient,Long> {

}

