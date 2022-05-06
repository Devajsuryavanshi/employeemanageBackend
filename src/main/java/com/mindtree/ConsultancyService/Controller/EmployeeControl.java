package com.mindtree.ConsultancyService.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mindtree.ConsultancyService.Entity.Certificate;
import com.mindtree.ConsultancyService.Entity.Employee;
import com.mindtree.ConsultancyService.Entity.Skill;
import com.mindtree.ConsultancyService.Service.EmployeeService;

@RestController
public class EmployeeControl {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World";
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/employees/{id}/skills")
	public List<Skill> getSkills(@PathVariable int id){
		return service.getSkillsByEmployeeId(id);
	}
	
	@GetMapping("/employees/{id}/certificates")
	public List<Certificate> getCertificates(@PathVariable int id){
		return service.getCertificateByEmployeeId(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/employees/{email}")
	public Employee getByEmail(@PathVariable String email){
		return service.getByEmail(email);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return service.getEmployees();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/employees")
	public ResponseEntity<Void> addEmployee(@RequestBody Employee emp){
		
		service.addOrUpdateEmployee(emp);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(emp.getId()).toUri();
        return ResponseEntity.created(location).build();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/employees")
	public ResponseEntity<Void> updateEmployee(@RequestBody Employee emp){
		
		service.addOrUpdateEmployee(emp);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(emp.getId()).toUri();
        return ResponseEntity.created(location).build();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/employees/skill")
	public ResponseEntity<Void> addSkill(@RequestBody Skill skill){
		
		service.addSkill(skill);
		System.out.println(skill);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(skill.getId()).toUri();
        return ResponseEntity.created(location).build();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/employees/skill/")
	public ResponseEntity<Void> updateSkill(@PathVariable int id, @RequestBody Skill skill){
		
		service.addSkill(skill);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(skill.getId()).toUri();
        return ResponseEntity.created(location).build();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/employees/certificate")
	public ResponseEntity<Void> addCert(@RequestBody Certificate cert){
		
		service.addCertificate(cert);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cert.getId()).toUri();
        return ResponseEntity.created(location).build();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/employees/certificate")
	public ResponseEntity<Void> updateCert(@PathVariable int id, @RequestBody Certificate cert){
		
		service.addCertificate(cert);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cert.getId()).toUri();
        return ResponseEntity.created(location).build();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/employees/skill/{id}")
	public void deleteSkill(@PathVariable int id) {
		service.deleteSkill(id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/employees/certificate/{id}")
	public void deleteCertificate(@PathVariable int id) {
		service.deleteCertificate(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id) {
		service.deleteEmployeeById(id);
	}

}
