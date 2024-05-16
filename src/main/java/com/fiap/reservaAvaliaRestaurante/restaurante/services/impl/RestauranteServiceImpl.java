package com.fiap.reservaAvaliaRestaurante.restaurante.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fiap.reservaAvaliaRestaurante.restaurante.records.Restaurante;
import com.fiap.reservaAvaliaRestaurante.restaurante.services.interfaces.RestauranteService;

@Service
public class RestauranteServiceImpl implements RestauranteService {

	@Override
	public List<Restaurante> BuscarRestaurantePorFiltro(String nomeRestaurante, String enderecoRestaurante,
			String cepRestaurante, String cidadeRestaurante, String estadoRestaurante, String tipoCozinha) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Restaurante BuscarRestaurantePorId(Integer idAvaliacao) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Restaurante CriarRestaurante(Restaurante objCriarRestaurante) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
