package com.flora.backend.entities;

import com.flora.backend.entities.properties.AcidesGras;
import com.flora.backend.entities.properties.Formule;
import com.flora.backend.entities.properties.Organoleptic;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("Cosmetic")
public class CosmeticIngredient extends Product{
    private  String Nombotanique;
    private String Organepresse;
    private String obtention;
    private String payorigine;

    @ManyToOne
    private Organoleptic organoleptic;
    @ManyToOne
    private Formule formule;
    @ManyToOne
    private AcidesGras acidesGras;



}

