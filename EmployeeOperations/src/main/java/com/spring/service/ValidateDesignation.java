package com.spring.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.spring.MyLocaleResolver;
import com.spring.entity.Designation;
import com.spring.repository.DesignationRepository;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class ValidateDesignation {

	@Autowired
	private DesignationRepository designationRepo;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private MyLocaleResolver myLocaleResolver;

	public String validate(Designation designation,HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		List<Designation> desgs = designationRepo.findAll();

		// validating desg id
		if (Objects.nonNull(designation.getDesgId()) && !"".equalsIgnoreCase(designation.getDesgId())) {
			if (designation.getDesgId().length() <= 36) {
				for (int i = 0; i < desgs.size(); i++) {
					if (desgs.get(i).getDesgId().equals(designation.getDesgId()))
						sb.append(messageSource.getMessage("desg3",null,myLocaleResolver.resolveLocale(request))+", ");
				}
			} else
				sb.append(messageSource.getMessage("desg4",null,myLocaleResolver.resolveLocale(request))+", ");
		} else
			sb.append(messageSource.getMessage("desg5",null,myLocaleResolver.resolveLocale(request))+", ");

		// validating desg name
		if (Objects.nonNull(designation.getDesgName()) && !"".equalsIgnoreCase(designation.getDesgName())) {
			if (designation.getDesgName().length() <= 50) {
				for (int i = 0; i < desgs.size(); i++) {
					if (desgs.get(i).getDesgName().equals(designation.getDesgName()))
						sb.append(messageSource.getMessage("desg6",null,myLocaleResolver.resolveLocale(request))+", ");
				}
			} else
				sb.append(messageSource.getMessage("desg7",null,myLocaleResolver.resolveLocale(request))+", ");
		} else
			sb.append(messageSource.getMessage("desg8",null,myLocaleResolver.resolveLocale(request))+", ");

		// validating desg code
		if (Objects.nonNull(designation.getDesgCode()) && !"".equalsIgnoreCase(designation.getDesgCode())) {
			if (designation.getDesgCode().length() <= 30) {
				for (int i = 0; i < desgs.size(); i++) {
					if (desgs.get(i).getDesgCode().equals(designation.getDesgCode()))
						sb.append(messageSource.getMessage("desg9",null,myLocaleResolver.resolveLocale(request))+", ");
				}
			} else
				sb.append(messageSource.getMessage("desg10",null,myLocaleResolver.resolveLocale(request))+", ");
		} else
			sb.append(messageSource.getMessage("desg11",null,myLocaleResolver.resolveLocale(request))+", ");

		return sb.toString();
	}

	public String ValidUpdate(Designation designation, HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		List<Designation> desgs = designationRepo.findAll();

		// validating desg name
		if (Objects.nonNull(designation.getDesgName()) && !"".equalsIgnoreCase(designation.getDesgName())) {
			if (designation.getDesgName().length() <= 50) {
				for (int i = 0; i < desgs.size(); i++) {
					if (desgs.get(i).getDesgName().equals(designation.getDesgName()))
						sb.append(messageSource.getMessage("desg6",null,myLocaleResolver.resolveLocale(request))+", ");
				}
			} else
				sb.append(messageSource.getMessage("desg7",null,myLocaleResolver.resolveLocale(request))+", ");
		}

		// validating desg code
		if (Objects.nonNull(designation.getDesgCode()) && !"".equalsIgnoreCase(designation.getDesgCode())) {
			if (designation.getDesgCode().length() <= 30) {
				for (int i = 0; i < desgs.size(); i++) {
					if (desgs.get(i).getDesgCode().equals(designation.getDesgCode()))
						sb.append(messageSource.getMessage("desg9",null,myLocaleResolver.resolveLocale(request))+", ");
				}
			} else
				sb.append(messageSource.getMessage("desg10",null,myLocaleResolver.resolveLocale(request))+", ");
		}

		return sb.toString();

	}
}
