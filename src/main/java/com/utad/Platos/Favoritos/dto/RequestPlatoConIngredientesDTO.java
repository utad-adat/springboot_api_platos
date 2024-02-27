package com.utad.Platos.Favoritos.dto;

import java.util.HashSet;
import java.util.Set;

public class RequestPlatoConIngredientesDTO {

    private String name;
    private Set<Long> ingredientList = new HashSet<>();
    private Long chef;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Long> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(Set<Long> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public Long getChef() {
        return chef;
    }

    public void setChef(Long chef) {
        this.chef = chef;
    }
}
