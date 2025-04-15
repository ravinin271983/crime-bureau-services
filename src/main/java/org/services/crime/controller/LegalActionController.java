package org.services.crime.controller;

import java.util.List;

import org.services.crime.entity.LegalAction;
import org.services.crime.services.LegalActionServices;
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
public class LegalActionController {
	@Autowired
	private LegalActionServices legalActionServices;

	@GetMapping(value = "/legalaction", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<LegalAction> findAll() {
		return legalActionServices.findAll();
	}

	@GetMapping(value = "/legalaction/{caseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<LegalAction> findAll(@PathVariable Long caseId) {
		return legalActionServices.findAllByCaseId(caseId);
	}
	
	@PostMapping(value = "/legalaction", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public LegalAction save(@RequestBody LegalAction legalAction) {
		return legalActionServices.save(legalAction);
	}
	
	@PutMapping(value = "/legalaction", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public LegalAction update(@RequestBody LegalAction legalAction) {
		return legalActionServices.save(legalAction);
	}

	@DeleteMapping(value = "/legalaction", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String delete(@RequestBody LegalAction legalAction) {
		legalActionServices.delete(legalAction);
		return "Legal Action deleted";
	}
}
