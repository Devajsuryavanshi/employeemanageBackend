package com.mindtree.ConsultancyService.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor @ToString
public class Employee {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter private int id;
	
	@Getter @Setter private String name;
	
	@Column(unique = true)
	@Getter @Setter private String email;

	@Getter @Setter private String password;
	
	@Getter @Setter private int yearsOfExperience;
	
	@Getter @Setter private String bio;
	
	@JsonManagedReference
	@OneToMany(mappedBy="employee")
	@Getter private List<Skill> skills;
	
	@JsonManagedReference
	@OneToMany(mappedBy="achiever")
	@Getter private List<Certificate> certificates;

}
