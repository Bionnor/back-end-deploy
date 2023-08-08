package com.flora.backend.services;

import com.flora.backend.dtos.Category.CategoryView;
import com.flora.backend.dtos.Product.ProductView;
import com.flora.backend.entities.Category;

import java.util.List;

public interface CategoryService {
    CategoryView findbyCategoryId(Long categoryId);

   CategoryView findCategoryByProductId(Long productId);
    List<CategoryView> ShowCategoriesWithoutPageable();
}
