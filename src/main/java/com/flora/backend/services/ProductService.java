package com.flora.backend.services;


import com.flora.backend.dtos.Product.ProductView;
import com.flora.backend.dtos.ResponsePageDTO;

public interface ProductService {
    ResponsePageDTO<ProductView> showProducts(int page, int size);

    ResponsePageDTO<ProductView> SearchProducts(String s, int page, int size);

    ResponsePageDTO<ProductView> findByCategory(int page, int size, Long categoryId);
}
