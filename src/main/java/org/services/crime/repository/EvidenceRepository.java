package org.services.crime.repository;

import java.util.List;

import org.services.crime.entity.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvidenceRepository extends JpaRepository<Evidence, Long>{
	public List<Evidence> findAllByCaseId(Long caseId);
}
