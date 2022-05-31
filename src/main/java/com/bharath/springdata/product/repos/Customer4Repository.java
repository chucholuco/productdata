package com.bharath.springdata.product.repos;

import com.bharath.springdata.product.entities.Customer4;
import com.bharath.springdata.product.entities.CustomerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Customer4Repository extends JpaRepository<Customer4, CustomerId> {
}
