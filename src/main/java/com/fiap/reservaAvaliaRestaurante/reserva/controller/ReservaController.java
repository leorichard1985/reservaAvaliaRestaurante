package com.fiap.reservaAvaliaRestaurante.reserva.controller;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.reservaAvaliaRestaurante.reserva.records.Reserva;
import com.fiap.reservaAvaliaRestaurante.reserva.services.interfaces.ReservaService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired
	private ReservaService service;

	@GetMapping
	public CompletableFuture<ResponseEntity<Object>> BuscarReservaPorFiltro(
			@RequestParam(value = "idRestaurante", required = false) Integer idRestaurante,
			@RequestParam(value = "idUsuario", required = false) Integer idUsuario) {

		try {

			List<Reserva> reserva = service.BuscarReservaPorFiltro(idRestaurante, idUsuario);

			if (Objects.isNull(reserva)) {
				return CompletableFuture.completedFuture(ResponseEntity.noContent().build());
			} else {
				return CompletableFuture.completedFuture(ResponseEntity.ok().body(reserva));
			}

		} catch (DataIntegrityViolationException e) {

			return CompletableFuture.completedFuture(ResponseEntity.badRequest().body(e));
		}
	}

	@GetMapping("/{idReserva}")
	public CompletableFuture<ResponseEntity<Object>> BuscarReservaPorId(
			@PathVariable("idRerserva") Integer idRerserva) {

		try {

			Reserva reserva = service.BuscarReservaPorId(idRerserva);

			if (Objects.isNull(reserva)) {
				return CompletableFuture.completedFuture(ResponseEntity.noContent().build());
			} else {
				return CompletableFuture.completedFuture(ResponseEntity.ok().body(reserva));
			}

		} catch (DataIntegrityViolationException e) {

			return CompletableFuture.completedFuture(ResponseEntity.badRequest().body(e));
		}

	}

	@PostMapping()
	@Transactional
	public CompletableFuture<ResponseEntity<Object>> CriarReserva(@RequestBody Reserva objCriarReserva)
			throws URISyntaxException {

		try {

			Reserva reserva = service.CriarReserva(objCriarReserva);
			
			if (Objects.isNull(reserva)) {
				return CompletableFuture.completedFuture(ResponseEntity.noContent().build());
			} else {
				return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.CREATED).body(reserva));
			}

			

		} catch (DataIntegrityViolationException e) {

			return CompletableFuture.completedFuture(ResponseEntity.badRequest().body(e));
		}

	}

	@PutMapping("/{idReserva}")
	public CompletableFuture<ResponseEntity<Object>> AtualizarReserva(@PathVariable("idReserva") Integer idReserva,
			@RequestBody Reserva objAtualizarReserva) {

		try {

			Reserva reserva = service.AtualizarReserva(idReserva, objAtualizarReserva);

			if (Objects.isNull(reserva)) {
				return CompletableFuture.completedFuture(ResponseEntity.noContent().build());
			} else {
				return CompletableFuture.completedFuture(ResponseEntity.ok().body(reserva));
			}

		} catch (DataIntegrityViolationException e) {

			return CompletableFuture.completedFuture(ResponseEntity.badRequest().body(e));
		}
	}

	@DeleteMapping("/{idReserva}")
	public CompletableFuture<ResponseEntity<Object>> DeletarReserva(@PathVariable("idReserva") Integer idRerserva) {

		try {

			Reserva reserva = service.BuscarReservaPorId(idRerserva);

			if (Objects.isNull(reserva)) {
				return CompletableFuture.completedFuture(ResponseEntity.noContent().build());
			} else {
				service.DeletarReserva(idRerserva);

				return CompletableFuture.completedFuture(ResponseEntity.noContent().build());

			}

		} catch (DataIntegrityViolationException e) {

			return CompletableFuture.completedFuture(ResponseEntity.badRequest().body(e));
		}
	}

}
