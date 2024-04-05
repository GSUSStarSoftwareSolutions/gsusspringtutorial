package com.luv2code.readJavaObject.dao;

import com.luv2code.readJavaObject.entity.Student;

public interface StudentDAO {
	void save(Student theStudent);
	Student findById(Integer id);


}
