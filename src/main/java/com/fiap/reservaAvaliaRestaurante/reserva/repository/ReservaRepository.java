package com.fiap.reservaAvaliaRestaurante.reserva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fiap.reservaAvaliaRestaurante.reserva.model.jpaStructure.ReservaJpa;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaJpa, Integer> {
	
	@Query(value = "SELECT reserva FROM ReservaJpa reserva WHERE reserva.restaurante.idRestaurante = :idRestaurante OR reserva.usuario.idUsuario = :idUsuario")
	public List<ReservaJpa> BuscarReservaPorFiltro(@Param(value = "idRestaurante") Integer idRestaurante, @Param(value = "idUsuario") Integer idUsuario);
	

}
