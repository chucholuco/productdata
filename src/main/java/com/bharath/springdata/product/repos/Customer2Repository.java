package com.bharath.springdata.product.repos;

import com.bharath.springdata.product.entities.Customer2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Customer2Repository extends JpaRepository<Customer2, Integer> {
}
