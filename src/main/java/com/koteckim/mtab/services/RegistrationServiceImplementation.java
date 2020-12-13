package com.koteckim.mtab.services;

import com.koteckim.mtab.model.Registration;
import com.koteckim.mtab.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RegistrationServiceImplementation implements RegistrationService {

    @Autowired
    RegistrationRepository registrationRepository;

    @Override
    public List<Registration> getAllRegistrations() {
        return (List<Registration>) registrationRepository.findAll();
    }

    @Override
    public Registration getRegistrationById(int id) {
        return registrationRepository.findById(id).get();
    }

    @Override
    public void addRegistration(Registration registration) {
        registrationRepository.save(registration);
    }

    @Override
    public void deleteRegistration(int id) {
        registrationRepository.deleteById(id);
    }

    public List<Registration> getStudentsRegistrationList(int studentId) {
        return registrationRepository.findByStudentId(studentId);
    }
}
