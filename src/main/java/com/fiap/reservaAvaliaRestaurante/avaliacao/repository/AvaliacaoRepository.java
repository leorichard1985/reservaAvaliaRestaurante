package com.fiap.reservaAvaliaRestaurante.avaliacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fiap.reservaAvaliaRestaurante.avaliacao.model.jpaStructure.AvaliacaoJpa;

@Repository
public interface AvaliacaoRepository extends JpaRepository<AvaliacaoJpa, Integer>{
	
	@Query(value = "SELECT avaliacao FROM tb_CAD_Avaliacao avaliacao INNER JOIN tb_CAD_Reserva reserva ON avaliacao.idReserva = reserva.idReserva WHERE reserva.idRestaurante = :idRestaurante AND reserva.idUsuario = :idUsuario", nativeQuery = true)
	public List<AvaliacaoJpa> BuscarAvaliacoesPorFiltro(
			@Param(value = "idRestaurante") Integer idRestaurante,
			@Param(value = "idUsuario") Integer idUsuario );
	
	

}
