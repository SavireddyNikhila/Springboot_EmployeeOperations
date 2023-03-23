package com.spring.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.spring.MyLocaleResolver;
import com.spring.entity.Department;
import com.spring.repository.DepartmentRepository;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class ValidateDepartment {

	@Autowired
	private DepartmentRepository departmentRepo;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private MyLocaleResolver myLocaleResolver;

	public String validate(Department department,HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		List<Department> depts = departmentRepo.findAll();

		// validating dept id
		if (Objects.nonNull(department.getDeptId()) && !"".equalsIgnoreCase(department.getDeptId())) {
			if (department.getDeptId().length() <= 36) {
				for (int i = 0; i < depts.size(); i++) {
					if (depts.get(i).getDeptId().equals(department.getDeptId()))
						sb.append(messageSource.getMessage("dept3",null,myLocaleResolver.resolveLocale(request))+", " );
				}
			} else
				sb.append(messageSource.getMessage("dept4",null,myLocaleResolver.resolveLocale(request))+", ");
		} else
			sb.append(messageSource.getMessage("dept5",null,myLocaleResolver.resolveLocale(request))+", ");

		// validating dept name
		if (Objects.nonNull(department.getDeptName()) && !"".equalsIgnoreCase(department.getDeptName())) {
			if (department.getDeptName().length() <= 50) {
				for (int i = 0; i < depts.size(); i++) {
					if (depts.get(i).getDeptName().equals(department.getDeptName()))
						sb.append(messageSource.getMessage("dept6",null,myLocaleResolver.resolveLocale(request))+", ");
				}
			} else
				sb.append(messageSource.getMessage("dept7",null,myLocaleResolver.resolveLocale(request))+", ");
		} else
			sb.append(messageSource.getMessage("dept8",null,myLocaleResolver.resolveLocale(request))+", ");

		// validating dept code
		if (Objects.nonNull(department.getDeptCode()) && !"".equalsIgnoreCase(department.getDeptCode())) {
			if (department.getDeptCode().length() <= 30) {
				for (int i = 0; i < depts.size(); i++) {
					if (depts.get(i).getDeptCode().equals(department.getDeptCode()))
						sb.append(messageSource.getMessage("dept9",null,myLocaleResolver.resolveLocale(request))+", ");
				}
			} else
				sb.append(messageSource.getMessage("dept10",null,myLocaleResolver.resolveLocale(request))+", ");
		} else
			sb.append(messageSource.getMessage("dept11",null,myLocaleResolver.resolveLocale(request))+", ");

		return sb.toString();
	}

	public String ValidUpdate(Department department,HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		List<Department> depts = departmentRepo.findAll();

		// validating dept name
		if (Objects.nonNull(department.getDeptName()) && !"".equalsIgnoreCase(department.getDeptName())) {
			if (department.getDeptName().length() <= 50) {
				for (int i = 0; i < depts.size(); i++) {
					if (depts.get(i).getDeptName().equals(department.getDeptName()))
						sb.append(messageSource.getMessage("dept6",null,myLocaleResolver.resolveLocale(request))+", ");
				}
			} else
				sb.append(messageSource.getMessage("dept7",null,myLocaleResolver.resolveLocale(request))+", ");
		}

		// validating dept code
		if (Objects.nonNull(department.getDeptCode()) && !"".equalsIgnoreCase(department.getDeptCode())) {
			if (department.getDeptCode().length() <= 30) {
				for (int i = 0; i < depts.size(); i++) {
					if (depts.get(i).getDeptCode().equals(department.getDeptCode()))
						sb.append(messageSource.getMessage("dept9",null,myLocaleResolver.resolveLocale(request))+", ");
				}
			} else
				sb.append(messageSource.getMessage("dept10",null,myLocaleResolver.resolveLocale(request))+", ");
		}

		return sb.toString();
	}
}
