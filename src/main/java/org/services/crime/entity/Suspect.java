package org.services.crime.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "suspect")
public class Suspect {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;

	@Column(name="name")
	private String name;

	@Column(name="gender")
	private String gender;

	@Column(name="address")
	private String address;

	@Column(name="age")
	private String age;

	@Column(name="crime_history")
	private String crimeHistory;
	
	@ManyToOne
	@JoinColumn(name = "case_id")
	@JsonIgnore
	private Case caseObj;
}
