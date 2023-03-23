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

import com.spring.entity.Designation;
import com.spring.exceptions.DesignationException;
import com.spring.service.DesignationService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
public class DesignationController {

	@Autowired
	private DesignationService designationService;
	
	private final Logger logger=LoggerFactory.getLogger(DesignationController.class);
	
	@PostMapping("/createDesignation")
	public Designation createDesignation(@Valid @RequestBody Designation designation,HttpServletRequest request) throws DesignationException {
		logger.info("creating a designation");
		return designationService.createDesignation(designation,request);
	}
	
	@PostMapping("/create/batchDesignations")
	public List<Designation> createBatchDesignations(@Valid @RequestBody List<Designation> designations,HttpServletRequest request) throws DesignationException{
		logger.info("creating multiple designations");
		return designationService.createBatchDesignations(designations,request);
	}
	
	@PutMapping("/updateDesignation/{id}")
	public Designation updateDesignation(@PathVariable("id") String desgId,@Valid @RequestBody Designation designation,HttpServletRequest request) throws DesignationException {
		logger.info("updating the designation by id");
		return designationService.updateDesignation(desgId,designation,request);	
	}
	
	@GetMapping("/getDesignation/{id}")
	public Designation getDesignation(@PathVariable("id") String desgId,HttpServletRequest request) throws DesignationException {
		logger.info("fetching the designation by id");
		return designationService.getDesignation(desgId,request);
	}
	
	@GetMapping("/getAllDesignations")
	public List<Designation> getAllDesignations(HttpServletRequest request) throws DesignationException{
		logger.info("fetching all the designations");
		return designationService.getAllDesignations(request);
	}
	
	@DeleteMapping("/deleteDesignations/{id}")
	public String deleteDesignation(@PathVariable("id") String desgId,HttpServletRequest request) throws DesignationException {
		logger.info("deleting the designation by id");
		designationService.deleteDesignation(desgId,request);
		return "Designation deleted successfully";
	}
}
