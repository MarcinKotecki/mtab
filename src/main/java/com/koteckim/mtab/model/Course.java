package com.koteckim.mtab.model;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="code")
    private String code;

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher personincharge;

    @Column(name="ects")
    private int ects;

    @Column(name="fieldofstudy")
    private String fieldofstudy;

    @Column(name="semester")
    private String semester;

    public String getCodeWithName(){
        return code + " " + name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFieldofstudy() {
        return fieldofstudy;
    }

    public void setFieldofstudy(String fieldofstudy) {
        this.fieldofstudy = fieldofstudy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public Teacher getPersonincharge() {
        return personincharge;
    }

    public void setPersonincharge(Teacher personincharge) {
        this.personincharge = personincharge;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
