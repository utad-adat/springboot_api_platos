package com.utad.Platos.Favoritos.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "fav_platos")
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String restaturant;
}
