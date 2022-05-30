package com.bharath.springdata.product.repos;

import com.bharath.springdata.product.entities.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("from Student")
    List<Student> findAllStudents(Pageable pageable);

    @Query("select st.firstName, st.lastName from Student st")
    List<Object[]> findAllStudentsPartialData();

    @Query("from Student where firstName=:firstName")
    List<Student> findAllStudentsByFirstName(@Param("firstName") String firstName);

    @Query("from Student where score between :min and :max")
    List<Student> findStudentsForGivenScore(@Param("min") int min, @Param("max") int max);

    @Modifying
    @Query("delete from Student where firstName=:fName")
    void deleteStudentsByFirstName(@Param("fName") String firstName);

    @Query(value = "SELECT * FROM student ORDER BY fname", nativeQuery = true)
    List<Student> findAllStudentsNativeQuery();

    @Query(value = "SELECT * FROM student WHERE fname=:firstName ", nativeQuery = true)
    List<Student> findByFirstNameNativeQuery(@Param("firstName") String firstName);
}
