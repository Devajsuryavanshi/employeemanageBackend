package com.mindtree.ConsultancyService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.ConsultancyService.Entity.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer,Integer> {
	
	public Employer findByEmail(String email);

}
