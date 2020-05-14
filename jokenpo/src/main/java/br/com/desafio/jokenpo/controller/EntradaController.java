package br.com.desafio.jokenpo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.jokenpo.common.business.EntradaService;
import br.com.desafio.jokenpo.common.business.JogadorService;
import br.com.desafio.jokenpo.common.entity.Entrada;
import br.com.desafio.jokenpo.common.entity.Jogada;
import br.com.desafio.jokenpo.common.entity.Jogador;
import br.com.desafio.jokenpo.common.exceptions.ResourceNotFoundException;
import br.com.desafio.jokenpo.common.exceptions.ResourceUnprocesableException;
import br.com.desafio.jokenpo.common.utils.Mensagens;
import br.com.desafio.jokenpo.dto.EntradaDto;
import io.swagger.annotations.ApiOperation;

@RestController
public class EntradaController {

	@Autowired
	private EntradaService entradaService;

	@Autowired
	private JogadorService jogadorService;

	@PostMapping("/jogar")
	@ApiOperation(value = "Retorna o vencedor da partida", httpMethod = "POST", response = String.class)
	public String jogar(@Valid @RequestBody List<EntradaDto> entradas) throws ResourceNotFoundException, ResourceUnprocesableException {
		
		if(entradas.isEmpty() || entradas.size() != 2) 
			throw new ResourceUnprocesableException(Mensagens.ERRO_ENTRADAS);

		EntradaDto entradaPrimeiroJogador = entradas.get(0);
		EntradaDto entradaSegundoJogador = entradas.get(1);

		Jogador jogador = jogadorService.buscarPorNome(entradaPrimeiroJogador.getJogador().getNome());

		if (jogador == null)
			throw new ResourceNotFoundException(String.format(Mensagens.ERRO_NOME_JOGADOR_NAO_ENCONTRADO, entradaPrimeiroJogador.getJogador().getNome()));

		jogador = jogadorService.buscarPorNome(entradaSegundoJogador.getJogador().getNome());

		if (jogador == null)
			throw new ResourceNotFoundException(String.format(Mensagens.ERRO_NOME_JOGADOR_NAO_ENCONTRADO, entradaSegundoJogador.getJogador().getNome()));

		return entradaService.jogar(new Entrada(new Jogador(entradaPrimeiroJogador.getJogador().getNome()), new Jogada(entradaPrimeiroJogador.getJogada().getTipo())),
				new Entrada(new Jogador(entradaSegundoJogador.getJogador().getNome()), new Jogada(entradaSegundoJogador.getJogada().getTipo())));
	}

}
