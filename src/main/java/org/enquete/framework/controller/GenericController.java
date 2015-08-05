package org.enquete.framework.controller;

import java.lang.reflect.Type;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.enquete.framework.captha.ReCaptchaChecker;
import org.enquete.framework.captha.ReCaptchaCheckerReponse;
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

	public void salvar() {

		this.getService().saveOrUpdate(this.getFormulario().getEntidade());

		this.iniciarCampos();

		this.mostrarMensagem("Item salvo com sucesso!", "Sucesso", FacesMessage.SEVERITY_INFO);

	}

	public void remover(E entidade) {

		this.getService().delete(entidade);

		this.mostrarMensagem("Item excluído com sucesso!", "Sucesso", FacesMessage.SEVERITY_INFO);

		this.iniciarCampos();

	}

	protected void iniciarCampos() {

		try {

			this.getFormulario().setEntidade(this.getTipoEntidade().newInstance());

			this.getFormulario().setLista(this.getService().getAll());

		} catch (final Exception e) {

			Logger.getLogger(this.getClass().getName()).info("ERROR: " + e.getMessage());
		}

	}

	public void novaEntidade() {

		try {

			this.getFormulario().setEntidade(this.getTipoEntidade().newInstance());

		} catch (final Exception e) {

			Logger.getLogger(this.getClass().getName()).info("ERROR: " + e.getMessage());

		}
	}

	public void mostrarMensagem(String msg, String titulo, Severity severity) {

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, titulo, msg));

	}

	public Boolean validarCaptha() {

		Boolean restult = Boolean.TRUE;
		
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

		String response = request.getParameter("g-recaptcha-response");

		ReCaptchaCheckerReponse rep = ReCaptchaChecker.checkReCaptcha(response);
		
		if(!rep.getSuccess()){
			
			restult = Boolean.FALSE;
			
			this.mostrarMensagem("Captha inválido!", "Erro", FacesMessage.SEVERITY_ERROR);
		}
		
		return restult;
	}

	public F getFormulario() {

		return formulario;
	}

	public S getService() {

		return service;
	}

	@SuppressWarnings("unchecked")
	protected Class<E> getTipoEntidade() {

		final Type type[] = ((ParameterizedTypeImpl) this.getClass().getGenericSuperclass()).getActualTypeArguments();

		return (Class<E>) type[0];
	}
}
