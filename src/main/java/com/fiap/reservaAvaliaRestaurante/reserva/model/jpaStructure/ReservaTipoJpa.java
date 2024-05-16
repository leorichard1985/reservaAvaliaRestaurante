package com.fiap.reservaAvaliaRestaurante.reserva.model.jpaStructure;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_CAD_ReservaTipo")
public class ReservaTipoJpa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idReservaTipo")
	public Integer idReservaTipo;

	@Column(name = "reservaTipo")
	public String reservaTipo;

}
