package org.services.crime.controller;

import java.util.List;

import org.services.crime.dto.EvidenceDto;
import org.services.crime.services.EvidenceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvidenceController {
	@Autowired
	private EvidenceServices evidenceServices;

	@GetMapping(value = "/evidence", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<EvidenceDto> findAll() {
		return evidenceServices.findAll();
	}

	@GetMapping(value = "/evidence/{caseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<EvidenceDto> findAll(@PathVariable Long caseId) {
		return evidenceServices.findAllByCaseId(caseId);
	}
	
	@PostMapping(value = "/evidence", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EvidenceDto save(@RequestBody EvidenceDto evidence) {
		return evidenceServices.save(evidence);
	}
	
	@PutMapping(value = "/evidence", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EvidenceDto update(@RequestBody EvidenceDto evidence) {
		return evidenceServices.save(evidence);
	}

	@DeleteMapping(value = "/evidence", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String delete(@RequestBody EvidenceDto evidence) {
		evidenceServices.delete(evidence);
		return "Evidence deleted";
	}
	
	@DeleteMapping(value = "/evidence/{id}")
	public String delete(@PathVariable("id") Long id) {
		evidenceServices.delete(id);
		return "Evidence deleted";
	}

}
