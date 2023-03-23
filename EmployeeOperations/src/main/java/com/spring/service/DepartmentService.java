package com.spring.service;

import java.util.List;

import com.spring.entity.Department;
import com.spring.exceptions.DepartmentException;
import com.spring.exceptions.EmployeeException;

import jakarta.servlet.http.HttpServletRequest;

public interface DepartmentService {

	Department createDepartment(Department department,HttpServletRequest request) throws DepartmentException;

	List<Department> createBatchDepartments(List<Department> departments,HttpServletRequest request) throws DepartmentException;

	Department updateDepartment(String deptId, Department department,HttpServletRequest request) throws DepartmentException;

	Department getDepartment(String deptId,HttpServletRequest request) throws DepartmentException;

	List<Department> getAllDepartments(HttpServletRequest request) throws DepartmentException;

	void deleteDepartment(String deptId,HttpServletRequest request) throws DepartmentException;

}
