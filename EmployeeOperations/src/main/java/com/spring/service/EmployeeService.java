package com.spring.service;

import java.time.LocalDate;
import java.util.List;

import com.spring.entity.Employee;
import com.spring.exceptions.EmployeeException;

import jakarta.servlet.http.HttpServletRequest;

public interface EmployeeService {

	Employee createEmployee(Employee employee,HttpServletRequest request) throws EmployeeException;

	List<Employee> createBatchEmployees(List<Employee> employees,HttpServletRequest request) throws EmployeeException;

	Employee updateEmployee(String employeeId,Employee employee,HttpServletRequest request) throws EmployeeException;
	
	Employee fetchEmployeeById(String employeeId,HttpServletRequest request) throws EmployeeException;

	Employee fetchEmployeeByEmailId(String emailId,HttpServletRequest request) throws EmployeeException;

	Employee fetchEmployeeByPhoneNumber(String phoneNumber,HttpServletRequest request) throws EmployeeException;
	
	List<Employee> getAllEmployees(HttpServletRequest request) throws EmployeeException;

	void deleteEmployee(String employeeId,HttpServletRequest request) throws EmployeeException;

	List<Employee> getEmployeesCreateDateBetween(LocalDate date1, LocalDate date2,HttpServletRequest request) throws EmployeeException;

}
