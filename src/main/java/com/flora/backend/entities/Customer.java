package com.flora.backend.entities;

import jakarta.persistence.*;
import lombok.*;

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

}
