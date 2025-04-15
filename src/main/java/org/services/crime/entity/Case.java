package org.services.crime.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "case_table")
public class Case {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	
	@Column(name="case_id")
	private String caseId;
	
	@Column(name="description")
	private String description;

	@Column(name="status")
	private String status;

	@Column(name="date_reported")
	private Timestamp dateReported;
	
	@Column(name="investigating_officer_id")
	private Long investigatingOfficerId;
}
