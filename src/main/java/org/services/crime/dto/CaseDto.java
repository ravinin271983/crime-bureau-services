package org.services.crime.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class CaseDto {
	private Long id;
	private String description;
	private String status;
	private Timestamp dateReported;
    private Long investigatingOfficerId;
    private List<Long> evidenceIds;
    private List<Long> victimIds;
    private List<Long> suspectIds;
    private Long legalActionId;
}
