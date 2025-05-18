package org.services.crime.controller;

import java.util.List;

import org.services.crime.dto.SuspectDto;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Victim Controller", description = "Operations related to victims")
public class VictimController {
	@Autowired
	private VictimServices victimServices;

	@GetMapping(value = "/victim", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Operation(summary = "Find all victims", description = "Returns all victims in system.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return all victims",
                    content = @Content(schema = @Schema(implementation = VictimDto.class)))
    })		
	public List<VictimDto> findAll() {
		return victimServices.findAll();
	}

	@GetMapping(value = "/victim/{caseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Operation(summary = "Find victims by case id", description = "Returns all victims related to input case id.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return all victims by case id",
                    content = @Content(schema = @Schema(implementation = VictimDto.class)))
    })		
	public List<VictimDto> findAll(@PathVariable Long caseId) {
		return victimServices.findAllByCaseId(caseId);
	}
	
	@PostMapping(value = "/victim", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Create victim", description = "Create a new victim.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Victim created successfully",
                    content = @Content(schema = @Schema(implementation = VictimDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data",
                    content = @Content(schema = @Schema()))
    })
	public VictimDto save(@RequestBody VictimDto suspect) {
		return victimServices.save(suspect);
	}
	
	@PutMapping(value = "/victim", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Modify victim", description = "Modify existing victim.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Victim modified successfully",
                    content = @Content(schema = @Schema(implementation = VictimDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data",
                    content = @Content(schema = @Schema()))
    })
	public VictimDto update(@RequestBody VictimDto suspect) {
		return victimServices.save(suspect);
	}

	@DeleteMapping(value = "/victim", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Delete victim", description = "Delete existing victim by input victim object.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Victim deleted successfully",
                    content = @Content(schema = @Schema(implementation = VictimDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data",
                    content = @Content(schema = @Schema()))
    })	
	public String delete(@RequestBody VictimDto suspect) {
		victimServices.delete(suspect);
		return "Victim deleted";
	}

	@DeleteMapping(value = "/victim/{id}")
	@ResponseBody
	@Operation(summary = "Delete victim", description = "Delete existing victim by input victim id.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Victim deleted successfully",
                    content = @Content(schema = @Schema(implementation = VictimDto.class))),
            @ApiResponse(responseCode = "404", description = "Invalid request data",
                    content = @Content(schema = @Schema()))
    })
	public String delete(@PathVariable("id") Long id) {
		victimServices.delete(id);
		return "Victim deleted";
	}
}
