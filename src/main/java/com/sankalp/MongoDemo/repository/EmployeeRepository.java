package com.sankalp.MongoDemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sankalp.MongoDemo.dto.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String>{
	
}
