package org.enquete.app.controller;

import org.enquete.app.dominio.Pergunta;
import org.enquete.app.formulario.PerguntaFormulario;
import org.enquete.app.service.PerguntaService;
import org.enquete.framework.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnqueteController extends GenericController<Pergunta> {

	@Autowired
	public EnqueteController(PerguntaService perguntaService, PerguntaFormulario formulario) {
		
		super(formulario, perguntaService);
		
	}

}
