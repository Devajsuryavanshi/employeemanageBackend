package com.mindtree.ConsultancyService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mindtree.ConsultancyService.Entity.Certificate;
import com.mindtree.ConsultancyService.Entity.Employee;
import com.mindtree.ConsultancyService.Entity.Skill;
import com.mindtree.ConsultancyService.Entity.User;
import com.mindtree.ConsultancyService.Repository.CertificateRepository;
import com.mindtree.ConsultancyService.Repository.EmployeeRepository;
import com.mindtree.ConsultancyService.Repository.SkillRepository;
import com.mindtree.ConsultancyService.Repository.UserRepository;

@Component
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repo;
	
	@Autowired
	SkillRepository skillRepo;
	
	@Autowired
	CertificateRepository certRepo;
	
	@Autowired
	UserRepository userRepo;
	
	public void addOrUpdateEmployee(Employee emp) {
		
		if(emp.getId() == 0)
		    userRepo.save(new User(emp.getEmail(),emp.getPassword(),"employee"));
		else {
			Employee empl = repo.getById(emp.getId());
				userRepo.deleteById(userRepo.findByEmail(empl.getEmail()).getId());
				userRepo.save(new User(emp.getEmail(),emp.getPassword(),"employee"));
		}
		repo.save(emp);
	}
	
	public List<Employee> getEmployees(){
		return repo.findAll();
	}
	
	public List<Skill> getSkillsByEmployeeId(int id){
		return repo.findById(id).get().getSkills();
	}
	
	public List<Certificate> getCertificateByEmployeeId(int id){
		return repo.findById(id).get().getCertificates();
	}
	
	public Employee getEmployeeById(int id) {
		return repo.findById(id).get();
	}
	
	public Employee getByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	public void addSkill(Skill skill) {
		skillRepo.save(skill);
	}
	
	public void addCertificate(Certificate cert) {
		certRepo.save(cert);
	}
	
	public void deleteSkill(int id) {
		skillRepo.deleteById(id);
	}
	
	public void deleteCertificate(int id) {
		certRepo.deleteById(id);
	}
	
	public void deleteEmployeeById(int id) {
		List<Skill> skills= repo.findById(id).get().getSkills(); 
		List<Certificate> certs = repo.findById(id).get().getCertificates();
		for(int i = 0; i < skills.size(); i++) {
			skillRepo.deleteById(skills.get(i).getId());
		}
		for(int i = 0; i< certs.size(); i++) {
			certRepo.deleteById(certs.get(i).getId());
		}
		repo.deleteById(id);
	}
}
