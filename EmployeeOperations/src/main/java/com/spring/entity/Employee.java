package com.spring.entity;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

	@Id
	private String employeeId;
	private String firstName;
	private String lastName;
	private String gender;
	private String emailId;
	private String phoneNumber;
	private String password;
	private Date dateOfBirth;
	private String profilePhoto;
	private LocalDate empCreatedDate;
	private LocalDate empUpdatedDate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="department_id",
	           referencedColumnName = "deptId")
	private Department department;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="designation_id",
	           referencedColumnName = "desgId")
	private Designation designation;

}
