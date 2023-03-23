package com.spring.controller;

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

import com.spring.entity.Department;
import com.spring.exceptions.DepartmentException;
import com.spring.service.DepartmentService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@PostMapping("/createDepartment")
	public Department createDepartment(@Valid @RequestBody Department department,HttpServletRequest request) throws DepartmentException {
		logger.info("creating a department");
		return departmentService.createDepartment(department,request);
	}

	@PostMapping("/create/batchDepartments")
	public List<Department> createBatchDepartments(@Valid @RequestBody List<Department> departments,HttpServletRequest request)
			throws DepartmentException {
		logger.info("creating multiple departments");
		return departmentService.createBatchDepartments(departments,request);
	}

	@PutMapping("/updateDepartment/{id}")
	public Department updateDepartment(@PathVariable("id") String deptId, @Valid @RequestBody Department department,
			HttpServletRequest request) throws DepartmentException {
		logger.info("updating the department by id");
		return departmentService.updateDepartment(deptId, department, request);
	}

	@GetMapping("/getDepartment/{id}")
	public Department getDepartment(@PathVariable("id") String deptId,HttpServletRequest request) throws DepartmentException {
		logger.info("fetching the department by id");
		return departmentService.getDepartment(deptId,request);
	}

	@GetMapping("/getAllDepartments")
	public List<Department> getAllDepartments(HttpServletRequest request) throws DepartmentException {
		logger.info("fetching all the departments");
		return departmentService.getAllDepartments(request);
	}

	@DeleteMapping("/deleteDepartment/{id}")
	public String deleteDepartment(@PathVariable("id") String deptId,HttpServletRequest request) throws DepartmentException {
		logger.info("deleting the department by id");
		departmentService.deleteDepartment(deptId,request);
		return "Department deleted successfully";
	}
}
