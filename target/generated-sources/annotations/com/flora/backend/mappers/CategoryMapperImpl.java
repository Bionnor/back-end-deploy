package com.flora.backend.mappers;

import com.flora.backend.dtos.BlogCategoryView;
import com.flora.backend.dtos.Category.CategoryView;
import com.flora.backend.entities.BlogCategory;
import com.flora.backend.entities.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-17T15:20:26+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19 (Eclipse Adoptium)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category fromCategoryViewToCategory(CategoryView categoryView) {
        if ( categoryView == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryView.getId() );
        category.setName( categoryView.getName() );
        category.setDescription( categoryView.getDescription() );
        category.setCreatedAt( categoryView.getCreatedAt() );
        category.setUpdatedAt( categoryView.getUpdatedAt() );
        category.setActive( categoryView.isActive() );
        category.setParentCategory( fromCategoryViewToCategory( categoryView.getParentCategory() ) );
        category.setSubcategories( categoryViewListToCategoryList( categoryView.getSubcategories() ) );

        return category;
    }

    @Override
    public CategoryView fromCategorytoCategoryView(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryView categoryView = new CategoryView();

        categoryView.setId( category.getId() );
        categoryView.setName( category.getName() );
        categoryView.setDescription( category.getDescription() );
        categoryView.setCreatedAt( category.getCreatedAt() );
        categoryView.setUpdatedAt( category.getUpdatedAt() );
        categoryView.setActive( category.isActive() );
        categoryView.setParentCategory( fromCategorytoCategoryView( category.getParentCategory() ) );
        categoryView.setSubcategories( fromListCategoryToListCategoryView( category.getSubcategories() ) );

        return categoryView;
    }

    @Override
    public List<CategoryView> fromListCategoryToListCategoryView(List<Category> categories) {
        if ( categories == null ) {
            return null;
        }

        List<CategoryView> list = new ArrayList<CategoryView>( categories.size() );
        for ( Category category : categories ) {
            list.add( fromCategorytoCategoryView( category ) );
        }

        return list;
    }

    @Override
    public List<BlogCategoryView> fromListBlogCategoryToListBlogCategoryView(List<BlogCategory> categories) {
        if ( categories == null ) {
            return null;
        }

        List<BlogCategoryView> list = new ArrayList<BlogCategoryView>( categories.size() );
        for ( BlogCategory blogCategory : categories ) {
            list.add( blogCategoryToBlogCategoryView( blogCategory ) );
        }

        return list;
    }

    protected List<Category> categoryViewListToCategoryList(List<CategoryView> list) {
        if ( list == null ) {
            return null;
        }

        List<Category> list1 = new ArrayList<Category>( list.size() );
        for ( CategoryView categoryView : list ) {
            list1.add( fromCategoryViewToCategory( categoryView ) );
        }

        return list1;
    }

    protected BlogCategoryView blogCategoryToBlogCategoryView(BlogCategory blogCategory) {
        if ( blogCategory == null ) {
            return null;
        }

        BlogCategoryView blogCategoryView = new BlogCategoryView();

        blogCategoryView.setId( blogCategory.getId() );
        blogCategoryView.setName( blogCategory.getName() );

        return blogCategoryView;
    }
}
