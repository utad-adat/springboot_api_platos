package com.utad.Platos.Favoritos.repository;

import com.utad.Platos.Favoritos.model.Chef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefRepository extends JpaRepository<Chef, Long> {
}
