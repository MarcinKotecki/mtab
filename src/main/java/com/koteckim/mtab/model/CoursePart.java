package com.koteckim.mtab.model;

import javax.persistence.*;

@Entity
@Table(name = "course_part")
public class CoursePart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name="course_code")
    private Course course;

    @Column(name="type")
    private String type;

    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    @Column(name="start_time")
    private String startTime;

    @Column(name="end_time")
    private String endTime;

    @Column(name="place")
    private String place;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
