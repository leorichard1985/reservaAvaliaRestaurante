package com.fiap.reservaAvaliaRestaurante.restaurante.model.jpaStructure;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "tb_Cad_Restaurante")
public class RestauranteJpa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRestaurante")
	public Integer idRestaurante;

	@Column(name = "nomeRestaurante")
	public String nomeRestaurante;

	@Column(name = "enderecoRestaurante")
	public String enderecoRestaurante;

	@Column(name = "cepRestaurante")
	public String cepRestaurante;

	@Column(name = "cidadeRestaurante")
	public String cidadeRestaurante;

	@Column(name = "estadoRestaurante")
	public String estadoRestaurante;

	@Column(name = "tipoCozinha")
	public String tipoCozinha;

	@Column(name = "horarioFuncionamento")
	public String horarioFuncionamento;

	@Column(name = "capacidadeReservaTotal")
	public Integer capacidadeReservaTotal;

	@Column(name = "capacidadeReservaDisponivel")
	public Integer capacidadeReservaDisponivel;

}
