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
public class AcidesGras
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String acidepunicique;
    private String acideoleique ;
    private String acidepalmitique ;
    private String acidestearique  ;
    private String acidearachidique  ;
    private String acidebehenique  ;
    private String acidealphalinolenique  ;
    private String acideeicosenoique  ;
    private String acidelinoleique  ;
    private String ags  ;
    private String agmi;
    private String agpi;


}
