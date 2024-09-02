package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.MarcaRequestDto;
import com.pragma.powerup.application.handler.IMarcaHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/marcas")
@RequiredArgsConstructor
public class MarcaRestController {

    private final IMarcaHandler marcaHandler;

    @Operation(summary = "Add a new marca")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Marca created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Marca already exists", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<Void> saveMarca(@Valid @RequestBody MarcaRequestDto marcaRequestDto) {
        marcaHandler.saveMarca(marcaRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all marcas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All marcas returned", content = @Content),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<?> getAllMarcas() {
        return ResponseEntity.ok(marcaHandler.getAllMarcas());
    }
}
