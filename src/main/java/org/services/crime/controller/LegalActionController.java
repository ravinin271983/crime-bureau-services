package org.services.crime.controller;

import java.util.List;

import org.services.crime.dto.LegalActionDto;
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
	public List<LegalActionDto> findAll() {
		return legalActionServices.findAll();
	}

	@GetMapping(value = "/legalaction/{caseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<LegalActionDto> findAll(@PathVariable Long caseId) {
		return legalActionServices.findAllByCaseId(caseId);
	}
	
	@PostMapping(value = "/legalaction", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public LegalActionDto save(@RequestBody LegalActionDto legalAction) {
		return legalActionServices.save(legalAction);
	}
	
	@PutMapping(value = "/legalaction", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public LegalActionDto update(@RequestBody LegalActionDto legalAction) {
		return legalActionServices.save(legalAction);
	}

	@DeleteMapping(value = "/legalaction")
	@ResponseBody
	public String delete(@RequestBody LegalActionDto legalAction) {
		legalActionServices.delete(legalAction);
		return "Legal Action deleted";
	}

	@DeleteMapping(value = "/legalaction/{id}")
	@ResponseBody
	public String delete(@PathVariable("id") Long id) {
		legalActionServices.delete(id);
		return "Legal Action deleted";
	}

}
