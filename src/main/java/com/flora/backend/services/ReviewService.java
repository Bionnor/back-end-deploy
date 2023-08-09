package com.flora.backend.services;

import com.flora.backend.dtos.ResponsePageDTO;
import com.flora.backend.dtos.Review.ReviewShow;

public interface ReviewService {
    ResponsePageDTO<ReviewShow> showReviews(int page, int size);

    ResponsePageDTO<ReviewShow> findByProduct(int page, int size, Long productId);

    boolean deleteProduct(Long reviewId);

    ResponsePageDTO<ReviewShow> getFilteredReviews(String searchTerm, Long productId, int pageSize, int pageNumber);
}
