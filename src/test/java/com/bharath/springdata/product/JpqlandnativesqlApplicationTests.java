package com.bharath.springdata.product;

import com.bharath.springdata.product.entities.Student;
import com.bharath.springdata.product.repos.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class JpqlandnativesqlApplicationTests {

    @Autowired
    StudentRepository repository;

    @Test
    public void testStudyCreate() {
        var student = Student.builder()
                .firstName("John")
                .lastName("Ferguson")
                .score(88).build();

        var student2 = Student.builder()
                .firstName("Bill")
                .lastName("Gates")
                .score(75).build();

        repository.saveAll(List.of(student, student2));
    }

    @Test
    public void testFindAllStudents() {
        Pageable pageable = PageRequest.of(3, 3, Sort.by(Sort.Direction.ASC, "id"));
        repository.findAllStudents(pageable).forEach(System.out::println);
    }

    @Test
    public void testFindAllStudentsPartial() {
        List<Object[]> data = repository.findAllStudentsPartialData();
        for (Object[] object : data) {
            System.out.println(object[0]);
            System.out.println(object[1]);
        }
    }

    @Test
    public void testFindAllStudentsByFirstName() {
        repository.findAllStudentsByFirstName("John").forEach(System.out::println);
    }

    @Test
    public void testFindStudentsForGivenScore() {
        repository.findStudentsForGivenScore(80, 90).forEach(System.out::println);
    }

    @Test
    @Transactional @Rollback(value = false)
    public void testDeleteStudentsByFirstName() {
        repository.deleteStudentsByFirstName("Bill");
    }

    @Test
    public void testFindAllStudentsNativeQuery() {
        repository.findAllStudentsNativeQuery().forEach(System.out::println);
    }

    @Test
    public void testFindByFirstNameNativeQuery() {
        repository.findByFirstNameNativeQuery("Xavier").forEach(System.out::println);
    }
}
