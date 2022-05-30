package com.bharath.springdata.product.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "bankcheck2")
@PrimaryKeyJoinColumn(name = "id")
public class Check3 extends Payment3{

    @Column(name = "checknumber")
    private String checkNumber;


}
