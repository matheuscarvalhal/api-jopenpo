package br.com.desafio.jokenpo.common.entity;

import java.util.Objects;

public class Jogador {

	private Long id;
	private String nome;

	public Jogador() {
	}

	public Jogador(String nome) {
		super();
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

}