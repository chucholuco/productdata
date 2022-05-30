package com.bharath.springdata.product.repos;

import com.bharath.springdata.product.entities.Customer3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Customer3Repository extends JpaRepository<Customer3, Long> {
}
