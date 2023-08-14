
package com.flora.backend.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity

@DiscriminatorValue("Final product")
public class FinalProduct extends Product{
}

