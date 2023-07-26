package com.flora.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@AllArgsConstructor
@Data
@Entity
@Table(name = "admin")
public class Administrator extends User {
}
