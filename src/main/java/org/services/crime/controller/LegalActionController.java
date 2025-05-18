package org.services.crime.controller;

import java.util.List;

import org.services.crime.dto.LegalActionDto;
import org.services.crime.services.LegalActionServices;
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
@Tag(name = "Legal Action Controller", description = "Operations related to legalaction")
public class LegalActionController {
	@Autowired
	private LegalActionServices legalActionServices;

	@GetMapping(value = "/legalaction", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Operation(summary = "Find all legal action", description = "Returns all legal actions in system.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return all legal actions",
                    content = @Content(schema = @Schema(implementation = LegalActionDto.class)))
    })	
	public List<LegalActionDto> findAll() {
		return legalActionServices.findAll();
	}

	@GetMapping(value = "/legalaction/{caseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Operation(summary = "Find legal action by case id", description = "Returns all legal action related to input case id.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return all legal actions for input case id",
                    content = @Content(schema = @Schema(implementation = LegalActionDto.class)))
    })
	public List<LegalActionDto> findAll(@PathVariable Long caseId) {
		return legalActionServices.findAllByCaseId(caseId);
	}
	
	@PostMapping(value = "/legalaction", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Create legal action", description = "Create a new legal action.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Legal action created successfully",
                    content = @Content(schema = @Schema(implementation = LegalActionDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data",
                    content = @Content(schema = @Schema()))
    })
	public LegalActionDto save(@RequestBody LegalActionDto legalAction) {
		return legalActionServices.save(legalAction);
	}
	
	@PutMapping(value = "/legalaction", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Modify legal action", description = "Modify existing legal.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Legal action modified successfully",
                    content = @Content(schema = @Schema(implementation = LegalActionDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data",
                    content = @Content(schema = @Schema()))
    })
	public LegalActionDto update(@RequestBody LegalActionDto legalAction) {
		return legalActionServices.save(legalAction);
	}

	@DeleteMapping(value = "/legalaction")
	@ResponseBody
	@Operation(summary = "Delete legal action", description = "Delete existing legal action by input legalAction object.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Legal action deleted successfully",
                    content = @Content(schema = @Schema(implementation = LegalActionDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data",
                    content = @Content(schema = @Schema()))
    })
	public String delete(@RequestBody LegalActionDto legalAction) {
		legalActionServices.delete(legalAction);
		return "Legal Action deleted";
	}

	@DeleteMapping(value = "/legalaction/{id}")
	@ResponseBody
	@Operation(summary = "Delete legal action", description = "Delete existing legal action by input id.")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Legal action deleted successfully",
                    content = @Content(schema = @Schema(implementation = LegalActionDto.class))),
            @ApiResponse(responseCode = "404", description = "Invalid request data",
                    content = @Content(schema = @Schema()))
    })
	public String delete(@PathVariable("id") Long id) {
		legalActionServices.delete(id);
		return "Legal Action deleted";
	}

}
