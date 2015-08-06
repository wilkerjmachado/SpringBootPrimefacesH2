package org.enquete.app.controller;

import org.enquete.app.dominio.Pergunta;
import org.enquete.app.dominio.Resposta;
import org.enquete.app.formulario.RespostaFormulario;
import org.enquete.app.service.RespostaService;
import org.enquete.framework.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class RespostaController extends GenericController<Resposta, RespostaFormulario, RespostaService>{

	@Autowired
	public RespostaController(RespostaFormulario formulario, RespostaService service) {
		super(formulario, service);
	}
	
	public void salvar(Pergunta pergunta) {
		
		this.getFormulario().getEntidade().setPergunta(pergunta);
		
		super.salvar();
	}

}
