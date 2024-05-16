package com.fiap.reservaAvaliaRestaurante.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.reservaAvaliaRestaurante.usuario.model.jpaStructure.UsuarioJpa;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioJpa, Integer> {

}
