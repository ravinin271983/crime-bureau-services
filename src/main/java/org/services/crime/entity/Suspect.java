package org.services.crime.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "suspect")
public class Suspect {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;

	@Column(name="case_id")
	private Long caseId;

	@Column(name="suspect_id")
	private String suspectId;

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
}
