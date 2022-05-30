package com.bharath.springdata.product.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    private int id;

    private String name;

    @Column(name = "description")
    private String desc;

    private Double price;

}
