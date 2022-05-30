package com.bharath.springdata.product.repos;

import com.bharath.springdata.product.entities.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByEmailAndName(String email, String name);

    List<Customer> findByEmailLike(String email);

    List<Customer> findByIdIn(List<Integer> ids, Pageable pageable);

    @Query("from Customer where id in :ids")
    List<Customer> findByIdInJPQL(@Param("ids") List<Integer> ids, Pageable pageable);

    @Query("update Customer set email=:email where id=:id")
    @Modifying
    void updateEmailGivenIdAndEmail(@Param("email") String email, @Param("id") int id);


}
