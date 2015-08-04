package org.enquete.framework.controller;

import java.lang.reflect.Type;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.enquete.framework.dominio.Entidade;
import org.enquete.framework.formulario.GenericForm;
import org.enquete.framework.service.GenericService;

import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

@SuppressWarnings("restriction")
public abstract class GenericController<E extends Entidade, F extends GenericForm<E>, S extends GenericService<E>> {

	private F formulario;

	private S service;

	public GenericController(F formulario, S service) {
		super();
		this.formulario = formulario;
		this.service = service;
	}

	@PostConstruct
	public void init() {

		this.iniciarCampos();
	}

	public String salvar() {

		this.getService().saveOrUpdate(this.getFormulario().getEntidade());

		this.iniciarCampos();

		return this.getListView();
	}
	
	public String remover(E entidade) {

		this.getService().delete(entidade);

		this.iniciarCampos();

		return this.getListView();
	}

	protected void iniciarCampos() {

		try {

			this.getFormulario().setEntidade(this.getTipoEntidade().newInstance());

			this.getFormulario().setLista(this.getService().getAll());

		} catch (final Exception e) {

			Logger.getLogger(this.getClass().getName()).info("ERROR: " + e.getMessage());
		}

	}

	public String novaEntidade() {

		try {

			this.getFormulario().setEntidade(this.getTipoEntidade().newInstance());

			return this.getEditView();

		} catch (final Exception e) {

			Logger.getLogger(this.getClass().getName()).info("ERROR: " + e.getMessage());

			return null;
		}
	}

	public F getFormulario() {

		return formulario;
	}

	
	public S getService() {
		
		return service;
	}

	public String getEditView() {

		return "pm:edit?transition=flip";
	}

	public String getListView() {

		return "pm:list?transition=flip";
	}

	@SuppressWarnings("unchecked")
	protected Class<E> getTipoEntidade() {

		final Type type[] = ((ParameterizedTypeImpl) this.getClass().getGenericSuperclass()).getActualTypeArguments();

		return (Class<E>) type[0];
	}
}
