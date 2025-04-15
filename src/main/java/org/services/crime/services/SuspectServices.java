package org.services.crime.services;

import java.util.List;

import org.services.crime.entity.Suspect;

public interface SuspectServices {
	public Suspect save(Suspect suspect);
	public void delete(Suspect suspect);
	public List<Suspect> findAll();
	public List<Suspect> findAllByCaseId(Long caseId);
}
