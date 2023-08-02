package com.flora.backend.mappers;

import com.flora.backend.dtos.Product.ProductView;
import com.flora.backend.entities.Product;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductView fromProductToProductView(Product product);
    Product fromProductViewToProduct(ProductView productView);
    List<ProductView> fromProductsToProductViews(List<Product> products);

    List<ProductView> getProductsPage(Page<Product> pages);


}
