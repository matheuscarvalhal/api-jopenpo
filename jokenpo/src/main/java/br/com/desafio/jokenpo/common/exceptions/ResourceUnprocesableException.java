package br.com.desafio.jokenpo.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class ResourceUnprocesableException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceUnprocesableException(String message) {
		super(message);
	}

}