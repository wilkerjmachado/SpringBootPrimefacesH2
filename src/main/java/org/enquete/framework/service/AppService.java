package org.enquete.framework.service;

import org.enquete.framework.dominio.Entidade;

public interface AppService<E extends Entidade> {

	public E saveOrUpdate(E entidade);

	public void delete(E entidade);
}
