package org.services.crime.services;

import java.util.List;

import org.services.crime.entity.Evidence;

public interface EvidenceServices {
	public Evidence save(Evidence evidence);
	public void delete(Evidence evidence);
	public List<Evidence> findAll();
	public List<Evidence> findAllByCaseId(Long caseId);
}
