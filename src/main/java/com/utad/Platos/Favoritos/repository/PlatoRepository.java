package com.utad.Platos.Favoritos.repository;


import com.utad.Platos.Favoritos.model.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoRepository extends JpaRepository<Plato, Long> {

    // CRUD Create Read Update Delete

}
