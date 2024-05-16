package com.fiap.reservaAvaliaRestaurante.restaurante.model.jpaStructure;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Cad_Restaurante")
public class RestauranteJpa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRestaurante")
	Integer idRestaurante;

	@Column(name = "nomeRestaurante")
	String nomeRestaurante;

	@Column(name = "enderecoRestaurante")
	String enderecoRestaurante;

	@Column(name = "cepRestaurante")
	String cepRestaurante;

	@Column(name = "cidadeRestaurante")
	String cidadeRestaurante;

	@Column(name = "estadoRestaurante")
	String estadoRestaurante;

	@Column(name = "tipoCozinha")
	String tipoCozinha;

	@Column(name = "horarioFuncionamento")
	String horarioFuncionamento;

	@Column(name = "capacidadeReservaTotal")
	Integer capacidadeReservaTotal;

	@Column(name = "capacidadeReservaDisponivel")
	Integer capacidadeReservaDisponivel;

}
