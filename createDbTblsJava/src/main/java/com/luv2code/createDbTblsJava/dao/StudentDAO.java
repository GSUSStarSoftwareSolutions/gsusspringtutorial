package com.luv2code.createDbTblsJava.dao;

import java.util.List;

import com.luv2code.createDbTblsJava.entity.Student;


public interface StudentDAO {
	void save(Student theStudent);
	Student findById(Integer id);
	List<Student> findAll();
	List<Student>findByLastName(String theLastName);
	void update(Student thesStudent);
	void delete(Integer id);
	int deleteAll();

}
