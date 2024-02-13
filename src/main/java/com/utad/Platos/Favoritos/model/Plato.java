package com.utad.Platos.Favoritos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "fav_platos")
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String restaurant;

    /**
     * @ManyToMany: Indica una relación many-to-many entre entidades.
     * @JoinTable: Permite personalizar la tabla de unión utilizada para la relación many-to-many.
     * @JoinColumn: Especifica la columna que se utilizará para la unión en la tabla de unión.
     * @MappedBy: Indica el campo en el lado inverso de la relación (en este caso, en la clase Ingrediente), evitando la duplicación de información sobre la relación.
     */

    @ManyToMany
    @JoinTable(name = "plato_ingrediente",
            joinColumns = @JoinColumn(name = "plato_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))
    private Set<Ingrediente> ingredientes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "chef_id")
    private Chef chef;

}
