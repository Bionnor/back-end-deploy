package com.flora.backend.dtos.Property;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AcideGrasSave {
    private  Long id;
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
