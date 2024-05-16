package com.fiap.reservaAvaliaRestaurante.restaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fiap.reservaAvaliaRestaurante.restaurante.model.jpaStructure.RestauranteJpa;

@Repository
public interface RestauranteRepository extends JpaRepository<RestauranteJpa, Integer> {
	
	@Query(value = "SELECT restaurante FROM tb_Cad_Restaurante restaurante WHERE nomeRestaurante = :nomeRestaurante OR enderecoRestaurante = :enderecoRestaurante OR cepRestaurante = :cepRestaurante OR cidadeRestaurante = :cidadeRestaurante OR estadoRestaurante = :estadoRestaurante OR tipoCozinha = :tipoCozinha", nativeQuery = true)
	public List<RestauranteJpa> BuscarRestaurantePorFiltro(
			@Param(value = "nomeRestaurante") String nomeRestaurante, 
			@Param(value = "enderecoRestaurante") String enderecoRestaurante,
			@Param(value = "cepRestaurante") String cepRestaurante, 
			@Param(value = "cidadeRestaurante") String cidadeRestaurante, 
			@Param(value = "estadoRestaurante") String estadoRestaurante, 
			@Param(value = "tipoCozinha") String tipoCozinha);

}
