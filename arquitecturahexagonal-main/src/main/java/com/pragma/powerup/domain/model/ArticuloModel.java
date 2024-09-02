package com.pragma.powerup.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloModel {
    private Long id;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private double precio;
    private Set<CategoriaModel> categorias;
}
