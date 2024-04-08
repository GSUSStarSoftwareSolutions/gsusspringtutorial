package com.luv2code.springboot.restCrudDemo.service;

import java.util.List;

import com.luv2code.springboot.restCrudDemo.entity.Employee;

public interface EmployeeService {
	List<Employee> findAll();
	Employee findById(int theId);
	Employee save(Employee theEmployee);
	void deleteById(int theId);

}
