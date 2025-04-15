package org.services.crime.controller;

import java.util.List;

import org.services.crime.entity.Suspect;
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
	public List<Suspect> findAll() {
		return suspectServices.findAll();
	}

	@GetMapping(value = "/suspect/{caseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Suspect> findAll(@PathVariable Long caseId) {
		return suspectServices.findAllByCaseId(caseId);
	}
	
	@PostMapping(value = "/suspect", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Suspect save(@RequestBody Suspect suspect) {
		return suspectServices.save(suspect);
	}
	
	@PutMapping(value = "/suspect", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Suspect update(@RequestBody Suspect suspect) {
		return suspectServices.save(suspect);
	}

	@DeleteMapping(value = "/suspect", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String delete(@RequestBody Suspect suspect) {
		suspectServices.delete(suspect);
		return "Suspect deleted";
	}
}
