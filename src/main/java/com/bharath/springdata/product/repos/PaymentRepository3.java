package com.bharath.springdata.product.repos;

import com.bharath.springdata.product.entities.Payment2;
import com.bharath.springdata.product.entities.Payment3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository3 extends JpaRepository<Payment3, Integer> {

}
