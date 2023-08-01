package com.flora.backend.dtos.Product;

import lombok.Data;

import java.util.List;
@Data
public class ProductPageDTO {
    private int currentPage;
    private int totalPages;
    private int pageSize;
    private List<ProductView> products;
}
