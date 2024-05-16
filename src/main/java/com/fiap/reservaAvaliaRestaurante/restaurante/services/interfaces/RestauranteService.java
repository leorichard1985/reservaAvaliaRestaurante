package com.fiap.reservaAvaliaRestaurante.restaurante.services.interfaces;

import java.util.List;

import com.fiap.reservaAvaliaRestaurante.restaurante.records.Restaurante;

public interface RestauranteService {

	List<Restaurante> BuscarRestaurantePorFiltro(String nomeRestaurante, String enderecoRestaurante,
			String cepRestaurante, String cidadeRestaurante, String estadoRestaurante, String tipoCozinha);

	Restaurante BuscarRestaurantePorId(Integer idAvaliacao);

	Restaurante CriarRestaurante(Restaurante objCriarRestaurante);

}
