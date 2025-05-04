package org.services.crime.dto;

import lombok.Data;

@Data
public class VictimDto {
	private Long id;
	private String name;
	private String contactNo;
	private String address;
	private Long caseId;
}
