package org.services.crime.services;

import java.util.List;

import org.services.crime.entity.Victim;

public interface VictimServices {
	public Victim save(Victim victim);
	public void delete(Victim victim);
	public List<Victim> findAll();
	public List<Victim> findAllByCaseId(Long caseId);
}
