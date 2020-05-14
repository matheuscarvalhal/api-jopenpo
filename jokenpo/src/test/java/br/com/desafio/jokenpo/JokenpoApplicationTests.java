package br.com.desafio.jokenpo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.desafio.jokenpo.common.business.EntradaService;
import br.com.desafio.jokenpo.common.entity.Entrada;
import br.com.desafio.jokenpo.common.entity.Jogada;
import br.com.desafio.jokenpo.common.entity.Jogador;
import br.com.desafio.jokenpo.common.enums.TipoJogada;

@SpringBootTest
class JokenpoApplicationTests {

	@Autowired
	private EntradaService entradaService;

	@Test
	void contextLoads() {
	}

	@Test
	public void jogadorUmVence() {
		assertTrue(entradaService
				.jogar(new Entrada(new Jogador("Jogador 1"), new Jogada(TipoJogada.PEDRA)),
						new Entrada(new Jogador("Jogador 2"), new Jogada(TipoJogada.TESOURA)))
				.equalsIgnoreCase("Jogador: Jogador 1 vitória"));
	}

	@Test
	public void jogadorDoisVence() {
		assertTrue(entradaService
				.jogar(new Entrada(new Jogador("Jogador 1"), new Jogada(TipoJogada.SPOCK)),
						new Entrada(new Jogador("Jogador 2"), new Jogada(TipoJogada.LAGARTO)))
				.equalsIgnoreCase("Jogador: Jogador 2 vitória"));
	}

	@Test
	public void jogadoresEmpatam() {
		assertTrue(entradaService
				.jogar(new Entrada(new Jogador("Jogador 1"), new Jogada(TipoJogada.PAPEL)),
						new Entrada(new Jogador("Jogador 2"), new Jogada(TipoJogada.PAPEL)))
				.equalsIgnoreCase("Empate"));
	}

}
