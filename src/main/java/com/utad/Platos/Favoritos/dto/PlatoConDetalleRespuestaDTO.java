package com.utad.Platos.Favoritos.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.utad.Platos.Favoritos.model.Chef;
import com.utad.Platos.Favoritos.model.Ingrediente;

import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PlatoConDetalleRespuestaDTO {

    private String name;
    private Set<Ingrediente> ingredients;
    private Chef chefName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Ingrediente> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingrediente> ingredients) {
        this.ingredients = ingredients;
    }

    public Chef getChefName() {
        return chefName;
    }

    public void setChefName(Chef chefName) {
        this.chefName = chefName;
    }
}