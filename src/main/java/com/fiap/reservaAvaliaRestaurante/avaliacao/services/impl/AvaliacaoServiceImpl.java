package com.fiap.reservaAvaliaRestaurante.avaliacao.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.reservaAvaliaRestaurante.avaliacao.model.jpaStructure.AvaliacaoJpa;
import com.fiap.reservaAvaliaRestaurante.avaliacao.records.Avaliacao;
import com.fiap.reservaAvaliaRestaurante.avaliacao.repository.AvaliacaoRepository;
import com.fiap.reservaAvaliaRestaurante.avaliacao.services.interfaces.AvaliacaoService;
import com.fiap.reservaAvaliaRestaurante.reserva.model.jpaStructure.ReservaJpa;
import com.fiap.reservaAvaliaRestaurante.reserva.repository.ReservaRepository;

@Service
public class AvaliacaoServiceImpl implements AvaliacaoService {

	@Autowired
	private AvaliacaoRepository repository;

	@Autowired
	private ReservaRepository reservaRepository;

	@Override
	public Avaliacao BuscarAvaliacaoPorId(Integer id) {

		Optional<AvaliacaoJpa> optJpa = repository.findById(id);

		if (optJpa.isEmpty()) {

			return null;

		} else {

			return new Avaliacao(optJpa.get().idAvaliacao, optJpa.get().reserva.idReserva, optJpa.get().notaAvaliacao,
					optJpa.get().comentarioAvaliacao);

		}

	}

	@Override
	public List<Avaliacao> BuscarAvaliacoesPorFiltro(Integer idRestaurante, Integer idUsuario) {

		List<AvaliacaoJpa> lstJpa = repository.BuscarAvaliacoesPorFiltro(idRestaurante, idUsuario);

		if (lstJpa.isEmpty()) {

			return null;

		} else {

			List<Avaliacao> lstAvaliacao = new ArrayList<>();

			for (int i = 0; i < lstJpa.size() - 1; i++) {

				Avaliacao itemAvaliacao = new Avaliacao(lstJpa.get(i).idAvaliacao, lstJpa.get(i).reserva.idReserva,
						lstJpa.get(i).notaAvaliacao, lstJpa.get(i).comentarioAvaliacao);

				lstAvaliacao.add(itemAvaliacao);

			}

			return lstAvaliacao;

		}

	}

	@Override
	public Avaliacao CriarAvaliacao(Avaliacao objCriarAvaliacao) {

		Optional<ReservaJpa> reservaJpa = reservaRepository.findById(objCriarAvaliacao.idReserva());

		if (reservaJpa.isPresent()) {

			AvaliacaoJpa avaliacaoJpa = new AvaliacaoJpa();

			avaliacaoJpa.idAvaliacao = objCriarAvaliacao.idAvaliacao();
			avaliacaoJpa.reserva = reservaJpa.get();
			avaliacaoJpa.notaAvaliacao = objCriarAvaliacao.notaAvaliacao();
			avaliacaoJpa.comentarioAvaliacao = objCriarAvaliacao.comentarioAvaliacao();

			AvaliacaoJpa avaliacaoJpaSaved = repository.save(avaliacaoJpa);

			return new Avaliacao(avaliacaoJpaSaved.idAvaliacao, avaliacaoJpaSaved.reserva.idReserva,
					avaliacaoJpaSaved.notaAvaliacao, avaliacaoJpaSaved.comentarioAvaliacao);
		}

		return null;
	}

}
