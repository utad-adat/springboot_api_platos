package com.utad.Platos.Favoritos.services;

import com.utad.Platos.Favoritos.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IngredienteService {

    private final IngredienteRepository ingredienteRepository;

    @Autowired
    public IngredienteService(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }
}
