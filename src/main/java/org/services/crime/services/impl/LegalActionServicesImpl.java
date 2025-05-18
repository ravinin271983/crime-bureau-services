package org.services.crime.services.impl;

import java.util.List;

import org.services.crime.dto.LegalActionDto;
import org.services.crime.entity.Case;
import org.services.crime.entity.LegalAction;
import org.services.crime.repository.CaseRepository;
import org.services.crime.repository.LegalActionRepository;
import org.services.crime.services.LegalActionServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LegalActionServicesImpl implements LegalActionServices {
	@Autowired
	private LegalActionRepository legalActionRepo;

	@Autowired
	private CaseRepository caseRepo;
	
	@Override
	public LegalActionDto save(LegalActionDto action) {
		formatInput(action);
		LegalAction legalAction = new LegalAction();
		BeanUtils.copyProperties(action, legalAction);
		legalAction = legalActionRepo.save(legalAction);
		
		if (action.getCaseId() != null) {
			caseRepo.updateCase(action.getCaseId(), legalAction.getId(), "CLOSED");
		}

		BeanUtils.copyProperties(legalAction, action);

		if (action.getCaseId() != null) {
			Case mappedCase = caseRepo.findById(action.getCaseId()).orElse(null);
			action.setCaseId(mappedCase.getId());
		}

		return action;
	}

	private void formatInput(LegalActionDto action) {
		if (action.getId() == -1) {
			action.setId(null);
		}
	}
	
	@Override
	public void delete(LegalActionDto action) {
		LegalAction legalAction = new LegalAction();
		BeanUtils.copyProperties(action, legalAction);
		legalActionRepo.delete(legalAction);
		caseRepo.removeLegalAction(legalAction.getId());
	}

	@Override
	public List<LegalActionDto> findAll() {
		List<LegalActionDto> legalActions = legalActionRepo.findAll().stream().map(legalAction -> {
			LegalActionDto legalActionDto = new LegalActionDto();
			BeanUtils.copyProperties(legalAction, legalActionDto);
			return legalActionDto;
		}).toList();
		return legalActions;
	}

	@Override
	public List<LegalActionDto> findAllByCaseId(Long caseId) {
//		return legalActionRepo.findAll().stream().filter(obj -> obj.getCaseObj().getId() == caseId).collect(Collectors.toList());
		return null;
	}

	@Override
	public void delete(Long id) {
		legalActionRepo.deleteById(id);
	}
}
