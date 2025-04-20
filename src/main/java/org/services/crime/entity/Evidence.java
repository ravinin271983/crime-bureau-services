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
@Entity(name = "evidence")
public class Evidence {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;

	@Column(name="evidence_type")
	private String evidenceType;
	
	@Column(name="evidence_details")
	private String evidenceDetails;

	@ManyToOne
	@JoinColumn(name = "case_id")
	@JsonIgnore
	private Case caseObj;
}
