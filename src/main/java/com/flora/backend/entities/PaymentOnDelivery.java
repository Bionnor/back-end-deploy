package com.flora.backend.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("PAYMENT_ON_DELIVERY")
public class PaymentOnDelivery extends Payment {
    private String deliveryAddress;

    // Getters and setters
}
