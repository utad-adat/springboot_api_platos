package com.utad.Platos.Favoritos.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
public class Chef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "chef")
    private Set<Plato> platos = new HashSet<>();

}