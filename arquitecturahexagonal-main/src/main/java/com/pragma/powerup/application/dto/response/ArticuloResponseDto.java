package com.pragma.powerup.application.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class ArticuloResponseDto {
    private Long id;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private double precio;
    private Set<CategoriaResponseDto> categorias;
}
