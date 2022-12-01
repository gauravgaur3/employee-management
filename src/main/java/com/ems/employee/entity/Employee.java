package com.ems.employee.entity;

import java.util.Objects;

public class Employee {

	private Long empId;
	private String firstName;
	private String LastName;
	private int age;
	private double salary;
	
		
	public Employee(Long empId, String firstName, String lastName, int age, double salary) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		LastName = lastName;
		this.age = age;
		this.salary = salary;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(empId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(empId, other.empId);
	}


	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", LastName=" + LastName + ", age=" + age
				+ ", salary=" + salary + "]";
	}
	
}
