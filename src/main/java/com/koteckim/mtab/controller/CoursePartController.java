package com.koteckim.mtab.controller;

import com.koteckim.mtab.model.Course;
import com.koteckim.mtab.model.CoursePart;
import com.koteckim.mtab.model.Teacher;
import com.koteckim.mtab.services.CoursePartService;
import com.koteckim.mtab.services.CourseService;
import com.koteckim.mtab.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/coursePart")
public class CoursePartController {

    @Autowired
    CoursePartService coursePartService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    CourseService courseService;

    List<String> CLASS_TYPES = Arrays.asList("wykład", "laboratorium", "ćwiczenia", "lektorat", "seminarium", "projekt");

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("coursePart_list");
        List<CoursePart> coursePartList = coursePartService.getAllCourseParts();
        model.addObject("coursePartList", coursePartList);
        return model;
    }

    @RequestMapping(value = "/addCoursePart", method = RequestMethod.GET)
    public ModelAndView addCoursePart() {
        ModelAndView model = new ModelAndView();
        CoursePart coursePart = new CoursePart();
        model.addObject("coursePartForm", coursePart);
        model.setViewName("coursePart_form");
        List<Teacher> teacherList = teacherService.getAllTeachers();
        model.addObject("teacherList", teacherList);
        List<Course> courseList = courseService.getAllCourses();
        model.addObject("courseList", courseList);
        model.addObject("classTypes",CLASS_TYPES);
        return model;
    }


    @RequestMapping(value = "/editCoursePart/{id}", method = RequestMethod.GET)
    public ModelAndView editCoursePart(@PathVariable int id) {
        ModelAndView model = new ModelAndView();
        CoursePart coursePart = coursePartService.getCoursePartById(id);
        model.addObject("coursePartForm", coursePart);
        model.setViewName("coursePart_form");
        List<Teacher> teacherList = teacherService.getAllTeachers();
        model.addObject("teacherList", teacherList);
        List<Course> courseList = courseService.getAllCourses();
        model.addObject("courseList", courseList);
        model.addObject("classTypes",CLASS_TYPES);
        return model;
    }

    @RequestMapping(value = "/addCoursePart", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("coursePartForm") CoursePart coursePart) {
        coursePartService.addCoursePart(coursePart);
        return new ModelAndView("redirect:/coursePart/list");
    }

    @RequestMapping(value = "/deleteCoursePart/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        coursePartService.deleteCoursePart(id);
        return new ModelAndView("redirect:/coursePart/list");
    }
}
