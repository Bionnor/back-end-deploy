package com.flora.backend.dtos.Customer;

import lombok.Data;

@Data
public class CustomerView {
    private  Long id;
    private  String username;
    private String firstName;
    private String lastName;
    private Boolean sexe;
    private String phone;
}

