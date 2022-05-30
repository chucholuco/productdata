package com.bharath.springdata.product.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    //@TableGenerator(name = "employee_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 100)
    @GenericGenerator(name = "emp_id", strategy = "com.bharath.springdata.product.idgenerators.CustomRandomIDGenerator")
    @GeneratedValue(generator = "emp_id")
    @Id
    //@GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_gen")
    private Long id;

    private String name;
}
