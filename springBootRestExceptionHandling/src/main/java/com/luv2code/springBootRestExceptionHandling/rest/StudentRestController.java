package com.luv2code.springBootRestExceptionHandling.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.luv2code.springBootRestExceptionHandling.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
private List<Student> theStudents;
	
	// define @PostConstruct to load the student data ... only once!
	
	@PostConstruct
	public void loadData() {
      theStudents = new ArrayList<>();
      theStudents.add(new Student("Vijay", "Kumar"));
      theStudents.add(new Student("Sachin", "Tendulkar"));
      theStudents.add(new Student("Virendar", "Sehwag"));

	} 
	
	// define endpoint for "/students" - return a list of students
	
		@GetMapping("/students")
		public List<Student> getStudents() {
			return theStudents;
		}
		
		// define endpoint or "/students/{studentId}" - return student at index
		
		@GetMapping("/students/{studentId}")
		public Student getStudent(@PathVariable int studentId) {
			// just index into the list ... keep it simple for now
			
			// check the studentId again list size
			
			if((studentId >= theStudents.size()) || (studentId < 0)) {
				throw new StudentNotFoundException("Student id not found - " + studentId);
			}
			return theStudents.get(studentId);
			
		}
		
		// Add an exception handler using @ExceptionHandler
		
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
			
			// create a StudentErrorResponse
			
			StudentErrorResponse error = new StudentErrorResponse();
			
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			// return ResponseEntity
			
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		}
		
		// add another exception handler ... to catch any exception (catch all)
		
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleexception(Exception exc) {
			
			// create a StudentErrorResponse
			
						StudentErrorResponse error = new StudentErrorResponse();
						
						error.setStatus(HttpStatus.BAD_REQUEST.value());
						error.setMessage(exc.getMessage());
						error.setTimeStamp(System.currentTimeMillis());
						
						// return ResponseEntity
						
						return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}
		

}
