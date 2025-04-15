package org.services.crime.services;

import java.util.List;

import org.services.crime.entity.Case;

public interface CaseServices {
	public Case save(Case caseEntity);
	public void delete(Case caseEntity);
	public List<Case> findAll();
}
