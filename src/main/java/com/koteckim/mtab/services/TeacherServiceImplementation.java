package com.koteckim.mtab.services;

import com.koteckim.mtab.model.Teacher;
import com.koteckim.mtab.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeacherServiceImplementation implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAllTeachers() {
        return (List<Teacher>) teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(int id) {
        return teacherRepository.findById(id).get();
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(int id) {
        teacherRepository.deleteById(id);
    }
}
