package org.services.crime.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "victim")
public class Victim {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;

	@Column(name="case_id")
	private Long caseId;

	@Column(name="victim_id")
	private String victimId;

	@Column(name="name")
	private String name;
	
	@Column(name="contact_no")
	private String contactNo;
	
	@Column(name="address")
	private String address;
}
