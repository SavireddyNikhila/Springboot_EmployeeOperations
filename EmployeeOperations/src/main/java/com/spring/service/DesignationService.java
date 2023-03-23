package com.spring.service;

import java.util.List;

import com.spring.entity.Designation;
import com.spring.exceptions.DepartmentException;
import com.spring.exceptions.DesignationException;

import jakarta.servlet.http.HttpServletRequest;

public interface DesignationService {

	Designation createDesignation(Designation designation,HttpServletRequest request) throws DesignationException;

	List<Designation> createBatchDesignations(List<Designation> designations,HttpServletRequest request) throws DesignationException;

	Designation updateDesignation(String desgId, Designation designation,HttpServletRequest request) throws DesignationException;

	Designation getDesignation(String desgId,HttpServletRequest request) throws DesignationException;

	List<Designation> getAllDesignations(HttpServletRequest request) throws DesignationException;

	void deleteDesignation(String desgId,HttpServletRequest request) throws DesignationException;

}
