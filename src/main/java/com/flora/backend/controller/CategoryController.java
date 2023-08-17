package com.flora.backend.controller;

import com.flora.backend.dtos.BlogCategoryView;
import com.flora.backend.dtos.Category.CategoryView;
import com.flora.backend.dtos.Product.ProductView;
import com.flora.backend.dtos.ResponsePageDTO;
import com.flora.backend.entities.Product;
import com.flora.backend.services.CategoryService;
import com.flora.backend.services.ProductService;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @GetMapping("/all")
    public List<CategoryView> ShowCategoriesWithoutPageable() {
        return categoryService.ShowCategoriesWithoutPageable();
    }
    @GetMapping("/blog")
    public List<BlogCategoryView> ShowBlogCategoriesWithoutPageable() {
        return categoryService.ShowBlogCategoriesWithoutPageable();
    }
    @GetMapping("/product/{id}")
    public CategoryView getCategoryByProduct(@PathVariable Long id) {
     ;
        return categoryService.findCategoryByProductId(id);
    }
}
