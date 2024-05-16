package com.fiap.reservaAvaliaRestaurante.usuario.model.jpaStructure;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_CAD_UsuarioTipo")
public class UsuarioTipoJpa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsuarioTipo")
	Integer idUsuarioTipo;

	@Column(name = "usuarioTipo")
	String usuarioTipo;

}
