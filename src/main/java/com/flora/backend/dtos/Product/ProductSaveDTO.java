package com.flora.backend.dtos.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSaveDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private Long idCategory;
    private String imageUrl;
    private boolean isActive;
}
