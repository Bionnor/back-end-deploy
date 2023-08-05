package com.flora.backend.dtos.Category;

import com.flora.backend.entities.Category;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class CategoryView {
    private Long id;
    private String name;
    private String description;
    private Date createdAt;
    private Date updatedAt;
    private boolean isActive;
    private Category parentCategory;
    private List<Category> subcategories;
}
