package org.services.crime.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.services.crime.dto.InvestigatingOfficerDto;
import org.services.crime.entity.InvestigatingOfficer;
import org.services.crime.repository.InvestigatingOfficerRepository;
import org.services.crime.services.InvestigatingOfficerServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestigatingOfficerServicesImpl implements InvestigatingOfficerServices {
	@Autowired
	private InvestigatingOfficerRepository investigatingOfficerRepo;

	@Override
	public InvestigatingOfficerDto save(InvestigatingOfficerDto investigatingOfficer) {
		formatInput(investigatingOfficer);
		InvestigatingOfficer officer = new InvestigatingOfficer();
		BeanUtils.copyProperties(investigatingOfficer, officer);
		officer = investigatingOfficerRepo.save(officer);
		BeanUtils.copyProperties(officer, investigatingOfficer);
		return investigatingOfficer;
	}

	private void formatInput(InvestigatingOfficerDto investigatingOfficer) {
		if (investigatingOfficer.getId() != null && investigatingOfficer.getId() == -1) {
			investigatingOfficer.setId(null);
		}
	}

	@Override
	public void delete(InvestigatingOfficerDto investigatingOfficer) {
		InvestigatingOfficer officer = new InvestigatingOfficer();
		BeanUtils.copyProperties(investigatingOfficer, officer);
		investigatingOfficerRepo.delete(officer);
	}

	@Override
	public void delete(Long id) {
		investigatingOfficerRepo.deleteById(id);
	}
	
	@Override
	public List<InvestigatingOfficerDto> findAll() {
		List<InvestigatingOfficerDto> investigatingOfficers = new ArrayList<>();
		List<InvestigatingOfficer> officers = investigatingOfficerRepo.findAll();
		for (InvestigatingOfficer officer : officers) {
			InvestigatingOfficerDto investigatingOfficer = new InvestigatingOfficerDto();
			BeanUtils.copyProperties(officer, investigatingOfficer);
			investigatingOfficers.add(investigatingOfficer);
		}
		return investigatingOfficers;
	}
}
