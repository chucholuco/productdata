package com.bharath.springdata.product.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class Customer3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customer3", cascade = CascadeType.ALL, fetch = FetchType.EAGER) //By default, this setting (fetch) is enabled (lazy).
    private Set<PhoneNumber> numbers;

    public void addPhoneNumber(PhoneNumber number) {
        if (number != null) {
            if (this.numbers == null) {
                numbers = new HashSet<>();
            }
            number.setCustomer3(this);
            numbers.add(number);
        }
    }
}
