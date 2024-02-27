package com.utad.Platos.Favoritos.dto;

import com.utad.Platos.Favoritos.model.Chef;
import com.utad.Platos.Favoritos.model.Ingrediente;

import java.util.Set;

public class ResponsePlatoDTO {

    private Long idPlato;
    private String namePlato;
    private Set<Ingrediente> ingredientes;

    private Chef chef;

    /**
     *  {
     *         "name": "Otra Costillas",
     *         "ingredients": [
     *             {
     *                 "id": 2,
     *                 "nombre": "Tomate"
     *             },
     *             {
     *                 "id": 1,
     *                 "nombre": "Mozzarella"
     *             }
     *         ],
     *         "chefName": {
     *             "id": 1,
     *             "nombre": "Paco"
     *         }
     *     }
     */
}
