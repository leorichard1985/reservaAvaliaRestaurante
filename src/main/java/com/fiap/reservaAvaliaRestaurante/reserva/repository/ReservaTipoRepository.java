package com.fiap.reservaAvaliaRestaurante.reserva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.reservaAvaliaRestaurante.reserva.model.jpaStructure.ReservaTipoJpa;

@Repository
public interface ReservaTipoRepository  extends JpaRepository<ReservaTipoJpa, Integer> {

}
