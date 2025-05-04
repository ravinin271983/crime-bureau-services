package org.services.crime.dto;

import lombok.Data;

@Data
public class SuspectDto {
	private Long id;
	private String name;
	private String gender;
	private String address;
	private String age;
	private String crimeHistory;
	private Long caseId;
}
