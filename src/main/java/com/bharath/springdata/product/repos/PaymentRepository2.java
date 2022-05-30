package com.bharath.springdata.product.repos;

import com.bharath.springdata.product.entities.Payment;
import com.bharath.springdata.product.entities.Payment2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository2 extends JpaRepository<Payment2, Integer> {

}
