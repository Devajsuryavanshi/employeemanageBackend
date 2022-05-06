package com.mindtree.ConsultancyService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.ConsultancyService.Entity.HR;

public interface HRRepository extends JpaRepository<HR, Integer>{

	public HR findByEmail(String email);

}