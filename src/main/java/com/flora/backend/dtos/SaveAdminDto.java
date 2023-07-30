package com.flora.backend.dtos;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class SaveAdminDto {
    @Column(unique = true ,nullable = false)
    private String email;
    @Column(unique = true ,nullable = false)
    private String username;
    private String password;
    private Boolean isOnline;
    private String photoUrl;
}
