package com.spring.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Employee;
import com.spring.exceptions.EmployeeException;
import com.spring.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	private final Logger logger=LoggerFactory.getLogger(EmployeeController.class);

	@PostMapping("/createEmployee")
	public Employee createEmployee(@Valid @RequestBody Employee employee,HttpServletRequest request) throws EmployeeException {
		logger.info("creating an employee");
		return employeeService.createEmployee(employee,request);
	}
	
	@PostMapping("/create/BatchEmployees")
	public List<Employee> createbatchEmployees(@Valid @RequestBody List<Employee> employees,HttpServletRequest request) throws EmployeeException{
		logger.info("creating multiple employees");
		return employeeService.createBatchEmployees(employees,request);
	}
	
	@PutMapping("/updateEmployee/{id}")
	public Employee updateEmployee(@PathVariable("id") String employeeId, @Valid @RequestBody Employee employee,HttpServletRequest request) throws EmployeeException {
		logger.info("updating an employee");
		return employeeService.updateEmployee(employeeId,employee,request);	
	}
	
	@GetMapping("/getEmployeeById/{id}")
	public Employee fetchEmployeeById(@PathVariable("id") String employeeId,HttpServletRequest request) throws EmployeeException {
		logger.info("fetching an employee by id");
		return employeeService.fetchEmployeeById(employeeId,request);
	}
	
	@GetMapping("/getEmployeeByEmail/{email}")
	public Employee fetchEmployeeByEmail(@PathVariable("email") String emailId,HttpServletRequest request) throws EmployeeException {
		logger.info("fetching an employee by email");
		return employeeService.fetchEmployeeByEmailId(emailId,request);
	}
	
	@GetMapping("/getEmployeeByPhone/{phone}")
	public Employee fetchEmployeeByPhoneNumber(@PathVariable("phone") String phoneNumber,HttpServletRequest request) throws EmployeeException {
		logger.info("fetching an employee by phone");
		return employeeService.fetchEmployeeByPhoneNumber(phoneNumber,request);
	}
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(HttpServletRequest request) throws EmployeeException{
		logger.info("fetching all the employees");
		return employeeService.getAllEmployees(request);
	}
	
	@GetMapping("/getemployeesBetweenCreateDates/{date1}/{date2}")
	public List<Employee> fetchEmployeeCreateDateBetween(@PathVariable("date1") LocalDate Date1,
			@PathVariable("date2") LocalDate Date2, HttpServletRequest request) throws EmployeeException{
		logger.info("fetching the employees between these created dates");
		return employeeService.getEmployeesCreateDateBetween(Date1, Date2,request);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") String employeeId, HttpServletRequest request) throws EmployeeException {
		logger.info("deleting an employee by id");
		employeeService.deleteEmployee(employeeId,request);
		return "deleted Successfully";
	}
}
