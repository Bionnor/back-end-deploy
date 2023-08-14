package com.flora.backend.dtos.Property;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FormuleSave {
    private Long id;
    private String Insaponifiable ;
    private String comedogenicite ;
    private String saponificationMoyenne;
    private String oxydation;
    private String stabiliteTemp;
    private String INCI;
}

