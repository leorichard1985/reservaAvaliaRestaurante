package com.fiap.reservaAvaliaRestaurante.avaliacao.model.jpaStructure;

import java.io.Serializable;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_CAD_Avaliacao")
public class AvaliacaoJpa implements Serializable {

	private static final Long serialVersionUID = 730210547235292769L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAvaliacao")
	public Integer idAvaliacao;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idReserva")
	public ReservaJpa reserva;

	@Column(name = "notaAvaliacao")
	public Integer notaAvaliacao;

	@Column(name = "comentarioAvaliacao")
	public String comentarioAvaliacao;

}
