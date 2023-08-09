package com.flora.backend.controller;

import com.flora.backend.dtos.Product.ProductView;
import com.flora.backend.dtos.ResponsePageDTO;
import com.flora.backend.dtos.Review.ReviewShow;
import com.flora.backend.services.ReviewService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @GetMapping("/")
    public ResponsePageDTO<ReviewShow> ShowProducts(@RequestParam(name = "page", defaultValue = "0") int page,
                                                    @RequestParam(name = "size", defaultValue = "6") int size) {

        return reviewService.showReviews(page, size);
    }

    @GetMapping
    public ResponsePageDTO<ReviewShow> getFilteredReviews(
            @RequestParam(required = false) String searchTerm,
            @RequestParam(required = false) Long productId,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "0") int pageNumber) {
        return reviewService.getFilteredReviews(searchTerm, productId, pageSize, pageNumber);
    }
    @GetMapping("/by-product")
    public ResponsePageDTO<ReviewShow> ShowProductsByProduct(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "product_id") Long productId,
            @RequestParam(name = "size", defaultValue = "6") int size) {

        return reviewService.findByProduct(page, size,productId);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long reviewId) {
        boolean isDeleted = reviewService.deleteProduct(reviewId);

        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
}
