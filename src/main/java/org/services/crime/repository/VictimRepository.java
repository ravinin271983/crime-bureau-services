package org.services.crime.repository;

import java.util.List;

import org.services.crime.entity.Victim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface VictimRepository extends JpaRepository<Victim, Long> {
	@Modifying
    @Transactional
    @Query(value="UPDATE victim v SET v.case_id = :caseId WHERE v.id = :id", nativeQuery = true)
	public int updateVictim(@Param("id") Long id, @Param("caseId") Long caseId);

	@Query(value="select * victim v WHERE v.case_id = :caseId", nativeQuery = true)
	public List<Victim> findAllByCaseId(@Param("caseId") Long caseId);

	@Modifying
    @Transactional
	@Query(value="update victim v set v.case_id = null WHERE v.case_id = :caseId", nativeQuery = true)
	public int removeCase(@Param("caseId") Long caseId);

}
