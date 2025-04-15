package org.services.crime.services;

import java.util.List;

import org.services.crime.entity.LegalAction;

public interface LegalActionServices {
	public LegalAction save(LegalAction action);
	public void delete(LegalAction action);
	public List<LegalAction> findAll();
	public List<LegalAction> findAllByCaseId(Long caseId);
}
