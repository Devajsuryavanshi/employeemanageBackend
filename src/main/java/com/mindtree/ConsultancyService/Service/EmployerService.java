package com.mindtree.ConsultancyService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mindtree.ConsultancyService.Entity.Employee;
import com.mindtree.ConsultancyService.Entity.Employer;
import com.mindtree.ConsultancyService.Entity.User;
import com.mindtree.ConsultancyService.Repository.CertificateRepository;
import com.mindtree.ConsultancyService.Repository.EmployerRepository;
import com.mindtree.ConsultancyService.Repository.SkillRepository;
import com.mindtree.ConsultancyService.Repository.UserRepository;

@Component
public class EmployerService {
	
	@Autowired
	EmployerRepository repo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	SkillRepository skillRepo;
	
	@Autowired
	CertificateRepository certRepo;
	
	public Employer getEmployerById(int id) {
		return repo.findById(id).get();
	}
	
	public Employer getByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	public void addOrUpdateEmployer(Employer emp) {
		if(emp.getId() == 0)
		    userRepo.save(new User(emp.getEmail(),emp.getPassword(),"employer"));
		else {
			Employer empl = repo.getById(emp.getId());
				userRepo.deleteById(userRepo.findByEmail(empl.getEmail()).getId());
				userRepo.save(new User(emp.getEmail(),emp.getPassword(),"employer"));
		}
		repo.save(emp);
	}
	
	public int getSkillCount() {
		return (int) skillRepo.count();
	}
	
	public int getCertificateCount() {
		return (int) certRepo.count();
	}
}
