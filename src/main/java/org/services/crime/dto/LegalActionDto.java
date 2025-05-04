package org.services.crime.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class LegalActionDto {
	private Long id;
	private String actionTaken;
	private Timestamp dateAction;
	private Long caseId;
}
