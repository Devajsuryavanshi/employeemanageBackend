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
public class User {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter private int id;
	
	@Column(unique=true)
	@Getter @Setter private String email;
	
	@Getter @Setter private String password;
	
	@Getter @Setter private String role;
	
	public User(String email, String password, String role) {
		this.email = email;
		this.password = password;
		this.role = role;
	}
	public User(int id, String email, String password, String role) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	

}
