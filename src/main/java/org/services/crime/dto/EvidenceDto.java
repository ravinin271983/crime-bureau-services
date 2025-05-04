package org.services.crime.dto;

import lombok.Data;

@Data
public class EvidenceDto {
	private Long id;
	private String evidenceType;
	private String evidenceDetails;
	private Long caseId;
}
