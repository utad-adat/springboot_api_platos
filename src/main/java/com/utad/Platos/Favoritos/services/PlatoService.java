package com.utad.Platos.Favoritos.services;

import com.utad.Platos.Favoritos.dto.PlatoConDetalleRespuestaDTO;
import com.utad.Platos.Favoritos.dto.PlatoConIngredientesDTO;
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
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PlatoService {

    private final PlatoRepository platoRepository;
    private final IngredienteRepository ingredienteRepository;
    private final ChefRepository chefRepository;

    @Autowired
    public PlatoService(PlatoRepository platoRepository, IngredienteRepository ingredienteRepository, ChefRepository chefRepository) {
        this.platoRepository = platoRepository;
        this.ingredienteRepository = ingredienteRepository;
        this.chefRepository = chefRepository;
    }

    public List<Plato> getPlatos() {
        return platoRepository.findAll();
    }

    public Plato save(Plato plato){
        return platoRepository.save(plato);
    }

    //  Spring se encarga de administrar la transacción para ese método. Si la transacción se completa correctamente, los cambios realizados en la base de datos se confirman. Si ocurre algún error, la transacción se revierte, y los cambios se deshacen (rollback).
    @Transactional
    public void crearPlatoConIngredientes(PlatoConIngredientesDTO platoDTO) {
        // Crea un nuevo plato
        Plato plato = new Plato();
        plato.setName(platoDTO.getName());

        // Recupera los ingredientes por sus IDs
        List<Ingrediente> ingredientes = ingredienteRepository.findAllById(platoDTO.getIngredientsIds());

        // Asocia los ingredientes al plato
        plato.setIngredientes(new HashSet<>(ingredientes));

        Chef chef = chefRepository.findById(platoDTO.getChef()).orElseThrow(() -> new RuntimeException("Chef no encontrado"));
        plato.setChef(chef);

        // Guarda el plato en la base de datos
        platoRepository.save(plato);
    }



    @Transactional
    public List<PlatoConDetalleRespuestaDTO> getAllPlatosConDetalle() {
        List<Plato> platos = platoRepository.findAll();
        return platos.stream().map(this::mapPlatoToDTO).collect(Collectors.toList());
    }

    private PlatoConDetalleRespuestaDTO mapPlatoToDTO(Plato plato) {
        PlatoConDetalleRespuestaDTO platoDTO = new PlatoConDetalleRespuestaDTO();
        platoDTO.setName(plato.getName());

        Set<Ingrediente> ingredientesDTO = plato.getIngredientes().stream()
                .map(this::mapIngredienteToDTO)
                .collect(Collectors.toSet());

        platoDTO.setIngredients(ingredientesDTO);

        if (plato.getChef() != null) {
            platoDTO.setChefName(mapChefToDTO(plato.getChef()));
        }

        return platoDTO;
    }

    private Chef mapChefToDTO(Chef chef) {
        Chef chefDTO = new Chef();
        chefDTO.setId(chef.getId());
        chefDTO.setNombre(chef.getNombre());
        return chefDTO;
    }

    private Ingrediente mapIngredienteToDTO(Ingrediente ingrediente) {
        Ingrediente ingredienteDTO = new Ingrediente();
        ingredienteDTO.setId(ingrediente.getId());
        ingredienteDTO.setNombre(ingrediente.getNombre());
        return ingredienteDTO;
    }

}
