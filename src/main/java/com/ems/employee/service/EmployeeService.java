package com.ems.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.employee.entity.Employee;
import com.ems.employee.repository.EmployeeRepository;

@Service
public class EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	
	public void removeEmployee(long empId) {
		employeeRepository.deleteById(empId);
	}

	
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}	
}
