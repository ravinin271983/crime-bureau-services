package org.services.crime.services.impl;

import java.util.List;

import org.services.crime.entity.Evidence;
import org.services.crime.repository.EvidenceRepository;
import org.services.crime.services.EvidenceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvidenceServicesImpl implements EvidenceServices {
	@Autowired
	private EvidenceRepository evidenceRepo; 

	@Override
	public Evidence save(Evidence evidence) {
		return evidenceRepo.save(evidence);
	}

	@Override
	public void delete(Evidence evidence) {
		evidenceRepo.delete(evidence);
	}

	@Override
	public List<Evidence> findAll() {
		return evidenceRepo.findAll();
	}

	@Override
	public List<Evidence> findAllByCaseId(Long caseId) {
		return evidenceRepo.findAllByCaseId(caseId);
	}

}
