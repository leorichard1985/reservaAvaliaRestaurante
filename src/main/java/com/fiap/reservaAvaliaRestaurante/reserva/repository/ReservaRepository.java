package com.fiap.reservaAvaliaRestaurante.reserva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fiap.reservaAvaliaRestaurante.reserva.model.jpaStructure.ReservaJpa;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaJpa, Integer> {
	
	@Query(value = "SELECT reserva ReservaJpa reserva WHERE reserva.restaurante.idRestaurante = ISNULL(:idRestaurante,  reserva.idRestaurante) AND reserva.usuario.idUsuario = ISNULL(:idUsuario, reserva.idUsuario)")
	List<ReservaJpa> BuscarReservaPorFiltro(@Param(value = "idRestaurante") Integer idRestaurante, @Param(value = "idUsuario") Integer idUsuario);
	

}
