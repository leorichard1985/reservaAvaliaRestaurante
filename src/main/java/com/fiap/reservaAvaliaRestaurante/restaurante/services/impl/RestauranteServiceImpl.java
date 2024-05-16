package com.fiap.reservaAvaliaRestaurante.restaurante.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.reservaAvaliaRestaurante.restaurante.model.jpaStructure.RestauranteJpa;
import com.fiap.reservaAvaliaRestaurante.restaurante.records.Restaurante;
import com.fiap.reservaAvaliaRestaurante.restaurante.repository.RestauranteRepository;
import com.fiap.reservaAvaliaRestaurante.restaurante.services.interfaces.RestauranteService;

@Service
public class RestauranteServiceImpl implements RestauranteService {

	@Autowired
	private RestauranteRepository repository;

	@Override
	public List<Restaurante> BuscarRestaurantePorFiltro(String nomeRestaurante, String enderecoRestaurante,
			String cepRestaurante, String cidadeRestaurante, String estadoRestaurante, String tipoCozinha) {
		
		List<RestauranteJpa> lstJpa = repository.BuscarRestaurantePorFiltro(nomeRestaurante, enderecoRestaurante, cepRestaurante, cidadeRestaurante, estadoRestaurante, tipoCozinha);

		if (lstJpa.isEmpty()) {

			return null;

		} else {

			List<Restaurante> lstRestaurante = new ArrayList<>();

			for (int i = 0; i < lstJpa.size() - 1; i++) {

				Restaurante itemRestaurante = new Restaurante(lstJpa.get(i).idRestaurante, lstJpa.get(i).nomeRestaurante,
						lstJpa.get(i).enderecoRestaurante, lstJpa.get(i).cepRestaurante, lstJpa.get(i).cidadeRestaurante,
						lstJpa.get(i).estadoRestaurante, lstJpa.get(i).tipoCozinha, lstJpa.get(i).horarioFuncionamento,
						lstJpa.get(i).capacidadeReservaTotal, lstJpa.get(i).capacidadeReservaDisponivel);

				lstRestaurante.add(itemRestaurante);

			}

			return lstRestaurante;

		}
	}

	@Override
	public Restaurante BuscarRestaurantePorId(Integer idRestaurante) {

		Optional<RestauranteJpa> optJpa = repository.findById(idRestaurante);

		if (optJpa.isEmpty()) {

			return null;

		} else {

			return new Restaurante(optJpa.get().idRestaurante, optJpa.get().nomeRestaurante,
					optJpa.get().enderecoRestaurante, optJpa.get().cepRestaurante, optJpa.get().cidadeRestaurante,
					optJpa.get().estadoRestaurante, optJpa.get().tipoCozinha, optJpa.get().horarioFuncionamento,
					optJpa.get().capacidadeReservaTotal, optJpa.get().capacidadeReservaDisponivel);

		}
	}

	@Override
	public Restaurante CriarRestaurante(Restaurante objCriarRestaurante) {
		RestauranteJpa restauranteJpa = new RestauranteJpa();

		restauranteJpa.nomeRestaurante = objCriarRestaurante.nomeRestaurante();
		restauranteJpa.enderecoRestaurante = objCriarRestaurante.enderecoRestaurante();
		restauranteJpa.cepRestaurante = objCriarRestaurante.cepRestaurante();
		restauranteJpa.cidadeRestaurante = objCriarRestaurante.cidadeRestaurante();
		restauranteJpa.estadoRestaurante = objCriarRestaurante.estadoRestaurante();
		restauranteJpa.tipoCozinha = objCriarRestaurante.tipoCozinha();
		restauranteJpa.horarioFuncionamento = objCriarRestaurante.horarioFuncionamento();
		restauranteJpa.capacidadeReservaTotal = objCriarRestaurante.capacidadeReservaTotal();
		restauranteJpa.capacidadeReservaDisponivel = objCriarRestaurante.capacidadeReservaDisponivel();

		RestauranteJpa optJpaSaved = repository.save(restauranteJpa);

		return new Restaurante(optJpaSaved.idRestaurante, optJpaSaved.nomeRestaurante, optJpaSaved.enderecoRestaurante,
				optJpaSaved.cepRestaurante, optJpaSaved.cidadeRestaurante, optJpaSaved.estadoRestaurante,
				optJpaSaved.tipoCozinha, optJpaSaved.horarioFuncionamento, optJpaSaved.capacidadeReservaTotal,
				optJpaSaved.capacidadeReservaDisponivel);
	}

}
