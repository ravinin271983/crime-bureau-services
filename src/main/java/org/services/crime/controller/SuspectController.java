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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Suspect Controller", description = "Operations related to suspects")
public class SuspectController {
	@Autowired
	private SuspectServices suspectServices;

	@GetMapping(value = "/suspect", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Operation(summary = "Find all suspects", description = "Returns all suspects in system.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return all suspects",
                    content = @Content(schema = @Schema(implementation = SuspectDto.class)))
    })		
	public List<SuspectDto> findAll() {
		return suspectServices.findAll();
	}

	@GetMapping(value = "/suspect/{caseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Operation(summary = "Find all suspects by case id", description = "Returns all suspects related to input case id.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return all suspects by case id",
                    content = @Content(schema = @Schema(implementation = SuspectDto.class)))
    })		
	public List<SuspectDto> findAll(@PathVariable Long caseId) {
		return suspectServices.findAllByCaseId(caseId);
	}
	
	@PostMapping(value = "/suspect", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Create suspect", description = "Create a new suspect.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Suspect created successfully",
                    content = @Content(schema = @Schema(implementation = SuspectDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data",
                    content = @Content(schema = @Schema()))
    })
	public SuspectDto save(@RequestBody SuspectDto suspect) {
		return suspectServices.save(suspect);
	}
	
	@PutMapping(value = "/suspect", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Modify suspect", description = "Modify existing suspect.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Suspect modified successfully",
                    content = @Content(schema = @Schema(implementation = SuspectDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data",
                    content = @Content(schema = @Schema()))
    })
	public SuspectDto update(@RequestBody SuspectDto suspect) {
		return suspectServices.save(suspect);
	}

	@DeleteMapping(value = "/suspect", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Delete suspect", description = "Delete existing suspect by input suspect object.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Suspect deleted successfully",
                    content = @Content(schema = @Schema(implementation = SuspectDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data",
                    content = @Content(schema = @Schema()))
    })
	public String delete(@RequestBody SuspectDto suspect) {
		suspectServices.delete(suspect);
		return "Suspect deleted";
	}
	
	@DeleteMapping(value = "/suspect/{id}")
	@ResponseBody
	@Operation(summary = "Delete suspect", description = "Delete existing suspect by input suspect id.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Suspect deleted successfully",
                    content = @Content(schema = @Schema(implementation = SuspectDto.class))),
            @ApiResponse(responseCode = "404", description = "Invalid request data",
                    content = @Content(schema = @Schema()))
    })
	public String deleteById(@PathVariable("id") Long id) {
		suspectServices.delete(id);
		return "Suspect deleted";
	}
}
