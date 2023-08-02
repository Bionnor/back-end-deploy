package com.flora.backend.dtos.Product;

import com.flora.backend.dtos.Category.CategoryView;
import com.flora.backend.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductView {
    private Long id;
    private String name;

    private String description;

    private double price;

    private int quantity;

    private CategoryView category;


    private String imageUrl;

    private Date createdAt;

    private boolean isActive;

}
