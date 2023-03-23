package com.spring.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.spring.MyLocaleResolver;
import com.spring.entity.Department;
import com.spring.entity.Employee;
import com.spring.exceptions.DepartmentException;
import com.spring.exceptions.EmployeeException;
import com.spring.repository.DepartmentRepository;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private ValidateDepartment validateDepartment;
	@Autowired
	private DepartmentRepository departmentRepo;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private MyLocaleResolver myLocaleResolver;

	@Override
	public Department createDepartment(Department department,HttpServletRequest request) throws DepartmentException {
		String str = validateDepartment.validate(department,request);
		if (!"".equalsIgnoreCase(str))
			throw new DepartmentException(str);

		department.setDeptCreatedDate(LocalDate.now());
		department.setDeptUpdatedDate(LocalDate.now());
		return departmentRepo.save(department);
	}

	@Override
	public List<Department> createBatchDepartments(List<Department> departments,HttpServletRequest request) throws DepartmentException {
		for (int i = 0; i < departments.size(); i++) {
			String str = validateDepartment.validate(departments.get(i),request);

			if (!"".equalsIgnoreCase(str)) {
				throw new DepartmentException(
						messageSource.getMessage("dept12",null,myLocaleResolver.resolveLocale(request)) + departments.get(i).getDeptId()+" " + messageSource.getMessage("dept13",null,myLocaleResolver.resolveLocale(request)) + str);
			}

			departments.get(i).setDeptCreatedDate(LocalDate.now());
			departments.get(i).setDeptUpdatedDate(LocalDate.now());
		}
		return departmentRepo.saveAll(departments);
	}

	@Override
	public Department updateDepartment(String deptId, Department department,HttpServletRequest request) throws DepartmentException {
		Optional<Department> dept = departmentRepo.findById(deptId);
		if (!dept.isPresent()) {
			throw new DepartmentException(messageSource.getMessage("dept1",null,myLocaleResolver.resolveLocale(request)) + deptId);
		} else {
			Department deptDB = departmentRepo.findById(deptId).get();
			String str = validateDepartment.ValidUpdate(department,request);
			if (!"".equalsIgnoreCase(str)) {
				throw new DepartmentException(str);
			} else {
				if (Objects.nonNull(department.getDeptName()) && !"".equalsIgnoreCase(department.getDeptName()))
					deptDB.setDeptName(department.getDeptName());
				if (Objects.nonNull(department.getDeptCode()) && !"".equalsIgnoreCase(department.getDeptCode()))
					deptDB.setDeptCode(department.getDeptCode());
				if (Objects.nonNull(department.getDeptCreatedDate()))
					deptDB.setDeptCreatedDate(department.getDeptCreatedDate());
				/*
				 * if (Objects.nonNull(department.getDeptUpdatedDate()))
				 * deptDB.setDeptUpdatedDate(department.getDeptUpdatedDate());
				 */
			}
			deptDB.setDeptUpdatedDate(LocalDate.now());
			return departmentRepo.save(deptDB);
		}
	}
	

	@Override
	public Department getDepartment(String deptId,HttpServletRequest request) throws DepartmentException {
		Optional<Department> dept = departmentRepo.findById(deptId);
		if (!dept.isPresent())
			throw new DepartmentException(messageSource.getMessage("dept1",null,myLocaleResolver.resolveLocale(request)) + deptId);
		return departmentRepo.findById(deptId).get();
		
	}

	@Override
	public List<Department> getAllDepartments(HttpServletRequest request) throws DepartmentException {
		List<Department> depts = departmentRepo.findAll();
		if (depts.size() == 0)
			throw new DepartmentException(messageSource.getMessage("dept2",null,myLocaleResolver.resolveLocale(request)));
		return depts;
	}

	@Override
	public void deleteDepartment(String deptId,HttpServletRequest request) throws DepartmentException {
		Optional<Department> dept = departmentRepo.findById(deptId);
		if (!dept.isPresent())
			throw new DepartmentException(messageSource.getMessage("dept1",null,myLocaleResolver.resolveLocale(request)) + deptId);
		departmentRepo.deleteById(deptId);

	}

}
