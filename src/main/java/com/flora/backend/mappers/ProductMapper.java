package com.flora.backend.mappers;

import com.flora.backend.dtos.Product.ProductSaveDTO;
import com.flora.backend.dtos.Product.ProductView;
import com.flora.backend.entities.FinalProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProductMapper {

    ProductView fromProductToProductView(FinalProduct product);
    FinalProduct fromProductViewToProduct(ProductView productView);
    @Mapping(target="idCategory", source="category.id")
    ProductSaveDTO fromProductToProductSave(FinalProduct product);
    @Mapping(target="category.id", source="idCategory")
    FinalProduct fromProductSaveToProduct(ProductSaveDTO productSaveDTO);


    List<ProductView> fromProductsToProductViews(List<FinalProduct> products);

    List<ProductView> getProductsPage(Page<FinalProduct> pages);

    @Mapping(target = "id", ignore = true) // Ignore updating the ID
    @Mapping(target="category.id", source="idCategory", ignore = true)
    void updateFromProductToProductSaveDTO(ProductSaveDTO productSaveDTO, @MappingTarget FinalProduct product);

}
