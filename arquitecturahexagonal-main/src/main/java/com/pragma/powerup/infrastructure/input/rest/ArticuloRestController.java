package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.ArticuloRequestDto;
import com.pragma.powerup.application.dto.response.ArticuloResponseDto;
import com.pragma.powerup.application.handler.IArticuloHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/articulos")
@RequiredArgsConstructor
public class ArticuloRestController {

    private final IArticuloHandler articuloHandler;

    @Operation(summary = "Add a new articulo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Articulo created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Articulo already exists", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<Void> saveArticulo(@Valid @RequestBody ArticuloRequestDto articuloRequestDto) {
        articuloHandler.saveArticulo(articuloRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all articulos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All articulos returned", content = @Content),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<ArticuloResponseDto>> getAllArticulos() {
        return ResponseEntity.ok(articuloHandler.getAllArticulos());
    }

    @Operation(summary = "Get paginated and sorted articulos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paginated and sorted articulos returned", content = @Content),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/paginated")
    public ResponseEntity<Page<ArticuloResponseDto>> getPaginatedAndSortedArticulos(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "asc") String sortDirection) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").direction(Sort.Direction.fromString(sortDirection)));
        return ResponseEntity.ok(articuloHandler.getArticulosPaginatedAndSorted(pageable));
    }
}
