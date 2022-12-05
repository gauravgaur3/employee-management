package com.ems.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.ems.employee.entity.Employee;
import com.ems.employee.repository.EmployeeRepositoryImpl;
import com.ems.employee.service.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
class EmployeeManagementSystemApplicationTests {
	
	@Mock
	private EmployeeRepositoryImpl repository;
	
	@InjectMocks
	private EmployeeServiceImpl service;
	
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
	
	@Test
	public void updateEmployeesTest(){
		Employee employee = new Employee(999l, "Saurav", "Kumar", 32, 360);
		when(repository.save(employee)).thenReturn(employee);
		Employee employee2 = new Employee(999l, "Gaurav", "Gaur", 32, 360);
		when(repository.save(employee2)).thenReturn(employee2);
		assertEquals(employee2, service.updateEmployee(employee2));
	}

}