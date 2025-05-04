package org.services.crime.services;

import java.util.List;

import org.services.crime.dto.InvestigatingOfficerDto;

public interface InvestigatingOfficerServices {
	public InvestigatingOfficerDto save(InvestigatingOfficerDto investigatingOfficer);
	public void delete(InvestigatingOfficerDto investigatingOfficer);
	public void delete(Long id);
	public List<InvestigatingOfficerDto> findAll();
}
