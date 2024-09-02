package com.pragma.powerup.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Table(name = "articulo")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ArticuloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String nombre;

    @Column(length = 120, nullable = false)
    private String descripcion;

    @Positive(message = "La cantidad debe ser positiva")
    private int cantidad;

    @Positive(message = "El precio debe ser positivo")
    private double precio;

    @ManyToMany
    @JoinTable(
            name = "articulo_categoria",
            joinColumns = @JoinColumn(name = "articulo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private Set<CategoriaEntity> categorias = new HashSet<>();
}
