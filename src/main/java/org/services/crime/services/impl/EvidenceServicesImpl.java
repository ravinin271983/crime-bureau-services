package org.services.crime.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.services.crime.dto.EvidenceDto;
import org.services.crime.entity.Evidence;
import org.services.crime.repository.EvidenceRepository;
import org.services.crime.services.EvidenceServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvidenceServicesImpl implements EvidenceServices {
	@Autowired
	private EvidenceRepository evidenceRepo; 

	@Override
	public EvidenceDto save(EvidenceDto evidenceDto) {
		formatInput(evidenceDto);

		if (evidenceDto.getId() != null) {
			evidenceRepo.updateEvidenceDetails(evidenceDto.getId(), evidenceDto.getCaseId(), evidenceDto.getEvidenceType(), evidenceDto.getEvidenceDetails());
		} else {
			Evidence evidence = new Evidence();
			BeanUtils.copyProperties(evidenceDto, evidence);

			evidence = evidenceRepo.save(evidence);
			BeanUtils.copyProperties(evidence, evidenceDto);
			if (evidence.getCaseObj() != null) {
				evidenceDto.setCaseId(evidence.getCaseObj().getId());
			}
		}

		return evidenceDto;
	}

	private void formatInput(EvidenceDto evidenceDto) {
		if (evidenceDto.getId() != null && evidenceDto.getId() == -1) {
			evidenceDto.setId(null);
		}
	}
	
	@Override
	public void delete(EvidenceDto evidenceDto) {
		Evidence evidence = new Evidence();
		BeanUtils.copyProperties(evidenceDto, evidence);
		evidenceRepo.delete(evidence);
	}

	@Override
	public void delete(Long id) {
		evidenceRepo.deleteById(id);
	}
	
	@Override
	public List<EvidenceDto> findAll() {
		List<Evidence> evidences = evidenceRepo.findAll();
		List<EvidenceDto> evidenceDtos = evidences.stream().map(evidence -> {
			EvidenceDto evidenceDto = new EvidenceDto();
			BeanUtils.copyProperties(evidence, evidenceDto);
			if (evidence.getCaseObj() != null) {
				evidenceDto.setCaseId(evidence.getCaseObj().getId());
			}
			return evidenceDto;
		}).collect(Collectors.toList());
		return evidenceDtos;
	}

	@Override
	public List<EvidenceDto> findAllByCaseId(Long caseId) {
		List<Evidence> evidences = evidenceRepo.findAllByCaseId(caseId);
		List<EvidenceDto> evidenceDtos = evidences.stream().map(evidence -> {
			EvidenceDto evidenceDto = new EvidenceDto();
			BeanUtils.copyProperties(evidence, evidenceDto);
			evidenceDto.setCaseId(evidence.getCaseObj().getId());
			return evidenceDto;
		}).collect(Collectors.toList());
		return evidenceDtos;
	}

}
