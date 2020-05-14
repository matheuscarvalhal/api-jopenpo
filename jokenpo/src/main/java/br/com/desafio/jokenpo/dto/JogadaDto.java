package br.com.desafio.jokenpo.dto;

import br.com.desafio.jokenpo.common.enums.TipoJogada;

public class JogadaDto {

	private TipoJogada tipo;

	public TipoJogada getTipo() {
		return tipo;
	}

	public void setTipo(TipoJogada tipo) {
		this.tipo = tipo;
	}

}