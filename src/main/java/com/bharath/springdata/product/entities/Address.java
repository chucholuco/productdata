package com.bharath.springdata.product.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Data
@Embeddable
public class Address {

    private String streetaddress;
    private String city;
    private String state;
    private String zipcode;
    private String country;
}
