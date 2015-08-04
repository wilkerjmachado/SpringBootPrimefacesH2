package org.enquete.app.controller;

import org.enquete.app.dominio.Pergunta;
import org.enquete.app.dominio.Resposta;
import org.enquete.app.formulario.PerguntaFormulario;
import org.enquete.app.service.PerguntaService;
import org.enquete.app.service.RespostaService;
import org.enquete.framework.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnqueteController extends GenericController<Pergunta, PerguntaFormulario, PerguntaService> {

	@Autowired
	private RespostaService respostaService;

	@Autowired
	public EnqueteController(PerguntaService perguntaService, PerguntaFormulario formulario) {

		super(formulario, perguntaService);

	}

	public void salvarResposta(Pergunta pergunta){
		
		this.getFormulario().getResposta().setPergunta(pergunta);
		
		this.respostaService.saveOrUpdate(this.getFormulario().getResposta());
		
		this.getFormulario().setEntidade(this.getService().findOne(this.getFormulario().getEntidade().getId()));;
		
		this.getFormulario().setResposta(new Resposta());
	}
	
	@Override
	protected void iniciarCampos() {

		this.getFormulario().setResposta(new Resposta());
		
		super.iniciarCampos();
	}

}
