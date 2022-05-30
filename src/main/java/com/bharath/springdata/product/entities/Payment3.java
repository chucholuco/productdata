package com.bharath.springdata.product.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "payment2")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment3 {

    @Id
    private int id;

    private double amount;
}
