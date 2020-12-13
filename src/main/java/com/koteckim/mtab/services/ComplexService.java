package com.koteckim.mtab.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
@Transactional
public class ComplexService {

    @PersistenceContext
    EntityManager entityManager;

    public List<Object[]> getStudentsRanking(String fieldOfStudy, String semester) {
        Query q = entityManager.createNativeQuery("SELECT s.id, s.firstname, s.lastname, SUM(CAST(r.grade AS FLOAT) * c.ects) / SUM(c.ects) AS sr FROM student s JOIN registration r ON (s.id = r.student_id) JOIN course c on (r.course_id = c.id) WHERE c.semester='" + semester + "' and s.fieldofstudy='" + fieldOfStudy + "' group by s.id order by sr desc");
        List<Object[]> rres = q.getResultList();
        return rres;
    }

}

