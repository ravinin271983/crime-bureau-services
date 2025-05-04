package org.services.crime.repository;

import java.util.Optional;

import org.services.crime.entity.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CaseRepository extends JpaRepository<Case, Long> {
	@Modifying
    @Transactional
    @Query(value="UPDATE case_table c SET c.legal_action_id = :legalActionId, c.status= :status WHERE c.id = :id", nativeQuery = true)
	public int updateCase(@Param("id") Long id, @Param("legalActionId") Long legalActionId, @Param("status") String status);
	
	@Query(value="select * case_table c WHERE c.legal_action_id = :legalActionId", nativeQuery = true)
	public Optional<Case> findByLegalActionId(@Param("legalActionId") Long legalActionId);
	
	@Modifying
    @Transactional
    @Query(value="UPDATE case_table c SET c.legal_action_id = null, c.status= :status WHERE c.legal_action_id = :legalActionId", nativeQuery = true)
	public int removeLegalAction(@Param("legalActionId") Long legalActionId);
}
