package com.flora.backend.dtos.Property;

import com.flora.backend.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganolepticView{

private Long id;
    private String aspect;
    private String couleur;
    private String odeur;
    private String toucher;
}
