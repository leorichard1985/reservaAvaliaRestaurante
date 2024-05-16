package com.fiap.reservaAvaliaRestaurante.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.reservaAvaliaRestaurante.restaurante.model.jpaStructure.RestauranteJpa;

@Repository
public interface RestauranteRepository extends JpaRepository<RestauranteJpa, Integer> {

}
