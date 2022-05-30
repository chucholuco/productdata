package com.bharath.springdata.product.repos;

import com.bharath.springdata.product.entities.Employee2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employee2Repository extends JpaRepository<Employee2, Integer> {
}
