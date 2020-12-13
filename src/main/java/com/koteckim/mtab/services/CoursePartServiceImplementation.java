package com.koteckim.mtab.services;

import com.koteckim.mtab.model.CoursePart;
import com.koteckim.mtab.repository.CoursePartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CoursePartServiceImplementation implements CoursePartService {

    @Autowired
    CoursePartRepository coursePartRepository;

    @Override
    public List<CoursePart> getAllCourseParts() {
        return (List<CoursePart>) coursePartRepository.findAll();
    }

    @Override
    public CoursePart getCoursePartById(int id) {
        return coursePartRepository.findById(id).get();
    }

    @Override
    public void addCoursePart(CoursePart coursePart) {
        coursePartRepository.save(coursePart);
    }

    @Override
    public void deleteCoursePart(int id) {
        coursePartRepository.deleteById(id);
    }
}
