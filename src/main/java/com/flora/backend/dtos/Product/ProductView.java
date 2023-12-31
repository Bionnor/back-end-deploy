package com.flora.backend.dtos.Product;

import com.flora.backend.dtos.Category.CategoryView;
import com.flora.backend.dtos.Review.ReviewShow;
import com.flora.backend.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

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
    private Date updatedAt;

    private boolean isActive;
    private List<ReviewShow> reviewShowList;

}
