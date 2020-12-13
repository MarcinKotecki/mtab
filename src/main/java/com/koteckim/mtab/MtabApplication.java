package com.koteckim.mtab;

import com.koteckim.mtab.model.Student;
import com.koteckim.mtab.repository.StudentRepository;
import com.koteckim.mtab.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MtabApplication {


	public static void main(String[] args) {
		SpringApplication.run(MtabApplication.class, args);
	}

}