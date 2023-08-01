package com.flora.backend.services;

import com.flora.backend.dtos.Product.ProductPageDTO;
import com.flora.backend.dtos.Product.ProductView;
import com.flora.backend.entities.Product;
import com.flora.backend.mappers.ProductMapper;
import com.flora.backend.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
@NoArgsConstructor
@Slf4j
public class ProductServiceImp implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    @Override
    public ProductPageDTO listProducts( int page, int size) {
        Page<Product> pages= productRepository.findAll(PageRequest.of(page, size));

        ProductPageDTO productpageDTO= new ProductPageDTO();
        productpageDTO.setProducts(productMapper.getProductsPage(pages));
        productpageDTO.setTotalPages(pages.getTotalPages());
        productpageDTO.setCurrentPage(page);
        productpageDTO.setPageSize(size);
        return productpageDTO;
    }



}
