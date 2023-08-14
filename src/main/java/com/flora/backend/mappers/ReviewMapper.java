package com.flora.backend.mappers;

import com.flora.backend.dtos.Review.ReviewShow;
import com.flora.backend.entities.Review;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")

public interface ReviewMapper {

    ReviewShow fromReviewToReviewShow(Review review);

    Review fromReviewShowToReview(ReviewShow reviewShow);
    List<ReviewShow> getReviewsPage(Page<Review> pages);

}
