package org.services.crime.repository;

import java.util.List;

import org.services.crime.entity.Suspect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuspectRepository extends JpaRepository<Suspect, Long>{
	public List<Suspect> findAllByCaseId(Long caseId);
}
