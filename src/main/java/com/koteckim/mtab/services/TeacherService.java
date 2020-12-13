package com.koteckim.mtab.services;

import com.koteckim.mtab.model.Teacher;

import java.util.List;

public interface TeacherService {

    public List<Teacher> getAllTeachers();
    public Teacher getTeacherById(int id);
    public void addTeacher(Teacher teacher);
    public void deleteTeacher(int id);

}
