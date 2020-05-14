package br.com.desafio.jokenpo.common.entity;

import java.util.Objects;

import br.com.desafio.jokenpo.common.enums.TipoJogada;

public class Jogada {

	private Long id;
	private TipoJogada tipo;

	public Jogada() {
	}

	public Jogada(TipoJogada tipo) {
		super();
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoJogada getTipo() {
		return tipo;
	}

	public void setTipo(TipoJogada tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tipo);
	}

}