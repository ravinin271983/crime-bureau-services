package org.services.crime.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.services.crime.dto.VictimDto;
import org.services.crime.entity.Victim;
import org.services.crime.repository.VictimRepository;
import org.services.crime.services.VictimServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VictimServicesImpl implements VictimServices {
	@Autowired
	private VictimRepository victimRepo;

	@Override
	public VictimDto save(VictimDto victim) {
		Victim victimEntity = new Victim();
		BeanUtils.copyProperties(victim, victimEntity);
		victimEntity = victimRepo.save(victimEntity);
		BeanUtils.copyProperties(victimEntity, victim);
		if (victimEntity.getCaseObj() != null) {
			victim.setCaseId(victimEntity.getCaseObj().getId());
		}
		return victim;
	}

	@Override
	public void delete(VictimDto victim) {
		Victim victimEntity = new Victim();
		BeanUtils.copyProperties(victim, victimEntity);
		victimRepo.delete(victimEntity);
	}

	@Override
	public List<VictimDto> findAll() {
		return victimRepo.findAll().stream().map(victim -> {
			VictimDto victimDto = new VictimDto();
			BeanUtils.copyProperties(victim, victimDto);
			if (victim.getCaseObj() != null) {
				victimDto.setCaseId(victim.getCaseObj().getId());
			}
			return victimDto;
		}).collect(Collectors.toList());
	}

	@Override
	public List<VictimDto> findAllByCaseId(Long caseId) {
		return victimRepo.findAllByCaseId(caseId).stream().map(victim -> {
			VictimDto victimDto = new VictimDto();
			BeanUtils.copyProperties(victim, victimDto);
			victimDto.setCaseId(victim.getCaseObj().getId());
			return victimDto;
		}).collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		victimRepo.deleteById(id);
	}

}
