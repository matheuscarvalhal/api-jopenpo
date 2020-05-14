package br.com.desafio.jokenpo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.jokenpo.common.business.EntradaService;
import br.com.desafio.jokenpo.common.business.JogadorService;
import br.com.desafio.jokenpo.common.dto.EntradaDto;
import br.com.desafio.jokenpo.common.entity.Entrada;

@Service
public class EntradaServiceImpl implements EntradaService {

	@Autowired
	private JogadorService jogadorService;

	private Set<Entrada> entradas = new HashSet<Entrada>();

	@Override
	public String jogar(Entrada entradaPrimeiroJogador, Entrada entradaSegundoJogador) {
		if (entradaPrimeiroJogador.getJogada().getTipo().ganha(entradaSegundoJogador.getJogada().getTipo())) {
			return String.format("Jogador: %s vitória", entradaPrimeiroJogador.getJogador().getNome());
		} else if (entradaPrimeiroJogador.getJogada().getTipo().perde(entradaSegundoJogador.getJogada().getTipo())) {
			return String.format("Jogador: %s vitória", entradaSegundoJogador.getJogador().getNome());
		}
		return "Empate";
	}

	@Override
	public Set<Entrada> findAll() {
		throw new RuntimeException(METODO_NAO_SUPORTA);
	}

	@Override
	public Entrada save(Entrada entity) {
		throw new RuntimeException(METODO_NAO_SUPORTA);
	}

	@Override
	public Entrada findById(Long id) {
		throw new RuntimeException(METODO_NAO_SUPORTA);
	}

	@Override
	public void update(Entrada entity) {
		throw new RuntimeException(METODO_NAO_SUPORTA);
	}

	@Override
	public void delete(Long id) {
		throw new RuntimeException(METODO_NAO_SUPORTA);
	}

}
