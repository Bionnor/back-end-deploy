package com.flora.backend.loader;

import com.flora.backend.entities.Customer;
import com.flora.backend.entities.Product;
import com.flora.backend.entities.Rate;
import com.flora.backend.entities.Review;
import com.flora.backend.repository.CustomerRepository;
import com.flora.backend.repository.ProductRepository;
import com.flora.backend.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
@Order(6)
public class ReviewDataLoader implements CommandLineRunner {
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Override
    public void run(String... args) throws Exception {
        Customer customer = customerRepository.findByUsername("customer").orElseThrow(()->new RuntimeException("not found"));
        Product product = productRepository.findById(1L).orElseThrow(()->new RuntimeException("not found"));
        Review review=new Review();
        review.setDateavis(new Date());
        review.setCustomer(customer);
        review.setNumetoile(Rate.CINQ);
        review.setContent("Great product! It's simple to use and does the job perfectly. I'm impressed with the quality and performance. Highly recommended.");
        review.setProduct(product);

        reviewRepository.save(review);



    }


}
