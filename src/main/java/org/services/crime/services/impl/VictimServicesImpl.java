package org.services.crime.services.impl;

import java.util.List;

import org.services.crime.entity.Victim;
import org.services.crime.repository.VictimRepository;
import org.services.crime.services.VictimServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VictimServicesImpl implements VictimServices {
	@Autowired
	private VictimRepository victimRepo;

	@Override
	public Victim save(Victim victim) {
		return victimRepo.save(victim);
	}

	@Override
	public void delete(Victim victim) {
		victimRepo.delete(victim);
	}

	@Override
	public List<Victim> findAll() {
		return victimRepo.findAll();
	}

	@Override
	public List<Victim> findAllByCaseId(Long caseId) {
		return victimRepo.findAllByCaseId(caseId);
	}

}
