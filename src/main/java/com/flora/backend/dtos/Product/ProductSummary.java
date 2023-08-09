package com.flora.backend.dtos.Product;

import com.flora.backend.dtos.Category.CategoryView;
import lombok.Data;

import java.util.Date;
@Data
public class ProductSummary {
    private Long id;
    private String name;

    private String description;

    private String imageUrl;





}
