package com.bharath.springdata.product;

import com.bharath.springdata.product.entities.Employee;
import com.bharath.springdata.product.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IdGeneratorsApplicationTests {

    @Autowired
    private EmployeeRepository repository;

    @Test
    public void testCreateEmployee() {
        var employee = Employee.builder()
                .name("Azalia")
                .build();

        repository.save(employee);
    }
}
