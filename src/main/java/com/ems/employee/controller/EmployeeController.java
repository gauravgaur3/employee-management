package com.ems.employee.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ems.employee.entity.Employee;
import com.ems.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@PostMapping("/employees")
	public ResponseEntity<Void> addEmployee(@RequestBody Employee employee){
		Employee addEmployee = employeeService.addEmployee(employee);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{empId}").buildAndExpand(addEmployee.getEmpId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	

	@PutMapping("/employees")
	public ResponseEntity<Employee> updateEmployee( @RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@DeleteMapping("/employees/{empId}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable long empId) {
		Employee employee = employeeService.removeEmployee(empId);
		if (employee != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}

