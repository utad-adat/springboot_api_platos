package com.utad.Platos.Favoritos.dto;

import java.util.HashSet;
import java.util.Set;

public class PlatoConIngredientesDTO {

    private String name;
    private Set<Long> ingredientsIds = new HashSet<>();

    private Long chef;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Long> getIngredientsIds() {
        return ingredientsIds;
    }

    public void setIngredientsIds(Set<Long> ingredientsIds) {
        this.ingredientsIds = ingredientsIds;
    }

    public Long getChef() {
        return chef;
    }

    public void setChef(Long chef) {
        this.chef = chef;
    }
}