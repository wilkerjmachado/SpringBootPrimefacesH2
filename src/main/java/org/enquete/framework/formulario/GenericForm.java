package org.enquete.framework.formulario;

import java.util.List;

import org.enquete.framework.dominio.Entidade;

public abstract class GenericForm<E extends Entidade> {

	private List<E> lista;

	private E entidade;

	public List<E> getLista() {
		return lista;
	}

	public void setLista(List<E> lista) {
		this.lista = lista;
	}

	public E getEntidade() {
		return entidade;
	}

	public void setEntidade(E entidade) {
		this.entidade = entidade;
	}

}
