package org.services.crime.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "investigating_officer")
public class InvestigatingOfficer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;

	@Column(name="name")
	private String name;

	@Column(name="contact")
	private String contact;

	@Column(name="role")
	private String role;

	@Column(name="dept")
	private String dept;
}
