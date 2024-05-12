package com.sateeshbhat.studentsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class StudentsystemApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(StudentsystemApplication.class, args);
		
	}

}
