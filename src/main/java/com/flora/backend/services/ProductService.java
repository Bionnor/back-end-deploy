package com.flora.backend.services;

import com.flora.backend.dtos.Product.ProductPageDTO;
import com.flora.backend.dtos.Product.ProductView;

public interface ProductService {
    ProductPageDTO listProducts( int page, int size);
}
