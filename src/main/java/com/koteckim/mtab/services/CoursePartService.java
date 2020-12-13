package com.koteckim.mtab.services;

import com.koteckim.mtab.model.CoursePart;

import java.util.List;

public interface CoursePartService {

    public List<CoursePart> getAllCourseParts();
    public CoursePart getCoursePartById(int id);
    public void addCoursePart(CoursePart coursePart);
    public void deleteCoursePart(int id);

}
