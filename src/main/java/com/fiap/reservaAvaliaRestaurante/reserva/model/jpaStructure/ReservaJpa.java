package com.fiap.reservaAvaliaRestaurante.reserva.model.jpaStructure;

import com.fiap.reservaAvaliaRestaurante.restaurante.model.jpaStructure.RestauranteJpa;
import com.fiap.reservaAvaliaRestaurante.usuario.model.jpaStructure.UsuarioJpa;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_CAD_Reserva")
public class ReservaJpa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idReserva")
	Integer idReserva;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idRestaurante")
	RestauranteJpa restaurante;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idUsuario")
	UsuarioJpa usuario;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idReservaTipo")
	ReservaTipoJpa reservaTipo;

	@Column(name = "dataReserva")
	String dataReserva;

	@Column(name = "horaReserva")
	String horaReserva;

}
