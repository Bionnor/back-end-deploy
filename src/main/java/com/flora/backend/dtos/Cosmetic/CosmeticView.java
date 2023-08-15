
package com.flora.backend.dtos.Cosmetic;

import com.flora.backend.dtos.Category.CategoryView;
import com.flora.backend.dtos.Property.AcideGrasView;
import com.flora.backend.dtos.Property.FormuleView;
import com.flora.backend.dtos.Property.OrganolepticView;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CosmeticView {
    private Long id;
    private String name;

    private String description;

    private double price;

    private int quantity;

    private CategoryView category;

    private String imageUrl;

    private Date createdAt;
    private Date updatedAt;
    private boolean isActive;
    private  String Nombotanique;
    private String Organepresse;
    private String obtention;
    private String payorigine;
    private int litrage[];

     private OrganolepticView organoleptic;
     private FormuleView formule;
     private AcideGrasView acideGras;
}

