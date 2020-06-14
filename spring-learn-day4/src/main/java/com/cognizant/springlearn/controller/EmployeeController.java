package com.cognizant.springlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.service.EmployeeService;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@RestController
public class EmployeeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	@ResponseBody
	public List<Employee> getAllEmployees() {		
		LOGGER.info("START");
		return employeeService.getAllEmployees();
	}
	
	@PutMapping("/employees")
	public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {
		LOGGER.info("START");
		employeeService.updateEmployee(employee);
	}
	
	@GetMapping("/employees/{id}")
	@ResponseBody
	public Employee getEmployeeById(@PathVariable int id) throws EmployeeNotFoundException {		
		LOGGER.info("START");
		return employeeService.getEmployeeById(id);
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException {
		LOGGER.info("START");
		employeeService.deleteEmployee(id);
	}
	
}
