package com.mindtree.ConsultancyService.Controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.mindtree.ConsultancyService.Entity.Employer;
import com.mindtree.ConsultancyService.Service.EmployerService;

@RestController
public class EmployerControl {
	
	@Autowired
	EmployerService service;
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/employer/{email}")
	public Employer getByEmail(@PathVariable String email){
		return service.getByEmail(email);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/employer")
	public ResponseEntity<Void> addEmployee(@RequestBody Employer emp){
		
		service.addOrUpdateEmployer(emp);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(emp.getId()).toUri();
        return ResponseEntity.created(location).build();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/employer")
	public ResponseEntity<Void> updateEmployee(@RequestBody Employer emp){
		
		service.addOrUpdateEmployer(emp);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(emp.getId()).toUri();
        return ResponseEntity.created(location).build();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/employer/skillCount")
	public int getSkillCount(){
		return service.getSkillCount();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/employer/certCount")
	public int getCertificateCount(){
		return service.getCertificateCount();
	}
	

}