package com.bharath.springdata.product.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "card")
public class CreditCard2 extends Payment2 {

    @Column(name = "cardnumber")
    private String cardNumber;

}
