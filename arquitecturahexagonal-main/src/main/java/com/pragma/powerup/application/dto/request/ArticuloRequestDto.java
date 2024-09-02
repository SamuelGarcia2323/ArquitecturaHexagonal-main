package com.pragma.powerup.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Set;

@Getter
@Setter
public class ArticuloRequestDto {

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 50, message = "El tamaño máximo del nombre es de 50 caracteres")
    private String nombre;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(max = 120, message = "El tamaño máximo de la descripción es de 120 caracteres")
    private String descripcion;

    @Positive(message = "La cantidad debe ser positiva")
    private int cantidad;

    @Positive(message = "El precio debe ser positivo")
    private double precio;

    @Size(min = 1, max = 3, message = "Debe tener entre 1 y 3 categorías")
    private Set<Long> categoriaIds;
}
