package com.koteckim.mtab.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="firstname")
    private String firstname;

    @Column(name="lastname")
    private String lastname;

    @Column(name="semester")
    private String semester;

    @Column(name="dgroup")
    private String dgroup;

    @Column(name="fieldofstudy")
    private String fieldofstudy;

    public String getNameWithId(){
        return id + " " + firstname + " " + lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getFieldofstudy() {
        return fieldofstudy;
    }

    public void setFieldofstudy(String fieldofstudy) {
        this.fieldofstudy = fieldofstudy;
    }

    public String getDgroup() {
        return dgroup;
    }

    public void setDgroup(String dgroup) {
        this.dgroup = dgroup;
    }
}
