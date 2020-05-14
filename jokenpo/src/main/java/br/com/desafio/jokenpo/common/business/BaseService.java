package br.com.desafio.jokenpo.common.business;

import java.util.Set;

public interface BaseService<T> {
	
	public static final String METODO_NAO_SUPORTA = "Método não implementado";

	Set<T> findAll();

	T findById(Long id);

	T save(T entity);

	void update(T entity);

	void delete(Long id);
}