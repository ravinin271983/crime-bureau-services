package org.services.crime.controller;

import java.util.List;

import org.services.crime.entity.InvestigatingOfficer;
import org.services.crime.services.InvestigatingOfficerServices;
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
public class InvestigatingOfficerController {
	@Autowired
	private InvestigatingOfficerServices investigatingOfficerServices;

	@GetMapping(value = "/investigatingofficer", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<InvestigatingOfficer> findAll() {
		return investigatingOfficerServices.findAll();
	}

	@PostMapping(value = "/investigatingofficer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public InvestigatingOfficer save(@RequestBody InvestigatingOfficer investigatingOfficer) {
		return investigatingOfficerServices.save(investigatingOfficer);
	}
	
	@PutMapping(value = "/investigatingofficer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public InvestigatingOfficer update(@RequestBody InvestigatingOfficer investigatingOfficer) {
		return investigatingOfficerServices.save(investigatingOfficer);
	}

	@DeleteMapping(value = "/investigatingofficer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String delete(@RequestBody InvestigatingOfficer investigatingOfficer) {
		investigatingOfficerServices.delete(investigatingOfficer);
		return "Investigating Officer deleted";
	}
}
