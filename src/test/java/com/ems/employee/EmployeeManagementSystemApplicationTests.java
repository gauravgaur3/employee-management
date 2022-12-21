package com.ems.employee;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ems.employee.entity.Employee;
import com.ems.employee.repository.EmployeeRepository;
import com.ems.employee.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
class EmployeeManagementSystemApplicationTests {
	
	@Mock
	private EmployeeRepository repository;
	
	@InjectMocks
	private EmployeeService service;
	
	@Test
	public void getAllEmployeesTest(){
		when(repository.findAll()).thenReturn(Stream.of(new Employee(983l, "James", "Smith", 34, 350),new Employee(984l, "james", "Johnson", 36, 370)).collect(Collectors.toList()));
		assertEquals(2, service.getAllEmployees().size());
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
		service.removeEmployee(empId);
		verify(repository,times(1)).deleteById(empId);
	}
	
	@Test
	public void updateEmployeesTest(){
		Employee employee = new Employee(999l, "Gaurav", "Gaur", 32, 360);
		when(repository.save(employee)).thenReturn(employee);		
		Employee employee2 = new Employee(999l, "Ram", "Kumar", 32, 360);
		assertEquals(employee, service.updateEmployee(employee2));
	}
	
	@Test
	public void sortEmployeesByAgeTest() {
		List<Employee> actualList=new ArrayList<>(Stream.of(new Employee(983l, "James", "Smith", 36, 350),new Employee(984l, "james", "Johnson", 34, 370)).collect(Collectors.toList()));
		when(repository.findAllByOrderByAgeAsc()).thenReturn(Stream.of(new Employee(983l, "James", "Smith", 34, 350),new Employee(984l, "james", "Johnson", 36, 370)).collect(Collectors.toList()));
		List<Employee> expectedEmployees = service.sortEmployeesByAge();
		assertEquals(actualList.get(1).getAge(),expectedEmployees.get(0).getAge());
		
	}
	@Test
	public void sortEmployeesByNameTest() {
		List<Employee> actualList=new ArrayList<>(Stream.of(new Employee(983l, "Rahul", "kumar", 36, 350),new Employee(984l, "Gaurav", "Gaur", 34, 370)).collect(Collectors.toList()));
		when(repository.findAllByOrderByFirstNameAsc()).thenReturn(Stream.of(new Employee(983l, "Gaurav", "Gaur", 34, 350),new Employee(984l, "Rahul", "kumar", 36, 370)).collect(Collectors.toList()));
		List<Employee> expectedEmployees = service.sortEmployeesByName();
		assertEquals(actualList.get(1).getFirstName(),expectedEmployees.get(0).getFirstName());
		
	}

}