package org.enquete.framework.controller;

import java.lang.reflect.Type;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.enquete.framework.dominio.Entidade;
import org.enquete.framework.formulario.GenericForm;
import org.enquete.framework.service.GenericService;

import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

@SuppressWarnings("restriction")
public abstract class GenericController<E extends Entidade> {

	private GenericForm<E> formulario;

	private GenericService<E> service;

	public GenericController(GenericForm<E> formulario, GenericService<E> service) {
		super();
		this.formulario = formulario;
		this.service = service;
	}

	@PostConstruct
	public void init() {

		this.iniciarCampos();
	}

	public String salvar() {

		this.service.saveOrUpdate(this.getFormulario().getEntidade());

		this.iniciarCampos();

		return "pm:list?transition=flip";
	}

	private void iniciarCampos() {

		try {

			this.getFormulario().setEntidade(this.getTipoEntidade().newInstance());

			this.getFormulario().setLista(this.service.getAll());

		} catch (final Exception e) {

			Logger.getLogger(this.getClass().getName()).info("ERROR: " + e.getMessage());
		}

	}

	public String novaEntidade() {
		
		try {
			
			this.getFormulario().setEntidade(this.getTipoEntidade().newInstance());

			return "pm:edit?transition=flip";
			
		} catch (final Exception e) {

			Logger.getLogger(this.getClass().getName()).info("ERROR: " + e.getMessage());

			return null;
		}
	}

	public GenericForm<E> getFormulario() {

		return formulario;
	}

	@SuppressWarnings("unchecked")
	protected Class<E> getTipoEntidade() {

		final Type type[] = ((ParameterizedTypeImpl) this.getClass().getGenericSuperclass()).getActualTypeArguments();

		return (Class<E>) type[0];
	}
}
