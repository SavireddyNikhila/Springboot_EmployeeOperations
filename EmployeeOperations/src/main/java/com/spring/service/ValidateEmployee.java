package com.spring.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.spring.MyLocaleResolver;
import com.spring.entity.Employee;
import com.spring.repository.EmployeeRepository;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class ValidateEmployee {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private MyLocaleResolver myLocaleResolver;

	public String validate(Employee employee,HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		List<Employee> emps = employeeRepository.findAll();

		// validating employee id
		if (Objects.nonNull(employee.getEmployeeId()) && !"".equalsIgnoreCase(employee.getEmployeeId())) {
			if (employee.getEmployeeId().length() <= 36) {
				for (int i = 0; i < emps.size(); i++) {
					if (emps.get(i).getEmployeeId().equals(employee.getEmployeeId()))
						sb.append(messageSource.getMessage("emp6",null,myLocaleResolver.resolveLocale(request))+", ");
				}
			} else
				sb.append(messageSource.getMessage("emp7",null,myLocaleResolver.resolveLocale(request))+", ");
		} else
			sb.append(messageSource.getMessage("emp8",null,myLocaleResolver.resolveLocale(request))+", ");

		// validating firstname
		if (Objects.nonNull(employee.getFirstName()) && !"".equalsIgnoreCase(employee.getFirstName())) {
			if (!(employee.getFirstName().length() <= 50)) {
				sb.append(messageSource.getMessage("emp9",null,myLocaleResolver.resolveLocale(request))+", ");
			}
		} else
			sb.append(messageSource.getMessage("emp10",null,myLocaleResolver.resolveLocale(request))+", ");

		// validating lastname
		if (Objects.nonNull(employee.getLastName()) && !"".equalsIgnoreCase(employee.getLastName())) {
			if (!(employee.getLastName().length() <= 50))
				sb.append(messageSource.getMessage("emp11",null,myLocaleResolver.resolveLocale(request))+", ");
		}

		// validating gender
		if (Objects.nonNull(employee.getGender()) && !"".equalsIgnoreCase(employee.getGender())) {
			if (employee.getGender().length() == 1) {
				if (!(employee.getGender().matches("(?:[M|F|O])"))) {
					sb.append(messageSource.getMessage("emp12",null,myLocaleResolver.resolveLocale(request))+", ");
				}
			} else {
				sb.append(messageSource.getMessage("emp13",null,myLocaleResolver.resolveLocale(request))+", ");
			}
		}

		// validating email
		if (Objects.nonNull(employee.getEmailId()) && !"".equalsIgnoreCase(employee.getEmailId())) {

			if ((employee.getEmailId().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+[a-zA-Z]{2,}"))) {
				for (int i = 0; i < emps.size(); i++) {
					if (emps.get(i).getEmailId().equals(employee.getEmailId())) {
						sb.append(messageSource.getMessage("emp14",null,myLocaleResolver.resolveLocale(request))+", ");
					}
				}
			} else {
				sb.append(messageSource.getMessage("emp15",null,myLocaleResolver.resolveLocale(request))+", ");
			}

		} else {
			sb.append(messageSource.getMessage("emp16",null,myLocaleResolver.resolveLocale(request))+", ");
		}

		// validating phoneNumber
		if (Objects.nonNull(employee.getPhoneNumber()) && !"".equalsIgnoreCase(employee.getPhoneNumber())) {
			if ((employee.getPhoneNumber().matches("[\\\\\\\\\\\\\\\\+]+[0-9]{2}+[-]+[0-9]{10}"))) {
				for (int i = 0; i < emps.size(); i++) {
					if (emps.get(i).getPhoneNumber().equals(employee.getPhoneNumber())) {
						sb.append(messageSource.getMessage("emp17",null,myLocaleResolver.resolveLocale(request))+", ");
					}
				}
			} else
				sb.append(messageSource.getMessage("emp18",null,myLocaleResolver.resolveLocale(request))+", ");
		} else {
			sb.append(messageSource.getMessage("emp19",null,myLocaleResolver.resolveLocale(request))+", ");
		}

		// validating password
		if ((Objects.nonNull(employee.getPassword()) && !"".equalsIgnoreCase(employee.getPassword()))) {
			if (((employee.getPassword().length() >= 8 && employee.getPassword().length() <= 20))) {
				if (!(employee.getPassword().matches("^(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[A-Za-z0-9]).{8,20}$"))) {
					sb.append(messageSource.getMessage("emp20",null,myLocaleResolver.resolveLocale(request)));
				}
			} else {
				sb.append(messageSource.getMessage("emp21",null,myLocaleResolver.resolveLocale(request)));
			}

		} else {
			sb.append(messageSource.getMessage("emp22",null,myLocaleResolver.resolveLocale(request)));
		}

		return sb.toString();

	}

	public String ValidUpdate(Employee employee,HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		List<Employee> emps = employeeRepository.findAll();

		// validating firstname
		if (Objects.nonNull(employee.getFirstName()) && !"".equalsIgnoreCase(employee.getFirstName())) {
			if (!(employee.getFirstName().length() <= 50)) {
				sb.append(messageSource.getMessage("emp9",null,myLocaleResolver.resolveLocale(request))+", ");
			}
		}

		// validating lastname
		if (Objects.nonNull(employee.getLastName()) && !"".equalsIgnoreCase(employee.getLastName())) {
			if (!(employee.getLastName().length() <= 50))
				sb.append(messageSource.getMessage("emp11",null,myLocaleResolver.resolveLocale(request))+", ");
		}

		// validating gender
		if (Objects.nonNull(employee.getGender()) && !"".equalsIgnoreCase(employee.getGender())) {
			if (employee.getGender().length() == 1) {
				if (!(employee.getGender().matches("(?:[M|F|O])"))) {
					sb.append(messageSource.getMessage("emp12",null,myLocaleResolver.resolveLocale(request))+", ");
				}
			} else {
				sb.append(messageSource.getMessage("emp13",null,myLocaleResolver.resolveLocale(request))+", ");
			}
		}

		// validating email
		if (Objects.nonNull(employee.getEmailId()) && !"".equalsIgnoreCase(employee.getEmailId())) {

			if ((employee.getEmailId().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+[a-zA-Z]{2,}"))) {
				for (int i = 0; i < emps.size(); i++) {
					if (emps.get(i).getEmailId().equals(employee.getEmailId())) {
						sb.append(messageSource.getMessage("emp14",null,myLocaleResolver.resolveLocale(request))+", ");
					}
				}
			} else {
				sb.append(messageSource.getMessage("emp15",null,myLocaleResolver.resolveLocale(request))+", ");
			}

		}

		// validating phoneNumber
		if (Objects.nonNull(employee.getPhoneNumber()) && !"".equalsIgnoreCase(employee.getPhoneNumber())) {
			if ((employee.getPhoneNumber().matches("[\\\\\\\\\\\\\\\\+]+[0-9]{2}+[-]+[0-9]{10}"))) {
				for (int i = 0; i < emps.size(); i++) {
					if (emps.get(i).getPhoneNumber().equals(employee.getPhoneNumber())) {
						sb.append(messageSource.getMessage("emp17",null,myLocaleResolver.resolveLocale(request))+", ");
					}
				}
			} else
				sb.append(messageSource.getMessage("emp18",null,myLocaleResolver.resolveLocale(request))+", ");
		}

		// validating password
		if ((Objects.nonNull(employee.getPassword()) && !"".equalsIgnoreCase(employee.getPassword()))) {
			if (((employee.getPassword().length() >= 8 && employee.getPassword().length() <= 20))) {
				if (!(employee.getPassword().matches("^(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[A-Za-z0-9]).{8,20}$"))) {
					sb.append(messageSource.getMessage("emp20",null,myLocaleResolver.resolveLocale(request)));
				}
			} else {
				sb.append(messageSource.getMessage("emp21",null,myLocaleResolver.resolveLocale(request)));
			}
		}
		return sb.toString();
	}
}
