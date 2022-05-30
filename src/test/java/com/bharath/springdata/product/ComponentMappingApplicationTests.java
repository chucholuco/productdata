package com.bharath.springdata.product;

import com.bharath.springdata.product.entities.Address;
import com.bharath.springdata.product.entities.Employee2;
import com.bharath.springdata.product.repos.Employee2Repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ComponentMappingApplicationTests {

    @Autowired
    Employee2Repository repository;

    @Test
    public void testCreate() {
        Employee2 employee = new Employee2();
        employee.setId(123);
        employee.setName("Jesus");

        Address address = new Address();
        address.setCity("Austin");
        address.setStreetaddress("Spicewood Springs");
        address.setCountry("USA");
        address.setState("Texas");
        address.setZipcode("78750");

        employee.setAddress(address);

        repository.save(employee);
    }
}
