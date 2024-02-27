package com.utad.Platos.Favoritos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Chef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double nota;

    @OneToMany(mappedBy = "chef")
    private Set<Plato> platos = new HashSet<>();
}
