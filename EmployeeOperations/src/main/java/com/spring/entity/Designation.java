package com.spring.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Designation {

	@Id
	private String desgId;
	private String desgName;
	private String desgCode;
	private LocalDate desgCreatedDate;
	private LocalDate desgUpdatedDate;
	    
}
