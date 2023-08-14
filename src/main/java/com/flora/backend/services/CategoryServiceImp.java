package com.flora.backend.services;

import com.flora.backend.dtos.Category.CategoryView;
import com.flora.backend.entities.FinalProduct;
import com.flora.backend.entities.Product;
import com.flora.backend.mappers.CategoryMapper;
import com.flora.backend.repository.CategoryRepository;
import com.flora.backend.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
@NoArgsConstructor
@Slf4j
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public CategoryView findbyCategoryId(Long categoryId) {
        return categoryMapper.fromCategorytoCategoryView(categoryRepository.findById(categoryId).get());
    }

    @Override
    public CategoryView findCategoryByProductId(Long productId) {
        Optional<FinalProduct> product=productRepository.findById(productId);

        return categoryMapper.fromCategorytoCategoryView(product.get().getCategory());
    }

    @Override
    public List<CategoryView> ShowCategoriesWithoutPageable() {
        return categoryMapper.fromListCategoryToListCategoryView(categoryRepository.findAll());
    }

}
