package org.enquete.framework.service.impl;

import java.util.List;

import org.enquete.framework.dominio.Entidade;
import org.enquete.framework.service.GenericService;
import org.springframework.data.repository.CrudRepository;

public abstract class GenericServiceImpl<E extends Entidade, T extends CrudRepository<E, Long>> implements GenericService<E> {

	protected T repository;

	public GenericServiceImpl(T repository) {
		super();
		this.repository = repository;
	}

	public E saveOrUpdate(E entidade) {

		return (E) repository.save(entidade);

	}

	public void delete(E entidade) {

		repository.delete(entidade);

	}

	public List<E> getAll() {

		return (List<E>) repository.findAll();
	}

}
