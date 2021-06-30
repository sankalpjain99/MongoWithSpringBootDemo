package com.sankalp.MongoDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sankalp.MongoDemo.dto.Employee;
import com.sankalp.MongoDemo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> findEmployee(){
		return employeeRepository.findAll();
	}
	
	public List<Employee> findEmployeesBySalaryGreaterThan(double salary){
		return null;
	}
	
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public boolean deleteEmployee(String eId) {
		employeeRepository.deleteById(eId);
		return true;
	}
	
	public Employee findEmployeeById(String eId) {
		return employeeRepository.findById(eId).get();
	}
	
	public Employee updateEmployee(Employee employee) {
		Optional<Employee> employeeOptional = employeeRepository.findById(employee.getEmployeeId());
		if(employeeOptional.isPresent()) {
			Employee currentEmp = employeeOptional.get();
			currentEmp.setEmail(employee.getEmail());
			currentEmp.setFirstName(employee.getFirstName());
			currentEmp.setSalary(employee.getSalary());
			employeeRepository.save(currentEmp);
		}
		return employee;
	}
	
}
