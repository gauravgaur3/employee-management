package com.ems.employee.repository;

import java.util.List;

import com.ems.employee.entity.Employee;

public interface EmployeeRepository {
	
	List<Employee> findAll();

	Employee deleteById(long empId);

	Employee save(Employee employee);
	
}
