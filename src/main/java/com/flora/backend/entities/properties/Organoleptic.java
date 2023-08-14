
package com.flora.backend.entities.properties;

import com.flora.backend.entities.CosmeticIngredient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Organoleptic  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String aspect;
    private String couleur;
    private String odeur;
    private String toucher;
    private String autres;
    @OneToMany(mappedBy = "organoleptic")
    List<CosmeticIngredient> cosmeticIngredients;



}

