package com.utad.Platos.Favoritos.services;

import com.utad.Platos.Favoritos.repository.ChefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChefService {

    private final ChefRepository chefRepository;

    @Autowired
    public ChefService(ChefRepository chefRepository) {
        this.chefRepository = chefRepository;
    }
}
