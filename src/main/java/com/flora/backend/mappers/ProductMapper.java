package com.flora.backend.mappers;

import com.flora.backend.dtos.Product.ProductSaveDTO;
import com.flora.backend.dtos.Product.ProductView;
import com.flora.backend.entities.Product;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProductMapper {
    ProductView fromProductToProductView(Product product);
    Product fromProductViewToProduct(ProductView productView);
    @Mapping(target="idCategory", source="category.id")
    ProductSaveDTO fromProductToProductSave(Product product);
    @Mapping(target="category.id", source="idCategory")
    Product fromProductSaveToProduct(ProductSaveDTO productSaveDTO);
    List<ProductView> fromProductsToProductViews(List<Product> products);

    List<ProductView> getProductsPage(Page<Product> pages);

    @Mapping(target = "id", ignore = true) // Ignore updating the ID
    @Mapping(target="category.id", source="idCategory", ignore = true)
    void updateFromProductToProductSaveDTO(ProductSaveDTO productSaveDTO, @MappingTarget Product product);

}
