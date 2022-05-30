package com.bharath.springdata.product;

import com.bharath.springdata.product.entities.Product;
import com.bharath.springdata.product.repos.ProductRepository;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ProductdataApplicationTests {

    private static final Logger LOG = LoggerFactory.getLogger(ProductdataApplicationTests.class);

    @Autowired
    private ProductRepository repository;

    @Autowired
    EntityManager entityManager;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreate() {
        var product = Product.builder()
                .id(6)
                .name("Iphone")
                .desc("Awesome")
                .price(1005d)
                .build();

        repository.save(product);
    }

    @Test
    public void read() {
        Product product = repository.findById(1).get();
        assertNotNull(product);
        assertEquals("Iphone", product.getName());
        LOG.info("the product is {}", product);
    }

    @Test
    public void testUpdate() {
        Product product = repository.findById(1).get();
        product.setPrice(1200d);
        repository.save(product);
        assertEquals(1200d, product.getPrice());
    }

    @Test
    public void delete() {
        if (repository.existsById(1)) {
            LOG.info("Deleting a product");
            repository.deleteById(1);
        }
    }

    @Test
    public void testCount() {
        LOG.info("Total Records: {}", repository.count());
    }

    @Test
    public void testFindByName() {
        List<Product> iWatch = repository.findByName("iWatch");
        iWatch.forEach(System.out::println);
    }

    @Test
    public void testFindByNameAndDesc() {
        List<Product> iWatch = repository.findByNameAndDesc("Washer", "From LG");

    }

    @Test
    public void testFindPriceGreaterThan() {
        List<Product> products = repository.findByPriceGreaterThan(1200D);
        products.forEach(System.out::println);
    }

    @Test
    public void testFindByDescContains() {
        List<Product> products = repository.findByDescContains("Apple");
        products.forEach(System.out::println);
    }

    @Test
    public void testFindByPriceBetween() {
        List<Product> products = repository.findByPriceBetween(100d, 1200d);
        products.forEach(System.out::println);
    }

    @Test
    public void testFindByDescLike() {
        List<Product> products = repository.findByDescLike("%From S%");
        products.forEach(System.out::println);
    }

    @Test
    public void testFindIdsIn() {
        Pageable pageable = PageRequest.of(0, 2);
        List<Product> products = repository.findByIdIn(List.of(1, 3, 5), pageable);
        products.forEach(System.out::println);
    }

    @Test
    public void testFindAllPaging() {
        Pageable pageable = PageRequest.of(0, 2);
        //Pageable pageable = PageRequest.of(0, 2, Sort.Direction.DESC, "name");
        Page<Product> products = repository.findAll(pageable);
        products.forEach(System.out::println);
    }

    @Test
    public void testFindAllSorting() {
        //repository.findAll(Sort.by(Sort.Direction.DESC, "name")).forEach(System.out::println);
        //repository.findAll(Sort.by(Sort.Direction.DESC, "name", "price")).forEach(System.out::println);
        repository.findAll(Sort.by(new Sort.Order(Sort.Direction.DESC, "name"),
                        new Sort.Order(Sort.Direction.ASC, "price")))
                .forEach(System.out::println);
    }

    @Test
    public void testFindAllPagingAndSorting() {
        Pageable pageable = PageRequest.of(0, 2, Sort.Direction.DESC, "name");
        repository.findAll(pageable).forEach(System.out::println);
    }

    @Test
    @Transactional
    public void testCaching() {
        Session session = entityManager.unwrap(Session.class);
        Product product = repository.findById(4).get();

        repository.findById(4).get();

        session.evict(product);

        repository.findById(4).get();
    }

    @Test
    public void testFindAllProductsSP() {
        repository.findAllProductsSP().forEach(System.out::println);
    }

    @Test
    public void testGetAllProductsByPriceSP() {
        repository.getAllProductsGraterByPriceSP(1000D).forEach(System.out::println);
        System.out.println(repository.getAllProductsCountGreaterByPriceSP(1000D));

    }
}
