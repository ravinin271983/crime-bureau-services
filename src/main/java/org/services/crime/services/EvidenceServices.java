package org.services.crime.services;

import java.util.List;

import org.services.crime.dto.EvidenceDto;

public interface EvidenceServices {
	public EvidenceDto save(EvidenceDto evidence);
	public void delete(EvidenceDto evidence);
	public void delete(Long id);
	public List<EvidenceDto> findAll();
	public List<EvidenceDto> findAllByCaseId(Long caseId);
}
