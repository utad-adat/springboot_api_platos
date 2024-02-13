package com.utad.Platos.Favoritos.controller;

import com.utad.Platos.Favoritos.dto.PlatoConDetalleRespuestaDTO;
import com.utad.Platos.Favoritos.dto.PlatoConIngredientesDTO;
import com.utad.Platos.Favoritos.model.Plato;
import com.utad.Platos.Favoritos.services.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/platos")
public class PlatoController {

    private final PlatoService platoService;

    @Autowired
    public PlatoController(PlatoService platoService) {
        this.platoService = platoService;
    }

    @GetMapping
    public ResponseEntity<List<Plato> > getAll() {
        List<Plato> list = platoService.getPlatos();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<Plato> save(@RequestBody Plato plato) {
        Plato newPlato = platoService.save(plato);
        return ResponseEntity.ok(newPlato);
    }

    @PostMapping("/completo")
    public ResponseEntity<String> crearPlatoConIngredientes(@RequestBody PlatoConIngredientesDTO platoDTO) {
        try {
            // Aquí podrías realizar validaciones adicionales si es necesario

            // Llama al servicio para crear el plato con ingredientes
            platoService.crearPlatoConIngredientes(platoDTO);

            return ResponseEntity.ok("Plato creado con éxito.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el plato.");
        }
    }

    @GetMapping("getAllPlatos")
    public List<PlatoConDetalleRespuestaDTO> getAllPlatosConDetalle() {
        return platoService.getAllPlatosConDetalle();
    }
}
