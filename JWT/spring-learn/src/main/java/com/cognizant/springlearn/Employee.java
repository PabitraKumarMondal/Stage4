package com.cognizant.springlearn;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

public class Employee {
	@NotNull
	@NumberFormat
	private int id;
	
	@NotNull
	@Size(min = 1, max = 30, message = "Maximum 30 characters are allowed")
	private String name;
	
	@NotNull
	@PositiveOrZero(message = "salary cannot be negative")
	private double salary;
	
	private Department department;
	
	public Employee() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department + "]";
	}
	
	
}
