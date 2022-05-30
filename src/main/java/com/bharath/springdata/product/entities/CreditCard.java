package com.bharath.springdata.product.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("cc")
public class CreditCard extends Payment {

    @Column(name = "cardnumber")
    private String cardNumber;

}
