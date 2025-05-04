package org.services.crime.services;

import java.util.List;

import org.services.crime.dto.CaseDto;

public interface CaseServices {
	public CaseDto save(CaseDto caseEntity);
	public void delete(CaseDto caseEntity);
	public void delete(Long id);
	public List<CaseDto> findAll();
}
