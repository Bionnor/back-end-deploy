package com.flora.backend.dtos.Cosmetic;

import com.flora.backend.dtos.Property.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CosmeticSaveDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private Long idCategory;
    private String imageUrl;
    private boolean isActive;

    private  String Nombotanique;
    private String Organepresse;
    private String obtention;
    private String payorigine;

    private OrganlopticSave organoleptic;
    private FormuleSave formule;
    private AcideGrasSave acideGras;
}
