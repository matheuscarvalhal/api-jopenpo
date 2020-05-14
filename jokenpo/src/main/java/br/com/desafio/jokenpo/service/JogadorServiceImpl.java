package br.com.desafio.jokenpo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.desafio.jokenpo.common.business.JogadorService;
import br.com.desafio.jokenpo.common.entity.Jogador;

@Service
public class JogadorServiceImpl implements JogadorService {

	private Set<Jogador> jogadores = new HashSet<Jogador>();
	private Long sequence = 1L;

	@Override
	public Set<Jogador> findAll() {
		return jogadores;
	}

	@Override
	public Jogador save(Jogador entity) {
		if (jogadores.stream().filter(i -> i.getNome().equalsIgnoreCase(entity.getNome())).count() == 0) {
			entity.setId(sequence);
			jogadores.add(entity);
			sequence++;
			return entity;
		} else {
			return null;
		}
	}

	@Override
	public Jogador findById(Long id) {
		return jogadores.stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null);
	}


	@Override
	public void delete(Long id) {
		jogadores.removeIf(i -> i.getId().equals(id));
	}

	@Override
	public Jogador buscarPorNome(String nome) {
		return jogadores.stream().filter(i -> i.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
	}
	
	@Override
	public void update(Jogador entity) {
		throw new RuntimeException(METODO_NAO_SUPORTA);
	}
}
