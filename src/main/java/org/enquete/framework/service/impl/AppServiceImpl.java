package org.enquete.framework.service.impl;

import org.enquete.framework.dominio.Entidade;
import org.enquete.framework.service.AppService;
import org.springframework.data.repository.CrudRepository;

public abstract class AppServiceImpl<E extends Entidade, T extends CrudRepository<E, Long>> implements AppService<E> {

	protected T repository;

	public E saveOrUpdate(E entidade) {

		return (E) repository.save(entidade);

	}

	public void delete(E entidade) {

		repository.delete(entidade);

	}

}
