package com.bharath.springdata.product.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(CustomerId.class)
@Getter @Setter
public class Customer4 {

    @Id
    private int id;

    @Id
    private String email;

    private String name;
}
