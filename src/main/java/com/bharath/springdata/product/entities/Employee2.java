package com.bharath.springdata.product.entities;


import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Employee2 {

    @Id
    private int id;

    private String name;

    @Embedded
    private Address address;
}
