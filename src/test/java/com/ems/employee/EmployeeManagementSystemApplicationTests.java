package com.ems.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.longThat;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ems.employee.entity.Employee;
import com.ems.employee.repository.EmployeeRepositoryImpl;
import com.ems.employee.service.EmployeeService;

@SpringBootTest
class EmployeeManagementSystemApplicationTests {
	
	@Autowired
	private EmployeeService service;
	
	@MockBean
	private EmployeeRepositoryImpl repository;
	
	@Test
	public void getAllEmployeesTest(){
		when(repository.findAll()).thenReturn(Stream.of(new Employee(982l, "Vijay", "Kumar", 32, 360),new Employee(983l, "James", "Smith", 34, 350),new Employee(984l, "james", "Johnson", 36, 370)).collect(Collectors.toList()));
		assertEquals(3, service.getAllEmployees().size());
	}
	
	@Test
	public void addEmployeesTest(){
		Employee employee = new Employee(999l, "Gaurav", "Gaur", 32, 360);
		when(repository.save(employee)).thenReturn(employee);
		assertEquals(employee, service.addEmployee(employee));
	}
	
	@Test
	public void removeEmployeesTest(){
		long empId = 999l;
		Employee employee = new Employee(999l, "Gaurav", "Gaur", 32, 360);
		when(repository.deleteById(empId)).thenReturn(employee);
		assertEquals(employee, service.removeEmployee(empId));
	}

}
