package com.flora.backend.mappers;

import com.flora.backend.dtos.Customer.CustomerView;
import com.flora.backend.dtos.Product.ProductSummary;
import com.flora.backend.dtos.Review.ReviewShow;
import com.flora.backend.entities.Customer;
import com.flora.backend.entities.Product;
import com.flora.backend.entities.Review;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-17T15:20:25+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19 (Eclipse Adoptium)"
)
@Component
public class ReviewMapperImpl implements ReviewMapper {

    @Override
    public ReviewShow fromReviewToReviewShow(Review review) {
        if ( review == null ) {
            return null;
        }

        ReviewShow reviewShow = new ReviewShow();

        reviewShow.setIdReview( review.getIdReview() );
        reviewShow.setCustomer( customerToCustomerView( review.getCustomer() ) );
        reviewShow.setContent( review.getContent() );
        reviewShow.setDateavis( review.getDateavis() );
        reviewShow.setNumetoile( review.getNumetoile() );
        reviewShow.setProduct( productToProductSummary( review.getProduct() ) );

        return reviewShow;
    }

    @Override
    public Review fromReviewShowToReview(ReviewShow reviewShow) {
        if ( reviewShow == null ) {
            return null;
        }

        Review.ReviewBuilder review = Review.builder();

        review.idReview( reviewShow.getIdReview() );
        review.content( reviewShow.getContent() );
        review.dateavis( reviewShow.getDateavis() );
        review.numetoile( reviewShow.getNumetoile() );
        review.customer( customerViewToCustomer( reviewShow.getCustomer() ) );
        review.product( productSummaryToProduct( reviewShow.getProduct() ) );

        return review.build();
    }

    @Override
    public List<ReviewShow> getReviewsPage(Page<Review> pages) {
        if ( pages == null ) {
            return null;
        }

        List<ReviewShow> list = new ArrayList<ReviewShow>();
        for ( Review review : pages ) {
            list.add( fromReviewToReviewShow( review ) );
        }

        return list;
    }

    protected CustomerView customerToCustomerView(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerView customerView = new CustomerView();

        customerView.setId( customer.getId() );
        customerView.setEmail( customer.getEmail() );
        customerView.setUsername( customer.getUsername() );
        customerView.setPassword( customer.getPassword() );
        customerView.setIsOnline( customer.getIsOnline() );
        customerView.setPhotoUrl( customer.getPhotoUrl() );
        customerView.setFirstName( customer.getFirstName() );
        customerView.setLastName( customer.getLastName() );
        customerView.setSexe( customer.getSexe() );
        customerView.setPhone( customer.getPhone() );

        return customerView;
    }

    protected ProductSummary productToProductSummary(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductSummary productSummary = new ProductSummary();

        productSummary.setId( product.getId() );
        productSummary.setName( product.getName() );
        productSummary.setDescription( product.getDescription() );
        productSummary.setImageUrl( product.getImageUrl() );

        return productSummary;
    }

    protected Customer customerViewToCustomer(CustomerView customerView) {
        if ( customerView == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerView.getId() );
        customer.setEmail( customerView.getEmail() );
        customer.setUsername( customerView.getUsername() );
        customer.setPassword( customerView.getPassword() );
        customer.setIsOnline( customerView.getIsOnline() );
        customer.setPhotoUrl( customerView.getPhotoUrl() );
        customer.setFirstName( customerView.getFirstName() );
        customer.setLastName( customerView.getLastName() );
        customer.setSexe( customerView.getSexe() );
        customer.setPhone( customerView.getPhone() );

        return customer;
    }

    protected Product productSummaryToProduct(ProductSummary productSummary) {
        if ( productSummary == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productSummary.getId() );
        product.setName( productSummary.getName() );
        product.setDescription( productSummary.getDescription() );
        product.setImageUrl( productSummary.getImageUrl() );

        return product;
    }
}
