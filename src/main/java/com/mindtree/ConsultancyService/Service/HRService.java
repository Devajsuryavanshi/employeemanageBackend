package com.mindtree.ConsultancyService.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.mindtree.ConsultancyService.Entity.HR;
import com.mindtree.ConsultancyService.Entity.User;
import com.mindtree.ConsultancyService.Repository.HRRepository;
import com.mindtree.ConsultancyService.Repository.UserRepository;

@Component
public class HRService {
	
	@Autowired
	HRRepository repo;
	
	@Autowired
	UserRepository userRepo;
	
	public HR getHRById(int id) {
		return repo.findById(id).get();
	}
	
	public HR getByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	public void addOrUpdateHR(HR emp) {
		repo.save(emp);
		if(emp.getId() == 0)
		    userRepo.save(new User(emp.getEmail(),emp.getPassword(),"HR"));
		else
			userRepo.save(new User(emp.getId(),emp.getEmail(),emp.getPassword(),"HR"));
	}
}