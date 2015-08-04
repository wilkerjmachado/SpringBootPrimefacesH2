package org.enquete.app.controller;

import javax.faces.application.FacesMessage;

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

	public void salvarResposta(){
		
		this.getFormulario().getResposta().setPergunta(this.getFormulario().getEntidade());
		
		this.respostaService.saveOrUpdate(this.getFormulario().getResposta());
		
		this.getFormulario().setEntidade(this.getService().findOne(this.getFormulario().getEntidade().getId()));
		
		this.getFormulario().setResposta(new Resposta());
		
		this.mostrarMensagem("Item excluído com sucesso!", "Sucesso", FacesMessage.SEVERITY_INFO);
	}
	
	public void visualizarRespostas(Pergunta pergunta){
		
		this.getFormulario().setEntidade(pergunta);
		
		this.getFormulario().setMostrarRespostas(Boolean.TRUE);
		
	}
	
	public void mostrarEnquetes(){
		
		this.iniciarCampos();
		
		this.getFormulario().setMostrarRespostas(Boolean.FALSE);
	}
	
	@Override
	protected void iniciarCampos() {

		this.getFormulario().setResposta(new Resposta());
		
		super.iniciarCampos();
	}

}
