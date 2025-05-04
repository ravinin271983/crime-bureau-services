package org.services.crime.controller;

import java.util.List;

import org.services.crime.dto.SuspectDto;
import org.services.crime.services.SuspectServices;
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
public class SuspectController {
	@Autowired
	private SuspectServices suspectServices;

	@GetMapping(value = "/suspect", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<SuspectDto> findAll() {
		return suspectServices.findAll();
	}

	@GetMapping(value = "/suspect/{caseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<SuspectDto> findAll(@PathVariable Long caseId) {
		return suspectServices.findAllByCaseId(caseId);
	}
	
	@PostMapping(value = "/suspect", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SuspectDto save(@RequestBody SuspectDto suspect) {
		return suspectServices.save(suspect);
	}
	
	@PutMapping(value = "/suspect", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SuspectDto update(@RequestBody SuspectDto suspect) {
		return suspectServices.save(suspect);
	}

	@DeleteMapping(value = "/suspect", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String delete(@RequestBody SuspectDto suspect) {
		suspectServices.delete(suspect);
		return "Suspect deleted";
	}
	
	@DeleteMapping(value = "/suspect/{id}")
	@ResponseBody
	public String deleteById(@PathVariable("id") Long id) {
		suspectServices.delete(id);
		return "Suspect deleted";
	}
}
