package com.koteckim.mtab.repository;

import com.koteckim.mtab.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {


}
