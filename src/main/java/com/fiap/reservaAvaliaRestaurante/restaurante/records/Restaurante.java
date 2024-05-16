package com.fiap.reservaAvaliaRestaurante.restaurante.records;

public record Restaurante(Integer idRestaurante, String nomeRestaurante, String enderecoRestaurante,
		String cepRestaurante, String cidadeRestaurante, String estadoRestaurante, String tipoCozinha,
		String horarioFuncionamento, Integer capacidadeReservaTotal, Integer capacidadeReservaDisponivel) {

}
