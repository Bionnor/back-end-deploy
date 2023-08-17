package com.flora.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReview;

    private String content;
    private Date dateavis;
    @Enumerated(EnumType.ORDINAL)
    private Rate numetoile;
    @ManyToOne
   private Customer customer;

    @ManyToOne
   private Product product;

}
