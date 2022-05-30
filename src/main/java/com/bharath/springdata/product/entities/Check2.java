package com.bharath.springdata.product.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "bankcheck")
public class Check2 extends Payment2{

    @Column(name = "checknumber")
    private String checkNumber;


}
