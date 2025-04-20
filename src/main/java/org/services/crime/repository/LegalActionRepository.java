package org.services.crime.repository;

import org.services.crime.entity.LegalAction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LegalActionRepository extends JpaRepository<LegalAction, Long>{
}
