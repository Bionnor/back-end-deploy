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
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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

}
