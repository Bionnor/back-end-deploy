package com.flora.backend.services;


import com.flora.backend.dtos.Product.ProductView;
import com.flora.backend.dtos.ResponsePageDTO;

public interface ProductService {
    ResponsePageDTO<ProductView> listProducts(int page, int size);
}
