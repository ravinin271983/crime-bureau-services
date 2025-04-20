package org.services.crime.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.services.crime.entity.Suspect;
import org.services.crime.repository.SuspectRepository;
import org.services.crime.services.SuspectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuspectServicesImpl implements SuspectServices {
	@Autowired
	private SuspectRepository suspectRepo;

	@Override
	public Suspect save(Suspect suspect) {
		return suspectRepo.save(suspect);
	}

	@Override
	public void delete(Suspect suspect) {
		suspectRepo.delete(suspect);
	}

	@Override
	public List<Suspect> findAll() {
		return suspectRepo.findAll().stream().filter(s -> s.getCaseObj() == null).collect(Collectors.toList());
	}

	@Override
	public List<Suspect> findAllByCaseId(Long caseId) {
//		return suspectRepo.findAll().stream().filter(obj -> obj.getCaseObj().getId() == caseId).collect(Collectors.toList());
		return null;
	}
}
