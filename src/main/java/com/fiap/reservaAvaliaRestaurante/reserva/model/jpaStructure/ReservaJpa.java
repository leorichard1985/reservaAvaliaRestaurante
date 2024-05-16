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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_CAD_Reserva")
public class ReservaJpa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idReserva")
	public Integer idReserva;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idRestaurante")
	public RestauranteJpa restaurante;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idUsuario")
	public UsuarioJpa usuario;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idReservaTipo")
	public ReservaTipoJpa reservaTipo;

	@Column(name = "dataReserva")
	public String dataReserva;

	@Column(name = "horaReserva")
	public String horaReserva;

}
