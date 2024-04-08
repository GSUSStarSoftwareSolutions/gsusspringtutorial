package com.luv2code.springDataJpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luv2code.springDataJpa.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
