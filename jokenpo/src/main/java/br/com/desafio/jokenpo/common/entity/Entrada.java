package br.com.desafio.jokenpo.common.entity;

public class Entrada {

	private Jogador jogador;
	private Jogada jogada;

	public Entrada() {
	}

	public Entrada(Jogador jogador, Jogada jogada) {
		super();
		this.jogador = jogador;
		this.jogada = jogada;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Jogada getJogada() {
		return jogada;
	}

	public void setJogada(Jogada jogada) {
		this.jogada = jogada;
	}

}