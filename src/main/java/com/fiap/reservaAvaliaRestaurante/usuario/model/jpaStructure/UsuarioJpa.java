package com.fiap.reservaAvaliaRestaurante.usuario.model.jpaStructure;

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
@Table(name = "tb_CAD_Usuario")
public class UsuarioJpa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsuario")
	Integer idUsuario;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idUsuarioTipo")
	UsuarioTipoJpa idUsuarioTipo;

	@Column(name = "nomeUsuario")
	String nomeUsuario;

	@Column(name = "cpfUsuario")
	String cpfUsuario;

}
