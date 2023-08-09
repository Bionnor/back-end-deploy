package com.flora.backend.dtos.Review;

import com.flora.backend.dtos.Customer.CustomerView;
import com.flora.backend.dtos.Product.ProductSummary;
import com.flora.backend.entities.Rate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewShow {

    private Long idReview;

    private CustomerView customer;
    private String content;
    private Date dateavis;
    private Rate numetoile;
    private ProductSummary product;
}