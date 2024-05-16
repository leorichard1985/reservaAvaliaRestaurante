package com.fiap.reservaAvaliaRestaurante.reserva.records;

public record Reserva(Integer idReserva, Integer idRestaurante, Integer idUsuario, Integer idReservaTipo,
		String dataReserva, String horaReserva) {

}
