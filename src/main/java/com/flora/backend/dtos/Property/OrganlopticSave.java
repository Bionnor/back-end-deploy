package com.flora.backend.dtos.Property;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganlopticSave {
    private Long id;
    private String aspect;
    private String couleur;
    private String odeur;
    private String toucher;
}
