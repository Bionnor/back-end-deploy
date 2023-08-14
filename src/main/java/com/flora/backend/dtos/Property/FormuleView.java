package com.flora.backend.dtos.Property;

import com.flora.backend.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormuleView {
    private Long id;

    private String Insaponifiable ;
    private String comedogenicite ;
    private String saponificationMoyenne;
    private String oxydation;
    private String stabiliteTemp;
    private String INCI;
}
