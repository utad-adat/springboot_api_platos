package com.utad.Platos.Favoritos.controller;

import com.utad.Platos.Favoritos.model.Plato;
import com.utad.Platos.Favoritos.services.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
