package com.koteckim.mtab.services;

import com.koteckim.mtab.model.Course;
import com.koteckim.mtab.repository.CourseRepository;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImplementation implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course getCourseById(int id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }
}
