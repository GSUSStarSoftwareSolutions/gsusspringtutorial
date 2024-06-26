package com.luv2code.saveJavaObject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.saveJavaObject.dao.StudentDAO;
import com.luv2code.saveJavaObject.entity.Student;

@SpringBootApplication
public class SaveJavaObjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaveJavaObjectApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
        createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		
		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Dhoni", "Thala", "dskr93@gmail.com");
		
		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);
		
		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
		
	}

}
