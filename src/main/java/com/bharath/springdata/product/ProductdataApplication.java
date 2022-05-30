package com.bharath.springdata.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;

@SpringBootApplication
public class ProductdataApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductdataApplication.class, args);
    }

}
