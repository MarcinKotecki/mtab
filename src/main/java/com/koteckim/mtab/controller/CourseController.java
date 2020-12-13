package com.koteckim.mtab.controller;

import com.koteckim.mtab.model.Course;
import com.koteckim.mtab.model.Teacher;
import com.koteckim.mtab.services.CourseService;
import com.koteckim.mtab.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/course")
public class CourseController {

    @Autowired
    CourseService courseService;
    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("course_list");
        List<Course> courseList = courseService.getAllCourses();
        model.addObject("courseList", courseList);
        return model;
    }

    @RequestMapping(value = "/addCourse/", method = RequestMethod.GET)
    public ModelAndView addCourse() {
        ModelAndView model = new ModelAndView();
        Course course = new Course();
        model.addObject("courseForm", course);
        model.setViewName("course_form");
        List<Teacher> teacherList = teacherService.getAllTeachers();
        model.addObject("teacherList",teacherList);
        return model;
    }


    @RequestMapping(value = "/editCourse/{id}", method = RequestMethod.GET)
    public ModelAndView editCourse(@PathVariable int id) {
        ModelAndView model = new ModelAndView();
        Course course = courseService.getCourseById(id);
        model.addObject("courseForm", course);
        model.setViewName("course_form");
        List<Teacher> teacherList = teacherService.getAllTeachers();
        model.addObject("teacherList",teacherList);
        return model;
    }

    @RequestMapping(value = "/addCourse", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("courseForm") Course course) {
        courseService.addCourse(course);
        return new ModelAndView("redirect:/course/list");
    }

    @RequestMapping(value = "/deleteCourse/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        courseService.deleteCourse(id);
        return new ModelAndView("redirect:/course/list");
    }
}
