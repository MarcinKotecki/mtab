package com.koteckim.mtab.services;

import com.koteckim.mtab.model.Registration;

import java.util.List;

public interface RegistrationService {

    public List<Registration> getAllRegistrations();
    public Registration getRegistrationById(int id);
    public void addRegistration(Registration registration);
    public void deleteRegistration(int id);
    public List<Registration> getStudentsRegistrationList(int studentId);

}
