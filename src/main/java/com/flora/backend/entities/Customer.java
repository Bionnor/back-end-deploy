package com.flora.backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class Customer extends User {

    private String firstName;
    private String lastName;
    private Boolean sexe;
    private String phone;
    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;
    @OneToMany(mappedBy = "customer")
    private List<Review> reviews;
}
