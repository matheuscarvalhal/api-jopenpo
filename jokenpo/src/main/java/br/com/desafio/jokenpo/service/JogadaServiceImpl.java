package br.com.desafio.jokenpo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.desafio.jokenpo.common.business.JogadaService;
import br.com.desafio.jokenpo.common.entity.Jogada;

@Service
public class JogadaServiceImpl implements JogadaService {

	private Set<Jogada> jogadas = new HashSet<Jogada>();
	private Long sequence = 1L;

	@Override
	public Set<Jogada> findAll() {
		return jogadas;
	}

	@Override
	public Jogada save(Jogada entity) {
		if (jogadas.stream().filter(i -> i.getTipo().equals(entity.getTipo())).count() == 0) {
			entity.setId(sequence);
			jogadas.add(entity);
			sequence++;
			return entity;
		} else {
			return null;
		}
	}

	@Override
	public Jogada findById(Long id) {
		return jogadas.stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null);
	}

	@Override
	public void update(Jogada entity) {
		throw new RuntimeException(METODO_NAO_SUPORTA);
	}

	@Override
	public void delete(Long id) {
		jogadas.removeIf(i -> i.getId().equals(id));
	}
}
