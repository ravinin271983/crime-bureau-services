package org.services.crime.repository;

import java.util.List;

import org.services.crime.entity.Suspect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface SuspectRepository extends JpaRepository<Suspect, Long>{
	@Modifying
    @Transactional
    @Query(value="UPDATE suspect s SET s.case_id = :caseId WHERE s.id = :id", nativeQuery = true)
	public int updateSuspect(@Param("id") Long id, @Param("caseId") Long caseId);
	
	@Query(value="select * suspect s WHERE s.case_id = :caseId", nativeQuery = true)
	public List<Suspect> findAllByCaseId(@Param("caseId") Long caseId);
	
	@Modifying
    @Transactional
	@Query(value="update suspect s set s.case_id = null WHERE s.case_id = :caseId", nativeQuery = true)
	public int removeCase(@Param("caseId") Long caseId);
}
