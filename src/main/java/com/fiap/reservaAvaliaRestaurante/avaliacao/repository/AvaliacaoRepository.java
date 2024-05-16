package com.fiap.reservaAvaliaRestaurante.avaliacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fiap.reservaAvaliaRestaurante.avaliacao.model.jpaStructure.AvaliacaoJpa;

@Repository
public interface AvaliacaoRepository extends JpaRepository<AvaliacaoJpa, Integer>{
	
	@Query(value = "SELECT avaliacao FROM AvaliacaoJpa avaliacao INNER JOIN ReservaJpa reserva ON avaliacao.reserva.idReserva = reserva.idReserva WHERE reserva.restaurante.idRestaurante = ISNULL(:idRestaurante,  reserva.restaurante.idRestaurante) AND reserva.usuario.idUsuario = ISNULL(:idUsuario, reserva.usuario.idUsuario)")
	List<AvaliacaoJpa> BuscarAvaliacoesPorFiltro(@Param(value = "idRestaurante") Integer idRestaurante,@Param(value = "idUsuario") Integer idUsuario );
	
	

}
