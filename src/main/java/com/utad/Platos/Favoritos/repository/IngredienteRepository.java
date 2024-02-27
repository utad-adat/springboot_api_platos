package com.utad.Platos.Favoritos.repository;

import com.utad.Platos.Favoritos.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
}
