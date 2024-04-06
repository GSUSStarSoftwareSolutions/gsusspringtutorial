package com.luv2code.readJavaObject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.readJavaObject.dao.StudentDAO;
import com.luv2code.readJavaObject.entity.Student;


@SpringBootApplication
public class ReadJavaObjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadJavaObjectApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
       // createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Muhammed","Ali", "clasius@gmail.com");
		
		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);
		
		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);
		
		//retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);
		
		//display student
		System.out.println("Found the student: " + myStudent);
		
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students
				System.out.println("Creating 3 student objects ...");
				Student tempStudent1 = new Student("Virat", "Kohli", "kingkohli@gmail.com");
				Student tempStudent2 = new Student("John", "Cena", "ucantseeme@gmail.com");
				Student tempStudent3 = new Student("Mike", "Tyson", "animal@gmail.com");

				// save the student objects
				System.out.println("Saving the students ...");
				studentDAO.save(tempStudent1);	
				studentDAO.save(tempStudent2);		
				studentDAO.save(tempStudent3);		

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