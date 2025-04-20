package org.services.crime.repository;

import org.services.crime.entity.Suspect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuspectRepository extends JpaRepository<Suspect, Long>{
}
