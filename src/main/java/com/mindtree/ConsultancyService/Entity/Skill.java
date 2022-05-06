package com.mindtree.ConsultancyService.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor @ToString
public class Skill {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter 
	private int id;
	
	@Getter @Setter 
	private String skillName;
	
	@Getter @Setter 
	private String skillDescription;
	
	@JsonBackReference
	@ManyToOne
	@Getter @Setter private Employee employee;
	
	public Skill(String skillName, String skillDescription) {
		this.skillName = skillName;
		this.skillDescription = skillDescription;
	}
	
}
