package com.spring.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{

	Employee findByEmailId(String emailId);
	
	Employee findByPhoneNumber(String phoneNumber);
	
	@Query("select x from Employee x where x.empCreatedDate between ?1 and ?2")
	List<Employee> findByCreatedDateBetween(LocalDate date1, LocalDate date2);

}
