package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Designation;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, String>{

}
