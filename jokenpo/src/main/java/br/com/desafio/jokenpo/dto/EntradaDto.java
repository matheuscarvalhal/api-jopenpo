package br.com.desafio.jokenpo.dto;

public class EntradaDto {

	private JogadorDto jogador;
	private JogadaDto jogada;

	public JogadorDto getJogador() {
		return jogador;
	}

	public void setJogador(JogadorDto jogador) {
		this.jogador = jogador;
	}

	public JogadaDto getJogada() {
		return jogada;
	}

	public void setJogada(JogadaDto jogada) {
		this.jogada = jogada;
	}

}
