package org.services.crime.services;

import java.util.List;

import org.services.crime.entity.InvestigatingOfficer;

public interface InvestigatingOfficerServices {
	public InvestigatingOfficer save(InvestigatingOfficer investigatingOfficer);
	public void delete(InvestigatingOfficer investigatingOfficer);
	public List<InvestigatingOfficer> findAll();
}
