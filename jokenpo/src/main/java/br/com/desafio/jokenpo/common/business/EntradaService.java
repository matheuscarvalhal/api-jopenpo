package br.com.desafio.jokenpo.common.business;

import br.com.desafio.jokenpo.common.entity.Entrada;

public interface EntradaService extends BaseService<Entrada> {
	public String jogar(Entrada entradaPrimeiroJogador, Entrada entradaSegundoJogador);
}