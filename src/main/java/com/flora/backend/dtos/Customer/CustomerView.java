package com.flora.backend.dtos.Customer;

import com.flora.backend.dtos.Order.OrderView;
import com.flora.backend.entities.Orders;
import com.flora.backend.entities.Review;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerView {
    private Long id;
    private String email;
    private String username;
    private String password;
    private Boolean isOnline=false;
    private String photoUrl;
    private String firstName;
    private String lastName;
    private Boolean sexe;
    private String phone;
}
