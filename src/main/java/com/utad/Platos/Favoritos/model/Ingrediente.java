package com.utad.Platos.Favoritos.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany(mappedBy = "ingredientes")
    private Set<Plato> platos = new HashSet<>();


}