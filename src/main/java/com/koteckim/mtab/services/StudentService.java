package com.koteckim.mtab.services;

import com.koteckim.mtab.model.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudents();
    public Student getStudentById(int id);
    public void addStudent(Student student);
    public void deleteStudent(int id);

}
