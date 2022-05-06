package com.mindtree.ConsultancyService.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor @ToString
public class Employer {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter private int id;
	
	@Getter @Setter private String name;
	
	@Column(unique = true)
	@Getter @Setter private String email;

	@Getter @Setter private String password;
	
	@Getter @Setter private String company;
	
	@Getter @Setter private String designation;

}
