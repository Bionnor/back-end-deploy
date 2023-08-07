package com.flora.backend.services;


import com.flora.backend.dtos.Category.CategoryView;
import com.flora.backend.dtos.Product.ProductSaveDTO;
import com.flora.backend.dtos.Product.ProductView;
import com.flora.backend.dtos.ResponsePageDTO;
import com.flora.backend.entities.Category;
import com.flora.backend.entities.Product;
import com.flora.backend.mappers.CategoryMapper;
import com.flora.backend.mappers.ProductMapper;
import com.flora.backend.repository.CategoryRepository;
import com.flora.backend.repository.ProductRepository;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
@NoArgsConstructor
@Slf4j
public class ProductServiceImp implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public ResponsePageDTO<ProductView> showProducts(int page, int size) {
        Page<Product> pages= productRepository.findAll(PageRequest.of(page, size));

        ResponsePageDTO<ProductView> productpageDTO= new ResponsePageDTO<>();
        productpageDTO.setResponseList(productMapper.getProductsPage(pages));
        productpageDTO.setTotalPages(pages.getTotalPages());
        productpageDTO.setCurrentPage(page);
        productpageDTO.setPageSize(size);
        return productpageDTO;
    }


    @Override
    public ResponsePageDTO<ProductView> SearchProducts(String keyword, int page, int size) {

        Page<Product> pages=  productRepository.searchProduct(keyword,keyword,PageRequest.of(page, size));
        ResponsePageDTO<ProductView> productViewResponsePageDTO= new ResponsePageDTO();
        productViewResponsePageDTO.setResponseList(productMapper.getProductsPage(pages));
        productViewResponsePageDTO.setTotalPages(pages.getTotalPages());
        productViewResponsePageDTO.setCurrentPage(page);
        productViewResponsePageDTO.setPageSize(size);
        return productViewResponsePageDTO;
    }


    @Override
    public ResponsePageDTO<ProductView> findByCategory(int page, int size, Long categoryId) {
        CategoryView category = categoryService.findbyCategoryId(categoryId);
        Page<Product> pages=  productRepository.getProductsByCategory(
                categoryMapper.fromCategoryViewToCategory(category),PageRequest.of(page, size));
        ResponsePageDTO<ProductView> productViewResponsePageDTO= new ResponsePageDTO();
        productViewResponsePageDTO.setResponseList(productMapper.getProductsPage(pages));
        productViewResponsePageDTO.setTotalPages(pages.getTotalPages());
        productViewResponsePageDTO.setCurrentPage(page);
        productViewResponsePageDTO.setPageSize(size);
        return productViewResponsePageDTO;
    }

    @Override
    public ProductSaveDTO addProduct(ProductSaveDTO productSaveDTO) {
        Product product=productMapper.fromProductSaveToProduct(productSaveDTO);
        log.info(productSaveDTO.toString());
        product.setCreatedAt(new Date());
        product.setActive(false);
        return productMapper.fromProductToProductSave(productRepository.save(product));

    }
    @Override
    public ProductSaveDTO updateProduct(Long productId, ProductSaveDTO productSaveDTO){
        Product existingProduct = productRepository.findById(productId).orElse(null);
        existingProduct.setUpdatedAt(new Date());
        productMapper.updateFromProductToProductSaveDTO(productSaveDTO,existingProduct);
        // Fetch the Category entity from the database using the idCategory from the DTO
        Category category = categoryRepository.findById(productSaveDTO.getIdCategory()).orElse(null);
   // Set the Category reference to the Product entity
        existingProduct.setCategory(category);

        return productMapper.fromProductToProductSave(productRepository.save(existingProduct));
    }
    @Override
    public boolean deleteProduct(Long productId){
        // Check if the product with the given ID exists
        Product existingProduct = productRepository.findById(productId).orElse(null);
        if (existingProduct != null) {
            productRepository.delete(existingProduct);
            return true;
        }
        return false;
    }
    @Transactional(readOnly = true)
    @Override
    public ResponsePageDTO<ProductView> getFilteredProducts(String searchTerm, Long categoryId, int pageSize, int pageNumber) {

        Specification<Product> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (searchTerm != null && !searchTerm.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + searchTerm.toLowerCase() + "%"));
            }

            if (categoryId != null) {
                Join<Product, Category> categoryJoin = root.join("category");
                predicates.add(criteriaBuilder.equal(categoryJoin.get("id"), categoryId));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        Page<Product> pages=  productRepository.findAll(specification, PageRequest.of(pageNumber, pageSize));
        ResponsePageDTO<ProductView> productViewResponsePageDTO= new ResponsePageDTO();
        productViewResponsePageDTO.setResponseList(productMapper.getProductsPage(pages));
        productViewResponsePageDTO.setTotalPages(pages.getTotalPages());
        productViewResponsePageDTO.setCurrentPage(pageNumber);
        productViewResponsePageDTO.setPageSize(pageSize);
        return productViewResponsePageDTO;
    }

    @Override
    public ProductView getProduct(Long id) {
        return productMapper.fromProductToProductView(productRepository.getProductById( id));
    }


}
