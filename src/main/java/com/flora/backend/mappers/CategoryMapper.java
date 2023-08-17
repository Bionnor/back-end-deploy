package com.flora.backend.mappers;

import com.flora.backend.dtos.BlogCategoryView;
import com.flora.backend.dtos.Category.CategoryView;
import com.flora.backend.entities.BlogCategory;
import com.flora.backend.entities.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category fromCategoryViewToCategory(CategoryView categoryView);
    CategoryView fromCategorytoCategoryView(Category category);


    List<CategoryView> fromListCategoryToListCategoryView(List<Category> categories);

    List<BlogCategoryView> fromListBlogCategoryToListBlogCategoryView(List<BlogCategory> categories);
}
