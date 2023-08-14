package com.flora.backend.services;

import com.flora.backend.dtos.Product.ProductView;
import com.flora.backend.dtos.ResponsePageDTO;

import com.flora.backend.dtos.Review.ReviewShow;
import com.flora.backend.entities.Product;
import com.flora.backend.entities.Review;
import com.flora.backend.mappers.ProductMapper;
import com.flora.backend.mappers.ReviewMapper;
import com.flora.backend.repository.ReviewRepository;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class ReviewServiceImp implements ReviewService{
    @Autowired
    private ReviewMapper reviewMapper;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductMapper productMapper;
    @Override
    public ResponsePageDTO<ReviewShow> showReviews(int page, int size) {
        Page<Review> pages= reviewRepository.findAll(PageRequest.of(page, size));
        log.info(pages.toString());
        ResponsePageDTO<ReviewShow> reviewpageDTO= new ResponsePageDTO<>();
        reviewpageDTO.setResponseList(reviewMapper.getReviewsPage(pages));
        reviewpageDTO.setTotalPages(pages.getTotalPages());
        reviewpageDTO.setCurrentPage(page);
        reviewpageDTO.setPageSize(size);
        return reviewpageDTO;
    }

    @Override
    public ResponsePageDTO<ReviewShow> findByProduct(int page, int size, Long productId) {
        ProductView product = productService.getProduct(productId);
        Page<Review> pages=  reviewRepository.getReviewsByProduct(
                productMapper.fromProductViewToProduct(product),PageRequest.of(page, size));
        ResponsePageDTO<ReviewShow> reviewShowResponsePageDTO= new ResponsePageDTO();
        reviewShowResponsePageDTO.setResponseList(reviewMapper.getReviewsPage(pages));
        reviewShowResponsePageDTO.setTotalPages(pages.getTotalPages());
        reviewShowResponsePageDTO.setCurrentPage(page);
        reviewShowResponsePageDTO.setPageSize(size);
        return reviewShowResponsePageDTO;
    }

    @Override
    public boolean deleteProduct(Long reviewId) {

        Review existingReview= reviewRepository.findById(reviewId).orElse(null);
        if (existingReview != null) {
            reviewRepository.delete(existingReview);
            return true;
        }
        return false;

    }

    @Override
    public ResponsePageDTO<ReviewShow> getFilteredReviews(String searchTerm, Long productId, int pageSize, int pageNumber) {
        Specification<Review> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (searchTerm != null && !searchTerm.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("content")), "%" + searchTerm.toLowerCase() + "%"));

            }

            if (productId != null) {
                Join<Review, Product> productJoin = root.join("product");
                predicates.add(criteriaBuilder.equal(productJoin.get("id"), productId));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        Page<Review> pages=  reviewRepository.findAll(specification, PageRequest.of(pageNumber, pageSize));
        ResponsePageDTO<ReviewShow> reviewShowResponsePageDTO= new ResponsePageDTO();
        reviewShowResponsePageDTO.setResponseList(reviewMapper.getReviewsPage(pages));
        reviewShowResponsePageDTO.setTotalPages(pages.getTotalPages());
        reviewShowResponsePageDTO.setCurrentPage(pageNumber);
        reviewShowResponsePageDTO.setPageSize(pageSize);
        return reviewShowResponsePageDTO;
    }






   /* @Override
    public ProductSaveDTO addReview(ProductSaveDTO productSaveDTO) {
        Product product=productMapper.fromProductSaveToProduct(productSaveDTO);
        log.info(productSaveDTO.toString());
        product.setCreatedAt(new Date());
        product.setActive(false);
        return productMapper.fromProductToProductSave(productRepository.save(product));

    }
    @Override
    public ProductView updateProduct(Long productId, ProductSaveDTO productSaveDTO){
        Product existingProduct = productRepository.findById(productId).orElse(null);
        existingProduct.setUpdatedAt(new Date());
        productMapper.updateFromProductToProductSaveDTO(productSaveDTO,existingProduct);
        // Fetch the Category entity from the database using the idCategory from the DTO
        Category category = categoryRepository.findById(productSaveDTO.getIdCategory()).orElse(null);
        // Set the Category reference to the Product entity
        existingProduct.setCategory(category);

        return productMapper.fromProductToProductView(productRepository.save(existingProduct));
    }
    @Override
    public boolean deleteProduct(Long productId){
        // Check if the product with the given ID exists
        Product existingProduct = productRepository.findById(productId).orElse(null);
        if (existingProduct != null) {
            productRepository.delete(existingProduct);
            return true;
        }
        return false;
    }
    @Transactional(readOnly = true)
    @Override
    public ResponsePageDTO<ProductView> getFilteredProducts(String searchTerm, Long categoryId, int pageSize, int pageNumber) {

        Specification<Product> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (searchTerm != null && !searchTerm.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + searchTerm.toLowerCase() + "%"));
            }

            if (categoryId != null) {
                Join<Product, Category> categoryJoin = root.join("category");
                predicates.add(criteriaBuilder.equal(categoryJoin.get("id"), categoryId));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        Page<Product> pages=  productRepository.findAll(specification, PageRequest.of(pageNumber, pageSize));
        ResponsePageDTO<ProductView> productViewResponsePageDTO= new ResponsePageDTO();
        productViewResponsePageDTO.setResponseList(productMapper.getProductsPage(pages));
        productViewResponsePageDTO.setTotalPages(pages.getTotalPages());
        productViewResponsePageDTO.setCurrentPage(pageNumber);
        productViewResponsePageDTO.setPageSize(pageSize);
        return productViewResponsePageDTO;
    }

    @Override
    public ProductView getProduct(Long id) {
        return productMapper.fromProductToProductView(productRepository.findById(id).orElseThrow(() -> new RuntimeException(
                "Product Not Found!")));
    }
*/
}
