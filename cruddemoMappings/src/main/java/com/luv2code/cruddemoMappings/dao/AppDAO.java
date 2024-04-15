package com.luv2code.cruddemoMappings.dao;

import com.luv2code.cruddemoMappings.entity.Instructor;

public interface AppDAO {
	
	void save(Instructor theInstructor);
	
	Instructor findInstructorById(int theId);
	
	void deleteInstructorById(int theId);


}
