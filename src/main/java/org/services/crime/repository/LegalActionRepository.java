package org.services.crime.repository;

import java.util.List;

import org.services.crime.entity.LegalAction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LegalActionRepository extends JpaRepository<LegalAction, Long>{
	public List<LegalAction> findAllByCaseId(Long caseId);
}
