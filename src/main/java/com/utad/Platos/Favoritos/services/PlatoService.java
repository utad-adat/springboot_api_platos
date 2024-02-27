package com.utad.Platos.Favoritos.services;

import com.utad.Platos.Favoritos.dto.RequestPlatoConIngredientesDTO;
import com.utad.Platos.Favoritos.model.Chef;
import com.utad.Platos.Favoritos.model.Ingrediente;
import com.utad.Platos.Favoritos.model.Plato;
import com.utad.Platos.Favoritos.repository.ChefRepository;
import com.utad.Platos.Favoritos.repository.IngredienteRepository;
import com.utad.Platos.Favoritos.repository.PlatoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class PlatoService {

    private final PlatoRepository platoRepository;
    private final ChefRepository chefRepository;
    private final IngredienteRepository ingredienteRepository;

    @Autowired
    public PlatoService(PlatoRepository platoRepository, ChefRepository chefRepository, IngredienteRepository ingredienteRepository) {
        this.platoRepository = platoRepository;
        this.chefRepository = chefRepository;
        this.ingredienteRepository = ingredienteRepository;
    }

    public List<Plato> getPlatos() {
        return platoRepository.findAll();
    }

    public Plato save(Plato plato){
        return platoRepository.save(plato);
    }

    @Transactional
    public Plato createPlatoConIngredientesYChef(RequestPlatoConIngredientesDTO platoDTO) {
        // Crear plato nuevo
        Plato plato = new Plato();
        plato.setName(platoDTO.getName());

        // Con los id que nos llegan buscarlos
        List<Ingrediente> ingredientes = ingredienteRepository.findAllById(platoDTO.getIngredientList());

        // Esos ingredientes meterlos en el Plato
        plato.setIngredientes(new HashSet<>(ingredientes));

        // Buscamos al chef por id y lo añadmos
        Chef chef = chefRepository.findById(platoDTO.getChef()).orElseThrow( () -> new RuntimeException("Chef no encontrado"));
        plato.setChef(chef);

        // Guardamos el plato en la bbdd
        return platoRepository.save(plato);
    }
}
