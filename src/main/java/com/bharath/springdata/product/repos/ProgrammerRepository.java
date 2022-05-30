package com.bharath.springdata.product.repos;

import com.bharath.springdata.product.entities.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammerRepository extends JpaRepository<Programmer, Integer> {
}
