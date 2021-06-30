package com.sankalp.MongoDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sankalp.MongoDemo.dto.Employee;
import com.sankalp.MongoDemo.service.EmployeeService;

@RequestMapping("/employees")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeServices;
	
	@GetMapping
	public List<Employee> findEmployees(){
		return employeeServices.findEmployee();
	}
	
	@GetMapping("{salary}")
	public List<Employee> findEmployeeBySalary(@PathVariable double salary){
		return employeeServices.findEmployeesBySalaryGreaterThan(salary);
	}
	
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeServices.createEmployee(employee);
	}
	
	@DeleteMapping
	public boolean deleteEmployee(@PathVariable String eId) {
		return employeeServices.deleteEmployee(eId);
	}
	
	@PutMapping
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeServices.updateEmployee(employee);
	}
}
