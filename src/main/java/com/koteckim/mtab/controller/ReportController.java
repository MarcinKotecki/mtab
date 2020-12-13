package com.koteckim.mtab.controller;

import com.koteckim.mtab.model.*;
import com.koteckim.mtab.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping(value = "/report")
public class ReportController {

    @Autowired
    CourseService courseService;

    @Autowired
    CoursePartService coursePartService;

    @Autowired
    RegistrationService registrationService;

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    ComplexService complexService;

    @RequestMapping(value = "/ranking", method = RequestMethod.GET)
    public ModelAndView ranking_form() {
        ModelAndView model = new ModelAndView();
        model.setViewName("student_ranking_form");
        return model;
    }

    @RequestMapping(value = "/ranking", method = RequestMethod.POST)
    public ModelAndView ranking_get(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        List<Object[]> res = complexService.getStudentsRanking(request.getParameter("fieldOfStudy"),request.getParameter("semester"));
        model.addObject("objects", res);
        model.addObject("fieldOfStudy", request.getParameter("fieldOfStudy"));
        model.addObject("semester", request.getParameter("semester"));
        model.setViewName("student_ranking");
        return model;
    }

    @RequestMapping(value = "/studentCourseList/{id}", method = RequestMethod.GET)
    public ModelAndView studentCourseList(@PathVariable int id) {
        ModelAndView model = new ModelAndView();
        System.out.println(id + " sid");
        Student student = studentService.getStudentById(id);
        model.addObject("student", student);
        List<Registration> registrations = registrationService.getStudentsRegistrationList(id);
        System.out.println(registrations);
        model.addObject("registrationList", registrations);
        model.setViewName("student_course_list");
        return model;
    }

