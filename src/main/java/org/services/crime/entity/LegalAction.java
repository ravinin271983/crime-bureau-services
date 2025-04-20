package org.services.crime.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "legal_action")
public class LegalAction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;

	@Column(name="action_id")
	private String actionId;
	
	@Column(name="action_taken")
	private String actionTaken;
	
	@Column(name="date_action")
	private Timestamp dateAction;
}
