package org.services.crime.repository;

import org.services.crime.entity.Victim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VictimRepository extends JpaRepository<Victim, Long> {
}
