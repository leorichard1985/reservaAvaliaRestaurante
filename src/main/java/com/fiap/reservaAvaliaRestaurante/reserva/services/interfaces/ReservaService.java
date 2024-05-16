package com.fiap.reservaAvaliaRestaurante.reserva.services.interfaces;

import java.util.List;

import com.fiap.reservaAvaliaRestaurante.reserva.records.Reserva;

public interface ReservaService {

	List<Reserva> BuscarReservaPorFiltro(Integer idRestaurante, Integer idUsuario);

	Reserva BuscarReservaPorId(Integer idRerserva);

	Reserva CriarReserva(Reserva objCriarReserva);

	Reserva AtualizarReserva(Integer idReserva,Reserva objAtualizarReserva);

	void DeletarReserva(Integer idReserva);

}
