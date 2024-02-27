package com.utad.Platos.Favoritos.controller;

import com.utad.Platos.Favoritos.dto.RequestPlatoConIngredientesDTO;
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

   @GetMapping("/todos")
    public ResponseEntity<Boolean> todosLosPlatos() {
        return ResponseEntity.ok(true);
    }

    @PostMapping("/completo")
    public ResponseEntity<Plato> addPlatoCompleto(@RequestBody RequestPlatoConIngredientesDTO req) {
        Plato platoCreated = platoService.createPlatoConIngredientesYChef(req);
        return ResponseEntity.ok(platoCreated);
    }
}
