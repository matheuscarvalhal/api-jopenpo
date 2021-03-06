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

import br.com.desafio.jokenpo.common.business.JogadaService;
import br.com.desafio.jokenpo.common.dto.JogadaDto;
import br.com.desafio.jokenpo.common.entity.Jogada;
import br.com.desafio.jokenpo.common.exceptions.ResourceNotFoundException;
import br.com.desafio.jokenpo.common.exceptions.ResourceUnprocesableException;
import br.com.desafio.jokenpo.common.utils.Mensagens;
import io.swagger.annotations.ApiOperation;

@RestController
public class JogadaController {

	@Autowired
	private JogadaService jogadaService;

	@PostMapping("/jogadas")
	@ApiOperation(value = "Cadastra uma jogada.", httpMethod = "POST", response = Jogada.class)
	public Jogada salvar(@Valid @RequestBody JogadaDto jogadorDto) throws ResourceUnprocesableException {

		Jogada jogada = jogadaService.save(new Jogada(jogadorDto.getTipo()));

		if (jogada == null)
			throw new ResourceUnprocesableException(Mensagens.ERRO_OBJETO_CADASTRADO);

		return jogada;
	}

	@GetMapping("/jogadas")
	@ApiOperation(value = "Retorna todas as jogadas cadastradas.", httpMethod = "GET", response = Jogada.class)
	public Set<Jogada> listar() {
		return jogadaService.findAll();
	}

	@GetMapping("/jogadas/{id}")
	@ApiOperation(value = "Retorna a jogada do ID informado.", httpMethod = "GET", response = Jogada.class)
	public ResponseEntity<Jogada> buscarPorId(@PathVariable Long id) throws ResourceNotFoundException {
		Jogada jogada = jogadaService.findById(id);

		if (jogada == null)
			throw new ResourceNotFoundException(String.format(Mensagens.ERRO_ID_JOGADA_NAO_ENCONTRADA, id));

		return ResponseEntity.ok().body(jogada);
	}

	@DeleteMapping("/jogadas/{id}")
	@ApiOperation(value = "Deleta a jogada do ID informado.", httpMethod = "DELETE", response = Jogada.class)
	public Map<String, Boolean> deletar(@PathVariable Long id) throws ResourceNotFoundException {
		Jogada jogada = jogadaService.findById(id);

		if (jogada == null)
			throw new ResourceNotFoundException(String.format(Mensagens.ERRO_ID_JOGADA_NAO_ENCONTRADA, id));

		jogadaService.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deletado", Boolean.TRUE);
		return response;
	}

}
