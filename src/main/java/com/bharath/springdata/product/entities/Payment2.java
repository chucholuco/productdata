package com.bharath.springdata.product.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Payment2 {

    @Id
    private int id;

    private double amount;
}
