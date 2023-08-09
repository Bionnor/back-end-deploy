package com.flora.backend.dtos.Review;

import com.flora.backend.dtos.Category.CategoryView;
import lombok.Data;

import java.util.List;
@Data
public class ReviewPageDTO {
        private int currentPage;
        private int totalPages;
        private int pageSize;
        private List<ReviewShow> reviewShows;

}
