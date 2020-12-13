package com.koteckim.mtab.controller;

import com.koteckim.mtab.model.Course;
import com.koteckim.mtab.model.Registration;
import com.koteckim.mtab.model.Student;
import com.koteckim.mtab.services.CourseService;
import com.koteckim.mtab.services.RegistrationService;
import com.koteckim.mtab.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @Autowired
    CourseService courseService;

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("registration_list");
        List<Registration> registrationList = registrationService.getAllRegistrations();
        model.addObject("registrationList", registrationList);
        return model;
    }

    @RequestMapping(value = "/addRegistration/", method = RequestMethod.GET)
    public ModelAndView addRegistration() {
        ModelAndView model = new ModelAndView();
        Registration registration = new Registration();
        model.addObject("registrationForm", registration);
        List<Course> courseList = courseService.getAllCourses();
        model.addObject("courseList", courseList);
        List<Student> studentList = studentService.getAllStudents();
        model.addObject("studentList", studentList);
        model.setViewName("registration_form");
        return model;
    }


    @RequestMapping(value = "/editRegistration/{id}", method = RequestMethod.GET)
    public ModelAndView editRegistration(@PathVariable int id) {
        ModelAndView model = new ModelAndView();
        Registration registration = registrationService.getRegistrationById(id);
        model.addObject("registrationForm", registration);
        List<Course> courseList = courseService.getAllCourses();
        model.addObject("courseList", courseList);
        List<Student> studentList = studentService.getAllStudents();
        model.addObject("studentList", studentList);
        model.setViewName("registration_edit_form");
        return model;
    }

    @RequestMapping(value = "/addRegistration", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("registrationForm") Registration registration) {
        if (registration.getCourse().getSemester().equals(registration.getStudent().getSemester())
        && registration.getCourse().getFieldofstudy().equals(registration.getStudent().getFieldofstudy())) {
            registrationService.addRegistration(registration);
            return new ModelAndView("redirect:/registration/list");
        } else {
            ModelAndView model = new ModelAndView();
            model.setViewName("registration_error");
            return model;
        }
    }

    @RequestMapping(value = "/deleteRegistration/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        registrationService.deleteRegistration(id);
        return new ModelAndView("redirect:/registration/list");
    }
}
