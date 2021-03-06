package org.enquete.framework.service;

import java.util.List;

import org.enquete.framework.dominio.Entidade;

public interface GenericService<E extends Entidade> {

	public E saveOrUpdate(E entidade);

	public void delete(E entidade);

	public List<E> getAll();
	
	public E findOne(Long id);
}
