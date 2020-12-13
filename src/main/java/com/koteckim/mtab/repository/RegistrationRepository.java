package com.koteckim.mtab.repository;

import com.koteckim.mtab.model.Course;
import com.koteckim.mtab.model.Registration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegistrationRepository extends CrudRepository<Registration, Integer> {

    @Query(
            value = "SELECT * FROM registration WHERE student_id = :sid",
            nativeQuery=true
    )
    public List<Registration> findByStudentId(@Param("sid") int sid);
}
