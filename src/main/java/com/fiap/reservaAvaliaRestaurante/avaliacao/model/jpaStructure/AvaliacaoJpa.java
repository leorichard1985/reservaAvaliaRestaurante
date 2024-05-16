package com.fiap.reservaAvaliaRestaurante.avaliacao.model.jpaStructure;

import com.fiap.reservaAvaliaRestaurante.reserva.model.jpaStructure.ReservaJpa;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_CAD_Avaliacao")
public class AvaliacaoJpa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAvaliacao")
	Integer idAvaliacao;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idReserva")
	ReservaJpa reserva;

	@Column(name = "notaAvaliacao")
	Integer notaAvaliacao;

	@Column(name = "comentarioAvaliacao")
	String comentarioAvaliacao;

}
