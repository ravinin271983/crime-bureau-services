package org.services.crime.services.impl;

import java.util.List;

import org.services.crime.entity.Case;
import org.services.crime.repository.CaseRepository;
import org.services.crime.services.CaseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseServicesImpl implements CaseServices {
	@Autowired
	private CaseRepository caseRepo;
	
	@Override
	public Case save(Case caseEntity) {
		return caseRepo.save(caseEntity);
	}

	@Override
	public void delete(Case caseEntity) {
		caseRepo.delete(caseEntity);
	}

	@Override
	public List<Case> findAll() {
		return caseRepo.findAll();
	}
}
