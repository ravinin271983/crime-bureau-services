package org.services.crime.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.services.crime.entity.LegalAction;
import org.services.crime.repository.LegalActionRepository;
import org.services.crime.services.LegalActionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LegalActionServicesImpl implements LegalActionServices {
	@Autowired
	private LegalActionRepository legalActionRepo;

	@Override
	public LegalAction save(LegalAction action) {
		return legalActionRepo.save(action);
	}

	@Override
	public void delete(LegalAction action) {
		legalActionRepo.delete(action);
	}

	@Override
	public List<LegalAction> findAll() {
		return legalActionRepo.findAll();
	}

	@Override
	public List<LegalAction> findAllByCaseId(Long caseId) {
//		return legalActionRepo.findAll().stream().filter(obj -> obj.getCaseObj().getId() == caseId).collect(Collectors.toList());
		return null;
	}
}
