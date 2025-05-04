package org.services.crime.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.services.crime.dto.SuspectDto;
import org.services.crime.entity.Suspect;
import org.services.crime.repository.SuspectRepository;
import org.services.crime.services.SuspectServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuspectServicesImpl implements SuspectServices {
	@Autowired
	private SuspectRepository suspectRepo;

	@Override
	public SuspectDto save(SuspectDto suspect) {
		Suspect suspectEntity = new Suspect();
		BeanUtils.copyProperties(suspect, suspectEntity);
		suspectEntity = suspectRepo.save(suspectEntity);
		BeanUtils.copyProperties(suspectEntity, suspect);

		if (suspectEntity.getCaseObj() != null) {
			suspect.setCaseId(suspectEntity.getCaseObj().getId());
		}
		
		return suspect;
	}

	@Override
	public void delete(SuspectDto suspect) {
		Suspect suspectEntity = new Suspect();
		BeanUtils.copyProperties(suspect, suspectEntity);
		suspectRepo.delete(suspectEntity);
	}

	@Override
	public List<SuspectDto> findAll() {
		return suspectRepo.findAll().stream().map(suspect -> {
			SuspectDto suspectDto = new SuspectDto();
			BeanUtils.copyProperties(suspect, suspectDto);
			if (suspect.getCaseObj() != null) {
				suspectDto.setCaseId(suspect.getCaseObj().getId());
			}
			return suspectDto;
		}).collect(Collectors.toList());
	}

	@Override
	public List<SuspectDto> findAllByCaseId(Long caseId) {
		return suspectRepo.findAllByCaseId(caseId).stream().map(suspect -> {
			SuspectDto suspectDto = new SuspectDto();
			BeanUtils.copyProperties(suspect, suspectDto);
			suspectDto.setCaseId(suspect.getCaseObj().getId());
			return suspectDto;
		}).collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		suspectRepo.deleteById(id);		
	}
}
