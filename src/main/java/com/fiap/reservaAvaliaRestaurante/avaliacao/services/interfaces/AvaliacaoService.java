package com.fiap.reservaAvaliaRestaurante.avaliacao.services.interfaces;

import java.util.List;

import com.fiap.reservaAvaliaRestaurante.avaliacao.records.Avaliacao;

public interface AvaliacaoService {

	List<Avaliacao> BuscarAvaliacoesPorFiltro(Integer idRestaurante, Integer idUsuario);

	Avaliacao BuscarAvaliacaoPorId(Integer id);

	Avaliacao CriarAvaliacao(Avaliacao objCriarAvaliacao);

}
