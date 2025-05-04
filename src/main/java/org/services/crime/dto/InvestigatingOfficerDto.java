package org.services.crime.dto;

import lombok.Data;

@Data
public class InvestigatingOfficerDto {
	private Long id;
	private String name;
	private String contact;
	private String role;
	private String dept;
}
