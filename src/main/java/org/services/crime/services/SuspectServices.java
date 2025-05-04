package org.services.crime.services;

import java.util.List;

import org.services.crime.dto.SuspectDto;

public interface SuspectServices {
	public SuspectDto save(SuspectDto suspect);
	public void delete(SuspectDto suspect);
	public void delete(Long id);
	public List<SuspectDto> findAll();
	public List<SuspectDto> findAllByCaseId(Long caseId);
}
