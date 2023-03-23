package com.spring.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.spring.MyLocaleResolver;
import com.spring.entity.Designation;
import com.spring.exceptions.DesignationException;
import com.spring.repository.DesignationRepository;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class DesignationServiceImpl implements DesignationService {

	@Autowired
	private ValidateDesignation validateDesignation;
	@Autowired
	private DesignationRepository designationRepo;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private MyLocaleResolver myLocaleResolver;

	@Override
	public Designation createDesignation(Designation designation,HttpServletRequest request) throws DesignationException {
		String str = validateDesignation.validate(designation,request);
		if (!"".equalsIgnoreCase(str))
			throw new DesignationException(str);

		designation.setDesgCreatedDate(LocalDate.now());
		designation.setDesgUpdatedDate(LocalDate.now());
		return designationRepo.save(designation);
	}

	@Override
	public List<Designation> createBatchDesignations(List<Designation> designations,HttpServletRequest request) throws DesignationException {
		for (int i = 0; i < designations.size(); i++) {
			String str = validateDesignation.validate(designations.get(i),request);

			if (!"".equalsIgnoreCase(str)) {
				throw new DesignationException(messageSource.getMessage("desg12",null,myLocaleResolver.resolveLocale(request)) + designations.get(i).getDesgId()
						+" "+ messageSource.getMessage("desg13",null,myLocaleResolver.resolveLocale(request)) + str);
			}

			designations.get(i).setDesgCreatedDate(LocalDate.now());
			designations.get(i).setDesgUpdatedDate(LocalDate.now());
		}
		return designationRepo.saveAll(designations);
	}

	@Override
	public Designation updateDesignation(String desgId, Designation designation,HttpServletRequest request) throws DesignationException {
		Optional<Designation> desg = designationRepo.findById(desgId);
		if (!desg.isPresent()) {
			throw new DesignationException(messageSource.getMessage("desg1",null,myLocaleResolver.resolveLocale(request))+ desgId);
		} else {
			Designation desgDB = designationRepo.findById(desgId).get();
			String str = validateDesignation.ValidUpdate(designation,request);
			if (!"".equalsIgnoreCase(str)) {
				throw new DesignationException(str);
			} else {
				if (Objects.nonNull(designation.getDesgName()) && !"".equalsIgnoreCase(designation.getDesgName()))
					desgDB.setDesgName(designation.getDesgName());
				if (Objects.nonNull(designation.getDesgCode()) && !"".equalsIgnoreCase(designation.getDesgCode()))
					desgDB.setDesgCode(designation.getDesgCode());
				if (Objects.nonNull(designation.getDesgCreatedDate()))
					desgDB.setDesgCreatedDate(designation.getDesgCreatedDate());
			}
			desgDB.setDesgUpdatedDate(LocalDate.now());
			return designationRepo.save(desgDB);
		}
	}

	@Override
	public Designation getDesignation(String desgId,HttpServletRequest request) throws DesignationException {
		Optional<Designation> desg = designationRepo.findById(desgId);
		if (!desg.isPresent())
			throw new DesignationException(messageSource.getMessage("desg1",null,myLocaleResolver.resolveLocale(request)) + desgId);
		return designationRepo.findById(desgId).get();
	}

	@Override
	public List<Designation> getAllDesignations(HttpServletRequest request) throws DesignationException {
		List<Designation> desgs = designationRepo.findAll();
		if (desgs.size() == 0)
			throw new DesignationException(messageSource.getMessage("desg2",null,myLocaleResolver.resolveLocale(request)));
		return desgs;
	}

	@Override
	public void deleteDesignation(String desgId,HttpServletRequest request) throws DesignationException {
		Optional<Designation> desg = designationRepo.findById(desgId);
		if (!desg.isPresent())
			throw new DesignationException(messageSource.getMessage("desg1",null,myLocaleResolver.resolveLocale(request)) + desgId);
		designationRepo.deleteById(desgId);

	}

}
