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
    private  String nombotanique;
    private String organepresse;
    private String obtention;
    private String payorigine;


    @OneToOne(cascade = CascadeType.PERSIST)

    private Organoleptic organoleptic;
    @OneToOne(cascade = CascadeType.PERSIST)

    private Formule formule;
    @OneToOne(cascade = CascadeType.PERSIST)

    private AcidesGras acidesGras;



}

