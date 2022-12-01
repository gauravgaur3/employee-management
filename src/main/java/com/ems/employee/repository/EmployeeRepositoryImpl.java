package com.ems.employee.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ems.employee.entity.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	// List of employee object need to be created here
	private static List<Employee> employees = new ArrayList<Employee>();

	static {
		employees.add(new Employee(982l, "Vijay", "Kumar", 32, 360));
		employees.add(new Employee(983l, "James", "Smith", 34, 350));
		employees.add(new Employee(984l, "james", "Johnson", 36, 370));
	}

	@Override
	public List<Employee> findAll() {
		return employees;
	}

	@Override
	public Employee deleteById(long empId) {
		Employee employee = findById(empId);
		if (employee == null) {
			return null;
		}
		if (employees.remove(employee)) {
			return employee;
		}
		return null;
	}

	public Employee findById(long empId) {
		for (Employee employee : employees) {
			if (employee.getEmpId() == empId) {
				return employee;
			}
		}
		return null;
	}

	@Override
	public Employee save(Employee employee) {
		if (findById(employee.getEmpId())==null) {
			employees.add(employee);
		}
		else {
			deleteById(employee.getEmpId());
			employees.add(employee);
		}
		return employee;
	}
}
