package com.bharath.springdata.product.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "card2")
@PrimaryKeyJoinColumn(name = "id")
public class CreditCard3 extends Payment3 {

    @Column(name = "cardnumber")
    private String cardNumber;

}
