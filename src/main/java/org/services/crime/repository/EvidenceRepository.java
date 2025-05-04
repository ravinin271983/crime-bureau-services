package org.services.crime.repository;

import java.util.List;

import org.services.crime.entity.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface EvidenceRepository extends JpaRepository<Evidence, Long> {
	@Modifying
    @Transactional
    @Query(value="UPDATE evidence e SET e.case_id = :caseId WHERE e.id = :id", nativeQuery = true)
	public int updateEvidence(@Param("id") Long id, @Param("caseId") Long caseId);

	@Modifying
    @Transactional
    @Query(value="UPDATE evidence e SET e.evidence_type = :evidenceType, e.evidence_details= :evidenceDetails, e.case_id= :caseId WHERE e.id = :id", nativeQuery = true)
	public int updateEvidenceDetails(@Param("id") Long id, @Param("caseId") Long caseId, @Param("evidenceType") String evidenceType, @Param("evidenceDetails") String evidenceDetails);
	
	@Query(value="select * evidence e WHERE e.case_id = :caseId", nativeQuery = true)
	public List<Evidence> findAllByCaseId(@Param("caseId") Long caseId);
	
	@Modifying
    @Transactional
	@Query(value="update evidence e set e.case_id = null WHERE e.case_id = :caseId", nativeQuery = true)
	public int removeCase(@Param("caseId") Long caseId);
}
