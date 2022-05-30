package com.bharath.springdata.product.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String type;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer3 customer3;
}
