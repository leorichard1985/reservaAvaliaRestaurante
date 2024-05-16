package com.fiap.reservaAvaliaRestaurante.reserva.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.reservaAvaliaRestaurante.reserva.model.jpaStructure.ReservaJpa;
import com.fiap.reservaAvaliaRestaurante.reserva.model.jpaStructure.ReservaTipoJpa;
import com.fiap.reservaAvaliaRestaurante.reserva.records.Reserva;
import com.fiap.reservaAvaliaRestaurante.reserva.repository.ReservaRepository;
import com.fiap.reservaAvaliaRestaurante.reserva.repository.ReservaTipoRepository;
import com.fiap.reservaAvaliaRestaurante.reserva.services.interfaces.ReservaService;
import com.fiap.reservaAvaliaRestaurante.restaurante.model.jpaStructure.RestauranteJpa;
import com.fiap.reservaAvaliaRestaurante.restaurante.repository.RestauranteRepository;
import com.fiap.reservaAvaliaRestaurante.usuario.model.jpaStructure.UsuarioJpa;
import com.fiap.reservaAvaliaRestaurante.usuario.repository.UsuarioRepository;

@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	private ReservaRepository repository;

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private ReservaTipoRepository reservaTipoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Reserva AtualizarReserva(Integer idReserva, Reserva objAtualizarReserva) {

		Optional<ReservaJpa> optJpa = repository.findById(idReserva);

		if (optJpa.isEmpty()) {

			return null;

		} else {

			optJpa.get().dataReserva = objAtualizarReserva.dataReserva();
			optJpa.get().horaReserva = objAtualizarReserva.horaReserva();

			Optional<RestauranteJpa> optJpaRestaurante = restauranteRepository
					.findById(objAtualizarReserva.idRestaurante());

			if (optJpaRestaurante.isEmpty()) {
				return null;
			}

			optJpa.get().restaurante = optJpaRestaurante.get();

			Optional<ReservaTipoJpa> optJpaReservaTipo = reservaTipoRepository
					.findById(objAtualizarReserva.idReservaTipo());

			if (optJpaReservaTipo.isEmpty()) {
				return null;
			}

			optJpa.get().reservaTipo = optJpaReservaTipo.get();

			Optional<UsuarioJpa> optJpaUsuario = usuarioRepository.findById(objAtualizarReserva.idUsuario());

			if (optJpaUsuario.isEmpty()) {
				return null;
			}

			optJpa.get().usuario = optJpaUsuario.get();

			ReservaJpa optJpaPreSaved = optJpa.get();

			ReservaJpa optJpaSaved = repository.save(optJpaPreSaved);

			return new Reserva(optJpaSaved.idReserva, optJpaSaved.restaurante.idRestaurante,
					optJpaSaved.usuario.idUsuario, optJpaSaved.reservaTipo.idReservaTipo, optJpaSaved.dataReserva,
					optJpaSaved.horaReserva);

		}

	}

	@Override
	public List<Reserva> BuscarReservaPorFiltro(Integer idRestaurante, Integer idUsuario) {
		List<ReservaJpa> lstJpa = repository.BuscarReservaPorFiltro(idRestaurante, idUsuario);

		if (lstJpa.isEmpty()) {

			return null;

		} else {

			List<Reserva> lstReserva = new ArrayList<>();

			for (int i = 0; i < lstJpa.size() - 1; i++) {

				Reserva itemReserva = new Reserva(lstJpa.get(i).idReserva, lstJpa.get(i).restaurante.idRestaurante,
						lstJpa.get(i).usuario.idUsuario, lstJpa.get(i).reservaTipo.idReservaTipo,
						lstJpa.get(i).dataReserva, lstJpa.get(i).horaReserva);

				lstReserva.add(itemReserva);

			}

			return lstReserva;

		}

	}

	@Override
	public Reserva BuscarReservaPorId(Integer idReserva) {

		Optional<ReservaJpa> optJpa = repository.findById(idReserva);

		if (optJpa.isEmpty()) {

			return null;

		} else {

			return new Reserva(optJpa.get().idReserva, optJpa.get().restaurante.idRestaurante,
					optJpa.get().usuario.idUsuario, optJpa.get().reservaTipo.idReservaTipo, optJpa.get().dataReserva,
					optJpa.get().horaReserva);

		}

	}

	@Override
	public Reserva CriarReserva(Reserva objCriarReserva) {

		ReservaJpa reservaJpa = new ReservaJpa();

		Optional<RestauranteJpa> optJpaRestaurante = restauranteRepository.findById(objCriarReserva.idRestaurante());

		if (optJpaRestaurante.isEmpty()) {
			return null;
		}

		reservaJpa.restaurante = optJpaRestaurante.get();

		Optional<ReservaTipoJpa> optJpaReservaTipo = reservaTipoRepository.findById(objCriarReserva.idReservaTipo());

		if (optJpaReservaTipo.isEmpty()) {
			return null;
		}

		reservaJpa.reservaTipo = optJpaReservaTipo.get();

		Optional<UsuarioJpa> optJpaUsuario = usuarioRepository.findById(objCriarReserva.idUsuario());

		if (optJpaUsuario.isEmpty()) {
			return null;
		}

		reservaJpa.usuario = optJpaUsuario.get();

		reservaJpa.dataReserva = objCriarReserva.dataReserva();
		reservaJpa.horaReserva = objCriarReserva.horaReserva();

		ReservaJpa optJpaSaved = repository.save(reservaJpa);

		return new Reserva(optJpaSaved.idReserva, optJpaSaved.restaurante.idRestaurante, optJpaSaved.usuario.idUsuario,
				optJpaSaved.reservaTipo.idReservaTipo, optJpaSaved.dataReserva, optJpaSaved.horaReserva);

	}

	@Override
	public void DeletarReserva(Integer idReserva) {

		repository.deleteById(idReserva);

	}

}
