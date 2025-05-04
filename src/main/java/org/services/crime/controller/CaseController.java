package org.services.crime.controller;

import java.util.List;

import org.services.crime.dto.CaseDto;
import org.services.crime.services.CaseServices;
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
public class CaseController {
	@Autowired
	private CaseServices caseServices;

	@GetMapping(value = "/cases", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<CaseDto> findAll() {
		return caseServices.findAll();
	}

	@PostMapping(value = "/cases", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CaseDto save(@RequestBody CaseDto caseDto) {
		return caseServices.save(caseDto);
	}
	
	@PutMapping(value = "/cases", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CaseDto update(@RequestBody CaseDto caseEntity) {
		return caseServices.save(caseEntity);
	}

	@DeleteMapping(value = "/cases", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String delete(@RequestBody CaseDto caseEntity) {
		caseServices.delete(caseEntity);
		return "Case deleted";
	}

	@DeleteMapping(value = "/cases/{id}")
	public String delete(@PathVariable ("id")Long id) {
		caseServices.delete(id);
		return "Case deleted";
	}
}
