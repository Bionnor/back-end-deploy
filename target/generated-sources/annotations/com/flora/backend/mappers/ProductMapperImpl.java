package com.flora.backend.mappers;

import com.flora.backend.dtos.Category.CategoryView;
import com.flora.backend.dtos.Product.ProductSaveDTO;
import com.flora.backend.dtos.Product.ProductView;
import com.flora.backend.entities.Category;
import com.flora.backend.entities.FinalProduct;
import com.flora.backend.entities.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-17T16:25:39+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductView fromProductToProductView(FinalProduct product) {
        if ( product == null ) {
            return null;
        }

        ProductView productView = new ProductView();

        if ( product.getId() != null ) {
            productView.setId( product.getId() );
        }
        if ( product.getName() != null ) {
            productView.setName( product.getName() );
        }
        if ( product.getDescription() != null ) {
            productView.setDescription( product.getDescription() );
        }
        productView.setPrice( product.getPrice() );
        productView.setQuantity( product.getQuantity() );
        if ( product.getCategory() != null ) {
            productView.setCategory( categoryToCategoryView( product.getCategory() ) );
        }
        if ( product.getImageUrl() != null ) {
            productView.setImageUrl( product.getImageUrl() );
        }
        if ( product.getCreatedAt() != null ) {
            productView.setCreatedAt( product.getCreatedAt() );
        }
        if ( product.getUpdatedAt() != null ) {
            productView.setUpdatedAt( product.getUpdatedAt() );
        }
        productView.setActive( product.isActive() );

        return productView;
    }

    @Override
    public FinalProduct fromProductViewToProduct(ProductView productView) {
        if ( productView == null ) {
            return null;
        }

        FinalProduct finalProduct = new FinalProduct();

        if ( productView.getId() != null ) {
            finalProduct.setId( productView.getId() );
        }
        if ( productView.getName() != null ) {
            finalProduct.setName( productView.getName() );
        }
        if ( productView.getDescription() != null ) {
            finalProduct.setDescription( productView.getDescription() );
        }
        finalProduct.setPrice( productView.getPrice() );
        finalProduct.setQuantity( productView.getQuantity() );
        if ( productView.getCategory() != null ) {
            finalProduct.setCategory( categoryViewToCategory( productView.getCategory() ) );
        }
        if ( productView.getImageUrl() != null ) {
            finalProduct.setImageUrl( productView.getImageUrl() );
        }
        if ( productView.getCreatedAt() != null ) {
            finalProduct.setCreatedAt( productView.getCreatedAt() );
        }
        if ( productView.getUpdatedAt() != null ) {
            finalProduct.setUpdatedAt( productView.getUpdatedAt() );
        }
        finalProduct.setActive( productView.isActive() );

        return finalProduct;
    }

    @Override
    public ProductSaveDTO fromProductToProductSave(FinalProduct product) {
        if ( product == null ) {
            return null;
        }

        ProductSaveDTO productSaveDTO = new ProductSaveDTO();

        Long id = productCategoryId( product );
        if ( id != null ) {
            productSaveDTO.setIdCategory( id );
        }
        if ( product.getId() != null ) {
            productSaveDTO.setId( product.getId() );
        }
        if ( product.getName() != null ) {
            productSaveDTO.setName( product.getName() );
        }
        if ( product.getDescription() != null ) {
            productSaveDTO.setDescription( product.getDescription() );
        }
        productSaveDTO.setPrice( product.getPrice() );
        productSaveDTO.setQuantity( product.getQuantity() );
        if ( product.getImageUrl() != null ) {
            productSaveDTO.setImageUrl( product.getImageUrl() );
        }
        productSaveDTO.setActive( product.isActive() );

        return productSaveDTO;
    }

    @Override
    public FinalProduct fromProductSaveToProduct(ProductSaveDTO productSaveDTO) {
        if ( productSaveDTO == null ) {
            return null;
        }

        FinalProduct finalProduct = new FinalProduct();

        if ( productSaveDTO != null ) {
            finalProduct.setCategory( productSaveDTOToCategory( productSaveDTO ) );
        }
        if ( productSaveDTO.getId() != null ) {
            finalProduct.setId( productSaveDTO.getId() );
        }
        if ( productSaveDTO.getName() != null ) {
            finalProduct.setName( productSaveDTO.getName() );
        }
        if ( productSaveDTO.getDescription() != null ) {
            finalProduct.setDescription( productSaveDTO.getDescription() );
        }
        finalProduct.setPrice( productSaveDTO.getPrice() );
        finalProduct.setQuantity( productSaveDTO.getQuantity() );
        if ( productSaveDTO.getImageUrl() != null ) {
            finalProduct.setImageUrl( productSaveDTO.getImageUrl() );
        }
        finalProduct.setActive( productSaveDTO.isActive() );

        return finalProduct;
    }

    @Override
    public List<ProductView> fromProductsToProductViews(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductView> list = new ArrayList<ProductView>( products.size() );
        for ( Product product : products ) {
            list.add( productToProductView( product ) );
        }

        return list;
    }

    @Override
    public List<ProductView> getProductsPage(Page<FinalProduct> pages) {
        if ( pages == null ) {
            return null;
        }

        List<ProductView> list = new ArrayList<ProductView>();
        for ( FinalProduct finalProduct : pages ) {
            list.add( fromProductToProductView( finalProduct ) );
        }

        return list;
    }

    @Override
    public void updateFromProductToProductSaveDTO(ProductSaveDTO productSaveDTO, FinalProduct product) {
        if ( productSaveDTO == null ) {
            return;
        }

        if ( product.getCategory() == null ) {
            product.setCategory( new Category() );
        }
        productSaveDTOToCategory1( productSaveDTO, product.getCategory() );
        if ( productSaveDTO.getName() != null ) {
            product.setName( productSaveDTO.getName() );
        }
        else {
            product.setName( null );
        }
        if ( productSaveDTO.getDescription() != null ) {
            product.setDescription( productSaveDTO.getDescription() );
        }
        else {
            product.setDescription( null );
        }
        product.setPrice( productSaveDTO.getPrice() );
        product.setQuantity( productSaveDTO.getQuantity() );
        if ( productSaveDTO.getImageUrl() != null ) {
            product.setImageUrl( productSaveDTO.getImageUrl() );
        }
        else {
            product.setImageUrl( null );
        }
        product.setActive( productSaveDTO.isActive() );
    }

    protected List<CategoryView> categoryListToCategoryViewList(List<Category> list) {
        if ( list == null ) {
            return null;
        }

        List<CategoryView> list1 = new ArrayList<CategoryView>( list.size() );
        for ( Category category : list ) {
            list1.add( categoryToCategoryView( category ) );
        }

        return list1;
    }

    protected CategoryView categoryToCategoryView(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryView categoryView = new CategoryView();

        if ( category.getId() != null ) {
            categoryView.setId( category.getId() );
        }
        if ( category.getName() != null ) {
            categoryView.setName( category.getName() );
        }
        if ( category.getDescription() != null ) {
            categoryView.setDescription( category.getDescription() );
        }
        if ( category.getCreatedAt() != null ) {
            categoryView.setCreatedAt( category.getCreatedAt() );
        }
        if ( category.getUpdatedAt() != null ) {
            categoryView.setUpdatedAt( category.getUpdatedAt() );
        }
        categoryView.setActive( category.isActive() );
        if ( category.getParentCategory() != null ) {
            categoryView.setParentCategory( categoryToCategoryView( category.getParentCategory() ) );
        }
        List<CategoryView> list = categoryListToCategoryViewList( category.getSubcategories() );
        if ( list != null ) {
            categoryView.setSubcategories( list );
        }

        return categoryView;
    }

    protected List<Category> categoryViewListToCategoryList(List<CategoryView> list) {
        if ( list == null ) {
            return null;
        }

        List<Category> list1 = new ArrayList<Category>( list.size() );
        for ( CategoryView categoryView : list ) {
            list1.add( categoryViewToCategory( categoryView ) );
        }

        return list1;
    }

    protected Category categoryViewToCategory(CategoryView categoryView) {
        if ( categoryView == null ) {
            return null;
        }

        Category category = new Category();

        if ( categoryView.getId() != null ) {
            category.setId( categoryView.getId() );
        }
        if ( categoryView.getName() != null ) {
            category.setName( categoryView.getName() );
        }
        if ( categoryView.getDescription() != null ) {
            category.setDescription( categoryView.getDescription() );
        }
        if ( categoryView.getCreatedAt() != null ) {
            category.setCreatedAt( categoryView.getCreatedAt() );
        }
        if ( categoryView.getUpdatedAt() != null ) {
            category.setUpdatedAt( categoryView.getUpdatedAt() );
        }
        category.setActive( categoryView.isActive() );
        if ( categoryView.getParentCategory() != null ) {
            category.setParentCategory( categoryViewToCategory( categoryView.getParentCategory() ) );
        }
        List<Category> list = categoryViewListToCategoryList( categoryView.getSubcategories() );
        if ( list != null ) {
            category.setSubcategories( list );
        }

        return category;
    }

    private Long productCategoryId(FinalProduct finalProduct) {
        if ( finalProduct == null ) {
            return null;
        }
        Category category = finalProduct.getCategory();
        if ( category == null ) {
            return null;
        }
        Long id = category.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Category productSaveDTOToCategory(ProductSaveDTO productSaveDTO) {
        if ( productSaveDTO == null ) {
            return null;
        }

        Category category = new Category();

        if ( productSaveDTO.getIdCategory() != null ) {
            category.setId( productSaveDTO.getIdCategory() );
        }

        return category;
    }

    protected ProductView productToProductView(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductView productView = new ProductView();

        if ( product.getId() != null ) {
            productView.setId( product.getId() );
        }
        if ( product.getName() != null ) {
            productView.setName( product.getName() );
        }
        if ( product.getDescription() != null ) {
            productView.setDescription( product.getDescription() );
        }
        productView.setPrice( product.getPrice() );
        productView.setQuantity( product.getQuantity() );
        if ( product.getCategory() != null ) {
            productView.setCategory( categoryToCategoryView( product.getCategory() ) );
        }
        if ( product.getImageUrl() != null ) {
            productView.setImageUrl( product.getImageUrl() );
        }
        if ( product.getCreatedAt() != null ) {
            productView.setCreatedAt( product.getCreatedAt() );
        }
        if ( product.getUpdatedAt() != null ) {
            productView.setUpdatedAt( product.getUpdatedAt() );
        }
        productView.setActive( product.isActive() );

        return productView;
    }

    protected void productSaveDTOToCategory1(ProductSaveDTO productSaveDTO, Category mappingTarget) {
        if ( productSaveDTO == null ) {
            return;
        }
    }
}
