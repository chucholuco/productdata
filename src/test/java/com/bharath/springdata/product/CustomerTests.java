package com.bharath.springdata.product;

import com.bharath.springdata.product.entities.Address;
import com.bharath.springdata.product.entities.Customer;
import com.bharath.springdata.product.entities.Customer2;
import com.bharath.springdata.product.entities.Employee2;
import com.bharath.springdata.product.repos.Customer2Repository;
import com.bharath.springdata.product.repos.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CustomerTests {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerTests.class);

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private Customer2Repository repository2;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreate() {
        var customer = Customer.builder()
                .id(1)
                .name("Jesus")
                .email("chucholuco@gmail.com")
                .build();

        repository.save(customer);
    }

    @Test
    public void read() {
        Customer customer = repository.findById(1).get();
        assertNotNull(customer);
        assertEquals("Jesus", customer.getName());
        LOG.info("the customer is {}", customer);
    }

    @Test
    public void testUpdate() {
        Customer customer = repository.findById(1).get();
        customer.setName("Azalia");
        repository.save(customer);
        assertEquals("Azalia", customer.getName());
    }

    @Test
    public void delete() {
        if (repository.existsById(1)) {
            LOG.info("Deleting a customer");
            repository.deleteById(1);
        }
    }

    @Test
    public void testCount() {
        LOG.info("Total Records: {}", repository.count());
    }

    @Test
    public void testFindByEmailAndName() {
        List<Customer> customers = repository.findByEmailAndName("chucholuco@gmail.com", "Jesus");
        customers.forEach(System.out::println);
    }

    @Test
    public void testFindByEmailLike() {
        List<Customer> customers = repository.findByEmailLike("%@gmail.com%");
        customers.forEach(System.out::println);
    }

    @Test
    public void testFindByIdsIn() {
        Pageable pageable = PageRequest.of(0, 2, Sort.Direction.ASC, "name");
        List<Customer> customers = repository.findByIdIn(List.of(1, 2, 6), pageable);
        customers.forEach(System.out::println);
    }

    @Test
    public void testFindByIdsInJPQL() {
        Pageable pageable = PageRequest.of(0, 2, Sort.Direction.ASC, "name");
        List<Customer> customers = repository.findByIdInJPQL(List.of(1, 2, 6), pageable);
        customers.forEach(System.out::println);
    }

    @Test
    @Transactional @Rollback(value = false)
    public void testUpdateEmailById() {
        repository.updateEmailGivenIdAndEmail("chucholuco@gmail.com", 1);
    }

    @Test
    public void testCreateMappingEmbedded() {
        Customer2 customer = new Customer2();
        customer.setId(123);
        customer.setName("Jesus");

        Address address = new Address();
        address.setCity("Austin");
        address.setStreetaddress("Spicewood Springs");
        address.setCountry("USA");
        address.setState("Texas");
        address.setZipcode("78750");

        customer.setAddress(address);

        repository2.save(customer);
    }

}
