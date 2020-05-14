package br.com.desafio.jokenpo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.jokenpo.common.business.JogadorService;
import br.com.desafio.jokenpo.common.dto.JogadorDto;
import br.com.desafio.jokenpo.common.entity.Jogador;
import br.com.desafio.jokenpo.common.exceptions.ResourceNotFoundException;
import br.com.desafio.jokenpo.common.exceptions.ResourceUnprocesableException;
import br.com.desafio.jokenpo.common.utils.Mensagens;
import io.swagger.annotations.ApiOperation;

@RestController
public class JogadorController {

	@Autowired
	private JogadorService jogadorService;

	@PostMapping("/jogadores")
	@ApiOperation(value = "Cadastra um jogador.", httpMethod = "POST", response = Jogador.class)
	public Jogador salvar(@Valid @RequestBody JogadorDto jogadorDto) throws ResourceUnprocesableException {
		Jogador jogador = jogadorService.save(new Jogador(jogadorDto.getNome()));

		if (jogador == null)
			throw new ResourceUnprocesableException(Mensagens.ERRO_OBJETO_CADASTRADO);

		return jogador;
	}

	@GetMapping("/jogadores")
	@ApiOperation(value = "Retorna todos os jogadores cadastrados.", httpMethod = "GET", response = Jogador.class)
	public Set<Jogador> listar() {
		return jogadorService.findAll();
	}

	@GetMapping("/jogadores/{id}")
	@ApiOperation(value = "Retorna o jogador do ID informado.", httpMethod = "GET", response = Jogador.class)
	public ResponseEntity<Jogador> buscarPorId(@PathVariable Long id) throws ResourceNotFoundException {
		Jogador jogador = jogadorService.findById(id);

		if (jogador == null)
			throw new ResourceNotFoundException(String.format(Mensagens.ERRO_ID_JOGADOR_NAO_ENCONTRADO, id));
		return ResponseEntity.ok().body(jogador);
	}

	@DeleteMapping("/jogadores/{id}")
	@ApiOperation(value = "Deleta o jogador do ID informado.", httpMethod = "DELETE", response = Jogador.class)
	public Map<String, Boolean> deletar(@PathVariable Long id) throws ResourceNotFoundException {
		Jogador jogador = jogadorService.findById(id);

		if (jogador == null)
			throw new ResourceNotFoundException(String.format(Mensagens.ERRO_ID_JOGADOR_NAO_ENCONTRADO, id));

		jogadorService.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deletado", Boolean.TRUE);
		return response;
	}

}
