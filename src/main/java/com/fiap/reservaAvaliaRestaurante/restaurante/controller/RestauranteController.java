package com.fiap.reservaAvaliaRestaurante.restaurante.controller;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.reservaAvaliaRestaurante.restaurante.records.Restaurante;
import com.fiap.reservaAvaliaRestaurante.restaurante.services.interfaces.RestauranteService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

	@Autowired
	private RestauranteService service;

	@GetMapping
	public CompletableFuture<ResponseEntity<Object>> BuscarRestaurantePorFiltro(
			@RequestParam(value = "nomeRestaurante", required = true) String nomeRestaurante,
			@RequestParam(value = "enderecoRestaurante", required = true) String enderecoRestaurante,
			@RequestParam(value = "cepRestaurante", required = true) String cepRestaurante,
			@RequestParam(value = "cidadeRestaurante", required = true) String cidadeRestaurante,
			@RequestParam(value = "estadoRestaurante", required = true) String estadoRestaurante,
			@RequestParam(value = "tipoCozinha", required = true) String tipoCozinha) {

		try {

			List<Restaurante> restaurante = service.BuscarRestaurantePorFiltro(nomeRestaurante, enderecoRestaurante,
					cepRestaurante, cidadeRestaurante, estadoRestaurante, tipoCozinha);

			if (Objects.isNull(restaurante)) {
				return CompletableFuture.completedFuture(ResponseEntity.noContent().build());
			} else {
				return CompletableFuture.completedFuture(ResponseEntity.ok().body(restaurante));
			}

		} catch (DataIntegrityViolationException e) {

			return CompletableFuture.completedFuture(ResponseEntity.badRequest().body(e));
		}
	}

	@GetMapping("/{idRestaurante}")
	public CompletableFuture<ResponseEntity<Object>> BuscarRestaurantePorId(
			@PathVariable("idRestaurante") Integer idAvaliacao) {

		try {

			Restaurante restaurante = service.BuscarRestaurantePorId(idAvaliacao);

			if (Objects.isNull(restaurante)) {
				return CompletableFuture.completedFuture(ResponseEntity.noContent().build());
			} else {
				return CompletableFuture.completedFuture(ResponseEntity.ok().body(restaurante));
			}

		} catch (DataIntegrityViolationException e) {

			return CompletableFuture.completedFuture(ResponseEntity.badRequest().body(e));
		}

	}

	@PostMapping()
	@Transactional
	public CompletableFuture<ResponseEntity<Object>> CriarRestaurante(@RequestBody Restaurante objCriarRestaurante)
			throws URISyntaxException {

		try {
			Restaurante restaurante = service.CriarRestaurante(objCriarRestaurante);

			if (Objects.isNull(restaurante)) {
				return CompletableFuture.completedFuture(ResponseEntity.noContent().build());
			} else {
				return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.CREATED).body(restaurante));
			}

		} catch (DataIntegrityViolationException e) {

			return CompletableFuture.completedFuture(ResponseEntity.badRequest().body(e));
		}

	}

}
