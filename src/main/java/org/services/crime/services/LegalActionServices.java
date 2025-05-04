package org.services.crime.services;

import java.util.List;

import org.services.crime.dto.LegalActionDto;

public interface LegalActionServices {
	public LegalActionDto save(LegalActionDto action);
	public void delete(LegalActionDto action);
	public void delete(Long id);
	public List<LegalActionDto> findAll();
	public List<LegalActionDto> findAllByCaseId(Long caseId);
}