    @RequestMapping(value = "/populate", method = RequestMethod.GET)
    public ModelAndView populate() {
        Random rand = new Random();
        List<String> MNAMES = Arrays.asList("Piotr", "Krzysztof", "Andrzej", "Tomasz", "Jan", "Paweł", "Michał", "Marcin", "Stanisław", "Jakub", "Adam", "Marek", "Łukasz", "Grzegorz", "Mateusz", "Wojciech", "Mariusz", "Dariusz", "Zbigniew", "Jerzy", "Maciej", "Rafał", "Robert", "Kamil", "Józef", "Jacek", "Dawid", "Tadeusz", "Ryszard", "Szymon", "Kacper", "Bartosz");
        List<String> FNAMES = Arrays.asList("Anna", "Maria", "Katarzyna", "Małgorzata", "Agnieszka", "Barbara", "Ewa", "Krystyna", "Elżbieta", "Magdalena", "Joanna", "Zofia", "Aleksandra", "Monika", "Teresa", "Danuta", "Natalia", "Karolina", "Marta", "Julia", "Beata", "Dorota", "Janina", "Jadwiga", "Halina", "Jolanta", "Alicja", "Irena", "Grażyna", "Iwona", "Paulina", "Justyna");
        List<String> FLNAMES = Arrays.asList("Nowak", "Kowalska", "Wiśniewska", "Wójcik", "Kowalczyk", "Kamińska", "Lewandowska", "Zielińska", "Szymańska", "Dąbrowska", "Woźniak", "Kozłowska", "Jankowska", "Mazur", "Kwiatkowska", "Wojciechowska", "Krawczyk", "Kaczmarek", "Piotrowska", "Grabowska", "Pawłowska", "Michalska", "Zając", "Król", "Wieczorek", "Jabłońska", "Wróbel", "Nowakowska", "Majewska", "Olszewska", "Adamczyk", "Jaworska");
        List<String> MLNAMES = Arrays.asList("Nowak", "Kowalski", "Wiśniewski", "Wójcik", "Kowalczyk", "Kamiński", "Lewandowski", "Zieliński", "Woźniak", "Szymański", "Dąbrowski", "Kozłowski", "Mazur", "Jankowski", "Kwiatkowski", "Wojciechowski", "Krawczyk", "Kaczmarek", "Piotrowski", "Grabowski", "Zając", "Pawłowski", "Król", "Michalski", "Wróbel", "Wieczorek", "Jabłoński", "Nowakowski", "Majewski", "Olszewski", "Dudek", "Stępień");

        List<String> DGROUPS = Arrays.asList("1", "2", "3");
        List<String> SFIELDS = Arrays.asList("Informatyka", "Elektrotechnika");
        List<String> SEM = Arrays.asList("1", "2", "3");
        for (int i = 0; i < 100; i++) {
            Student stud = new Student();
            if (rand.nextInt(2) == 0) {
                stud.setFirstname(FNAMES.get(rand.nextInt(32)));
                stud.setLastname(FLNAMES.get(rand.nextInt(32)));
            } else {
                stud.setFirstname(MNAMES.get(rand.nextInt(32)));
                stud.setLastname(MLNAMES.get(rand.nextInt(32)));
            }
            stud.setDgroup(DGROUPS.get(rand.nextInt(3)));
            stud.setFieldofstudy(SFIELDS.get(rand.nextInt(2)));
            stud.setSemester(SEM.get(rand.nextInt(3)));
            studentService.addStudent(stud);
        }

        List<String> TITLES = Arrays.asList("prof.", "dr", "mgr inż.");
        List<String> UNITS = Arrays.asList("Instytut informatyki", "Instytut elektrotechniki", "Intsytut elektryki");
        for (int i = 0; i < 20; i++) {
            Teacher teacher = new Teacher();
            if (rand.nextInt(2) == 0) {
                teacher.setFirstname(FNAMES.get(rand.nextInt(32)));
                teacher.setLastname(FLNAMES.get(rand.nextInt(32)));
            } else {
                teacher.setFirstname(MNAMES.get(rand.nextInt(32)));
                teacher.setLastname(MLNAMES.get(rand.nextInt(32)));
            }
            teacher.setTitle(TITLES.get(rand.nextInt(3)));
            teacher.setUnit(UNITS.get(rand.nextInt(3)));
            teacherService.addTeacher(teacher);
        }

        List<String> COURSES = Arrays.asList("Analiza matematyczna", "Algebra liniowa", "Fizyka ogólna", "Języki i metody programowania", "Podstawy informatyki", "Systemy operacyjne");
        List<String> CODES = Arrays.asList("1D|1101", "1D|1102", "1D|1201", "1D|1202", "1D|1301", "1D|1302");
        List<Integer> ECTS = Arrays.asList(4, 5, 6, 4, 5, 6);
        List<String> CSEMESTER = Arrays.asList("1", "1", "2", "2", "3", "3");
        List<String> DTYP = Arrays.asList("ćwiczenia", "ćwiczenia", "laboratorium", "projekt", "laboratorium", "projekt");
        List<String> PLACE = Arrays.asList("S201", "S101", "S102", "S103", "S105", "S203", "S204");
        List<String> STARTTIME = Arrays.asList("8:00", "10:00", "12:00", "14:00", "16:00");
        List<String> ENDTIME = Arrays.asList("10:00", "12:00", "14:00", "16:00", "18:00");
        List<Teacher> TEACHERS = teacherService.getAllTeachers();
        for (int i = 0; i < 6; i++) {
            Course course = new Course();
            course.setCode(CODES.get(i));
            course.setEcts(ECTS.get(i));
            course.setFieldofstudy("Informatyka");
            course.setName(COURSES.get(i));
            course.setSemester(CSEMESTER.get(i));
            course.setPersonincharge(TEACHERS.get(i));
            courseService.addCourse(course);

            CoursePart cp = new CoursePart();
            cp.setCourse(course);
            cp.setPlace(PLACE.get(rand.nextInt(7)));
            int r = rand.nextInt(5);
            cp.setStartTime(STARTTIME.get(r));
            cp.setEndTime(ENDTIME.get(r));
            cp.setTeacher(TEACHERS.get(rand.nextInt(15)));
            cp.setType("wykład");
            coursePartService.addCoursePart(cp);

            CoursePart cp2 = new CoursePart();
            cp2.setCourse(course);
            cp2.setPlace(PLACE.get(rand.nextInt(7)));
            r = rand.nextInt(5);
            cp2.setStartTime(STARTTIME.get(r));
            cp2.setEndTime(ENDTIME.get(r));
            cp2.setTeacher(TEACHERS.get(rand.nextInt(15)));
            cp2.setType(DTYP.get(i));
            coursePartService.addCoursePart(cp2);
        }
        return new ModelAndView("redirect:/student/list");
    }
}
