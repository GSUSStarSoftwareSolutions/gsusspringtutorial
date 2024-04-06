package com.luv2code.springBootRestController.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springBootRestController.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	// define endpoint for "/students" - return a list of students
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		List<Student> theStudents = new ArrayList<>();
		theStudents.add(new Student("Vijay", "Kumar"));
		theStudents.add(new Student("Sachin", "Tendulkar"));
		theStudents.add(new Student("Virendar", "Sehwag"));
		
		return theStudents;

		
		
		
	}

}
