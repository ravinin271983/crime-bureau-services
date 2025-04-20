package org.services.crime.services.impl;

import java.util.List;

import org.services.crime.entity.Case;
import org.services.crime.entity.Evidence;
import org.services.crime.entity.InvestigatingOfficer;
import org.services.crime.entity.Suspect;
import org.services.crime.entity.Victim;
import org.services.crime.repository.CaseRepository;
import org.services.crime.repository.EvidenceRepository;
import org.services.crime.repository.InvestigatingOfficerRepository;
import org.services.crime.repository.SuspectRepository;
import org.services.crime.repository.VictimRepository;
import org.services.crime.services.CaseServices;
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
	public Case save(Case caseEntity) {
		Case savedCase = caseRepo.save(caseEntity);

//		if (caseEntity.getInvestigatingOfficer() != null) {
//			caseEntity.getInvestigatingOfficer().setCaseObj(savedCase);
//			investigatingOfficerRepo.save(caseEntity.getInvestigatingOfficer());
//		}

		if (!CollectionUtils.isEmpty(caseEntity.getEvidences())) {
			List<Evidence> evidences = caseEntity.getEvidences();
			for (Evidence evidence: evidences) {
				evidence.setCaseObj(savedCase);
				evidenceRepo.save(evidence);	
			}
		}

		if (!CollectionUtils.isEmpty(caseEntity.getSuspects())) {
			List<Suspect> suspects = caseEntity.getSuspects();
			for (Suspect suspect: suspects) {
				suspect.setCaseObj(savedCase);
				suspectRepo.save(suspect);	
			}
		}

		if (!CollectionUtils.isEmpty(caseEntity.getVictims())) {
			List<Victim> victims = caseEntity.getVictims();
			for (Victim victim: victims) {
				victim.setCaseObj(savedCase);
				victimRepo.save(victim);	
			}
		}

		return savedCase;
	}

	@Override
	public void delete(Case caseEntity) {
		caseRepo.delete(caseEntity);
	}

	@Override
	public List<Case> findAll() {
		List<Case> cases = caseRepo.findAll();
//		for (Case caseObj: cases) {
//			List<Evidence> evidences = evidenceRepo.findAllByCaseId(caseObj.getId());
//			caseObj.setEvidences(evidences);
//			List<Suspect> suspects = suspectRepo.findAllByCaseId(caseObj.getId());
//			caseObj.setSuspects(suspects);
//			List<Victim> victims = victimRepo.findAllByCaseId(caseObj.getId());
//			caseObj.setVictims(victims);
//		}
		return cases;
	}
}
