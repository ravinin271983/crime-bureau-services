package org.services.crime.services;

import java.util.List;

import org.services.crime.dto.VictimDto;

public interface VictimServices {
	public VictimDto save(VictimDto victim);
	public void delete(VictimDto victim);
	public void delete(Long id);
	public List<VictimDto> findAll();
	public List<VictimDto> findAllByCaseId(Long caseId);
}
