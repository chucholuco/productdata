package com.bharath.springdata.product;

import com.bharath.springdata.product.entities.*;
import com.bharath.springdata.product.repos.Customer3Repository;
import com.bharath.springdata.product.repos.LicenseRepository;
import com.bharath.springdata.product.repos.ProgrammerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
public class AssociationsApplicationTests {

    @Autowired
    Customer3Repository repository;

    @Autowired
    ProgrammerRepository programmerRepository;

    @Autowired
    LicenseRepository licenseRepository;

    @Test
    public void testCreateCustomer() {

        Customer3 customer = new Customer3();
        customer.setName("Jesus");

        customer.addPhoneNumber(PhoneNumber.builder().number("1234567890").type("cell").build());
        customer.addPhoneNumber(PhoneNumber.builder().number("0987654321").type("home").build());

        repository.save(customer);
    }

    @Test
    @Transactional
    public void loadCustomer() {
        Customer3 customer = repository.findById(6L).get();
        System.out.println(customer.getName());

        Set<PhoneNumber> numbers = customer.getNumbers();
        numbers.forEach(x -> System.out.println(x.getNumber()));
    }

    @Test
    public void testUpdateCustomer() {
        Customer3 customer = repository.findById(6L).get();
        customer.setName("Azalia");

        Set<PhoneNumber> numbers = customer.getNumbers();
        numbers.forEach(number -> number.setType("cell"));

        repository.save(customer);
    }

    @Test
    public void testDelete() {
        repository.deleteById(6L);
    }

    @Test
    public void testCreateProgrammerManyToMany() {
        Programmer programmer = new Programmer();
        programmer.setName("Jesus");
        programmer.setSal(10_000);

        HashSet<Project> projects = new HashSet<>();
        Project project = new Project();
        project.setName("Hibernate Project");
        projects.add(project);

        programmer.setProjects(projects);

        programmerRepository.save(programmer);
    }

    @Test
    @Transactional
    public void testFindProgrammerManyToMany() {
        Programmer programmer = programmerRepository.findById(5).get();
        System.out.println(programmer);
    }

    @Test
    public void testOneToOneCreateLicense() {
        License license = new License();
        license.setType("CAR");
        license.setValidFrom(LocalDate.now());
        license.setValidTo(LocalDate.of(2025, 1, 25));

        Person person = new Person();
        person.setFirstName("Jesus");
        person.setLastName("Tapia");
        person.setAge(38);

        license.setPerson(person);

        licenseRepository.save(license);
    }
}
