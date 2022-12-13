package com.ems.employee;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ems.employee.controller.EmployeeController;
import com.ems.employee.entity.Employee;
import com.ems.employee.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class  ControllerTest{
	
	@InjectMocks
    EmployeeController employeeController;

    @Mock
    EmployeeService employeeService;
   
	   @Test
	   public void getAllEmployeesControllerTest() {
		   List<Employee> employees = new ArrayList<>(Arrays.asList(new Employee(911l, "Ajay", "Kumar", 32, 360),new Employee(912l, "Neeraj", "Smith", 34, 350)));
	
	       when(employeeService.getAllEmployees()).thenReturn(employees);
	
	       List<Employee> result = employeeController.getAllEmployees();
	
	       assertThat(result.size()).isEqualTo(2);
	       assertThat(result.get(0).getFirstName()).isEqualTo(employees.get(0).getFirstName());
	       assertThat(result.get(1).getFirstName()).isEqualTo(employees.get(1).getFirstName());
	   }

	@Test
	   public void addEmployeeTest()
	   {
	       MockHttpServletRequest request = new MockHttpServletRequest();
	       RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	
	       when(employeeService.addEmployee(any(Employee.class))).thenReturn(new Employee(911l, "Gaurav", "Gaur", 32, 360));
	       ResponseEntity<Void> responseEntity = employeeController.addEmployee(new Employee(911l, "Gaurav", "Gaur", 32, 360));
	       assertThat(responseEntity.getStatusCode().value()).isEqualTo(201);
	       assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/911");
	   }
	
	@Test
	public void updateEmployeeTest()
	{
		 MockHttpServletRequest request = new MockHttpServletRequest();
	       RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	       when(employeeService.updateEmployee(any(Employee.class))).thenReturn(new Employee(911l, "Saurav", "Kumar", 32, 360));
	       ResponseEntity<Void> responseEntity = employeeController.updateEmployee(new Employee(911l, "Saurav", "Kumar", 32, 360));
	       assertThat(responseEntity.getStatusCode().value()).isEqualTo(200);
	}
	
	@Test
	public void deleteEmployeeTest()
	{
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		long empId = 999l;
		employeeService.removeEmployee(empId);
		verify(employeeService,times(1)).removeEmployee(empId);
		ResponseEntity<Void> responseEntity = employeeController.deleteEmployee(empId);
		assertThat(responseEntity.getStatusCode().value()).isEqualTo(204);
	}
    
}
