package com.koteckim.mtab.controller;

import com.koteckim.mtab.model.Teacher;
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
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("teacher_list");
        List<Teacher> teacherList = teacherService.getAllTeachers();
        model.addObject("teacherList", teacherList);
        return model;
    }

    @RequestMapping(value = "/addTeacher/", method = RequestMethod.GET)
    public ModelAndView addTeacher() {
        ModelAndView model = new ModelAndView();
        Teacher teacher = new Teacher();
        model.addObject("teacherForm", teacher);
        model.setViewName("teacher_form");
        return model;
    }


    @RequestMapping(value = "/editTeacher/{id}", method = RequestMethod.GET)
    public ModelAndView editTeacher(@PathVariable int id) {
        ModelAndView model = new ModelAndView();
        Teacher teacher = teacherService.getTeacherById(id);
        model.addObject("teacherForm", teacher);
        model.setViewName("teacher_form");
        return model;
    }

    @RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("teacherForm") Teacher teacher) {
        teacherService.addTeacher(teacher);
        return new ModelAndView("redirect:/teacher/list");
    }

    @RequestMapping(value = "/deleteTeacher/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        teacherService.deleteTeacher(id);
        return new ModelAndView("redirect:/teacher/list");
    }
}
