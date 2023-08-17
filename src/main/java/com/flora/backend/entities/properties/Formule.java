
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

public class Formule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Insaponifiable ;
    private String comedogenicite ;
    private String saponificationMoyenne;
    private String oxydation;
    private String stabiliteTemp;
    private String INCI;


}

