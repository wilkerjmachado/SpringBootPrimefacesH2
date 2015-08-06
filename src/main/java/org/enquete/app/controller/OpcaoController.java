package org.enquete.app.controller;

import org.enquete.app.dominio.Opcao;
import org.enquete.app.dominio.Pergunta;
import org.enquete.app.formulario.OpcaoFormulario;
import org.enquete.app.service.OpcaoService;
import org.enquete.framework.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OpcaoController extends GenericController<Opcao, OpcaoFormulario, OpcaoService> {

	@Autowired
	public OpcaoController(OpcaoFormulario formulario, OpcaoService service) {
		super(formulario, service);
	}
	
	public void salvar(Pergunta pergunta) {
		
		this.getFormulario().getEntidade().setPergunta(pergunta);
		
		super.salvar();
	}

}
