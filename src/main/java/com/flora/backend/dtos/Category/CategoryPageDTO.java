package com.flora.backend.dtos.Category;

import com.flora.backend.dtos.Product.ProductView;
import lombok.Data;

import java.util.List;
@Data
public class CategoryPageDTO {
    private int currentPage;
    private int totalPages;
    private int pageSize;
    private List<CategoryView> categories;
}
