package com.fiap.reservaAvaliaRestaurante.avaliacao.controller;

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

import com.fiap.reservaAvaliaRestaurante.avaliacao.records.Avaliacao;
import com.fiap.reservaAvaliaRestaurante.avaliacao.services.interfaces.AvaliacaoService;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

	@Autowired
	private AvaliacaoService service;

	@GetMapping
	public CompletableFuture<ResponseEntity<Object>> BuscarAvaliacoesPorFiltro(
			@RequestParam(value = "idRestaurante", required = false) Integer idRestaurante,
			@RequestParam(value = "idUsuario", required = false) Integer idUsuario) {

		try {

			List<Avaliacao> avaliacao = service.BuscarAvaliacoesPorFiltro(idRestaurante, idUsuario);

			if (Objects.isNull(avaliacao)) {
				return CompletableFuture.completedFuture(ResponseEntity.noContent().build());
			} else {
				return CompletableFuture.completedFuture(ResponseEntity.ok().body(avaliacao));
			}

		} catch (DataIntegrityViolationException e) {

			return CompletableFuture.completedFuture(ResponseEntity.badRequest().body(e));
		}
	}

	@GetMapping("/{idAvaliacao}")
	public CompletableFuture<ResponseEntity<Object>> BuscarAvaliacaoPorId(
			@PathVariable("idAvaliacao") Integer idAvaliacao) {

		try {

			Avaliacao avaliacao = service.BuscarAvaliacaoPorId(idAvaliacao);

			if (Objects.isNull(avaliacao)) {
				return CompletableFuture.completedFuture(ResponseEntity.noContent().build());
			} else {
				return CompletableFuture.completedFuture(ResponseEntity.ok().body(avaliacao));
			}

		} catch (DataIntegrityViolationException e) {

			return CompletableFuture.completedFuture(ResponseEntity.badRequest().body(e));
		}

	}

	@PostMapping()
	@Transactional
	public CompletableFuture<ResponseEntity<Object>> CriarAvaliacao(@RequestBody Avaliacao objCriarAvaliacao)
			throws URISyntaxException {

		try {

			Avaliacao avaliacao = service.CriarAvaliacao(objCriarAvaliacao);

			if (Objects.isNull(avaliacao)) {
				return CompletableFuture.completedFuture(ResponseEntity.noContent().build());
			} else {
				return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.CREATED).body(avaliacao));
			}

		} catch (DataIntegrityViolationException e) {

			return CompletableFuture.completedFuture(ResponseEntity.badRequest().body(e));
		}

	}

}
