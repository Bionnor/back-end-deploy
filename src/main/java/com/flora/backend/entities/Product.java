package com.flora.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private double price;

    private int quantity;
    @ManyToOne
    private Category category;

    private String brand;

    private String imageUrl;

    private double rating;
/*
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Review> reviews;*/

    private Date createdAt;

    private Date updatedAt;


    private boolean isActive;
    @OneToMany(mappedBy = "product")
    private List<OrderLine> orderLines;

}
