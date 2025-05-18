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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Case Controller", description = "Operations related to cases")
public class CaseController {
	@Autowired
	private CaseServices caseServices;

	@GetMapping(value = "/cases", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Operation(summary = "Get all cases", description = "Returns all cases available in system.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List all cases",
                    content = @Content(schema = @Schema(implementation = CaseDto.class)))
    })
	public List<CaseDto> findAll() {
		return caseServices.findAll();
	}

	@PostMapping(value = "/cases", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Create case", description = "Create a new case.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Case created successfully",
                    content = @Content(schema = @Schema(implementation = CaseDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data",
                    content = @Content(schema = @Schema()))
    })
	public CaseDto save(@RequestBody CaseDto caseDto) {
		return caseServices.save(caseDto);
	}
	
	@PutMapping(value = "/cases", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Modify case", description = "Modify existing case.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Case modified successfully",
                    content = @Content(schema = @Schema(implementation = CaseDto.class)))
    })
	public CaseDto update(@RequestBody CaseDto caseEntity) {
		return caseServices.save(caseEntity);
	}

	@DeleteMapping(value = "/cases", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Delete case", description = "Delete case by input case object.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Case deleted successfully",
                    content = @Content(schema = @Schema(implementation = CaseDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data",
                    content = @Content(schema = @Schema()))
    })
	public String delete(@RequestBody CaseDto caseEntity) {
		caseServices.delete(caseEntity);
		return "Case deleted";
	}

	@DeleteMapping(value = "/cases/{id}")
	@Operation(summary = "Delete case", description = "Delete case by input case id.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Case deleted successfully",
                    content = @Content(schema = @Schema(implementation = CaseDto.class))),
            @ApiResponse(responseCode = "404", description = "Invalid case id",
                    content = @Content(schema = @Schema()))
    })	
	public String delete(@PathVariable ("id")Long id) {
		caseServices.delete(id);
		return "Case deleted";
	}
}
