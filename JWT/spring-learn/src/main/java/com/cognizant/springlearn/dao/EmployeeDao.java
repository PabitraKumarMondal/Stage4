package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Repository
public class EmployeeDao {
	private static ArrayList<Employee> EMPLOYEE_LIST;

	public EmployeeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList");
	}
	public List<Employee> getAllEmployees() {
		return EMPLOYEE_LIST;
	}
	public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
		boolean flag = true;
		for (Employee emp : EMPLOYEE_LIST) {
			if(emp.getId() == employee.getId()) {
				emp.setName(employee.getName());
				emp.setSalary(employee.getSalary());
				emp.setDepartment(employee.getDepartment());
				flag = false;
				break;
			}
		}
		if(flag) {
			throw new EmployeeNotFoundException();
		}
	}
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
		for (Employee emp : EMPLOYEE_LIST) {
			if(emp.getId() == id) {
				return emp;
			}
		}
		throw new EmployeeNotFoundException();
	}
	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		boolean flag = true;
		for (Employee emp : EMPLOYEE_LIST) {
			if(emp.getId() == id) {
				EMPLOYEE_LIST.remove(emp);
				flag = false;
				break;
			}
		}
		if(flag) {
			throw new EmployeeNotFoundException();
		}
	}
}
