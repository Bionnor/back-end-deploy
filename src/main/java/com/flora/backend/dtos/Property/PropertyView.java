package com.flora.backend.dtos.Property;

import com.flora.backend.dtos.Cosmetic.CosmeticView;
import com.flora.backend.entities.CosmeticIngredient;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyView {
    private Long idProperty;

    private String autres;

    private CosmeticView cosmeticView;
}
