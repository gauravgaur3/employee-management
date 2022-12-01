package com.ems.employee.service;

import java.util.List;

import com.ems.employee.entity.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	Employee removeEmployee(long empId);
	Employee updateEmployee(Employee employee);
	Employee addEmployee(Employee employee);
}	
