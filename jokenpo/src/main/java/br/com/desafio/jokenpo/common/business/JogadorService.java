package br.com.desafio.jokenpo.common.business;

import br.com.desafio.jokenpo.common.entity.Jogador;

public interface JogadorService extends BaseService<Jogador> {
	public Jogador buscarPorNome(String nome);
}