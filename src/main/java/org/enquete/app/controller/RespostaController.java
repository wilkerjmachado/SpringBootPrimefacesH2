package org.enquete.app.controller;

import javax.faces.application.FacesMessage;

import org.enquete.app.dominio.Pergunta;
import org.enquete.app.dominio.Resposta;
import org.enquete.app.formulario.RespostaFormulario;
import org.enquete.app.service.RespostaService;
import org.enquete.framework.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Scope("request")
public class RespostaController extends GenericController<Resposta, RespostaFormulario, RespostaService> {

	@Autowired
	public RespostaController(RespostaFormulario formulario, RespostaService service) {
		super(formulario, service);
	}

	public void salvar(Pergunta pergunta) {

		if (!StringUtils.isEmpty(this.getFormulario().getEntidade().getTexto().toString())) {

			this.getFormulario().getEntidade().setPergunta(pergunta);

			super.salvar();

		} else {

			this.mostrarMensagem("Preecha dados obrigatórios!", "Alerta", FacesMessage.SEVERITY_INFO);
		}
	}

}
