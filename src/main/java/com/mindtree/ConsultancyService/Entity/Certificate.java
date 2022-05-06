package com.mindtree.ConsultancyService.Entity;

import javax.persistence.Column;
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
public class Certificate {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter private int id;
	
	@Getter @Setter private String certificateName;
	
	@Getter @Setter private String certificateDescription;
	
	@Getter @Setter private String authority;
	
	@Column(unique=true)
	@Getter @Setter private String certificateNumber;
	
	@JsonBackReference
	@ManyToOne
	@Getter @Setter private Employee achiever;

}
