package com.utad.Platos.Favoritos.services;

import com.utad.Platos.Favoritos.model.Plato;
import com.utad.Platos.Favoritos.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoService {

    private final PlatoRepository platoRepository;


    @Autowired
    public PlatoService(PlatoRepository platoRepository) {
        this.platoRepository = platoRepository;
    }

    public List<Plato> getPlatos() {
        return platoRepository.findAll();
    }

}
