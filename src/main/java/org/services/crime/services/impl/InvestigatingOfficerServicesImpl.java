package org.services.crime.services.impl;

import java.util.List;

import org.services.crime.entity.InvestigatingOfficer;
import org.services.crime.repository.InvestigatingOfficerRepository;
import org.services.crime.services.InvestigatingOfficerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestigatingOfficerServicesImpl implements InvestigatingOfficerServices {
	@Autowired
	private InvestigatingOfficerRepository investigatingOfficerRepo;

	@Override
	public InvestigatingOfficer save(InvestigatingOfficer investigatingOfficer) {
		return investigatingOfficerRepo.save(investigatingOfficer);
	}

	@Override
	public void delete(InvestigatingOfficer investigatingOfficer) {
		investigatingOfficerRepo.delete(investigatingOfficer);
	}

	@Override
	public List<InvestigatingOfficer> findAll() {
		return investigatingOfficerRepo.findAll();
	}
}
