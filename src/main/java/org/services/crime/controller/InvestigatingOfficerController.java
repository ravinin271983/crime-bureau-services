package org.services.crime.controller;

import java.util.List;

import org.services.crime.dto.InvestigatingOfficerDto;
import org.services.crime.services.InvestigatingOfficerServices;
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
public class InvestigatingOfficerController {
	@Autowired
	private InvestigatingOfficerServices investigatingOfficerServices;

	@GetMapping(value = "/investigatingofficer", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<InvestigatingOfficerDto> findAll() {
		return investigatingOfficerServices.findAll();
	}

	@PostMapping(value = "/investigatingofficer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public InvestigatingOfficerDto save(@RequestBody InvestigatingOfficerDto investigatingOfficer) {
		return investigatingOfficerServices.save(investigatingOfficer);
	}
	
	@PutMapping(value = "/investigatingofficer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public InvestigatingOfficerDto update(@RequestBody InvestigatingOfficerDto investigatingOfficer) {
		return investigatingOfficerServices.save(investigatingOfficer);
	}

	@DeleteMapping(value = "/investigatingofficer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String delete(@RequestBody InvestigatingOfficerDto investigatingOfficer) {
		investigatingOfficerServices.delete(investigatingOfficer);
		return "Investigating Officer deleted";
	}
	
	@DeleteMapping(value = "/investigatingofficer/{id}")
	public String delete(@PathVariable("id") Long id) {
		investigatingOfficerServices.delete(id);
		return "Investigating Officer deleted";
	}
}
