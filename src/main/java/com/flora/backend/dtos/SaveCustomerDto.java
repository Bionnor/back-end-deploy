package com.flora.backend.dtos;

import com.flora.backend.entities.Role;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class SaveCustomerDto {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String photoUrl;
    private Boolean sexe;
    private String phone;


}
