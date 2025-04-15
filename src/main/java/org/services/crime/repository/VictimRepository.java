package org.services.crime.repository;

import java.util.List;

import org.services.crime.entity.Victim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VictimRepository extends JpaRepository<Victim, Long> {
	public List<Victim> findAllByCaseId(Long caseId);
}
