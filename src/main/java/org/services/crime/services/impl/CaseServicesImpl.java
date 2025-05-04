package org.services.crime.services.impl;

import java.util.List;

import org.services.crime.dto.CaseDto;
import org.services.crime.entity.Case;
import org.services.crime.entity.Evidence;
import org.services.crime.entity.Suspect;
import org.services.crime.entity.Victim;
import org.services.crime.repository.CaseRepository;
import org.services.crime.repository.EvidenceRepository;
import org.services.crime.repository.InvestigatingOfficerRepository;
import org.services.crime.repository.SuspectRepository;
import org.services.crime.repository.VictimRepository;
import org.services.crime.services.CaseServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class CaseServicesImpl implements CaseServices {
	@Autowired
	private CaseRepository caseRepo;

	@Autowired
	private EvidenceRepository evidenceRepo;

	@Autowired
	private SuspectRepository suspectRepo;

	@Autowired
	private VictimRepository victimRepo;
	
	@Autowired
	private InvestigatingOfficerRepository investigatingOfficerRepo;

	@Override
	public CaseDto save(CaseDto caseDto) {
		Case caseEntity = new Case();
		BeanUtils.copyProperties(caseDto, caseEntity);

		if (caseDto.getId() != null) {
			evidenceRepo.removeCase(caseDto.getId());
			suspectRepo.removeCase(caseDto.getId());
			victimRepo.removeCase(caseDto.getId());

			investigatingOfficerRepo.findById(caseDto.getInvestigatingOfficerId()).ifPresent(investigatingOfficer -> {
				caseEntity.setInvestigatingOfficer(investigatingOfficer);
			});
		}

		Case savedCase = caseRepo.save(caseEntity);

		if (!CollectionUtils.isEmpty(caseDto.getEvidenceIds())) {
			for (Long evidenceId: caseDto.getEvidenceIds()) {
				evidenceRepo.updateEvidence(evidenceId, savedCase.getId());	
			}
		}

		if (!CollectionUtils.isEmpty(caseDto.getSuspectIds())) {
			for (Long suspectId: caseDto.getSuspectIds()) {
				suspectRepo.updateSuspect(suspectId, savedCase.getId());	
			}
		}

		if (!CollectionUtils.isEmpty(caseDto.getVictimIds())) {
			for (Long victimId: caseDto.getVictimIds()) {
				victimRepo.updateVictim(victimId, savedCase.getId());		
			}
		}

		BeanUtils.copyProperties(savedCase, caseDto);
		return caseDto;
	}

	@Override
	public void delete(CaseDto caseDto) {
		Case caseEntity = new Case();
		BeanUtils.copyProperties(caseDto, caseEntity);
		caseRepo.delete(caseEntity);
	}

	@Override
	public List<CaseDto> findAll() {
		List<Case> cases = caseRepo.findAll();
		List<CaseDto> caseDtos = cases.stream().map(caseEntity -> {
			CaseDto caseDto = new CaseDto();
			BeanUtils.copyProperties(caseEntity, caseDto);
			if (caseEntity.getInvestigatingOfficer() != null) {
				caseDto.setInvestigatingOfficerId(caseEntity.getInvestigatingOfficer().getId());
			}
			if (caseEntity.getLegalAction() != null) {
				caseDto.setLegalActionId(caseEntity.getLegalAction().getId());
			}
			if (!CollectionUtils.isEmpty(caseEntity.getEvidences())) {
				caseDto.setEvidenceIds(caseEntity.getEvidences().stream().map(Evidence::getId).toList());
			}
			if (!CollectionUtils.isEmpty(caseEntity.getSuspects())) {
				caseDto.setSuspectIds(caseEntity.getSuspects().stream().map(Suspect::getId).toList());
			}
			if (!CollectionUtils.isEmpty(caseEntity.getVictims())) {
				caseDto.setVictimIds(caseEntity.getVictims().stream().map(Victim::getId).toList());
			}
			return caseDto;
		}).toList();
		return caseDtos;
	}

	@Override
	public void delete(Long id) {
		caseRepo.deleteById(id);
	}
}
