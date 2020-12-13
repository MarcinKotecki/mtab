package com.koteckim.mtab.services;

import com.koteckim.mtab.model.Course;

import java.util.List;

public interface CourseService {

    public List<Course> getAllCourses();
    public Course getCourseById(int id);
    public void addCourse(Course course);
    public void deleteCourse(int id);

}
