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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Investigating Officer Controller", description = "Operations related to investigatingofficer")
public class InvestigatingOfficerController {
	@Autowired
	private InvestigatingOfficerServices investigatingOfficerServices;

	@GetMapping(value = "/investigatingofficer", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Operation(summary = "Find all investigating officer", description = "Return all investigating officers in system.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return all investigating officers",
                    content = @Content(schema = @Schema(implementation = InvestigatingOfficerDto.class)))
    })	
	public List<InvestigatingOfficerDto> findAll() {
		return investigatingOfficerServices.findAll();
	}

	@PostMapping(value = "/investigatingofficer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Create investigating officer", description = "Create new investigating officer.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Investigating officer created successfully",
                    content = @Content(schema = @Schema(implementation = InvestigatingOfficerDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data",
                    content = @Content(schema = @Schema()))
    })
	public InvestigatingOfficerDto save(@RequestBody InvestigatingOfficerDto investigatingOfficer) {
		return investigatingOfficerServices.save(investigatingOfficer);
	}
	
	@PutMapping(value = "/investigatingofficer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Modify investigating officer", description = "Modify investigating officer.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Investigating officer modified successfully",
                    content = @Content(schema = @Schema(implementation = InvestigatingOfficerDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data",
                    content = @Content(schema = @Schema()))
    })
	public InvestigatingOfficerDto update(@RequestBody InvestigatingOfficerDto investigatingOfficer) {
		return investigatingOfficerServices.save(investigatingOfficer);
	}

	@DeleteMapping(value = "/investigatingofficer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Delete investigating officer", description = "Delete existing investigating officer by input investigatingOfficer object.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Investigating officer deleted successfully",
                    content = @Content(schema = @Schema(implementation = InvestigatingOfficerDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data",
                    content = @Content(schema = @Schema()))
    })	
	public String delete(@RequestBody InvestigatingOfficerDto investigatingOfficer) {
		investigatingOfficerServices.delete(investigatingOfficer);
		return "Investigating Officer deleted";
	}
	
	@DeleteMapping(value = "/investigatingofficer/{id}")
	@Operation(summary = "Delete investigating officer", description = "Delete existing investigating officer by input id.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Investigating officer deleted successfully",
                    content = @Content(schema = @Schema(implementation = InvestigatingOfficerDto.class))),
            @ApiResponse(responseCode = "404", description = "Invalid investigating officer id",
                    content = @Content(schema = @Schema()))
    })	
	public String delete(@PathVariable("id") Long id) {
		investigatingOfficerServices.delete(id);
		return "Investigating Officer deleted";
	}
}
