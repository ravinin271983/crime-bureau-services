package org.services.crime.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "evidence")
public class Evidence {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;

	@Column(name="evidence_type")
	private String evidenceType;
	
	@Column(name="evidence_id")
	private String evidenceId;
	
	@Column(name="evidence_details")
	private String evidenceDetails;
	
	@Column(name="case_id")
	private Long caseId;
}
