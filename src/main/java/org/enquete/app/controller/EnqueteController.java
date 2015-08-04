package org.enquete.app.controller;

import javax.annotation.PostConstruct;

import org.enquete.app.dominio.Pergunta;
import org.enquete.app.formulario.PerguntaFormulario;
import org.enquete.app.service.PerguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnqueteController {

	@Autowired
	private PerguntaService perguntaService;

	@Autowired
	private PerguntaFormulario formulario;

	@PostConstruct
    public void init() {
		
		this.iniciarCampos();
    }

	public String salvar() {
		
		this.perguntaService.saveOrUpdate(this.getFormulario().getEntidade());
		
		this.iniciarCampos();
		
		return "pm:list?transition=flip";
	}

	private void iniciarCampos() {
		
		this.getFormulario().setEntidade(new Pergunta());
		
		this.getFormulario().setLista(this.perguntaService.getAll());
	}

	public String novaEntidade() {

		this.getFormulario().setEntidade(new Pergunta());

		return "pm:edit?transition=flip";
	}

	public PerguntaFormulario getFormulario() {
		
		return formulario;
	}
}
