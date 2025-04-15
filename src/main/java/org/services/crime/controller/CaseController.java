package org.services.crime.controller;

import java.util.List;

import org.services.crime.entity.Case;
import org.services.crime.services.CaseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaseController {
	@Autowired
	private CaseServices caseServices;

	@GetMapping(value = "/cases", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Case> findAll() {
		return caseServices.findAll();
	}

	@PostMapping(value = "/cases", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Case save(@RequestBody Case caseEntity) {
		return caseServices.save(caseEntity);
	}
	
	@PutMapping(value = "/cases", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Case update(@RequestBody Case caseEntity) {
		return caseServices.save(caseEntity);
	}

	@DeleteMapping(value = "/cases", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String delete(@RequestBody Case caseEntity) {
		caseServices.delete(caseEntity);
		return "Case deleted";
	}
}
