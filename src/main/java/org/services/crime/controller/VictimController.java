package org.services.crime.controller;

import java.util.List;

import org.services.crime.dto.VictimDto;
import org.services.crime.services.VictimServices;
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
public class VictimController {
	@Autowired
	private VictimServices victimServices;

	@GetMapping(value = "/victim", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<VictimDto> findAll() {
		return victimServices.findAll();
	}

	@GetMapping(value = "/victim/{caseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<VictimDto> findAll(@PathVariable Long caseId) {
		return victimServices.findAllByCaseId(caseId);
	}
	
	@PostMapping(value = "/victim", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public VictimDto save(@RequestBody VictimDto suspect) {
		return victimServices.save(suspect);
	}
	
	@PutMapping(value = "/victim", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public VictimDto update(@RequestBody VictimDto suspect) {
		return victimServices.save(suspect);
	}

	@DeleteMapping(value = "/victim", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String delete(@RequestBody VictimDto suspect) {
		victimServices.delete(suspect);
		return "Victim deleted";
	}

	@DeleteMapping(value = "/victim/{id}")
	@ResponseBody
	public String delete(@PathVariable("id") Long id) {
		victimServices.delete(id);
		return "Victim deleted";
	}

}
