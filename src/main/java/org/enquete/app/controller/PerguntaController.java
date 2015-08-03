package org.enquete.app.controller;

import org.enquete.app.formulario.PerguntaFormulario;
import org.enquete.app.service.PerguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PerguntaController {

	@Autowired
	private PerguntaService perguntaService;

	@Autowired
	private PerguntaFormulario formulario;

	public PerguntaFormulario getFormulario() {
		return formulario;
	}

}
