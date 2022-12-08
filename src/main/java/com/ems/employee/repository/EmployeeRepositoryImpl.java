//package com.ems.employee.repository;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import org.springframework.stereotype.Repository;
//
//import com.ems.employee.entity.Employee;
//
//
//public class EmployeeRepositoryImpl {
//
//	// List of employee object need to be created here
//	public static List<Employee> employees = new ArrayList<>(Arrays.asList(new Employee(982l, "Vijay", "Kumar", 32, 360),new Employee(983l, "James", "Smith", 34, 350),new Employee(984l, "james", "Johnson", 36, 370)));
//	
//	// Get all employees
//	@Override
//	public List<Employee> findAll() {
//		return employees;
//	}
//	
//	// Delete Employees
//	@Override
//	public Employee deleteById(long empId) {
//		Employee employee = findById(empId);
//		if (employee != null) {
//			employees.remove(employee);
//		}
//		return employee;	
//	}
//	
//	// find employee
//	public Employee findById(long empId) {
//		return employees.stream().filter(employee -> employee.getEmpId().equals(empId)).findFirst().orElse(null);
//	}
//	
//	// Save employee and update employee
//	@Override
//	public Employee save(Employee employee) {
//		Employee findById = findById(employee.getEmpId());
//		if (findById == null) {
//			employees.add(employee);
//		} else {
//			deleteById(employee.getEmpId());
//			employees.add(employee);
//		}
//		return employee;
//	}
//}
