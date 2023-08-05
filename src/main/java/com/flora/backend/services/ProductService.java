package com.flora.backend.services;


import com.flora.backend.dtos.Product.ProductSaveDTO;
import com.flora.backend.dtos.Product.ProductView;
import com.flora.backend.dtos.ResponsePageDTO;
import com.flora.backend.entities.Product;

public interface ProductService {
    ResponsePageDTO<ProductView> showProducts(int page, int size);

    ResponsePageDTO<ProductView> SearchProducts(String s, int page, int size);

    ResponsePageDTO<ProductView> findByCategory(int page, int size, Long categoryId);

    ProductSaveDTO addProduct(ProductSaveDTO productSaveDTO);

    ProductSaveDTO updateProduct(Long productId, ProductSaveDTO productSaveDTO);

    boolean deleteProduct(Long productId);

    ResponsePageDTO<ProductView> getFilteredProducts(String searchTerm, Long categoryId, int pageSize, int pageNumber);
}
